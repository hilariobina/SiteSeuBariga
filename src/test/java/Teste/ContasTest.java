package Teste;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.openqa.selenium.WebDriver;

import Page.ContaPage;
import Page.HOMEPAGE;
import Page.LoginPage;
import Suporte.DriverFactore;
import Suporte.GeradorDeNome;
import Suporte.Screeshort;

public class ContasTest {

	private WebDriver driver;
	public HOMEPAGE page;
	public LoginPage login;
	public ContaPage conta;
	public Screeshort scree = new Screeshort();
	public GeradorDeNome gerador = new GeradorDeNome();

	@Rule
	public TestName evi = new TestName();

	@Before
	public void SetUp() {

		driver = DriverFactore.Inicializar();
		page = new HOMEPAGE(driver);
		login = new LoginPage(driver);
		conta = new ContaPage(driver);

		login.setEmail();
		login.setSenha();
		login.ClicarBotao();

		page.clicarMenuConta();
		page.clicaAddConta();

	}

	@After
	public void fechar() {
		driver.quit();
	}

	@Test
	public void validarContaJaExistente() {

		conta.serNome("Lorenzo Bina");
		scree.GerarEvidencia(driver,
				"C:/evidencias/" + GeradorDeNome.geradorDeDataEHoraParaArquivo() + evi.getMethodName() + ".png");
		conta.clicaBotao();
		Assert.assertEquals("Já existe uma conta com esse nome!", conta.pegarMsgJaExiste());
		scree.GerarEvidencia(driver,
				System.getProperty("user.dir") + GeradorDeNome.geradorDeDataEHoraParaArquivo() + evi.getMethodName() + ".png");
	}

	@Test
	public void validarADDConta() {
		conta.serNome(gerador.GeradorDeNomeAleatorio());
		scree.GerarEvidencia(driver,
				"C:/evidencias/" + GeradorDeNome.geradorDeDataEHoraParaArquivo() + evi.getMethodName() + ".png");
		conta.clicaBotao();
		Assert.assertEquals("Conta adicionada com sucesso!", conta.pegarMsgSucesso());
		scree.GerarEvidencia(driver,
				System.getProperty("user.dir") + GeradorDeNome.geradorDeDataEHoraParaArquivo() + evi.getMethodName() + ".png");
	}

}
