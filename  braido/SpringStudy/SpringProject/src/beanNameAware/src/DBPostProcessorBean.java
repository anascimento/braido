package beanNameAware.src;

import java.util.Arrays;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class DBPostProcessorBean implements BeanPostProcessor {
	
	public Object postProcessAfterInitialization(Object bean, String beanName)
			throws BeansException {
		System.out.println("After Initialization");
		System.out.println("Bean object: "+ bean);
		System.out.println("Bean name: "+ beanName);
		DatabaseRowBean dbRow = null;
		if (bean instanceof DatabaseRowBean) {
			dbRow = (DatabaseRowBean) bean;
			dbRow.setValues(Arrays.asList("Antony","10","93232"));
			return dbRow;
		}
		return null;
	}

	public Object postProcessBeforeInitialization(Object bean, String beanName)
			throws BeansException {
		System.out.println("Before Initialization");
		System.out.println("Bean object: "+ bean);
		System.out.println("Bean name: "+ beanName);
		DatabaseRowBean dbRow = null;
		if (bean instanceof DatabaseRowBean) {
			dbRow=(DatabaseRowBean) bean;
			dbRow.setRowId("ROWID-001");
			dbRow.setNoOfColumns(3);
			return dbRow;
		}
		return null;
	}

}
