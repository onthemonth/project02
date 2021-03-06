package com.ly.sdk.env;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 
 * <p>ClassName: FtpProperties</p>
 * <p>Description: TODO</p>
 * <p>Author: Administrator</p>
 * <p>Date: 2016年1月14日</p>
 */
public class FtpProperties {
    private static String ftpFilePath = "/data/env/ftp_config.properties";
    private static Properties prop = new Properties();

    static {
        InputStream in = null;
        try {
            File file = new File(ftpFilePath);
            if (file.exists() && !file.isDirectory()) {
                in = new FileInputStream(file);
                if (in != null) {
                    prop.load(in);
                    
                }
            } else {
                throw new RuntimeException("not found ftp properties file :"
                        + file.getAbsolutePath());
            }
        } catch (Exception e) {
            throw new RuntimeException("init ftp properties error :"
                    + e.getMessage());
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException e) {
                in = null;
            }
        }
    }
    public static String getString(String key) {
        return prop.getProperty(key);
    }
}
