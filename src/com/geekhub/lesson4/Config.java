package com.geekhub.lesson4;

import java.io.File;

public class Config {

    private static Config instance;
    private String userPath, resPath, audioPath, videoPath, imagePath;
    private String audioFormats[] = {"mp3", "wav", "wma"};
    private String videoFormats[] = {"avi", "mp4", "flv"};
    private String imageFormats[] = {"jpeg", "jpg", "gif", "png"};

    private Config() {}

    public static Config getInstance() {
        if (instance == null) {
            instance = new Config();
        }
        return instance;
    }

    public void setConfig(String path) {
        System.out.println("Setting config...");
        userPath = path;
        resPath = new File(userPath).getParent() + "\\res";
        audioPath = resPath + "\\audios.zip";
        videoPath = resPath + "\\videos.zip";
        imagePath = resPath + "\\images.zip";
    }

    public String getUserPath() {
        return userPath;
    }

    public String getResPath() {
        return resPath;
    }

    public String getAudioPath() {
        return audioPath;
    }

    public String getVideoPath() {
        return videoPath;
    }

    public String getImagePath() {
        return imagePath;
    }

    public String[] getAudioFormats() {
        return audioFormats;
    }

    public String[] getVideoFormats() {
        return videoFormats;
    }

    public String[] getImageFormats() {
        return imageFormats;
    }
}
