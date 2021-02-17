//package com.eh.exam.dev.graphql.beans.mutation;
//
//import java.util.Date;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.stereotype.Component;
//
//import com.eh.exam.dev.util.DateUtil;
//import com.eh.exam.dev.util.graphql.Mutation;
//
///**
// * @author   Md. Emran Hossain <emranhos1@gmail.com>
// * @version  1.0.00 EH
// * @since    1.0.00 EH
// */
//@Component
//public class RootMutation extends Mutation {
//    private static Logger LOG = LoggerFactory.getLogger(RootMutation.class);
//
//    public String insertCheck(String name) {
//        String time = DateUtil.format(new Date(), DateUtil.ISO_DATE);
//        String hello = String.format("%s => Insert By, %s!", time, name);
//        LOG.info(hello);
//        return hello;
//    }
//}
