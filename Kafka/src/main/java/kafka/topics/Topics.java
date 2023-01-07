package main.java.kafka.topics;

public class Topics {

//    public static final String RESERVATION_TOPIC = "reservations";
//    public static final String CONSUMER_GROUP_NAME = "reservationsconsumer";
//
//    public static void createTopic() throws InterruptedException {
//        Properties properties = new Properties();
//        int partitionsNumber = 3;
//        short replicationFactor = 3;
//
//        properties.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, "kafka1:9192,kafka1:9292,kafka1:9392");
//
//        try (Admin admin = Admin.create(properties)) {
//            NewTopic newTopic = new NewTopic(Topics.RESERVATION_TOPIC, partitionsNumber, replicationFactor);
//            CreateTopicsOptions options = new CreateTopicsOptions()
//                    .timeoutMs(1000)
//                    .validateOnly(false)
//                    .retryOnQuotaViolation(true);
//            CreateTopicsResult result = admin.createTopics(List.of(newTopic), options);
//            KafkaFuture<Void> futureResult = result.values().get(Topics.RESERVATION_TOPIC);
//            futureResult.get();
//        } catch (ExecutionException e) {
//            throw new RuntimeException(e);
//        } catch (InterruptedException e) {
//            throw new TopicExistsException(e.getMessage());
//        }
//
//    }
}
