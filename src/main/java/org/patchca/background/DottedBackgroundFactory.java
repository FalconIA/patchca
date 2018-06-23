package org.patchca.background;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;

import org.patchca.color.ColorFactory;
import org.patchca.color.SingleColorFactory;

public class DottedBackgroundFactory implements BackgroundFactory {

    private ColorFactory background;
    private int size;

    public DottedBackgroundFactory() {
        this.background = new SingleColorFactory(Color.WHITE);
        this.size = 100;
    }

    public DottedBackgroundFactory(ColorFactory background, int size) {
        this.background = background;
        this.size = size;
    }

    public void setBackground(ColorFactory background) {
        this.background = background;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void fillBackground(BufferedImage dest) {
        Random random = new Random();

        Graphics graphics = dest.getGraphics();

        // 验证码图片的宽高
        int imgWidth = dest.getWidth();
        int imgHeight = dest.getHeight();

        // 填充白色背景
        graphics.setColor(this.background.getColor(0));
        graphics.fillRect(0, 0, imgWidth, imgHeight);

        // 画噪点(颜色及位置随机)
        for (int i = 0; i < this.size; i++) {
            // 随机颜色
            int rInt = random.nextInt(255);
            int gInt = random.nextInt(255);
            int bInt = random.nextInt(255);

            graphics.setColor(new Color(rInt, gInt, bInt));

            // 随机位置
            int xInt = random.nextInt(imgWidth - 3);
            int yInt = random.nextInt(imgHeight - 2);

            // 随机旋转角度
            int sAngleInt = random.nextInt(360);
            int eAngleInt = random.nextInt(360);

            // 随机大小
            int wInt = 2 + random.nextInt(6);
            int hInt = 2 + random.nextInt(6);

            graphics.fillArc(xInt, yInt, wInt, hInt, sAngleInt, eAngleInt);
        }
    }

}
