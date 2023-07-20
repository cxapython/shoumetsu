package net.gree.gamelib.payment.internal.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import net.gree.gamelib.payment.Payment;
import net.gree.gamelib.payment.PaymentListener;
import net.gree.gamelib.payment.shop.Order;
import org.json.JSONObject;

/* loaded from: classes.dex */
public interface h {
    public static final int e = 0;
    public static final int f = 1;
    public static final int g = 3;
    public static final int h = 4;
    public static final int i = 5;
    public static final int j = 6;
    public static final int k = 7;
    public static final int l = 8;

    String a();

    void a(Activity activity, Order order, PaymentListener<g> paymentListener);

    void a(Context context, Payment payment, net.gree.gamelib.payment.internal.shop.a aVar);

    void a(Set<String> set, PaymentListener<HashMap<String, JSONObject>> paymentListener);

    void a(PaymentListener<List<g>> paymentListener);

    void a(g gVar, PaymentListener<Void> paymentListener);

    boolean a(int i2, int i3, Intent intent);

    void b();

    boolean d();
}
