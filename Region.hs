module Region ( Region, newR, foundR, linkR, tunelR, connectedR, linkedR, delayR, availableCapacityForR)
   where

import City 
import Quality 
import Tunel 
import Link
import Point
import Data.List (find)
import Data.Typeable

data Region = Reg [City] [Link] [Tunel] deriving Show

newR :: Region
newR = Reg [] [] []

foundR :: Region -> City -> Region -- agrega una nueva ciudad a la región
foundR (Reg cities links tunnels) newCity
    | not (isCityType newCity) = error "InvalidCityType: The second argument must be of type City"
    | not(any(\existingCity -> existingCity == newCity) cities) = error "CityAlreadyExists: A city with the same name already exists in the region."
    | otherwise = Reg (newCity : cities) links tunnels
  where
    isCityType :: City -> Bool
    isCityType city = case cast city of
        Just (_ :: City) -> True
        Nothing -> False


linkR :: Region -> City -> City -> Quality -> Region -- enlaza dos ciudades de la región con un enlace de la calidad indicada
linkR (Reg cities links tunels) city1 city2 quality
    | not(any(\existingCity -> existingCity == city1)cities) || not(any(\existingCity -> existingCity == city2)cities) = 
        error "At least one city is not in the region."
    | otherwise = Reg cities (newLink : links) tunels
  where
    newLink = newL city1 city2 quality

-- Si ya hay 

tunelR :: Region -> [City] -> Region -- genera una comunicación entre dos ciudades distintas de la región
tunelR region@(Reg cities links tunels) citiesToConnect
    | length citiesToConnect < 2 = 
        error "You can't create a tunnel with fewer than 2 cities."
    | not (all (`elem` cities) citiesToConnect) = 
        error "Some cities are not in the region."
    | not (all (hasExistingL links) linksToCheck) = 
        error "Missing link between cities."
    | not((availableCapacityForR region (head cities) (last cities)) > 0) = 
        error "Insufficient capacity in some links."
    | otherwise = Reg cities links (newTunnel : tunels)
  where
    linksToCheck = zip citiesToConnect (tail citiesToConnect)
    newTunnel = newT [getLink city1 city2 | (city1, city2) <- linksToCheck]
    
    getLink :: City -> City -> Link
    getLink c1 c2 = head [link | link <- links, connectsL c1 link && connectsL c2 link]

    hasExistingL :: [Link] -> (City, City) -> Bool
    hasExistingL links (c1, c2) = any (\link -> linksL c1 c2 link) links


connectedR :: Region -> City -> City -> Bool -- indica si estas dos ciudades estan conectadas por un tunel
connectedR (Reg cities links tunels) city1 city2 = any (\tunel -> connectsT city1 city2 tunel) tunels

linkedR :: Region -> City -> City -> Bool -- indica si estas dos ciudades estan enlazadas
linkedR (Reg cities links tunels) city1 city2 = any (\link -> linksL city1 city2 link) links

delayR :: Region -> City -> City -> Float -- dadas dos ciudades conectadas, indica la demora
delayR (Reg cities links tunels) city1 city2 =
    case find (\tunel -> connectsT city1 city2 tunel) tunels of
    Just tunnel -> delayT tunnel
    Nothing -> error "No tunnel connects the provided cities"

availableCapacityForR :: Region -> City -> City -> Int -- indica la capacidad disponible entre dos ciudades
availableCapacityForR (Reg _ links tunnels) city1 city2 =
    case find (\link -> linksL city1 city2 link) links of
        Just link -> capacityL link - usedCapacityForR tunnels link
        Nothing -> error "No link connects the provided cities"
  where
    usedCapacityForR :: [Tunel] -> Link -> Int
    usedCapacityForR tunnels link =
        sum [1 | tunel <- tunnels, usesT link tunel]
        

-- Describir los distintos esecenarios <- tiene que haber un archivo con esto, donde se manifiesten todas las decisiones tomadas
-- links repetidos -> ?
