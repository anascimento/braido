package beanNameAware.src;

import org.springframework.beans.factory.BeanNameAware;

public class BeanName implements BeanNameAware {
	private String beanName;

	public String getBeanName() {
		return beanName;
	}

	public void setBeanName(String beanName) {
		this.beanName = beanName;
	}
}
