package Teste;

import java.util.Date;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.openqa.selenium.WebDriver;

import Page.HOMEPAGE;
import Page.LoginPage;
import Page.MovimentaçãoPage;
import Suporte.DriverFactore;
import Suporte.GeradorDeNome;
import Suporte.Screeshort;

public class MovimentaçãoTeste {

	private WebDriver driver;
	public MovimentaçãoPage movi;
	public HOMEPAGE page;
	public LoginPage login;

	public Screeshort scree = new Screeshort();
	public GeradorDeNome gerador = new GeradorDeNome();

	@Rule
	public TestName evi = new TestName();

	@Before
	public void SetUp() {

		driver = DriverFactore.Inicializar();

		login = new LoginPage(driver);
		page = new HOMEPAGE(driver);

		login.setEmail();
		login.setSenha();
		login.ClicarBotao();

		page.clicaCriarMovimentacao();
		movi = new MovimentaçãoPage(driver);
	}

	@After
	public void Fechar() {
		driver.quit();
	}

	@Test
	public void CriarMovimentacaoPAGA() {

		movi.TipoMovimentacao();
		movi.setDataMovimentacao(gerador.geradorDataCorrente(new Date()));
		movi.setDataPagamento(gerador.geradorDataCorrente(new Date()));
		movi.setDescricao();
		movi.setIntessado();
		movi.setValor();
		movi.setConta();
		movi.setRadioPago();
		scree.GerarEvidencia(driver,
				System.getProperty("user.dir") + GeradorDeNome.geradorDeDataEHoraParaArquivo() + evi.getMethodName() + ".png");
		movi.salvar();

		Assert.assertEquals("Movimentação adicionada com sucesso!", movi.pegaMsgSucesso());
		scree.GerarEvidencia(driver,
				System.getProperty("user.dir") + GeradorDeNome.geradorDeDataEHoraParaArquivo() + evi.getMethodName() + ".png");

	}

	@Test
	public void CriarMovimentacaoPendente() {

		movi.TipoMovimentacao();
		movi.setDataPagamento(gerador.geradorDataCorrente(new Date()));
		movi.setDataMovimentacao(gerador.geradorDataCorrente(new Date()));
		movi.setDescricao();
		movi.setIntessado();
		movi.setValor();
		movi.setConta();
		movi.setRadioPendente();
		scree.GerarEvidencia(driver,
				System.getProperty("user.dir") + GeradorDeNome.geradorDeDataEHoraParaArquivo() + evi.getMethodName() + ".png");

		movi.salvar();
		Assert.assertEquals("Movimentação adicionada com sucesso!", movi.pegaMsgSucesso());
		scree.GerarEvidencia(driver,
				System.getProperty("user.dir") + GeradorDeNome.geradorDeDataEHoraParaArquivo() + evi.getMethodName() + ".png");

	}

	@Test
	public void CampoMovimentacaoObrgatorio() {
		movi.TipoMovimentacao();
		movi.setDataPagamento(gerador.geradorDataCorrente(new Date()));
		movi.setDescricao();
		movi.setIntessado();
		movi.setValor();
		movi.setConta();
		movi.setRadioPendente();
		movi.salvar();
		scree.GerarEvidencia(driver,
				System.getProperty("user.dir") + GeradorDeNome.geradorDeDataEHoraParaArquivo() + evi.getMethodName() + ".png");
		Assert.assertEquals("Data da Movimentação é obrigatório", movi.CampoObrigatorio());
	}

	@Test
	public void CampoDataPagamentoObrigatorio() {
		movi.TipoMovimentacao();
		movi.setDataMovimentacao(gerador.geradorDataCorrente(new Date()));
		movi.setDescricao();
		movi.setIntessado();
		movi.setValor();
		movi.setConta();
		movi.setRadioPendente();
		movi.salvar();
		scree.GerarEvidencia(driver,
				System.getProperty("user.dir") + GeradorDeNome.geradorDeDataEHoraParaArquivo() + evi.getMethodName() + ".png");
		Assert.assertEquals("Data do pagamento é obrigatório", movi.CampoObrigatorio());
	}

	@Test
	public void CampoDescricaoObrigatorio() {
		movi.TipoMovimentacao();
		movi.setDataMovimentacao(gerador.geradorDataCorrente(new Date()));
		movi.setDataPagamento(gerador.geradorDataCorrente(new Date()));
		movi.setIntessado();
		movi.setValor();
		movi.setConta();
		movi.setRadioPendente();
		movi.salvar();
		scree.GerarEvidencia(driver,
				System.getProperty("user.dir") + GeradorDeNome.geradorDeDataEHoraParaArquivo() + evi.getMethodName() + ".png");;
		Assert.assertEquals("Descrição é obrigatório", movi.CampoObrigatorio());
	}

	@Test
	public void CampoInteressadoObrigatorio() {
		movi.TipoMovimentacao();
		movi.setDataMovimentacao(gerador.geradorDataCorrente(new Date()));
		movi.setDataPagamento(gerador.geradorDataCorrente(new Date()));
		movi.setDescricao();
		movi.setValor();
		movi.setConta();
		movi.setRadioPendente();
		movi.salvar();
		scree.GerarEvidencia(driver,
				System.getProperty("user.dir") + GeradorDeNome.geradorDeDataEHoraParaArquivo() + evi.getMethodName() + ".png");
		Assert.assertEquals("Interessado é obrigatório", movi.CampoObrigatorio());
	}
}
