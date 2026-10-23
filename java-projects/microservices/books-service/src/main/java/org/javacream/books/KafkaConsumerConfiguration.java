package org.javacream.books;
import java.util.HashMap;
import java.util.Map;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.*;
import org.springframework.kafka.support.serializer.JsonDeserializer;
@Configuration
public class KafkaConsumerConfiguration {
 @Bean public ConsumerFactory<String,StockChangedEvent> consumerFactory(@Value("${spring.kafka.bootstrap-servers}") String servers){
  Map<String,Object> config=new HashMap<>();
  config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,servers);
  config.put(ConsumerConfig.GROUP_ID_CONFIG,"books-service");
  config.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG,"earliest");
  config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,StringDeserializer.class);
  config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,JsonDeserializer.class);
  config.put(JsonDeserializer.VALUE_DEFAULT_TYPE,StockChangedEvent.class.getName());
  config.put(JsonDeserializer.TRUSTED_PACKAGES,"org.javacream.books");
  config.put(JsonDeserializer.USE_TYPE_INFO_HEADERS,false);
  return new DefaultKafkaConsumerFactory<>(config);
 }
 @Bean public ConcurrentKafkaListenerContainerFactory<String,StockChangedEvent> kafkaListenerContainerFactory(ConsumerFactory<String,StockChangedEvent> factory){
  var result=new ConcurrentKafkaListenerContainerFactory<String,StockChangedEvent>();result.setConsumerFactory(factory);return result;
 }
}
