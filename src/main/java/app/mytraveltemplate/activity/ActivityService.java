package app.mytraveltemplate.activity;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.mytraveltemplate.tag.Tag;

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
	
	//filter activities by city
	public List<Activity> filterActivitiesByCity(String city) {
		List<Activity> activities = new ArrayList<>();
		for(Activity a : activityRepository.findAll()) {
			if (a.getCity().equals(city) ) {
				activities.add(a);
			}
		}
		return activities;
	}

	//helper function to filter for timeOfDay
	public Boolean paramMatch(Tag tag, String param) {
		if (tag.tagname.equals(param)) {
			return true;
		} else {
			return false;
		}
	}
	
	// filter for timeOfDay, pace, type, budget, and sites
	public List<Activity> filterActivitiesInCity(String city, String timeOfDay) {
		List<Activity> activities = filterActivitiesByCity(city); // isolate activities for that city
		List<Activity> filteredActivities = new ArrayList<>(); // initialize list of activities to filter and return

		for ( Activity a : activities ) {
			List<Tag> tags = a.getTags(); // get tags for each activity
			
			for(int i = 0; i<tags.size(); i++) {
				if ( paramMatch(tags.get(i), timeOfDay) ) {
					filteredActivities.add(a);
				}
			}

		}
		return filteredActivities;
	}
}
