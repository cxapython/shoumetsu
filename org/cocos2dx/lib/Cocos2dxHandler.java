package org.cocos2dx.lib;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public class Cocos2dxHandler extends Handler {
    public static final int HANDLER_SHOW_DIALOG = 1;
    private WeakReference<Cocos2dxActivity> mActivity;

    /* loaded from: classes.dex */
    public static class DialogMessage {
        public String message;
        public String title;

        public DialogMessage(String str, String str2) {
            this.title = str;
            this.message = str2;
        }
    }

    public Cocos2dxHandler(Cocos2dxActivity cocos2dxActivity) {
        this.mActivity = new WeakReference<>(cocos2dxActivity);
    }

    private void showDialog(Message message) {
        DialogMessage dialogMessage = (DialogMessage) message.obj;
        new AlertDialog.Builder(this.mActivity.get()).setTitle(dialogMessage.title).setMessage(dialogMessage.message).setPositiveButton("Ok", new DialogInterface.OnClickListener() { // from class: org.cocos2dx.lib.Cocos2dxHandler.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        }).create().show();
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (message.what != 1) {
            return;
        }
        showDialog(message);
    }
}
