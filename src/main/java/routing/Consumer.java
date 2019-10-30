package routing;


import com.rabbitmq.client.*;

import javax.management.Query;
import java.io.IOException;
import java.util.Queue;
import java.util.concurrent.TimeoutException;

public class Consumer {
    public static void main(String[] args) throws IOException, TimeoutException {
            ConnectionFactory cf = new ConnectionFactory();
            Connection cn = cf.newConnection();
            Channel ch =cn.createChannel();
            String queueName = ch.queueDeclare().getQueue();
            ch.exchangeDeclare("sami-ex", BuiltinExchangeType.DIRECT);
            ch.queueBind(queueName,"sami-ex","sadad");
            ch.basicConsume(queueName, true, new com.rabbitmq.client.Consumer() {
                public void handleConsumeOk(String consumerTag) {

                }

                public void handleCancelOk(String consumerTag) {

                }

                public void handleCancel(String consumerTag) throws IOException {

                }

                public void handleShutdownSignal(String consumerTag, ShutdownSignalException sig) {

                }

                public void handleRecoverOk(String consumerTag) {

                }

                public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                    String message = new String(body, "UTF-8");
                    System.out.println(" [x] Received '" +
                            envelope.getRoutingKey() + "':'" + message + "'");
                    System.out.println(envelope);
                }
            });


    }
}
