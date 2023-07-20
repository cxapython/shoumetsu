package androidx.e.a;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

/* loaded from: classes.dex */
public class c extends d implements DialogInterface.OnCancelListener, DialogInterface.OnDismissListener {
    public static final int STYLE_NORMAL = 0;
    public static final int STYLE_NO_FRAME = 2;
    public static final int STYLE_NO_INPUT = 3;
    public static final int STYLE_NO_TITLE = 1;
    int a = 0;
    int b = 0;
    boolean c = true;
    boolean d = true;
    int e = -1;
    Dialog f;
    boolean g;
    boolean h;
    boolean i;

    void a(boolean z) {
        if (this.h) {
            return;
        }
        this.h = true;
        this.i = false;
        Dialog dialog = this.f;
        if (dialog != null) {
            dialog.dismiss();
        }
        this.g = true;
        if (this.e >= 0) {
            getFragmentManager().a(this.e, 1);
            this.e = -1;
            return;
        }
        n a = getFragmentManager().a();
        a.a(this);
        if (z) {
            a.d();
        } else {
            a.c();
        }
    }

    public void dismiss() {
        a(false);
    }

    public void dismissAllowingStateLoss() {
        a(true);
    }

    public Dialog getDialog() {
        return this.f;
    }

    public boolean getShowsDialog() {
        return this.d;
    }

    public int getTheme() {
        return this.b;
    }

    public boolean isCancelable() {
        return this.c;
    }

    @Override // androidx.e.a.d
    public void onActivityCreated(Bundle bundle) {
        Bundle bundle2;
        super.onActivityCreated(bundle);
        if (!this.d) {
            return;
        }
        View view = getView();
        if (view != null) {
            if (view.getParent() != null) {
                throw new IllegalStateException("DialogFragment can not be attached to a container view");
            }
            this.f.setContentView(view);
        }
        e activity = getActivity();
        if (activity != null) {
            this.f.setOwnerActivity(activity);
        }
        this.f.setCancelable(this.c);
        this.f.setOnCancelListener(this);
        this.f.setOnDismissListener(this);
        if (bundle == null || (bundle2 = bundle.getBundle("android:savedDialogState")) == null) {
            return;
        }
        this.f.onRestoreInstanceState(bundle2);
    }

    @Override // androidx.e.a.d
    public void onAttach(Context context) {
        super.onAttach(context);
        if (!this.i) {
            this.h = false;
        }
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
    }

    @Override // androidx.e.a.d
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.d = this.mContainerId == 0;
        if (bundle != null) {
            this.a = bundle.getInt("android:style", 0);
            this.b = bundle.getInt("android:theme", 0);
            this.c = bundle.getBoolean("android:cancelable", true);
            this.d = bundle.getBoolean("android:showsDialog", this.d);
            this.e = bundle.getInt("android:backStackId", -1);
        }
    }

    public Dialog onCreateDialog(Bundle bundle) {
        return new Dialog(getActivity(), getTheme());
    }

    @Override // androidx.e.a.d
    public void onDestroyView() {
        super.onDestroyView();
        Dialog dialog = this.f;
        if (dialog != null) {
            this.g = true;
            dialog.dismiss();
            this.f = null;
        }
    }

    @Override // androidx.e.a.d
    public void onDetach() {
        super.onDetach();
        if (this.i || this.h) {
            return;
        }
        this.h = true;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        if (!this.g) {
            a(true);
        }
    }

    @Override // androidx.e.a.d
    public LayoutInflater onGetLayoutInflater(Bundle bundle) {
        Context i;
        if (!this.d) {
            return super.onGetLayoutInflater(bundle);
        }
        this.f = onCreateDialog(bundle);
        Dialog dialog = this.f;
        if (dialog != null) {
            setupDialog(dialog, this.a);
            i = this.f.getContext();
        } else {
            i = this.mHost.i();
        }
        return (LayoutInflater) i.getSystemService("layout_inflater");
    }

    @Override // androidx.e.a.d
    public void onSaveInstanceState(Bundle bundle) {
        Bundle onSaveInstanceState;
        super.onSaveInstanceState(bundle);
        Dialog dialog = this.f;
        if (dialog != null && (onSaveInstanceState = dialog.onSaveInstanceState()) != null) {
            bundle.putBundle("android:savedDialogState", onSaveInstanceState);
        }
        int i = this.a;
        if (i != 0) {
            bundle.putInt("android:style", i);
        }
        int i2 = this.b;
        if (i2 != 0) {
            bundle.putInt("android:theme", i2);
        }
        boolean z = this.c;
        if (!z) {
            bundle.putBoolean("android:cancelable", z);
        }
        boolean z2 = this.d;
        if (!z2) {
            bundle.putBoolean("android:showsDialog", z2);
        }
        int i3 = this.e;
        if (i3 != -1) {
            bundle.putInt("android:backStackId", i3);
        }
    }

    @Override // androidx.e.a.d
    public void onStart() {
        super.onStart();
        Dialog dialog = this.f;
        if (dialog != null) {
            this.g = false;
            dialog.show();
        }
    }

    @Override // androidx.e.a.d
    public void onStop() {
        super.onStop();
        Dialog dialog = this.f;
        if (dialog != null) {
            dialog.hide();
        }
    }

    public void setCancelable(boolean z) {
        this.c = z;
        Dialog dialog = this.f;
        if (dialog != null) {
            dialog.setCancelable(z);
        }
    }

    public void setShowsDialog(boolean z) {
        this.d = z;
    }

    public void setStyle(int i, int i2) {
        this.a = i;
        int i3 = this.a;
        if (i3 == 2 || i3 == 3) {
            this.b = 16973913;
        }
        if (i2 != 0) {
            this.b = i2;
        }
    }

    public void setupDialog(Dialog dialog, int i) {
        switch (i) {
            case 1:
            case 2:
                break;
            default:
                return;
            case 3:
                dialog.getWindow().addFlags(24);
                break;
        }
        dialog.requestWindowFeature(1);
    }

    public int show(n nVar, String str) {
        this.h = false;
        this.i = true;
        nVar.a(this, str);
        this.g = false;
        this.e = nVar.c();
        return this.e;
    }

    public void show(i iVar, String str) {
        this.h = false;
        this.i = true;
        n a = iVar.a();
        a.a(this, str);
        a.c();
    }

    public void showNow(i iVar, String str) {
        this.h = false;
        this.i = true;
        n a = iVar.a();
        a.a(this, str);
        a.e();
    }
}
