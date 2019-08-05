package com.pl.spring;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class FileEventLogger implements EventLogger {

    private static final Logger LOGGER = Logger.getLogger(FileEventLogger.class);

    private File file;
    private String fileName;

    FileEventLogger(String fileName) {
        this.fileName = fileName;
    }

    private void init() throws IOException {
        this.file = new File(fileName);
        if (!file.exists()) {
            file.createNewFile();
        }
        if (!file.canWrite()) {
            throw new IOException();
        }
    }

    @Override
    public void logEvent(Event msg) {
        try {
            FileUtils.writeStringToFile(file, msg.toString(), StandardCharsets.UTF_8, true);
        } catch (IOException e) {
            LOGGER.error(e);
        }
    }
}
