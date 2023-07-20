package com.amazon.device.iap.internal;

import android.content.Context;
import android.content.Intent;
import com.amazon.device.iap.PurchasingListener;
import com.amazon.device.iap.model.FulfillmentResult;
import com.amazon.device.iap.model.RequestId;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

/* loaded from: classes.dex */
public class d {
    private static String a = "d";
    private static String b = "sku";
    private static d c = new d();
    private final c d = e.b();
    private Context e;
    private PurchasingListener f;

    private d() {
    }

    public static d d() {
        return c;
    }

    private void e() {
        if (this.f != null) {
            return;
        }
        throw new IllegalStateException("You must register a PurchasingListener before invoking this operation");
    }

    public PurchasingListener a() {
        return this.f;
    }

    public RequestId a(String str) {
        com.amazon.device.iap.internal.util.d.a((Object) str, b);
        e();
        RequestId requestId = new RequestId();
        this.d.a(requestId, str);
        return requestId;
    }

    public RequestId a(Set<String> set) {
        com.amazon.device.iap.internal.util.d.a((Object) set, "skus");
        com.amazon.device.iap.internal.util.d.a((Collection<? extends Object>) set, "skus");
        for (String str : set) {
            if (str.trim().length() == 0) {
                throw new IllegalArgumentException("Empty SKU values are not allowed");
            }
        }
        if (set.size() <= 100) {
            e();
            RequestId requestId = new RequestId();
            this.d.a(requestId, new LinkedHashSet(set));
            return requestId;
        }
        throw new IllegalArgumentException(set.size() + " SKUs were provided, but no more than 100 SKUs are allowed");
    }

    public RequestId a(boolean z) {
        e();
        RequestId requestId = new RequestId();
        this.d.a(requestId, z);
        return requestId;
    }

    public void a(Context context, Intent intent) {
        try {
            this.d.a(context, intent);
        } catch (Exception e) {
            String str = a;
            com.amazon.device.iap.internal.util.e.b(str, "Error in onReceive: " + e);
        }
    }

    public void a(Context context, PurchasingListener purchasingListener) {
        String str = a;
        com.amazon.device.iap.internal.util.e.a(str, "PurchasingListener registered: " + purchasingListener);
        String str2 = a;
        com.amazon.device.iap.internal.util.e.a(str2, "PurchasingListener Context: " + context);
        if (purchasingListener == null || context == null) {
            throw new IllegalArgumentException("Neither PurchasingListener or its Context can be null");
        }
        this.e = context.getApplicationContext();
        this.f = purchasingListener;
    }

    public void a(String str, FulfillmentResult fulfillmentResult) {
        if (!com.amazon.device.iap.internal.util.d.a(str)) {
            com.amazon.device.iap.internal.util.d.a(fulfillmentResult, "fulfillmentResult");
            e();
            this.d.a(new RequestId(), str, fulfillmentResult);
            return;
        }
        throw new IllegalArgumentException("Empty receiptId is not allowed");
    }

    public Context b() {
        return this.e;
    }

    public RequestId c() {
        e();
        RequestId requestId = new RequestId();
        this.d.a(requestId);
        return requestId;
    }
}
