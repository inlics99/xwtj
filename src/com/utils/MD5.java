package com.utils;

import java.math.BigInteger;

/**
 *MD5密码加密类
 *
 */

import java.security.*; 
import java.security.spec.*; 
public final class MD5 {
	
	public final static String MD5(String s){ 
		return s;
	}
	public final static String Md(String str) {
		try {
            // 生成一个MD5加密计算摘要
            MessageDigest md = MessageDigest.getInstance("MD5");
            // 计算md5函数
            md.update(str.getBytes());
            // digest()最后确定返回md5 hash值，返回值为8为字符串。因为md5 hash值是16位的hex值，实际上就是8位的字符
            // BigInteger函数则将8位的字符串转换成16位hex值，用字符串来表示；得到字符串形式的hash值
            return new BigInteger(1, md.digest()).toString(16);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("MD5加密出现错误");
        }
	}
}
