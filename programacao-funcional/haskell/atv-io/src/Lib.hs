module Lib
    ( exercicio1
    , exercicio2
    , exercicio3
    , exercicio4
    , exercicio5
    ) where

import System.IO

-- Parte 1 – Fundamentos de IO
-- Escreva um programa que leia um caractere do teclado e o imprima duas vezes na tela.
exercicio1 :: IO ()
exercicio1 = do
    putStrLn "=== Exercício 1 ==="
    putStrLn "Digite um caractere:"
    c <- getChar
    _ <- getLine  -- Limpa o buffer
    putChar c
    putChar c
    putStrLn ""

-- Parte 2 – Lendo e escrevendo Strings
-- Implemente uma função que peça o nome do usuário e o cumprimente.
exercicio2 :: IO ()
exercicio2 = do
    putStrLn "\n=== Exercício 2 ==="
    putStrLn "Qual é o seu nome?"
    nome <- getLine
    putStrLn $ "Bem vindo " ++ nome ++ "!"

-- Parte 3 – Do notation
-- Atividade 3: Verifica se o usuário é maior de idade
exercicio3 :: IO ()
exercicio3 = do
    putStrLn "\n=== Exercício 3 ==="
    putStrLn "Qual é a sua idade?"
    idadeStr <- getLine
    let idade = read idadeStr :: Int
    if idade >= 18
        then putStrLn "Você é maior de idade."
        else putStrLn "Você é menor de idade."

-- Parte 4 – Manipulação de arquivos
-- Escreva um programa que leia o conteúdo de um arquivo "entrada.txt" e imprima na tela.
exercicio4 :: IO ()
exercicio4 = do
    putStrLn "\n=== Exercício 4 ==="
    putStrLn "Lendo o arquivo 'entrada.txt'..."
    conteudo <- readFile "entrada.txt"
    putStrLn "Conteúdo do arquivo:"
    putStrLn conteudo

-- Parte 5 – Desafios
-- Implemente um programa que conte quantas linhas existem em um arquivo de texto.
exercicio5 :: IO ()
exercicio5 = do
    putStrLn "\n=== Exercício 5 ==="
    putStrLn "Contando linhas do arquivo 'entrada.txt'..."
    conteudo <- readFile "entrada.txt"
    let numLinhas = length (lines conteudo)
    putStrLn $ "O arquivo tem " ++ show numLinhas ++ " linha(s)."
