package beanNameAware.src;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

public class Main {
	
	static void beanPostProcessorTest(){
		Resource resource = new FileSystemResource("beanNameAware//config//Spring-config.xml");
		ConfigurableBeanFactory xmlBeanFactory = new XmlBeanFactory(resource);
		DBPostProcessorBean processor = new DBPostProcessorBean();
		xmlBeanFactory.addBeanPostProcessor(processor);
		DatabaseRowBean databaseRow = (DatabaseRowBean) xmlBeanFactory.getBean("databaseRow");
		System.out.println("Row Id: "+ databaseRow.getRowId());
		System.out.println("Columns: "+ databaseRow.getNoOfColumns());
		System.out.println("Values: "+ databaseRow.getValues().toString());
	}
}
