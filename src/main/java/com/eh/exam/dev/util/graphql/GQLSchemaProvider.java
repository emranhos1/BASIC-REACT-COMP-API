//package com.eh.exam.dev.util.graphql;
//
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.StringWriter;
//import java.nio.charset.StandardCharsets;
//import java.util.Arrays;
//import java.util.List;
//import java.util.stream.Collectors;
//
//import org.apache.commons.io.IOUtils;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.ApplicationContext;
//import org.springframework.core.io.Resource;
//
//import com.oembedler.moon.graphql.boot.SchemaStringProvider;
///**
// * @author   Md. Emran Hossain <emranhos1@gmail.com>
// * @version  1.0.00 EH
// * @since    1.0.00 EH
// */
//public class GQLSchemaProvider implements SchemaStringProvider {
//
//    private static final Logger LOG = LoggerFactory.getLogger(GQLSchemaProvider.class);
//
//    @Autowired
//    private ApplicationContext applicationContext;
//
//    @Value("${graphql.schema-locations:classpath*:/META-INF/graphql/**/*.graphqls}")
//    private String graphqlSchemaLocations;
//
//    @Override
//    public List<String> schemaStrings() throws IOException {
//        LOG.info("GraphQL Schema Locations: \"{}\"", graphqlSchemaLocations);
//        Resource[] resources = applicationContext.getResources(graphqlSchemaLocations);
//        if (resources.length <= 0) {
//            String format  = "GraphQL Schema Not Found! Please check on \"%s\"";
//            String message = String.format(format, graphqlSchemaLocations);
//            throw new IllegalStateException(message);
//        }
//
//        return Arrays.stream(resources).map(this::readSchema).collect(Collectors.toList());
//    }
//
//    private String readSchema(Resource resource) {
//        StringWriter writer = new StringWriter();
//        try (InputStream inputStream = resource.getInputStream()) {
//            IOUtils.copy(inputStream, writer, StandardCharsets.UTF_8);
//        } catch (IOException e) {
//            String format  = "GraphQL Schema Not Readable! Please check on \"%s\"";
//            String message = String.format(format, resource);
//            throw new IllegalStateException(message, e);
//        }
//        return writer.toString();
//    }
//
//}