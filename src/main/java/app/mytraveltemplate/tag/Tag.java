package app.mytraveltemplate.tag;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import app.mytraveltemplate.activity.Activity;

@Entity
@Table(name = "tags")
public class Tag {
	
	@Id
	private Integer id;
	private String tagname;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JsonBackReference
	@JoinTable(name = "activitytag",
			joinColumns = @JoinColumn(name = "tagid", referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(name = "activityid", referencedColumnName = "id"))
	private Set<Activity> activities = new HashSet<Activity>();
	
	public Tag() {
	}
	
	public Tag(Integer id, String tagname) {
		super();
		this.id = id;
		this.tagname = tagname;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTagname() {
		return tagname;
	}

	public void setTagname(String tagname) {
		this.tagname = tagname;
	}
	

	
}
