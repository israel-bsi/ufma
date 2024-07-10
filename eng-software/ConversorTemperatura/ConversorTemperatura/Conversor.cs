namespace ConversorTemperatura;
public class Conversor
{
    public double Converter(int opcao, double graus)
    {
        var resultado = 0.0;
        switch (opcao)
        {
            case 1:
                resultado = (graus * 1.8) + 32;
                break;

            case 2:
                resultado = (graus - 32) / 1.8;
                break;
        }
        return resultado;
    }
}