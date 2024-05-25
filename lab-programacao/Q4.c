#include <stdio.h>
#include <stdlib.h>

#define Linhas 3
#define Colunas 3

int main(void)
{
    int MatrizAux = 0;
    int MatrizMult[Linhas][Colunas];
    int MatrizMain[Linhas][Colunas];

    for (int i = 0; i < Linhas; i++)
    {
        for (int j = 0; j < Colunas; j++)
        {
            printf("Matriz [%d] [%d] = ", i, j);
            scanf("%d", &MatrizMain[i][j]);
        }
    }
    printf("\n");
    for (int i = 0; i < Linhas; i++)
    {
        printf("| ");
        for (int j = 0; j < Colunas; j++)
        {
            printf("%d | ", MatrizMain[i][j]);
        }
        printf("\n");
    }
    for (int i = 0; i < Linhas; i++)
    { // controle da linha
        for (int j = 0; j < Colunas; j++)
        { // controle da coluna
            for (int k = 0; k < Colunas; k++)
            {
                MatrizAux = MatrizAux + (MatrizMain[i][k] * MatrizMain[k][j]);
            }
            MatrizMult[i][j] = MatrizAux;
            MatrizAux = 0;
        }
    }
    printf("\nO resultado eh: \n");
    printf("\n");
    for (int i = 0; i < Linhas; i++)
    {
        printf("| ");
        for (int j = 0; j < Colunas; j++)
        {
            printf("%d | ", MatrizMult[i][j]);
        }
        printf("\n");
    }
}