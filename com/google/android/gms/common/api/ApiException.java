package com.google.android.gms.common.api;

/* loaded from: classes.dex */
public class ApiException extends Exception {
    protected final Status a;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ApiException(Status status) {
        super(r3.toString());
        int statusCode = status.getStatusCode();
        String statusMessage = status.getStatusMessage() != null ? status.getStatusMessage() : "";
        StringBuilder sb = new StringBuilder(String.valueOf(statusMessage).length() + 13);
        sb.append(statusCode);
        sb.append(": ");
        sb.append(statusMessage);
        this.a = status;
    }

    public int getStatusCode() {
        return this.a.getStatusCode();
    }

    @Deprecated
    public String getStatusMessage() {
        return this.a.getStatusMessage();
    }
}
