package org.productor;

import com.alibaba.fastjson.JSONObject;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/xixixi")
public class Productor {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @GetMapping(value = "/gen")
    public String genUser() {
        User newUser = new User("zhang3", "male", 27);
        rabbitTemplate.setMessageConverter(new Jackson2JsonMessageConverter());
        JSONObject js = new JSONObject();
        js.put("user", newUser);
        js.put("extra", "xixixi");
        rabbitTemplate.convertAndSend("Direct_Exchange", "Direct_Routing", js);
        System.out.println("发送user成功。");
        return "Generated a new org.productor.User!";
    }
}
