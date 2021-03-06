package app.mytraveltemplate.activity;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityRepository extends CrudRepository<Activity, Integer> {
	List<Activity> findAllByCity(String city);
	List<Activity> findByCityAndTimeOfDayAndTypeAndBudgetAndPaceAndSites(String city, String timeOfDay, String type, String budget, String pace, String sites);
}
