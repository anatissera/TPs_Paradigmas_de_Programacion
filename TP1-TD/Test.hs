module Test 
    where
import Point 
import City 
import Quality 
import Link 
import Tunel
import Region 

import Control.Exception
import System.IO.Unsafe


exception :: IO a -> IO Bool
exception action = do
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
northWest = newP (-3) 13

southEast = newP 10 (-4)
southWest = newP 1 (-2)

east = newP  12 6
west = newP (-5) 7
center = newP 5 6

-- City
cam = newC "Cambridge" northEast
nHam = newC "Northampton" northWest
sHam = newC "Southampton" southWest
ebo = newC "Eastbourne" southEast
oxf = newC "Oxford" west
lon = newC "London"  east
lon1 = newC "London" center
sil = newC "Silverstone" northWest

-- Quality
high0 = newQ "High" 7 (-2) -- < 0
high = newQ "High" 7 2
mediumHigh = newQ "Medium-High" 5 3
medium = newQ "Medium" 4 4
mediumLow = newQ "Medium-Low" 3 5
low = newQ "Low" 1 6
low0 = newQ "Low" (-4) 6 -- < 0

-- Region
uk = newR
uk1 = foundR uk cam
uk2 = foundR uk1 nHam
uk3 = foundR uk2 sHam
uk4 = foundR uk3 lon
uk5 = foundR uk4 lon -- already in region
uk6 = foundR uk4 ebo
uk7 = foundR uk6 oxf
uk0 = foundR uk7 lon1 -- name already exists
uk02 = foundR uk7 sil -- location is used

uk8 = linkR uk4 nHam oxf medium -- not in region
uk9 = linkR uk7 oxf lon high
uk10 = linkR uk9 oxf nHam medium 
uk11 = linkR uk10 nHam cam mediumHigh 
uk12 = linkR uk11 cam nHam high -- already linked
uk13 = linkR uk11 cam ebo low 
uk14 = linkR uk13 ebo sHam mediumLow
uk15 = linkR uk14 cam lon mediumHigh
uk15_0 = linkR uk15 cam cam low -- same city



uk16 = tunelR uk15 [lon, oxf, ebo] -- not linked
uk17 = tunelR uk15 [lon, oxf, nHam, cam, ebo, sHam]
uk18 = tunelR uk17 [cam, ebo, sHam] -- insufficient quality
uk19 = tunelR uk17 [oxf, lon]
uk20 = tunelR uk19 [oxf, lon, cam]
uk21 = tunelR uk20 [lon] -- not enough cities
uk22 = tunelR uk20 [lon, sil] -- not in region
uk23 = tunelR uk20 [oxf, cam] -- already connected
uk24 = tunelR uk20 [oxf, nHam, cam, lon, oxf] -- head == last


region = [
         testF (exception (evaluate high0)),
         unsafePerformIO $ exception (evaluate low0),
         nameC lon1 == nameC lon,
         unsafePerformIO $ exception (evaluate uk0),
         distanceC sil nHam == 0,
         unsafePerformIO $ exception (evaluate uk02),
         unsafePerformIO $ exception (evaluate uk5), 
         unsafePerformIO $ exception (evaluate uk8), 
         linkedR uk11 nHam cam, 
         unsafePerformIO $ exception (evaluate uk12), 
         not(linkedR uk15 oxf ebo),
         unsafePerformIO $ exception (evaluate uk15_0),
         unsafePerformIO $ exception (evaluate uk16),
         availableCapacityForR uk17 cam ebo == 0,
         unsafePerformIO $ exception (evaluate uk18), 
         unsafePerformIO $ exception (evaluate uk21),
         unsafePerformIO $ exception (evaluate uk22),
         linkedR uk9 oxf lon,
         connectedR uk17 lon sHam,
         availableCapacityForR uk20 nHam cam == (capacityQ mediumHigh)-1 ,
         availableCapacityForR uk20 oxf lon == (capacityQ high)-3, 
         unsafePerformIO $ exception (evaluate (connectedR uk20 lon sil)),
         unsafePerformIO $ exception (evaluate (connectedR uk20 lon lon)),
         not(connectedR uk20 nHam ebo),
         unsafePerformIO $ exception (evaluate (delayR uk20 nHam ebo)),
         unsafePerformIO $ exception (evaluate (delayR uk20 lon sil)),
         unsafePerformIO $ exception (evaluate (availableCapacityForR uk20 nHam ebo)),
         unsafePerformIO $ exception (evaluate (availableCapacityForR uk20 lon sil)),
         delayR uk20 oxf cam == delayQ high * distanceC oxf lon + delayQ mediumHigh * distanceC lon cam,
         connectedR uk20 cam oxf,
         unsafePerformIO $ exception (evaluate uk23),
         unsafePerformIO $ exception (evaluate uk24),
         True]

notRegion = [
    linkedR uk15 oxf ebo,
    linkedR uk15 lon sil, 
    connectedR uk20 lon cam,
    connectedR uk17 cam sHam, 
    False]