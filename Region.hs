module Region ( Region, newR, foundR, linkR, tunelR, connectedR, linkedR, tunelRA, delayR, availableCapacityForR)
   where

--pathR, linksForR, (((delayR, availableCapacityForR,))) usedCapacityForR
import City 
import Quality 
import Tunel 
import Link
import Point
import Data.Typeable

data Region = Reg [City] [Link] [Tunel] deriving Show

newR :: Region
newR = Reg [] [] []

foundR :: Region -> City -> Region
foundR (Reg cities links tunnels) newCity
    | not (isCityType newCity) = error "InvalidCityType: The second argument must be of type City"
    | not(any(\existingCity -> existingCity == newCity) cities) = error "CityAlreadyExists: A city with the same name already exists in the region."
    | otherwise = Reg (newCity : cities) links tunnels
  where
    isCityType :: City -> Bool
    isCityType city = case cast city of
        Just (_ :: City) -> True
        Nothing -> False

-- las ciudades que se pasan tienen que ser data City

linkR :: Region -> City -> City -> Quality -> Region
linkR (Reg cities links tunels) city1 city2 quality
    | not(any(\existingCity -> existingCity == city1)cities) || not(any(\existingCity -> existingCity == city2)cities) = error "UnavailableCity: At least one city is not in the region."
    | otherwise = Reg cities (newLink : links) tunels
  where
    newLink = newL city1 city2 quality

-- hay que chequear que estén en la región
-- Si ya hay 

-- tunelR

tunelRA :: Region -> [City] -> Region
tunelRA (Reg cities links tunnels) citiesToConnect
    | length [city | city <- citiesToConnect, city `elem` cities] /= length citiesToConnect =
        error "the cities are not in the region"
    | length citiesToConnect < 2 =
        error "need at least 2 cities to create a tunnel"
    | not (linkedCheck links citiesToConnect) =
        error "cities are not linked"
    | otherwise =
        Reg cities links ((newT (verifiedLinks links citiesToConnect)):tunnels)
  where

    linkedCheck links (c1:c2:rest)
        | any (\link -> linksL c1 c2 link) links = linkedCheck links (c2:rest)
        | otherwise = False
    linkedCheck _ _ = True

    verifiedLinks links (c1:c2:rest) = filter (\link -> linksL c1 c2 link) links  ++ verifiedLinks links (c2:rest)
    verifiedLinks _ _ = []


tunelR :: Region -> [City] -> Region
tunelR region@(Reg cities links tunels) citiesToConnect
    | length citiesToConnect < 2 = error "You can't create a tunnel with fewer than 2 cities."
    | not (all (`elem` cities) citiesToConnect) = error "Some cities are not in the region."
    | not (all (hasExistingL links) linksToCheck) = error "Missing link between cities."
    | not((availableCapacityForR region (head cities) (last cities)) > 0) = error "Insufficient capacity in some links."
    | otherwise = Reg cities links (newTunnel : tunels)
  where
    linksToCheck = zip citiesToConnect (tail citiesToConnect)
    newTunnel = newT [getLink city1 city2 | (city1, city2) <- linksToCheck]
    
    getLink :: City -> City -> Link
    getLink c1 c2 = head [link | link <- links, connectsL c1 link && connectsL c2 link]

    hasExistingL :: [Link] -> (City, City) -> Bool
    hasExistingL links (c1, c2) = any (\link -> linksL c1 c2 link) links

    
-- tunelRA 2
tunelRB :: Region -> [City] -> Region
tunelRB (Reg cities links tunnels) citiesToConnect
    | length citiesToConnect < 2 = 
        error "You can't create a tunnel with fewer than 2 cities."
    | not (all (`elem` cities) citiesToConnect) = 
        error "Some cities are not in the region."
    | not (linkedCheck links citiesToConnect) =
        error "Missing link between cities."
    | otherwise =
        let updatedLinks = updateLinkCapacities links citiesToConnect
        in Reg cities updatedLinks (newT updatedLinks : tunnels)
  where
    linkedCheck links (c1:c2:rest) =
        any (\link -> linksL c1 c2 link) links && linkedCheck links (c2:rest)
    linkedCheck _ _ = True

    -- updateLinkCapacities :: [Link] -> [City] -> [Link]
    -- updateLinkCapacities [] _ = []
    -- updateLinkCapacities (link:restLinks) citiesToConnect =
    --     let (city1, city2, quality) = getLinkInfo link
    --     in if (city1, city2) `elem` linksToCheck
    --         then decreaseLQ link : updateLinkCapacities restLinks citiesToConnect
    --         else link : updateLinkCapacities restLinks citiesToConnect
    
    getLinkInfo :: Link -> (City, City, Quality)
    getLinkInfo (Lin city1 city2 quality) = (city1, city2, quality)

    -- decreaseLQ :: Link -> Link
    -- decreaseLQ (Lin city1 city2 quality) =
    --     Lin city1 city2 (decreaseQ quality)
    
    linksToCheck = [(city1, city2) | (city1, city2, _) <- map getLinkInfo links]



-- los data link tienen una capacidad entre A y B, otra entre B y C. Para hacer un túnel se necesita que la capacidad de todos los links sea suficiente.


connectedR :: Region -> City -> City -> Bool -- indica si estas dos ciudades estan conectadas por un tunel
connectedR (Reg cities links tunels) city1 city2 = any (\tunel -> connectsT city1 city2 tunel) tunels

linkedR :: Region -> City -> City -> Bool -- indica si estas dos ciudades estan enlazadas
linkedR (Reg cities links tunels) city1 city2 = any (\link -> linksL city1 city2 link) links

delayR :: Region -> City -> City -> Float -- dadas dos ciudades conectadas, indica la demora
delayR (Reg cities links tunels) city1 city2 =
    case find (\tunel -> connectsT city1 city2 tunel) tunnels of
    Just tunnel -> delayT tunnel
    Nothing -> error "NoMatchingTunnel: No tunnel connects the provided cities"

availableCapacityForR :: Region -> City -> City -> Int -- indica la capacidad disponible entre dos ciudades
availableCapacityForR (Reg cities links tunels) city1 city2 = 
    case find (\link -> linksL city1 city2 link) links of
    Just link -> CapacityL link -- -usesT link tunnel (recursivo)
    Nothing -> error "NoMatchingLink: No link connects the provided cities"

    -- hasSufficientQ :: [Link] -> (City, City) -> Bool
    -- hasSufficientQ links (c1, c2) = any (\link -> capacityL link > 0) [getLink c1 c2 | link <- links]

-- ARREGLAR
-- Si hay tunel, se reduce la capacidad

-- Describir los distintos esecenarios <- creo que tiene que haber un archivo con esto, donde se manifiesten todas las decisiones tomadas
-- links repetidos -> ?


-- emilio
eslaPrimera c [] = False 
eslaPrimera c a:[] = connectsL a c 
eslaPrimera c a:b:ls = -- && not(connectsL a c)

