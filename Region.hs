module Region ( Region, newR, foundR, linkR, tunelR, pathR, linksForR, connectedR, linkedR, delayR, availableCapacityForR, usedCapacityForR )
   where

import City ( City, newC, nameC, distanceC )
import Quality ( Quality, newQ, capacityQ, delayQ )
import Tunel 
import Link
import Point

data Region = Reg [City] [Link] [Tunel]

newR :: Region
newR = Reg [] [] []

foundR :: Region -> City -> Region
foundR (Reg cities links tunels) newCity
    | not (isCity newCity) = error "InvalidCityType: The second argument must be of type City."
    | cityName `elem` existingCityNames = error "CityAlreadyExists: A city with the same name already exists in the region."
    | otherwise = Reg (newCity : cities) links tunels
  where
    isCity (Cit _ _) = True
    isCity _ = False

    cityName = nameC newCity
    existingCityNames = map (\(Cit name _ ) -> name) cities

linkR :: Region -> City -> City -> Quality -> Region -- enlaza dos ciudades de la región con un enlace de la calidad indicada
linkR (Reg cities links tunels) city1 city2 quality = Reg cities (newL city1 city2 quality : links) tunels
-- hay que chequear que estén en la región
-- Si ya hay 

-- tunelR A

tunelRA :: Region -> [City] -> Region
tunelR (Reg cities links tunels) citiesToConnect
    | length citiesToConnect < 2 = error "You can't create a tunnel with fewer than 2 cities."
    | not (all (`elem` cities) citiesToConnect) = error "Some cities are not in the region."
    | not (all (hasExistingLink city1 city2) citiesToConnect) = error "Missing link between cities."
    | not (all (hasSufficientCapacity city1 city2) linksToCheck) = error "Insufficient capacity in some links."
    | otherwise = Reg cities (updateLinkCapacity links citiesToConnect) (newTunnel : tunels)
  where
    linksToCheck = zip citiesToConnect (tail citiesToConnect)
    newTunnel = newT [getLink city1 city2 | (city1, city2) <- linksToCheck]

    getLink :: City -> City -> Link
    getLink c1 c2 = head [link | link <- links, connectsL c1 link && connectsL c2 link]

    hasSufficientCapacity :: City -> City -> Bool
    hasSufficientCapacity c1 c2 = capacityL (getLink c1 c2) > 0

    hasExistingLink :: City -> City -> Bool
    hasExistingLink c1 c2 = any (\(Lin city1 city2 _) -> (c1 == city1 && c2 == city2) || (c1 == city2 && c2 == city1)) links

    updateLinkCapacity :: [Link] -> [City] -> [Link]
    updateLinkCapacity [] _ = []
    updateLinkCapacity (link@(Lin city1 city2 quality):restLinks) (c1:c2:restCities) =
       Lin city1 city2 (decreaseCapacity quality) : updateLinkCapacity restLinks restCities
    updateLinkCapacity links _ = links

    decreaseCapacity :: Quality -> Quality
    decreaseCapacity (Qua newQua capacity delay) = Qua newQua (capacity - 1) delay
    
-- tunelR B 

tunelRB :: Region -> [City] -> Region
tunelRB (Reg cities links tunnels) citiesToConnect
    | length [city | city <- citiesToConnect, city `elem` cities] /= length citiesToConnect =
        error "the cities are not in the region"
    | length citiesToConnect < 2 =
        error "need at least 2 cities to create a tunnel"
    | not (linkedCheck links citiesToConnect) =
        error "cities are not linked"
    | otherwise =
        Reg cities links (newT (verifiedLinks links citiesToConnect)) 
  where
    linkedCheck links (c1:c2:rest)
        | any (\link -> linksL c1 c2 link) links = linkedCheck (c2:rest) links
        | otherwise = False
    linkedCheck _ = True
    verifiedLinks links (c1:c2:rest) = filter (\link -> linksL c1 c2 link) links  ++ verifiedLinks links (c2:rest)
    verifiedLinks _ _ = []


-- tiene que haber un link preexistente entre las ciudades del camino. Es decir, si se pasa region [A, B, C], tiene que haber un túnel de A a B y de B a C.
-- las ciudades que se pasan tienen que ser data City
-- los data link tienen una capacidad entre A y B, otra entre B y C. Para hacer un túnel se necesita que la capacidad de todos los links sea suficiente. Además, una vez creado el tunel, la capacidad se reduce en 1 en todos los links del túnel


connectedR :: Region -> City -> City -> Bool -- indica si estas dos ciudades estan conectadas por un tunel
connectedR (Reg cities links tunels) city1 city2 = not(null([tunel | tunel <- tunels, connectsT city1 city2 tunel]))
-- dos ciudades están conectadas únicamente si son inicio y fin. Alternativa con fold

linkedR :: Region -> City -> City -> Bool -- indica si estas dos ciudades estan enlazadas
linkedR (Reg cities links tunels) city1 city2 = not(null([link | link <- links, connectsL city1 city2 link]))
-- enlace directo

-- delayR :: Region -> City -> City -> Float -- dadas dos ciudades conectadas, indica la demora
-- delayR region city1 city2 = if connectedR region city1 city2 then delayL else

-- suma del delay de todos los enlaces del túnel por la unidad de distancia 
-- si no están conectadas, error
-- describir un escenario demostrando la elección que tomamos (error)

--availableCapacityForR :: Region -> City -> City -> Int -- indica la capacidad disponible entre dos ciudades
--availableCapacityForR (Reg cities links tunels) city1 city2 =
-- tiene que haber enlace, es entre dos conectadas
-- es la cantntidad de tuneles disponibles¿

-- el link es virtual, la conectividad es física
-- el tunel da el camino entre las ciudades
-- calidad y capacidad -> la capacidad se va reduciendo con el aumento de los tuneles
-- Si hay un tunel ABCD, Solo A y D estan conectadas
-- Describir los distintos esecenarios <- creo que tiene que haber un archivo con esto, donde se manifiesten todas las decisiones tomadas
-- links repetidos -> ?
-- cuentan los links directos
-- hay que chequear únicamente en la regiones