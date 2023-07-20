package com.google.android.gms.internal.gtm;

import java.io.IOException;

/* loaded from: classes.dex */
public final class zzuv extends IOException {
    public zzuv(String str) {
        super(str);
    }

    public zzuv(String str, Exception exc) {
        super(str, exc);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzuv a() {
        return new zzuv("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either than the input has been truncated or that an embedded message misreported its own length.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzuv b() {
        return new zzuv("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzuv c() {
        return new zzuv("CodedInputStream encountered a malformed varint.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzuv d() {
        return new zzuv("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
    }
}
