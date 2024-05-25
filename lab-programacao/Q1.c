#include <stdio.h>
#include <stdlib.h>

int main(void)
{
    float vetor[5], total = 0;
    for (int i = 0; i < 5; i++)
    {
        printf("\nDigite um numero: ");
        scanf("%f", &vetor[i]);
        total += vetor[i];
    }
    printf("\n");

    float media = total / 5;
    printf("A media dos valores eh: %.1f\n", media);

    return 0;
}