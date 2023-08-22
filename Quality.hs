module Quality ( Quality, newQ, capacityQ, delayQ, decreaseQ )
   where

data Quality = Qua String Int Float deriving (Eq, Show)

newQ :: String -> Int -> Float -> Quality
newQ newQua capacity delay = Qua newQua capacity delay

capacityQ :: Quality -> Int -- cuantos túneles puede tolerar esta conexión
capacityQ (Qua newQua capacity delay) = capacity

delayQ :: Quality -> Float  -- la demora por unidad de distancia que sucede en las conexiones de este canal
delayQ (Qua newQua capacity delay) = delay
-- que unidad de distancia ? delay*distancia?

decreaseQ :: Quality -> Quality
decreaseQ (Qua newQua capacity delay) = (Qua newQua (capacity - 1) delay)