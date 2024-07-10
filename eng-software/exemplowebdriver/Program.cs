using OpenQA.Selenium;
using OpenQA.Selenium.Chrome;

var webDriver = new ChromeDriver();

webDriver.Navigate().GoToUrl("https://www.selenium.dev");

webDriver.Manage().Window.Maximize();

webDriver.FindElement(By.LinkText("Documentation")).Click();

webDriver.FindElement(By.Id("tabs-03-02-tab")).Click();

webDriver.Quit();