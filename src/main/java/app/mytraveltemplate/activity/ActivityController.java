package app.mytraveltemplate.activity;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ActivityController {
	@Autowired
	private ActivityService activityService;
	
	@RequestMapping("/activities")
	public List<Activity> getAllActivities()  {
		return activityService.getAllActivities();
	}
	
	@PostMapping("/filter/{query}")
	public List<Activity> filterActivities(@RequestBody ActivityQuery query) {
		return activityService.filterActivities(query);
	}
	
	public class ActivityQuery {	
		private String city;
		private String timeOfDay;
		private String type;
		private String budget;
		private String pace;
		private String sites;
		private List<String> interests;
		private List<String> entertainment;
		private List<String> transport;
		
		public String getCity() {
			return city;
		}
		public void setCity(String city) {
			this.city = city;
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
		public List<String> getInterests() {
			return interests;
		}
		public void setInterests(List<String> interests) {
			this.interests = interests;
		}
		public List<String> getEntertainment() {
			return entertainment;
		}
		public void setEntertainment(List<String> entertainment) {
			this.entertainment = entertainment;
		}
		public List<String> getTransport() {
			return transport;
		}
		public void setTransport(List<String> transport) {
			this.transport = transport;
		}
		
	}
	
}
