package beanNameAware.src;

import java.util.List;

import org.springframework.beans.factory.DisposableBean;

public class DatabaseBean implements DisposableBean {
	private List<Connection> connections;
	
	public void establishConnection(){
		for(int i=0;i<5;i++){
			Connection connection = new Connection();
			connection.createConnection();
			connections.add(connection);
		}
	}
	public void destroy() throws Exception {
		for(Connection connection: connections)
			connection.closeConnection();
	}

}
	
class Connection{
	public void createConnection(){
		
	}
	public void closeConnection(){
		
	}
}