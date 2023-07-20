package net.gree.gamelib.payment.internal.b;

import net.gree.gamelib.core.http.ResponseAdapter;
import net.gree.gamelib.payment.PaymentListener;
import net.gree.gamelib.payment.internal.b.a;
import org.json.JSONObject;

/* loaded from: classes.dex */
public abstract class b<T extends a> extends ResponseAdapter<T> {
    public b(String str, PaymentListener<T> paymentListener) {
        super(str, paymentListener);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // net.gree.gamelib.core.http.ResponseAdapter
    /* renamed from: jsonObjectToResponseData  reason: collision with other method in class */
    public T mo48jsonObjectToResponseData(JSONObject jSONObject) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // net.gree.gamelib.core.http.ResponseAdapter
    /* renamed from: jsonStringToResponseData  reason: collision with other method in class */
    public T mo49jsonStringToResponseData(String str) {
        return mo54toPaymentResponse(str);
    }

    /* renamed from: toPaymentResponse */
    protected abstract T mo54toPaymentResponse(String str);
}
