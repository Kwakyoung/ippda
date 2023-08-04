package event;

public class EventVO {
 private int event_no, admin_no;
 private String event_title, event_context, event_image;
public int getEvent_no() {
	return event_no;
}
public void setEvent_no(int event_no) {
	this.event_no = event_no;
}
public int getAdmin_no() {
	return admin_no;
}
public void setAdmin_no(int admin_no) {
	this.admin_no = admin_no;
}
public String getEvent_title() {
	return event_title;
}
public void setEvent_title(String event_title) {
	this.event_title = event_title;
}
public String getEvent_context() {
	return event_context;
}
public void setEvent_context(String event_context) {
	this.event_context = event_context;
}
public String getEvent_image() {
	return event_image;
}
public void setEvent_image(String event_image) {
	this.event_image = event_image;
}
 
}
