import Point 
import City 
import Quality 
import Link 
import Tunel
import Region 

import Control.Exception
import System.IO.Unsafe

fallo :: IO a -> IO Bool
fallo action = do
    result <- tryJust isException action
    return $ case result of
        Left _ -> True
        Right _ -> False
    where
        isException :: SomeException -> Maybe ()
        isException _ = Just ()

testF :: IO Bool -> Bool
testF action = unsafePerformIO action


-- Point
northEast = newP 9 12
northWest = newP 2 13

southEast = newP 10 1
southWest = newP 3 2

east = newP  12 6
west = newP 1 7


-- City
cam = newC "Cambridge" northEast
nHam = newC "Northampton" northWest
sHam = newC "Southampton" southWest
ebo = newC "Eastbourne" southEast
oxf = newC "Oxford" west
lon = newC "London"  east

-- Quality
high = newQ "High" 7 2
mediumHigh = newQ "Medium-High" 5 3
medium = newQ "Medium" 4 4
mediumLow = newQ "Medium-Low" 3 5
low = newQ "Low" 1 6

-- Region
uk = newR
uk1 = foundR uk cam
uk2 = foundR uk1 nHam
uk3 = foundR uk2 sHam
uk4 = foundR uk3 lon
uk5 = foundR uk4 lon 
uk6 = foundR uk5 ebo
uk7 = foundR uk6 oxf

uk8 = linkR uk4 nHam oxf medium -- va a dar error
uk9 = linkR uk7 oxf lon high
uk10 = linkR uk9 oxf nHam medium 
uk11 = linkR uk10 nHam cam mediumHigh 
uk12 = linkR uk11 cam ebo low 
uk13 = linkR uk12 ebo sHam mediumLow


uk14 = tunelR uk13 [lon, oxf, ebo] -- va a dar error porque no están linkeadas
uk15 = tunelR uk14 [lon, oxf, nHam, cam, ebo, sHam]
uk16 = tunelR uk15 [cam, ebo, sHam] -- va a dar error por quality
uk17 = tunelR uk15 [oxf, lon]
uk18 = tunelR uk17 [oxf, lon, cam]


region = [uk4 == uk5, 
          uk8, 
          uk14, 
          uk16, 

        ]


-- t = [ pop ( Stack Vacio 2) == Vacio,
--       push Vacio 3 == Stack Vacio 3,
--       top (push Vacio 3) == 3,
--       stickWith [ 2, 3 ] == Stack (Stack Vacio 3) 2,
--       True ]


-- Link

-- Tunel 
-- crear un tunel vacío (newT)
-- preguntarse si dos ciudades iguales estan conectadas por un tunel (connectsT)
-- atajar el error en caso que un tunel contenga 3 ciudades (connectsT)

-- Region
-- foundR
-- añadir ciudad con el mismo nombre == error
-- añadir ciudad con el mismo point == error
-- linkR
-- linkear ciudades que no están en la región
-- linkear ciudades que ya están linkeadas
-- tunelR
-- lista de cities vacía o con un argumento
-- lista de cities donde alguna no esté en la región 
-- no están linkeadas las ciudades
--
-- capacidad insuficiente
-- connectedR
-- ciudades no en la región 
-- linkedR
-- delayR 
-- ciudades no conectadas
-- si las ciudades no están en la región también va a tirar error de que no están conectadas
-- availableCapacityForR
-- ciudades no linkeadas (idem delayR)
