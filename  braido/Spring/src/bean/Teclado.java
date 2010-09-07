package bean;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Teclado {
	/**
	 * Lê um tesxto do usuário.
	 * 
	 * @return
	 */
	public String ler() {
		String texto = null;
		// imprime um 'prompt'
		System.out.print("[TECLADO]>");
		try {
			texto = new BufferedReader(new InputStreamReader(System.in))
					.readLine();
		} catch (IOException e) {
			System.out.println("Erro lendo teclado!");
			e.printStackTrace();
		}
		return texto;
	}

}
