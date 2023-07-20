package net.gree.gamelib.payment.internal.a;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.ServiceConnection;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Base64;
import com.a.b.a.a;
import com.adjust.sdk.Constants;
import java.math.BigDecimal;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import net.gree.gamelib.core.Core;
import net.gree.gamelib.core.GLog;
import net.gree.gamelib.payment.shop.Product;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class e {
    public static final String A = "BUY_INTENT";
    public static final String B = "INAPP_PURCHASE_DATA";
    public static final String C = "INAPP_DATA_SIGNATURE";
    public static final String D = "INAPP_PURCHASE_ITEM_LIST";
    public static final String E = "INAPP_PURCHASE_DATA_LIST";
    public static final String F = "INAPP_DATA_SIGNATURE_LIST";
    public static final String G = "INAPP_CONTINUATION_TOKEN";
    public static final String H = "ITEM_ID_LIST";
    public static final String I = "productId";
    public static final String J = "type";
    public static final String K = "price";
    public static final String L = "price_amount_micros";
    public static final String M = "price_currency_code";
    public static final String N = "title";
    public static final String O = "description";
    public static final String P = "inapp";
    private static final String S = "e";
    private static final int T = 3;
    private static final String U = "test_";
    private static final int V = 20;
    private static final int W = 6;
    public static final int h = 0;
    public static final int i = 1;
    public static final int j = 2;
    public static final int k = 3;
    public static final int l = 4;
    public static final int m = 5;
    public static final int n = 6;
    public static final int o = 7;
    public static final int p = 8;
    public static final int q = -1000;
    public static final int r = -1001;
    public static final int s = -1002;
    public static final int t = -1004;
    public static final int u = -1005;
    public static final int v = -1006;
    public static final int w = -1007;
    public static final int x = -1008;
    public static final String y = "RESPONSE_CODE";
    public static final String z = "DETAILS_LIST";
    InterfaceC0073e Q;
    d R;
    Context d;
    com.a.b.a.a e;
    ServiceConnection f;
    int g;
    boolean a = false;
    boolean b = false;
    String c = "";
    private boolean X = false;
    private String Y = "";

    /* loaded from: classes.dex */
    public interface a {
        void a(f fVar, HashMap<String, JSONObject> hashMap);
    }

    /* loaded from: classes.dex */
    public interface b {
        void a(f fVar, List<g> list);
    }

    /* loaded from: classes.dex */
    public interface c {
        void a(List<g> list, List<f> list2);
    }

    /* loaded from: classes.dex */
    public interface d {
        void a(f fVar, g gVar);
    }

    /* renamed from: net.gree.gamelib.payment.internal.a.e$e  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0073e {
        void a(f fVar);
    }

    public e(Context context) {
        this.d = context.getApplicationContext();
        GLog.i(S, "IAB helper created.");
    }

    public static String a(int i2) {
        StringBuilder sb;
        String str;
        String[] split = "0:OK/1:User Canceled/2:Unknown/3:Billing Unavailable/4:Item unavailable/5:Developer Error/6:Error/7:Item Already Owned/8:Item not owned".split("/");
        String[] split2 = "0:OK/-1001:Remote exception during initialization/-1002:Bad response received/-1003:Purchase signature verification failed/-1004:Send intent failed/-1005:User cancelled/-1006:Unknown purchase response/-1007:Missing token/-1008:Unknown error/-1009:Subscriptions not available/-1010:Invalid consumption attempt".split("/");
        if (i2 <= -1000) {
            int i3 = q - i2;
            if (i3 >= 0 && i3 < split2.length) {
                return split2[i3];
            }
            sb = new StringBuilder();
            sb.append(String.valueOf(i2));
            str = ":Unknown IAB Helper Error";
        } else if (i2 >= 0 && i2 < split.length) {
            return split[i2];
        } else {
            sb = new StringBuilder();
            sb.append(String.valueOf(i2));
            str = ":Unknown";
        }
        sb.append(str);
        return sb.toString();
    }

    private String e(String str) {
        try {
            return Base64.encodeToString(MessageDigest.getInstance(Constants.SHA1).digest(str.getBytes("UTF-8")), 2);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    int a(Intent intent) {
        Object obj = intent.getExtras().get(y);
        if (obj == null) {
            GLog.e(S, "Intent with no response code, assuming OK (known issue)");
            return 0;
        } else if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        } else {
            if (obj instanceof Long) {
                return (int) ((Long) obj).longValue();
            }
            GLog.e(S, "Unexpected type for intent response code.");
            GLog.e(S, obj.getClass().getName());
            throw new RuntimeException("Unexpected type for intent response code: " + obj.getClass().getName());
        }
    }

    int a(Bundle bundle) {
        Object obj = bundle.get(y);
        if (obj == null) {
            GLog.i(S, "Bundle with null response code, assuming OK (known issue)");
            return 0;
        } else if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        } else {
            if (obj instanceof Long) {
                return (int) ((Long) obj).longValue();
            }
            GLog.e(S, "Unexpected type for bundle response code.");
            GLog.e(S, obj.getClass().getName());
            throw new RuntimeException("Unexpected type for bundle response code: " + obj.getClass().getName());
        }
    }

    int a(List<JSONObject> list, ArrayList<String> arrayList) {
        ArrayList<String> stringArrayList;
        Bundle bundle = new Bundle();
        bundle.putStringArrayList(H, arrayList);
        Bundle a2 = this.e.a(3, this.d.getPackageName(), P, bundle);
        int a3 = a(a2);
        if (a3 != 0 || (stringArrayList = a2.getStringArrayList(z)) == null) {
            return a3;
        }
        Iterator<String> it = stringArrayList.iterator();
        while (it.hasNext()) {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject(it.next());
            jSONObject.put(Product.KEY_ID, jSONObject2.getString("productId"));
            jSONObject.put(Product.KEY_FORMATTED_PRICE, jSONObject2.getString("price"));
            jSONObject.put(Product.KEY_CURRENCY_CODE, jSONObject2.getString(M));
            jSONObject.put(Product.KEY_NAME, jSONObject2.getString(N));
            jSONObject.put("description", jSONObject2.getString("description"));
            jSONObject.put("price", d(jSONObject2.getString(L)));
            list.add(jSONObject);
        }
        return a3;
    }

    List<JSONObject> a(ArrayList<String> arrayList) {
        b("getProducts");
        try {
            ArrayList arrayList2 = new ArrayList();
            int a2 = a(arrayList2, arrayList);
            if (a2 == 0) {
                return arrayList2;
            }
            throw new net.gree.gamelib.payment.internal.a.d(a2, "Error querying available products.");
        } catch (RemoteException e) {
            throw new net.gree.gamelib.payment.internal.a.d(r, "Remote exception while querying available products.", e);
        } catch (JSONException e2) {
            throw new net.gree.gamelib.payment.internal.a.d(s, "Error parsing JSON response while querying available products.", e2);
        }
    }

    List<g> a(List<String> list) {
        b("getPurchases");
        try {
            ArrayList arrayList = new ArrayList();
            int b2 = b(arrayList);
            if (b2 == 0) {
                return arrayList;
            }
            throw new net.gree.gamelib.payment.internal.a.d(b2, "Error refreshing inventory (querying owned items).");
        } catch (RemoteException e) {
            throw new net.gree.gamelib.payment.internal.a.d(r, "Remote exception while refreshing inventory.", e);
        } catch (JSONException e2) {
            throw new net.gree.gamelib.payment.internal.a.d(s, "Error parsing JSON response while refreshing inventory.", e2);
        }
    }

    protected g a(String str, String str2) {
        g gVar = new g(str, str2);
        if (TextUtils.isEmpty(gVar.a()) && !TextUtils.isEmpty(gVar.g())) {
            gVar.a(U + e(gVar.g()));
        }
        return gVar;
    }

    public void a() {
        GLog.i(S, "Disposing.");
        this.a = false;
        if (this.f != null) {
            GLog.i(S, "Unbinding from service.");
            Context context = this.d;
            if (context != null) {
                context.unbindService(this.f);
            }
            this.f = null;
            this.e = null;
            this.R = null;
        }
    }

    public void a(Activity activity, String str, int i2, d dVar, String str2) {
        f fVar;
        Bundle a2;
        String str3;
        String str4;
        b("launchPurchaseFlow");
        c("launchPurchaseFlow");
        try {
            GLog.i(S, "Constructing buy intent for " + str);
            if (this.e == null) {
                b();
                f fVar2 = new f(r, "Service disconnected.");
                if (dVar == null) {
                    return;
                }
                dVar.a(fVar2, null);
                return;
            }
            if (this.X) {
                Bundle bundle = new Bundle();
                bundle.putString("accountId", this.Y);
                a2 = this.e.a(6, this.d.getPackageName(), str, P, str2, bundle);
                str3 = S;
                str4 = "getBuyIntentExtraParams done. accountId=" + this.Y;
            } else {
                a2 = this.e.a(3, this.d.getPackageName(), str, P, str2);
                str3 = S;
                str4 = "getBuyIntent done.";
            }
            GLog.i(str3, str4);
            int a3 = a(a2);
            if (a3 != 0) {
                GLog.e(S, "Unable to buy item, Error response: " + a(a3));
                b();
                f fVar3 = new f(a3, "Unable to buy item");
                if (dVar == null) {
                    return;
                }
                dVar.a(fVar3, null);
                return;
            }
            GLog.i(S, "Launching buy intent for " + str + ". Request code: " + i2);
            this.g = i2;
            this.R = dVar;
            IntentSender intentSender = ((PendingIntent) a2.getParcelable(A)).getIntentSender();
            Intent intent = new Intent();
            Integer num = 0;
            int intValue = num.intValue();
            Integer num2 = 0;
            Integer num3 = 0;
            activity.startIntentSenderForResult(intentSender, i2, intent, intValue, num2.intValue(), num3.intValue());
        } catch (IntentSender.SendIntentException unused) {
            GLog.e(S, "SendIntentException while launching purchase flow for sku " + str);
            b();
            fVar = new f(t, "Failed to send intent.");
            if (dVar == null) {
                return;
            }
            dVar.a(fVar, null);
        } catch (RemoteException unused2) {
            GLog.e(S, "RemoteException while launching purchase flow for sku " + str);
            b();
            fVar = new f(r, "Remote exception while starting purchase flow");
            if (dVar == null) {
                return;
            }
            dVar.a(fVar, null);
        }
    }

    public void a(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.Y = e(str);
        }
    }

    public void a(final ArrayList<String> arrayList, final a aVar) {
        final Handler handler = new Handler(Looper.getMainLooper());
        b("getProducts");
        c("get products");
        Core.EXECUTOR.execute(new Runnable() { // from class: net.gree.gamelib.payment.internal.a.e.4
            @Override // java.lang.Runnable
            public void run() {
                int i2 = 0;
                final f fVar = new f(0, "Get products successful.");
                ArrayList<JSONObject> arrayList2 = new ArrayList();
                int size = arrayList.size();
                while (i2 < size) {
                    int i3 = i2 + 20;
                    try {
                        arrayList2.addAll(e.this.a(new ArrayList<>(arrayList.subList(i2, Math.min(i3, size)))));
                        i2 = i3;
                    } catch (net.gree.gamelib.payment.internal.a.d e) {
                        fVar = e.a();
                    }
                }
                e.this.b();
                HashMap hashMap = new HashMap();
                for (JSONObject jSONObject : arrayList2) {
                    try {
                        e.this.a(jSONObject);
                        hashMap.put(jSONObject.getString(Product.KEY_ID), jSONObject);
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                }
                final HashMap hashMap2 = new HashMap(hashMap);
                handler.post(new Runnable() { // from class: net.gree.gamelib.payment.internal.a.e.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        aVar.a(fVar, hashMap2);
                    }
                });
            }
        });
    }

    void a(final List<String> list, final b bVar) {
        final Handler handler = new Handler(Looper.getMainLooper());
        b("getPurchases");
        c("refresh inventory");
        Core.EXECUTOR.execute(new Runnable() { // from class: net.gree.gamelib.payment.internal.a.e.2
            @Override // java.lang.Runnable
            public void run() {
                final f fVar = new f(0, "Inventory refresh successful.");
                final List<g> arrayList = new ArrayList<>();
                try {
                    arrayList = e.this.a(list);
                } catch (net.gree.gamelib.payment.internal.a.d e) {
                    fVar = e.a();
                }
                e.this.b();
                handler.post(new Runnable() { // from class: net.gree.gamelib.payment.internal.a.e.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        bVar.a(fVar, arrayList);
                    }
                });
            }
        });
    }

    public void a(final List<g> list, final c cVar) {
        b("consume");
        final Handler handler = new Handler(Looper.getMainLooper());
        c("consume");
        Core.EXECUTOR.execute(new Runnable() { // from class: net.gree.gamelib.payment.internal.a.e.3
            @Override // java.lang.Runnable
            public void run() {
                final ArrayList arrayList = new ArrayList();
                for (g gVar : list) {
                    try {
                        e.this.a(gVar);
                        arrayList.add(new f(0, "Successful consume of sku " + gVar.c()));
                    } catch (net.gree.gamelib.payment.internal.a.d e) {
                        arrayList.add(e.a());
                    }
                }
                e.this.b();
                if (cVar != null) {
                    handler.post(new Runnable() { // from class: net.gree.gamelib.payment.internal.a.e.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            cVar.a(list, arrayList);
                        }
                    });
                }
            }
        });
    }

    public void a(b bVar) {
        a((List<String>) null, bVar);
    }

    public void a(InterfaceC0073e interfaceC0073e) {
        if (this.a) {
            if (interfaceC0073e == null) {
                return;
            }
            interfaceC0073e.a(new f(0, "Setup successful."));
            return;
        }
        this.Q = interfaceC0073e;
        GLog.i(S, "Starting in-app billing setup.");
        this.f = new ServiceConnection() { // from class: net.gree.gamelib.payment.internal.a.e.1
            @Override // android.content.ServiceConnection
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                GLog.i(e.S, "Billing service connected.");
                e.this.e = a.AbstractBinderC0037a.a(iBinder);
                String packageName = e.this.d.getPackageName();
                try {
                    GLog.i(e.S, "Checking for in-app billing 3 support.");
                    int a2 = e.this.e.a(3, packageName, e.P);
                    if (a2 != 0) {
                        if (e.this.Q == null) {
                            return;
                        }
                        e.this.Q.a(new f(a2, "Error checking for billing v3 support."));
                        e.this.Q = null;
                        return;
                    }
                    String str = e.S;
                    GLog.i(str, "In-app billing version 3 supported for " + packageName);
                    if (e.this.e.a(6, packageName, e.P) == 0) {
                        e.this.X = true;
                        String str2 = e.S;
                        GLog.i(str2, "In-app billing version 6 supported for " + packageName);
                    }
                    e.this.a = true;
                    if (e.this.Q == null) {
                        return;
                    }
                    e.this.Q.a(new f(0, "Setup successful."));
                    e.this.Q = null;
                } catch (RemoteException e) {
                    if (e.this.Q != null) {
                        e.this.Q.a(new f(e.r, "RemoteException while setting up in-app billing."));
                        e.this.Q = null;
                    }
                    e.printStackTrace();
                }
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName componentName) {
                GLog.i(e.S, "Billing service disconnected.");
                e eVar = e.this;
                eVar.e = null;
                eVar.a = false;
                eVar.Q = null;
                eVar.b();
            }
        };
        Intent intent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
        intent.setPackage("com.android.vending");
        List<ResolveInfo> queryIntentServices = this.d.getPackageManager().queryIntentServices(intent, 0);
        if (queryIntentServices != null && !queryIntentServices.isEmpty()) {
            this.d.bindService(intent, this.f, 1);
            return;
        }
        InterfaceC0073e interfaceC0073e2 = this.Q;
        if (interfaceC0073e2 == null) {
            return;
        }
        interfaceC0073e2.a(new f(3, "Billing service unavailable on device."));
        this.Q = null;
    }

    void a(g gVar) {
        b("consume");
        try {
            String g = gVar.g();
            String c2 = gVar.c();
            if (g == null || g.equals("")) {
                String str = S;
                GLog.e(str, "Can't consume " + c2 + ". No token.");
                throw new net.gree.gamelib.payment.internal.a.d((int) w, "PurchaseInfo is missing token for sku: " + c2 + " " + gVar);
            }
            String str2 = S;
            GLog.i(str2, "Consuming sku: " + c2 + ", token: " + g);
            if (this.e == null) {
                throw new net.gree.gamelib.payment.internal.a.d((int) r, "Service disconnected.");
            }
            int b2 = this.e.b(3, this.d.getPackageName(), g);
            if (b2 == 0) {
                String str3 = S;
                GLog.i(str3, "Successfully consumed sku: " + c2);
                return;
            }
            String str4 = S;
            GLog.i(str4, "Error consuming consuming sku " + c2 + ". " + a(b2));
            throw new net.gree.gamelib.payment.internal.a.d(b2, "Error consuming sku " + c2);
        } catch (RemoteException e) {
            throw new net.gree.gamelib.payment.internal.a.d(r, "Remote exception while consuming. PurchaseInfo: " + gVar, e);
        }
    }

    protected void a(JSONObject jSONObject) {
        try {
            String string = jSONObject.getString(Product.KEY_NAME);
            if (string == null) {
                return;
            }
            jSONObject.put(Product.KEY_NAME, string.replaceAll("\\s*\\(.*\\)$", ""));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x0151, code lost:
        if (r9 != null) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0185, code lost:
        if (r9 != null) goto L38;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean a(int i2, int i3, Intent intent) {
        f fVar;
        d dVar;
        if (i2 != this.g) {
            return false;
        }
        b("handleActivityResult");
        b();
        if (intent == null) {
            GLog.e(S, "Null data in IAB activity result.");
            f fVar2 = new f(s, "Null data in IAB result");
            d dVar2 = this.R;
            if (dVar2 != null) {
                dVar2.a(fVar2, null);
                this.R = null;
            }
            return true;
        }
        int a2 = a(intent);
        String stringExtra = intent.getStringExtra(B);
        String stringExtra2 = intent.getStringExtra(C);
        if (i3 != -1 || a2 != 0) {
            if (i3 == -1) {
                String str = S;
                GLog.i(str, "Result code was OK but in-app billing response was not OK: " + a(a2));
                if (this.R != null) {
                    fVar = new f(a2, "Problem purchashing item.");
                    dVar = this.R;
                    dVar.a(fVar, null);
                }
                return true;
            } else if (i3 == 0) {
                String str2 = S;
                GLog.i(str2, "Purchase canceled - Response: " + a(a2));
                fVar = new f(u, "User canceled.");
                dVar = this.R;
            } else {
                String str3 = S;
                GLog.e(str3, "Purchase failed. Result code: " + Integer.toString(i3) + ". Response: " + a(a2));
                fVar = new f(v, "Unknown purchase response.");
                dVar = this.R;
            }
            this.R = null;
            return true;
        }
        GLog.i(S, "Successful resultcode from purchase activity.");
        String str4 = S;
        GLog.i(str4, "Purchase data: " + stringExtra);
        String str5 = S;
        GLog.i(str5, "Data signature: " + stringExtra2);
        String str6 = S;
        GLog.i(str6, "Extras: " + intent.getExtras());
        if (stringExtra == null || stringExtra2 == null) {
            GLog.e(S, "BUG: either purchaseData or dataSignature is null.");
            String str7 = S;
            GLog.i(str7, "Extras: " + intent.getExtras().toString());
            f fVar3 = new f(x, "IAB returned null purchaseData or dataSignature");
            d dVar3 = this.R;
            if (dVar3 != null) {
                dVar3.a(fVar3, null);
                this.R = null;
            }
            return true;
        }
        try {
            g a3 = a(stringExtra, stringExtra2);
            d dVar4 = this.R;
            if (dVar4 != null) {
                dVar4.a(new f(0, "Success"), a3);
                this.R = null;
            }
            return true;
        } catch (JSONException e) {
            GLog.e(S, "Failed to parse purchase data.");
            e.printStackTrace();
            f fVar4 = new f(s, "Failed to parse purchase data.");
            d dVar5 = this.R;
            if (dVar5 != null) {
                dVar5.a(fVar4, null);
                this.R = null;
            }
            return true;
        }
    }

    int b(List<g> list) {
        GLog.i(S, "Querying owned items");
        String str = S;
        GLog.i(str, "Package name: " + this.d.getPackageName());
        String str2 = null;
        do {
            String str3 = S;
            GLog.i(str3, "Calling getPurchases with continuation token: " + str2);
            com.a.b.a.a aVar = this.e;
            if (aVar == null) {
                return r;
            }
            Bundle a2 = aVar.a(3, this.d.getPackageName(), P, str2);
            int a3 = a(a2);
            String str4 = S;
            GLog.i(str4, "Owned items response: " + String.valueOf(a3));
            if (a3 != 0) {
                String str5 = S;
                GLog.i(str5, "getPurchases() failed: " + a(a3));
                return a3;
            } else if (!a2.containsKey(D) || !a2.containsKey(E) || !a2.containsKey(F)) {
                GLog.e(S, "Bundle returned from getPurchases() doesn't contain required fields.");
                return s;
            } else {
                ArrayList<String> stringArrayList = a2.getStringArrayList(D);
                ArrayList<String> stringArrayList2 = a2.getStringArrayList(E);
                ArrayList<String> stringArrayList3 = a2.getStringArrayList(F);
                for (int i2 = 0; i2 < stringArrayList2.size(); i2++) {
                    String str6 = S;
                    GLog.i(str6, "Sku is owned: " + stringArrayList.get(i2));
                    list.add(a(stringArrayList2.get(i2), stringArrayList3.get(i2)));
                }
                str2 = a2.getString(G);
                String str7 = S;
                GLog.i(str7, "Continuation token: " + str2);
            }
        } while (!TextUtils.isEmpty(str2));
        return 0;
    }

    void b() {
        String str = S;
        GLog.i(str, "Ending async operation: " + this.c);
        this.c = "";
        this.b = false;
    }

    void b(String str) {
        if (this.a) {
            return;
        }
        String str2 = S;
        GLog.e(str2, "Illegal state for operation (" + str + "): IAB helper is not set up.");
        throw new IllegalStateException("IAB helper is not set up. Can't perform operation: " + str);
    }

    void c(String str) {
        if (this.b) {
            throw new IllegalStateException("Can't start async operation (" + str + ") because another async operation(" + this.c + ") is in progress.");
        }
        this.c = str;
        this.b = true;
        String str2 = S;
        GLog.i(str2, "Starting async operation: " + str);
    }

    String d(String str) {
        try {
            return new BigDecimal(str).divide(new BigDecimal(1000000)).toPlainString();
        } catch (Exception unused) {
            GLog.e(S, "Unexpected type for SKU price_amount_micros.");
            return "0";
        }
    }
}
