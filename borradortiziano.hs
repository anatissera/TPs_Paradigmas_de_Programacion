import City 
import Quality 
import Tunel 
import Link
import Point
import Data.Typeable
data Region = Reg [City] [Link] [Tunel] deriving Show

foundR :: Region -> City -> Region
foundR (Reg cities links tunnels) newCity
    | not (isCityType newCity) = error "InvalidCityType: The second argument must be of type City"
    | any (\existingCity -> existingCity == newCity) cities = error "CityAlreadyExists: A city with the same name already exists in the region."
    | otherwise = Reg (newCity : cities) links tunnels
-- NOS PUEDE SERVIR PARA CHEQUEAR LOS TIPOS DE DATOS??? (STR, INT, FLOAT, ETC)
  where
    isCityType :: City -> Bool
    isCityType city = case cast city of
        Just (_ :: City) -> True
        Nothing -> False