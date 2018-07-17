package app.mytraveltemplate.activity;

import java.util.ArrayList;
import java.util.List;

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

//	public List<Activity> filterActivities(ActivityQuery query) {
//		List<Activity> activities = new ArrayList<>();
//		
//		for(Activity a : activityRepository.findAll()) {
//			// find activities for specified city
//			if(
//				a.getCity().equals(query.getCity()) 
//			  )
//				{
//					//examine tags for activities in that city
//					for(Tag t : tagRepository.findAll()) 
//					{
//					//does the tag we're looking at match a parameter in the query?
//						if( 
//							t.tagname.equals(query.getTimeOfDay()) 
//							|| t.tagname.equals(query.getPace())
//							|| t.tagname.equals(query.getType())
//							|| t.tagname.equals(query.getBudget())
//							|| t.tagname.equals(query.getSites())
//							|| query.getInterests().contains(t.tagname)
//							|| query.getEntertainment().contains(t.tagname)
//							|| query.getTransport().contains(t.tagname)
//							)
//							
//							//if it does, add the activity to the list
//								{
//									activities.add(a);
//									
//								}
//					}
//				}
//			}
//		return activities;
//	}
	
	// filter for timeOfDay, pace, type, budget, and sites
	public List<Tag> filterActivitiesInCity(String city, String timeOfDay) {
		List<Activity> activities = filterActivitiesByCity(city); // isolate activities for that city
		List<Tag> tags = new ArrayList<>(); //initialize a list of each activity's tag
		
		for (Activity a : activities ) {
			tags.addAll(a.getTags());
		}
		return tags;
	}
}
