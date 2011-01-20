package beanNameAware.src;

public class CustomBean {
	public void customInitMethod(){
		System.out.println("Custom init method called for this bean");
	}
	
	public void customDestroyMethod(){
		System.out.println("Custom destroy method called for this bean");
	}
}
