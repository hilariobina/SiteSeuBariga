package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);

	}

	private final String XPATH_BOTAO = "//button[.='Entrar']";
	private final String XPATH_MSGMAIL = "//div[.='Email é um campo obrigatório']";
	private final String XPATH_MSGSENHA = "//div[.='Senha é um campo obrigatório']";
	private final String XPATH_MSGLOGINERRO = "//div[.='Problemas com o login do usuário']";
	private final String ID_EMAIL = "email";
	private final String ID_SENHA = "senha";

	public LoginPage setEmail() {
		driver.findElement(By.id(ID_EMAIL)).sendKeys("hilariobina@gmail.com");
		return this;

	}

	public LoginPage setSenha() {
		driver.findElement(By.id(ID_SENHA)).sendKeys("juliana100");
		return this;

	}

	public LoginPage setSenhaIconrreta() {
		driver.findElement(By.id(ID_SENHA)).sendKeys("123456");
		return this;

	}

	public String pegarMSGEMAIL() {

		return driver.findElement(By.xpath(XPATH_MSGMAIL)).getText();
	}

	public String pegarMSGESENHA() {

		return driver.findElement(By.xpath(XPATH_MSGSENHA)).getText();
	}

	public String pegaMSGERROLOGIN() {

		return driver.findElement(By.xpath(XPATH_MSGLOGINERRO)).getText();
	}

	public void ClicarBotao() {
		driver.findElement(By.xpath(XPATH_BOTAO)).click();

	}

}
