package net.gree.gamelib.payment.internal.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import net.gree.gamelib.payment.Payment;
import net.gree.gamelib.payment.PaymentError;
import net.gree.gamelib.payment.PaymentListener;
import net.gree.gamelib.payment.internal.a.e;
import net.gree.gamelib.payment.shop.Order;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class c implements h {
    static final int a = 10001;
    public static final String b = "google";
    private e c;
    private net.gree.gamelib.payment.internal.shop.a d;
    private Payment m;
    private Context n;

    @Override // net.gree.gamelib.payment.internal.a.h
    public String a() {
        return "google";
    }

    @Override // net.gree.gamelib.payment.internal.a.h
    public void a(final Activity activity, final Order order, final PaymentListener<g> paymentListener) {
        net.gree.gamelib.payment.internal.shop.b b2 = this.d.b(order.getPurchaseId(), order.getProductId(), this.m.getUuid());
        if (b2 != null) {
            this.d.c(b2);
            this.c.a(new e.InterfaceC0073e() { // from class: net.gree.gamelib.payment.internal.a.c.4
                @Override // net.gree.gamelib.payment.internal.a.e.InterfaceC0073e
                public void a(f fVar) {
                    if (c.this.a(fVar, paymentListener)) {
                        return;
                    }
                    try {
                        c.this.c.a(c.this.m.getUuid());
                        c.this.c.a(activity, order.getProductId(), 10001, new e.d() { // from class: net.gree.gamelib.payment.internal.a.c.4.1
                            @Override // net.gree.gamelib.payment.internal.a.e.d
                            public void a(f fVar2, g gVar) {
                                if (c.this.a(fVar2, paymentListener)) {
                                    c.this.d.b(order.getProductId(), c.this.m.getUuid(), fVar2.a());
                                } else if (paymentListener == null) {
                                } else {
                                    c.this.d.a(gVar.c(), gVar.a(), gVar.f(), c.this.m.getUuid());
                                    paymentListener.onSuccess(gVar);
                                }
                            }
                        }, order.getPurchaseId());
                    } catch (IllegalStateException unused) {
                        paymentListener.onError(17219, "The process is already in progress");
                    } catch (RuntimeException e) {
                        PaymentListener paymentListener2 = paymentListener;
                        if (paymentListener2 == null) {
                            return;
                        }
                        paymentListener2.onError(17220, e.getMessage());
                    }
                }
            });
        } else if (paymentListener == null) {
        } else {
            paymentListener.onError(PaymentError.ERROR_CODE_PAYMENT_LOCAL_HISTORY_DB_NOT_FOUND, PaymentError.ERROR_MESSAGE_PAYMENT_LOCAL_HISTORY_DB_NOT_FOUND);
        }
    }

    @Override // net.gree.gamelib.payment.internal.a.h
    public void a(Context context, Payment payment, net.gree.gamelib.payment.internal.shop.a aVar) {
        this.n = context;
        this.c = new e(context);
        this.d = aVar;
        this.m = payment;
    }

    @Override // net.gree.gamelib.payment.internal.a.h
    public void a(Set<String> set, final PaymentListener<HashMap<String, JSONObject>> paymentListener) {
        if (this.c == null) {
            this.c = new e(this.n);
        }
        final ArrayList arrayList = new ArrayList(set);
        this.c.a(new e.InterfaceC0073e() { // from class: net.gree.gamelib.payment.internal.a.c.1
            @Override // net.gree.gamelib.payment.internal.a.e.InterfaceC0073e
            public void a(f fVar) {
                if (c.this.a(fVar, paymentListener)) {
                    return;
                }
                try {
                    c.this.c.a(arrayList, new e.a() { // from class: net.gree.gamelib.payment.internal.a.c.1.1
                        @Override // net.gree.gamelib.payment.internal.a.e.a
                        public void a(f fVar2, HashMap<String, JSONObject> hashMap) {
                            if (!c.this.a(fVar2, paymentListener) && paymentListener != null) {
                                paymentListener.onSuccess(hashMap);
                            }
                        }
                    });
                } catch (IllegalStateException unused) {
                    paymentListener.onError(17219, "The process is already in progress");
                } catch (RuntimeException e) {
                    PaymentListener paymentListener2 = paymentListener;
                    if (paymentListener2 == null) {
                        return;
                    }
                    paymentListener2.onError(17220, e.getMessage());
                }
            }
        });
    }

    @Override // net.gree.gamelib.payment.internal.a.h
    public void a(final PaymentListener<List<g>> paymentListener) {
        if (this.c == null) {
            this.c = new e(this.n);
        }
        this.c.a(new e.InterfaceC0073e() { // from class: net.gree.gamelib.payment.internal.a.c.2
            @Override // net.gree.gamelib.payment.internal.a.e.InterfaceC0073e
            public void a(f fVar) {
                if (c.this.a(fVar, paymentListener)) {
                    return;
                }
                try {
                    c.this.c.a(new e.b() { // from class: net.gree.gamelib.payment.internal.a.c.2.1
                        @Override // net.gree.gamelib.payment.internal.a.e.b
                        public void a(f fVar2, List<g> list) {
                            if (paymentListener != null) {
                                paymentListener.onSuccess(list);
                            }
                        }
                    });
                } catch (IllegalStateException unused) {
                    paymentListener.onError(17219, "The process is already in progress");
                } catch (RuntimeException e) {
                    PaymentListener paymentListener2 = paymentListener;
                    if (paymentListener2 == null) {
                        return;
                    }
                    paymentListener2.onError(17220, e.getMessage());
                }
            }
        });
    }

    public void a(e eVar) {
        this.c = eVar;
    }

    @Override // net.gree.gamelib.payment.internal.a.h
    public void a(g gVar, final PaymentListener<Void> paymentListener) {
        final ArrayList arrayList = new ArrayList();
        arrayList.add(gVar);
        this.c.a(new e.InterfaceC0073e() { // from class: net.gree.gamelib.payment.internal.a.c.3
            @Override // net.gree.gamelib.payment.internal.a.e.InterfaceC0073e
            public void a(f fVar) {
                if (c.this.a(fVar, paymentListener)) {
                    return;
                }
                try {
                    c.this.c.a(arrayList, new e.c() { // from class: net.gree.gamelib.payment.internal.a.c.3.1
                        @Override // net.gree.gamelib.payment.internal.a.e.c
                        public void a(List<g> list, List<f> list2) {
                            for (f fVar2 : list2) {
                                if (c.this.a(fVar2, paymentListener)) {
                                    return;
                                }
                                if (paymentListener != null) {
                                    paymentListener.onSuccess(null);
                                }
                            }
                        }
                    });
                } catch (IllegalStateException unused) {
                    paymentListener.onError(17219, "The process is already in progress");
                } catch (RuntimeException e) {
                    PaymentListener paymentListener2 = paymentListener;
                    if (paymentListener2 == null) {
                        return;
                    }
                    paymentListener2.onError(17220, e.getMessage());
                }
            }
        });
    }

    @Override // net.gree.gamelib.payment.internal.a.h
    public boolean a(int i, int i2, Intent intent) {
        try {
            return this.c.a(i, i2, intent);
        } catch (RuntimeException unused) {
            return false;
        }
    }

    public boolean a(f fVar, PaymentListener<?> paymentListener) {
        String b2;
        int i;
        if (fVar.c()) {
            return false;
        }
        if (paymentListener == null) {
            return true;
        }
        if (fVar.d()) {
            i = PaymentError.ERROR_CODE_SUBMIT_CANCELED;
            b2 = PaymentError.ERROR_MESSAGE_SUBMIT_CANCELED;
        } else if (fVar.e()) {
            i = PaymentError.ERROR_CODE_PAYMENT_SERVICE_UNAVAILABLE;
            b2 = PaymentError.ERROR_MESSAGE_PAYMENT_SERVICE_UNAVAILABLE;
        } else {
            b2 = fVar.b();
            i = 17220;
        }
        paymentListener.onError(i, b2);
        return true;
    }

    @Override // net.gree.gamelib.payment.internal.a.h
    public void b() {
        this.c.a();
    }

    @Override // net.gree.gamelib.payment.internal.a.h
    public boolean d() {
        return false;
    }
}
