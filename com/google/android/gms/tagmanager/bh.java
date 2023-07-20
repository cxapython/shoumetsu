package com.google.android.gms.tagmanager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.google.android.gms.common.util.VisibleForTesting;

/* loaded from: classes.dex */
class bh extends BroadcastReceiver {
    @VisibleForTesting
    private static final String a = "com.google.android.gms.tagmanager.bh";
    private final zzfm b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bh(zzfm zzfmVar) {
        this.b = zzfmVar;
    }

    public static void a(Context context) {
        Intent intent = new Intent("com.google.analytics.RADIO_POWERED");
        intent.addCategory(context.getPackageName());
        intent.putExtra(a, true);
        context.sendBroadcast(intent);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (!"android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
            if (!"com.google.analytics.RADIO_POWERED".equals(action) || intent.hasExtra(a)) {
                return;
            }
            this.b.zzjp();
            return;
        }
        Bundle extras = intent.getExtras();
        Boolean bool = Boolean.FALSE;
        if (extras != null) {
            bool = Boolean.valueOf(intent.getExtras().getBoolean("noConnectivity"));
        }
        this.b.zzf(!bool.booleanValue());
    }
}
