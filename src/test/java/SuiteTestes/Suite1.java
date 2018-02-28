package SuiteTestes;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import Teste.ADDContaTest;
import Teste.ContasTest;
import Teste.LoginTest;
import Teste.MovimentaçãoTeste;

@RunWith(Suite.class)
@SuiteClasses({
	LoginTest.class,
	ADDContaTest.class,
	ContasTest.class,
	MovimentaçãoTeste.class
})
public class Suite1 {

}
