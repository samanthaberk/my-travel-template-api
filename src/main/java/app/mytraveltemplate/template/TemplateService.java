package app.mytraveltemplate.template;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TemplateService {
	
	@Autowired
	private TemplateRepository templateRepository;

	
	public List<Template> getAllTemplates() {
		List<Template> templates = new ArrayList<>();
		for(Template t : templateRepository.findAll()) {
			templates.add(t);
		}
		return templates;
	}
	
	public Template getTemplate(Integer id) {
		return templateRepository.findOne(id);
	}
	
	public List<Template> findByDurationAndTravelertype(int duration, String travelertype) {
		List<Template> templates = new ArrayList<>();
		for(Template t : templateRepository.findAll()) {
			if(t.getDuration().equals(duration) && t.getTravelertype().equals(travelertype)) {
			 templates.add(t);
			}
		}
		return templates;
	}

}

