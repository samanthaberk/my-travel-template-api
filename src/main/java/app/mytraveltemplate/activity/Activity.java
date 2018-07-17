package app.mytraveltemplate.activity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

	@ManyToMany
	@JoinTable(name = "activitytag",
			joinColumns = @JoinColumn(name = "activityid", referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(name = "tagid", referencedColumnName = "id"))
	private List<Tag> tags = new ArrayList<Tag>();

	public Activity() {
	}

	public Activity(Integer id, String city, String content) {
		super();
		this.id = id;
		this.city = city;
		this.content = content;
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


}
