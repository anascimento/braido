package br.com.caelum.fj26;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class GeraBanco {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Configuration configuration = new AnnotationConfiguration();
		configuration.configure();	
		SessionFactory sf = configuration.buildSessionFactory();
		Session s = sf.openSession();		
		SchemaExport se = new SchemaExport(configuration);
		se.create(true, true);

	}

}
