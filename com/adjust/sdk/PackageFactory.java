package com.adjust.sdk;

import android.net.Uri;
import android.net.UrlQuerySanitizer;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class PackageFactory {
    private static final String ADJUST_PREFIX = "adjust_";

    public static ActivityPackage buildDeeplinkSdkClickPackage(Uri uri, long j, ActivityState activityState, AdjustConfig adjustConfig, DeviceInfo deviceInfo, SessionParameters sessionParameters) {
        String uri2;
        if (uri == null || (uri2 = uri.toString()) == null || uri2.length() == 0) {
            return null;
        }
        AdjustFactory.getLogger().verbose("Url to parse (%s)", uri);
        UrlQuerySanitizer urlQuerySanitizer = new UrlQuerySanitizer();
        urlQuerySanitizer.setUnregisteredParameterValueSanitizer(UrlQuerySanitizer.getAllButNulLegal());
        urlQuerySanitizer.setAllowUnregisteredParamaters(true);
        urlQuerySanitizer.parseUrl(uri2);
        PackageBuilder queryStringClickPackageBuilder = queryStringClickPackageBuilder(urlQuerySanitizer.getParameterList(), activityState, adjustConfig, deviceInfo, sessionParameters);
        if (queryStringClickPackageBuilder == null) {
            return null;
        }
        queryStringClickPackageBuilder.deeplink = uri.toString();
        queryStringClickPackageBuilder.clickTimeInMilliseconds = j;
        return queryStringClickPackageBuilder.buildClickPackage(Constants.DEEPLINK);
    }

    public static ActivityPackage buildInstallReferrerSdkClickPackage(ReferrerDetails referrerDetails, String str, ActivityState activityState, AdjustConfig adjustConfig, DeviceInfo deviceInfo, SessionParameters sessionParameters) {
        PackageBuilder packageBuilder = new PackageBuilder(adjustConfig, deviceInfo, activityState, sessionParameters, System.currentTimeMillis());
        packageBuilder.referrer = referrerDetails.installReferrer;
        packageBuilder.clickTimeInSeconds = referrerDetails.referrerClickTimestampSeconds;
        packageBuilder.installBeginTimeInSeconds = referrerDetails.installBeginTimestampSeconds;
        packageBuilder.clickTimeServerInSeconds = referrerDetails.referrerClickTimestampServerSeconds;
        packageBuilder.installBeginTimeServerInSeconds = referrerDetails.installBeginTimestampServerSeconds;
        packageBuilder.installVersion = referrerDetails.installVersion;
        packageBuilder.googlePlayInstant = referrerDetails.googlePlayInstant;
        packageBuilder.referrerApi = str;
        return packageBuilder.buildClickPackage(Constants.INSTALL_REFERRER);
    }

    public static ActivityPackage buildPreinstallSdkClickPackage(String str, String str2, ActivityState activityState, AdjustConfig adjustConfig, DeviceInfo deviceInfo, SessionParameters sessionParameters) {
        if (str == null || str.length() == 0) {
            return null;
        }
        PackageBuilder packageBuilder = new PackageBuilder(adjustConfig, deviceInfo, activityState, sessionParameters, System.currentTimeMillis());
        packageBuilder.preinstallPayload = str;
        packageBuilder.preinstallLocation = str2;
        return packageBuilder.buildClickPackage(Constants.PREINSTALL);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0076 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0077  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static ActivityPackage buildReftagSdkClickPackage(String str, long j, ActivityState activityState, AdjustConfig adjustConfig, DeviceInfo deviceInfo, SessionParameters sessionParameters) {
        String str2;
        ILogger logger;
        String str3;
        Object[] objArr;
        PackageBuilder queryStringClickPackageBuilder;
        if (str == null || str.length() == 0) {
            return null;
        }
        try {
            str2 = URLDecoder.decode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            str2 = Constants.MALFORMED;
            logger = AdjustFactory.getLogger();
            str3 = "Referrer decoding failed due to UnsupportedEncodingException. Message: (%s)";
            objArr = new Object[]{e.getMessage()};
            logger.error(str3, objArr);
            AdjustFactory.getLogger().verbose("Referrer to parse (%s)", str2);
            UrlQuerySanitizer urlQuerySanitizer = new UrlQuerySanitizer();
            urlQuerySanitizer.setUnregisteredParameterValueSanitizer(UrlQuerySanitizer.getAllButNulLegal());
            urlQuerySanitizer.setAllowUnregisteredParamaters(true);
            urlQuerySanitizer.parseQuery(str2);
            queryStringClickPackageBuilder = queryStringClickPackageBuilder(urlQuerySanitizer.getParameterList(), activityState, adjustConfig, deviceInfo, sessionParameters);
            if (queryStringClickPackageBuilder != null) {
            }
        } catch (IllegalArgumentException e2) {
            str2 = Constants.MALFORMED;
            logger = AdjustFactory.getLogger();
            str3 = "Referrer decoding failed due to IllegalArgumentException. Message: (%s)";
            objArr = new Object[]{e2.getMessage()};
            logger.error(str3, objArr);
            AdjustFactory.getLogger().verbose("Referrer to parse (%s)", str2);
            UrlQuerySanitizer urlQuerySanitizer2 = new UrlQuerySanitizer();
            urlQuerySanitizer2.setUnregisteredParameterValueSanitizer(UrlQuerySanitizer.getAllButNulLegal());
            urlQuerySanitizer2.setAllowUnregisteredParamaters(true);
            urlQuerySanitizer2.parseQuery(str2);
            queryStringClickPackageBuilder = queryStringClickPackageBuilder(urlQuerySanitizer2.getParameterList(), activityState, adjustConfig, deviceInfo, sessionParameters);
            if (queryStringClickPackageBuilder != null) {
            }
        } catch (Exception e3) {
            str2 = Constants.MALFORMED;
            logger = AdjustFactory.getLogger();
            str3 = "Referrer decoding failed. Message: (%s)";
            objArr = new Object[]{e3.getMessage()};
            logger.error(str3, objArr);
            AdjustFactory.getLogger().verbose("Referrer to parse (%s)", str2);
            UrlQuerySanitizer urlQuerySanitizer22 = new UrlQuerySanitizer();
            urlQuerySanitizer22.setUnregisteredParameterValueSanitizer(UrlQuerySanitizer.getAllButNulLegal());
            urlQuerySanitizer22.setAllowUnregisteredParamaters(true);
            urlQuerySanitizer22.parseQuery(str2);
            queryStringClickPackageBuilder = queryStringClickPackageBuilder(urlQuerySanitizer22.getParameterList(), activityState, adjustConfig, deviceInfo, sessionParameters);
            if (queryStringClickPackageBuilder != null) {
            }
        }
        AdjustFactory.getLogger().verbose("Referrer to parse (%s)", str2);
        UrlQuerySanitizer urlQuerySanitizer222 = new UrlQuerySanitizer();
        urlQuerySanitizer222.setUnregisteredParameterValueSanitizer(UrlQuerySanitizer.getAllButNulLegal());
        urlQuerySanitizer222.setAllowUnregisteredParamaters(true);
        urlQuerySanitizer222.parseQuery(str2);
        queryStringClickPackageBuilder = queryStringClickPackageBuilder(urlQuerySanitizer222.getParameterList(), activityState, adjustConfig, deviceInfo, sessionParameters);
        if (queryStringClickPackageBuilder != null) {
            return null;
        }
        queryStringClickPackageBuilder.referrer = str2;
        queryStringClickPackageBuilder.clickTimeInMilliseconds = j;
        queryStringClickPackageBuilder.rawReferrer = str;
        return queryStringClickPackageBuilder.buildClickPackage(Constants.REFTAG);
    }

    private static PackageBuilder queryStringClickPackageBuilder(List<UrlQuerySanitizer.ParameterValuePair> list, ActivityState activityState, AdjustConfig adjustConfig, DeviceInfo deviceInfo, SessionParameters sessionParameters) {
        if (list == null) {
            return null;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        AdjustAttribution adjustAttribution = new AdjustAttribution();
        for (UrlQuerySanitizer.ParameterValuePair parameterValuePair : list) {
            readQueryString(parameterValuePair.mParameter, parameterValuePair.mValue, linkedHashMap, adjustAttribution);
        }
        long currentTimeMillis = System.currentTimeMillis();
        String str = (String) linkedHashMap.remove(Constants.REFTAG);
        if (activityState != null) {
            activityState.lastInterval = currentTimeMillis - activityState.lastActivity;
        }
        PackageBuilder packageBuilder = new PackageBuilder(adjustConfig, deviceInfo, activityState, sessionParameters, currentTimeMillis);
        packageBuilder.extraParameters = linkedHashMap;
        packageBuilder.attribution = adjustAttribution;
        packageBuilder.reftag = str;
        return packageBuilder;
    }

    private static boolean readQueryString(String str, String str2, Map<String, String> map, AdjustAttribution adjustAttribution) {
        if (str == null || str2 == null || !str.startsWith(ADJUST_PREFIX)) {
            return false;
        }
        String substring = str.substring(7);
        if (substring.length() == 0 || str2.length() == 0) {
            return false;
        }
        if (tryToSetAttribution(adjustAttribution, substring, str2)) {
            return true;
        }
        map.put(substring, str2);
        return true;
    }

    private static boolean tryToSetAttribution(AdjustAttribution adjustAttribution, String str, String str2) {
        if (str.equals("tracker")) {
            adjustAttribution.trackerName = str2;
            return true;
        } else if (str.equals("campaign")) {
            adjustAttribution.campaign = str2;
            return true;
        } else if (str.equals("adgroup")) {
            adjustAttribution.adgroup = str2;
            return true;
        } else if (!str.equals("creative")) {
            return false;
        } else {
            adjustAttribution.creative = str2;
            return true;
        }
    }
}
