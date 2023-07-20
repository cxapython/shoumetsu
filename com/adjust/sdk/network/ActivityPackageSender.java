package com.adjust.sdk.network;

import android.net.Uri;
import com.adjust.sdk.ActivityKind;
import com.adjust.sdk.ActivityPackage;
import com.adjust.sdk.AdjustAttribution;
import com.adjust.sdk.AdjustFactory;
import com.adjust.sdk.ILogger;
import com.adjust.sdk.ResponseData;
import com.adjust.sdk.TrackingState;
import com.adjust.sdk.Util;
import com.adjust.sdk.network.IActivityPackageSender;
import com.adjust.sdk.network.UtilNetworking;
import com.adjust.sdk.scheduler.SingleThreadCachedScheduler;
import com.adjust.sdk.scheduler.ThreadExecutor;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLHandshakeException;
import net.gree.gamelib.core.a.b.b;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class ActivityPackageSender implements IActivityPackageSender {
    private String basePath;
    private String clientSdk;
    private String gdprPath;
    private String subscriptionPath;
    private UrlStrategy urlStrategy;
    private ILogger logger = AdjustFactory.getLogger();
    private ThreadExecutor executor = new SingleThreadCachedScheduler("ActivityPackageSender");
    private UtilNetworking.IHttpsURLConnectionProvider httpsURLConnectionProvider = AdjustFactory.getHttpsURLConnectionProvider();
    private UtilNetworking.IConnectionOptions connectionOptions = AdjustFactory.getConnectionOptions();

    public ActivityPackageSender(String str, String str2, String str3, String str4, String str5) {
        this.basePath = str2;
        this.gdprPath = str3;
        this.subscriptionPath = str4;
        this.clientSdk = str5;
        this.urlStrategy = new UrlStrategy(AdjustFactory.getBaseUrl(), AdjustFactory.getGdprUrl(), AdjustFactory.getSubscriptionUrl(), str);
    }

    private String buildAuthorizationHeader(ActivityPackage activityPackage) {
        Map<String, String> parameters = activityPackage.getParameters();
        String activityKind = activityPackage.getActivityKind().toString();
        String extractSecretId = extractSecretId(parameters);
        String buildAuthorizationHeaderV2 = buildAuthorizationHeaderV2(extractSignature(parameters), extractSecretId, extractHeadersId(parameters), extractAlgorithm(parameters), extractNativeVersion(parameters));
        return buildAuthorizationHeaderV2 != null ? buildAuthorizationHeaderV2 : buildAuthorizationHeaderV1(parameters, extractAppSecret(parameters), extractSecretId, activityKind);
    }

    private String buildAuthorizationHeaderV1(Map<String, String> map, String str, String str2, String str3) {
        if (str == null || str.length() == 0) {
            return null;
        }
        Map<String, String> signature = getSignature(map, str3, str);
        String formatString = Util.formatString("Signature %s,%s,%s,%s", Util.formatString("secret_id=\"%s\"", str2), Util.formatString("signature=\"%s\"", Util.sha256(signature.get("clear_signature"))), Util.formatString("algorithm=\"%s\"", "sha256"), Util.formatString("headers=\"%s\"", signature.get("fields")));
        this.logger.verbose("authorizationHeader: %s", formatString);
        return formatString;
    }

    private String buildAuthorizationHeaderV2(String str, String str2, String str3, String str4, String str5) {
        if (str2 == null || str == null || str3 == null) {
            return null;
        }
        String formatString = Util.formatString("signature=\"%s\"", str);
        String formatString2 = Util.formatString("secret_id=\"%s\"", str2);
        String formatString3 = Util.formatString("headers_id=\"%s\"", str3);
        Object[] objArr = new Object[1];
        if (str4 == null) {
            str4 = "adj1";
        }
        objArr[0] = str4;
        String formatString4 = Util.formatString("algorithm=\"%s\"", objArr);
        Object[] objArr2 = new Object[1];
        if (str5 == null) {
            str5 = "";
        }
        objArr2[0] = str5;
        String formatString5 = Util.formatString("Signature %s,%s,%s,%s,%s", formatString, formatString2, formatString4, formatString3, Util.formatString("native_version=\"%s\"", objArr2));
        this.logger.verbose("authorizationHeader: %s", formatString5);
        return formatString5;
    }

    private DataOutputStream configConnectionForGET(HttpsURLConnection httpsURLConnection) {
        httpsURLConnection.setRequestMethod("GET");
        return null;
    }

    private DataOutputStream configConnectionForPOST(HttpsURLConnection httpsURLConnection, ActivityPackage activityPackage, Map<String, String> map) {
        httpsURLConnection.setRequestMethod("POST");
        httpsURLConnection.setUseCaches(false);
        httpsURLConnection.setDoInput(true);
        httpsURLConnection.setDoOutput(true);
        String generatePOSTBodyString = generatePOSTBodyString(activityPackage.getParameters(), map);
        if (generatePOSTBodyString == null) {
            return null;
        }
        DataOutputStream dataOutputStream = new DataOutputStream(httpsURLConnection.getOutputStream());
        dataOutputStream.writeBytes(generatePOSTBodyString);
        return dataOutputStream;
    }

    private String errorMessage(Throwable th, String str, ActivityPackage activityPackage) {
        return Util.formatString("%s. (%s)", activityPackage.getFailureMessage(), Util.getReasonString(str, th));
    }

    private static String extractAlgorithm(Map<String, String> map) {
        return map.remove("algorithm");
    }

    private static String extractAppSecret(Map<String, String> map) {
        return map.remove("app_secret");
    }

    private static void extractEventCallbackId(Map<String, String> map) {
        map.remove("event_callback_id");
    }

    private static String extractHeadersId(Map<String, String> map) {
        return map.remove("headers_id");
    }

    private static String extractNativeVersion(Map<String, String> map) {
        return map.remove("native_version");
    }

    private static String extractSecretId(Map<String, String> map) {
        return map.remove("secret_id");
    }

    private static String extractSignature(Map<String, String> map) {
        return map.remove("signature");
    }

    private String generatePOSTBodyString(Map<String, String> map, Map<String, String> map2) {
        if (map.isEmpty()) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        injectParametersToPOSTStringBuilder(map, sb);
        injectParametersToPOSTStringBuilder(map2, sb);
        if (sb.length() > 0 && sb.charAt(sb.length() - 1) == '&') {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

    private String generateUrlStringForGET(ActivityPackage activityPackage, Map<String, String> map) {
        URL url = new URL(urlWithExtraPathByActivityKind(activityPackage.getActivityKind(), this.urlStrategy.targetUrlByActivityKind(activityPackage.getActivityKind())));
        Uri.Builder builder = new Uri.Builder();
        builder.scheme(url.getProtocol());
        builder.encodedAuthority(url.getAuthority());
        builder.path(url.getPath());
        builder.appendPath(activityPackage.getPath());
        this.logger.debug("Making request to url: %s", builder.toString());
        for (Map.Entry<String, String> entry : activityPackage.getParameters().entrySet()) {
            builder.appendQueryParameter(entry.getKey(), entry.getValue());
        }
        if (map != null) {
            for (Map.Entry<String, String> entry2 : map.entrySet()) {
                builder.appendQueryParameter(entry2.getKey(), entry2.getValue());
            }
        }
        return builder.build().toString();
    }

    private String generateUrlStringForPOST(ActivityPackage activityPackage) {
        String formatString = Util.formatString("%s%s", urlWithExtraPathByActivityKind(activityPackage.getActivityKind(), this.urlStrategy.targetUrlByActivityKind(activityPackage.getActivityKind())), activityPackage.getPath());
        this.logger.debug("Making request to url : %s", formatString);
        return formatString;
    }

    private Map<String, String> getSignature(Map<String, String> map, String str, String str2) {
        String validIdentifier = getValidIdentifier(map);
        String str3 = map.get("source");
        String str4 = map.get("payload");
        HashMap hashMap = new HashMap();
        hashMap.put("app_secret", str2);
        hashMap.put("created_at", map.get("created_at"));
        hashMap.put("activity_kind", str);
        hashMap.put(validIdentifier, map.get(validIdentifier));
        if (str3 != null) {
            hashMap.put("source", str3);
        }
        if (str4 != null) {
            hashMap.put("payload", str4);
        }
        String str5 = "";
        String str6 = "";
        for (Map.Entry entry : hashMap.entrySet()) {
            if (entry.getValue() != null) {
                str5 = str5 + ((String) entry.getKey()) + " ";
                str6 = str6 + ((String) entry.getValue());
            }
        }
        String substring = str5.substring(0, str5.length() - 1);
        HashMap hashMap2 = new HashMap();
        hashMap2.put("clear_signature", str6);
        hashMap2.put("fields", substring);
        return hashMap2;
    }

    private String getValidIdentifier(Map<String, String> map) {
        if (map.get("gps_adid") != null) {
            return "gps_adid";
        }
        if (map.get("fire_adid") != null) {
            return "fire_adid";
        }
        if (map.get("android_id") != null) {
            return "android_id";
        }
        if (map.get("mac_sha1") != null) {
            return "mac_sha1";
        }
        if (map.get("mac_md5") != null) {
            return "mac_md5";
        }
        if (map.get("android_uuid") == null) {
            return null;
        }
        return "android_uuid";
    }

    private void injectParametersToPOSTStringBuilder(Map<String, String> map, StringBuilder sb) {
        if (map == null || map.isEmpty()) {
            return;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String encode = URLEncoder.encode(entry.getKey(), "UTF-8");
            String value = entry.getValue();
            String encode2 = value != null ? URLEncoder.encode(value, "UTF-8") : "";
            sb.append(encode);
            sb.append("=");
            sb.append(encode2);
            sb.append("&");
        }
    }

    private void localError(Throwable th, String str, ResponseData responseData) {
        String errorMessage = errorMessage(th, str, responseData.activityPackage);
        this.logger.error(errorMessage, new Object[0]);
        responseData.message = errorMessage;
        responseData.willRetry = false;
    }

    private void parseResponse(ResponseData responseData, String str) {
        if (str.length() == 0) {
            this.logger.error("Empty response string", new Object[0]);
            return;
        }
        JSONObject jSONObject = null;
        try {
            jSONObject = new JSONObject(str);
        } catch (JSONException e) {
            this.logger.error(errorMessage(e, "Failed to parse JSON response", responseData.activityPackage), new Object[0]);
        }
        if (jSONObject == null) {
            return;
        }
        responseData.jsonResponse = jSONObject;
        responseData.message = UtilNetworking.extractJsonString(jSONObject, b.g);
        responseData.adid = UtilNetworking.extractJsonString(jSONObject, "adid");
        responseData.timestamp = UtilNetworking.extractJsonString(jSONObject, "timestamp");
        String extractJsonString = UtilNetworking.extractJsonString(jSONObject, "tracking_state");
        if (extractJsonString != null && extractJsonString.equals("opted_out")) {
            responseData.trackingState = TrackingState.OPTED_OUT;
        }
        responseData.askIn = UtilNetworking.extractJsonLong(jSONObject, "ask_in");
        responseData.retryIn = UtilNetworking.extractJsonLong(jSONObject, "retry_in");
        responseData.continueIn = UtilNetworking.extractJsonLong(jSONObject, "continue_in");
        responseData.attribution = AdjustAttribution.fromJson(jSONObject.optJSONObject("attribution"), responseData.adid, Util.getSdkPrefixPlatform(this.clientSdk));
    }

    private void remoteError(Throwable th, String str, ResponseData responseData) {
        String str2 = errorMessage(th, str, responseData.activityPackage) + " Will retry later";
        this.logger.error(str2, new Object[0]);
        responseData.message = str2;
        responseData.willRetry = true;
    }

    private boolean shouldRetryToSend(ResponseData responseData) {
        if (!responseData.willRetry) {
            this.logger.debug("Will not retry with current url strategy", new Object[0]);
            this.urlStrategy.resetAfterSuccess();
            return false;
        } else if (this.urlStrategy.shouldRetryAfterFailure(responseData.activityKind)) {
            this.logger.error("Failed with current url strategy, but it will retry with new", new Object[0]);
            return true;
        } else {
            this.logger.error("Failed with current url strategy and it will not retry", new Object[0]);
            return false;
        }
    }

    private void tryToGetResponse(ResponseData responseData) {
        String generateUrlStringForPOST;
        DataOutputStream dataOutputStream = null;
        try {
            try {
                try {
                    try {
                        try {
                            try {
                                ActivityPackage activityPackage = responseData.activityPackage;
                                Map<String, String> map = responseData.sendingParameters;
                                boolean z = true;
                                boolean z2 = responseData.activityPackage.getActivityKind() == ActivityKind.ATTRIBUTION;
                                if (z2) {
                                    extractEventCallbackId(activityPackage.getParameters());
                                    generateUrlStringForPOST = generateUrlStringForGET(activityPackage, map);
                                } else {
                                    generateUrlStringForPOST = generateUrlStringForPOST(activityPackage);
                                }
                                HttpsURLConnection generateHttpsURLConnection = this.httpsURLConnectionProvider.generateHttpsURLConnection(new URL(generateUrlStringForPOST));
                                this.connectionOptions.applyConnectionOptions(generateHttpsURLConnection, activityPackage.getClientSdk());
                                String buildAuthorizationHeader = buildAuthorizationHeader(activityPackage);
                                if (buildAuthorizationHeader != null) {
                                    generateHttpsURLConnection.setRequestProperty("Authorization", buildAuthorizationHeader);
                                }
                                if (z2) {
                                    dataOutputStream = configConnectionForGET(generateHttpsURLConnection);
                                } else {
                                    extractEventCallbackId(activityPackage.getParameters());
                                    dataOutputStream = configConnectionForPOST(generateHttpsURLConnection, activityPackage, map);
                                }
                                Integer readConnectionResponse = readConnectionResponse(generateHttpsURLConnection, responseData);
                                responseData.success = responseData.jsonResponse != null && responseData.retryIn == null && readConnectionResponse != null && readConnectionResponse.intValue() == 200;
                                if (responseData.jsonResponse != null && responseData.retryIn == null) {
                                    z = false;
                                }
                                responseData.willRetry = z;
                                if (dataOutputStream == null) {
                                    return;
                                }
                                dataOutputStream.flush();
                                dataOutputStream.close();
                            } catch (UnsupportedEncodingException e) {
                                localError(e, "Failed to encode parameters", responseData);
                                if (dataOutputStream == null) {
                                    return;
                                }
                                dataOutputStream.flush();
                                dataOutputStream.close();
                            } catch (MalformedURLException e2) {
                                localError(e2, "Malformed URL", responseData);
                                if (dataOutputStream == null) {
                                    return;
                                }
                                dataOutputStream.flush();
                                dataOutputStream.close();
                            }
                        } catch (ProtocolException e3) {
                            localError(e3, "Protocol Error", responseData);
                            if (dataOutputStream == null) {
                                return;
                            }
                            dataOutputStream.flush();
                            dataOutputStream.close();
                        } catch (SSLHandshakeException e4) {
                            remoteError(e4, "Certificate failed", responseData);
                            if (dataOutputStream == null) {
                                return;
                            }
                            dataOutputStream.flush();
                            dataOutputStream.close();
                        }
                    } catch (IOException e5) {
                        remoteError(e5, "Request failed", responseData);
                        if (dataOutputStream == null) {
                            return;
                        }
                        dataOutputStream.flush();
                        dataOutputStream.close();
                    } catch (Throwable th) {
                        localError(th, "Sending SDK package", responseData);
                        if (dataOutputStream == null) {
                            return;
                        }
                        dataOutputStream.flush();
                        dataOutputStream.close();
                    }
                } catch (SocketTimeoutException e6) {
                    remoteError(e6, "Request timed out", responseData);
                    if (dataOutputStream == null) {
                        return;
                    }
                    dataOutputStream.flush();
                    dataOutputStream.close();
                }
            } catch (IOException e7) {
                this.logger.error(errorMessage(e7, "Flushing and closing connection output stream", responseData.activityPackage), new Object[0]);
            }
        } catch (Throwable th2) {
            if (0 != 0) {
                try {
                    dataOutputStream.flush();
                    dataOutputStream.close();
                } catch (IOException e8) {
                    this.logger.error(errorMessage(e8, "Flushing and closing connection output stream", responseData.activityPackage), new Object[0]);
                }
            }
            throw th2;
        }
    }

    private String urlWithExtraPathByActivityKind(ActivityKind activityKind, String str) {
        if (activityKind == ActivityKind.GDPR) {
            if (this.gdprPath == null) {
                return str;
            }
            return str + this.gdprPath;
        } else if (activityKind == ActivityKind.SUBSCRIPTION) {
            if (this.subscriptionPath == null) {
                return str;
            }
            return str + this.subscriptionPath;
        } else if (this.basePath == null) {
            return str;
        } else {
            return str + this.basePath;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x004f, code lost:
        if (r7 == null) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0056, code lost:
        if (r0.length() != 0) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0058, code lost:
        r7 = r6.logger;
        r8 = "Empty response string buffer";
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x005c, code lost:
        r7.error(r8, new java.lang.Object[0]);
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0061, code lost:
        return r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0068, code lost:
        if (r2.intValue() != 429) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x006a, code lost:
        r7 = r6.logger;
        r8 = "Too frequent requests to the endpoint (429)";
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x006f, code lost:
        r7 = r0.toString();
        r6.logger.debug("Response string: %s", r7);
        parseResponse(r8, r7);
        r7 = r8.message;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0084, code lost:
        if (r7 != null) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0086, code lost:
        return r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0087, code lost:
        if (r2 == null) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x008f, code lost:
        if (r2.intValue() != 200) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0091, code lost:
        r6.logger.info("Response message: %s", r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x009d, code lost:
        r6.logger.error("Response message: %s", r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00a8, code lost:
        return r2;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    Integer readConnectionResponse(HttpsURLConnection httpsURLConnection, ResponseData responseData) {
        StringBuilder sb = new StringBuilder();
        Integer num = null;
        try {
            try {
                httpsURLConnection.connect();
                num = Integer.valueOf(httpsURLConnection.getResponseCode());
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(num.intValue() >= 400 ? httpsURLConnection.getErrorStream() : httpsURLConnection.getInputStream()));
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    sb.append(readLine);
                }
            } catch (IOException e) {
                this.logger.error(errorMessage(e, "Connecting and reading response", responseData.activityPackage), new Object[0]);
            }
        } finally {
            if (httpsURLConnection != null) {
                httpsURLConnection.disconnect();
            }
        }
    }

    @Override // com.adjust.sdk.network.IActivityPackageSender
    public void sendActivityPackage(final ActivityPackage activityPackage, final Map<String, String> map, final IActivityPackageSender.ResponseDataCallbackSubscriber responseDataCallbackSubscriber) {
        this.executor.submit(new Runnable() { // from class: com.adjust.sdk.network.ActivityPackageSender.1
            @Override // java.lang.Runnable
            public void run() {
                responseDataCallbackSubscriber.onResponseDataCallback(ActivityPackageSender.this.sendActivityPackageSync(activityPackage, map));
            }
        });
    }

    @Override // com.adjust.sdk.network.IActivityPackageSender
    public ResponseData sendActivityPackageSync(ActivityPackage activityPackage, Map<String, String> map) {
        ResponseData buildResponseData;
        do {
            buildResponseData = ResponseData.buildResponseData(activityPackage, map);
            tryToGetResponse(buildResponseData);
        } while (shouldRetryToSend(buildResponseData));
        return buildResponseData;
    }
}
