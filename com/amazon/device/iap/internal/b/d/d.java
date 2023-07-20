package com.amazon.device.iap.internal.b.d;

import com.amazon.device.iap.internal.b.e;
import com.amazon.device.iap.internal.model.PurchaseUpdatesResponseBuilder;
import com.amazon.device.iap.internal.model.ReceiptBuilder;
import com.amazon.device.iap.internal.model.UserDataBuilder;
import com.amazon.device.iap.model.ProductType;
import com.amazon.device.iap.model.PurchaseUpdatesResponse;
import com.amazon.device.iap.model.Receipt;
import com.amazon.venezia.command.SuccessResult;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import net.gree.gamelib.payment.internal.a.g;
import org.json.JSONArray;
import org.json.JSONException;

/* loaded from: classes.dex */
public final class d extends b {
    private static final String b = "d";
    private static final Date c = new Date(0);

    public d(e eVar, boolean z) {
        super(eVar, "1.0", z);
    }

    @Override // com.amazon.device.iap.internal.b.i
    protected boolean a(SuccessResult successResult) {
        String str;
        StringBuilder sb;
        String message;
        Map data = successResult.getData();
        String str2 = b;
        com.amazon.device.iap.internal.util.e.a(str2, "data: " + data);
        String str3 = (String) data.get(g.c);
        String str4 = (String) data.get(g.d);
        String str5 = (String) data.get("marketplace");
        ArrayList arrayList = new ArrayList();
        JSONArray jSONArray = new JSONArray((String) data.get("receipts"));
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                Receipt a = com.amazon.device.iap.internal.util.a.a(jSONArray.getJSONObject(i), str3, null);
                arrayList.add(a);
                if (ProductType.ENTITLED == a.getProductType()) {
                    com.amazon.device.iap.internal.c.c.a().a(str3, a.getReceiptId(), a.getSku());
                }
            } catch (com.amazon.device.iap.internal.b.a e) {
                str = b;
                sb = new StringBuilder();
                sb.append("fail to parse receipt, requestId:");
                message = e.a();
                sb.append(message);
                com.amazon.device.iap.internal.util.e.b(str, sb.toString());
            } catch (com.amazon.device.iap.internal.b.d e2) {
                str = b;
                sb = new StringBuilder();
                sb.append("fail to verify receipt, requestId:");
                message = e2.a();
                sb.append(message);
                com.amazon.device.iap.internal.util.e.b(str, sb.toString());
            } catch (Throwable th) {
                str = b;
                sb = new StringBuilder();
                sb.append("fail to verify receipt, requestId:");
                message = th.getMessage();
                sb.append(message);
                com.amazon.device.iap.internal.util.e.b(str, sb.toString());
            }
        }
        JSONArray jSONArray2 = new JSONArray((String) data.get("revocations"));
        for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
            try {
                String string = jSONArray2.getString(i2);
                arrayList.add(new ReceiptBuilder().setSku(string).setProductType(ProductType.ENTITLED).setPurchaseDate(null).setCancelDate(c).setReceiptId(com.amazon.device.iap.internal.c.c.a().a(str3, string)).build());
            } catch (JSONException unused) {
                String str6 = b;
                com.amazon.device.iap.internal.util.e.b(str6, "fail to parse JSON[" + i2 + "] in \"" + jSONArray2 + "\"");
            }
        }
        boolean equalsIgnoreCase = "true".equalsIgnoreCase((String) data.get("hasMore"));
        e b2 = b();
        PurchaseUpdatesResponse build = new PurchaseUpdatesResponseBuilder().setRequestId(b2.c()).setRequestStatus(PurchaseUpdatesResponse.RequestStatus.SUCCESSFUL).setUserData(new UserDataBuilder().setUserId(str3).setMarketplace(str5).build()).setReceipts(arrayList).setHasMore(equalsIgnoreCase).build();
        build.getReceipts().addAll(com.amazon.device.iap.internal.c.a.a().b(build.getUserData().getUserId()));
        b2.d().a(build);
        b2.d().a("newCursor", (String) data.get("cursor"));
        return true;
    }
}
