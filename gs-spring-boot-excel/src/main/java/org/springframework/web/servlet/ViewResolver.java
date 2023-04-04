package org.springframework.web.servlet;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2019/9/28
 */
@Data
@AllArgsConstructor
public class ViewResolver {
    private String viewName;
    private File template;

    protected String parse(ModelAndView mv) throws IOException {
        Map model = mv.getModel();

        RandomAccessFile ra = new RandomAccessFile(this.getTemplate(), "r");
        StringBuffer ba = new StringBuffer();
        String line;
        while (null != (line = ra.readLine())) {
            Matcher march = march(line);
            while (march.find()) {
                for (int idx = 0; idx < march.groupCount(); idx++) {
                    String paramName = march.group(idx).replaceAll("@\\{","").replaceAll("\\}","");
                    Object value = model.get(paramName);
                    if (value != null) {
                        line=line.replaceAll("@\\{"+paramName+"\\}" , value.toString());
                    }
                }
            }
            ba.append(line);
        }
        return ba.toString();
    }

    private Matcher march(String str) {
        Pattern pattern = Pattern.compile("@\\{(.+?)\\}", Pattern.CASE_INSENSITIVE);
        return pattern.matcher(str);
    }
}
