package com.google.android.gms.drive.metadata.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.util.GmsVersion;
import com.google.android.gms.drive.UserMetadata;
import java.util.Arrays;
import java.util.Collections;

/* loaded from: classes.dex */
public final class zzu extends zzm<UserMetadata> {
    public zzu(String str, int i) {
        super(str, Arrays.asList(a(str, "permissionId"), a(str, "displayName"), a(str, "picture"), a(str, "isAuthenticatedUser"), a(str, "emailAddress")), Collections.emptyList(), GmsVersion.VERSION_MANCHEGO);
    }

    private final String a(String str) {
        return a(getName(), str);
    }

    private static String a(String str, String str2) {
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 1 + String.valueOf(str2).length());
        sb.append(str);
        sb.append(".");
        sb.append(str2);
        return sb.toString();
    }

    @Override // com.google.android.gms.drive.metadata.zza
    protected final boolean a(DataHolder dataHolder, int i, int i2) {
        return dataHolder.hasColumn(a("permissionId")) && !dataHolder.hasNull(a("permissionId"), i, i2);
    }

    @Override // com.google.android.gms.drive.metadata.zza
    protected final /* synthetic */ Object b(DataHolder dataHolder, int i, int i2) {
        String string = dataHolder.getString(a("permissionId"), i, i2);
        if (string != null) {
            String string2 = dataHolder.getString(a("displayName"), i, i2);
            String string3 = dataHolder.getString(a("picture"), i, i2);
            Boolean valueOf = Boolean.valueOf(dataHolder.getBoolean(a("isAuthenticatedUser"), i, i2));
            return new UserMetadata(string, string2, string3, valueOf.booleanValue(), dataHolder.getString(a("emailAddress"), i, i2));
        }
        return null;
    }
}
