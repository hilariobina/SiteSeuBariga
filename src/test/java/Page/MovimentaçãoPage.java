package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import Suporte.GeradorDeNome;

public class MovimentaçãoPage extends BasePage {

	public MovimentaçãoPage(WebDriver driver) {
		super(driver);

	}

	private final String ID_TIPOMOVIMENTACAO = "tipo";
	private final String XPATH_DATAMOVIMENTACAO = "//input[@id='data_transacao']";
	private final String XPATH_DATAPAGAMENTO = "//*[@id='data_pagamento']";
	private final String XPATH_DESCRICAO = "//input[@id='descricao']";
	private final String XPATH_INTERESSADO = "//input[@id='interessado']";
	private final String XPATH_VALOR = "//input[@id='valor']";
	private final String ID_CONTA = "conta";
	private final String XPATH_RADIO_PAGO = "//input[@id='status_pago']";
	private final String XPATH_RADIO_PENDENTE = "//input[@id='status_pendente']";
	private final String XPATH_BOTAO_SALVAR = "/html/body/div[2]/form/div[4]/button";

	public GeradorDeNome gerador = new GeradorDeNome();

	public void TipoMovimentacao() {
		WebElement Tmo = driver.findElement(By.id(ID_TIPOMOVIMENTACAO));
		Select movi = new Select(Tmo);
		movi.selectByIndex(0);

	}

	public void setDataMovimentacao(String data) {
		driver.findElement(By.xpath(XPATH_DATAMOVIMENTACAO)).sendKeys(data);

	}

	public void setDataPagamento(String data) {
		driver.findElement(By.xpath(XPATH_DATAPAGAMENTO)).sendKeys(data);

	}

	public void setDescricao() {
		driver.findElement(By.xpath(XPATH_DESCRICAO)).sendKeys("Pagamento de conta de Luz");

	}

	public void setIntessado() {
		driver.findElement(By.xpath(XPATH_INTERESSADO)).sendKeys("Eletropaulo");

	}

	public void setValor() {
		driver.findElement(By.xpath(XPATH_VALOR)).sendKeys("498");

	}

	public void setConta() {
		WebElement combo = driver.findElement(By.id(ID_CONTA));
		Select conta = new Select(combo);
		conta.selectByIndex(0);

	}

	public void setRadioPago() {
		driver.findElement(By.xpath(XPATH_RADIO_PAGO)).click();

	}

	public void setRadioPendente() {
		driver.findElement(By.xpath(XPATH_RADIO_PENDENTE)).click();

	}

	public void salvar() {
		driver.findElement(By.xpath(XPATH_BOTAO_SALVAR)).click();

	}

	public String pegaMsgSucesso() {
		return driver.findElement(By.xpath("/html/body/div[1]")).getText();
	}

	public String CampoObrigatorio() {
		return driver.findElement(By.xpath("/html/body/div[1]/ul/li")).getText();
	}

}
