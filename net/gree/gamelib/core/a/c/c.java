package net.gree.gamelib.core.a.c;

import android.text.TextUtils;
import com.adjust.sdk.Constants;
import cz.msebera.android.httpclient.HttpHost;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import net.gree.gamelib.core.http.HttpRequest;

/* loaded from: classes.dex */
public class c {
    private static final int A = 7;
    private static final int B = 8;
    private static final int C = 63;
    private static final int D = 983040;
    private static final int E = 12288;
    private static final int F = 3072;
    private static final int G = 768;
    private static final int H = 48;
    private static final int I = 15;
    private static final int J = 127;
    private static final int K = 255;
    private static final int L = 4;
    public static final String a = "Authorization";
    public static final String b = "X-GREE-Authorization";
    public static final String c = "1.0";
    public static final String d = "HMAC-SHA1";
    public static final String e = "HmacSHA1";
    public static final String f = "RSA-SHA1";
    public static final String g = "UTF-8";
    public static final String h = "oauth_body_hash";
    public static final String i = "oauth_consumer_key";
    public static final String j = "oauth_nonce";
    public static final String k = "oauth_timestamp";
    public static final String l = "oauth_signature";
    public static final String m = "oauth_signature_method";
    public static final String n = "oauth_version";
    public static final String o = "xoauth_requestor_id";
    public static final String p = "xoauth_as_hash";
    private static final long q = 1000;
    private static final int r = 80;
    private static final int s = 443;
    private static final int t = 16;
    private static final int u = 3;
    private static final int v = 6;
    private static final int w = 1;
    private static final int x = 2;
    private static final int y = 4;
    private static final int z = 5;

    private c() {
    }

    public static String a() {
        return Long.toString(System.currentTimeMillis() / q);
    }

    static String a(int i2) {
        return i2 <= 127 ? String.format("%c", Integer.valueOf(i2 & K)) : String.format("%c", Integer.valueOf(((D & i2) >>> 4) + (((i2 & E) + (i2 & F)) >>> 2) + ((i2 & G) >>> 2) + (i2 & 48) + (i2 & 15)));
    }

    public static String a(String str) {
        if (str == null) {
            str = "";
        }
        byte[] a2 = a(str, Constants.SHA1);
        return a2 != null ? net.gree.gamelib.core.a.a.b.a(a2) : "";
    }

    public static String a(String str, String str2, String str3) {
        return net.gree.gamelib.core.a.a.b.a(a(str + str2, str3, "RSA", "SHA1withRSA")).trim();
    }

    static String a(URI uri) {
        int lastIndexOf;
        String scheme = uri.getScheme();
        String authority = uri.getAuthority();
        if (((scheme.equals(HttpHost.DEFAULT_SCHEME_NAME) && uri.getPort() == 80) || (scheme.equals(Constants.SCHEME) && uri.getPort() == s)) && (lastIndexOf = authority.lastIndexOf(":")) >= 0) {
            authority = authority.substring(0, lastIndexOf);
        }
        String rawPath = uri.getRawPath();
        if (rawPath == null || rawPath.length() <= 0) {
            rawPath = "/";
        }
        return scheme + "://" + authority + rawPath;
    }

    public static String a(TreeMap<String, String> treeMap) {
        StringBuilder sb = new StringBuilder();
        sb.append("OAuth ");
        for (Map.Entry<String, String> entry : treeMap.entrySet()) {
            sb.append(entry.getKey());
            sb.append("=\"");
            sb.append(c(entry.getValue()));
            sb.append("\",");
        }
        return sb.substring(0, sb.lastIndexOf(","));
    }

    public static String a(HttpRequest httpRequest, String str, TreeMap<String, String> treeMap) {
        String b2 = b(a(httpRequest, treeMap), str);
        return b2 == null ? "" : b2;
    }

    static String a(HttpRequest httpRequest, TreeMap<String, String> treeMap) {
        String method = httpRequest.getMethod();
        String url = httpRequest.getUrl();
        String str = "";
        try {
            str = a(new URI(url));
        } catch (URISyntaxException e2) {
            e2.printStackTrace();
        }
        a(url, treeMap);
        StringBuilder sb = new StringBuilder();
        for (String str2 : treeMap.keySet()) {
            if (!l.equals(str2)) {
                sb.append(c(str2));
                sb.append("=");
                sb.append(c(treeMap.get(str2)));
                sb.append("&");
            }
        }
        return c(method) + "&" + c(str) + "&" + c(sb.substring(0, sb.lastIndexOf("&")));
    }

    static void a(String str, TreeMap<String, String> treeMap) {
        String[] split;
        String substring;
        int indexOf = str.indexOf(63);
        if (indexOf >= 0) {
            String substring2 = str.substring(indexOf + 1);
            if (TextUtils.isEmpty(substring2)) {
                return;
            }
            for (String str2 : substring2.split("&")) {
                int indexOf2 = str2.indexOf(61);
                if (indexOf2 < 0) {
                    substring = null;
                } else {
                    String substring3 = str2.substring(0, indexOf2);
                    substring = str2.substring(indexOf2 + 1);
                    str2 = substring3;
                }
                treeMap.put(str2, substring);
            }
        }
    }

