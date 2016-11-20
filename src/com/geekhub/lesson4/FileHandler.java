package com.geekhub.lesson4;

import java.io.*;
import java.util.zip.*;

public class FileHandler {

    public static Config CONFIG;
    static final int BUFFER = 2048;

    public FileHandler() {
        CONFIG = Config.getInstance();
    }

    public void addFileToStream(ZipOutputStream outputStream, String filePath) throws IOException {
        System.out.println("Zipping...");

        byte data[] = new byte[BUFFER];
        BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(filePath), BUFFER);
        String fileName = filePath.substring(CONFIG.getUserPath().length() + 1);
        outputStream.putNextEntry(new ZipEntry(fileName));

        int count;
        while ((count = inputStream.read(data, 0, BUFFER)) != -1) {
            outputStream.write(data, 0, count);
        }

        inputStream.close();
    }
}
