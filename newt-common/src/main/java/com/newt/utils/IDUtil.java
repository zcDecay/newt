package com.newt.utils;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;

import java.nio.ByteBuffer;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

/**
 * @Description: id生成策略
 * @Author: zcc
 * @Date: 18/09/12
 */
public class IDUtil {

    /**
     * 图片名生成
     */
    public static String getImageName() {
        // 取当前时间的长整形值包含毫秒
        long millis = System.currentTimeMillis();
        // long millis = System.nanoTime();
        // 加上三位随机数
        Random random = new Random();
        int end3 = random.nextInt(999);
        // 如果不足三位前面补0
        String str = millis + String.format("%03d", end3);

        return str;
    }

    /**
     * 商品id生成
     */
    public static long getItemId() {
        // 取当前时间的长整形值包含毫秒
        long millis = System.currentTimeMillis();
        // long millis = System.nanoTime();
        // 加上两位随机数
        Random random = new Random();
        int end2 = random.nextInt(99);
        // 如果不足两位前面补0
        String str = millis + String.format("%02d", end2);
        long id = new Long(str);
        return id;
    }

    /**
     * 商品id生成
     */
    public static String getId() {
        // 取当前时间的长整形值包含毫秒
        long millis = System.currentTimeMillis();
        // long millis = System.nanoTime();
        // 加上两位随机数
        Random random = new Random();
        int end2 = random.nextInt(999);
        // yyyyMMddHHmissSSS
        // 2016060117041979637
        // 如果不足两位前面补0
        String date = DateUtil.format(new Date(), DateUtil.YYYYMMDDHHMMSSSSS);
        String str = date + String.format("%03d", end2);
        return str;
    }

    public static void main(String[] args) {
        System.out.println(getId());
    }

    /**
     * 获取UUID
     *
     * @return
     */
    public static String getUUID() {
        return StringUtils.replace(UUID.randomUUID().toString(), "-", "");
    }

    public static String getUuid() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    public static String getBase64Uuid() {
        UUID uuid = UUID.randomUUID();
        ByteBuffer bb = ByteBuffer.wrap(new byte[16]);
        bb.putLong(uuid.getMostSignificantBits());
        bb.putLong(uuid.getLeastSignificantBits());
        return Base64.encodeBase64URLSafeString(bb.array());
    }

    public static String getBase58Uuid() {
        UUID uuid = UUID.randomUUID();
        ByteBuffer bb = ByteBuffer.wrap(new byte[16]);
        bb.putLong(uuid.getMostSignificantBits());
        bb.putLong(uuid.getLeastSignificantBits());

        return Base58.encode(bb.array());
    }

    /**
     * 指定长度生成纯数字code
     *
     * @param length
     * @return
     */
    public static String getRandomNumberByLength(int length) {
        StringBuilder sb = new StringBuilder();
        Random rand = new Random();
        for (int i = 0; i < length; i++) {
            sb.append(rand.nextInt(10));
        }
        return sb.toString();
    }

}
