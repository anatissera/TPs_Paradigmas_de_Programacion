module Tunel ( Tunel, newT, connectsT, usesT, delayT )
   where

import City
import Link
import Data.List (find)

data Tunel = Tun [Link] deriving (Eq, Show)

newT :: [Link] -> Tunel
newT links = Tun links

-- connectsT :: City -> City -> Tunel -> Bool 
-- connectsT city1 city2 (Tun links) = not(null [link|link <- links, linksL city1 city2 link])               -- esta mal, no reconoce el camino de los links.... de esta forma, optimizar tunelR

connectsT :: City -> City -> Tunel -> Bool
connectsT city1 city2 (Tun links) =
    case find (\link -> connectsL city1 link || connectsL city2 link) links of
        Just _ -> True
        Nothing -> False

usesT :: Link -> Tunel -> Bool  -- indica si este tunel atraviesa ese link
usesT linkToCheck (Tun links) = linkToCheck `elem` links

delayT :: Tunel -> Float -- la demora que sufre una conexion en este tunel
delayT (Tun links) = sum (map delayL links)