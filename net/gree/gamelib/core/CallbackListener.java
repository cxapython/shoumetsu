package net.gree.gamelib.core;

/* loaded from: classes.dex */
public interface CallbackListener<T> {
    void onError(int i, String str);

    void onSuccess(T t);
}
