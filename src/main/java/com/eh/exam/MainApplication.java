package com.eh.exam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.eh.exam.dev.util.PropertyUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * @author   Md. Emran Hossain <emranhos1@gmail.com>
 * @version  1.0.00 EH
 * @since    1.0.00 EH
 */
@EnableScheduling
@SpringBootApplication
@ComponentScan({"com.eh.exam.config"})
public class MainApplication {

    private static final Logger LOG = LoggerFactory.getLogger(MainApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
        LOG.info("START UP MASSAGE :: {}", PropertyUtil.WELCOME);
        LOG.info("Check URL :: {}", PropertyUtil.URL);
    }
}
