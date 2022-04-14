package com.tiaot33.wxmsnotify;

import com.github.shuaidd.autoconfigure.EnableWeChat;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@EnableWeChat
public class WxMsNotifyApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(WxMsNotifyApplication.class, args);
    }

}
