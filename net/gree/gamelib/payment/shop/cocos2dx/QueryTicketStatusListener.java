package net.gree.gamelib.payment.shop.cocos2dx;

import net.gree.gamelib.payment.PaymentListener;
import net.gree.gamelib.payment.shop.Ticket;
import net.gree.gamelib.payment.shop.TicketList;
import org.cocos2dx.lib.Cocos2dxHelper;

/* loaded from: classes.dex */
public class QueryTicketStatusListener implements PaymentListener<TicketList> {
    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeOnFailure(int i, String str);

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeOnSuccess(Ticket[] ticketArr);

    @Override // net.gree.gamelib.core.CallbackListener
    public void onError(final int i, final String str) {
        Cocos2dxHelper.runOnGLThread(new Runnable() { // from class: net.gree.gamelib.payment.shop.cocos2dx.QueryTicketStatusListener.2
            @Override // java.lang.Runnable
            public void run() {
                QueryTicketStatusListener.this.nativeOnFailure(i, str);
            }
        });
    }

    @Override // net.gree.gamelib.core.CallbackListener
    public void onSuccess(final TicketList ticketList) {
        Cocos2dxHelper.runOnGLThread(new Runnable() { // from class: net.gree.gamelib.payment.shop.cocos2dx.QueryTicketStatusListener.1
            @Override // java.lang.Runnable
            public void run() {
                QueryTicketStatusListener.this.nativeOnSuccess(ticketList.getTickets());
            }
        });
    }
}
