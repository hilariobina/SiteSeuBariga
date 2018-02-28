package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HOMEPAGE {

	private WebDriver driver;

	private final String XPATH_MSGBOASVINDAS = "/html/body/div[1]";
	private final String XPATH_MENUCONTAS = "//*[@id='navbar']/ul/li[2]/a";
	private final String LINKTEXT_ADDCONTA = "Adicionar";

	public HOMEPAGE(WebDriver driver) {
		this.driver = driver;
	}

	public String pegaMSGSUCESSO() {
		return driver.findElement(By.xpath(XPATH_MSGBOASVINDAS)).getText();
	}

	public void clicarMenuConta() {
		driver.findElement(By.xpath(XPATH_MENUCONTAS)).click();
	}

	public void clicaAddConta() {
		driver.findElement(By.linkText(LINKTEXT_ADDCONTA)).click();
	}

	public void clicaCriarMovimentacao() {
		driver.findElement(By.linkText("Criar Movimentação")).click();
	}

}
