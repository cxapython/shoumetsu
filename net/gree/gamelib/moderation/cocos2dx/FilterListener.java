package net.gree.gamelib.moderation.cocos2dx;

import net.gree.gamelib.moderation.FilteringResultListener;
import org.cocos2dx.lib.Cocos2dxHelper;

/* loaded from: classes.dex */
public class FilterListener implements FilteringResultListener {
    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeOnCompleted(int i);

    @Override // net.gree.gamelib.moderation.FilteringResultListener
    public void onCompleted(final int i) {
        Cocos2dxHelper.runOnGLThread(new Runnable() { // from class: net.gree.gamelib.moderation.cocos2dx.FilterListener.1
            @Override // java.lang.Runnable
            public void run() {
                FilterListener.this.nativeOnCompleted(i);
            }
        });
    }
}
