/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.eng.core.util;

import com.me.eng.core.application.ResourceLocator;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Artur Tomasi
 */
public class LogUtilities {

    private static LogUtilities _instance;

    /**
     * getInstance
     *
     * @return LogUtilities
     */
    public final static LogUtilities getInstance() {
        try {
            if (_instance == null) {
                _instance = new LogUtilities();
                _instance.start();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace(System.err);
        }

        return _instance;
    }

    private File _log;
    private DateFormat _df;

    /**
     * LogUtilities
     *
     */
    public LogUtilities() {
        URL l = ResourceLocator.getResourceAsURL("/log/log.log");

        try {
            _log = new File(l.toURI());
        } catch (URISyntaxException ex) {
            ex.printStackTrace(System.err);
        }

        _df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    }

    /**
     * write
     *
     * @param action String
     * @throws IOException
     */
    public void write(String action) throws IOException {
        Files.write(_log.toPath(), format(action).getBytes(), StandardOpenOption.APPEND);
    }

    /**
     * tail
     *
     * @return String
     */
    public String tail() {
        java.io.RandomAccessFile fileHandler = null;
        try {
            fileHandler = new java.io.RandomAccessFile(_log, "r");
            long fileLength = fileHandler.length() - 1;
            StringBuilder sb = new StringBuilder();
            int line = 0;
            for (long filePointer = fileLength; filePointer != -1; filePointer--) {
                fileHandler.seek(filePointer);
                int readByte = fileHandler.readByte();

                if (readByte == 0xA) {
                    if (filePointer < fileLength) {
                        line = line + 1;
                    }
                } else if (readByte == 0xD) {
                    if (filePointer < fileLength - 1) {
                        line = line + 1;
                    }
                }
                if (line >= 1000) {
                    break;
                }
                sb.append((char) readByte);
            }

            String lastLine = sb.reverse().toString();
            return lastLine;
        } catch (java.io.FileNotFoundException e) {
            e.printStackTrace(System.err);
            return null;
        } catch (java.io.IOException e) {
            e.printStackTrace( System.err);
            return null;
        } finally {
            if (fileHandler != null) {
                try {
                    fileHandler.close();
                } catch (IOException e) {
                }
            }
        }
    }

    /**
     * format
     *
     * @param action String
     * @param t Thread
     * @return String
     */
    private String format(String action) {
        Date dt = new java.sql.Date(System.currentTimeMillis());

        return _df.format(dt) + ": "
                + String.format("%-25s", Thread.currentThread().getName()) + ": " + action + System.lineSeparator();
    }

    /**
     * start
     *
     */
    private void start() throws FileNotFoundException {
        clear();
    }

    /**
     * clear
     *
     */
    private void clear() throws FileNotFoundException {
        try (PrintWriter writer = new PrintWriter(_log)) {
            writer.print("");
            writer.close();
        }
    }

}
