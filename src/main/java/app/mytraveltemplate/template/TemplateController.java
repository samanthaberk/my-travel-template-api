package app.mytraveltemplate.template;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/templates")
public class TemplateController {
	
	@Autowired
	private TemplateService templateService;
	
	@RequestMapping("/")
	public List<Template> getAllTemplates() {
		return templateService.getAllTemplates();

	}
	
	@RequestMapping("/{id}")
	public Template getTemplate(@PathVariable int id) {
		return templateService.getTemplate(id);
	}
	
	@RequestMapping("/byduration/{duration}")
	public List<Template> byDuration(@PathVariable(value="duration") int duration) {
		return templateService.byDuration(duration);
	}
	

}
