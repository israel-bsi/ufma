using OpenQA.Selenium.Chrome;
using OpenQA.Selenium;

var driver = new ChromeDriver();

driver.Url = "https://www.google.com";
driver.FindElement(By.Name("q")).SendKeys("webdriver" + Keys.Return);
Console.WriteLine(driver.Title);