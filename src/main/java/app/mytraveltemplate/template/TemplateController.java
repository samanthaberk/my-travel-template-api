package app.mytraveltemplate.template;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TemplateController {
	
	@RequestMapping("/templates")
	public List<Template> getAllTemplates() {
		return Arrays.asList(
				new Template(
						1, 
						7, 
						"first-timer", 
						"average", 
						new ArrayList<String>(Arrays.asList("train", "plane")),
						new HashMap<String, String>(){{
                            put("day one", "Beijing");
                            put("day two", "Beijing");
                            put("day three", "Beijing");
                            put("day four", "Beijing");
                            put("day five", "Xian");
                            put("day six", "Xian");
                            put("day seven", "home");
                            }}						
					)
				);

	}


}
