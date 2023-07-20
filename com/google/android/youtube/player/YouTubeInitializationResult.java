package com.google.android.youtube.player;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import com.google.android.youtube.player.internal.ab;
import com.google.android.youtube.player.internal.m;
import com.google.android.youtube.player.internal.y;
import com.google.android.youtube.player.internal.z;

/* loaded from: classes.dex */
public enum YouTubeInitializationResult {
    SUCCESS,
    INTERNAL_ERROR,
    UNKNOWN_ERROR,
    SERVICE_MISSING,
    SERVICE_VERSION_UPDATE_REQUIRED,
    SERVICE_DISABLED,
    SERVICE_INVALID,
    ERROR_CONNECTING_TO_SERVICE,
    CLIENT_LIBRARY_UPDATE_REQUIRED,
    NETWORK_ERROR,
    DEVELOPER_KEY_INVALID,
    INVALID_APPLICATION_SIGNATURE;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class a implements DialogInterface.OnClickListener {
        private final Activity a;
        private final Intent b;
        private final int c;

        public a(Activity activity, Intent intent, int i) {
            this.a = (Activity) ab.a(activity);
            this.b = (Intent) ab.a(intent);
            this.c = ((Integer) ab.a(Integer.valueOf(i))).intValue();
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface dialogInterface, int i) {
            try {
                this.a.startActivityForResult(this.b, this.c);
                dialogInterface.dismiss();
            } catch (ActivityNotFoundException e) {
                y.a("Can't perform resolution for YouTubeInitalizationError", e);
            }
        }
    }

    public final Dialog getErrorDialog(Activity activity, int i) {
        return getErrorDialog(activity, i, null);
    }

    public final Dialog getErrorDialog(Activity activity, int i, DialogInterface.OnCancelListener onCancelListener) {
        Intent b;
        AlertDialog.Builder message;
        String str;
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        if (onCancelListener != null) {
            builder.setOnCancelListener(onCancelListener);
        }
        switch (this) {
            case SERVICE_MISSING:
            case SERVICE_VERSION_UPDATE_REQUIRED:
                b = z.b(z.a(activity));
                break;
            case SERVICE_DISABLED:
                b = z.a(z.a(activity));
                break;
            default:
                b = null;
                break;
        }
        a aVar = new a(activity, b, i);
        m mVar = new m(activity);
        switch (this) {
            case SERVICE_MISSING:
                message = builder.setTitle(mVar.b).setMessage(mVar.c);
                str = mVar.d;
                break;
            case SERVICE_DISABLED:
                message = builder.setTitle(mVar.e).setMessage(mVar.f);
                str = mVar.g;
                break;
            case SERVICE_VERSION_UPDATE_REQUIRED:
                message = builder.setTitle(mVar.h).setMessage(mVar.i);
                str = mVar.j;
                break;
            default:
                String valueOf = String.valueOf(name());
                throw new IllegalArgumentException(valueOf.length() != 0 ? "Unexpected errorReason: ".concat(valueOf) : new String("Unexpected errorReason: "));
        }
        return message.setPositiveButton(str, aVar).create();
    }

    public final boolean isUserRecoverableError() {
        switch (this) {
            case SERVICE_MISSING:
            case SERVICE_DISABLED:
            case SERVICE_VERSION_UPDATE_REQUIRED:
                return true;
            default:
                return false;
        }
    }
}
