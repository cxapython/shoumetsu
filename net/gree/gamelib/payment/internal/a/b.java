package net.gree.gamelib.payment.internal.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Xml;
import com.b.a.a.a.a;
import com.google.android.gms.analytics.ecommerce.ProductAction;
import java.io.StringReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import net.gree.gamelib.core.GLog;
import net.gree.gamelib.payment.Payment;
import net.gree.gamelib.payment.PaymentError;
import net.gree.gamelib.payment.PaymentListener;
import net.gree.gamelib.payment.shop.Order;
import org.json.JSONException;
import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParser;

/* loaded from: classes.dex */
public class b implements h {
    private static long A = 30000;
    public static final String a = "kddi";
    private static final String m = "b";
    private static final String n = "receipt";
    private static final String o = "item_id";
    private static final String p = "commodity_id";
    private static final String q = "pay_info_no";
    private static final String r = "pay_date";
    private net.gree.gamelib.payment.internal.shop.a s;
    private Payment t;
    private com.b.a.a.a.a u;
    private PaymentListener<g> w;
    private PaymentListener<List<g>> x;
    private PaymentListener<Void> y;
    private Order v = null;
    private long z = 0;
    boolean b = false;
    String c = "";
    protected a.f d = new a.f() { // from class: net.gree.gamelib.payment.internal.a.b.1
        @Override // com.b.a.a.a.a.f
        public void onConfirmReceiptResult(int i, String str, String str2, Map<String, Object> map) {
            String str3 = b.m;
            GLog.v(str3, "onConfirmReceiptResult is called:" + i + ", receipt:" + str);
            b.this.c();
            ArrayList arrayList = new ArrayList();
            if (i == 0) {
                for (JSONObject jSONObject : b.this.b(str)) {
                    g a2 = b.this.a(jSONObject, str, str2);
                    if (a2 != null) {
                        arrayList.add(a2);
                    }
                }
                if (b.this.x == null) {
                    return;
                }
                b.this.x.onSuccess(arrayList);
            } else if (i == -24) {
                if (b.this.x == null) {
                    return;
                }
                b.this.x.onSuccess(new ArrayList());
            } else if (b.this.x == null) {
                return;
            } else {
                b.this.x.onError(17220, "Get Purchases is failed");
            }
            b.this.x = null;
        }

        @Override // com.b.a.a.a.a.f
        public void onInvalidateItemResult(int i, Map<String, Object> map) {
            String str = b.m;
            GLog.v(str, "onInvalidateItemResult is called:" + i);
            b.this.c();
            if (i == 0) {
                if (b.this.y == null) {
                    return;
                }
                b.this.y.onSuccess(null);
            } else if (b.this.y == null) {
                return;
            } else {
                b.this.y.onError(17220, "Consume is failed");
            }
            b.this.y = null;
        }

        @Override // com.b.a.a.a.a.f
        public void onIssueReceiptResult(int i, String str, String str2, Map<String, Object> map) {
            int i2;
            String str3 = b.m;
            GLog.v(str3, "onIssueReceiptResult is called:" + i + ", receipt:" + str);
            if (i == -24) {
                i2 = 8;
            } else if (i == 0) {
                i2 = 0;
            } else if (i != 9) {
                switch (i) {
                    case -21:
                        i2 = 7;
                        break;
                    case -20:
                        i2 = 1;
                        break;
                    default:
                        i2 = 6;
                        break;
                }
            } else {
                i2 = 4;
            }
            if (i2 == 0) {
                g a2 = b.this.a(str, str2);
                if (a2 != null && b.this.a(a2) && b.this.w != null) {
                    b.this.c();
                    b.this.w.onSuccess(a2);
                    b.this.w = null;
                    return;
                }
                i2 = 6;
            }
            if (b.this.v != null) {
                b.this.s.b(b.this.v.getProductId(), b.this.t.getUuid(), i2);
            }
            b.this.c();
            if (b.this.w != null) {
                if (i2 == 1) {
                    new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: net.gree.gamelib.payment.internal.a.b.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            b.this.w.onError(PaymentError.ERROR_CODE_SUBMIT_CANCELED, PaymentError.ERROR_MESSAGE_SUBMIT_CANCELED);
                            b.this.w = null;
                        }
                    }, 500L);
                    return;
                }
                PaymentListener paymentListener = b.this.w;
                paymentListener.onError(17220, "Purchase " + i2);
                b.this.w = null;
            }
        }

        @Override // com.b.a.a.a.a.f
        public void onUpdateReceiptResult(int i, String str, String str2, Map<String, Object> map) {
        }
    };

    public b(com.b.a.a.a.a aVar) {
        this.u = null;
        this.u = aVar;
    }

    @Override // net.gree.gamelib.payment.internal.a.h
    public String a() {
        return a;
    }

    protected g a(String str, String str2) {
        List<JSONObject> b = b(str);
        if (b.isEmpty()) {
            GLog.e(m, "receipt is empty.");
            return null;
        }
        return a(b.get(0), str, str2);
    }

    protected g a(JSONObject jSONObject, String str, String str2) {
        Date date;
        g gVar;
        JSONObject jSONObject2 = new JSONObject();
        try {
            String string = jSONObject.getString(o);
            jSONObject2.put(g.b, jSONObject.getString(q));
            jSONObject2.put("productId", string);
            try {
                date = new SimpleDateFormat("yyyyMMddHHmmss", Locale.getDefault()).parse(jSONObject.optString(r));
            } catch (ParseException unused) {
                date = null;
            }
            if (date != null) {
                jSONObject2.put(g.f, date.getTime());
            }
            jSONObject2.put(g.h, jSONObject.optString(p));
            jSONObject2.put("receipt", str);
            gVar = new g(jSONObject2.toString(), str2);
        } catch (JSONException unused2) {
            GLog.e(m, "found invalid data in receipt. receipt:" + str);
        }
        if (b(gVar)) {
            return gVar;
        }
        return null;
    }

    @Override // net.gree.gamelib.payment.internal.a.h
    public void a(Activity activity, Order order, PaymentListener<g> paymentListener) {
        GLog.v(m, "start purchase");
        if (!e()) {
            if (paymentListener == null) {
                return;
            }
            paymentListener.onError(17220, "au Service Bind Error");
            return;
        }
        try {
            a(ProductAction.ACTION_PURCHASE);
            net.gree.gamelib.payment.internal.shop.b b = this.s.b(order.getPurchaseId(), order.getProductId(), this.t.getUuid());
            if (b == null) {
                c();
                if (paymentListener == null) {
                    return;
                }
                paymentListener.onError(PaymentError.ERROR_CODE_PAYMENT_LOCAL_HISTORY_DB_NOT_FOUND, PaymentError.ERROR_MESSAGE_PAYMENT_LOCAL_HISTORY_DB_NOT_FOUND);
                return;
            }
            this.s.c(b);
            this.v = order;
            this.w = paymentListener;
            this.u.a(this.t.getContext().getPackageName(), this.d, order.getProductId(), order.getPurchaseId(), "");
        } catch (IllegalStateException unused) {
            if (paymentListener == null) {
                return;
            }
            paymentListener.onError(17219, "The process is already in progress");
        } catch (RuntimeException e) {
            if (paymentListener == null) {
                return;
            }
            paymentListener.onError(17220, e.getMessage());
        }
    }

    @Override // net.gree.gamelib.payment.internal.a.h
    public void a(Context context, Payment payment, net.gree.gamelib.payment.internal.shop.a aVar) {
        String str = m;
        GLog.v(str, "startSetup:" + a());
        this.t = payment;
        this.s = aVar;
    }

    void a(String str) {
        long time = new Date().getTime();
        if (this.b && time < this.z + A) {
            throw new IllegalStateException("Can't start async operation (" + str + ") because another async operation(" + this.c + ") is in progress.");
        }
        this.c = str;
        this.b = true;
        this.z = time;
        String str2 = m;
        GLog.i(str2, "Starting async operation: " + str);
    }

    @Override // net.gree.gamelib.payment.internal.a.h
    public void a(Set<String> set, PaymentListener<HashMap<String, JSONObject>> paymentListener) {
        GLog.v(m, "call getProducts");
        paymentListener.onSuccess(new HashMap<>());
    }

    @Override // net.gree.gamelib.payment.internal.a.h
    public void a(PaymentListener<List<g>> paymentListener) {
        GLog.v(m, "start getPurchases");
        if (!e()) {
            if (paymentListener == null) {
                return;
            }
            paymentListener.onError(17220, "au Service Bind Error");
            return;
        }
        try {
            a("refresh inventory");
            this.x = paymentListener;
            this.u.a(this.t.getContext().getPackageName(), this.d, "", "", "", 1);
        } catch (IllegalStateException unused) {
            if (paymentListener == null) {
                return;
            }
            paymentListener.onError(17219, "The process is already in progress");
        } catch (RuntimeException e) {
            if (paymentListener == null) {
                return;
            }
            paymentListener.onError(17220, e.getMessage());
        }
    }

    @Override // net.gree.gamelib.payment.internal.a.h
    public void a(g gVar, PaymentListener<Void> paymentListener) {
        GLog.v(m, "call consume");
        if (!e()) {
            if (paymentListener == null) {
                return;
            }
            paymentListener.onError(17220, "au Service Bind Error");
            return;
        }
        try {
            a("consume");
            this.y = paymentListener;
            this.u.b(this.t.getContext().getPackageName(), this.d, gVar.c(), gVar.a(), gVar.f());
        } catch (IllegalStateException unused) {
            if (paymentListener == null) {
                return;
            }
            paymentListener.onError(17219, "The process is already in progress");
        } catch (RuntimeException e) {
            if (paymentListener == null) {
                return;
            }
            paymentListener.onError(17220, e.getMessage());
        }
    }

    @Override // net.gree.gamelib.payment.internal.a.h
    public boolean a(int i, int i2, Intent intent) {
        return false;
    }

    protected boolean a(g gVar) {
        this.s.a(gVar.c(), gVar.a(), gVar.f(), this.t.getUuid());
        net.gree.gamelib.payment.internal.shop.b b = this.s.b(gVar.f(), gVar.c(), this.t.getUuid());
        if (b != null) {
            b.d(gVar.k());
            this.s.a(b);
            return true;
        }
        String str = m;
        GLog.e(str, "not found history. orderId:" + gVar.a() + ",productId:" + gVar.c());
        return false;
    }

    protected List<JSONObject> b(String str) {
        ArrayList arrayList = new ArrayList();
        try {
            XmlPullParser newPullParser = Xml.newPullParser();
            newPullParser.setInput(new StringReader(str));
            JSONObject jSONObject = null;
            for (int eventType = newPullParser.getEventType(); eventType != 1; eventType = newPullParser.next()) {
                String name = newPullParser.getName();
                if (eventType == 2 && "receipt".equalsIgnoreCase(name)) {
                    JSONObject jSONObject2 = new JSONObject();
                    arrayList.add(jSONObject2);
                    jSONObject = jSONObject2;
                } else if (eventType == 3 && "receipt".equalsIgnoreCase(name)) {
                    jSONObject = null;
                } else if (eventType == 2 && jSONObject != null) {
                    String nextText = newPullParser.nextText();
                    if (newPullParser.getEventType() != 3) {
                        newPullParser.next();
                    }
                    jSONObject.put(name, nextText);
                }
            }
        } catch (Exception e) {
            GLog.e(m, "receipt xml parse error. receipt:" + str);
            e.printStackTrace();
        }
        return arrayList;
    }

    @Override // net.gree.gamelib.payment.internal.a.h
    public void b() {
    }

    protected boolean b(g gVar) {
        String str;
        String str2;
        if (TextUtils.isEmpty(gVar.c())) {
            str = m;
            str2 = "sku is empty in purchase.";
        } else if (TextUtils.isEmpty(gVar.a())) {
            str = m;
            str2 = "order id is empty in purchase.";
        } else if (!TextUtils.isEmpty(gVar.f())) {
            return true;
        } else {
            str = m;
            str2 = "developer payload is empty in purchase.";
        }
        GLog.e(str, str2);
        return false;
    }

    void c() {
        String str = m;
        GLog.i(str, "Ending async operation: " + this.c);
        this.c = "";
        this.b = false;
    }

    @Override // net.gree.gamelib.payment.internal.a.h
    public boolean d() {
        return false;
    }

    protected boolean e() {
        return net.gree.gamelib.payment.internal.b.a(this.t.getContext());
    }
}
