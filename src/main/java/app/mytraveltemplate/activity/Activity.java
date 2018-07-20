package app.mytraveltemplate.activity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import app.mytraveltemplate.tag.Tag;

@Entity
@Table(name= "activities")
public class Activity {

	@Id
	private Integer id;
	private String city;
	private String content;
	private String timeOfDay;
	private String type;
	private String budget;
	private String pace;
	private String sites;

	@ManyToMany
	@JoinTable(name = "activitytag",
			joinColumns = @JoinColumn(name = "activityid", referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(name = "tagid", referencedColumnName = "id"))
	private List<Tag> tags = new ArrayList<Tag>();

	public Activity() {
	}

	public Activity(Integer id, String city, String content, String timeOfDay, String type, String budget, String pace, String sites) {
		super();
		this.id = id;
		this.city = city;
		this.content = content;
		this.timeOfDay = timeOfDay;
		this.type = type;
		this.budget = budget;
		this.pace = pace;
		this.sites = sites;
	}

	public List<Tag> getTags() {
		return tags;
	}

	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getTimeOfDay() {
		return timeOfDay;
	}

	public void setTimeOfDay(String timeOfDay) {
		this.timeOfDay = timeOfDay;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getBudget() {
		return budget;
	}

	public void setBudget(String budget) {
		this.budget = budget;
	}

	public String getPace() {
		return pace;
	}

	public void setPace(String pace) {
		this.pace = pace;
	}

	public String getSites() {
		return sites;
	}

	public void setSites(String sites) {
		this.sites = sites;
	}	
	

}
