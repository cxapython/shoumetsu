package net.gree.gamelib.payment.shop.cocos2dx;

import net.gree.gamelib.payment.PaymentListener;
import net.gree.gamelib.payment.shop.Product;
import net.gree.gamelib.payment.shop.ProductList;
import org.cocos2dx.lib.Cocos2dxHelper;

/* loaded from: classes.dex */
public class QueryProductListListener implements PaymentListener<ProductList> {
    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeOnFailure(int i, String str);

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeOnSuccess(int i, Product[] productArr);

    @Override // net.gree.gamelib.core.CallbackListener
    public void onError(final int i, final String str) {
        Cocos2dxHelper.runOnGLThread(new Runnable() { // from class: net.gree.gamelib.payment.shop.cocos2dx.QueryProductListListener.2
            @Override // java.lang.Runnable
            public void run() {
                QueryProductListListener.this.nativeOnFailure(i, str);
            }
        });
    }

    @Override // net.gree.gamelib.core.CallbackListener
    public void onSuccess(final ProductList productList) {
        Cocos2dxHelper.runOnGLThread(new Runnable() { // from class: net.gree.gamelib.payment.shop.cocos2dx.QueryProductListListener.1
            @Override // java.lang.Runnable
            public void run() {
                QueryProductListListener.this.nativeOnSuccess(productList.getWelcome(), productList.getProducts());
            }
        });
    }
}
