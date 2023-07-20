package com.amazon.device.iap.internal.b.a;

import com.amazon.device.iap.internal.b.e;
import com.amazon.device.iap.internal.b.i;
import com.amazon.device.iap.internal.model.PurchaseResponseBuilder;
import com.amazon.device.iap.internal.model.UserDataBuilder;
import com.amazon.device.iap.model.PurchaseResponse;

/* loaded from: classes.dex */
abstract class c extends i {
    /* JADX INFO: Access modifiers changed from: package-private */
    public c(e eVar, String str) {
        super(eVar, "purchase_response", str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(String str, String str2, String str3, PurchaseResponse.RequestStatus requestStatus) {
        e b = b();
        b.d().a(new PurchaseResponseBuilder().setRequestId(b.c()).setRequestStatus(requestStatus).setUserData(new UserDataBuilder().setUserId(str).setMarketplace(str2).build()).setReceipt(null).build());
    }
}
