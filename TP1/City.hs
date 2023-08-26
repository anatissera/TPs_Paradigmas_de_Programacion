module City ( City, newC, nameC, distanceC)
   where

import TP1\Point

data City = Cit String Point deriving (Eq, Show)

newC :: String -> Point -> City
newC cityName point = Cit cityName point

nameC :: City -> String
nameC (Cit cityName point) = cityName

distanceC :: City -> City -> Float
distanceC (Cit cityName1 point1) (Cit cityName2 point2) = difP point1 point2