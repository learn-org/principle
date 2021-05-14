package com.learn.utils;

import ws.schild.jave.Encoder;
import ws.schild.jave.EncoderException;
import ws.schild.jave.MultimediaObject;
import ws.schild.jave.encode.AudioAttributes;
import ws.schild.jave.encode.EncodingAttributes;
import ws.schild.jave.encode.VideoAttributes;
import ws.schild.jave.info.MultimediaInfo;
import ws.schild.jave.info.VideoInfo;
import ws.schild.jave.info.VideoSize;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author: lxj
 * @Date: 2021/3/2
 * @Description: 视频格式转换 （linux服务器内核版本要求3.0以上）
 */
public class VideoUtil {

    private static Map<String, Integer> sizeBitRateMap;

    static {
        sizeBitRateMap = new HashMap<>();
        sizeBitRateMap.put("1920*1080", 4992);
        sizeBitRateMap.put("1280*720", 2496);
        sizeBitRateMap.put("1024*576", 1856);
        sizeBitRateMap.put("840*480", 1216);
        sizeBitRateMap.put("768*432", 1088);
        sizeBitRateMap.put("640*360", 896);
        sizeBitRateMap.put("424*240", 576);
    }

    public static void main(String[] args) throws Exception {
        transferVideoToMP4(new File("C:\\Users\\lxj\\Desktop\\文档\\戏曲.mov"),new File("C:\\Users\\lxj\\Desktop\\文档\\戏曲.mp4"));

    }

    /**
     * 将视频格式转化为mp4格式
     * @param sourceFile
     * @param targetFile
     * @throws EncoderException
     */
    public static void transferVideoToMP4 (File sourceFile, File targetFile) throws EncoderException {
        long start = System.currentTimeMillis();
        MultimediaObject multimediaObject = new MultimediaObject(sourceFile);
        MultimediaInfo info = multimediaObject.getInfo();
        VideoInfo videoInfo = info.getVideo();
        VideoSize size = videoInfo.getSize();
        Integer bitRate = sizeBitRateMap.get(size.getWidth() + "*" + size.getHeight());
        VideoAttributes videoAttributes = new VideoAttributes();
        //设置视频编码
        videoAttributes.setCodec("h264");
        if (Objects.nonNull(bitRate)) {
            //设置比特率
            videoAttributes.setBitRate(bitRate * 1000);
        }
        AudioAttributes audioAttributes = new AudioAttributes();
        //设置编码器名称
        audioAttributes.setCodec("aac");
        EncodingAttributes attrs = new EncodingAttributes();
        //设置转换后的格式
        attrs.setOutputFormat("mp4");
        attrs.setAudioAttributes(audioAttributes);
        attrs.setVideoAttributes(videoAttributes);
        Encoder encoder = new Encoder();
        encoder.encode(multimediaObject, targetFile, attrs);
        long end = System.currentTimeMillis();
        System.out.println("transferVideoToMP4 cost:" + (end - start) + " ms");
    }
}
