package com.google.android.youtube.player.internal;

import android.graphics.Bitmap;
import com.google.android.youtube.player.YouTubeThumbnailLoader;
import com.google.android.youtube.player.YouTubeThumbnailView;
import java.lang.ref.WeakReference;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public abstract class a implements YouTubeThumbnailLoader {
    private final WeakReference<YouTubeThumbnailView> a;
    private YouTubeThumbnailLoader.OnThumbnailLoadedListener b;
    private boolean c;
    private boolean d;

    public a(YouTubeThumbnailView youTubeThumbnailView) {
        this.a = new WeakReference<>(ab.a(youTubeThumbnailView));
    }

    private void i() {
        if (a()) {
            return;
        }
        throw new IllegalStateException("This YouTubeThumbnailLoader has been released");
    }

    public final void a(Bitmap bitmap, String str) {
        YouTubeThumbnailView youTubeThumbnailView = this.a.get();
        if (!a() || youTubeThumbnailView == null) {
            return;
        }
        youTubeThumbnailView.setImageBitmap(bitmap);
        YouTubeThumbnailLoader.OnThumbnailLoadedListener onThumbnailLoadedListener = this.b;
        if (onThumbnailLoadedListener == null) {
            return;
        }
        onThumbnailLoadedListener.onThumbnailLoaded(youTubeThumbnailView, str);
    }

    public abstract void a(String str);

    public abstract void a(String str, int i);

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean a() {
        return !this.d;
    }

    public final void b() {
        if (a()) {
            y.a("The finalize() method for a YouTubeThumbnailLoader has work to do. You should have called release().", new Object[0]);
            release();
        }
    }

    public final void b(String str) {
        YouTubeThumbnailLoader.ErrorReason errorReason;
        YouTubeThumbnailView youTubeThumbnailView = this.a.get();
        if (!a() || this.b == null || youTubeThumbnailView == null) {
            return;
        }
        try {
            errorReason = YouTubeThumbnailLoader.ErrorReason.valueOf(str);
        } catch (IllegalArgumentException | NullPointerException unused) {
            errorReason = YouTubeThumbnailLoader.ErrorReason.UNKNOWN;
        }
        this.b.onThumbnailError(youTubeThumbnailView, errorReason);
    }

    public abstract void c();

    public abstract void d();

    public abstract void e();

    public abstract boolean f();

    @Override // com.google.android.youtube.player.YouTubeThumbnailLoader
    public final void first() {
        i();
        if (this.c) {
            e();
            return;
        }
        throw new IllegalStateException("Must call setPlaylist first");
    }

    public abstract boolean g();

    public abstract void h();

    @Override // com.google.android.youtube.player.YouTubeThumbnailLoader
    public final boolean hasNext() {
        i();
        return f();
    }

    @Override // com.google.android.youtube.player.YouTubeThumbnailLoader
    public final boolean hasPrevious() {
        i();
        return g();
    }

    @Override // com.google.android.youtube.player.YouTubeThumbnailLoader
    public final void next() {
        i();
        if (this.c) {
            if (!f()) {
                throw new NoSuchElementException("Called next at end of playlist");
            }
            c();
            return;
        }
        throw new IllegalStateException("Must call setPlaylist first");
    }

    @Override // com.google.android.youtube.player.YouTubeThumbnailLoader
    public final void previous() {
        i();
        if (this.c) {
            if (!g()) {
                throw new NoSuchElementException("Called previous at start of playlist");
            }
            d();
            return;
        }
        throw new IllegalStateException("Must call setPlaylist first");
    }

    @Override // com.google.android.youtube.player.YouTubeThumbnailLoader
    public final void release() {
        if (a()) {
            this.d = true;
            this.b = null;
            h();
        }
    }

    @Override // com.google.android.youtube.player.YouTubeThumbnailLoader
    public final void setOnThumbnailLoadedListener(YouTubeThumbnailLoader.OnThumbnailLoadedListener onThumbnailLoadedListener) {
        i();
        this.b = onThumbnailLoadedListener;
    }

    @Override // com.google.android.youtube.player.YouTubeThumbnailLoader
    public final void setPlaylist(String str) {
        setPlaylist(str, 0);
    }

    @Override // com.google.android.youtube.player.YouTubeThumbnailLoader
    public final void setPlaylist(String str, int i) {
        i();
        this.c = true;
        a(str, i);
    }

    @Override // com.google.android.youtube.player.YouTubeThumbnailLoader
    public final void setVideo(String str) {
        i();
        this.c = false;
        a(str);
    }
}
