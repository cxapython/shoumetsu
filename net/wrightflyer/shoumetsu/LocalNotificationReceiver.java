package net.wrightflyer.shoumetsu;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import androidx.core.app.f;
import com.google.android.gms.drive.MetadataChangeSet;
import net.gree.gamelib.core.a.b.b;

/* loaded from: classes.dex */
public class LocalNotificationReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        try {
            int intExtra = intent.getIntExtra("notification_id", 0);
            String stringExtra = intent.getStringExtra(b.g);
            Intent intent2 = new Intent(context, AthenaActivity.class);
            intent2.setFlags(MetadataChangeSet.INDEXABLE_TEXT_SIZE_LIMIT_BYTES);
            PendingIntent activity = PendingIntent.getActivity(context, 0, intent2, 134217728);
            int identifier = context.getResources().getIdentifier("icon", "drawable", context.getPackageName());
            String string = context.getResources().getString(context.getResources().getIdentifier("app_name", "string", context.getPackageName()));
            Bitmap decodeResource = BitmapFactory.decodeResource(context.getResources(), identifier);
            f.d dVar = new f.d(context);
            dVar.a((CharSequence) string);
            dVar.b(stringExtra);
            dVar.a(identifier);
            dVar.a(decodeResource);
            dVar.c(stringExtra);
            dVar.a(true);
            dVar.b(-1);
            dVar.a(activity);
            ((NotificationManager) context.getSystemService("notification")).notify(intExtra, dVar.b());
        } catch (Exception unused) {
        }
    }
}
