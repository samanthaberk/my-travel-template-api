package app.mytraveltemplate.tag;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TagService {
	
	@Autowired
	private TagRepository tagRepository;

	
	public List<Tag> getAllTags() {
		List<Tag> tags = new ArrayList<>();
		for(Tag t : tagRepository.findAll()) {
			tags.add(t);
		}
		return tags;
	}

}

