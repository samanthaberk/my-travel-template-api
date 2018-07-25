package app.mytraveltemplate.tag;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.mytraveltemplate.activity.Activity;

@RestController
@CrossOrigin(origins = "*")
public class TagController {
	
	@Autowired
	private TagService tagService;
	
	@RequestMapping("/tags")
	public List<Tag> getAllTags()  {
		return tagService.getAllTags();

	}
	
	@RequestMapping(value = "/tags/{id}/activities")
	public ResponseEntity<Collection<Activity>> getTagActivities(@PathVariable Integer id) {
		Tag tag = tagService.findOne(id);

		if (tag != null) {
			return new ResponseEntity<>(tag.getActivities(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}

}
