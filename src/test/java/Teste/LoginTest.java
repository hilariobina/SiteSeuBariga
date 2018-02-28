package Teste;

import org.junit.After;
import org.junit.Assert;
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

public class LoginTest {

	public LoginPage page;
	private WebDriver driver;
	public HOMEPAGE home;
	public Screeshort scree = new Screeshort();
	public GeradorDeNome gerador = new GeradorDeNome();

	@Rule
	public TestName evi = new TestName();

	@Before
	public void SetUp() {

		driver = DriverFactore.Inicializar();

		page = new LoginPage(driver);
		home = new HOMEPAGE(driver);
	}

	@After
	public void Fechar() {
		driver.quit();
	}

	@Test
	public void loginClicarSomenteNoBotao() {
		page.ClicarBotao();
		Assert.assertEquals("Email é um campo obrigatório", page.pegarMSGEMAIL());
		Assert.assertEquals("Senha é um campo obrigatório", page.pegarMSGESENHA());
		scree.GerarEvidencia(driver,
				System.getProperty("user.dir") + GeradorDeNome.geradorDeDataEHoraParaArquivo() + evi.getMethodName() + ".png");

	}

	@Test
	public void validarSomenteCampoEmailPreenchido() {
		page.setEmail();
		scree.GerarEvidencia(driver,
				"C:/evidencias/" + GeradorDeNome.geradorDeDataEHoraParaArquivo() + evi.getMethodName() + ".png");
		page.ClicarBotao();
		Assert.assertEquals("Senha é um campo obrigatório", page.pegarMSGESENHA());
		scree.GerarEvidencia(driver,
				System.getProperty("user.dir") + GeradorDeNome.geradorDeDataEHoraParaArquivo() + evi.getMethodName() + ".png");
	}

	@Test
	public void validarSomenteCampoSenhaPreenchido() {
		page.setSenha();
		scree.GerarEvidencia(driver,
				"C:/evidencias/" + GeradorDeNome.geradorDeDataEHoraParaArquivo() + evi.getMethodName() + ".png");
		page.ClicarBotao();
		Assert.assertEquals("Email é um campo obrigatório", page.pegarMSGEMAIL());
		scree.GerarEvidencia(driver,
				System.getProperty("user.dir") + GeradorDeNome.geradorDeDataEHoraParaArquivo() + evi.getMethodName() + ".png");
	}

	@Test
	public void validarErroLogin() {
		page.setEmail();
		page.setSenhaIconrreta();
		scree.GerarEvidencia(driver,
				"C:/evidencias/" + GeradorDeNome.geradorDeDataEHoraParaArquivo() + evi.getMethodName() + ".png");
		page.ClicarBotao();
		Assert.assertEquals("Problemas com o login do usuário", page.pegaMSGERROLOGIN());
		scree.GerarEvidencia(driver,
				System.getProperty("user.dir") + GeradorDeNome.geradorDeDataEHoraParaArquivo() + evi.getMethodName() + ".png");

	}

	@Test
	public void acessoComSucesso() {
		page.setEmail();
		page.setSenha();
		page.ClicarBotao();
		Assert.assertEquals("Bem vindo, Hilario!", home.pegaMSGSUCESSO());
		scree.GerarEvidencia(driver,
				System.getProperty("user.dir") + GeradorDeNome.geradorDeDataEHoraParaArquivo() + evi.getMethodName() + ".png");
	}

}
