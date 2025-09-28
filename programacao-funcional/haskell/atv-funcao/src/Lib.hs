module Lib (quad, hipotenusa, classificaNota, diasDaSemana, fib) where

--Funções básicas - Exercício 1.1
quad :: Num a => a -> a
quad x = x * x

--Definições locais - Exercício 2.1
hipotenusa :: Floating a => a -> a -> a
hipotenusa a b = sqrt sab
    where
        sab = (quad a) + (quad b)

--Condicionais e guards - Exercício 3.3
classificaNota :: Double -> String
classificaNota nota
    | nota < 5  = "Reprovado"
    | nota <= 6.9 = "Recuperação"
    | otherwise = "Aprovado"

--Pattern Matching - Exercício 4.2
diasDaSemana :: Int -> String
diasDaSemana 1 = "Domingo"
diasDaSemana 2 = "Segunda"
diasDaSemana 3 = "Terça"
diasDaSemana 4 = "Quarta"
diasDaSemana 5 = "Quinta"
diasDaSemana 6 = "Sexta"
diasDaSemana 7 = "Sábado"
diasDaSemana _ = "Dia inválido"

--Recursão - Exercício 5.3
fib :: Integer -> Integer
fib 0 = 1
fib 1 = 1
fib x = fib (x - 1) + fib (x - 2)