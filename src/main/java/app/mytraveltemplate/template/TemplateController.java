package app.mytraveltemplate.template;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class TemplateController {
	
	@Autowired
	private TemplateService templateService;
	
	@RequestMapping("/templates")
	@PostMapping
	public List<Template> getAllTemplates()  {
		return templateService.getAllTemplates();
	}
	
	@RequestMapping("templates/duration/{duration}/travelers/{travelerType}/pace/{pace}/transport/{transport}")
		public Template filterTemplates(@PathVariable String duration, @PathVariable String travelerType, @PathVariable String pace, @PathVariable String transport) {
		return templateService.filterTemplates(duration, travelerType, pace, transport);
	}
	
	

}
