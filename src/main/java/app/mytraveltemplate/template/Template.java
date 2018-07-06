package app.mytraveltemplate.template;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "templates")
public class Template {
	
	@Id
	private Integer id;
	private Integer duration;
	private String traveler_type;
	private String pace;
	private String transport;
	private String content;
	
	public Template() {
	}
	
	public Template(Integer id, Integer duration, String traveler_type, String pace, String transport,
			String content) {
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
	public String getTransport() {
		return transport;
	}
	public void setTransport(String transport) {
		this.transport = transport;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}	
	
}
