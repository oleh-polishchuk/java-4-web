package com.geekhub.lesson10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class Crawler {

    public String getContentByLink(String link) throws IOException {
        if (link.length() == 0) {
            return null;
        }

        StringBuilder content = new StringBuilder();

        URL url = new URL(link);
        InputStreamReader stream = new InputStreamReader(url.openStream());
        BufferedReader in = new BufferedReader(stream);

        String html;
        while ((html = in.readLine()) != null) {
            content.append(html);
        }
        in.close();

        return content.toString();
    }
}
