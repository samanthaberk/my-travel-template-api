package app.mytraveltemplate.tag;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TagController {
	
	@Autowired
	private TagService templateService;
	
	@RequestMapping("/tags")
	public List<Tag> getAllTags()  {
		return templateService.getAllTags();

	}

}
