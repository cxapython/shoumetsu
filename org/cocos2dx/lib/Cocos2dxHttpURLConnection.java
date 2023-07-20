package org.cocos2dx.lib;

import android.util.Log;
import cz.msebera.android.httpclient.HttpHeaders;
import cz.msebera.android.httpclient.cookie.ClientCookie;
import cz.msebera.android.httpclient.protocol.HTTP;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.security.KeyStore;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import java.util.zip.InflaterInputStream;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;

/* loaded from: classes.dex */
public class Cocos2dxHttpURLConnection {
    private static final String POST_METHOD = "POST";
    private static final String PUT_METHOD = "PUT";

    static void addRequestHeader(HttpURLConnection httpURLConnection, String str, String str2) {
        httpURLConnection.setRequestProperty(str, str2);
    }

    public static String combinCookies(List<String> list, String str) {
        StringBuilder sb = new StringBuilder();
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = "FALSE";
        String str6 = "/";
        String str7 = str;
        for (String str8 : list) {
            String[] split = str8.split(";");
            int length = split.length;
            int i = 0;
            String str9 = str4;
            String str10 = str3;
            String str11 = str2;
            String str12 = str5;
            String str13 = str6;
            String str14 = str7;
            int i2 = 0;
            while (i2 < length) {
                String str15 = split[i2];
                int indexOf = str15.indexOf("=");
                if (-1 != indexOf) {
                    String[] strArr = new String[2];
                    strArr[i] = str15.substring(i, indexOf);
                    strArr[1] = str15.substring(indexOf + 1);
                    if (ClientCookie.EXPIRES_ATTR.equalsIgnoreCase(strArr[i].trim())) {
                        str9 = str2Seconds(strArr[1].trim());
                    } else if (ClientCookie.PATH_ATTR.equalsIgnoreCase(strArr[0].trim())) {
                        str13 = strArr[1];
                    } else if (ClientCookie.SECURE_ATTR.equalsIgnoreCase(strArr[0].trim())) {
                        str12 = strArr[1];
                    } else if (ClientCookie.DOMAIN_ATTR.equalsIgnoreCase(strArr[0].trim())) {
                        str14 = strArr[1];
                    } else {
                        if (!ClientCookie.VERSION_ATTR.equalsIgnoreCase(strArr[0].trim()) && !"max-age".equalsIgnoreCase(strArr[0].trim())) {
                            str11 = strArr[0];
                            str10 = strArr[1];
                        }
                        i2++;
                        i = 0;
                    }
                }
                i2++;
                i = 0;
            }
            str7 = str14 == null ? "none" : str14;
            sb.append(str7);
            sb.append('\t');
            sb.append("FALSE");
            sb.append('\t');
            sb.append(str13);
            sb.append('\t');
            sb.append(str12);
            sb.append('\t');
            sb.append(str9);
            sb.append("\t");
            sb.append(str11);
            sb.append("\t");
            sb.append(str10);
            sb.append('\n');
            str6 = str13;
            str5 = str12;
            str2 = str11;
            str3 = str10;
            str4 = str9;
        }
        return sb.toString();
    }

    static int connect(HttpURLConnection httpURLConnection) {
        try {
            httpURLConnection.connect();
            return 0;
        } catch (IOException e) {
            Log.e("cocos2d-x debug info", "come in connect");
            Log.e("cocos2d-x debug info", e.toString());
            return 1;
        }
    }

