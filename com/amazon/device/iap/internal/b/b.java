package com.amazon.device.iap.internal.b;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import com.amazon.android.framework.context.ContextManager;
import com.amazon.android.framework.prompt.PromptContent;
import com.amazon.android.framework.prompt.SimplePrompt;
import com.amazon.android.framework.resource.Resource;

/* loaded from: classes.dex */
public class b extends SimplePrompt {
    private static final String a = "b";
    @Resource
    private ContextManager b;
    private final PromptContent c;

    public b(PromptContent promptContent) {
        super(promptContent);
        this.c = promptContent;
    }

    protected void doAction() {
        com.amazon.device.iap.internal.util.e.a(a, "doAction");
        if ("Amazon Appstore required".equalsIgnoreCase(this.c.getTitle()) || "Amazon Appstore Update Required".equalsIgnoreCase(this.c.getTitle())) {
            try {
                Activity visible = this.b.getVisible();
                if (visible == null) {
                    visible = this.b.getRoot();
                }
                visible.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://www.amazon.com/gp/mas/get-appstore/android/ref=mas_mx_mba_iap_dl")));
            } catch (Exception e) {
                String str = a;
                com.amazon.device.iap.internal.util.e.b(str, "Exception in PurchaseItemCommandTask.OnSuccess: " + e);
            }
        }
    }

    protected long getExpirationDurationInSeconds() {
        return 31536000L;
    }

    public String toString() {
        return a;
    }
}
