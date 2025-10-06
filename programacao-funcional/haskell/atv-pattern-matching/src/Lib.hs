module Lib
    ( Ponto
    , distancia
    , Dolar(..)
    , converterParaReal
    , DiaSemana(..)
    , proximoDia
    , ehFimDeSemana
    , Opcao(..)
    , resposta
    , Pessoa(..)
    , maiorIdade
    ) where

--1.3. Crie um **sinônimo de tipo** `Ponto` para `(Float, Float)`.  
--Escreva uma função `distancia :: Ponto -> Ponto -> Float` 
--que calcule a distância euclidiana entre dois pontos.

type Ponto = (Float, Float)

distancia :: Ponto -> Ponto -> Float
distancia (x1, y1) (x2, y2) = sqrt ((x2 - x1)^2 + (y2 - y1)^2)

--Novos tipos
--2.1 Crie um `newtype` chamado `Dolar` que envolve `Float`.
--Escreva uma função `converterParaReal :: Dolar -> Float` considerando 1 Dólar = 5,50 BRL.
newtype Dolar = Dolar Float deriving (Show)

converterParaReal :: Dolar -> Float
converterParaReal (Dolar valor) = valor * 5.50

--Tipos algebrico
--3.1 Defina um tipo `DiaSemana` com os sete dias da semana.
--Escreva uma função `proximoDia :: DiaSemana -> DiaSemana`.
data DiaSemana = Segunda | Terca | Quarta | Quinta | Sexta | Sabado | Domingo
    deriving (Show, Eq)

proximoDia :: DiaSemana -> DiaSemana
proximoDia Segunda = Terca
proximoDia Terca   = Quarta
proximoDia Quarta  = Quinta
proximoDia Quinta  = Sexta
proximoDia Sexta   = Sabado
proximoDia Sabado  = Domingo
proximoDia Domingo = Segunda

--Pattern Matching
--4.2 Escreva uma função ehFimDeSemana :: DiaSemana -> Bool usando pattern matching.
ehFimDeSemana :: DiaSemana -> Bool
ehFimDeSemana Sabado  = True
ehFimDeSemana Domingo = True
ehFimDeSemana _       = False

--Funções que usam tipos algebricos
--5.3. Crie um tipo `Opcao` com `Sim | Nao | Talvez`.
--Escreva uma função `resposta :: Opcao -> String` que retorne `"Aceito"`, `"Recuso"` ou `"Indeciso"`.
data Opcao = Sim | Nao | Talvez
    deriving (Show, Eq)

resposta :: Opcao -> String
resposta Sim    = "Aceito"
resposta Nao    = "Recuso"
resposta Talvez = "Indeciso"

--Exercícios mistos avançados
--6.1. Crie um tipo `Pessoa` com `Nome String` e `Idade Int`.
--Escreva uma função `maiorIdade :: Pessoa -> Bool` usando pattern matching.
data Pessoa = Nome String | Idade Int
    deriving (Show, Eq)

maiorIdade :: Pessoa -> Bool
maiorIdade (Idade idade) = idade >= 18
maiorIdade (Nome _)      = False