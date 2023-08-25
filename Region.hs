module Region ( Region, newR, foundR, linkR, tunelR, connectedR, linkedR, delayR, availableCapacityForR)
   where

import City 
import Quality 
import Tunel 
import Link
import Point
import Data.List (find)

data Region = Reg [City] [Link] [Tunel] deriving (Eq, Show)

newR :: Region
newR = Reg [] [] []

foundR :: Region -> City -> Region -- agrega una nueva ciudad a la región
foundR (Reg cities links tunels) newCity
    | any(\existingCityName -> nameC existingCityName == nameC newCity) cities = 
        error "A city with the same name already exists in the region."
    | any(\existingLocation -> round(distanceC existingLocation newCity) == 0) cities = 
        error "A city has been already created on this location."
    | otherwise = Reg (newCity:cities) links tunels

linkR :: Region -> City -> City -> Quality -> Region -- enlaza dos ciudades de la región con un enlace de la calidad indicada
linkR (Reg cities links tunels) city1 city2 quality
    | not(city1 `elem` cities && city2 `elem` cities) = 
        error "At least one city is not in the region."
    | any(\link -> linksL city1 city2 link) links = 
        error "Cities are already linked"
    | otherwise = Reg cities (newLink : links) tunels
  where
    newLink = newL city1 city2 quality

tunelR :: Region -> [City] -> Region -- genera una comunicación entre dos ciudades distintas de la región
tunelR region@(Reg cities links tunels) citiesToConnect
    | length citiesToConnect < 2 = 
        error "You can't create a tunel with fewer than 2 cities."
    | not (all (`elem` cities) citiesToConnect) = 
        error "Some cities are not in the region."
    | any(\tunel -> connectsT (head citiesToConnect) (last citiesToConnect) tunel) tunels =
        error "The provides cities are already connected"
    | not (all (hasExistingL links) linksToCheck) =
        error "Missing link between cities."
    | any (\(city1, city2) -> availableCapacityForR region city1 city2 < 1) linksToCheck = 
        error "Insufficient capacity in some links."       
    | otherwise = Reg cities links (newTunel : tunels)                 
  where
    linksToCheck = zip citiesToConnect (tail citiesToConnect)

    hasExistingL :: [Link] -> (City, City) -> Bool
    hasExistingL links (c1, c2) = any (\link -> linksL c1 c2 link) links

    newTunel = newT [getLink city1 city2 | (city1, city2) <- linksToCheck]

    getLink :: City -> City -> Link
    getLink c1 c2 = head [link | link <- links, connectsL c1 link && connectsL c2 link]
-- pueden pasar por el mismo lugar?

connectedR :: Region -> City -> City -> Bool -- indica si estas dos ciudades estan conectadas por un tunel
connectedR (Reg cities _ tunels) city1 city2
 | null tunels = False
 | not(city1 `elem` cities && city2 `elem` cities) = error "At least one city is not in the region."
 | otherwise = any (\tunel -> connectsT city1 city2 tunel) tunels 

linkedR :: Region -> City -> City -> Bool -- indica si estas dos ciudades estan enlazadas
linkedR (Reg _ links _) city1 city2 = any (\link -> linksL city1 city2 link) links

delayR :: Region -> City -> City -> Float -- dadas dos ciudades conectadas, indica la demora
delayR (Reg _ _ tunels) city1 city2 =
    case find (\tunel -> connectsT city1 city2 tunel) tunels of
        Just tunel -> delayT tunel
        Nothing -> error "No tunel connects the provided cities"

availableCapacityForR :: Region -> City -> City -> Int -- indica la capacidad disponible entre dos ciudades
availableCapacityForR (Reg _ links tunels) city1 city2 =
    case find (\link -> linksL city1 city2 link) links of
        Just link -> capacityL link - usedCapacityForR tunels link
        Nothing -> error "No link connects the provided cities"
  where
    usedCapacityForR :: [Tunel] -> Link -> Int
    usedCapacityForR tunels link =
        sum [1 | tunel <- tunels, usesT link tunel]