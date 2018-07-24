package app.mytraveltemplate.template;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TemplateRepository extends CrudRepository<Template, Integer> {
	Template findByDurationAndTravelertype(Integer duration, String travelertype);
	
}
