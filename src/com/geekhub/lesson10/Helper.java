package com.geekhub.lesson10;

import java.io.*;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Properties;

public class Helper {

    public static Properties config = null;

    public Helper(Properties conf) {
        config = conf;
    }

    public ArrayList<String> getLinks() throws IOException {
        FileReader fileReader = new FileReader(config.getProperty("links.path"));
        BufferedReader reader = new BufferedReader(fileReader);
        ArrayList<String> links = new ArrayList<>();

        String line;
        while ((line = reader.readLine()) != null) {
            links.add(line);
        }

        return links;
    }

    public String md5(String content) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(content.getBytes());
        return (new BigInteger(1, md.digest())).toString(16);
    }

    public void writeHash(String content) throws IOException {
        String filePath = config.getProperty("hash.path");
        BufferedWriter file = new BufferedWriter(new FileWriter(filePath, true));
        file.write(content);
        file.newLine();
        file.close();
    }

    public void cleanResources() throws IOException {
        String filePath = config.getProperty("hash.path");
        Files.deleteIfExists(Paths.get(filePath));
    }
}