    static HttpURLConnection createHttpURLConnection(String str) {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setRequestProperty(HttpHeaders.ACCEPT_ENCODING, HTTP.IDENTITY_CODING);
            httpURLConnection.setDoInput(true);
            return httpURLConnection;
        } catch (Exception e) {
            Log.e("URLConnection exception", e.toString());
            return null;
        }
    }

    static void disconnect(HttpURLConnection httpURLConnection) {
        httpURLConnection.disconnect();
    }

    static int getResponseCode(HttpURLConnection httpURLConnection) {
        try {
            return httpURLConnection.getResponseCode();
        } catch (IOException e) {
            Log.e("URLConnection exception", e.toString());
            return 0;
        }
    }

    static byte[] getResponseContent(HttpURLConnection httpURLConnection) {
        InputStream errorStream;
        try {
            try {
                errorStream = httpURLConnection.getInputStream();
                String contentEncoding = httpURLConnection.getContentEncoding();
                if (contentEncoding != null) {
                    if (contentEncoding.equalsIgnoreCase("gzip")) {
                        errorStream = new GZIPInputStream(httpURLConnection.getInputStream());
                    } else if (contentEncoding.equalsIgnoreCase("deflate")) {
                        errorStream = new InflaterInputStream(httpURLConnection.getInputStream());
                    }
                }
            } catch (Exception e) {
                Log.e("URLConnection exception", e.toString());
                return null;
            }
        } catch (IOException unused) {
            errorStream = httpURLConnection.getErrorStream();
        }
        byte[] bArr = new byte[1024];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            int read = errorStream.read(bArr, 0, 1024);
            if (read == -1) {
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
                return byteArray;
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
    }

    static String getResponseHeaderByIdx(HttpURLConnection httpURLConnection, int i) {
        Map<String, List<String>> headerFields = httpURLConnection.getHeaderFields();
        if (headerFields == null) {
            return null;
        }
        int i2 = 0;
        for (Map.Entry<String, List<String>> entry : headerFields.entrySet()) {
            if (i2 == i) {
                String key = entry.getKey();
                if (key == null) {
                    return listToString(entry.getValue(), ",") + "\n";
                }
                return key + ":" + listToString(entry.getValue(), ",") + "\n";
            }
            i2++;
        }
        return null;
    }

    static String getResponseHeaderByKey(HttpURLConnection httpURLConnection, String str) {
        Map<String, List<String>> headerFields;
        if (str == null || (headerFields = httpURLConnection.getHeaderFields()) == null) {
            return null;
        }
        for (Map.Entry<String, List<String>> entry : headerFields.entrySet()) {
            if (str.equalsIgnoreCase(entry.getKey())) {
                return "set-cookie".equalsIgnoreCase(str) ? combinCookies(entry.getValue(), httpURLConnection.getURL().getHost()) : listToString(entry.getValue(), ",");
            }
        }
        return null;
    }

    static int getResponseHeaderByKeyInt(HttpURLConnection httpURLConnection, String str) {
        String headerField = httpURLConnection.getHeaderField(str);
        if (headerField == null) {
            return 0;
        }
        return Integer.parseInt(headerField);
    }

    static String getResponseHeaders(HttpURLConnection httpURLConnection) {
        Map<String, List<String>> headerFields = httpURLConnection.getHeaderFields();
        if (headerFields == null) {
            return null;
        }
        String str = "";
        for (Map.Entry<String, List<String>> entry : headerFields.entrySet()) {
            String key = entry.getKey();
            str = key == null ? str + listToString(entry.getValue(), ",") + "\n" : str + key + ":" + listToString(entry.getValue(), ",") + "\n";
        }
        return str;
    }

    static String getResponseMessage(HttpURLConnection httpURLConnection) {
        try {
            return httpURLConnection.getResponseMessage();
        } catch (IOException e) {
            String iOException = e.toString();
            Log.e("URLConnection exception", iOException);
            return iOException;
        }
    }

    public static String listToString(List<String> list, String str) {
        if (list == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        boolean z = false;
        for (String str2 : list) {
            if (z) {
                sb.append(str);
            }
            if (str2 == null) {
                str2 = "";
            }
            sb.append(str2);
            z = true;
        }
        return sb.toString();
    }

    static void sendRequest(HttpURLConnection httpURLConnection, byte[] bArr) {
        try {
            OutputStream outputStream = httpURLConnection.getOutputStream();
            if (bArr != null) {
                outputStream.write(bArr);
                outputStream.flush();
            }
            outputStream.close();
        } catch (IOException e) {
            Log.e("URLConnection exception", e.toString());
        }
    }

    static void setReadAndConnectTimeout(HttpURLConnection httpURLConnection, int i, int i2) {
        httpURLConnection.setReadTimeout(i);
        httpURLConnection.setConnectTimeout(i2);
    }

    static void setRequestMethod(HttpURLConnection httpURLConnection, String str) {
        try {
            httpURLConnection.setRequestMethod(str);
            if (!str.equalsIgnoreCase("POST") && !str.equalsIgnoreCase("PUT")) {
                return;
            }
            httpURLConnection.setDoOutput(true);
        } catch (ProtocolException e) {
            Log.e("URLConnection exception", e.toString());
        }
    }

    static void setVerifySSL(HttpURLConnection httpURLConnection, String str) {
        BufferedInputStream bufferedInputStream;
        if (!(httpURLConnection instanceof HttpsURLConnection)) {
            return;
        }
        HttpsURLConnection httpsURLConnection = (HttpsURLConnection) httpURLConnection;
        try {
            if (str.startsWith("/")) {
                bufferedInputStream = new BufferedInputStream(new FileInputStream(str));
            } else {
                bufferedInputStream = new BufferedInputStream(Cocos2dxHelper.getActivity().getAssets().open(str.substring(7)));
            }
            Certificate generateCertificate = CertificateFactory.getInstance("X.509").generateCertificate(bufferedInputStream);
            PrintStream printStream = System.out;
            printStream.println("ca=" + ((X509Certificate) generateCertificate).getSubjectDN());
            bufferedInputStream.close();
            KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
            keyStore.load(null, null);
            keyStore.setCertificateEntry("ca", generateCertificate);
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustManagerFactory.init(keyStore);
            SSLContext sSLContext = SSLContext.getInstance("TLS");
            sSLContext.init(null, trustManagerFactory.getTrustManagers(), null);
            httpsURLConnection.setSSLSocketFactory(sSLContext.getSocketFactory());
        } catch (Exception e) {
            Log.e("URLConnection exception", e.toString());
        }
    }

    private static String str2Seconds(String str) {
        long j;
        Calendar calendar = Calendar.getInstance();
        try {
            calendar.setTime(new SimpleDateFormat("EEE, dd-MMM-yy hh:mm:ss zzz", Locale.US).parse(str));
            j = calendar.getTimeInMillis() / 1000;
        } catch (ParseException e) {
            Log.e("URLConnection exception", e.toString());
            j = 0;
        }
        return Long.toString(j);
    }
}
