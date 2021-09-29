package com.learn.utils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * @author: lxj
 * @Date: 2021/8/25
 * @Description:
 */

public class ImageUtil {
    /**
     * 标点符号列表
     */
    private static final List<String> PUNCTUATION_LIST = Arrays.asList("；", "！", "，", "。", "、");

    public static void main(String[] args) {
        String srcImagePath = "C:\\Users\\lxj\\Desktop\\入职周年贺卡\\5.jpg";
        String targetImagePath = "C:\\Users\\lxj\\Desktop\\\1111.jpg";

        String html = "<div style=\"font-size: 16px; padding: 0px; height: auto; min-height: auto; font-family: &quot;lucida Grande&quot;, Verdana; position: relative; zoom: 1; overflow-wrap: break-word; white-space: normal;text-align: center;\"><img src=\"#{imageUrl}\"  style=\"max-width:100%;max-height:100%;\"></div>";
        // 入职周年贺卡一 1050,160
        /*List<String> contentList = Arrays.asList("亲爱的张三，",
                "2021年10月11日，是你加入开域的第一天，",
                "相识一年，从陌生到默契，从磨合到合作，",
                "你凭借不懈的努力和拼搏，快速成长，不断超越预期。",
                "相信这一年的付出已化为荣耀的星火，",
                "在不久的将来，定能闪耀夜空。",
                "让我们继续携手【开拓创新，域见美好】！");*/
        // 入职周年贺卡二 450, 900
       /* List<String> contentList = Arrays.asList("亲爱的张三，",
                "你我相聚已2年。",
                "同行岁月中，你的勤勉、奉献、热爱历历在目，",
                "相信独一无二的你在星辰大海的征程中已崭露头角，",
                "请带着爱继续前行【开拓创新，域见美好】！",
                "入职2周年快乐哟！");*/
        // 入职周年贺卡三 450, 160
        /*List<String> contentList = Arrays.asList("亲爱的张三，",
                "今天是你入职3周年的日子。",
                "过往的耕耘孕育出蓬勃的生命力，指引前行的路，",
                "稳定输出的你是团队最坚实可靠的战友，无坚不摧。",
                "期待你如星辰长明，熠熠生辉。","让我们继续携手【开拓创新，域见美好】！");*/
        // 入职周年贺卡四 450 900
        /*List<String> contentList = Arrays.asList("亲爱的张三，",
                "恭喜你，入职4周年快乐。","你站在时代浪尖，积极拥抱变化，主动解决问题，","如今你的已成为团队不可或缺的中坚力量，","你的成长让成功有迹可循，见证开域飞速发展。","让我们继续携手【开拓创新，域见美好】！");*/
        // 入职周年贺卡五 550 160
        List<String> contentList = Arrays.asList("亲爱的张三，",
                "5年的相互陪伴，5年的彼此成就。","你的每一次成长都烙上了开域的痕迹，","开域的每一次辉煌也印上了你的名字。","团队就是忘记“你们”和“他们”，一起成就“我们”","让我们继续携手【开拓创新，域见美好】！");
        // 入职周年贺卡六 1100, 950
        /*List<String> contentList = Arrays.asList("亲爱的张三，",
                "时光飞逝，眨眼已相伴6年时光。","星辰大海的征程上，你已成为优秀的领航员。","感谢一路有你，乘风破浪的日子里，","我们无所畏惧。征程还在继续，","让我们一起【开拓创新，域见美好】！");*/
        // 入职周年贺卡七 1100, 160
        /*List<String> contentList = Arrays.asList("亲爱的张三，",
                "今年是传说中的“七年之氧”哟，","你的活力如同氧气，让开域血液中充满生机，","你总是可以轻松放下过往荣耀，不断挑战极限，","你身体力行践行着今天最好的表现是明天最低的要求。","感恩有你携手【开拓创新，域见美好】！");*/
        // 入职周年贺卡八 450, 160
        /*List<String> contentList = Arrays.asList("亲爱的张三，",
                "8，是你在开域的时间；∞，代表无穷无尽 ； ","而你+开域就等于无限可能","老朋友，入职8周年快乐呀。","期待与你继续并肩作战，披荆斩棘。","让我们共同携手【开拓创新，域见美好】！");*/
        Font font = new Font("楷体", 0, 25);
        Color color=new Color(255,255,255);
        File file = new File(srcImagePath);
        addWaterMark(file, targetImagePath, 550,160, color, font, contentList, 5);

       /* // 入职周年贺卡的图片生成二进制流
        File files = new File(targetImagePath);
        FastByteArrayOutputStream os = null;
        try {
            BufferedImage bufferedImage = ImageIO.read(files);
            os = new FastByteArrayOutputStream();
            ImageIO.write(bufferedImage, "jpg", os);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (Objects.nonNull(os)) {
                os.close();
            }
        }
        String imageByte = Base64Util.encode(os.toByteArray());
        String context = html.replaceAll("#\\{imageUrl\\}", "data:image/gif;base64," + imageByte);
        System.out.println(context);*/
    }

