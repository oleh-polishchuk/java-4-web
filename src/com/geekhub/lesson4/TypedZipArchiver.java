package com.geekhub.lesson4;

import java.io.*;
import java.util.*;
import java.util.zip.ZipOutputStream;

public class TypedZipArchiver {

    private static ZipReader zipReader;
    private static ZipScanner zipScanner;
    private static StreamHandler streamHandler;

    private ZipOutputStream audioStream;
    private ZipOutputStream videoStream;
    private ZipOutputStream imageStream;

    private ArrayList<String> files;

    public static Config config;

    public TypedZipArchiver() {
        zipReader = new ZipReader();
        zipScanner = new ZipScanner();
        streamHandler = new StreamHandler();
        config = Config.getInstance();
    }

    public void readPath() {
        config.setConfig(zipScanner.getDirPathForMessage("Enter path to a folder: "));

        files = zipReader.readDir(config.getUserPath());
        if (files.isEmpty()) {
            System.out.println("There aren't any files.");
            readPath();
        }

        File resDir = new File(config.getResPath());
        if (!resDir.exists()) {
            Boolean isMkdir = resDir.mkdir();
        }
    }

    public void openStreams() throws FileNotFoundException {
        System.out.println("Opening streams...");

        audioStream = streamHandler.openStream(config.getAudioPath());
        videoStream = streamHandler.openStream(config.getVideoPath());
        imageStream = streamHandler.openStream(config.getImagePath());
    }

    public void compress() throws IOException {
        System.out.println("Compressing...");

        for (String file : files) {
            String fileType = file.substring(file.lastIndexOf(".") + 1).toLowerCase();

            if (Arrays.asList(config.getAudioFormats()).contains(fileType)) {
                streamHandler.addToStream(audioStream, file);
                continue;
            }

            if (Arrays.asList(config.getVideoFormats()).contains(fileType)) {
                streamHandler.addToStream(videoStream, file);
                continue;
            }

            if (Arrays.asList(config.getImageFormats()).contains(fileType)) {
                streamHandler.addToStream(imageStream, file);
                continue;
            }

            System.out.println("Unsupported file: " + file);
        }
    }

    public void closeStreams() throws IOException {
        System.out.println("Closing streams...");

        streamHandler.closeStream(audioStream);
        streamHandler.closeStream(videoStream);
        streamHandler.closeStream(imageStream);
    }
}
