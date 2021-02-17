//package com.eh.exam.dev.graphql.beans.query;
//
//import java.util.List;
//import java.util.Map;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import org.springframework.util.StringUtils;
//
//import com.eh.exam.dev.model.Gender;
//import com.eh.exam.dev.service.GenderService;
//import com.eh.exam.dev.util.OffsetUtil;
//import com.eh.exam.dev.util.graphql.Query;
//
///**
// * @author   Md. Emran Hossain <emranhos1@gmail.com>
// * @version  1.0.00 EH
// * @since    1.0.00 EH
// */
//@Component
//public class GenderQuery extends Query {
//    @SuppressWarnings("unused")
//    private static Logger LOG = LoggerFactory.getLogger(GenderQuery.class);
//
//    @Autowired
//    GenderService service;
//
//    public List<Gender> selectAllGender() {
//        return service.selectAll();
//    }
//
//    public Gender selectGenderByCode(String code) {
//        if (!StringUtils.isEmpty(code)) {
//            return service.selectByCode(code);
//        }
//        return null;
//    }
//
//    public Long countAllGender() {
//        return service.countAll();
//    }
//
//    public Long searchGenderPageCount(int size) {
//        Long noOfRecords = service.countAll();
//        Long pages = OffsetUtil.getPageCount(noOfRecords, size);
//        return pages;
//    }
//
//    public List<Gender> searchGenderByOffset(int page, int size) {
//        Map<String, Object> param = OffsetUtil.offsetifyByPageAndSize(page, size);
//        return service.searchByOffset(param);
//    }
//}
