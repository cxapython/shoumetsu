package androidx.core.app;

import android.app.Notification;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseArray;
import androidx.core.app.f;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h {
    private static Field b;
    private static boolean c;
    private static final Object a = new Object();
    private static final Object d = new Object();

    public static Bundle a(Notification.Builder builder, f.a aVar) {
        builder.addAction(aVar.a(), aVar.b(), aVar.c());
        Bundle bundle = new Bundle(aVar.d());
        if (aVar.f() != null) {
            bundle.putParcelableArray("android.support.remoteInputs", a(aVar.f()));
        }
        if (aVar.h() != null) {
            bundle.putParcelableArray("android.support.dataRemoteInputs", a(aVar.h()));
        }
        bundle.putBoolean("android.support.allowGeneratedReplies", aVar.e());
        return bundle;
    }

    public static Bundle a(Notification notification) {
        String str;
        String str2;
        synchronized (a) {
            if (c) {
                return null;
            }
            try {
                if (b == null) {
                    Field declaredField = Notification.class.getDeclaredField("extras");
                    if (!Bundle.class.isAssignableFrom(declaredField.getType())) {
                        Log.e("NotificationCompat", "Notification.extras field is not of type Bundle");
                        c = true;
                        return null;
                    }
                    declaredField.setAccessible(true);
                    b = declaredField;
                }
                Bundle bundle = (Bundle) b.get(notification);
                if (bundle == null) {
                    bundle = new Bundle();
                    b.set(notification, bundle);
                }
                return bundle;
            } catch (IllegalAccessException e) {
                e = e;
                str = "NotificationCompat";
                str2 = "Unable to access notification extras";
                Log.e(str, str2, e);
                c = true;
                return null;
            } catch (NoSuchFieldException e2) {
                e = e2;
                str = "NotificationCompat";
                str2 = "Unable to access notification extras";
                Log.e(str, str2, e);
                c = true;
                return null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Bundle a(f.a aVar) {
        Bundle bundle = new Bundle();
        bundle.putInt("icon", aVar.a());
        bundle.putCharSequence(net.gree.gamelib.payment.internal.a.e.N, aVar.b());
        bundle.putParcelable("actionIntent", aVar.c());
        Bundle bundle2 = aVar.d() != null ? new Bundle(aVar.d()) : new Bundle();
        bundle2.putBoolean("android.support.allowGeneratedReplies", aVar.e());
        bundle.putBundle("extras", bundle2);
        bundle.putParcelableArray("remoteInputs", a(aVar.f()));
        bundle.putBoolean("showsUserInterface", aVar.i());
        bundle.putInt("semanticAction", aVar.g());
        return bundle;
    }

    private static Bundle a(i iVar) {
        Bundle bundle = new Bundle();
        bundle.putString("resultKey", iVar.a());
        bundle.putCharSequence("label", iVar.b());
        bundle.putCharSequenceArray("choices", iVar.c());
        bundle.putBoolean("allowFreeFormInput", iVar.e());
        bundle.putBundle("extras", iVar.f());
        Set<String> d2 = iVar.d();
        if (d2 != null && !d2.isEmpty()) {
            ArrayList<String> arrayList = new ArrayList<>(d2.size());
            for (String str : d2) {
                arrayList.add(str);
            }
            bundle.putStringArrayList("allowedDataTypes", arrayList);
        }
        return bundle;
    }

    public static SparseArray<Bundle> a(List<Bundle> list) {
        int size = list.size();
        SparseArray<Bundle> sparseArray = null;
        for (int i = 0; i < size; i++) {
            Bundle bundle = list.get(i);
            if (bundle != null) {
                if (sparseArray == null) {
                    sparseArray = new SparseArray<>();
                }
                sparseArray.put(i, bundle);
            }
        }
        return sparseArray;
    }

    private static Bundle[] a(i[] iVarArr) {
        if (iVarArr == null) {
            return null;
        }
        Bundle[] bundleArr = new Bundle[iVarArr.length];
        for (int i = 0; i < iVarArr.length; i++) {
            bundleArr[i] = a(iVarArr[i]);
        }
        return bundleArr;
    }
}
