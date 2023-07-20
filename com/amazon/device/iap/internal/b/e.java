package com.amazon.device.iap.internal.b;

import android.content.Context;
import android.os.Handler;
import com.amazon.device.iap.PurchasingListener;
import com.amazon.device.iap.model.ProductDataResponse;
import com.amazon.device.iap.model.PurchaseResponse;
import com.amazon.device.iap.model.PurchaseUpdatesResponse;
import com.amazon.device.iap.model.RequestId;
import com.amazon.device.iap.model.UserDataResponse;

/* loaded from: classes.dex */
public class e {
    private static final String a = "e";
    private final RequestId b;
    private final h c = new h();
    private i d = null;

    public e(RequestId requestId) {
        this.b = requestId;
    }

    public void a() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(i iVar) {
        this.d = iVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(Object obj) {
        a(obj, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(final Object obj, final i iVar) {
        com.amazon.device.iap.internal.util.d.a(obj, "response");
        Context b = com.amazon.device.iap.internal.d.d().b();
        final PurchasingListener a2 = com.amazon.device.iap.internal.d.d().a();
        if (b != null && a2 != null) {
            new Handler(b.getMainLooper()).post(new Runnable() { // from class: com.amazon.device.iap.internal.b.e.1
                @Override // java.lang.Runnable
                public void run() {
                    e.this.d().a("notifyListenerResult", Boolean.FALSE);
                    try {
                        if (obj instanceof ProductDataResponse) {
                            a2.onProductDataResponse((ProductDataResponse) obj);
                        } else if (obj instanceof UserDataResponse) {
                            a2.onUserDataResponse((UserDataResponse) obj);
                        } else if (obj instanceof PurchaseUpdatesResponse) {
                            PurchaseUpdatesResponse purchaseUpdatesResponse = (PurchaseUpdatesResponse) obj;
                            a2.onPurchaseUpdatesResponse(purchaseUpdatesResponse);
                            Object a3 = e.this.d().a("newCursor");
                            if (a3 != null && (a3 instanceof String)) {
                                com.amazon.device.iap.internal.util.b.a(purchaseUpdatesResponse.getUserData().getUserId(), a3.toString());
                            }
                        } else if (obj instanceof PurchaseResponse) {
                            a2.onPurchaseResponse((PurchaseResponse) obj);
                        } else {
                            String str = e.a;
                            com.amazon.device.iap.internal.util.e.b(str, "Unknown response type:" + obj.getClass().getName());
                        }
                        e.this.d().a("notifyListenerResult", Boolean.TRUE);
                    } catch (Throwable th) {
                        String str2 = e.a;
                        com.amazon.device.iap.internal.util.e.b(str2, "Error in sendResponse: " + th);
                    }
                    i iVar2 = iVar;
                    if (iVar2 != null) {
                        iVar2.a(true);
                        iVar.a_();
                    }
                }
            });
            return;
        }
        String str = a;
        com.amazon.device.iap.internal.util.e.a(str, "PurchasingListener is not set. Dropping response: " + obj);
    }

    public void b() {
    }

    public RequestId c() {
        return this.b;
    }

    public h d() {
        return this.c;
    }

    public void e() {
        i iVar = this.d;
        if (iVar != null) {
            iVar.a_();
        } else {
            a();
        }
    }
}
