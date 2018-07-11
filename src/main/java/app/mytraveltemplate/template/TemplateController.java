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
	
	@RequestMapping("templates/duration/{duration}/travelers/{travelerType}/pace/{pace}/transport/{transport}")
		public List<Template> filterTemplates(@PathVariable int duration, @PathVariable String travelerType, @PathVariable String pace, @PathVariable String transport) {
		return templateService.filterTemplates(duration, travelerType, pace, transport);
	}

}
