package com.sample;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;

public class Globals {

    public static String htmlE(String x) {
        return x.replace("&", "&amp;").replace("<", "&lt;")
                .replaceAll("(?m)^ | $|( ) ", "$1&nbsp;").replaceAll("\n|\r\n?", "<br/>");
    }

    public static String attrE(String x) {
        return x.replace("&", "&amp;").replace("\"", "&quot;");
    }

    public static void respondPlain(HttpServletResponse resp, int statusCode, boolean json, String write) throws IOException {
        resp.setStatus(statusCode);
        resp.setHeader("Content-Type", json ? "application/json" : "text/plain; charset=UTF-8");
        try (Writer writer = resp.getWriter()) {
            writer.write(write);
        }
    }

}
