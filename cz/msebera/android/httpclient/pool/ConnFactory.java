package cz.msebera.android.httpclient.pool;

/* loaded from: classes.dex */
public interface ConnFactory<T, C> {
    C create(T t);
}
