module Region ( Region, newR, foundR, linkR, tunelR, pathR, linksForR, connectedR, linkedR, delayR, availableCapacityForR, usedCapacityForR )
   where

import City
import Quality
import Tunel
import Link

data Region = Reg [City] [Link] [Tunel]

newR :: Region
newR = Reg
foundR :: Region -> City -> Region -- agrega una nueva ciudad a la región
foundR (Reg cities links tunels) city = Reg (city : cities) links tunels

linkR :: Region -> City -> City -> Quality -> Region -- enlaza dos ciudades de la región con un enlace de la calidad indicada
linkR (Reg cities links tunels) city1 city2 quality = Reg cities (newL city1 city2 quality : links) tunels

tunelR :: Region -> [ City ] -> Region -- genera una comunicación entre dos ciudades distintas de la región
tunelR (Reg cities links tunels) [city1, city2] = Reg cities links (newT : ...)
-- que links quiere comunicar????
-- atajar si se quiere hacer un tunel con dos ciudades no linkeadas
-- atajar si es que el len de la lista de ciudades es distinto de dos Y PREGUNTAR

connectedR :: Region -> City -> City -> Bool -- indica si estas dos ciudades estan conectadas por un tunel
connectedR (Reg cities links tunels) city1 city2 = not(null([tunel | tunel <- tunels, connectsT city1 city2 tunel]))

linkedR :: Region -> City -> City -> Bool -- indica si estas dos ciudades estan enlazadas
linkedR (Reg cities links tunels) city1 city2 = not(null([link | link <- links, connectsL city1 city2 link]))

delayR :: Region -> City -> City -> Float -- dadas dos ciudades conectadas, indica la demora
delayR region city1 city2 = if connectedR region city1 city2 then delayL 
-- PREGUNTAR

availableCapacityForR :: Region -> City -> City -> Int -- indica la capacidad disponible entre dos ciudades
availableCapacityForR (Reg cities links tunels) city1 city2 =


