module Main (main) where

import Lib

menu :: IO ()
menu = do
    putStrLn "\n========================================="
    putStrLn "Atividades de Entrada e Saída - Haskell"
    putStrLn "========================================="
    putStrLn "1. Ler caractere e imprimir duas vezes"
    putStrLn "2. Pedir nome e cumprimentar"
    putStrLn "3. Verificar se é maior de idade"
    putStrLn "4. Ler arquivo 'entrada.txt'"
    putStrLn "5. Contar linhas do arquivo 'entrada.txt'"
    putStrLn "0. Sair"
    putStrLn "========================================="
    putStrLn "Escolha uma opção:"
    opcao <- getLine
    case opcao of
        "1" -> exercicio1 >> menu
        "2" -> exercicio2 >> menu
        "3" -> exercicio3 >> menu
        "4" -> exercicio4 >> menu
        "5" -> exercicio5 >> menu
        "0" -> putStrLn "Encerrando o programa..."
        _   -> putStrLn "Opção inválida!" >> menu

main :: IO ()
main = menu