package com.geekhub.lesson4;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.zip.*;

public class Main {

    public static Config CONFIG;

    public static void main(String[] args) throws Exception {
        ZipReader zipReader = new ZipReader();
        ZipScanner zipScanner = new ZipScanner();
        FileHandler fileHandler = new FileHandler();

        CONFIG = Config.getInstance();
        CONFIG.setConfig(zipScanner.getDirPathForMessage("Enter directory path: "));

        File resDir = new File(CONFIG.getResPath());
        if (!resDir.exists()) {
            Boolean isMkdir = resDir.mkdir();
        }

        ZipOutputStream audioStream = new ZipOutputStream(
                new BufferedOutputStream(new FileOutputStream(CONFIG.getAudioPath()))
        );
        ZipOutputStream videoStream = new ZipOutputStream(
                new BufferedOutputStream(new FileOutputStream(CONFIG.getVideoPath()))
        );
        ZipOutputStream imageStream = new ZipOutputStream(
                new BufferedOutputStream(new FileOutputStream(CONFIG.getImagePath()))
        );

        ArrayList<String> files = zipReader.readDir(CONFIG.getUserPath());
        if (files.isEmpty()) {
            System.out.println("There aren't any files.");
            return;
        }

        for (String file : files) {
            String fileType = file.substring(file.lastIndexOf(".") + 1).toLowerCase();

            if (Arrays.asList(CONFIG.getAudioFormats()).contains(fileType)) {
                fileHandler.addFileToStream(audioStream, file);
                continue;
            }

            if (Arrays.asList(CONFIG.getVideoFormats()).contains(fileType)) {
                fileHandler.addFileToStream(videoStream, file);
                continue;
            }

            if (Arrays.asList(CONFIG.getImageFormats()).contains(fileType)) {
                fileHandler.addFileToStream(imageStream, file);
                continue;
            }

            System.out.println("Unsupported file: " + file);
        }

        System.out.println("Process finish.");

        audioStream.close();
        videoStream.close();
        imageStream.close();
    }
}
