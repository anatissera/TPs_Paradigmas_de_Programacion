module Link ( Link, newL, linksL, connectsL, capacityL, delayL )
   where

import City
import Quality

data Link = Lin City City Quality deriving (Eq, Show)

newL :: City -> City -> Quality -> Link -- genera un link entre dos ciudades distintas
newL cityName1 cityName2 quality = Lin cityName1 cityName2 quality
-- si ya hay un link, que diga error
-- error "Link already exists between these cities."


-- existingLinks :: [Link]
-- existingLinks = []

-- newL :: City -> City -> Quality -> Link
-- newL city1 city2 quality
--     | linkExists city1 city2 = error "Link already exists between these cities."
--     | otherwise = Lin city1 city2 quality
--   where
--     linkExists c1 c2 = any (\(Lin linked1 linked2 _) ->
--         (c1 == linked1 && c2 == linked2) || (c1 == linked2 && c2 == linked1)) existingLinks

connectsL :: City -> Link -> Bool   -- indica si esta ciudad es parte de este link
connectsL city (Lin city1 city2 quality) = city == city1 || city == city2

linksL :: City -> City -> Link -> Bool -- indica si estas dos ciudades distintas estan conectadas mediante este link
linksL city1 city2 (Lin linked1 linked2 quality) = 
   (city1 == linked1 && city2 == linked2) || (city2 == linked1 && city1 == linked2)

capacityL :: Link -> Int
capacityL (Lin cityName1 cityName2 quality) = capacityQ quality

delayL :: Link -> Float     -- la demora que sufre una conexion en este canal
delayL (Lin cityName1 cityName2 quality) = delayQ quality
-- delay por unidad de distancia 

-- atajar si por ejemplo quieren linkear dos ciudades iguales