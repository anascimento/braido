package br.com.caelum.tarefas.tabelas;

import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import br.com.caelum.tarefas.modelo.Tarefa;

public class GeraTabelas {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		AnnotationConfiguration cfg = new AnnotationConfiguration();
		cfg.addAnnotatedClass(Tarefa.class);
		cfg.configure();
		SchemaExport se = new SchemaExport(cfg);
		se.create(true, true);

	}

}
