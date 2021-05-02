package com.xingyu.util;

import org.jasypt.util.text.BasicTextEncryptor;

import java.util.UUID;

public class JasyptUtil {

    private static final String salt = UUID.randomUUID().toString();

    public static void main(String[] args) {
        //获取加密工具类对象
        BasicTextEncryptor encryptor = new BasicTextEncryptor();
        //设置加盐的盐
        encryptor.setPassword("123456");
        //加密
        String name = encryptor.encrypt("root");
        String password = encryptor.encrypt("rootc");
        System.out.println(name);
        System.out.println(password);
//        System.out.println("========================");
//        System.out.println(encryptor.decrypt(name));
//        System.out.println(encryptor.decrypt(password));

        //Caused by: org.jasypt.exceptions.EncryptionOperationNotPossibleException: null
        //Caused by: com.ulisesbocchio.jasyptspringboot.exception.DecryptionException: Unable to decrypt: ENC(
        //使用jasypt-spring-boot-starter.3.0.3.jar加密工具时启动springboot报错
        //改为2.0.0即可 ENC(加密后的结果)     3.0.3版本的解密方式不太一样 可能不通过ENC的方式
    }
}
