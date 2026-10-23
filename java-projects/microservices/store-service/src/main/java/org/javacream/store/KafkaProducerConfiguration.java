package org.javacream.store;
import java.util.HashMap;
import java.util.Map;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.*;
import org.springframework.kafka.support.serializer.JsonSerializer;
@Configuration
public class KafkaProducerConfiguration {
 @Bean public ProducerFactory<String,StockChangedEvent> producerFactory(@Value("${spring.kafka.bootstrap-servers}") String servers){
  Map<String,Object> config=new HashMap<>();config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,servers);
  config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,StringSerializer.class);
  config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,JsonSerializer.class);
  config.put(JsonSerializer.ADD_TYPE_INFO_HEADERS,false);
  return new DefaultKafkaProducerFactory<>(config);
 }
 @Bean public KafkaTemplate<String,StockChangedEvent> kafkaTemplate(ProducerFactory<String,StockChangedEvent> factory){return new KafkaTemplate<>(factory);}
}
