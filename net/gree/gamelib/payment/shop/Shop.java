package net.gree.gamelib.payment.shop;

import android.app.Activity;
import android.content.Intent;
import android.text.format.DateFormat;
import android.util.Base64;
import com.adjust.sdk.Constants;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import net.gree.gamelib.core.GLog;
import net.gree.gamelib.core.http.SignedRequest;
import net.gree.gamelib.payment.Payment;
import net.gree.gamelib.payment.PaymentError;
import net.gree.gamelib.payment.PaymentListener;
import net.gree.gamelib.payment.SettingConsts;
import net.gree.gamelib.payment.internal.a.b;
import net.gree.gamelib.payment.internal.a.g;
import net.gree.gamelib.payment.internal.a.h;
import net.gree.gamelib.payment.internal.a.i;
import net.gree.gamelib.payment.internal.b.c;
import net.gree.gamelib.payment.internal.d;
import net.gree.gamelib.payment.internal.e;
import net.gree.gamelib.payment.internal.shop.PurchaseSettings;
import net.gree.gamelib.payment.shop.Order;
import net.gree.gamelib.payment.shop.ProductList;
import net.gree.gamelib.payment.shop.PurchaseAlert;
import net.gree.gamelib.payment.shop.PurchaseAlertSetting;
import net.gree.gamelib.payment.shop.TicketList;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class Shop {
    private static final String a = "Shop";
    private static final String b = "v1.0";
    private static final String c = "v1.0";
    private static final String d = "v1.0";
    private static final String e = "v1.0";
    private static final String f = "v1.0";
    private static final String g = "v1.0";
    private static final String h = "v1.0";
    private static final String i = "gamelib";
    private static final int[] j = {PaymentError.ERROR_CODE_SUBMIT_PRODUCT_ID_IS_NOT_EXIST, PaymentError.ERROR_CODE_SUBMIT_DUPLICATE_PURCHASE_ID, PaymentError.ERROR_CODE_SUBMIT_INVALID_RECEIPT, PaymentError.ERROR_CODE_SUBMIT_DUMP_INVALID_PURCHASE};
    private static Shop k = null;
    private static final int p = 255;
    private Payment l;
    private c m;
    private h n;
    private net.gree.gamelib.payment.internal.shop.a o;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: net.gree.gamelib.payment.shop.Shop$1  reason: invalid class name */
    /* loaded from: classes.dex */
    public class AnonymousClass1 implements PaymentListener<ProductList> {
        protected ProductList a;
        final /* synthetic */ PaymentListener b;

        AnonymousClass1(PaymentListener paymentListener) {
            this.b = paymentListener;
        }

        @Override // net.gree.gamelib.core.CallbackListener
        /* renamed from: a */
        public void onSuccess(ProductList productList) {
            this.a = productList;
            if (productList.getProducts().length == 0) {
                this.b.onSuccess(this.a);
                return;
            }
            HashSet hashSet = new HashSet();
            for (Product product : productList.getProducts()) {
                hashSet.add(product.getId());
            }
            Shop.this.n.a(hashSet, new PaymentListener<HashMap<String, JSONObject>>() { // from class: net.gree.gamelib.payment.shop.Shop.1.1
                @Override // net.gree.gamelib.core.CallbackListener
                /* renamed from: a */
                public void onSuccess(HashMap<String, JSONObject> hashMap) {
                    Product[] products;
                    for (Product product2 : AnonymousClass1.this.a.getProducts()) {
                        JSONObject jSONObject = hashMap.get(product2.getId());
                        if (jSONObject != null) {
                            try {
                                product2.writeStoreProductData(jSONObject);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                    if (!PurchaseSettings.sPrioritizeGameLibProductList) {
                        try {
                            AnonymousClass1.this.a.removeProductsNotDefinedInStore(hashMap);
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                        }
                    }
                    AnonymousClass1.this.b.onSuccess(AnonymousClass1.this.a);
                }

                @Override // net.gree.gamelib.core.CallbackListener
                public void onError(int i, String str) {
                    AnonymousClass1.this.b.onError(i, str);
                }
            });
        }

        @Override // net.gree.gamelib.core.CallbackListener
        public void onError(int i, String str) {
            this.b.onError(i, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface a {
        void a(int i, String str);

        void a(List<g> list);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Shop() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Shop(Payment payment) {
        this.l = payment;
        Payment payment2 = this.l;
        if (payment2 != null) {
            this.m = new c(payment2.getParams());
        }
        PurchaseSettings.init();
        if (b.a.equalsIgnoreCase(this.l.getStoreType()) || (this.l.getParams() != null && i.equalsIgnoreCase(this.l.getParams().get(SettingConsts.PRODUCT_LIST_PRIORITY)))) {
            PurchaseSettings.sPrioritizeGameLibProductList = true;
        }
        this.o = new net.gree.gamelib.payment.internal.shop.a(this.l.getContext());
        this.n = i.a(this.l.getStoreType());
        this.n.a(this.l.getContext(), this.l, this.o);
    }

    static void b() {
        k = null;
    }

    public static synchronized Shop getInstance() {
        synchronized (Shop.class) {
            if (Payment.getInstance() instanceof d) {
                return e.a();
            }
            if (k == null) {
                k = net.gree.gamelib.payment.shop.a.a();
            }
            return k;
        }
    }

    String a(String str) {
        return a(str, Constants.MD5);
    }

    String a(String str, String str2) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(str2);
            messageDigest.update(str.getBytes());
            StringBuilder sb = new StringBuilder();
            byte[] digest = messageDigest.digest();
            int length = digest.length;
            for (int i2 = 0; i2 < length; i2++) {
                sb.append(String.format("%02X", Integer.valueOf(digest[i2] & 255)));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    OrderListener a(final String str, final OrderListener orderListener) {
        return new OrderListener() { // from class: net.gree.gamelib.payment.shop.Shop.7
            @Override // net.gree.gamelib.core.CallbackListener
            /* renamed from: a */
            public void onSuccess(Order order) {
                order.a(str);
                net.gree.gamelib.payment.internal.shop.b a2 = Shop.this.o.a(order.getPurchaseId(), order.getProductId(), Shop.this.l.getUuid());
                OrderListener orderListener2 = orderListener;
                if (orderListener2 != null) {
                    if (a2 != null) {
                        orderListener2.onSuccess(order);
                    } else {
                        orderListener2.onError(PaymentError.ERROR_CODE_PAYMENT_LOCAL_HISTORY_DB_NOT_FOUND, PaymentError.ERROR_MESSAGE_PAYMENT_LOCAL_HISTORY_DB_NOT_FOUND);
                    }
                }
            }

            @Override // net.gree.gamelib.core.CallbackListener
            public void onError(int i2, String str2) {
                OrderListener orderListener2 = orderListener;
                if (orderListener2 != null) {
                    orderListener2.onError(i2, str2);
                }
            }

            @Override // net.gree.gamelib.payment.shop.OrderListener
            public void onNeedCautionBeforePurchase(Order order) {
                order.a(str);
                net.gree.gamelib.payment.internal.shop.b a2 = Shop.this.o.a(order.getPurchaseId(), order.getProductId(), Shop.this.l.getUuid());
                OrderListener orderListener2 = orderListener;
                if (orderListener2 != null) {
                    if (a2 != null) {
                        orderListener2.onNeedCautionBeforePurchase(order);
                    } else {
                        orderListener2.onError(PaymentError.ERROR_CODE_PAYMENT_LOCAL_HISTORY_DB_NOT_FOUND, PaymentError.ERROR_MESSAGE_PAYMENT_LOCAL_HISTORY_DB_NOT_FOUND);
                    }
                }
            }
        };
    }

    void a(final g gVar, final PaymentListener<Void> paymentListener) {
        String f2;
        String h2;
        String i2;
        SignedRequest signedRequest = this.l.getSignedRequest();
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.l.getStoreType().equalsIgnoreCase(net.gree.gamelib.payment.internal.a.a.a)) {
                a(jSONObject, gVar.f(), Base64.encodeToString(gVar.k().getBytes(), 2), gVar.j(), this.n.d());
            } else {
                if (this.l.getStoreType().equalsIgnoreCase(b.a)) {
                    f2 = gVar.f();
                    h2 = Base64.encodeToString(gVar.k().getBytes(), 2);
                    i2 = gVar.i();
                } else {
                    f2 = gVar.f();
                    h2 = gVar.h();
                    i2 = gVar.i();
                }
                a(jSONObject, f2, h2, i2);
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        signedRequest.setEntity(jSONObject.toString());
        signedRequest.request("POST", this.m.g("v1.0"), new net.gree.gamelib.payment.internal.b.b<net.gree.gamelib.payment.internal.b.a>(a, new PaymentListener<net.gree.gamelib.payment.internal.b.a>() { // from class: net.gree.gamelib.payment.shop.Shop.12
            @Override // net.gree.gamelib.core.CallbackListener
            /* renamed from: a */
            public void onSuccess(net.gree.gamelib.payment.internal.b.a aVar) {
                Shop.this.b(gVar, paymentListener);
            }

            @Override // net.gree.gamelib.core.CallbackListener
            public void onError(int i3, String str) {
                if (Shop.this.a(i3)) {
                    Shop.this.b(gVar, paymentListener);
                    return;
                }
                PaymentListener paymentListener2 = paymentListener;
                if (paymentListener2 == null) {
                    return;
                }
                paymentListener2.onError(i3, str);
            }
        }) { // from class: net.gree.gamelib.payment.shop.Shop.13
            @Override // net.gree.gamelib.payment.internal.b.b
            /* renamed from: toPaymentResponse */
            protected net.gree.gamelib.payment.internal.b.a mo54toPaymentResponse(String str) {
                return null;
            }
        });
    }

    void a(h hVar) {
        this.n = hVar;
    }

    void a(net.gree.gamelib.payment.internal.shop.a aVar) {
        this.o = aVar;
    }

    void a(Product product, OrderListener orderListener) {
        SignedRequest signedRequest = this.l.getSignedRequest();
        signedRequest.addCustomValues("paymentApiToken", a(c()));
        JSONObject jSONObject = new JSONObject();
        if (product == null) {
            orderListener.onError(PaymentError.ERROR_CODE_SUBMIT_INVALID_PRODUCT_ID, PaymentError.ERROR_MESSAGE_SUBMIT_INVALID_PRODUCT_ID);
            return;
        }
        try {
            a(jSONObject, product);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        signedRequest.setEntity(jSONObject.toString());
        signedRequest.request("POST", this.m.f("v1.0"), new Order.ResponseAdapter(orderListener));
    }

    void a(final a aVar) {
        this.n.a(new PaymentListener<List<g>>() { // from class: net.gree.gamelib.payment.shop.Shop.9
            @Override // net.gree.gamelib.core.CallbackListener
            /* renamed from: a */
            public void onSuccess(List<g> list) {
                a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.a(list);
                }
            }

            @Override // net.gree.gamelib.core.CallbackListener
            public void onError(int i2, String str) {
                a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.a(i2, str);
                }
            }
        });
    }

    void a(JSONObject jSONObject, String str, String str2, String str3) {
        jSONObject.put("purchase_id", str);
        jSONObject.put(g.e, str2);
        jSONObject.put("signature", str3);
    }

    void a(JSONObject jSONObject, String str, String str2, String str3, boolean z) {
        jSONObject.put("purchase_id", str);
        jSONObject.put(g.e, str2);
        jSONObject.put("user_id", str3);
        jSONObject.put("is_sandbox", z);
    }

    void a(JSONObject jSONObject, Product product) {
        jSONObject.put(Product.KEY_ID, product.getId());
        jSONObject.put(Product.KEY_COUNTRY_CODE, product.getCountryCode());
        jSONObject.put(Product.KEY_CURRENCY_CODE, product.getCurrencyCode());
        jSONObject.put("translated_name", product.getName());
        jSONObject.put(Product.KEY_FORMATTED_PRICE, product.getFormattedPrice());
        jSONObject.put("price", product.getPriceString());
    }

    void a(JSONObject jSONObject, boolean z, double d2) {
        jSONObject.put("purchase_alert", z);
        if (!Double.isNaN(d2)) {
            jSONObject.put("threshold_amount", d2);
        }
    }

    boolean a(int i2) {
        for (int i3 : j) {
            if (i2 == i3) {
                return true;
            }
        }
        return false;
    }

    void b(g gVar, PaymentListener<Void> paymentListener) {
        net.gree.gamelib.payment.internal.shop.b c2 = this.o.c(gVar.a(), gVar.c(), this.l.getUuid());
        if (c2 != null) {
            c2.b(3);
            this.o.b(c2);
        }
        if (!PurchaseSettings.sSkipConsumePurchase) {
            this.n.a(gVar, paymentListener);
        } else if (paymentListener == null) {
        } else {
            paymentListener.onSuccess(null);
        }
    }

    void b(JSONObject jSONObject, Product product) {
        jSONObject.put(Product.KEY_ID, product.getId());
        jSONObject.put(Product.KEY_COUNTRY_CODE, product.getCountryCode());
        jSONObject.put(Product.KEY_CURRENCY_CODE, product.getCurrencyCode());
        jSONObject.put(Product.KEY_FORMATTED_PRICE, product.getFormattedPrice());
        jSONObject.put("price", product.getPriceString());
    }

    String c() {
        return DateFormat.format("yyyyMMddkkmmss", Calendar.getInstance()).toString();
    }

    public void confirmPurchaseTransaction(final PaymentListener<Boolean> paymentListener) {
        a(new a() { // from class: net.gree.gamelib.payment.shop.Shop.8
            @Override // net.gree.gamelib.payment.shop.Shop.a
            public void a(int i2, String str) {
                PaymentListener paymentListener2 = paymentListener;
                if (paymentListener2 != null) {
                    paymentListener2.onError(i2, str);
                }
            }

            @Override // net.gree.gamelib.payment.shop.Shop.a
            public void a(List<g> list) {
                if (paymentListener != null) {
                    boolean z = list.size() > 0;
                    if (z) {
                        GLog.i(Shop.a, "Uncompleted transaction remains.");
                    }
                    paymentListener.onSuccess(Boolean.valueOf(z));
                }
            }
        });
    }

    public void disposePurchase() {
        if (!PurchaseSettings.sIgnoreBillingSupported) {
            this.n.b();
        }
    }

    public void getPurchaseAlertSetting(PaymentListener<PurchaseAlertSetting> paymentListener) {
        this.l.getSignedRequest().request("GET", this.m.j("v1.0"), new PurchaseAlertSetting.ResponseAdapter(paymentListener));
    }

    public boolean handleActivityResult(int i2, int i3, Intent intent) {
        h hVar = this.n;
        if (hVar != null) {
            return hVar.a(i2, i3, intent);
        }
        return false;
    }

    public void queryOrder(final Product product, final OrderListener orderListener) {
        restorePurchaseTransaction(new PaymentListener<Boolean>() { // from class: net.gree.gamelib.payment.shop.Shop.6
            @Override // net.gree.gamelib.core.CallbackListener
            /* renamed from: a */
            public void onSuccess(Boolean bool) {
                if (product == null) {
                    orderListener.onError(PaymentError.ERROR_CODE_SUBMIT_INVALID_PRODUCT_ID, PaymentError.ERROR_MESSAGE_SUBMIT_INVALID_PRODUCT_ID);
                } else if (!PurchaseSettings.sPrioritizeGameLibProductList) {
                    HashSet hashSet = new HashSet();
                    hashSet.add(product.getId());
                    Shop.this.n.a(hashSet, new PaymentListener<HashMap<String, JSONObject>>() { // from class: net.gree.gamelib.payment.shop.Shop.6.1
                        @Override // net.gree.gamelib.core.CallbackListener
                        /* renamed from: a */
                        public void onSuccess(HashMap<String, JSONObject> hashMap) {
                            JSONObject jSONObject = hashMap.get(product.getId());
                            if (jSONObject == null) {
                                orderListener.onError(PaymentError.ERROR_CODE_SUBMIT_INVALID_PRODUCT_ID, PaymentError.ERROR_MESSAGE_SUBMIT_INVALID_PRODUCT_ID);
                                return;
                            }
                            try {
                                product.writeStoreProductData(jSONObject);
                            } catch (JSONException e2) {
                                e2.printStackTrace();
                            }
                            Shop.this.a(product, Shop.this.a(product.getId(), orderListener));
                        }

                        @Override // net.gree.gamelib.core.CallbackListener
                        public void onError(int i2, String str) {
                            orderListener.onError(i2, str);
                        }
                    });
                } else {
                    Shop shop = Shop.this;
                    Product product2 = product;
                    shop.a(product2, shop.a(product2.getId(), orderListener));
                }
            }

            @Override // net.gree.gamelib.core.CallbackListener
            public void onError(int i2, String str) {
                OrderListener orderListener2 = orderListener;
                if (orderListener2 != null) {
                    orderListener2.onError(i2, str);
                }
            }
        });
    }

    public void queryProductList(PaymentListener<ProductList> paymentListener) {
        this.l.getSignedRequest().request("GET", this.m.e("v1.0"), new ProductList.ResponseAdapter(new AnonymousClass1(paymentListener)));
    }

    public void queryPurchaseAlert(final Product product, final PaymentListener<PurchaseAlert> paymentListener, String str) {
        final SignedRequest signedRequest = this.l.getSignedRequest();
        final JSONObject jSONObject = new JSONObject();
        if (product == null) {
            paymentListener.onError(PaymentError.ERROR_CODE_SUBMIT_INVALID_PRODUCT_ID, PaymentError.ERROR_MESSAGE_SUBMIT_INVALID_PRODUCT_ID);
        } else if (!PurchaseSettings.sPrioritizeGameLibProductList) {
            HashSet hashSet = new HashSet();
            hashSet.add(product.getId());
            this.n.a(hashSet, new PaymentListener<HashMap<String, JSONObject>>() { // from class: net.gree.gamelib.payment.shop.Shop.3
                @Override // net.gree.gamelib.core.CallbackListener
                /* renamed from: a */
                public void onSuccess(HashMap<String, JSONObject> hashMap) {
                    JSONObject jSONObject2 = hashMap.get(product.getId());
                    if (jSONObject2 != null) {
                        try {
                            product.writeStoreProductData(jSONObject2);
                            Shop.this.b(jSONObject, product);
                            signedRequest.setEntity(jSONObject.toString());
                            signedRequest.request("POST", Shop.this.m.i("v1.0"), new PurchaseAlert.ResponseAdapter(paymentListener));
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                        }
                    }
                }

                @Override // net.gree.gamelib.core.CallbackListener
                public void onError(int i2, String str2) {
                    paymentListener.onError(i2, str2);
                }
            });
        } else {
            try {
                b(jSONObject, product);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            signedRequest.setEntity(jSONObject.toString());
            signedRequest.request("POST", this.m.i("v1.0"), new PurchaseAlert.ResponseAdapter(paymentListener));
        }
    }

    public void queryTicketStatus(PaymentListener<TicketList> paymentListener) {
        this.l.getSignedRequest().request("GET", this.m.l("v1.0"), new TicketList.ResponseAdapter(paymentListener));
    }

    public void queryUnfinishedOrder(final PaymentListener<Order> paymentListener) {
        a(new a() { // from class: net.gree.gamelib.payment.shop.Shop.2
            @Override // net.gree.gamelib.payment.shop.Shop.a
            public void a(int i2, String str) {
                PaymentListener paymentListener2 = paymentListener;
                if (paymentListener2 != null) {
                    paymentListener2.onError(i2, str);
                }
            }

            @Override // net.gree.gamelib.payment.shop.Shop.a
            public void a(List<g> list) {
                int i2;
                String str;
                if (list.size() > 0) {
                    try {
                        g gVar = list.get(0);
                        Order order = new Order(gVar.f(), gVar.c(), false);
                        order.b(gVar.h());
                        order.c(gVar.i());
                        if (paymentListener == null) {
                            return;
                        }
                        paymentListener.onSuccess(order);
                        return;
                    } catch (JSONException unused) {
                        i2 = 2000;
                        str = PaymentError.ERROR_MESSAGE_COMMON_JSON_PARSING_ERROR;
                    }
                } else {
                    i2 = PaymentError.ERROR_CODE_RESTORE_ORDER_NO_REMAIN_ORDER;
                    str = PaymentError.ERROR_MESSAGE_RESTORE_ORDER_NO_REMAIN_ORDER;
                }
                a(i2, str);
            }
        });
    }

    public void restorePurchaseTransaction(final PaymentListener<Boolean> paymentListener) {
        a(new a() { // from class: net.gree.gamelib.payment.shop.Shop.10
            @Override // net.gree.gamelib.payment.shop.Shop.a
            public void a(int i2, String str) {
                PaymentListener paymentListener2 = paymentListener;
                if (paymentListener2 != null) {
                    paymentListener2.onError(i2, str);
                }
            }

            @Override // net.gree.gamelib.payment.shop.Shop.a
            public void a(List<g> list) {
                if (list.size() == 0) {
                    PaymentListener paymentListener2 = paymentListener;
                    if (paymentListener2 == null) {
                        return;
                    }
                    paymentListener2.onSuccess(false);
                    return;
                }
                final ArrayList arrayList = new ArrayList(list);
                final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
                for (final g gVar : list) {
                    Shop.this.a(gVar, new PaymentListener<Void>() { // from class: net.gree.gamelib.payment.shop.Shop.10.1
                        @Override // net.gree.gamelib.core.CallbackListener
                        /* renamed from: a */
                        public void onSuccess(Void r2) {
                            arrayList.remove(gVar);
                            if (arrayList.size() != 0 || paymentListener == null || atomicBoolean.getAndSet(true)) {
                                return;
                            }
                            paymentListener.onSuccess(true);
                        }

                        @Override // net.gree.gamelib.core.CallbackListener
                        public void onError(int i2, String str) {
                            arrayList.remove(gVar);
                            if (paymentListener == null || atomicBoolean.getAndSet(true)) {
                                return;
                            }
                            paymentListener.onError(i2, str);
                        }
                    });
                }
            }
        });
    }

    public void submit(final Activity activity, final Order order, final PaymentListener<Void> paymentListener) {
        restorePurchaseTransaction(new PaymentListener<Boolean>() { // from class: net.gree.gamelib.payment.shop.Shop.11
            @Override // net.gree.gamelib.core.CallbackListener
            /* renamed from: a */
            public void onSuccess(Boolean bool) {
                try {
                    net.gree.gamelib.payment.internal.shop.b b2 = Shop.this.o.b(order.getPurchaseId(), order.getProductId(), Shop.this.l.getUuid());
                    if (b2 != null && b2.h() != 1 && b2.h() != 3 && b2.h() != 2) {
                        Shop.this.n.a(activity, order, new PaymentListener<g>() { // from class: net.gree.gamelib.payment.shop.Shop.11.1
                            @Override // net.gree.gamelib.core.CallbackListener
                            /* renamed from: a */
                            public void onSuccess(g gVar) {
                                Shop.this.a(gVar, paymentListener);
                            }

                            @Override // net.gree.gamelib.core.CallbackListener
                            public void onError(int i2, String str) {
                                if (paymentListener != null) {
                                    paymentListener.onError(i2, str);
                                }
                            }
                        });
                    } else if (paymentListener == null) {
                    } else {
                        paymentListener.onError(17220, "Wrong Purchase Status");
                    }
                } catch (IllegalArgumentException e2) {
                    e2.printStackTrace();
                    PaymentListener paymentListener2 = paymentListener;
                    if (paymentListener2 == null) {
                        return;
                    }
                    paymentListener2.onError(17220, "Illegal Argument for LocalIAPHistory");
                }
            }

            @Override // net.gree.gamelib.core.CallbackListener
            public void onError(int i2, String str) {
                PaymentListener paymentListener2 = paymentListener;
                if (paymentListener2 != null) {
                    paymentListener2.onError(i2, str);
                }
            }
        });
    }

    public void updatePurchaseAlertSetting(boolean z, double d2, final PaymentListener<Void> paymentListener, String str) {
        SignedRequest signedRequest = this.l.getSignedRequest();
        JSONObject jSONObject = new JSONObject();
        try {
            a(jSONObject, z, d2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        signedRequest.setEntity(jSONObject.toString());
        signedRequest.request("POST", this.m.k("v1.0"), new net.gree.gamelib.payment.internal.b.b<net.gree.gamelib.payment.internal.b.a>(a, new PaymentListener<net.gree.gamelib.payment.internal.b.a>() { // from class: net.gree.gamelib.payment.shop.Shop.4
            @Override // net.gree.gamelib.core.CallbackListener
            /* renamed from: a */
            public void onSuccess(net.gree.gamelib.payment.internal.b.a aVar) {
                PaymentListener paymentListener2 = paymentListener;
                if (paymentListener2 != null) {
                    paymentListener2.onSuccess(null);
                }
            }

            @Override // net.gree.gamelib.core.CallbackListener
            public void onError(int i2, String str2) {
                PaymentListener paymentListener2 = paymentListener;
                if (paymentListener2 != null) {
                    paymentListener2.onError(i2, str2);
                }
            }
        }) { // from class: net.gree.gamelib.payment.shop.Shop.5
            @Override // net.gree.gamelib.payment.internal.b.b
            /* renamed from: toPaymentResponse */
            protected net.gree.gamelib.payment.internal.b.a mo54toPaymentResponse(String str2) {
                return null;
            }
        });
    }
}
