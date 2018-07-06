package app.mytraveltemplate.template;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface TemplateRepository extends CrudRepository<Template, Integer> {
	List<Template> findAllByDuration(Integer duration);
	
}
