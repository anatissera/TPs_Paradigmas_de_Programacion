module Quality ( Quality, newQ, capacityQ, delayQ )
   where

data Quality = Qua String Int Float deriving (Eq, Show)

newQ :: String -> Int -> Float -> Quality
newQ newQua capacity delay
   | capacity < 0 = error "Capacity can not be negative"
   | delay < 0 = error "Delay can not be negative"
   | otherwise = Qua newQua capacity delay

capacityQ :: Quality -> Int   -- cuantos túneles puede tolerar esta conexión
capacityQ (Qua newQua capacity delay) = capacity

delayQ :: Quality -> Float -- la demora por unidad de distancia que sucede en las conexiones de este canal
delayQ (Qua newQua capacity delay) = delay