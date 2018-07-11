package app.mytraveltemplate.activity;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	
}
