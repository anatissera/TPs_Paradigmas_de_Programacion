module Link ( Link, newL, linksL, connectsL, capacityL, delayL)
   where

import City
import Quality

data Link = Lin City City Quality deriving (Eq, Show)

newL :: City -> City -> Quality -> Link  -- genera un link entre dos ciudades distintas
newL city1 city2 quality
 | city1 == city2 = error "Is not posibble to link the same city"
 | otherwise= Lin city1 city2 quality

connectsL :: City -> Link -> Bool   -- indica si esta ciudad es parte de este link
connectsL cityToCheck (Lin city1 city2 quality) = cityToCheck == city1 || cityToCheck == city2

linksL :: City -> City -> Link -> Bool -- indica si estas dos ciudades distintas están conectadas mediante este link
linksL city1 city2 (Lin linkedcity1 linkedcity2 quality) = 
   (city1 == linkedcity1 && city2 == linkedcity2) || (city2 == linkedcity1 && city1 == linkedcity2)

capacityL :: Link -> Int
capacityL (Lin cityName1 cityName2 quality) = capacityQ quality

delayL :: Link -> Float -- la demora que sufre una conexión en este canal
delayL (Lin city1 city2 quality) = (delayQ quality)*(distanceC city1 city2)