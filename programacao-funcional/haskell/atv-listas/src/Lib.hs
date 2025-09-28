module Lib
    ( primeiroOuZero,
      meuLength,
      meuZip,
      divisores,
      ehPrimo
    ) where

--Pattern Matching - Exercicio 3.1
primeiroOuZero :: [Int] -> Int
primeiroOuZero [] = 0
primeiroOuZero xs
  | null xs = 0
  | otherwise = head xs

--Recursão em Listas - Exercício 3.1
meuLength :: [a] -> Int
meuLength [] = 0
meuLength (_:xs) = 1 + meuLength xs

--Funções com Vários Argumentos - Exercício 5.1
meuZip :: [a] -> [b] -> [(a,b)]
meuZip [] _ = []                          
meuZip _ [] = []                          
meuZip (x:xs) (y:ys) = (x,y) : meuZip xs ys 

-- Compreensão de Listas - Exercício 6.2
divisores :: Int -> [Int]
divisores n = [x | x <- [1..n], n `mod` x == 0]

-- Compreensão de Listas - Exercício 6.3
ehPrimo :: Int -> Bool
ehPrimo n 
  | n <= 1 = False
  | otherwise = length (divisores n) == 2