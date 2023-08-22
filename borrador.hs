module Region ( Region, tunelRA)
   where

import City 
import Quality 
import Tunel 
import Link
import Point
import Data.Typeable

data Region = Reg [City] [Link] [Tunel] deriving Show


tunelRA :: Region -> [City] -> Region
tunelRA (Reg cities links tunels) citiesToConnect
    | length citiesToConnect < 2 = error "You can't create a tunnel with fewer than 2 cities."
    | not (all (`elem` cities) citiesToConnect) = error "Some cities are not in the region."
    | not (all (hasExistingL links) linksToCheck) = error "Missing link between cities."
    | not (all (hasSufficientQ links) linksToCheck) = error "Insufficient capacity in some links."
    | otherwise = Reg cities links (newTunnel : tunels)
  where
    linksToCheck = zip citiesToConnect (tail citiesToConnect)
    newTunnel = newT [getLink city1 city2 | (city1, city2) <- linksToCheck]
    
    getLink :: City -> City -> Link
    getLink c1 c2 = head [link | link <- links, connectsL c1 link && connectsL c2 link]

    hasExistingL :: [Link] -> (City, City) -> Bool
    hasExistingL links (c1, c2) = any (\link -> linksL c1 c2 link) links

    hasSufficientQ :: [Link] -> (City, City) -> Bool
    hasSufficientQ links (c1, c2) = any (\link -> capacityL link > 0) [getLink c1 c2 | link <- links]




