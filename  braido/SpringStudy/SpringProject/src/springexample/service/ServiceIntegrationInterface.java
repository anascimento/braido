package springexample.service;

import springexample.email.EmailInterface;
import springexample.sms.SMSInterface;

public interface ServiceIntegrationInterface {
	public EmailInterface getEmailInterface();
	public void setEmailInterface(EmailInterface emailInterface);
	public SMSInterface getSmsInterface();
	public void setSmsInterface(SMSInterface smsInterface);
	public void startService();
}
