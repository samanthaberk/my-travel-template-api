package app.mytraveltemplate.activity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
	
	//Helper function to find all activities in a city
	public List<Activity> findActivitiesInCity(String city) {
		List<Activity> activities = activityRepository.findAllByCity(city);
		return activities;
	}
	
	//Helper function to get tags for a given activity
	private List<String> getTagsForActivity(Activity activity) {
		List<Tag> tags = activity.getTags();
		List<String> tagnames = new ArrayList<>();
		for ( Tag t : tags ) { 
			tagnames.add(t.getTagname());
		}
		return tagnames;
	}
		
	
	//Helper Function to get percentage overlap between user preferences and activity tags
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

	public List<Activity> getActivitiesForTemplate(UserAnswers userAnswers) {
		Template template = templateRepository.findOne(userAnswers.getTemplateId()); //Find template passed in w/ user answers
		String cities = template.getContent(); //Isolate cities from template 
		List<String> citiesArray = Arrays.asList(cities.split("\\s*,\\s*")); //Shovel cities into an Array to iterate through them
		
		//define variables to pass in for timeOfDay depending on place in array
		String morning = "morning"; 
		String afternoon = "afternoon";
		String evening = "evening";
		
		//get parameters for questions with only 1 possible answer
		String type = userAnswers.getType();
		String budget = userAnswers.getBudget();
		String pace = userAnswers.getPace();
		String sites = userAnswers.getSites();
		
		//Initialize an empty list to store the activities that will be returned
		List<Activity> activities = new ArrayList<>();
		
		//Initialize an empty list and fill with parameters from user that have many answers
		List<String> userInputList = new ArrayList<>();
		userInputList.addAll(userAnswers.getCityTravel());
		userInputList.addAll(userAnswers.getInterests());
		userInputList.addAll(userAnswers.getEntertainment());
		
		//filter activities for each city in the itinerary template
		for (int i = 0; i < citiesArray.size(); i++ ) {
			
			if(i == 0) {
				List<Activity> filteredActivities = activityRepository.findByCityAndTimeOfDayAndTypeAndBudgetAndPaceAndSites(
						citiesArray.get(i), 
						evening, 
						type, 
						budget,
						pace,
						sites); 

				double percentage=0; //set counter to keep track over percentage match between user preferences and a given activity
				Activity bestActivityMatch = null;
				
				for ( Activity a : filteredActivities ) {
				//remove activity and continue if it's already been chosen
					if (activities.contains(a)) {
						 continue;
					 }
			
				//get tags for the activity		
				List<String> tagnames = getTagsForActivity(a);
				
				double currentPercentage = getPercentage(userInputList, tagnames);
				if (currentPercentage > percentage) {
					percentage = currentPercentage;
					bestActivityMatch = a;
				}				
			}	
				
				activities.add(bestActivityMatch);
				
			} else if (i == citiesArray.size()-1) {
				List<Activity> filteredActivities = activityRepository.findByCityAndTimeOfDayAndTypeAndBudgetAndPaceAndSites(
						citiesArray.get(i), 
						morning, 
						type, 
						budget,
						pace,
						sites); 

				double percentage=0; //set counter to keep track over percentage match between user preferences and a given activity
				Activity bestActivityMatch = null;
				
				for ( Activity a : filteredActivities ) {
				//remove activity and continue if it's already been chosen
					if (activities.contains(a)) {
						 continue;
					 }
			
				//get tags for the activity		
				List<String> tagnames = getTagsForActivity(a);
				
				double currentPercentage = getPercentage(userInputList, tagnames);
				if (currentPercentage > percentage) {
					percentage = currentPercentage;
					bestActivityMatch = a;
				}				
			}	
				
				activities.add(bestActivityMatch);

			} else {
				//get morning activity
				List<Activity> filteredActivities = activityRepository.findByCityAndTimeOfDayAndTypeAndBudgetAndPaceAndSites(
						citiesArray.get(i), 
						morning, 
						type, 
						budget,
						pace,
						sites); 

				double percentage=0;
				Activity bestMorningActivityMatch = null;
				
				for ( Activity a : filteredActivities ) {
					if (activities.contains(a)) {
						 continue;
					 }
			
				List<String> tagnames = getTagsForActivity(a);
				
				double currentPercentage = getPercentage(userInputList, tagnames);
				if (currentPercentage > percentage) {
					percentage = currentPercentage;
					bestMorningActivityMatch = a;
				}				
			}	
				
				activities.add(bestMorningActivityMatch);
				
				//get afternooon activity
				filteredActivities = activityRepository.findByCityAndTimeOfDayAndTypeAndBudgetAndPaceAndSites(
						citiesArray.get(i), 
						afternoon, 
						type, 
						budget,
						pace,
						sites); 

				percentage=0; 
				Activity bestAfternoonActivityMatch = null;
				
				for ( Activity a : filteredActivities ) {
					if (activities.contains(a)) {
						 continue;
					 }
			
				List<String> tagnames = getTagsForActivity(a);
				
				double currentPercentage = getPercentage(userInputList, tagnames);
				if (currentPercentage > percentage) {
					percentage = currentPercentage;
					bestAfternoonActivityMatch = a;
				}				
			}	
				
				activities.add(bestAfternoonActivityMatch);
				
				//get evening activity
				filteredActivities = activityRepository.findByCityAndTimeOfDayAndTypeAndBudgetAndPaceAndSites(
						citiesArray.get(i), 
						evening, 
						type, 
						budget,
						pace,
						sites); 

				percentage=0; 
				Activity bestEveningActivityMatch = null;
				
				for ( Activity a : filteredActivities ) {
					if (activities.contains(a)) {
						 continue;
					 }
			
				//get tags for the activity		
				List<String> tagnames = getTagsForActivity(a);
				
				double currentPercentage = getPercentage(userInputList, tagnames);
				if (currentPercentage > percentage) {
					percentage = currentPercentage;
					bestEveningActivityMatch = a;
				}				
			}	
				
				activities.add(bestEveningActivityMatch);
			}
		}
		return activities;
	}
}


//Activity best = a.stream()
//.filter(activity -> !activities.contains(activity))
//.sorted(Comparator.comparingDouble(activity -> getPercentage(userInputList, activity.getTags().stream().map(tag -> tag.getTagname()).collect(Collectors.toList()))))
//.sorted(Collections.reverseOrder())
//.findFirst().get();

