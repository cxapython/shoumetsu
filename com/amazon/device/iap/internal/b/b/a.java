package com.amazon.device.iap.internal.b.b;

import android.app.Activity;
import android.content.Intent;
import com.amazon.android.framework.context.ContextManager;
import com.amazon.android.framework.resource.Resource;
import com.amazon.android.framework.task.Task;
import com.amazon.android.framework.task.TaskManager;
import com.amazon.android.framework.task.pipeline.TaskPipelineId;
import com.amazon.device.iap.internal.b.e;
import com.amazon.device.iap.internal.b.i;
import com.amazon.device.iap.internal.util.MetricsHelper;
import com.amazon.venezia.command.SuccessResult;
import java.util.Map;

/* loaded from: classes.dex */
abstract class a extends i {
    private static final String d = "a";
    @Resource
    protected TaskManager a;
    @Resource
    protected ContextManager b;
    protected final String c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(e eVar, String str, String str2) {
        super(eVar, "purchase_item", str);
        this.c = str2;
        a("sku", this.c);
    }

    @Override // com.amazon.device.iap.internal.b.i
    protected boolean a(SuccessResult successResult) {
        Map data = successResult.getData();
        String str = d;
        com.amazon.device.iap.internal.util.e.a(str, "data: " + data);
        if (!data.containsKey("purchaseItemIntent")) {
            com.amazon.device.iap.internal.util.e.b(d, "did not find intent");
            return false;
        }
        com.amazon.device.iap.internal.util.e.a(d, "found intent");
        final Intent intent = (Intent) data.remove("purchaseItemIntent");
        this.a.enqueueAtFront(TaskPipelineId.FOREGROUND, new Task() { // from class: com.amazon.device.iap.internal.b.b.a.1
            public void execute() {
                try {
                    Activity visible = a.this.b.getVisible();
                    if (visible == null) {
                        visible = a.this.b.getRoot();
                    }
                    String str2 = a.d;
                    com.amazon.device.iap.internal.util.e.a(str2, "About to fire intent with activity " + visible);
                    visible.startActivity(intent);
                } catch (Exception e) {
                    String c = a.this.c();
                    MetricsHelper.submitExceptionMetrics(c, a.d + ".onResult().execute()", e);
                    String str3 = a.d;
                    com.amazon.device.iap.internal.util.e.b(str3, "Exception when attempting to fire intent: " + e);
                }
            }
        });
        return true;
    }
}
