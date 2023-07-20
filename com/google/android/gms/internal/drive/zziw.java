package com.google.android.gms.internal.drive;

import java.io.IOException;

/* loaded from: classes.dex */
public final class zziw extends IOException {
    public zziw(String str) {
        super(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zziw a() {
        return new zziw("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either than the input has been truncated or that an embedded message misreported its own length.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zziw b() {
        return new zziw("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zziw c() {
        return new zziw("CodedInputStream encountered a malformed varint.");
    }
}
