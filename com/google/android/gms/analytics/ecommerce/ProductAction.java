package com.google.android.gms.analytics.ecommerce;

import com.google.android.gms.analytics.zzi;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.HashMap;
import java.util.Map;

@VisibleForTesting
/* loaded from: classes.dex */
public class ProductAction {
    public static final String ACTION_ADD = "add";
    public static final String ACTION_CHECKOUT = "checkout";
    public static final String ACTION_CHECKOUT_OPTION = "checkout_option";
    @Deprecated
    public static final String ACTION_CHECKOUT_OPTIONS = "checkout_options";
    public static final String ACTION_CLICK = "click";
    public static final String ACTION_DETAIL = "detail";
    public static final String ACTION_PURCHASE = "purchase";
    public static final String ACTION_REFUND = "refund";
    public static final String ACTION_REMOVE = "remove";
    private Map<String, String> a = new HashMap();

    public ProductAction(String str) {
        a("&pa", str);
    }

    private final void a(String str, String str2) {
        Preconditions.checkNotNull(str, "Name should be non-null");
        this.a.put(str, str2);
    }

    @VisibleForTesting
    public final Map<String, String> build() {
        return new HashMap(this.a);
    }

    public ProductAction setCheckoutOptions(String str) {
        a("&col", str);
        return this;
    }

    public ProductAction setCheckoutStep(int i) {
        a("&cos", Integer.toString(i));
        return this;
    }

    public ProductAction setProductActionList(String str) {
        a("&pal", str);
        return this;
    }

    public ProductAction setProductListSource(String str) {
        a("&pls", str);
        return this;
    }

    public ProductAction setTransactionAffiliation(String str) {
        a("&ta", str);
        return this;
    }

    public ProductAction setTransactionCouponCode(String str) {
        a("&tcc", str);
        return this;
    }

    public ProductAction setTransactionId(String str) {
        a("&ti", str);
        return this;
    }

    public ProductAction setTransactionRevenue(double d) {
        a("&tr", Double.toString(d));
        return this;
    }

    public ProductAction setTransactionShipping(double d) {
        a("&ts", Double.toString(d));
        return this;
    }

    public ProductAction setTransactionTax(double d) {
        a("&tt", Double.toString(d));
        return this;
    }

    public String toString() {
        HashMap hashMap = new HashMap();
        for (Map.Entry<String, String> entry : this.a.entrySet()) {
            hashMap.put(entry.getKey().startsWith("&") ? entry.getKey().substring(1) : entry.getKey(), entry.getValue());
        }
        return zzi.zza((Map) hashMap);
    }
}
