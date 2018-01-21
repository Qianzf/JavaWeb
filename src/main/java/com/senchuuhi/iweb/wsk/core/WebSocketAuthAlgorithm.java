package com.senchuuhi.iweb.wsk.core;

import org.apache.commons.codec.binary.Base64;
import org.apache.log4j.Logger;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.HashMap;
import java.util.Map;


/**
 * 鉴权加解密算法
 */
public class WebSocketAuthAlgorithm {

    private static Logger log = Logger.getLogger(WebSocketAuthAlgorithm.class);

    private final static String PUBLIC_KEY = "RSAPublicKey";

    private final static String PRIVATE_KEY = "RSAPrivateKey";

    private final static Map<String, Object> keyMap = new HashMap<String, Object>();

    /**
     * 初始化公密钥
     *
     * @return
     * @throws Exception
     */
    public static Map<String, Object> initKey() {
        log.info("正在初始化加密逻辑");
        KeyPairGenerator kpGenerator = null;
        try {
            // RSA
            kpGenerator = KeyPairGenerator.getInstance("RSA");
            // 加密强度设定
            kpGenerator.initialize(2048);

            KeyPair keyPair = kpGenerator.generateKeyPair();
            // 存储公钥
            PublicKey publicKey = keyPair.getPublic();
            // 存储密钥
            PrivateKey privateKey = keyPair.getPrivate();

            keyMap.put(PUBLIC_KEY, publicKey);

            keyMap.put(PRIVATE_KEY, privateKey);

            log.info("初始化系统公钥：\n" + getPublicKey(keyMap));

            log.info("初始化系统私钥：\n" + getPrivateKey(keyMap));

        } catch (NoSuchAlgorithmException e) {
            log.info("加密逻辑生成失败！");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return keyMap;
    }

    /**
     * 取出公钥
     *
     * @param keyMap
     * @return
     */
    public static String getPublicKey(Map<String, Object> keyMap) {
        Key key = (Key) keyMap.get(PUBLIC_KEY);
        return encode2Base64(key.getEncoded());
    }

    /**
     * 取出密钥
     *
     * @param keyMap
     * @return
     */
    public static String getPrivateKey(Map<String, Object> keyMap) {
        Key key = (Key) keyMap.get(PRIVATE_KEY);
        return encode2Base64(key.getEncoded());
    }

    /**
     * 公钥加密
     *
     * @param data
     * @return
     * @throws Exception
     */
    public static String encryptByPublicKey(String data) {
        Cipher cipher = null;
        String mi = "";
        try {
            cipher = Cipher.getInstance("RSA");
            RSAPublicKey publicKey = (RSAPublicKey) keyMap.get(PUBLIC_KEY);

            cipher.init(Cipher.ENCRYPT_MODE, publicKey);
            // 模长
            int key_len = publicKey.getModulus().bitLength() / 8;
            // 加密数据长度 <= 模长-11
            String[] datas = splitString(data, key_len - 11);

            // 如果明文长度大于模长-11则要分组加密
            for (String s : datas) {
                mi += bcd2Str(cipher.doFinal(s.getBytes()));
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        }
        return mi;
    }

    /**
     * 私钥加密
     *
     * @param data
     * @return
     * @throws Exception
     */
    public static String encryptByPrivateKey(String data) {
        String mi = "";
        try {
            Cipher cipher = Cipher.getInstance("RSA");
            RSAPrivateKey privateKey = (RSAPrivateKey) keyMap.get(PRIVATE_KEY);

            cipher.init(Cipher.ENCRYPT_MODE, privateKey);
            // 模长
            int key_len = privateKey.getModulus().bitLength() / 8;
            // 加密数据长度 <= 模长-11
            String[] datas = splitString(data, key_len - 11);
            // 如果明文长度大于模长-11则要分组加密
            for (String s : datas) {
                mi += bcd2Str(cipher.doFinal(s.getBytes()));
            }
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return mi;
    }

    /**
     * 私钥解密
     *
     * @param data
     * @return
     * @throws Exception
     */
    public static String decryptByPrivateKey(String data) {
        String ming = null;
        Cipher cipher = null;
        try {
            cipher = Cipher.getInstance("RSA");

            RSAPrivateKey privateKey = (RSAPrivateKey) keyMap.get(PRIVATE_KEY);

            cipher.init(Cipher.DECRYPT_MODE, privateKey);
            // 模长
            int key_len = privateKey.getModulus().bitLength() / 8;
            byte[] bytes = data.getBytes();
            byte[] bcd = ASCII_To_BCD(bytes, bytes.length);
            System.err.println(bcd.length);
            // 如果密文长度大于模长则要分组解密
            byte[][] arrays = splitArray(bcd, key_len);
            for (byte[] arr : arrays) {
                ming += new String(cipher.doFinal(arr));
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        }
        return ming;
    }

    /**
     * ASCII码转BCD码
     */
    public static byte[] ASCII_To_BCD(byte[] ascii, int asc_len) {
        byte[] bcd = new byte[asc_len / 2];
        int j = 0;
        for (int i = 0; i < (asc_len + 1) / 2; i++) {
            bcd[i] = asc_to_bcd(ascii[j++]);
            bcd[i] = (byte) (((j >= asc_len) ? 0x00 : asc_to_bcd(ascii[j++])) + (bcd[i] << 4));
        }
        return bcd;
    }

    public static byte asc_to_bcd(byte asc) {
        byte bcd;

        if ((asc >= '0') && (asc <= '9'))
            bcd = (byte) (asc - '0');
        else if ((asc >= 'A') && (asc <= 'F'))
            bcd = (byte) (asc - 'A' + 10);
        else if ((asc >= 'a') && (asc <= 'f'))
            bcd = (byte) (asc - 'a' + 10);
        else
            bcd = (byte) (asc - 48);
        return bcd;
    }

    /**
     * BCD转字符串
     */
    public static String bcd2Str(byte[] bytes) {
        char temp[] = new char[bytes.length * 2], val;

        for (int i = 0; i < bytes.length; i++) {
            val = (char) (((bytes[i] & 0xf0) >> 4) & 0x0f);
            temp[i * 2] = (char) (val > 9 ? val + 'A' - 10 : val + '0');

            val = (char) (bytes[i] & 0x0f);
            temp[i * 2 + 1] = (char) (val > 9 ? val + 'A' - 10 : val + '0');
        }
        return new String(temp);
    }

    /**
     * 拆分字符串
     */
    public static String[] splitString(String string, int len) {
        int x = string.length() / len;
        int y = string.length() % len;
        int z = 0;
        if (y != 0) {
            z = 1;
        }
        String[] strings = new String[x + z];
        String str = "";
        for (int i = 0; i < x + z; i++) {
            if (i == x + z - 1 && y != 0) {
                str = string.substring(i * len, i * len + y);
            } else {
                str = string.substring(i * len, i * len + len);
            }
            strings[i] = str;
        }
        return strings;
    }

    /**
     * 拆分数组
     */
    public static byte[][] splitArray(byte[] data, int len) {
        int x = data.length / len;
        int y = data.length % len;
        int z = 0;
        if (y != 0) {
            z = 1;
        }
        byte[][] arrays = new byte[x + z][];
        byte[] arr;
        for (int i = 0; i < x + z; i++) {
            arr = new byte[len];
            if (i == x + z - 1 && y != 0) {
                System.arraycopy(data, i * len, arr, 0, y);
            } else {
                System.arraycopy(data, i * len, arr, 0, len);
            }
            arrays[i] = arr;
        }
        return arrays;
    }

    public static String encode2Base64(byte[] bytes) {
        byte[] bts = Base64.encodeBase64(bytes);
        return new String(bts);
    }

}
