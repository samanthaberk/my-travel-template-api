package app.mytraveltemplate.activity;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "https://mytraveltemplate.herokuapp.com/")
public class ActivityController {
	@Autowired
	private ActivityService activityService;
	
	
	@RequestMapping("/activities")
	public List<Activity> getAllActivities()  {
		return activityService.getAllActivities();
	}
	
	@RequestMapping("/activities/{city}") 
	public List<Activity> filterActivitiesByCity(@PathVariable String city) {
		return activityService.findActivitiesInCity(city);
	}
	
	
//	@RequestMapping("/filter/{city}/{timeOfDay}/{travelParty}/{budget}/{pace}/{sites}/{cityTravel}/{interests}/{entertainment}/{activityList}")
//	public Activity filterActivities(@PathVariable String city, @PathVariable String timeOfDay, @PathVariable String travelParty, @PathVariable String budget, @PathVariable String pace, @PathVariable String sites, @PathVariable ArrayList<String> cityTravel, @PathVariable ArrayList<String> interests, @PathVariable ArrayList<String> entertainment, @PathVariable ArrayList<String> activityList) {
//		return activityService.filterActivitiesInCity(city, timeOfDay, travelParty, budget, pace, sites, cityTravel, interests, entertainment, activityList);
//	}
	
	@RequestMapping("/getActivities")
	@PostMapping
	public List<Activity> test(@RequestBody UserAnswers userAnswers)	{
		return activityService.getActivitiesForTemplate(userAnswers);
	}

}
