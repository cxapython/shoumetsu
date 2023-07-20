package com.google.firebase.iid;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;
import com.google.android.gms.common.util.VisibleForTesting;
import javax.annotation.Nullable;

@VisibleForTesting
/* loaded from: classes.dex */
final class ae extends BroadcastReceiver {
    @Nullable
    private aa a;

    public ae(aa aaVar) {
        this.a = aaVar;
    }

    public final void a() {
        if (FirebaseInstanceId.e()) {
            Log.d("FirebaseInstanceId", "Connectivity change received registered");
        }
        this.a.a().registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        aa aaVar = this.a;
        if (aaVar != null && aaVar.b()) {
            if (FirebaseInstanceId.e()) {
                Log.d("FirebaseInstanceId", "Connectivity changed. Starting background sync.");
            }
            FirebaseInstanceId.a(this.a, 0L);
            this.a.a().unregisterReceiver(this);
            this.a = null;
        }
    }
}
