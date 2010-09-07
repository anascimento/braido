package main;
import bean.Computador;
import bean.Impressora;
import bean.Monitor;
import bean.Teclado;

public class IniciaComputador {
	public static void main(String[] args) {
		Computador computador = new Computador();
		computador.setImpressora(new Impressora());
		computador.setTeclado(new Teclado());
		computador.setMonitor(new Monitor());
		computador.ligar();
	}
}
