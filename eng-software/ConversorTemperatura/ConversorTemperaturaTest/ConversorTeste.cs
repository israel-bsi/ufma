using ConversorTemperatura;
using Xunit.Abstractions;

namespace ConversorTemperaturaTest;
public class ConversorTeste(ITestOutputHelper testOutput)
{
    [Fact]
    public void DeveRetornar32QuandoOpcaoFor1e0Grau()
    {
        // Arrange
        var conversor = new Conversor();
        var resultadoEsperado = 32;

        // Act
        var resultado = conversor.Converter(1, 0);
        testOutput.WriteLine($"Resultado: {resultado}");

        // Assert
        Assert.Equal(resultadoEsperado, resultado);
    }
    [Fact]
    public void DeveRetornar45QuandoOpcaoFor1e5Grau()
    {
        // Arrange
        var conversor = new Conversor();
        var resultadoEsperado = 41;

        // Act
        var resultado = conversor.Converter(1, 5);
        testOutput.WriteLine($"Resultado: {resultado}");

        // Assert
        Assert.Equal(resultadoEsperado, resultado);
    }
    [Fact]
    public void DeveRetornarMenos15QuandoOpcaoFor2e5Graus()
    {
        // Arrange
        var conversor = new Conversor();
        var resultadoEsperado = -15;

        // Act
        var resultado = conversor.Converter(2, 5);
        testOutput.WriteLine($"Resultado: {resultado}");

        // Assert
        Assert.Equal(resultadoEsperado, resultado);
    }
    [Fact]
    public void DeveRetornarMenos17QuandoOpcaoFor2e0Graus()
    {
        // Arrange
        var conversor = new Conversor();
        var resultadoEsperado = -17.777777777777778;

        // Act
        var resultado = conversor.Converter(2, 0);
        testOutput.WriteLine($"Resultado: {resultado}");

        // Assert
        Assert.Equal(resultadoEsperado, resultado);
    }
}