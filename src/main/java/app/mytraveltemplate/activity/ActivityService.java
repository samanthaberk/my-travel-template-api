package app.mytraveltemplate.activity;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActivityService {
	
	@Autowired
	private ActivityRepository activityRepository;
	
	public List<Activity> getAllActivities() {
		List<Activity> activities = new ArrayList<>();
		for(Activity a : activityRepository.findAll()) {
			activities.add(a);
		}
		return activities;
	}

}
