package app.mytraveltemplate.activity;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.mytraveltemplate.tag.Tag;

@RestController
public class ActivityController {
	@Autowired
	private ActivityService activityService;
	
	@RequestMapping("/activities")
	public List<Activity> getAllActivities()  {
		return activityService.getAllActivities();
	}
	
	@RequestMapping("/activities/{city}")
	public List<Activity> filterActivitiesByCity(@PathVariable String city) {
		return activityService.filterActivitiesByCity(city);
	}
	
	@RequestMapping("/filter/{city}/{timeOfDay}")
	public List<Activity> filterActivities(@PathVariable String city, @PathVariable String timeOfDay) {
		return activityService.filterActivitiesInCity(city, timeOfDay);
	}

}
