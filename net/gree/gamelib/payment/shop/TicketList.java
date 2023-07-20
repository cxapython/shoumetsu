package net.gree.gamelib.payment.shop;

import net.gree.gamelib.payment.PaymentListener;
import net.gree.gamelib.payment.internal.b.b;
import org.json.JSONArray;

/* loaded from: classes.dex */
public class TicketList extends net.gree.gamelib.payment.internal.b.a {
    private static final String a = "TicketList";
    protected Ticket[] mTickets;

    /* loaded from: classes.dex */
    protected static class ResponseAdapter extends b<TicketList> {
        public ResponseAdapter(PaymentListener<TicketList> paymentListener) {
            super(TicketList.a, paymentListener);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // net.gree.gamelib.payment.internal.b.b
        /* renamed from: toPaymentResponse  reason: collision with other method in class */
        public TicketList mo54toPaymentResponse(String str) {
            return new TicketList(str);
        }
    }

    protected TicketList(String str) {
        super(str);
        JSONArray b = b();
        int length = b.length();
        this.mTickets = new Ticket[length];
        for (int i = 0; i < length; i++) {
            this.mTickets[i] = new Ticket(b.getJSONObject(i));
        }
    }

    private JSONArray b() {
        return this.mJson.getJSONArray("entry");
    }

    public Ticket[] getTickets() {
        return this.mTickets;
    }
}
