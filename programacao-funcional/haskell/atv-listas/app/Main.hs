module Main (main) where

import Lib

main :: IO ()
main = do
    --Definição e Criação de Listas - Exercício 1.2
    print ("Definicao e Criacao de Listas")
    print listaUmAVinte
    print listaParesAteVinte
    print listaMultiplosDeTres    
    print ("--------------------------------")
    --Funções e Operadores sobre Listas - Exercício 2.1
    print ("Funcoes e Operadores sobre Listas")
    print (head lista)
    print (tail lista)
    print (take 5 lista)
    print (drop 7 lista)
    print (lista !! 3)
    --Recursão em Listas - Exercício 3.1
    print ("Recursao em Listas")
    print (meuLength [1,2,3,4,5])
    --Funções com Vários Argumentos - Exercício 5.1 e 5.2
    print ("Funcoes com Varios Argumentos")
    print (meuZip [1,2,3] ['a','b','c'])
    --Compreensão de Listas - Exercício 6.2 e 6.3
    print ("Compreensao de Listas")
    print (divisores 12)
    print (ehPrimo 7)
  where  
    --Definição e Criação de Listas - Exercício 1.2
    listaUmAVinte = [1..20]
    listaParesAteVinte = [0,2..20]
    listaMultiplosDeTres = [3,6..30]    
    --Funções e Operadores sobre Listas -  - Exercício 2.1
    lista = [10..20]   