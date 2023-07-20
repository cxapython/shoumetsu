package com.amazon.device.iap.internal.b.e;

import com.amazon.device.iap.internal.b.e;
import com.amazon.device.iap.internal.b.i;
import com.amazon.device.iap.internal.model.UserDataResponseBuilder;
import com.amazon.device.iap.model.RequestId;
import com.amazon.device.iap.model.UserDataResponse;

/* loaded from: classes.dex */
public final class a extends e {
    public a(RequestId requestId) {
        super(requestId);
        c cVar = new c(this);
        cVar.b(new d(this));
        a((i) cVar);
    }

    @Override // com.amazon.device.iap.internal.b.e
    public void a() {
        a((UserDataResponse) d().a());
    }

    @Override // com.amazon.device.iap.internal.b.e
    public void b() {
        UserDataResponse userDataResponse = (UserDataResponse) d().a();
        if (userDataResponse == null) {
            userDataResponse = new UserDataResponseBuilder().setRequestId(c()).setRequestStatus(UserDataResponse.RequestStatus.FAILED).build();
        }
        a(userDataResponse);
    }
}
