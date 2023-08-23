module Tunel ( Tunel, newT, connectsT, usesT, delayT )
   where

import City
import Link
import Data.List (find)

data Tunel = Tun [Link] deriving (Eq, Show)

newT :: [Link] -> Tunel -- genera un link entre dos ciudades distintas
newT links = Tun links

connectsT :: City -> City -> Tunel -> Bool -- inidca si este tunel conecta estas dos ciudades distintas
connectsT city1 city2 (Tun links) =
  connectsL city1 (head links) && connectsL city2 (last links) || connectsL city2 (head links) && connectsL city1 (last links)
-- dando por sentado que la lista de links del tunel está en el orden de conexión

usesT :: Link -> Tunel -> Bool  -- indica si este tunel atraviesa ese link
usesT linkToCheck (Tun links) = linkToCheck `elem` links

delayT :: Tunel -> Float -- la demora que sufre una conexion en este tunel
delayT (Tun links) = sum (map delayL links)