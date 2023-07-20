package com.amazon.device.iap.internal.b.c;

import com.amazon.device.iap.internal.b.e;
import com.amazon.device.iap.internal.model.ProductBuilder;
import com.amazon.device.iap.internal.model.ProductDataResponseBuilder;
import com.amazon.device.iap.model.Product;
import com.amazon.device.iap.model.ProductDataResponse;
import com.amazon.device.iap.model.ProductType;
import com.amazon.venezia.command.SuccessResult;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class b extends c {
    private static final String b = "b";

    public b(e eVar, Set<String> set) {
        super(eVar, "1.0", set);
    }

    private Product a(String str, Map map) {
        String str2 = (String) map.get(str);
        try {
            JSONObject jSONObject = new JSONObject(str2);
            ProductType valueOf = ProductType.valueOf(jSONObject.getString("itemType").toUpperCase());
            String string = jSONObject.getString("description");
            String optString = jSONObject.optString("price");
            String string2 = jSONObject.getString(net.gree.gamelib.payment.internal.a.e.N);
            String string3 = jSONObject.getString("iconUrl");
            return new ProductBuilder().setSku(str).setProductType(valueOf).setDescription(string).setPrice(optString).setSmallIconUrl(string3).setTitle(string2).setCoinsRewardAmount(jSONObject.optInt("coinsRewardAmount", 0)).build();
        } catch (JSONException unused) {
            throw new IllegalArgumentException("error in parsing json string" + str2);
        }
    }

    @Override // com.amazon.device.iap.internal.b.i
    protected boolean a(SuccessResult successResult) {
        Map data = successResult.getData();
        String str = b;
        com.amazon.device.iap.internal.util.e.a(str, "data: " + data);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        HashMap hashMap = new HashMap();
        for (String str2 : this.a) {
            if (!data.containsKey(str2)) {
                linkedHashSet.add(str2);
            } else {
                try {
                    hashMap.put(str2, a(str2, data));
                } catch (IllegalArgumentException e) {
                    linkedHashSet.add(str2);
                    String str3 = b;
                    com.amazon.device.iap.internal.util.e.b(str3, "Error parsing JSON for SKU " + str2 + ": " + e.getMessage());
                }
            }
        }
        e b2 = b();
        b2.d().a(new ProductDataResponseBuilder().setRequestId(b2.c()).setRequestStatus(ProductDataResponse.RequestStatus.SUCCESSFUL).setUnavailableSkus(linkedHashSet).setProductData(hashMap).build());
        return true;
    }
}
