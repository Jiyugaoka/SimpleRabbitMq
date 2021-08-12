package org.consumer;

import com.alibaba.fastjson.JSONObject;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {
    @RabbitListener(queues = "Direct_Queue")
    public void getUser(Message message) {
        JSONObject js = JSONObject.parseObject(new String(message.getBody()));
        User user = js.getObject("user", User.class);
        System.out.println(user.toString());
        System.out.println(js.getString("extra"));
    }
}
