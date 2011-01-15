package springexample.sms;

public class SMS implements SMSInterface {
	private String cellNumber;
	
	public void sendSMS() {
		System.out.println("This is just SMS dummy method for String Test");
	}

	public String getCellNumber() {
		return cellNumber;
	}

	public void setCellNumber(String cellNumber) {
		this.cellNumber = cellNumber;
	}
}
