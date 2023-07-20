package com.amazon.device.iap.internal.b.a;

import com.amazon.device.iap.internal.b.e;
import com.amazon.device.iap.internal.model.PurchaseResponseBuilder;
import com.amazon.device.iap.internal.model.UserDataBuilder;
import com.amazon.device.iap.model.PurchaseResponse;
import com.amazon.device.iap.model.Receipt;
import com.amazon.venezia.command.SuccessResult;
import java.util.Map;
import net.gree.gamelib.payment.internal.a.g;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class a extends c {
    private static final String a = "a";

    public a(e eVar) {
        super(eVar, "2.0");
    }

    @Override // com.amazon.device.iap.internal.b.i
    protected boolean a(SuccessResult successResult) {
        Map data = successResult.getData();
        String str = a;
        com.amazon.device.iap.internal.util.e.a(str, "data: " + data);
        String str2 = (String) getCommandData().get(g.d);
        String str3 = (String) data.get(g.c);
        String str4 = (String) data.get("marketplace");
        String str5 = (String) data.get(g.e);
        if (!com.amazon.device.iap.internal.util.d.a(str5)) {
            Receipt receipt = null;
            JSONObject jSONObject = new JSONObject(str5);
            PurchaseResponse.RequestStatus safeValueOf = PurchaseResponse.RequestStatus.safeValueOf(jSONObject.getString("orderStatus"));
            if (safeValueOf == PurchaseResponse.RequestStatus.SUCCESSFUL) {
                try {
                    receipt = com.amazon.device.iap.internal.util.a.a(jSONObject, str3, str2);
                } catch (Throwable unused) {
                }
            }
            e b = b();
            b.d().a(new PurchaseResponseBuilder().setRequestId(b.c()).setRequestStatus(safeValueOf).setUserData(new UserDataBuilder().setUserId(str3).setMarketplace(str4).build()).setReceipt(receipt).build());
            return true;
        }
        a(str3, str4, str2, PurchaseResponse.RequestStatus.FAILED);
        return false;
    }
}
