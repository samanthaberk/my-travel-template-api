package app.mytraveltemplate.activity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.mytraveltemplate.tag.Tag;
import app.mytraveltemplate.template.Template;
import app.mytraveltemplate.template.TemplateRepository;

@Service
public class ActivityService {
	
	@Autowired
	private ActivityRepository activityRepository;
	
	@Autowired
	private TemplateRepository templateRepository;
	
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
	private Boolean paramMatch(String tag, String param) {
		if (tag.equals(param)) {
			return true;
		} else {
			return false;
		}
	}
	
	//get percentage overlap between user input and choices
	private double getPercentage(List<String> userInputList, List<String> tagnames ) {
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
	
	// filter for timeOfDay, pace, travelParty, budget, and sites
//	public Activity filterActivitiesInCity(String city, String timeOfDay, String travelParty, String budget, String pace, String sites, ArrayList<String> cityTravel, ArrayList<String> interests, ArrayList<String> entertainment, ArrayList<String> activityList) {
//		List<Activity> activities = activityRepository.findByCityAndTimeOfDayAndTypeAndBudgetAndPaceAndSites(city, timeOfDay, travelParty, budget, pace, sites); // isolate activities for that city
//		Activity activity = activities.get(0);
//		System.out.println(activityList);
//		
//		List<String> userInputList = new ArrayList<>(); //array list to keep track of user preferences
//		List<String> addedActivities = new ArrayList<>(); // array list to keep track of which activities have already been added
//		System.out.println("addedActivities before: " + addedActivities);
//
//		//add user preferences to the list to compare with each activity's tag
//		userInputList.addAll(cityTravel);
//		userInputList.addAll(interests);
//		userInputList.addAll(entertainment);
//		
//		//add the activities already used to the list so we don't select the same activity more than once
//		addedActivities.addAll(activityList);
//		
//		double percentage=0; //set counter to keep track over percentage match between user preferences and a given activity
//
//		for ( Activity a : activities ) {
//			//remove activity and continue if it's already been chosen
//				 String currentId = Integer.toString(a.getId());
//				System.out.println("currentId: " + currentId);
//
//				if (addedActivities.contains(currentId)) {
//					 continue;
//				 }
//					
//			List<Tag> tags = a.getTags(); //get tags for each activity
//			
//			List<String> tagnames = new ArrayList<>();//isolate tag name
//			for ( Tag t : tags ) { 
//				tagnames.add(t.getTagname());
//			}
//			double currentPercentage = getPercentage(userInputList, tagnames);
//			if (currentPercentage > percentage) {
//				percentage = currentPercentage;
//				activity = a;
//			}
//			
//		}
//		return activity;
//	}

	public List<Activity> getActivitiesForTemplate(UserAnswers userAnswers) {
		Template template = templateRepository.findOne(userAnswers.getTemplateId());
		String cities = template.getContent();
		List<String> citiesArray = Arrays.asList(cities.split("\\s*,\\s*"));
		
		String morning = "morning"; //enumerable?
		String afternoon = "afternoon";
		String evening = "evening";
		
		String type = userAnswers.getType();
		String budget = userAnswers.getBudget();
		String pace = userAnswers.getPace();
		String sites = userAnswers.getSites();
		
		List<Activity> activities = new ArrayList<>();
		
		List<String> userInputList = new ArrayList<>();
		userInputList.addAll(userAnswers.getCityTravel());
		userInputList.addAll(userAnswers.getInterests());
		userInputList.addAll(userAnswers.getEntertainment());
		
		for (int i = 0; i < citiesArray.size(); i++ ) {
			
			if(i == 0) {
				List<Activity> a = activityRepository.findByCityAndTimeOfDayAndTypeAndBudgetAndPaceAndSites(
						citiesArray.get(i), 
						evening, 
						type, 
						budget,
						pace,
						sites); 
				
				Activity best = a.stream()
						.filter(activity -> !activities.contains(activity))
						.sorted(Comparator.comparingDouble(activity -> getPercentage(userInputList, activity.getTags().stream().map(tag -> tag.getTagname()).collect(Collectors.toList()))))
						.sorted(Collections.reverseOrder())
						.findFirst().get();
				
				activities.add(best);
			} else if (i == citiesArray.size()-1) {
				List<Activity> a = activityRepository.findByCityAndTimeOfDayAndTypeAndBudgetAndPaceAndSites(
						citiesArray.get(i), 
						morning, 
						type, 
						budget,
						pace,
						sites); 
				
				Activity best = a.stream()
						.filter(activity -> !activities.contains(activity))
						.sorted(Comparator.comparingDouble(activity -> getPercentage(userInputList, activity.getTags().stream().map(tag -> tag.getTagname()).collect(Collectors.toList()))))
						.sorted(Collections.reverseOrder())
						.findFirst().get();
				
				activities.add(best);
			} else {
				List<Activity> morningActivity = activityRepository.findByCityAndTimeOfDayAndTypeAndBudgetAndPaceAndSites(
						citiesArray.get(i), 
						morning, 
						type, 
						budget,
						pace,
						sites); 
				
				Activity bestMorning = morningActivity.stream()
						.filter(activity -> !activities.contains(activity))
						.sorted(Comparator.comparingDouble(activity -> getPercentage(userInputList, activity.getTags().stream().map(tag -> tag.getTagname()).collect(Collectors.toList()))))
						.sorted(Collections.reverseOrder())
						.findFirst().get();
				
				activities.add(bestMorning);
				
				List<Activity> afternoonActivity = activityRepository.findByCityAndTimeOfDayAndTypeAndBudgetAndPaceAndSites(
						citiesArray.get(i), 
						afternoon, 
						type, 
						budget,
						pace,
						sites); 
				
				Activity bestAfternoon = afternoonActivity.stream()
						.filter(activity -> !activities.contains(activity))
						.sorted(Comparator.comparingDouble(activity -> getPercentage(userInputList, activity.getTags().stream().map(tag -> tag.getTagname()).collect(Collectors.toList()))))
						.sorted(Collections.reverseOrder())
						.findFirst().get();
				
				activities.add(bestAfternoon);
				
				List<Activity> eveningActivity = activityRepository.findByCityAndTimeOfDayAndTypeAndBudgetAndPaceAndSites(
						citiesArray.get(i), 
						afternoon, 
						type, 
						budget,
						pace,
						sites); 
				
				Activity bestEvening = eveningActivity.stream()
						.filter(activity -> !activities.contains(activity))
						.sorted(Comparator.comparingDouble(activity -> getPercentage(userInputList, activity.getTags().stream().map(tag -> tag.getTagname()).collect(Collectors.toList()))))
						.sorted(Collections.reverseOrder())
						.findFirst().get();
				
				activities.add(bestEvening);
			}
		}
		return activities;
	}
}
