package app.mytraveltemplate.template;

import java.util.HashMap;
import java.util.List;

public class Template {
	
	private int id;
	private int duration;
	private String traveler_type;
	private String pace;
	private List<String> transport;
	private HashMap<String, String> content;
	
	
	public Template() {

	}
	
	public Template(int id, int duration, String traveler_type, String pace, List<String> transport,
			HashMap<String, String> content) {
		super();
		this.id = id;
		this.duration = duration;
		this.traveler_type = traveler_type;
		this.pace = pace;
		this.transport = transport;
		this.content = content;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public String getTraveler_type() {
		return traveler_type;
	}
	public void setTraveler_type(String traveler_type) {
		this.traveler_type = traveler_type;
	}
	public String getPace() {
		return pace;
	}
	public void setPace(String pace) {
		this.pace = pace;
	}
	public List<String> getTransport() {
		return transport;
	}
	public void setTransport(List<String> transport) {
		this.transport = transport;
	}
	public HashMap<String, String> getContent() {
		return content;
	}
	public void setContent(HashMap<String, String> content) {
		this.content = content;
	}	
	
}
