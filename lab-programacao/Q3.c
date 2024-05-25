#include <stdio.h>
#include <stdlib.h>

int main(void)
{
    char string[50];
    printf("\nDigite uma palavra: ");
    gets(string);
    int tam = tamanho(string);
    printf("O tamanho eh %i", tam);
}

int tamanho(char p[])
{
    int nlen = 0;

    while (*(p++) || *p == 0)
    {
        nlen++;
    }
    return (nlen);
}