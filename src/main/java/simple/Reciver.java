package simple;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Reciver {
    public static void main(String[] args) {
        try {
            ConnectionFactory factory = new ConnectionFactory();
            factory.setHost("localhost");
            Connection connection = factory.newConnection();
            Channel channel = connection.createChannel();

            channel.queueDeclare("products_queue",false,false,false,null);
            channel.basicConsume("products_queue", true, new Consumer() {
                public void handleConsumeOk(String s) {

                }

                public void handleCancelOk(String s) {

                }

                public void handleCancel(String s) throws IOException {

                }

                public void handleShutdownSignal(String s, ShutdownSignalException e) {

                }

                public void handleRecoverOk(String s) {

                }

                public void handleDelivery(String s, Envelope envelope, AMQP.BasicProperties basicProperties, byte[] bytes) throws IOException {
                String message = new String(bytes,"UTF-8");
                    System.out.printf("message: "+ message);
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }
}
