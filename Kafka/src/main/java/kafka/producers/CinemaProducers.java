package main.java.kafka.producers;

import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import model.Reservation;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.StringSerializer;
import org.apache.kafka.common.serialization.UUIDSerializer;
import org.json.JSONObject;


import static kafka.topics.Topics.RESERVATION_TOPIC;

public class CinemaProducers {

//    private KafkaProducer<UUID, String> producer;
//    private Jsonb jsonb = JsonbBuilder.create();
//
//    public CinemaProducer() throws ExecutionException, InterruptedException {
//        Properties producerConfig = new Properties();
//
//        producerConfig.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
//                UUIDSerializer.class.getName());
//        producerConfig.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
//                StringSerializer.class.getName());
//        producerConfig.put(ProducerConfig.CLIENT_ID_CONFIG, "local");
//        producerConfig.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,
//                "kafka1:9192,kafka2:9292,kafka3:9392");
////        producerConfig.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,
////                "kafka1:9192");
//        producerConfig.put(ProducerConfig.ENABLE_IDEMPOTENCE_CONFIG, true);
//        producerConfig.put(ProducerConfig.ACKS_CONFIG, "all");
//        this.producer = new KafkaProducer<>(producerConfig);
//    }
//
//    public void send(Reservation reservation) throws ExecutionException, InterruptedException {
//        ProducerRecord<UUID, String> record = new ProducerRecord<>(RESERVATION_TOPIC,
//                reservation.getId().getUuid(), jsonb.toJson(reservation));
//
//        this.producer.send(record, this::onCompletion);
//        System.out.println(new JSONObject(reservation));
//    }
//
//    private void onCompletion(RecordMetadata data, Exception exception) {
//        if (exception == null) {
//            System.out.println(data.offset());
//        } else {
//            System.out.println(exception);
//        }
//    }
//
//    public void close() {
//        this.producer.flush();
//        this.producer.close();
//    }
}
