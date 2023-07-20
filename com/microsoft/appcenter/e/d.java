package com.microsoft.appcenter.e;

import java.util.UUID;

/* loaded from: classes.dex */
public class d {
    public static UUID a() {
        try {
            return UUID.fromString(com.microsoft.appcenter.e.d.d.a("installId", ""));
        } catch (Exception unused) {
            a.d("AppCenter", "Unable to get installID from Shared Preferences");
            UUID randomUUID = UUID.randomUUID();
            com.microsoft.appcenter.e.d.d.b("installId", randomUUID.toString());
            return randomUUID;
        }
    }
}