    /**
     *
     * @param srcImgPath 源图片路径
     * @param tarImgPath 加水印图片路径
     * @param x 水印横坐标开始
     * @param y 水印纵坐标开始
     * @param color 水印颜色
     * @param font 水印字体
     * @param contentList 水印内容
     */
    public static void addWaterMark(String srcImgPath, String tarImgPath, int x, int y, Color color, Font font, List<String> contentList) {

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
            BufferedImage bufImg = new BufferedImage(srcImgWidth, srcImgHeight, BufferedImage.TYPE_INT_RGB);
            Graphics2D g = bufImg.createGraphics();
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
            }
            g.dispose();
            // 输出图片
            FileOutputStream outImgStream = new FileOutputStream(tarImgPath);
            ImageIO.write(bufImg, "jpg", outImgStream);
            outImgStream.flush();
            outImgStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     *
     * @param srcImgFile 源图片文件
     * @param tarImgPath 加水印图片路径
     * @param x 水印横坐标开始
     * @param y 水印纵坐标开始
     * @param color 水印颜色
     * @param font 水印字体
     * @param contentList 水印内容
     */
    public static void addWaterMark(File srcImgFile, String tarImgPath, int x, int y, Color color, Font font, List<String> contentList) {
        try {
            //文件转化为图片
            Image srcImg = ImageIO.read(srcImgFile);
            //获取图片的宽
            int srcImgWidth = srcImg.getWidth(null);
            //获取图片的高
            int srcImgHeight = srcImg.getHeight(null);
            // 加水印
            BufferedImage bufImg = new BufferedImage(srcImgWidth, srcImgHeight, BufferedImage.TYPE_INT_RGB);
            Graphics2D g = bufImg.createGraphics();
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
            }
            g.dispose();
            // 输出图片
            FileOutputStream outImgStream = new FileOutputStream(tarImgPath);
            ImageIO.write(bufImg, "jpg", outImgStream);
            outImgStream.flush();
            outImgStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @param srcImgFile 源图片文件
     * @param tarImgPath 加水印图片路径
     * @param x 水印横坐标开始
     * @param y 水印纵坐标开始
     * @param color 水印颜色
     * @param font 水印字体
     * @param contentList 水印内容
     */
    public static void addWaterMark(File srcImgFile, String tarImgPath, int x, int y, Color color, Font font, List<String> contentList, Integer workYear) {
        try {
            //文件转化为图片
            Image srcImg = ImageIO.read(srcImgFile);
            //获取图片的宽
            int srcImgWidth = srcImg.getWidth(null);
            //获取图片的高
            int srcImgHeight = srcImg.getHeight(null);
            // 加水印
            BufferedImage bufImg = new BufferedImage(srcImgWidth, srcImgHeight, BufferedImage.TYPE_INT_RGB);
            Graphics2D g = bufImg.createGraphics();
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
            setEmployeeAnniversaryCardWatermarkCoordinate (x, y, contentList, g, workYear);
            g.dispose();
            // 输出图片
            FileOutputStream outImgStream = new FileOutputStream(tarImgPath);
            ImageIO.write(bufImg, "jpg", outImgStream);
            outImgStream.flush();
            outImgStream.close();
        } catch (Exception e) {
            e.printStackTrace();
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
     * 入职周年贺卡设置水印坐标
     * @param x
     * @param y
     * @param contentList
     * @param g
     * @param workYear
     */
    private static void setEmployeeAnniversaryCardWatermarkCoordinate(int x, int y, List<String> contentList, Graphics2D g, Integer workYear) {
        switch (workYear) {
            case 1:setEmployeeAnniversaryCardWatermarkCoordinateOne(x, y, contentList, g);
            break;
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8: setEmployeeAnniversaryCardWatermarkCoordinateCommon(x, y, contentList, g);
            break;
            default:
                break;
        }

    }

    /**
     * 通用入职周年贺卡设置水印坐标
     * @param x
     * @param y
     * @param contentList
     * @param g
     */
    private static void setEmployeeAnniversaryCardWatermarkCoordinateCommon(int x, int y, List<String> contentList, Graphics2D g) {
        // y值备份
        int fy = y;
        //设置水印的坐标
        for (int j = 0; j < contentList.size(); j++ ) {
            char[] charArr = contentList.get(j).toCharArray();
            y = fy;
            x -= 70;
            for (int i = 0; i < charArr.length; i++) {
                String string = String.valueOf(charArr[i]);
                if (!isChinese(charArr[i])) {
                    string = "国";
                }
                if (PUNCTUATION_LIST.contains(string)) {
                    x += getWatermarkLength(string, g)/2;
                    if (Objects.equals("！", string) || Objects.equals("；", string)) {
                        y += getWatermarkLength(string, g);
                    } else {
                        y += getWatermarkLength(string, g)/2;
                    }
                } else {
                    y += getWatermarkLength(string, g);
                }
                if (NumberUtil.isPositiveNumber(String.valueOf(charArr[i])) || Objects.equals("+", String.valueOf(charArr[i]))) {
                    x += getWatermarkLength(string, g)/4;
                }
                if (Objects.equals("【", string)) {
                    // 设置水印旋转
                    y -= getWatermarkLength(string, g);
                    x += getWatermarkLength(string, g)/4;
                    g.rotate(Math.toRadians(90), x, y);
                }
                if (Objects.equals("】", string)) {
                    // 设置水印旋转
                    y -= getWatermarkLength(string, g)/2;
                    x += getWatermarkLength(string, g)/4;
                    g.rotate(Math.toRadians(90), x, y);
                }
                if (Objects.equals("“", string)) {
                    y += getWatermarkLength(string, g)/4;
                    x -= getWatermarkLength(string, g)/4;
                }
                if ( Objects.equals("”", string)) {
                    y += getWatermarkLength(string, g)/4;
                    x += getWatermarkLength(string, g)/4;
                }
                //画出水印
                g.drawString(String.valueOf(charArr[i]), x, y);
                if (PUNCTUATION_LIST.contains(string)) {
                    x -= getWatermarkLength(string, g)/2;
                }
                if (Objects.equals("【", string)) {
                    // 设置水印旋转
                    g.rotate(Math.toRadians(-90),  x, y);
                    y += getWatermarkLength(string, g);
                    x -= getWatermarkLength(string, g)/4;
                }
                if (Objects.equals("】", string)) {
                    // 设置水印旋转
                    g.rotate(Math.toRadians(-90),  x, y);
                    y += getWatermarkLength(string, g)/2;
                    x -= getWatermarkLength(string, g)/4;
                }
                if (Objects.equals("“", string)) {
                    y -= getWatermarkLength(string, g)/4;
                    x += getWatermarkLength(string, g)/4;
                }
                if ( Objects.equals("”", string)) {
                    y -= getWatermarkLength(string, g)/4;
                    x -= getWatermarkLength(string, g)/4;
                }
                if (NumberUtil.isPositiveNumber(String.valueOf(charArr[i])) || Objects.equals("+", String.valueOf(charArr[i]))) {
                    x -= getWatermarkLength(string, g)/4;
                }
            }
        }
    }

    /**
     * 一周年入职周年贺卡设置水印坐标
     * @param x
     * @param y
     * @param contentList
     * @param g
     */
    private static void setEmployeeAnniversaryCardWatermarkCoordinateOne(int x, int y, List<String> contentList, Graphics2D g) {
        // y值备份
        int fy = y;
        //设置水印的坐标
        for (int j = 0; j < contentList.size(); j++ ) {
            char[] charArr = contentList.get(j).toCharArray();
            y = fy;
            x -= 70;
            for (int i = 0; i < charArr.length; i++) {
                String string = String.valueOf(charArr[i]);
                if (j == 0) {
                    if (!isChinese(charArr[i])) {
                        string = "国";
                    }
                }
                if (j == 1) {
                    if (i > 4 && i < 7) {
                        string = charArr[5] + String.valueOf(charArr[6]);
                        i = 6;
                    }
                    if (i > 7 && i < 10) {
                        string = charArr[8] + String.valueOf(charArr[9]);
                        i = 9;
                    }
                }
                if (PUNCTUATION_LIST.contains(string)) {
                    x += getWatermarkLength(string, g)/2;
                    if (Objects.equals("！", string) || Objects.equals("；", string)) {
                        y += getWatermarkLength(string, g);
                    } else {
                        y += getWatermarkLength(string, g)/2;
                    }
                } else {
                    if (j == 1 && i < 4) {
                        y += getWatermarkLength("年", g);
                        x += getWatermarkLength(string, g)/2;
                    } else {
                        y += getWatermarkLength(string, g);
                    }
                }
                if (Objects.equals("【", string)) {
                    // 设置水印旋转
                    y -= getWatermarkLength(string, g);
                    x += getWatermarkLength(string, g)/4;
                    g.rotate(Math.toRadians(90), x, y);
                }
                if (Objects.equals("】", string)) {
                    // 设置水印旋转
                    y -= getWatermarkLength(string, g)/2;
                    x += getWatermarkLength(string, g)/4;
                    g.rotate(Math.toRadians(90), x, y);
                }
                if (Objects.equals("“", string)) {
                    y += getWatermarkLength(string, g)/4;
                    x -= getWatermarkLength(string, g)/4;
                }
                if ( Objects.equals("”", string)) {
                    y += getWatermarkLength(string, g)/4;
                    x += getWatermarkLength(string, g)/4;
                }
                //画出水印
                if (j == 0) {
                    g.drawString(String.valueOf(charArr[i]), x, y);
                } else {
                    g.drawString(string, x, y);
                }
                if (PUNCTUATION_LIST.contains(string)) {
                    x -= getWatermarkLength(string, g)/2;
                }
                if (Objects.equals("【", string)) {
                    // 设置水印旋转
                    g.rotate(Math.toRadians(-90),  x, y);
                    y += getWatermarkLength(string, g);
                    x -= getWatermarkLength(string, g)/4;
                }
                if (Objects.equals("】", string)) {
                    // 设置水印旋转
                    g.rotate(Math.toRadians(-90),  x, y);
                    y += getWatermarkLength(string, g)/2;
                    x -= getWatermarkLength(string, g)/4;
                }
                if (j == 1 && i < 4) {
                    x -= getWatermarkLength(string, g)/2;
                }
                if (Objects.equals("“", string)) {
                    y -= getWatermarkLength(string, g)/4;
                    x += getWatermarkLength(string, g)/4;
                }
                if ( Objects.equals("”", string)) {
                    y -= getWatermarkLength(string, g)/4;
                    x -= getWatermarkLength(string, g)/4;
                }
            }
        }
    }

    /**
     * 根据Unicode编码完美的判断中文汉字和符号
     * @param c
     * @return
     */
    private static boolean isChinese(char c) {
        Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);
        if (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS
                || ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS
                || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A
                || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_B
                || ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION
                || ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS
                || ub == Character.UnicodeBlock.GENERAL_PUNCTUATION) {
            return true;
        }
        return false;
    }
}
