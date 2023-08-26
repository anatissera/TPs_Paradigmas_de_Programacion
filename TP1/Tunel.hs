module Tunel ( Tunel, newT, connectsT, usesT, delayT )
   where

import City
import Link

data Tunel = Tun [Link] deriving (Eq, Show)

newT :: [Link] -> Tunel -- genera un link entre dos ciudades distintas
newT [] = error "The tunel can not be empty"
newT links = Tun links

connectsT :: City -> City -> Tunel -> Bool -- inidca si este tunel conecta estas dos ciudades distintas
connectsT city1 city2 (Tun links)
  | city1 == city2 = error "Cities cannot be connected to themselves."
  | length links == 2 = areHeadAndTail && not (linksL city1 city2 (head links) || linksL city1 city2 (last links)) 
  | otherwise = areHeadAndTail
  where
    areHeadAndTail = (connectsL city1 (head links) && connectsL city2 (last links)) || (connectsL city2 (head links) && connectsL city1 (last links))
-- Preguntar si la lista de links esta ordenada en base al recorrido del tunel

usesT :: Link -> Tunel -> Bool  -- indica si este tunel atraviesa ese link
usesT linkToCheck (Tun links) = linkToCheck `elem` links

delayT :: Tunel -> Float -- la demora que sufre una conexion en este tunel
delayT (Tun links) = sum (map delayL links)