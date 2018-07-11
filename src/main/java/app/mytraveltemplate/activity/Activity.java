package app.mytraveltemplate.activity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "activities")
public class Activity {
	
	@Id
	private Integer id;
	private String city;
	private String content;

	public Activity() {
	}
	
	public Activity(Integer id, String city, String content) {
		super();
		this.id = id;
		this.city = city;
		this.content = content;
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
