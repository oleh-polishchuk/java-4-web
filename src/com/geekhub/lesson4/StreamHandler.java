package com.geekhub.lesson4;

import java.io.*;
import java.util.zip.*;

public class StreamHandler {

    public static Config config;
    static final int BUFFER = 2048;

    public StreamHandler() {
        config = Config.getInstance();
    }

    public ZipOutputStream openStream(String name) throws FileNotFoundException {
        return new ZipOutputStream(
                new BufferedOutputStream(new FileOutputStream(name))
        );
    }

    public void addToStream(ZipOutputStream outputStream, String filePath) throws IOException {
        byte data[] = new byte[BUFFER];
        BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(filePath), BUFFER);
        String fileName = filePath.substring(config.getUserPath().length() + 1);
        outputStream.putNextEntry(new ZipEntry(fileName));

        int count;
        while ((count = inputStream.read(data, 0, BUFFER)) != -1) {
            outputStream.write(data, 0, count);
        }

        inputStream.close();
    }

    public void closeStream(ZipOutputStream stream) throws IOException {
        stream.close();
    }
}
