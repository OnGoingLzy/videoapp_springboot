package com.proj3.videoapp.uitl;

import java.io.IOException;
import com.coremedia.iso.IsoFile;

import java.io.IOException;

public class VideoUtil {

    /**
     * 得到视频文件时长,单位秒
     * @param
     * @return
     * @throws
     */
    public static long getMp4Duration(String videoPath) throws IOException {
        IsoFile isoFile = new IsoFile(videoPath);
        long lengthInSeconds =
                isoFile.getMovieBox().getMovieHeaderBox().getDuration() /
                        isoFile.getMovieBox().getMovieHeaderBox().getTimescale();
        return lengthInSeconds;
    }

    public long getDuration(String filePath) throws IOException {
        String format = getVideoFormat(filePath);
        long result = 0;
        if("m4a".equals(format)) {
            result = VideoUtil.getMp4Duration(filePath);
        }else if("mov".equals(format)){
            result = VideoUtil.getMp4Duration(filePath);
        }else if("mp4".equals(format)){
            result = VideoUtil.getMp4Duration(filePath);
        }

        return result;
    }

    /**
     * 得到文件格式
     * @param
     * @return
     */
    public String getVideoFormat(String path){
        return  path.toLowerCase().substring(path.toLowerCase().lastIndexOf(".") + 1);
    }


}
