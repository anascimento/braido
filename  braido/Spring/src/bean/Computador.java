package bean;
public class Computador {
	private Impressora impressora = null;
	private Monitor monitor = null;
	private Teclado teclado = null;

	public void setImpressora(Impressora impressora) {
		this.impressora = impressora;
	}

	public void setMonitor(Monitor monitor) {
		this.monitor = monitor;
	}

	public void setTeclado(Teclado teclado) {
		this.teclado = teclado;
	}

	public void ligar() {
		monitor.exibeMensagem("Digite texto para impressão");
		String texto = teclado.ler();
		impressora.imprimir(texto);
		monitor.exibeMensagem("Texto Impresso!");
	}
}
