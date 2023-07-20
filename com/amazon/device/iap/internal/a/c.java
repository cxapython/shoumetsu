package com.amazon.device.iap.internal.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import com.amazon.device.iap.PurchasingListener;
import com.amazon.device.iap.PurchasingService;
import com.amazon.device.iap.internal.model.ProductBuilder;
import com.amazon.device.iap.internal.model.ProductDataResponseBuilder;
import com.amazon.device.iap.internal.model.PurchaseResponseBuilder;
import com.amazon.device.iap.internal.model.PurchaseUpdatesResponseBuilder;
import com.amazon.device.iap.internal.model.ReceiptBuilder;
import com.amazon.device.iap.internal.model.UserDataBuilder;
import com.amazon.device.iap.internal.model.UserDataResponseBuilder;
import com.amazon.device.iap.model.FulfillmentResult;
import com.amazon.device.iap.model.Product;
import com.amazon.device.iap.model.ProductDataResponse;
import com.amazon.device.iap.model.ProductType;
import com.amazon.device.iap.model.PurchaseResponse;
import com.amazon.device.iap.model.PurchaseUpdatesResponse;
import com.amazon.device.iap.model.Receipt;
import com.amazon.device.iap.model.RequestId;
import com.amazon.device.iap.model.UserData;
import com.amazon.device.iap.model.UserDataResponse;
import com.google.android.gms.drive.DriveFile;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Currency;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import net.gree.gamelib.payment.internal.a.e;
import net.gree.gamelib.payment.internal.a.g;
import net.gree.gamelib.payment.internal.f;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class c implements com.amazon.device.iap.internal.c {
    private static final String a = "c";

    private Intent a(String str) {
        Intent intent = new Intent(str);
        intent.setComponent(new ComponentName("com.amazon.sdktestclient", "com.amazon.sdktestclient.command.CommandBroker"));
        return intent;
    }

    private Product a(String str, JSONObject jSONObject) {
        ProductType valueOf = ProductType.valueOf(jSONObject.optString("itemType"));
        JSONObject jSONObject2 = jSONObject.getJSONObject("priceJson");
        Currency currency = Currency.getInstance(jSONObject2.optString("currency"));
        String str2 = currency.getSymbol() + jSONObject2.optString("value");
        String optString = jSONObject.optString(e.N);
        String optString2 = jSONObject.optString("description");
        return new ProductBuilder().setSku(str).setProductType(valueOf).setDescription(optString2).setPrice(str2).setSmallIconUrl(jSONObject.optString("smallIconUrl")).setTitle(optString).setCoinsRewardAmount(jSONObject.optInt("coinsRewardAmount", 0)).build();
    }

    private Receipt a(JSONObject jSONObject) {
        String optString = jSONObject.optString("receiptId");
        String optString2 = jSONObject.optString("sku");
        ProductType valueOf = ProductType.valueOf(jSONObject.optString("itemType"));
        Date parse = b.a.parse(jSONObject.optString("purchaseDate"));
        String optString3 = jSONObject.optString("cancelDate");
        return new ReceiptBuilder().setReceiptId(optString).setSku(optString2).setProductType(valueOf).setPurchaseDate(parse).setCancelDate((optString3 == null || optString3.length() == 0) ? null : b.a.parse(optString3)).build();
    }

    private void a(Intent intent) {
        PurchaseUpdatesResponse b = b(intent);
        if (b.getRequestStatus() == PurchaseUpdatesResponse.RequestStatus.SUCCESSFUL) {
            String optString = new JSONObject(intent.getStringExtra("purchaseUpdatesOutput")).optString(f.a);
            String str = a;
            Log.i(str, "Offset for PurchaseUpdatesResponse:" + optString);
            com.amazon.device.iap.internal.util.b.a(b.getUserData().getUserId(), optString);
        }
        a(b);
    }

    private void a(String str, String str2, boolean z) {
        try {
            Context b = com.amazon.device.iap.internal.d.d().b();
            String a2 = com.amazon.device.iap.internal.util.b.a(str2);
            String str3 = a;
            Log.i(str3, "send PurchaseUpdates with user id:" + str2 + ";reset flag:" + z + ", local cursor:" + a2 + ", parsed from old requestId:" + str);
            Bundle bundle = new Bundle();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(g.d, str.toString());
            if (z) {
                a2 = null;
            }
            jSONObject.put(f.a, a2);
            jSONObject.put("sdkVersion", PurchasingService.SDK_VERSION);
            jSONObject.put("packageName", b.getPackageName());
            bundle.putString("purchaseUpdatesInput", jSONObject.toString());
            Intent a3 = a("com.amazon.testclient.iap.purchaseUpdates");
            a3.addFlags(DriveFile.MODE_READ_ONLY);
            a3.putExtras(bundle);
            b.startService(a3);
        } catch (JSONException unused) {
            com.amazon.device.iap.internal.util.e.b(a, "Error in sendPurchaseUpdatesRequest.");
        }
    }

    private void a(String str, boolean z, boolean z2) {
        try {
            Context b = com.amazon.device.iap.internal.d.d().b();
            Bundle bundle = new Bundle();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(g.d, str);
            jSONObject.put("packageName", b.getPackageName());
            jSONObject.put("sdkVersion", PurchasingService.SDK_VERSION);
            jSONObject.put("isPurchaseUpdates", z);
            jSONObject.put("reset", z2);
            bundle.putString("userInput", jSONObject.toString());
            Intent a2 = a("com.amazon.testclient.iap.appUserId");
            a2.addFlags(DriveFile.MODE_READ_ONLY);
            a2.putExtras(bundle);
            b.startService(a2);
        } catch (JSONException unused) {
            com.amazon.device.iap.internal.util.e.b(a, "Error in sendGetUserDataRequest.");
        }
    }

    private PurchaseUpdatesResponse b(Intent intent) {
        Exception e;
        RequestId requestId;
        UserData userData;
        boolean z;
        PurchaseUpdatesResponse.RequestStatus requestStatus = PurchaseUpdatesResponse.RequestStatus.FAILED;
        ArrayList arrayList = null;
        try {
            JSONObject jSONObject = new JSONObject(intent.getStringExtra("purchaseUpdatesOutput"));
            requestId = RequestId.fromString(jSONObject.optString(g.d));
            try {
                requestStatus = PurchaseUpdatesResponse.RequestStatus.valueOf(jSONObject.optString("status"));
                z = jSONObject.optBoolean("isMore");
                try {
                    userData = new UserDataBuilder().setUserId(jSONObject.optString(g.c)).setMarketplace(jSONObject.optString("marketplace")).build();
                    try {
                        if (requestStatus == PurchaseUpdatesResponse.RequestStatus.SUCCESSFUL) {
                            ArrayList arrayList2 = new ArrayList();
                            try {
                                JSONArray optJSONArray = jSONObject.optJSONArray("receipts");
                                if (optJSONArray != null) {
                                    for (int i = 0; i < optJSONArray.length(); i++) {
                                        JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                                        try {
                                            arrayList2.add(a(optJSONObject));
                                        } catch (Exception unused) {
                                            Log.e(a, "Failed to parse receipt from json:" + optJSONObject);
                                        }
                                    }
                                }
                                arrayList = arrayList2;
                            } catch (Exception e2) {
                                e = e2;
                                arrayList = arrayList2;
                                Log.e(a, "Error parsing purchase updates output", e);
                                return new PurchaseUpdatesResponseBuilder().setRequestId(requestId).setRequestStatus(requestStatus).setUserData(userData).setReceipts(arrayList).setHasMore(z).build();
                            }
                        }
                    } catch (Exception e3) {
                        e = e3;
                    }
                } catch (Exception e4) {
                    e = e4;
                    userData = null;
                }
            } catch (Exception e5) {
                userData = null;
                e = e5;
                z = false;
                Log.e(a, "Error parsing purchase updates output", e);
                return new PurchaseUpdatesResponseBuilder().setRequestId(requestId).setRequestStatus(requestStatus).setUserData(userData).setReceipts(arrayList).setHasMore(z).build();
            }
        } catch (Exception e6) {
            e = e6;
            requestId = null;
            userData = null;
        }
        return new PurchaseUpdatesResponseBuilder().setRequestId(requestId).setRequestStatus(requestStatus).setUserData(userData).setReceipts(arrayList).setHasMore(z).build();
    }

    private void c(Intent intent) {
        a(d(intent));
    }

    private ProductDataResponse d(Intent intent) {
        LinkedHashSet linkedHashSet;
        HashMap hashMap;
        Exception e;
        RequestId requestId;
        JSONObject jSONObject;
        ProductDataResponse.RequestStatus requestStatus = ProductDataResponse.RequestStatus.FAILED;
        LinkedHashSet linkedHashSet2 = null;
        try {
            jSONObject = new JSONObject(intent.getStringExtra("itemDataOutput"));
            requestId = RequestId.fromString(jSONObject.optString(g.d));
            try {
                requestStatus = ProductDataResponse.RequestStatus.valueOf(jSONObject.optString("status"));
            } catch (Exception e2) {
                e = e2;
                linkedHashSet = null;
                hashMap = null;
            }
        } catch (Exception e3) {
            linkedHashSet = null;
            hashMap = null;
            e = e3;
            requestId = null;
        }
        if (requestStatus == ProductDataResponse.RequestStatus.FAILED) {
            hashMap = null;
            return new ProductDataResponseBuilder().setRequestId(requestId).setRequestStatus(requestStatus).setProductData(hashMap).setUnavailableSkus(linkedHashSet2).build();
        }
        linkedHashSet = new LinkedHashSet();
        try {
            hashMap = new HashMap();
            try {
                JSONArray optJSONArray = jSONObject.optJSONArray("unavailableSkus");
                if (optJSONArray != null) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        linkedHashSet.add(optJSONArray.getString(i));
                    }
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("items");
                if (optJSONObject != null) {
                    Iterator<String> keys = optJSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        hashMap.put(next, a(next, optJSONObject.optJSONObject(next)));
                    }
                }
            } catch (Exception e4) {
                e = e4;
                Log.e(a, "Error parsing item data output", e);
                linkedHashSet2 = linkedHashSet;
                return new ProductDataResponseBuilder().setRequestId(requestId).setRequestStatus(requestStatus).setProductData(hashMap).setUnavailableSkus(linkedHashSet2).build();
            }
        } catch (Exception e5) {
            e = e5;
            hashMap = null;
            e = e;
            Log.e(a, "Error parsing item data output", e);
            linkedHashSet2 = linkedHashSet;
            return new ProductDataResponseBuilder().setRequestId(requestId).setRequestStatus(requestStatus).setProductData(hashMap).setUnavailableSkus(linkedHashSet2).build();
        }
        linkedHashSet2 = linkedHashSet;
        return new ProductDataResponseBuilder().setRequestId(requestId).setRequestStatus(requestStatus).setProductData(hashMap).setUnavailableSkus(linkedHashSet2).build();
    }

    private void e(Intent intent) {
        JSONObject jSONObject;
        UserDataResponse f = f(intent);
        RequestId requestId = f.getRequestId();
        String stringExtra = intent.getStringExtra("userInput");
        try {
            jSONObject = new JSONObject(stringExtra);
        } catch (JSONException e) {
            String str = a;
            Log.e(str, "Unable to parse request data: " + stringExtra, e);
            jSONObject = null;
        }
        if (requestId == null || jSONObject == null) {
            a(f);
        } else if (!jSONObject.optBoolean("isPurchaseUpdates", false)) {
            a(f);
        } else if (f.getUserData() == null || com.amazon.device.iap.internal.util.d.a(f.getUserData().getUserId())) {
            String str2 = a;
            Log.e(str2, "No Userid found in userDataResponse" + f);
            a(new PurchaseUpdatesResponseBuilder().setRequestId(requestId).setRequestStatus(PurchaseUpdatesResponse.RequestStatus.FAILED).setUserData(f.getUserData()).setReceipts(new ArrayList()).setHasMore(false).build());
        } else {
            String str3 = a;
            Log.i(str3, "sendGetPurchaseUpdates with user id" + f.getUserData().getUserId());
            a(requestId.toString(), f.getUserData().getUserId(), jSONObject.optBoolean("reset", true));
        }
    }

    private UserDataResponse f(Intent intent) {
        RequestId requestId;
        UserDataResponse.RequestStatus requestStatus = UserDataResponse.RequestStatus.FAILED;
        UserData userData = null;
        try {
            JSONObject jSONObject = new JSONObject(intent.getStringExtra("userOutput"));
            requestId = RequestId.fromString(jSONObject.optString(g.d));
            try {
                requestStatus = UserDataResponse.RequestStatus.valueOf(jSONObject.optString("status"));
                if (requestStatus == UserDataResponse.RequestStatus.SUCCESSFUL) {
                    userData = new UserDataBuilder().setUserId(jSONObject.optString(g.c)).setMarketplace(jSONObject.optString("marketplace")).build();
                }
            } catch (Exception e) {
                e = e;
                Log.e(a, "Error parsing userid output", e);
                return new UserDataResponseBuilder().setRequestId(requestId).setRequestStatus(requestStatus).setUserData(userData).build();
            }
        } catch (Exception e2) {
            e = e2;
            requestId = null;
        }
        return new UserDataResponseBuilder().setRequestId(requestId).setRequestStatus(requestStatus).setUserData(userData).build();
    }

    private void g(Intent intent) {
        a(h(intent));
    }

    private PurchaseResponse h(Intent intent) {
        RequestId requestId;
        UserData userData;
        PurchaseResponse.RequestStatus requestStatus = PurchaseResponse.RequestStatus.FAILED;
        Receipt receipt = null;
        try {
            JSONObject jSONObject = new JSONObject(intent.getStringExtra("purchaseOutput"));
            requestId = RequestId.fromString(jSONObject.optString(g.d));
            try {
                userData = new UserDataBuilder().setUserId(jSONObject.optString(g.c)).setMarketplace(jSONObject.optString("marketplace")).build();
                try {
                    requestStatus = PurchaseResponse.RequestStatus.safeValueOf(jSONObject.optString("purchaseStatus"));
                    JSONObject optJSONObject = jSONObject.optJSONObject(g.e);
                    if (optJSONObject != null) {
                        receipt = a(optJSONObject);
                    }
                } catch (Exception e) {
                    e = e;
                    Log.e(a, "Error parsing purchase output", e);
                    return new PurchaseResponseBuilder().setRequestId(requestId).setRequestStatus(requestStatus).setUserData(userData).setReceipt(receipt).build();
                }
            } catch (Exception e2) {
                e = e2;
                userData = null;
            }
        } catch (Exception e3) {
            e = e3;
            requestId = null;
            userData = null;
        }
        return new PurchaseResponseBuilder().setRequestId(requestId).setRequestStatus(requestStatus).setUserData(userData).setReceipt(receipt).build();
    }

    @Override // com.amazon.device.iap.internal.c
    public void a(Context context, Intent intent) {
        com.amazon.device.iap.internal.util.e.a(a, "handleResponse");
        intent.setComponent(new ComponentName("com.amazon.sdktestclient", "com.amazon.sdktestclient.command.CommandBroker"));
        try {
            String string = intent.getExtras().getString("responseType");
            if (string.equalsIgnoreCase("com.amazon.testclient.iap.purchase")) {
                g(intent);
            } else if (string.equalsIgnoreCase("com.amazon.testclient.iap.appUserId")) {
                e(intent);
            } else if (string.equalsIgnoreCase("com.amazon.testclient.iap.itemData")) {
                c(intent);
            } else if (string.equalsIgnoreCase("com.amazon.testclient.iap.purchaseUpdates")) {
                a(intent);
            }
        } catch (Exception e) {
            Log.e(a, "Error handling response.", e);
        }
    }

    @Override // com.amazon.device.iap.internal.c
    public void a(RequestId requestId) {
        com.amazon.device.iap.internal.util.e.a(a, "sendGetUserDataRequest");
        a(requestId.toString(), false, false);
    }

    @Override // com.amazon.device.iap.internal.c
    public void a(RequestId requestId, String str) {
        com.amazon.device.iap.internal.util.e.a(a, "sendPurchaseRequest");
        try {
            Context b = com.amazon.device.iap.internal.d.d().b();
            Bundle bundle = new Bundle();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("sku", str);
            jSONObject.put(g.d, requestId.toString());
            jSONObject.put("packageName", b.getPackageName());
            jSONObject.put("sdkVersion", PurchasingService.SDK_VERSION);
            bundle.putString("purchaseInput", jSONObject.toString());
            Intent a2 = a("com.amazon.testclient.iap.purchase");
            a2.addFlags(DriveFile.MODE_READ_ONLY);
            a2.putExtras(bundle);
            b.startService(a2);
        } catch (JSONException unused) {
            com.amazon.device.iap.internal.util.e.b(a, "Error in sendPurchaseRequest.");
        }
    }

    @Override // com.amazon.device.iap.internal.c
    public void a(RequestId requestId, String str, FulfillmentResult fulfillmentResult) {
        com.amazon.device.iap.internal.util.e.a(a, "sendNotifyPurchaseFulfilled");
        try {
            Context b = com.amazon.device.iap.internal.d.d().b();
            Bundle bundle = new Bundle();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(g.d, requestId.toString());
            jSONObject.put("packageName", b.getPackageName());
            jSONObject.put("receiptId", str);
            jSONObject.put("fulfillmentResult", fulfillmentResult);
            jSONObject.put("sdkVersion", PurchasingService.SDK_VERSION);
            bundle.putString("purchaseFulfilledInput", jSONObject.toString());
            Intent a2 = a("com.amazon.testclient.iap.purchaseFulfilled");
            a2.addFlags(DriveFile.MODE_READ_ONLY);
            a2.putExtras(bundle);
            b.startService(a2);
        } catch (JSONException unused) {
            com.amazon.device.iap.internal.util.e.b(a, "Error in sendNotifyPurchaseFulfilled.");
        }
    }

    @Override // com.amazon.device.iap.internal.c
    public void a(RequestId requestId, Set<String> set) {
        com.amazon.device.iap.internal.util.e.a(a, "sendItemDataRequest");
        try {
            Context b = com.amazon.device.iap.internal.d.d().b();
            Bundle bundle = new Bundle();
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray((Collection) set);
            jSONObject.put(g.d, requestId.toString());
            jSONObject.put("packageName", b.getPackageName());
            jSONObject.put("skus", jSONArray);
            jSONObject.put("sdkVersion", PurchasingService.SDK_VERSION);
            bundle.putString("itemDataInput", jSONObject.toString());
            Intent a2 = a("com.amazon.testclient.iap.itemData");
            a2.addFlags(DriveFile.MODE_READ_ONLY);
            a2.putExtras(bundle);
            b.startService(a2);
        } catch (JSONException unused) {
            com.amazon.device.iap.internal.util.e.b(a, "Error in sendItemDataRequest.");
        }
    }

    @Override // com.amazon.device.iap.internal.c
    public void a(RequestId requestId, boolean z) {
        if (requestId == null) {
            requestId = new RequestId();
        }
        String str = a;
        com.amazon.device.iap.internal.util.e.a(str, "sendPurchaseUpdatesRequest/sendGetUserData first:" + requestId);
        a(requestId.toString(), true, z);
    }

    protected void a(final Object obj) {
        com.amazon.device.iap.internal.util.d.a(obj, "response");
        Context b = com.amazon.device.iap.internal.d.d().b();
        final PurchasingListener a2 = com.amazon.device.iap.internal.d.d().a();
        if (b != null && a2 != null) {
            new Handler(b.getMainLooper()).post(new Runnable() { // from class: com.amazon.device.iap.internal.a.c.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (obj instanceof ProductDataResponse) {
                            a2.onProductDataResponse((ProductDataResponse) obj);
                        } else if (obj instanceof UserDataResponse) {
                            a2.onUserDataResponse((UserDataResponse) obj);
                        } else if (obj instanceof PurchaseUpdatesResponse) {
                            a2.onPurchaseUpdatesResponse((PurchaseUpdatesResponse) obj);
                        } else if (obj instanceof PurchaseResponse) {
                            a2.onPurchaseResponse((PurchaseResponse) obj);
                        } else {
                            String str = c.a;
                            com.amazon.device.iap.internal.util.e.b(str, "Unknown response type:" + obj.getClass().getName());
                        }
                    } catch (Exception e) {
                        String str2 = c.a;
                        com.amazon.device.iap.internal.util.e.b(str2, "Error in sendResponse: " + e);
                    }
                }
            });
            return;
        }
        String str = a;
        com.amazon.device.iap.internal.util.e.a(str, "PurchasingListener is not set. Dropping response: " + obj);
    }
}
