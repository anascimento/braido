package main;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import bean.Computador;

public class IniciaUsandoSpring {
	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		Computador computador = (Computador) applicationContext.getBean("computadorBean");
		computador.ligar();
	}
}