package com.geekhub.lesson4;

public class Main {

    public static void main(String[] args) throws Exception {
        TypedZipArchiver archiver = new TypedZipArchiver();
        archiver.readPath();
        archiver.openStreams();
        archiver.compress();
        archiver.closeStreams();
    }
}
