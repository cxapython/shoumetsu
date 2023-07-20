package cz.msebera.android.httpclient;

/* loaded from: classes.dex */
public interface Header {
    HeaderElement[] getElements();

    String getName();

    String getValue();
}
