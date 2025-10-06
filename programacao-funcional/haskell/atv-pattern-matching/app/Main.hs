module Main (main) where

import Lib

main :: IO ()
main = do
    let p1 = (0.0, 0.0) 
    let p2 = (3.0, 4.0)
    let p3 = (1.0, 1.0)
    let p4 = (4.0, 5.0)

    putStrLn "\nCalculando distâncias entre pontos:"
    putStrLn $ "Distância entre " ++ show p1 ++ " e " ++ show p2 ++ ": " ++ show (distancia p1 p2)
    putStrLn $ "Distância entre " ++ show p3 ++ " e " ++ show p4 ++ ": " ++ show (distancia p3 p4)    
    
    putStrLn "\nConvertendo dólares para reais:"
    let dolar1 = Dolar 10.0
    let dolar2 = Dolar 50.0    
    
    putStrLn $ show dolar1 ++ " = R$ " ++ show (converterParaReal dolar1)
    putStrLn $ show dolar2 ++ " = R$ " ++ show (converterParaReal dolar2)    

    putStrLn "\nSequência de dias da semana:"
    let hoje = Segunda
    putStrLn $ "Hoje: " ++ show hoje
    putStrLn $ "Amanhã: " ++ show (proximoDia hoje)
    putStrLn $ "Depois de amanhã: " ++ show (proximoDia (proximoDia hoje))
    
    putStrLn "\nVerificando fim de semana:"
    let todosDias = [Segunda, Terca, Quarta, Quinta, Sexta, Sabado, Domingo]
    mapM_ (\dia -> putStrLn $ show dia ++ " é fim de semana? " ++ show (ehFimDeSemana dia)) todosDias
    
    putStrLn "\nTestando opções de resposta:"
    let opcoes = [Sim, Nao, Talvez]
    mapM_ (\opcao -> putStrLn $ "Opção " ++ show opcao ++ " -> " ++ resposta opcao) opcoes
    
    putStrLn "\nExemplo prático:"
    putStrLn $ "Você aceita o convite? " ++ show Sim ++ " -> " ++ resposta Sim
    putStrLn $ "Você vai à festa? " ++ show Nao ++ " -> " ++ resposta Nao  
    putStrLn $ "Você quer sobremesa? " ++ show Talvez ++ " -> " ++ resposta Talvez
    
    putStrLn "\nTestando maioridade:"
    let pessoas = [Nome "Joao", Idade 25, Nome "Maria", Idade 16, Idade 18, Idade 17]
    mapM_ (\pessoa -> putStrLn $ show pessoa ++ " é maior de idade? " ++ show (maiorIdade pessoa)) pessoas    