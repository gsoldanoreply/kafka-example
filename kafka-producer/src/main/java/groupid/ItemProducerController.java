package groupid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemProducerController {
	
	@Autowired
	private KafkaTemplate<String, Object> kafkaTemplate;
	
	@PostMapping("/postitem")
	public void insertItem(@RequestBody Item item) {
		kafkaTemplate.send("topic1", item);
	}

}
