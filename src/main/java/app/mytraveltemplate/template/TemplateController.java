package app.mytraveltemplate.template;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TemplateController {
	
	@Autowired
	private TemplateService templateService;
	
	@RequestMapping("/templates")
	public List<Template> getAllTemplates()  {
		return templateService.getAllTemplates();

	}
	
	@RequestMapping("/templates/{id}")
	public Template getTemplate(@PathVariable int id) {
		return templateService.getTemplate(id);
	}
	
	@RequestMapping("templates/duration/{duration}/{travelerType}")
		public List<Template> findByDurationAndTravelertype(@PathVariable int duration, @PathVariable String travelerType) {
		return templateService.findByDurationAndTravelertype(duration, travelerType);
	}

}
//
//public List<Template> findByDurationAndTravelertype(@PathVariable int duration, @PathVariable String travelertype) {
//	return templateService.findByDurationAndTravelertype(duration, travelertype);
