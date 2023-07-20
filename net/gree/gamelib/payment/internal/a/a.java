package net.gree.gamelib.payment.internal.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import com.amazon.device.iap.PurchasingListener;
import com.amazon.device.iap.PurchasingService;
import com.amazon.device.iap.model.FulfillmentResult;
import com.amazon.device.iap.model.Product;
import com.amazon.device.iap.model.ProductDataResponse;
import com.amazon.device.iap.model.PurchaseResponse;
import com.amazon.device.iap.model.PurchaseUpdatesResponse;
import com.amazon.device.iap.model.Receipt;
import com.amazon.device.iap.model.UserData;
import com.amazon.device.iap.model.UserDataResponse;
import com.google.android.gms.analytics.ecommerce.ProductAction;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Currency;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import net.gree.gamelib.core.Core;
import net.gree.gamelib.core.GLog;
import net.gree.gamelib.payment.Payment;
import net.gree.gamelib.payment.PaymentError;
import net.gree.gamelib.payment.PaymentListener;
import net.gree.gamelib.payment.shop.Order;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class a implements PurchasingListener, h {
    public static final String a = "amazon";
    static final String b = "a";
    private static long v = 30000;
    private net.gree.gamelib.payment.internal.shop.a m;
    private Payment o;
    private UserData q;
    private PaymentListener<HashMap<String, JSONObject>> r;
    private PaymentListener<g> s;
    private PaymentListener<List<g>> t;
    private long u = 0;
    boolean c = false;
    String d = "";
    private List<g> p = null;
    private CountDownLatch n = new CountDownLatch(1);

    protected static String a(PurchaseResponse.RequestStatus requestStatus) {
        return "Purchase " + requestStatus.toString();
    }

    public static g a(Receipt receipt, UserData userData, net.gree.gamelib.payment.internal.shop.b bVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("productId", receipt.getSku());
            jSONObject.put(g.e, receipt.toString());
            jSONObject.put(g.c, userData.getUserId());
            jSONObject.put(g.b, receipt.getReceiptId());
            Date purchaseDate = receipt.getPurchaseDate();
            if (purchaseDate != null) {
                jSONObject.put(g.f, purchaseDate.getTime());
            }
            if (bVar != null) {
                jSONObject.put(g.h, bVar.a());
                jSONObject.put(g.d, bVar.i());
            }
            return new g(jSONObject.toString(), null);
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // net.gree.gamelib.payment.internal.a.h
    public String a() {
        return a;
    }

    protected JSONObject a(Product product) {
        String str = "";
        String marketplace = this.q.getMarketplace();
        Locale locale = new Locale("", marketplace);
        String price = product.getPrice();
        if (price != null && price.length() > 0) {
            try {
                str = NumberFormat.getCurrencyInstance(locale).parse(price).toString();
            } catch (ParseException unused) {
            }
            if (str == null || str.length() == 0) {
                str = price.replaceAll("[^\\d.]", "");
            }
        }
        String currencyCode = Currency.getInstance(locale).getCurrencyCode();
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(net.gree.gamelib.payment.shop.Product.KEY_ID, product.getSku());
        jSONObject.put(net.gree.gamelib.payment.shop.Product.KEY_NAME, product.getTitle());
        jSONObject.put(net.gree.gamelib.payment.shop.Product.KEY_FORMATTED_PRICE, price);
        jSONObject.put("price", str);
        jSONObject.put(net.gree.gamelib.payment.shop.Product.KEY_CURRENCY_CODE, currencyCode);
        jSONObject.put(net.gree.gamelib.payment.shop.Product.KEY_COUNTRY_CODE, marketplace);
        jSONObject.put("description", product.getDescription());
        return jSONObject;
    }

    @Override // net.gree.gamelib.payment.internal.a.h
    public void a(Activity activity, final Order order, final PaymentListener<g> paymentListener) {
        GLog.v(b, "purchase is called");
        try {
            a(ProductAction.ACTION_PURCHASE);
            Core.EXECUTOR.execute(new Runnable() { // from class: net.gree.gamelib.payment.internal.a.a.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        a.this.n.await();
                        a.this.s = paymentListener;
                        a.this.m.e(order.getProductId(), order.getPurchaseId(), PurchasingService.purchase(order.getProductId()).toString());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        if (paymentListener == null) {
                            return;
                        }
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: net.gree.gamelib.payment.internal.a.a.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                paymentListener.onError(5, "To wait for Startup is failed");
                            }
                        });
                    }
                }
            });
        } catch (IllegalStateException unused) {
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
        String str = b;
        GLog.v(str, "startSettup:" + a() + ", SAND_BOX_MODE" + PurchasingService.IS_SANDBOX_MODE);
        this.o = payment;
        PurchasingService.registerListener(context.getApplicationContext(), this);
        this.m = aVar;
        PurchasingService.getUserData();
    }

    void a(String str) {
        long time = new Date().getTime();
        if (this.c && time < this.u + v) {
            throw new IllegalStateException("Can't start async operation (" + str + ") because another async operation(" + this.d + ") is in progress.");
        }
        this.d = str;
        this.c = true;
        this.u = time;
        String str2 = b;
        GLog.i(str2, "Starting async operation: " + str);
    }

    @Override // net.gree.gamelib.payment.internal.a.h
    public void a(Set<String> set, PaymentListener<HashMap<String, JSONObject>> paymentListener) {
        GLog.v(b, "start getProducts");
        try {
            a("get products");
            this.r = paymentListener;
            PurchasingService.getProductData(set);
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
    public void a(PaymentListener<List<g>> paymentListener) {
        try {
            a("get purchaes");
            this.p = new ArrayList();
            this.t = paymentListener;
            GLog.v(b, "start getPurchases");
            PurchasingService.getPurchaseUpdates(false);
        } catch (IllegalStateException unused) {
            if (paymentListener == null) {
                return;
            }
            paymentListener.onError(17219, "The process is already in progress");
        } catch (RuntimeException e) {
            this.p = null;
            if (paymentListener == null) {
                return;
            }
            paymentListener.onError(17220, e.getMessage());
        }
    }

    @Override // net.gree.gamelib.payment.internal.a.h
    public void a(g gVar, PaymentListener<Void> paymentListener) {
        GLog.v(b, "call consume");
        try {
            a("consume");
            PurchasingService.notifyFulfillment(gVar.a(), FulfillmentResult.FULFILLED);
            c();
            if (paymentListener == null) {
                return;
            }
            paymentListener.onSuccess(null);
        } catch (IllegalStateException unused) {
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
        GLog.e(b, "Wrong Interface");
        c();
        return false;
    }

    @Override // net.gree.gamelib.payment.internal.a.h
    public void b() {
    }

    void c() {
        String str = b;
        GLog.i(str, "Ending async operation: " + this.d);
        this.d = "";
        this.c = false;
    }

    @Override // net.gree.gamelib.payment.internal.a.h
    public boolean d() {
        return PurchasingService.IS_SANDBOX_MODE;
    }

    @Override // com.amazon.device.iap.PurchasingListener
    public void onProductDataResponse(ProductDataResponse productDataResponse) {
        GLog.v(b, "onProductDataResponse is called");
        HashMap<String, JSONObject> hashMap = new HashMap<>();
        if (productDataResponse.getRequestStatus() == ProductDataResponse.RequestStatus.SUCCESSFUL) {
            for (String str : productDataResponse.getProductData().keySet()) {
                try {
                    hashMap.put(str, a(productDataResponse.getProductData().get(str)));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            PaymentListener<HashMap<String, JSONObject>> paymentListener = this.r;
            if (paymentListener != null) {
                paymentListener.onSuccess(hashMap);
                this.r = null;
            }
        } else {
            PaymentListener<HashMap<String, JSONObject>> paymentListener2 = this.r;
            if (paymentListener2 != null) {
                paymentListener2.onError(4, productDataResponse.getRequestStatus().toString());
                this.r = null;
            }
        }
        c();
    }

    @Override // com.amazon.device.iap.PurchasingListener
    public void onPurchaseResponse(PurchaseResponse purchaseResponse) {
        int i;
        String str;
        String userId;
        String str2 = b;
        GLog.v(str2, "onPurchaseResponse is called:" + purchaseResponse.toString());
        JSONObject jSONObject = new JSONObject();
        switch (purchaseResponse.getRequestStatus()) {
            case ALREADY_PURCHASED:
                i = 7;
                break;
            case FAILED:
                i = 1;
                break;
            case INVALID_SKU:
                i = 4;
                break;
            case NOT_SUPPORTED:
            default:
                i = 6;
                break;
            case SUCCESSFUL:
                i = 0;
                break;
        }
        if (i != 0) {
            this.m.a(purchaseResponse.getRequestId().toString(), i);
            PaymentListener<g> paymentListener = this.s;
            if (paymentListener != null) {
                if (i == 1) {
                    paymentListener.onError(PaymentError.ERROR_CODE_SUBMIT_CANCELED, PaymentError.ERROR_MESSAGE_SUBMIT_CANCELED);
                } else {
                    paymentListener.onError(17220, a(purchaseResponse.getRequestStatus()));
                }
                this.s = null;
            }
            c();
        }
        try {
            Receipt receipt = purchaseResponse.getReceipt();
            net.gree.gamelib.payment.internal.shop.b a2 = this.m.a(purchaseResponse.getRequestId().toString(), this.o.getUuid());
            jSONObject.put("productId", receipt.getSku());
            if (purchaseResponse.getUserData() == null || purchaseResponse.getUserData().getUserId().length() <= 0) {
                str = g.c;
                userId = this.q.getUserId();
            } else {
                str = g.c;
                userId = purchaseResponse.getUserData().getUserId();
            }
            jSONObject.put(str, userId);
            jSONObject.put(g.d, purchaseResponse.getRequestId());
            jSONObject.put(g.b, receipt.getReceiptId());
            jSONObject.put(g.e, receipt.toString());
            if (a2 != null) {
                jSONObject.put(g.h, a2.a());
            }
            this.m.a(receipt.getSku(), purchaseResponse.getRequestId().toString(), receipt.getReceiptId(), receipt.toString(), this.o.getUuid());
            if (this.s != null) {
                this.s.onSuccess(new g(jSONObject.toString(), null));
                this.s = null;
            }
        } catch (JSONException e) {
            e.printStackTrace();
            PaymentListener<g> paymentListener2 = this.s;
            if (paymentListener2 != null) {
                paymentListener2.onError(17220, "Amazon Receipt to JSON failed");
            }
        }
        c();
    }

    @Override // com.amazon.device.iap.PurchasingListener
    public void onPurchaseUpdatesResponse(PurchaseUpdatesResponse purchaseUpdatesResponse) {
        String str = b;
        GLog.v(str, "onPurchaseUpdatesResponse is called:" + purchaseUpdatesResponse.toString());
        if (purchaseUpdatesResponse.getRequestStatus() == PurchaseUpdatesResponse.RequestStatus.SUCCESSFUL) {
            for (Receipt receipt : purchaseUpdatesResponse.getReceipts()) {
                net.gree.gamelib.payment.internal.shop.b c = this.m.c(receipt.getReceiptId(), receipt.getSku(), this.o.getUuid());
                if (c == null) {
                    c = this.m.a(receipt.getSku(), this.o.getUuid(), 1);
                }
                g a2 = a(receipt, purchaseUpdatesResponse.getUserData(), c);
                if (a2 != null) {
                    this.p.add(a2);
                }
            }
            if (purchaseUpdatesResponse.hasMore()) {
                PurchasingService.getPurchaseUpdates(false);
                return;
            }
            c();
            PaymentListener<List<g>> paymentListener = this.t;
            if (paymentListener == null) {
                return;
            }
            paymentListener.onSuccess(this.p);
        } else {
            c();
            PaymentListener<List<g>> paymentListener2 = this.t;
            if (paymentListener2 == null) {
                return;
            }
            paymentListener2.onError(17220, "Get Purchases is failed");
        }
        this.t = null;
    }

    @Override // com.amazon.device.iap.PurchasingListener
    public void onUserDataResponse(UserDataResponse userDataResponse) {
        String str = b;
        GLog.v(str, "onUserDataResponse:" + userDataResponse.toString());
        if (userDataResponse.getRequestStatus() == UserDataResponse.RequestStatus.SUCCESSFUL) {
            this.q = userDataResponse.getUserData();
            String str2 = b;
            GLog.v(str2, "marketPlace:" + this.q.getMarketplace());
        }
        this.n.countDown();
    }
}
