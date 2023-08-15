module Region ( Region, newR, foundR, linkR, tunelR, pathR, linksForR, connectedR, linkedR, delayR, availableCapacityForR, usedCapacityForR )
   where

import City
import Quality
import Tunel
import Link

data Region = Reg [City] [Link] [Tunel]

newR :: Region
newR = Region

foundR :: Region -> City -> Region -- agrega una nueva ciudad a la región
foundR (Reg cities links tunels) city = Reg (city : cities) links tunels

linkR :: Region -> City -> City -> Quality -> Region -- enlaza dos ciudades de la región con un enlace de la calidad indicada
linkR (Reg cities links tunels) city1 city2 quality = Reg cities (newL city1 city2 quality : links) tunels
-- hay que chequear que estén en la región, única condición?

tunelR :: Region -> [ City ] -> Region -- genera una comunicación entre dos ciudades distintas de la región
tunelR (Reg cities links tunels) [city1, city2] = Reg cities links (newT : ...)
-- 
-- tiene que haber un link preexistente entre las ciudades inicio y fin
-- atajar si se quiere hacer un tunel con dos ciudades no linkeadas
-- ciudades que no existen error
-- capacidad no existe error

connectedR :: Region -> City -> City -> Bool -- indica si estas dos ciudades estan conectadas por un tunel
connectedR (Reg cities links tunels) city1 city2 = not(null([tunel | tunel <- tunels, connectsT city1 city2 tunel]))
-- dos ciudades están conectadas únicamente si son inicio y fin.

linkedR :: Region -> City -> City -> Bool -- indica si estas dos ciudades estan enlazadas
linkedR (Reg cities links tunels) city1 city2 = not(null([link | link <- links, connectsL city1 city2 link]))
-- enlace directo

delayR :: Region -> City -> City -> Float -- dadas dos ciudades conectadas, indica la demora
delayR region city1 city2 = if connectedR region city1 city2 then delayL 
-- suma del delay de todos los enlaces
-- si no están conectadas, error
-- describir un escenario demostrando la elección que tomamos (error)

availableCapacityForR :: Region -> City -> City -> Int -- indica la capacidad disponible entre dos ciudades
availableCapacityForR (Reg cities links tunels) city1 city2 =
-- más baja de los links

-- el link es virtual, la conectividad es física
-- el tunel da el camino entre las ciudades
-- calidad y capacidad -> la capacidad se va reduciendo con el aumento de los links
-- Si hay un tunel ABCD, Solo A y D estan conectadas
-- Describir los distintos esecenarios <- creo que tiene que haber un archivo con esto, donde se manifiesten todas las decisiones tomadas
-- links repetidos -> ?
-- cuentan los links directos