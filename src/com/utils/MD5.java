package com.utils;

import java.math.BigInteger;

/**
 *MD5���������
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
            // ����һ��MD5���ܼ���ժҪ
            MessageDigest md = MessageDigest.getInstance("MD5");
            // ����md5����
            md.update(str.getBytes());
            // digest()���ȷ������md5 hashֵ������ֵΪ8Ϊ�ַ�������Ϊmd5 hashֵ��16λ��hexֵ��ʵ���Ͼ���8λ���ַ�
            // BigInteger������8λ���ַ���ת����16λhexֵ�����ַ�������ʾ���õ��ַ�����ʽ��hashֵ
            return new BigInteger(1, md.digest()).toString(16);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("MD5���ܳ��ִ���");
        }
	}
}
