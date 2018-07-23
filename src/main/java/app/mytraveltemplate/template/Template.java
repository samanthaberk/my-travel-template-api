package app.mytraveltemplate.template;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import app.mytraveltemplate.activity.Activity;

@Entity
@Table(name = "templates")
public class Template {
	
	@Id
	private Integer id;
	private String duration;
	private String travelertype;
	private String pace;
	private String transport;
	private String content;
	@OneToMany
	@JoinTable(name="templateActivity", joinColumns=@JoinColumn(name="userId"),
				inverseJoinColumns=@JoinColumn(name="templateId")
	)
	private Collection<Activity> activities = new ArrayList<Activity>();
	
	public Template() {
	}
	
	public Template(Integer id, String duration, String travelertype, String pace, String transport,
			String content) {
		super();
		this.id = id;
		this.duration = duration;
		this.travelertype = travelertype;
		this.pace = pace;
		this.transport = transport;
		this.content = content;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public String getTravelertype() {
		return travelertype;
	}
	public void setTravelertype(String travelertype) {
		this.travelertype = travelertype;
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

	public Collection<Activity> getActivities() {
		return activities;
	}

	public void setActivities(Collection<Activity> activities) {
		this.activities = activities;
	}
	
}
