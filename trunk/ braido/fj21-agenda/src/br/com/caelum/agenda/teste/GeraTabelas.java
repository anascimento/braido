package br.com.caelum.agenda.teste;

import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import br.com.caelum.agenda.modelo.Contatos;
import br.com.caelum.agenda.modelo.Funcionarios;

public class GeraTabelas {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		AnnotationConfiguration cfg = new AnnotationConfiguration();
		cfg.addAnnotatedClass(Contatos.class);
		cfg.addAnnotatedClass(Funcionarios.class);
		cfg.configure();
		SchemaExport se = new SchemaExport(cfg);
		se.create(true, true);

	}

}
