package com.learn.utils;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 * @author: lxj
 * @Date: 2021/8/26
 * @Description: 图片加水印
 */

public class ImageUtil {

    public static void main(String[] args) {
        String srcImgPath = "C:\\Users\\lxj\\Desktop\\图片1.jpg";
        String iconPath = "C:\\Users\\lxj\\Desktop\\11.jpg";
        String targetPath = "C:\\Users\\lxj\\Desktop\\22.jpg";
        String targetPath2 = "C:\\Users\\lxj\\Desktop\\rotate.jpg";
        String targetPath3 = "C:\\Users\\lxj\\Desktop\\33.jpg";
        String html = "<div style=\"font-size: 16px; padding: 0px; height: auto; min-height: auto; font-family: &quot;lucida Grande&quot;, Verdana; position: relative; zoom: 1; overflow-wrap: break-word; white-space: normal;text-align: center;\"><img src=\"#{imageUrl}\"  style=\"max-width:100%;max-height:100%;\"></div>";
        // 给图片添加水印
//        markImageByIcon(iconPath, srcImgPath, targetPath);
//        // 给图片添加水印,水印旋转-45
//        markImageByIcon(iconPath, srcImgPath, targetPath2, -45);
        List<String> contentList = Arrays.asList("亲爱的{#姓名}，今天是你的生日，", "感谢你在过去时光里的陪伴与付出！","愿你以梦为马、不负韶华，",
                "让我们继往开，域见美好！", "生日快乐！", "请在收到邮件后一周内", "联系HR领取专属生日礼物吧！");
        List<String> list = new ArrayList<>(contentList);
        list.add(0, "3455");
        Font font = new Font("楷体", Font.PLAIN, 30);
        //水印图片色彩以及透明度
        Color color=new Color(236,117,36);
        markImageByFont(srcImgPath, targetPath3, 260,700, color,font, -45, contentList);
//        getImageByte(targetPath3);
        String context = html.replaceAll("#\\{imageUrl\\}", "data:image/gif;base64," + getImageByte(targetPath3));
        System.out.println(context);
    }

    /**
     * 给图片添加水印
     * @param iconPath   水印图片路径
     * @param srcImgPath 源图片路径
     * @param targetPath 目标图片路径
     */
    public static void markImageByIcon(String iconPath, String srcImgPath, String targetPath) {
        markImageByIcon(iconPath, srcImgPath, targetPath, null);
    }

    /**
     * 给图片添加水印、可设置水印图片旋转角度
     * @param iconPath   水印图片路径
     * @param srcImgPath 源图片路径
     * @param targetPath 目标图片路径
     * @param degree     水印图片旋转角度
     */
    public static void markImageByIcon(String iconPath, String srcImgPath, String targetPath, Integer degree) {
        OutputStream os = null;
        try {
            Image srcImg = ImageIO.read(new File(srcImgPath));
            BufferedImage bufferedImage = new BufferedImage(srcImg.getWidth(null), srcImg.getHeight(null), BufferedImage.TYPE_INT_RGB);
            // 得到画笔对象
            Graphics2D g = bufferedImage.createGraphics();
            // 设置对线段的锯齿状边缘处理
            g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
            g.drawImage(srcImg.getScaledInstance(srcImg.getWidth(null), srcImg.getHeight(null), Image.SCALE_SMOOTH), 0, 0, null);
            if (null != degree) {
                // 设置水印旋转
                g.rotate(Math.toRadians(degree), (double) bufferedImage.getWidth() / 2, (double) bufferedImage.getHeight() / 2);
            }
            // 水印图象的路径 水印一般为gif或者png的，这样可设置透明度
            ImageIcon imgIcon = new ImageIcon(iconPath);
            // 得到Image对象。
            Image img = imgIcon.getImage();
            // 透明度
            float alpha = 0.4f;
            g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, alpha));
            // 表示水印图片的位置
            g.drawImage(img, 260, 700, null);
            g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER));
            g.dispose();
            os = new FileOutputStream(targetPath);
            // 生成图片
            ImageIO.write(bufferedImage, "jpg", os);
            os.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != os) {
                    os.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 给图片添加文字水印
     * @param srcImgPath 源图片路径
     * @param tarImgPath 加水印图片路径
     * @param x 水印横坐标开始
     * @param y 水印纵坐标开始
     * @param color 水印颜色
     * @param font 水印字体
     * @param contentList 水印内容
     */
    public static void markImageByFont(String srcImgPath, String tarImgPath, int x, int y, Color color, Font font, Integer degree, List<String> contentList) {
        FileOutputStream fileOutputStream = null;
        try {
            //创建文件
            File srcImgFile = new File(srcImgPath);
            //文件转化为图片
            Image srcImg = ImageIO.read(srcImgFile);
            //获取图片的宽
            int srcImgWidth = srcImg.getWidth(null);
            //获取图片的高
            int srcImgHeight = srcImg.getHeight(null);
            // 加水印
            BufferedImage bufferedImage = new BufferedImage(srcImgWidth, srcImgHeight, BufferedImage.TYPE_INT_RGB);
            Graphics2D g = bufferedImage.createGraphics();
            g.drawImage(srcImg, 0, 0, srcImgWidth, srcImgHeight, null);
            // 设置水印颜色
            g.setColor(color);
            // 设置字体
            g.setFont(font);
            // 去除水印锯齿
            RenderingHints rh=new RenderingHints(RenderingHints. KEY_ANTIALIASING, RenderingHints. VALUE_ANTIALIAS_ON);
            rh.put(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);
            rh.put(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
            g.setRenderingHints(rh);
            // 第一行字的位置
            int fx = 0;
            //设置水印的坐标
            for (int i = 0; i < contentList.size(); i++) {
                if (i == 0) {
                    x = x + 50;
                    fx = x;
                } else {
                    x = fx + (getWatermarkLength(contentList.get(0), g) - getWatermarkLength(contentList.get(i), g))/2;
                }
                y += 70;
                //画出水印
                g.drawString(contentList.get(i), x, y);
                if (null != degree) {
                    // 设置水印旋转
//                    g.rotate(Math.toRadians(degree), (double) bufferedImage.getWidth() / 2, (double) bufferedImage.getHeight() / 2);
                }
            }
            g.dispose();
            // 输出图片
            fileOutputStream = new FileOutputStream(tarImgPath);
            ImageIO.write(bufferedImage, "jpg", fileOutputStream);
            fileOutputStream.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (Objects.nonNull(fileOutputStream)) {
                try {
                    fileOutputStream.close();
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        }
    }

    /**
     * 获取水印的长度
     * @param waterMarkContent
     * @param g
     * @return
     */
    public static int getWatermarkLength(String waterMarkContent, Graphics2D g) {
        return g.getFontMetrics(g.getFont()).charsWidth(waterMarkContent.toCharArray(), 0, waterMarkContent.length());
    }

    /**
     * 获取图片二进制流
     * @param imagePath
     * @return
     */
    public static String getImageByte (String imagePath) {
        ByteArrayOutputStream os = null;
        try {
            File file = new File(imagePath);
            BufferedImage bufferedImage = ImageIO.read(file);
//        import org.springframework.util.FastByteArrayOutputStream;
//        os = new FastByteArrayOutputStream();
            os = new ByteArrayOutputStream();
            ImageIO.write(bufferedImage, "jpg", os);
            os.flush();
            return Base64Util.encode(os.toByteArray());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (Objects.nonNull(os)) {
                try {
                    os.close();
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        }
        return null;
    }
}
