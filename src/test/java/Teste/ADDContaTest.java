package Teste;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.openqa.selenium.WebDriver;

import Page.HOMEPAGE;
import Page.LoginPage;
import Suporte.DriverFactore;
import Suporte.GeradorDeNome;
import Suporte.Screeshort;

public class ADDContaTest {

	private WebDriver driver;

	public HOMEPAGE page;
	public LoginPage login;

	public Screeshort scree = new Screeshort();
	public GeradorDeNome gerador = new GeradorDeNome();

	@Rule
	public TestName evi = new TestName();

	@Before
	public void SetUp() {

		driver = DriverFactore.Inicializar();

		page = new HOMEPAGE(driver);
		login = new LoginPage(driver);

		login.setEmail();
		login.setSenha();
		login.ClicarBotao();

	}

	@After
	public void Fechar() {
		driver.quit();
	}

	@Test
	public void ValidarAcessoPaginaConta() {

		page.clicarMenuConta();
		page.clicaAddConta();
		scree.GerarEvidencia(driver,
				System.getProperty("user.dir") + GeradorDeNome.geradorDeDataEHoraParaArquivo() + evi.getMethodName() + ".png");
	}

}
