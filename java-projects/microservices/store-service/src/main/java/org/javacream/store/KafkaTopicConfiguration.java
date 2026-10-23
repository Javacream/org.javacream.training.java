package org.javacream.store;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration public class KafkaTopicConfiguration {
 @Bean NewTopic stockChangedTopic(){return new NewTopic("store.stock.changed",1,(short)1);}
}
