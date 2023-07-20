package com.microsoft.appcenter;

/* loaded from: classes.dex */
class h {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(String str) {
        try {
            String string = com.microsoft.appcenter.e.e.a().getString("APP_CENTER_DISABLE");
            if (string == null) {
                return false;
            }
            for (String str2 : string.split(",")) {
                String trim = str2.trim();
                if (trim.equals("All") || trim.equals(str)) {
                    return true;
                }
            }
            return false;
        } catch (IllegalStateException | LinkageError unused) {
            com.microsoft.appcenter.e.a.b("AppCenter", "Cannot read instrumentation variables in a non-test environment.");
            return false;
        }
    }
}
