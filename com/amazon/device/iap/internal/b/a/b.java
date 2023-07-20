package com.amazon.device.iap.internal.b.a;

import com.amazon.device.iap.internal.b.e;
import com.amazon.device.iap.internal.model.PurchaseResponseBuilder;
import com.amazon.device.iap.internal.model.UserDataBuilder;
import com.amazon.device.iap.model.ProductType;
import com.amazon.device.iap.model.PurchaseResponse;
import com.amazon.device.iap.model.Receipt;
import com.amazon.venezia.command.SuccessResult;
import java.util.Map;
import net.gree.gamelib.payment.internal.a.g;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class b extends c {
    private static final String a = "b";

    public b(e eVar) {
        super(eVar, "1.0");
    }

    private void a(String str, String str2, String str3) {
        if (str == null || str2 == null || str3 == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str3);
            if (PurchaseResponse.RequestStatus.safeValueOf(jSONObject.getString("orderStatus")) != PurchaseResponse.RequestStatus.SUCCESSFUL) {
                return;
            }
            com.amazon.device.iap.internal.c.a.a().a(str, str2, com.amazon.device.iap.internal.util.a.a(jSONObject, str2, str).getReceiptId(), str3);
        } catch (Throwable th) {
            String str4 = a;
            com.amazon.device.iap.internal.util.e.b(str4, "Error in savePendingReceipt: " + th);
        }
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
        if (str2 == null || !com.amazon.device.iap.internal.c.b.a().a(str2)) {
            b().d().b();
            return true;
        }
        if (!com.amazon.device.iap.internal.util.d.a(str5)) {
            Receipt receipt = null;
            JSONObject jSONObject = new JSONObject(str5);
            PurchaseResponse.RequestStatus safeValueOf = PurchaseResponse.RequestStatus.safeValueOf(jSONObject.getString("orderStatus"));
            if (safeValueOf == PurchaseResponse.RequestStatus.SUCCESSFUL) {
                try {
                    receipt = com.amazon.device.iap.internal.util.a.a(jSONObject, str3, str2);
                    if (ProductType.CONSUMABLE == receipt.getProductType()) {
                        a(str2, str3, str5);
                    }
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
