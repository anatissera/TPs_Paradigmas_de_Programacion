module Tunel ( Tunel, newT, connectsT, usesT, delayT )
   where

import City
import Link

data Tunel = Tun [Link] deriving (Eq, Show)

newT :: [Link] -> Tunel
newT links = Tun links

connectsT :: City -> City -> Tunel -> Bool -- inidca si este tunel conecta estas dos ciudades distintas
connectsT city1 city2 (Tun links) = not(null [link|link <- links, linksL city1 city2 link])

usesT :: Link -> Tunel -> Bool  -- indica si este tunel atraviesa ese link
usesT linkToCheck (Tun links) = linkToCheck `elem` links

delayT :: Tunel -> Float -- la demora que sufre una conexion en este tunel
delayT (Tun links) = sum (map delayL links)