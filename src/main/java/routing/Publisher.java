package routing;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Publisher {
    public static final  String MESSAGE = "sadad message";
    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory= new ConnectionFactory();
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        channel.exchangeDeclare("sami-ex", BuiltinExchangeType.DIRECT);
        channel.basicPublish("sami-ex","sadad",null, MESSAGE.getBytes());
        System.out.println("message sent:"+ MESSAGE);
        channel.close();
        connection.close();

    }
}
