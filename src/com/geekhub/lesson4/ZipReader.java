package com.geekhub.lesson4;

import java.io.File;
import java.util.ArrayList;

public class ZipReader {

    private ArrayList<String> files = new ArrayList<>();

    public ArrayList<String> readDir(String dirPath) {
        System.out.println("Reading...");

        File root = new File(dirPath);
        File[] list = root.listFiles();

        if (list == null) {
            return files;
        }

        for (File f : list) {
            if (f.isFile()) {
                files.add(f.getAbsolutePath());
            } else {
                readDir(f.getAbsolutePath());
            }
        }

        return files;
    }
}
