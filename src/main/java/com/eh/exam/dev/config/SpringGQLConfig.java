//package com.eh.exam.dev.config;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//
//import com.eh.exam.dev.util.graphql.GQLSchemaProvider;
//import com.oembedler.moon.graphql.boot.SchemaStringProvider;
//
///**
// * @author   Md. Emran Hossain <emranhos1@gmail.com>
// * @version  1.0.00 EH
// * @since    1.0.00 EH
// */
//@Configuration
//@ComponentScan({"com.eh.exam.dev.graphql.beans"})
//public class SpringGQLConfig {
//
//    @SuppressWarnings("unused")
//    private static final Logger LOG = LoggerFactory.getLogger(SpringGQLConfig.class);
//
//    @Bean
//    public SchemaStringProvider schemaStringProvider() {
//        return new GQLSchemaProvider();
//    }
//}