    static byte[] a(String str, String str2) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(str2);
            messageDigest.update(str.getBytes("UTF-8"));
            return messageDigest.digest();
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
            return null;
        } catch (NoSuchAlgorithmException e3) {
            e3.printStackTrace();
            return null;
        }
    }

    static byte[] a(String str, String str2, String str3, String str4) {
        try {
            PKCS8EncodedKeySpec pKCS8EncodedKeySpec = new PKCS8EncodedKeySpec(net.gree.gamelib.core.a.a.b.a(str2));
            KeyFactory keyFactory = KeyFactory.getInstance(str3);
            Signature signature = Signature.getInstance(str4);
            signature.initSign(keyFactory.generatePrivate(pKCS8EncodedKeySpec));
            signature.update(str.getBytes("UTF-8"));
            return signature.sign();
        } catch (IOException e2) {
            e2.printStackTrace();
            return null;
        } catch (InvalidKeyException e3) {
            e3.printStackTrace();
            return null;
        } catch (NoSuchAlgorithmException e4) {
            e4.printStackTrace();
            return null;
        } catch (SignatureException e5) {
            e5.printStackTrace();
            return null;
        } catch (InvalidKeySpecException e6) {
            e6.printStackTrace();
            return null;
        }
    }

    public static String b() {
        return Long.toString(new Random(System.nanoTime()).nextLong());
    }

    public static String b(String str) {
        if (str == null) {
            str = "";
        }
        byte[] a2 = a(str, Constants.SHA256);
        return a2 != null ? net.gree.gamelib.core.a.a.b.a(a2) : "";
    }

    public static String b(String str, String str2) {
        if (str != null && str2 != null) {
            try {
                byte[] bytes = str2.getBytes("UTF-8");
                Mac mac = Mac.getInstance(e);
                mac.init(new SecretKeySpec(bytes, mac.getAlgorithm()));
                return net.gree.gamelib.core.a.a.b.a(mac.doFinal(str.getBytes("UTF-8"))).trim();
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
            } catch (InvalidKeyException e3) {
                e3.printStackTrace();
            } catch (NoSuchAlgorithmException e4) {
                e4.printStackTrace();
            }
        }
        return null;
    }

    public static String b(HttpRequest httpRequest, String str, TreeMap<String, String> treeMap) {
        String c2 = c(a(httpRequest, treeMap), str);
        return c2 == null ? "" : c2;
    }

    static String c(String str) {
        char[] charArray;
        byte[] bytes;
        if (str == null) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        for (char c2 : str.toCharArray()) {
            if ((c2 < 'A' || c2 > 'Z') && ((c2 < 'a' || c2 > 'z') && !((c2 >= '0' && c2 <= '9') || c2 == '-' || c2 == '.' || c2 == '_' || c2 == '~'))) {
                for (byte b2 : String.valueOf(c2).getBytes()) {
                    sb.append("%" + String.format("%02X", Byte.valueOf(b2)));
                }
            } else {
                sb.append(c2);
            }
        }
        return sb.toString();
    }

    public static String c(String str, String str2) {
        if (str == null || str2 == null || str.length() == 0) {
            return null;
        }
        return net.gree.gamelib.core.a.a.b.a(a(str, str2, "RSA", "SHA1withRSA")).trim();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String d(String str) {
        char c2;
        if (str == null) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        char[] charArray = str.toCharArray();
        int i2 = 0;
        while (i2 < charArray.length) {
            if (charArray[i2] == '%') {
                StringBuilder sb2 = new StringBuilder();
                int i3 = i2 + 3;
                if (i3 >= charArray.length) {
                    sb2.append(charArray[i2 + 1]);
                    i2 += 2;
                    c2 = charArray[i2];
                } else {
                    if (i3 < charArray.length) {
                        int i4 = i2 + 1;
                        if (charArray[i4] == 'E' && charArray[i3] == '%' && charArray[i2 + 6] == '%') {
                            sb2.append(charArray[i4]);
                            sb2.append(charArray[i2 + 2]);
                            sb2.append(charArray[i2 + 4]);
                            sb2.append(charArray[i2 + 5]);
                            sb2.append(charArray[i2 + 7]);
                            i2 += 8;
                            c2 = charArray[i2];
                        }
                    }
                    sb2.append(charArray[i2 + 1]);
                    i2 += 2;
                    c2 = charArray[i2];
                }
                sb2.append(c2);
                sb.append(a(Integer.parseInt(sb2.toString(), 16)));
            } else {
                sb.append(charArray[i2]);
            }
            i2++;
        }
        return sb.toString();
    }

    public static String e(String str) {
        StringBuilder sb = new StringBuilder();
        int i2 = 0;
        for (char c2 : str.toCharArray()) {
            if (i2 == 63) {
                sb.append("\n");
                i2 = 0;
            }
            sb.append(c2);
            i2++;
        }
        return sb.toString();
    }
}
