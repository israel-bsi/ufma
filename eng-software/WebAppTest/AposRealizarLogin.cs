using OpenQA.Selenium;
using OpenQA.Selenium.Chrome;
using OpenQA.Selenium.Interactions;

namespace WebAppTest;

public class AposRealizarLogin
{
    private readonly ChromeDriver driver = new();
    [Fact]
    public void RealizarLoginECadastrarCliente()
    {
        driver.Navigate().GoToUrl("https://localhost:5001/UsuarioApps/Login");

        Thread.Sleep(1000);

        var login = driver.FindElement(By.Id("Email"));
        login.SendKeys("israel@email.com");

        var senha = driver.FindElement(By.Id("Senha"));
        senha.SendKeys("senha01");

        Thread.Sleep(1000);

        var btnLogar = driver.FindElement(By.Id("btn-logar"));
        btnLogar.Click();

        Thread.Sleep(1000);

        var linkTextCliente = driver.FindElement(By.LinkText("Cliente"));
        linkTextCliente.Click();

        Thread.Sleep(1000);

        var linkTextAddClient = driver.FindElement(By.LinkText("Adicionar Cliente"));
        linkTextAddClient.Click();

        Thread.Sleep(1000);
        
        var campoId = driver.FindElement(By.Name("Identificador"));
        campoId.SendKeys("8137fbc3-5c79-465a-8410-72b80fa508bc");

        Thread.Sleep(1000);

        var campoCpf = driver.FindElement(By.Name("CPF"));
        campoCpf.SendKeys("21836147066");

        Thread.Sleep(1000);

        var campoNome = driver.FindElement(By.Name("Nome"));
        campoNome.SendKeys("Israel Silva");

        Thread.Sleep(1000);

        var profissao = driver.FindElement(By.Name("Profissao"));
        profissao.SendKeys("Desenvolvedor");

        Thread.Sleep(1000);

        var btnNovo = driver.FindElement(By.CssSelector(".btn-primary"));
        btnNovo.Click();

        Thread.Sleep(1000);

        Assert.Contains("Israel Silva", driver.PageSource);

        driver.Quit();
    }

    [Fact]
    public void SeleniumIde()
    {
        driver.Navigate().GoToUrl("https://localhost:5001/");
        driver.Manage().Window.Size = new System.Drawing.Size(1936, 1048);
        driver.FindElement(By.Id("login")).Click();
        driver.FindElement(By.Id("Email")).Click();
        driver.FindElement(By.Id("Email")).Click();
        driver.FindElement(By.Id("Email")).Click();
        {
            var element = driver.FindElement(By.Id("Email"));
            Actions builder = new Actions(driver);
            builder.DoubleClick(element).Perform();
        }
        driver.FindElement(By.Id("Email")).SendKeys("israel@email.com");
        driver.FindElement(By.Id("Senha")).Click();
        driver.FindElement(By.Id("Senha")).SendKeys("senha01");
        driver.FindElement(By.CssSelector(".form-group")).Click();
        driver.FindElement(By.Id("btn-logar")).Click();
        driver.FindElement(By.Id("clientes")).Click();
        driver.FindElement(By.LinkText("Adicionar Cliente")).Click();
        driver.FindElement(By.Id("Identificador")).Click();
        driver.FindElement(By.Id("Identificador")).SendKeys("24aec5d7-6bb4-46ea-8451-851410dd072e");
        driver.FindElement(By.Id("CPF")).Click();
        driver.FindElement(By.Id("CPF")).SendKeys("26931531077");
        driver.FindElement(By.Id("Nome")).Click();
        driver.FindElement(By.Id("Nome")).SendKeys("Fulano Beltrano");
        driver.FindElement(By.Id("Profissao")).Click();
        driver.FindElement(By.Id("Profissao")).SendKeys("Developer");
        driver.FindElement(By.CssSelector("html")).Click();
        driver.FindElement(By.CssSelector(".btn-primary")).Click();
        driver.FindElement(By.CssSelector("tr:nth-child(3)")).Click();
        driver.FindElement(By.CssSelector("html")).Click();
        driver.FindElement(By.CssSelector(".btn-link")).Click();
        driver.FindElement(By.CssSelector("html")).Click();
        driver.Close();
    }
}