package com.google.android.gms.internal.gtm;

import java.io.IOException;

/* loaded from: classes.dex */
public class zzrk extends IOException {
    private zzsk a;

    public zzrk(String str) {
        super(str);
        this.a = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzrk a() {
        return new zzrk("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzrk b() {
        return new zzrk("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzrk c() {
        return new zzrk("CodedInputStream encountered a malformed varint.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzrk d() {
        return new zzrk("Protocol message end-group tag did not match expected tag.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzrl e() {
        return new zzrl("Protocol message tag had invalid wire type.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzrk f() {
        return new zzrk("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzrk g() {
        return new zzrk("Failed to parse the message.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzrk h() {
        return new zzrk("Protocol message had invalid UTF-8.");
    }

    public final zzrk zzg(zzsk zzskVar) {
        this.a = zzskVar;
        return this;
    }
}
