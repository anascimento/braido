package beanNameAware.src;

import org.springframework.beans.factory.BeanClassLoaderAware;

public class BeanLoader implements BeanClassLoaderAware {
	private ClassLoader classLoader;

	public ClassLoader getClassLoader() {
		return classLoader;
	}

	public void setBeanClassLoader(ClassLoader classLoader) {
		this.classLoader = classLoader;
	}

}
