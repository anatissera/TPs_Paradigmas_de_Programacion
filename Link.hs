module Link ( Link, newL, linksL, connectsL, capacityL, delayL )
   where

import City
import Quality

data Link = Lin City City Quality deriving (Eq, Show)

newL :: City -> City -> Quality -> Link -- genera un link entre dos ciudades distintas
newL cityName1 cityName2 quality = Lin cityName1 cityName2 quality
-- si ya hay un link, que diga error, que cree otro, que se quede con 2
-- muestro un escenario para mostrar mi elección.

connectsL :: City -> Link -> Bool   -- indica si esta ciudad es parte de este link
connectsL city (Lin city1 city2 quality) = city == city1 || city == city2

linksL :: City -> City -> Link -> Bool -- indica si estas dos ciudades distintas estan conectadas mediante este link
linksL city1 city2 (Lin linked1 linked2 quality) = 
   (city1 == linked1 && city2 == linked2) || (city2 == linked1 && city1 == linked2)

capacityL :: Link -> Int
capacityL (Lin cityName1 cityName2 quality) = capacityQ quality

delayL :: Link -> Float     -- la demora que sufre una conexion en este canal
delayL (Lin cityName1 cityName2 quality) = delayQ quality


-- atajar si por ejemplo quieren linkear dos ciudades iguales