package com.aaa.day2Thread;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/*
 * @Author: 江Sir
 * @Date: 2022/10/9 20:53
 * @Description:
 * @Since version:  2022.10
 */
public class KeyCodeUtils {
    public static String Write(String url) {
        //image
        BufferedImage image = new BufferedImage(100, 40, BufferedImage.TYPE_INT_RGB);
        //画笔
        Graphics graphics = image.getGraphics();

        //绘制(背景 文字 -->随机)
        graphics.setColor(Color.yellow);
        graphics.fillRect(0,0,100,400);

        graphics.setColor(Color.BLACK);
        graphics.setFont(new Font("黑体",Font.BOLD,20));
        char[] values = "0123456789abcdefg".toCharArray();
        Random random = new Random();
        //4位的验证码
        String code = "";
        for (int i = 0; i < 4; i++) {
            int index = random.nextInt(values.length);
            graphics.drawString(String.valueOf(values[index]),10+24*i,30);
            code += String.valueOf(values[index]);
        }
        //image--->文件
        try {
            ImageIO.write(image,"jpg",new File(url));
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return code;
    }
}
