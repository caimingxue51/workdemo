package com.test.demo.mq.rocket;


import com.alibaba.rocketmq.client.producer.DefaultMQProducer;
import com.alibaba.rocketmq.client.producer.SendResult;
import com.alibaba.rocketmq.common.message.Message;
import com.alibaba.rocketmq.remoting.common.RemotingHelper;

public class SyncProducer {

    public static void main(String[] args) throws Exception {
        //Instantiate with a producer group name.
        DefaultMQProducer producer = new
                DefaultMQProducer("ccxProducer");
        // Specify name server addresses.
        producer.setNamesrvAddr("172.16.23.35:9876");
        //Launch the instance.
        producer.start();
        String tag = "";
        for (int i = 0; i < 100; i++) {
            //Create a message instance, specifying topic, tag and message body.
            tag =  (i%3)==0?"TagB":"TagA";
            Message msg = new Message("OSS_TEST" /* Topic */,
                    tag /* Tag */,
                    ("Hello RocketMQ " +
                            i).getBytes(RemotingHelper.DEFAULT_CHARSET) /* Message body */
            );
            //Call send message to deliver message to one of brokers.
            SendResult sendResult = producer.send(msg);
            System.out.printf("%s%n", sendResult);
        }
        //Shut down once the producer instance is not longer in use.
        producer.shutdown();
    }
}
