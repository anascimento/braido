package springexample.client;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import springexample.service.ServiceIntegrationInterface;

public class TestClient {

	public static void main(String[] args) {
		try{
			System.out.println("Example started");
			XmlBeanFactory appContext = new XmlBeanFactory(new ClassPathResource("spring//springexample-test.xml"));
			ServiceIntegrationInterface si = (ServiceIntegrationInterface) appContext.getBean("service");
			si.startService();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
