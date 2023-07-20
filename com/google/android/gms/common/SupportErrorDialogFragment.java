package com.google.android.gms.common;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;

/* loaded from: classes.dex */
public class SupportErrorDialogFragment extends androidx.e.a.c {
    private Dialog j = null;
    private DialogInterface.OnCancelListener k = null;

    public static SupportErrorDialogFragment newInstance(Dialog dialog) {
        return newInstance(dialog, null);
    }

    public static SupportErrorDialogFragment newInstance(Dialog dialog, DialogInterface.OnCancelListener onCancelListener) {
        SupportErrorDialogFragment supportErrorDialogFragment = new SupportErrorDialogFragment();
        Dialog dialog2 = (Dialog) Preconditions.checkNotNull(dialog, "Cannot display null dialog");
        dialog2.setOnCancelListener(null);
        dialog2.setOnDismissListener(null);
        supportErrorDialogFragment.j = dialog2;
        if (onCancelListener != null) {
            supportErrorDialogFragment.k = onCancelListener;
        }
        return supportErrorDialogFragment;
    }

    @Override // androidx.e.a.c, android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        DialogInterface.OnCancelListener onCancelListener = this.k;
        if (onCancelListener != null) {
            onCancelListener.onCancel(dialogInterface);
        }
    }

    @Override // androidx.e.a.c
    public Dialog onCreateDialog(Bundle bundle) {
        if (this.j == null) {
            setShowsDialog(false);
        }
        return this.j;
    }

    @Override // androidx.e.a.c
    public void show(androidx.e.a.i iVar, String str) {
        super.show(iVar, str);
    }
}
