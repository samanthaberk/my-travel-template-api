package app.mytraveltemplate.template;

import java.util.ArrayList;
import java.util.Arrays;
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
			Arrays.asList(t.getTransport().split("\\s*,\\s*"));
			templates.add(t);
		}
		return templates;
	}
	
	public Template getTemplate(Integer id) {
		return templateRepository.findOne(id);
	}
	
	// CUSTOM QUERIES
	
	public List<Template> byDuration(int duration){
		return templateRepository.findAllByDuration(duration);
	}


}
