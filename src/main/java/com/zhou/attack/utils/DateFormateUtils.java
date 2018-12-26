package com.zhou.attack.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by zhoumb on 2018/12/26
 */
public class DateFormateUtils {
    public static String format(Date date, FormatTemplate template) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(template.getFormat());
        return simpleDateFormat.format(date);
    }

    public static enum FormatTemplate {
        YMDHMS("yyyy-MM-dd HH:mm:ss.SSS");

        private String format;

        FormatTemplate(String format) {
            this.format = format;
        }

        public String getFormat() {
            return format;
        }

        public void setFormat(String format) {
            this.format = format;
        }
    }
}
