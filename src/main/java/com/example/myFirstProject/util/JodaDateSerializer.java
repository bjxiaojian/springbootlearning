package com.example.myFirstProject.util;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * Created by huadong.tang on 15/9/1.
 */
public class JodaDateSerializer extends StdSerializer<DateTime> {

//    private static final Logger logger = LoggerFactory.getLogger(JodaDateSerializer.class);

    protected JodaDateSerializer(Class<DateTime> t) {
        super(t);
    }

    @Override
    public void serialize(DateTime value, JsonGenerator jgen, SerializerProvider provider) throws IOException, JsonGenerationException {
        if ( value == null ) {
            jgen.writeString("null");

        } else {
            try {
                String str = DateTimeUtils.fmtYyyyMMddHHmmss(value);
                jgen.writeString(str);

            } catch (Exception e) {
//                logger.error("joda serialize error: ", e);
                jgen.writeString("unknown");
            }

        }
    }

}
