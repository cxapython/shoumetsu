package com.amazon.device.iap.internal.b.e;

import com.amazon.device.iap.internal.b.e;
import com.amazon.device.iap.internal.model.UserDataBuilder;
import com.amazon.device.iap.internal.model.UserDataResponseBuilder;
import com.amazon.device.iap.model.UserData;
import com.amazon.device.iap.model.UserDataResponse;
import com.amazon.venezia.command.SuccessResult;
import java.util.Map;
import net.gree.gamelib.payment.internal.a.g;

/* loaded from: classes.dex */
public final class d extends b {
    private static final String b = "d";

    public d(e eVar) {
        super(eVar, "1.0");
    }

    @Override // com.amazon.device.iap.internal.b.i
    protected boolean a(SuccessResult successResult) {
        String str = b;
        com.amazon.device.iap.internal.util.e.a(str, "onSuccessInternal: result = " + successResult);
        Map data = successResult.getData();
        String str2 = b;
        com.amazon.device.iap.internal.util.e.a(str2, "data: " + data);
        String str3 = (String) data.get(g.c);
        e b2 = b();
        if (com.amazon.device.iap.internal.util.d.a(str3)) {
            b2.d().a(new UserDataResponseBuilder().setRequestId(b2.c()).setRequestStatus(UserDataResponse.RequestStatus.FAILED).build());
            return false;
        }
        UserData build = new UserDataBuilder().setUserId(str3).setMarketplace(a).build();
        UserDataResponse build2 = new UserDataResponseBuilder().setRequestId(b2.c()).setRequestStatus(UserDataResponse.RequestStatus.SUCCESSFUL).setUserData(build).build();
        b2.d().a(g.c, build.getUserId());
        b2.d().a(build2);
        return true;
    }
}
