package com.util.json;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @Description: JacksonObjectMapper
 * @Author: lin.shi
 * @CreateTime: 2017-04-20 09:17
 */
public class JacksonObjectMapper extends ObjectMapper {
    private Log logger = LogFactory.getLog(JacksonObjectMapper.class);

    public JacksonObjectMapper() {

        if (logger.isDebugEnabled()) {
            // 在调试模式下,格式化输出JSON
            configure(SerializationFeature.INDENT_OUTPUT, true);
        }

        configure(SerializationFeature.WRAP_ROOT_VALUE, false);

        // 不予输出null字段
        setSerializationInclusion(JsonInclude.Include.NON_NULL);

        configure(SerializationFeature.WRITE_NULL_MAP_VALUES, false);

        // 当数组中只有一个元素时，也按照数组输出
        configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);

        // 时间格式化输出
       // setDateFormat(new SimpleDateFormat("yyyy-MM-dd"));
      /*  CustomSerializerFactory factory = new CustomSerializerFactory();
        factory.addGenericMapping(Date.class, new JsonSerializer<Date>() {
            @Override
            public void serialize(Date date, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonProcessingException {
                long times = date.getTime() / 1000;
                jsonGenerator.writeString(times+"");
            }
        });
*/
    }
}
