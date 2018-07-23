package app.mytraveltemplate.activity;

import java.util.Arrays;
import java.util.List;

public class UserAnswers {
	
	private Integer templateId;
	private String type;
	private String budget;
	private String pace;
	private String sites;
	private String cityTravel;
	private String interests;
	private String entertainment;
	
	public Integer getTemplateId() {
		return templateId;
	}
	public void setTemplateId(Integer templateId) {
		this.templateId = templateId;
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
	public List<String> getCityTravel() {
		List<String> travelInCities = Arrays.asList(cityTravel.split("\\s*,\\s*"));
		return travelInCities;
	}
	public void setCityTravel(String cityTravel) {
		this.cityTravel = cityTravel;
	}
	public List<String> getInterests() {
		List<String> userInterests = Arrays.asList(interests.split("\\s*,\\s*"));
		return userInterests;
	}
	public void setInterests(String interests) {
		this.interests = interests;
	}
	public List<String> getEntertainment() {
		List<String> userEntertainment = Arrays.asList(entertainment.split("\\s*,\\s*"));
		return userEntertainment;
	}
	public void setEntertainment(String entertainment) {
		this.entertainment = entertainment;
	}
	
	}

