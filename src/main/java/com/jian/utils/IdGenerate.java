package com.jian.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class IdGenerate {

    private static final SimpleDateFormat format = new SimpleDateFormat("yyMMddHHmmss");

    //用户uid
    public static String uid(){

        String label = "u";
        String uid = format.format(new Date());
        String tail = String.valueOf(new Random().nextInt(900) + 100);

        return label + uid + tail;
    }

    //故事sid
    public static String sid(){

        String label = "s";
        String sid = format.format(new Date());
        String tail = String.valueOf(new Random().nextInt(900) + 100);

        return label + sid + tail;
    }

    //标签tid
    public static String tid(){

        String label = "t";
        String tid = format.format(new Date());
        String tail = String.valueOf(new Random().nextInt(900) + 100);

        return label + tid + tail;
    }

    //阅读记录编号
    public static String readId(){

        String label = "r";
        String readId = format.format(new Date());
        String tail = String.valueOf(new Random().nextInt(900) + 100);

        return label + readId + tail;
    }

    //点赞记录编号
    public static String loveId(){

        String label = "l";
        String loveId = format.format(new Date());
        String tail = String.valueOf(new Random().nextInt(900) + 100);

        return label + loveId + tail;
    }

    //评论记录编号
    public static String commentId(){

        String label = "c";
        String commentId = format.format(new Date());
        String tail = String.valueOf(new Random().nextInt(900) + 100);

        return label + commentId + tail;
    }

}
