package com.amazon.device.iap.internal.b.d;

import com.amazon.device.iap.internal.b.e;
import com.amazon.device.iap.internal.model.PurchaseUpdatesResponseBuilder;
import com.amazon.device.iap.internal.model.UserDataBuilder;
import com.amazon.device.iap.model.PurchaseUpdatesResponse;
import com.amazon.device.iap.model.Receipt;
import com.amazon.venezia.command.SuccessResult;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import net.gree.gamelib.payment.internal.a.g;
import org.json.JSONArray;

/* loaded from: classes.dex */
public final class c extends b {
    private static final String b = "c";

    public c(e eVar, boolean z) {
        super(eVar, "2.0", z);
    }

    private List<Receipt> a(String str, String str2, String str3) {
        String str4;
        StringBuilder sb;
        String message;
        ArrayList arrayList = new ArrayList();
        JSONArray jSONArray = new JSONArray(str2);
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                arrayList.add(com.amazon.device.iap.internal.util.a.a(jSONArray.getJSONObject(i), str, str3));
            } catch (com.amazon.device.iap.internal.b.a e) {
                str4 = b;
                sb = new StringBuilder();
                sb.append("fail to parse receipt, requestId:");
                message = e.a();
                sb.append(message);
                com.amazon.device.iap.internal.util.e.b(str4, sb.toString());
            } catch (com.amazon.device.iap.internal.b.d e2) {
                str4 = b;
                sb = new StringBuilder();
                sb.append("fail to verify receipt, requestId:");
                message = e2.a();
                sb.append(message);
                com.amazon.device.iap.internal.util.e.b(str4, sb.toString());
            } catch (Throwable th) {
                str4 = b;
                sb = new StringBuilder();
                sb.append("fail to verify receipt, requestId:");
                message = th.getMessage();
                sb.append(message);
                com.amazon.device.iap.internal.util.e.b(str4, sb.toString());
            }
        }
        return arrayList;
    }

    @Override // com.amazon.device.iap.internal.b.i
    protected boolean a(SuccessResult successResult) {
        Map data = successResult.getData();
        String str = b;
        com.amazon.device.iap.internal.util.e.a(str, "data: " + data);
        String str2 = (String) data.get(g.c);
        List<Receipt> a = a(str2, (String) data.get("receipts"), (String) data.get(g.d));
        boolean booleanValue = Boolean.valueOf((String) data.get("hasMore")).booleanValue();
        e b2 = b();
        PurchaseUpdatesResponse build = new PurchaseUpdatesResponseBuilder().setRequestId(b2.c()).setRequestStatus(PurchaseUpdatesResponse.RequestStatus.SUCCESSFUL).setUserData(new UserDataBuilder().setUserId(str2).setMarketplace((String) data.get("marketplace")).build()).setReceipts(a).setHasMore(booleanValue).build();
        b2.d().a("newCursor", (String) data.get("cursor"));
        b2.d().a(build);
        return true;
    }
}
