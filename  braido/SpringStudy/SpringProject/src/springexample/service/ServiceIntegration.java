package springexample.service;

import springexample.email.EmailInterface;
import springexample.sms.SMSInterface;

public class ServiceIntegration implements ServiceIntegrationInterface {
	private EmailInterface emailInterface;
	private SMSInterface smsInterface;
	
	public EmailInterface getEmailInterface() {
		return emailInterface;
	}
	public void setEmailInterface(EmailInterface emailInterface) {
		this.emailInterface = emailInterface;
	}
	public SMSInterface getSmsInterface() {
		return smsInterface;
	}
	public void setSmsInterface(SMSInterface smsInterface) {
		this.smsInterface = smsInterface;
	}
	public void startService() {
		if(getEmailInterface() != null){
			getEmailInterface().sendEmail();
			System.out.println("Email sent to: "+getEmailInterface().getFromEmail());
			System.out.println("Email userId: "+getEmailInterface().getUserId());
			System.out.println("Email password: "+getEmailInterface().getPassword());
			System.out.println("Email smtpHost: "+getEmailInterface().getSmtpHost());
		}
		if(getSmsInterface() != null){
			getSmsInterface().sendSMS();
			System.out.println("SMS sent to: "+ getSmsInterface().getCellNumber());
		}
	}
	
	
}
