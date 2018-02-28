package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContaPage extends BasePage {

	public ContaPage(WebDriver driver) {
		super(driver);

	}

	private final String XPATH_NOME = "//input[@id='nome']";
	private final String XPATH_BOTAO = "/html/body/div[2]/form/div[2]/button";
	private final String XPATH_MSGERRO = "//div[.='Já existe uma conta com esse nome!']";
	private final String XPATH_MSGSUCESSO = "//div[.='Conta adicionada com sucesso!']";

	public void serNome(String Nome) {

		driver.findElement(By.xpath(XPATH_NOME)).sendKeys(Nome);
	}

	public void clicaBotao() {

		driver.findElement(By.xpath(XPATH_BOTAO)).click();
	}

	public String pegarTexto() {
		return driver.findElement(By.xpath(XPATH_NOME)).getText();
	}

	public String pegarMsgSucesso() {
		return driver.findElement(By.xpath(XPATH_MSGSUCESSO)).getText();
	}

	public String pegarMsgJaExiste() {
		return driver.findElement(By.xpath(XPATH_MSGERRO)).getText();
	}

}
