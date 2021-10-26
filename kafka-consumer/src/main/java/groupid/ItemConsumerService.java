package groupid;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ItemConsumerService {
	
	@KafkaListener(topics = "topic1")
	public void printItem(Item item) {
		System.out.println(item.getId() + " " + item.getValue());
	}

}
