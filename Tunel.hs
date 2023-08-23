module Tunel ( Tunel, newT, connectsT, usesT, delayT )
   where

import City
import Link
import Data.List (find)

data Tunel = Tun [Link] deriving (Eq, Show)

newT :: [Link] -> Tunel -- genera un link entre dos ciudades distintas
newT links = Tun links

            -- esta mal, no reconoce el camino de los links.... de esta forma, optimizar tunelR

connectsT :: City -> City -> Tunel -> Bool -- inidca si este tunel conecta estas dos ciudades distintas
connectsT city1 city2 (Tun links) =
    any (connectedByTunnel city1 city2) links
  where
    connectedByTunnel :: City -> City -> Link -> Bool
    connectedByTunnel c1 c2 link =
        (connectsL c1 link && connectsL c2 link) ||
        (connectsL c2 link && connectsL c1 link)
-- MAL porque no necesariamente tienen que estar linkeadas
-- Tunel tiene como argumento una lista de links, cómo accedo a las ciudades?
-- IDEA, si city1 está en el link1 de Tunel y ... o viceversa.

usesT :: Link -> Tunel -> Bool  -- indica si este tunel atraviesa ese link
usesT linkToCheck (Tun links) = linkToCheck `elem` links

delayT :: Tunel -> Float -- la demora que sufre una conexion en este tunel
delayT (Tun links) = sum (map delayL links)


-- emilio
-- eslaPrimera c [] = False 
-- eslaPrimera c a:[] = connectsL a c 
-- eslaPrimera c a:b:ls = -- && not(connectsL a c)

