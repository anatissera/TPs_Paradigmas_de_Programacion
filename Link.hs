

module Link ( Link, newL, linksL, connectsL, capacityL, delayL)
   where

import City
import Quality (Quality, capacityQ, delayQ)

data Link = Lin City City Quality deriving (Eq, Show)

-- existingLinks :: [Link]
-- existingLinks = []

newL :: City -> City -> Quality -> Link -- genera un link entre dos ciudades distintas
newL city1 city2 quality
 | city1 == city2 = error "Is not posibble to link the same city"
 | otherwise= Lin city1 city2 quality
--     | linkExists city1 city2 = error "Link already exists between these cities."
--     | otherwise = Lin city1 city2 quality
--   where
--     linkExists :: City -> City -> Bool
--     linkExists c1 c2 = any (\(Lin linked1 linked2 _) ->
--         (c1 == linked1 && c2 == linked2) || (c1 == linked2 && c2 == linked1)) existingLinks

connectsL :: City -> Link -> Bool   -- indica si esta ciudad es parte de este link
connectsL city (Lin city1 city2 quality) = city == city1 || city == city2

linksL :: City -> City -> Link -> Bool -- indica si estas dos ciudades distintas estan conectadas mediante este link
linksL city1 city2 (Lin linkedcity1 linkedcity2 quality) = 
   (city1 == linkedcity1 && city2 == linkedcity2) || (city2 == linkedcity1 && city1 == linkedcity2)

capacityL :: Link -> Int
capacityL (Lin cityName1 cityName2 quality) = capacityQ quality

delayL :: Link -> Float     -- la demora que sufre una conexion en este canal
delayL (Lin city1 city2 quality) = (delayQ quality) * (distanceC city1 city2)

-- atajar si por ejemplo quieren linkear dos ciudades iguales