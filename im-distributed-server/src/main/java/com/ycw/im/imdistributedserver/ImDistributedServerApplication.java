package com.ycw.im.imdistributedserver;

import com.ycw.im.imdistributedserver.config.AppConfiguration;
import com.ycw.im.imdistributedserver.tool.RegistorZkTool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.net.InetAddress;

@SpringBootApplication
public class ImDistributedServerApplication implements CommandLineRunner {

    private final static Logger LOGGER = LoggerFactory.getLogger(ImDistributedServerApplication.class);

    @Autowired
    private AppConfiguration appConfiguration ;

    @Value("${server.port}")
    private int httpPort ;

    public static void main(String[] args) {
        SpringApplication.run(ImDistributedServerApplication.class, args);
        LOGGER.info("服务端开始启动");
    }


    @Override
    public void run(String... args) throws Exception {
        String localAdree = InetAddress.getLocalHost().getHostAddress();
        Thread thread = new Thread(new RegistorZkTool(localAdree,appConfiguration.getImServerPort(),httpPort));
        thread.setName("registry-zk");
        thread.start();
;    }
}
