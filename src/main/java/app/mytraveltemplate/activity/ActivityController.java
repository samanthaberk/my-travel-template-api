package app.mytraveltemplate.activity;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@RequestMapping("/activities/{city}") 
	public List<Activity> filterActivitiesByCity(@PathVariable String city) {
		return activityService.filterActivitiesByCity(city);
	}
	
	
	@RequestMapping("/filter/{city}/{timeOfDay}/{type}/{budget}/{pace}/{sites}/{internalTravel}/{interests}/{entertainment}")
	public Activity filterActivities(@PathVariable String city, @PathVariable String timeOfDay, @PathVariable String type, @PathVariable String budget, @PathVariable String pace, @PathVariable String sites, @PathVariable ArrayList<String> internalTravel, @PathVariable ArrayList<String> interests, @PathVariable ArrayList<String> entertainment) {
		return activityService.filterActivitiesInCity(city, timeOfDay, type, budget, pace, sites, internalTravel, interests, entertainment);
	}

}
