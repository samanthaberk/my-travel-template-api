package app.mytraveltemplate.template;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TemplateRepository extends CrudRepository<Template, Integer> {
	List<Template> findByDurationAndTravelertype(Integer duration, String travelertype);
	
}
