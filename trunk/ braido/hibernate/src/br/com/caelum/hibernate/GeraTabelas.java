package br.com.caelum.hibernate;

import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class GeraTabelas {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		AnnotationConfiguration cfg = new AnnotationConfiguration();
		cfg.addAnnotatedClass(Produto.class);
		cfg.configure();
		SchemaExport se = new SchemaExport(cfg);
		se.create(true, true);
	}

}
