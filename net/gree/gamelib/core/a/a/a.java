package net.gree.gamelib.core.a.a;

import com.adjust.sdk.Constants;
import cz.msebera.android.httpclient.message.TokenParser;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import net.gree.gamelib.core.GLog;

/* loaded from: classes.dex */
public class a {
    private static final String a = "a";
    private static final int b = 13;

    private a() {
    }

    public static String a(String str, String str2) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(str.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(2, secretKeySpec);
            return new String(cipher.doFinal(a(str2)));
        } catch (InvalidKeyException e) {
            e.printStackTrace();
            return null;
        } catch (NoSuchAlgorithmException e2) {
            e2.printStackTrace();
            return null;
        } catch (BadPaddingException e3) {
            e3.printStackTrace();
            throw new RuntimeException(e3);
        } catch (IllegalBlockSizeException e4) {
            e4.printStackTrace();
            throw new RuntimeException(e4);
        } catch (NoSuchPaddingException e5) {
            e5.printStackTrace();
            return null;
        }
    }

    public static String a(byte[] bArr, String str) {
        String str2;
        try {
            byte[] a2 = a(bArr);
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(1, new SecretKeySpec(a2, "AES"), new IvParameterSpec(a2));
            str2 = b.a(cipher.doFinal(str.getBytes()));
        } catch (InvalidAlgorithmParameterException e) {
            e.printStackTrace();
            str2 = null;
            String str3 = a;
            GLog.i(str3, "encryption value: " + str + " to " + str2);
            return str2;
        } catch (InvalidKeyException e2) {
            e2.printStackTrace();
            str2 = null;
            String str32 = a;
            GLog.i(str32, "encryption value: " + str + " to " + str2);
            return str2;
        } catch (NoSuchAlgorithmException e3) {
            e3.printStackTrace();
            str2 = null;
            String str322 = a;
            GLog.i(str322, "encryption value: " + str + " to " + str2);
            return str2;
        } catch (BadPaddingException e4) {
            e4.printStackTrace();
            throw new RuntimeException(e4);
        } catch (IllegalBlockSizeException e5) {
            e5.printStackTrace();
            throw new RuntimeException(e5);
        } catch (NoSuchPaddingException e6) {
            e6.printStackTrace();
            str2 = null;
            String str3222 = a;
            GLog.i(str3222, "encryption value: " + str + " to " + str2);
            return str2;
        }
        String str32222 = a;
        GLog.i(str32222, "encryption value: " + str + " to " + str2);
        return str2;
    }

    protected static byte[] a(String str) {
        char[] charArray = str.toCharArray();
        int length = charArray.length;
        byte[] bArr = new byte[length >> 1];
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int i3 = i + 1;
            i = i3 + 1;
            bArr[i2] = (byte) (((Character.digit(charArray[i], 16) << 4) | Character.digit(charArray[i3], 16)) & 255);
            i2++;
        }
        return bArr;
    }

    static byte[] a(byte[] bArr) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(Constants.SHA1);
            messageDigest.update(bArr);
            String a2 = b.a(messageDigest.digest());
            MessageDigest messageDigest2 = MessageDigest.getInstance(Constants.MD5);
            messageDigest2.update(a2.getBytes());
            return messageDigest2.digest();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return "".getBytes();
        }
    }

    public static String b(String str) {
        return d(new StringBuilder(b.a(str.getBytes())).reverse().toString());
    }

    public static String b(byte[] bArr, String str) {
        String str2;
        try {
            byte[] a2 = a(bArr);
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(2, new SecretKeySpec(a2, "AES"), new IvParameterSpec(a2));
            str2 = new String(cipher.doFinal(b.a(str)), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            str2 = null;
            String str3 = a;
            GLog.i(str3, "decryption from " + str + " to " + str2);
            return str2;
        } catch (IOException e2) {
            e2.printStackTrace();
            str2 = null;
            String str32 = a;
            GLog.i(str32, "decryption from " + str + " to " + str2);
            return str2;
        } catch (InvalidAlgorithmParameterException e3) {
            e3.printStackTrace();
            str2 = null;
            String str322 = a;
            GLog.i(str322, "decryption from " + str + " to " + str2);
            return str2;
        } catch (InvalidKeyException e4) {
            e4.printStackTrace();
            str2 = null;
            String str3222 = a;
            GLog.i(str3222, "decryption from " + str + " to " + str2);
            return str2;
        } catch (NoSuchAlgorithmException e5) {
            e5.printStackTrace();
            str2 = null;
            String str32222 = a;
            GLog.i(str32222, "decryption from " + str + " to " + str2);
            return str2;
        } catch (BadPaddingException e6) {
            e6.printStackTrace();
            throw new RuntimeException(e6);
        } catch (IllegalBlockSizeException e7) {
            e7.printStackTrace();
            throw new RuntimeException(e7);
        } catch (NoSuchPaddingException e8) {
            e8.printStackTrace();
            str2 = null;
            String str322222 = a;
            GLog.i(str322222, "decryption from " + str + " to " + str2);
            return str2;
        }
        String str3222222 = a;
        GLog.i(str3222222, "decryption from " + str + " to " + str2);
        return str2;
    }

    public static String c(String str) {
        try {
            return new String(b.a(new StringBuilder(d(str)).reverse().toString()));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    static String d(String str) {
        int i;
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < str.length(); i2++) {
            char charAt = str.charAt(i2);
            if ((charAt < 'a' || charAt > 'm') && (charAt < 'A' || charAt > 'M')) {
                if ((charAt >= 'n' && charAt <= 'z') || (charAt >= 'N' && charAt <= 'Z')) {
                    i = charAt - '\r';
                }
                sb.append(charAt);
            } else {
                i = charAt + TokenParser.CR;
            }
            charAt = (char) i;
            sb.append(charAt);
        }
        return sb.toString();
    }
}
