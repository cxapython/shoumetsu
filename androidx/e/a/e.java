package androidx.e.a;

import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import androidx.core.app.a;
import androidx.lifecycle.e;
import com.google.android.gms.games.request.GameRequest;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* loaded from: classes.dex */
public class e extends androidx.core.app.d implements a.InterfaceC0021a, a.c, androidx.lifecycle.s {
    boolean c;
    boolean d;
    boolean f;
    boolean g;
    boolean h;
    int i;
    androidx.b.h<String> j;
    private androidx.lifecycle.r k;
    final Handler a = new Handler() { // from class: androidx.e.a.e.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 2) {
                super.handleMessage(message);
                return;
            }
            e.this.a();
            e.this.b.m();
        }
    };
    final g b = g.a(new a());
    boolean e = true;

    /* loaded from: classes.dex */
    class a extends h<e> {
        public a() {
            super(e.this);
        }

        @Override // androidx.e.a.h, androidx.e.a.f
        public View a(int i) {
            return e.this.findViewById(i);
        }

        @Override // androidx.e.a.h
        public void a(d dVar, Intent intent, int i, Bundle bundle) {
            e.this.a(dVar, intent, i, bundle);
        }

        @Override // androidx.e.a.h
        public void a(d dVar, IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) {
            e.this.a(dVar, intentSender, i, intent, i2, i3, i4, bundle);
        }

        @Override // androidx.e.a.h
        public void a(d dVar, String[] strArr, int i) {
            e.this.a(dVar, strArr, i);
        }

        @Override // androidx.e.a.h
        public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            e.this.dump(str, fileDescriptor, printWriter, strArr);
        }

        @Override // androidx.e.a.h, androidx.e.a.f
        public boolean a() {
            Window window = e.this.getWindow();
            return (window == null || window.peekDecorView() == null) ? false : true;
        }

        @Override // androidx.e.a.h
        public boolean a(d dVar) {
            return !e.this.isFinishing();
        }

        @Override // androidx.e.a.h
        public boolean a(String str) {
            return androidx.core.app.a.a(e.this, str);
        }

        @Override // androidx.e.a.h
        public LayoutInflater b() {
            return e.this.getLayoutInflater().cloneInContext(e.this);
        }

        @Override // androidx.e.a.h
        public void b(d dVar) {
            e.this.a(dVar);
        }

        @Override // androidx.e.a.h
        /* renamed from: c */
        public e g() {
            return e.this;
        }

        @Override // androidx.e.a.h
        public void d() {
            e.this.c();
        }

        @Override // androidx.e.a.h
        public boolean e() {
            return e.this.getWindow() != null;
        }

        @Override // androidx.e.a.h
        public int f() {
            Window window = e.this.getWindow();
            if (window == null) {
                return 0;
            }
            return window.getAttributes().windowAnimations;
        }
    }

    /* loaded from: classes.dex */
    static final class b {
        Object a;
        androidx.lifecycle.r b;
        k c;

        b() {
        }
    }

    private static boolean a(i iVar, e.b bVar) {
        boolean z = false;
        for (d dVar : iVar.c()) {
            if (dVar != null) {
                if (dVar.getLifecycle().a().a(e.b.STARTED)) {
                    dVar.mLifecycleRegistry.a(bVar);
                    z = true;
                }
                i peekChildFragmentManager = dVar.peekChildFragmentManager();
                if (peekChildFragmentManager != null) {
                    z |= a(peekChildFragmentManager, bVar);
                }
            }
        }
        return z;
    }

    private int b(d dVar) {
        if (this.j.b() < 65534) {
            while (this.j.f(this.i) >= 0) {
                this.i = (this.i + 1) % 65534;
            }
            int i = this.i;
            this.j.b(i, dVar.mWho);
            this.i = (this.i + 1) % 65534;
            return i;
        }
        throw new IllegalStateException("Too many pending Fragment activity results.");
    }

    static void b(int i) {
        if ((i & (-65536)) == 0) {
            return;
        }
        throw new IllegalArgumentException("Can only use lower 16 bits for requestCode");
    }

    private void e() {
        do {
        } while (a(d(), e.b.CREATED));
    }

    final View a(View view, String str, Context context, AttributeSet attributeSet) {
        return this.b.a(view, str, context, attributeSet);
    }

    protected void a() {
        this.b.h();
    }

    @Override // androidx.core.app.a.c
    public final void a(int i) {
        if (this.f || i == -1) {
            return;
        }
        b(i);
    }

    public void a(d dVar) {
    }

    public void a(d dVar, Intent intent, int i, Bundle bundle) {
        this.h = true;
        try {
            if (i == -1) {
                androidx.core.app.a.a(this, intent, -1, bundle);
                return;
            }
            b(i);
            androidx.core.app.a.a(this, intent, ((b(dVar) + 1) << 16) + (i & GameRequest.TYPE_ALL), bundle);
        } finally {
            this.h = false;
        }
    }

    public void a(d dVar, IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) {
        this.g = true;
        try {
            if (i == -1) {
                androidx.core.app.a.a(this, intentSender, i, intent, i2, i3, i4, bundle);
                return;
            }
            b(i);
            androidx.core.app.a.a(this, intentSender, ((b(dVar) + 1) << 16) + (i & GameRequest.TYPE_ALL), intent, i2, i3, i4, bundle);
        } finally {
            this.g = false;
        }
    }

    void a(d dVar, String[] strArr, int i) {
        if (i == -1) {
            androidx.core.app.a.a(this, strArr, i);
            return;
        }
        b(i);
        try {
            this.f = true;
            androidx.core.app.a.a(this, strArr, ((b(dVar) + 1) << 16) + (i & GameRequest.TYPE_ALL));
        } finally {
            this.f = false;
        }
    }

    protected boolean a(View view, Menu menu) {
        return super.onPreparePanel(0, view, menu);
    }

    public Object b() {
        return null;
    }

    @Deprecated
    public void c() {
        invalidateOptionsMenu();
    }

    public i d() {
        return this.b.a();
    }

    @Override // android.app.Activity
    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        printWriter.print(str);
        printWriter.print("Local FragmentActivity ");
        printWriter.print(Integer.toHexString(System.identityHashCode(this)));
        printWriter.println(" State:");
        String str2 = str + "  ";
        printWriter.print(str2);
        printWriter.print("mCreated=");
        printWriter.print(this.c);
        printWriter.print(" mResumed=");
        printWriter.print(this.d);
        printWriter.print(" mStopped=");
        printWriter.print(this.e);
        if (getApplication() != null) {
            androidx.h.a.a.a(this).a(str2, fileDescriptor, printWriter, strArr);
        }
        this.b.a().a(str, fileDescriptor, printWriter, strArr);
    }

    @Override // androidx.core.app.d, androidx.lifecycle.g
    public androidx.lifecycle.e getLifecycle() {
        return super.getLifecycle();
    }

    @Override // androidx.lifecycle.s
    public androidx.lifecycle.r getViewModelStore() {
        if (getApplication() != null) {
            if (this.k == null) {
                b bVar = (b) getLastNonConfigurationInstance();
                if (bVar != null) {
                    this.k = bVar.b;
                }
                if (this.k == null) {
                    this.k = new androidx.lifecycle.r();
                }
            }
            return this.k;
        }
        throw new IllegalStateException("Your activity is not yet attached to the Application instance. You can't request ViewModel before onCreate call.");
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        this.b.b();
        int i3 = i >> 16;
        if (i3 == 0) {
            a.b a2 = androidx.core.app.a.a();
            if (a2 != null && a2.a(this, i, i2, intent)) {
                return;
            }
            super.onActivityResult(i, i2, intent);
            return;
        }
        int i4 = i3 - 1;
        String a3 = this.j.a(i4);
        this.j.c(i4);
        if (a3 == null) {
            Log.w("FragmentActivity", "Activity result delivered for unknown Fragment.");
            return;
        }
        d a4 = this.b.a(a3);
        if (a4 != null) {
            a4.onActivityResult(i & GameRequest.TYPE_ALL, i2, intent);
            return;
        }
        Log.w("FragmentActivity", "Activity result no fragment exists for who: " + a3);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        i a2 = this.b.a();
        boolean d = a2.d();
        if (!d || Build.VERSION.SDK_INT > 25) {
            if (!d && a2.b()) {
                return;
            }
            super.onBackPressed();
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.b.b();
        this.b.a(configuration);
    }

    @Override // androidx.core.app.d, android.app.Activity
    protected void onCreate(Bundle bundle) {
        k kVar = null;
        this.b.a((d) null);
        super.onCreate(bundle);
        b bVar = (b) getLastNonConfigurationInstance();
        if (bVar != null && bVar.b != null && this.k == null) {
            this.k = bVar.b;
        }
        if (bundle != null) {
            Parcelable parcelable = bundle.getParcelable("android:support:fragments");
            g gVar = this.b;
            if (bVar != null) {
                kVar = bVar.c;
            }
            gVar.a(parcelable, kVar);
            if (bundle.containsKey("android:support:next_request_index")) {
                this.i = bundle.getInt("android:support:next_request_index");
                int[] intArray = bundle.getIntArray("android:support:request_indicies");
                String[] stringArray = bundle.getStringArray("android:support:request_fragment_who");
                if (intArray == null || stringArray == null || intArray.length != stringArray.length) {
                    Log.w("FragmentActivity", "Invalid requestCode mapping in savedInstanceState.");
                } else {
                    this.j = new androidx.b.h<>(intArray.length);
                    for (int i = 0; i < intArray.length; i++) {
                        this.j.b(intArray[i], stringArray[i]);
                    }
                }
            }
        }
        if (this.j == null) {
            this.j = new androidx.b.h<>();
            this.i = 0;
        }
        this.b.e();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onCreatePanelMenu(int i, Menu menu) {
        return i == 0 ? super.onCreatePanelMenu(i, menu) | this.b.a(menu, getMenuInflater()) : super.onCreatePanelMenu(i, menu);
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory2
    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        View a2 = a(view, str, context, attributeSet);
        return a2 == null ? super.onCreateView(view, str, context, attributeSet) : a2;
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        View a2 = a((View) null, str, context, attributeSet);
        return a2 == null ? super.onCreateView(str, context, attributeSet) : a2;
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        if (this.k != null && !isChangingConfigurations()) {
            this.k.a();
        }
        this.b.k();
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onLowMemory() {
        super.onLowMemory();
        this.b.l();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuItemSelected(int i, MenuItem menuItem) {
        if (super.onMenuItemSelected(i, menuItem)) {
            return true;
        }
        if (i == 0) {
            return this.b.a(menuItem);
        }
        if (i == 6) {
            return this.b.b(menuItem);
        }
        return false;
    }

    @Override // android.app.Activity
    public void onMultiWindowModeChanged(boolean z) {
        this.b.a(z);
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        this.b.b();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int i, Menu menu) {
        if (i == 0) {
            this.b.b(menu);
        }
        super.onPanelClosed(i, menu);
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        this.d = false;
        if (this.a.hasMessages(2)) {
            this.a.removeMessages(2);
            a();
        }
        this.b.i();
    }

    @Override // android.app.Activity
    public void onPictureInPictureModeChanged(boolean z) {
        this.b.b(z);
    }

    @Override // android.app.Activity
    protected void onPostResume() {
        super.onPostResume();
        this.a.removeMessages(2);
        a();
        this.b.m();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onPreparePanel(int i, View view, Menu menu) {
        return (i != 0 || menu == null) ? super.onPreparePanel(i, view, menu) : a(view, menu) | this.b.a(menu);
    }

    @Override // android.app.Activity, androidx.core.app.a.InterfaceC0021a
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        this.b.b();
        int i2 = (i >> 16) & GameRequest.TYPE_ALL;
        if (i2 != 0) {
            int i3 = i2 - 1;
            String a2 = this.j.a(i3);
            this.j.c(i3);
            if (a2 == null) {
                Log.w("FragmentActivity", "Activity result delivered for unknown Fragment.");
                return;
            }
            d a3 = this.b.a(a2);
            if (a3 != null) {
                a3.onRequestPermissionsResult(i & GameRequest.TYPE_ALL, strArr, iArr);
                return;
            }
            Log.w("FragmentActivity", "Activity result no fragment exists for who: " + a2);
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        this.a.sendEmptyMessage(2);
        this.d = true;
        this.b.m();
    }

    @Override // android.app.Activity
    public final Object onRetainNonConfigurationInstance() {
        Object b2 = b();
        k d = this.b.d();
        if (d == null && this.k == null && b2 == null) {
            return null;
        }
        b bVar = new b();
        bVar.a = b2;
        bVar.b = this.k;
        bVar.c = d;
        return bVar;
    }

    @Override // androidx.core.app.d, android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        e();
        Parcelable c = this.b.c();
        if (c != null) {
            bundle.putParcelable("android:support:fragments", c);
        }
        if (this.j.b() > 0) {
            bundle.putInt("android:support:next_request_index", this.i);
            int[] iArr = new int[this.j.b()];
            String[] strArr = new String[this.j.b()];
            for (int i = 0; i < this.j.b(); i++) {
                iArr[i] = this.j.d(i);
                strArr[i] = this.j.e(i);
            }
            bundle.putIntArray("android:support:request_indicies", iArr);
            bundle.putStringArray("android:support:request_fragment_who", strArr);
        }
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        this.e = false;
        if (!this.c) {
            this.c = true;
            this.b.f();
        }
        this.b.b();
        this.b.m();
        this.b.g();
    }

    @Override // android.app.Activity
    public void onStateNotSaved() {
        this.b.b();
    }

    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
        this.e = true;
        e();
        this.b.j();
    }

    @Override // android.app.Activity
    public void startActivityForResult(Intent intent, int i) {
        if (!this.h && i != -1) {
            b(i);
        }
        super.startActivityForResult(intent, i);
    }

    @Override // android.app.Activity
    public void startActivityForResult(Intent intent, int i, Bundle bundle) {
        if (!this.h && i != -1) {
            b(i);
        }
        super.startActivityForResult(intent, i, bundle);
    }

    @Override // android.app.Activity
    public void startIntentSenderForResult(IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4) {
        if (!this.g && i != -1) {
            b(i);
        }
        super.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4);
    }

    @Override // android.app.Activity
    public void startIntentSenderForResult(IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) {
        if (!this.g && i != -1) {
            b(i);
        }
        super.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4, bundle);
    }
}
