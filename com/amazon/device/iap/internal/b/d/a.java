package com.amazon.device.iap.internal.b.d;

import com.amazon.device.iap.internal.b.e;
import com.amazon.device.iap.internal.b.i;
import com.amazon.device.iap.internal.model.PurchaseUpdatesResponseBuilder;
import com.amazon.device.iap.model.PurchaseUpdatesResponse;
import com.amazon.device.iap.model.Receipt;
import com.amazon.device.iap.model.RequestId;
import java.util.HashSet;

/* loaded from: classes.dex */
public final class a extends e {
    public a(RequestId requestId, boolean z) {
        super(requestId);
        com.amazon.device.iap.internal.b.e.c cVar = new com.amazon.device.iap.internal.b.e.c(this);
        cVar.a(new c(this, z));
        com.amazon.device.iap.internal.b.e.d dVar = new com.amazon.device.iap.internal.b.e.d(this);
        dVar.a(new d(this, z));
        cVar.b(dVar);
        a((i) cVar);
    }

    @Override // com.amazon.device.iap.internal.b.e
    public void a() {
        i iVar;
        PurchaseUpdatesResponse purchaseUpdatesResponse = (PurchaseUpdatesResponse) d().a();
        if (purchaseUpdatesResponse.getReceipts() == null || purchaseUpdatesResponse.getReceipts().size() <= 0) {
            iVar = null;
        } else {
            HashSet hashSet = new HashSet();
            for (Receipt receipt : purchaseUpdatesResponse.getReceipts()) {
                if (!com.amazon.device.iap.internal.util.d.a(receipt.getReceiptId())) {
                    hashSet.add(receipt.getReceiptId());
                }
            }
            iVar = new com.amazon.device.iap.internal.b.g.a(this, hashSet, com.amazon.device.iap.internal.model.a.DELIVERED.toString());
        }
        a(purchaseUpdatesResponse, iVar);
    }

    @Override // com.amazon.device.iap.internal.b.e
    public void b() {
        Object a = d().a();
        a((a == null || !(a instanceof PurchaseUpdatesResponse)) ? new PurchaseUpdatesResponseBuilder().setRequestId(c()).setRequestStatus(PurchaseUpdatesResponse.RequestStatus.FAILED).build() : (PurchaseUpdatesResponse) a);
    }
}
