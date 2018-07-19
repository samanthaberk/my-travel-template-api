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
		List<Activity> activities = activityRepository.findAllByCity(city);
		return activities;
	}

	//helper function to filter for single params
	public Boolean paramMatch(String tag, String param) {
		if (tag.equals(param)) {
			return true;
		} else {
			return false;
		}
	}
	
	//get percentage overlap between user input and choices
	public double getPercentage(List<String> userInputList, List<String> tagnames ) {
		  double percentage=0;
		  for(int i = 0; i < userInputList.size(); i++) {
		    for(int j = 0; j < tagnames.size(); j++) {
		      if(userInputList.get(i).equals(tagnames.get(j))) { 
		        percentage++;
		      }
		    }
		  }
		  return (percentage/userInputList.size())*100; 
		} 
	
	// filter for timeOfDay, pace, type, budget, and sites
	public Activity filterActivitiesInCity(String city, String timeOfDay, String type, String budget, String pace, String sites, ArrayList<String> internalTravel, ArrayList<String> interests, ArrayList<String> entertainment) {
		List<Activity> activities = activityRepository.findByCityAndTimeOfDayAndTypeAndBudgetAndPaceAndSites(city, timeOfDay, type, budget, pace, sites); // isolate activities for that city
		Activity activity = activities.get(0);
		System.out.println(activities.toString());
		
		List<String> userInputList = new ArrayList<>();
		userInputList.addAll(internalTravel);
		userInputList.addAll(interests);
		userInputList.addAll(entertainment);
		System.out.println(userInputList.toString());
		double percentage=0; //set counter 

		for ( Activity a : activities ) {
			List<Tag> tags = a.getTags(); //get tags for each activity
			
			List<String> tagnames = new ArrayList<>();//isolate tag name
			for ( Tag t : tags ) { 
				tagnames.add(t.getTagname());
			}
			System.out.println(tagnames);
			double currentPercentage = getPercentage(userInputList, tagnames);
			System.out.println(currentPercentage);
			System.out.println(percentage);
			if (currentPercentage > percentage) {
				percentage = currentPercentage;
				activity = a;
			}
			
		}
		System.out.print(activity);
		return activity;
	}
}
