module Main where

    sortCircles :: [Integer] -> [Integer]
    sortCircles []     = []
    sortCircles (p:xs) = (sortCircles lesser) ++ [p] ++ (sortCircles greater) where
        lesser  = filter(< p) xs
        greater = filter(>= p) xs

    radius :: (String, Integer) -> Integer
    radius(name, radius) = radius

    small = ("small", 1)
    medium = ("medium", 8)
    big = ("big", 50)
