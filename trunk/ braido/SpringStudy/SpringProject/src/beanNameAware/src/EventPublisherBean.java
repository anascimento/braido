package beanNameAware.src;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;

public class EventPublisherBean implements ApplicationEventPublisher {
	private Event event;
	
	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public void publishEvent(ApplicationEvent arg0) {

	}
	
	public EventPublisherBean(Object source, Event event){
		super();
		this.event = event;
	}

}

class Event{
	private String event_id;
	private String event_name;
	public Event(){
		
	}
}