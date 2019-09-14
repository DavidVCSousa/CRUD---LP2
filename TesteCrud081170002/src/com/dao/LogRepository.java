package com.dao;

import com.commons.enums.FilePath;

import java.io.IOException;

public class LogRepository {
    public static void registerLog(String log) throws IOException {
        FileManager actions = new FileManager();
        actions.writeFile(
                FilePath.Log.getPath(),
                log
        );
    }
}
