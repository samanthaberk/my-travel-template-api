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
			templates.add(t);
		}
		return templates;
	}
	
	public Template getTemplate(Integer id) {
		return templateRepository.findOne(id);
	}
	
	
	public Boolean TransportIntersection(List<String> arrayOne, List<String> arrayTwo) {		     
		for(int i = 0; i<arrayOne.size(); i++ ) {
			for(int j = 0; j<arrayTwo.size(); j++) {
				if(arrayOne.indexOf(i)==arrayTwo.indexOf(j)) {
					return true;
				}
			}
		}
		return false;
	}
	
	
	
	public List<Template> filterTemplates(int duration, String travelertype, String pace, String transport) {
		
		//get list of transport options user DOES NOT want passed in as params
		List<String> paramsTransportOptions = Arrays.asList(transport.split("\\s*,\\s*"));
		List<Template> templates = new ArrayList<>();
		
		for(Template t : templateRepository.findAll()) {
			//check for overlap between unwanted transport options and current template
			List<String> currentTransportOptions = Arrays.asList(t.getTransport().split("\\s*,\\s*"));
		
			if (TransportIntersection(currentTransportOptions, paramsTransportOptions)) {
				break;
			}

			//filter the rest of the params
			if(
					t.getDuration().equals(duration) 
					&& t.getTravelertype().equals(travelertype) 
					&& t.getPace().equals(pace)
				)
			{
			 templates.add(t);
			}
		}

		return templates;
	}

}

