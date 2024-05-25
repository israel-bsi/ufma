#include <stdio.h>
#include <stdlib.h>

int main(void)
{
    int vetmain[8], impar = 0, par = 0, i = 0;
    for (i = 0; i < 8; i++)
    {
        printf("\nDigite um numero: ");
        scanf("%d", &vetmain[i]);
    }

    for (i = 0; i < 8; i++)
    {
        if (vetmain[i] % 2 == 0)
        {
            par++; // Verificando quantos pares tem no vetor
        }
        else
        {
            impar++; // Verificando quantos impares tem no vetor
        }
    }

    // int *v;

    // v = (int *)malloc(par * sizeof(int));

    // for (i = 0; i < par; ++i)
    // {
    //     v[i] = i;
    // }

    // free(v);
    return 0;
}