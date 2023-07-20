package com.amazon.device.iap.internal.b;

import com.amazon.android.Kiwi;
import com.amazon.android.framework.exception.KiwiException;
import com.amazon.android.framework.prompt.PromptContent;
import com.amazon.android.framework.task.command.AbstractCommandTask;
import com.amazon.android.licensing.LicenseFailurePromptContentMapper;
import com.amazon.device.iap.PurchasingService;
import com.amazon.venezia.command.FailureResult;
import com.amazon.venezia.command.SuccessResult;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class i extends AbstractCommandTask {
    private static final String a = "i";
    private final e b;
    private final String c;
    private final String d;
    private final String e;
    private boolean h;
    private i i;
    private i j;
    private final LicenseFailurePromptContentMapper g = new LicenseFailurePromptContentMapper();
    private boolean k = false;
    private final Map<String, Object> f = new HashMap();

    public i(e eVar, String str, String str2) {
        this.b = eVar;
        this.c = eVar.c().toString();
        this.d = str;
        this.e = str2;
        this.f.put(net.gree.gamelib.payment.internal.a.g.d, this.c);
        this.f.put("sdkVersion", PurchasingService.SDK_VERSION);
        this.h = true;
        this.i = null;
        this.j = null;
    }

    private void a(PromptContent promptContent) {
        if (promptContent == null) {
            return;
        }
        Kiwi.getPromptManager().present(new b(promptContent));
    }

    public i a(boolean z) {
        this.k = z;
        return this;
    }

    public void a(i iVar) {
        this.i = iVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(String str, Object obj) {
        this.f.put(str, obj);
    }

    protected abstract boolean a(SuccessResult successResult);

    public void a_() {
        Kiwi.addCommandToCommandTaskPipeline(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public e b() {
        return this.b;
    }

    public void b(i iVar) {
        this.j = iVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(boolean z) {
        this.h = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String c() {
        return this.c;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Map<String, Object> getCommandData() {
        return this.f;
    }

    protected String getCommandName() {
        return this.d;
    }

    protected String getCommandVersion() {
        return this.e;
    }

    protected boolean isExecutionNeeded() {
        return true;
    }

    protected final void onException(KiwiException kiwiException) {
        i iVar;
        String str = a;
        com.amazon.device.iap.internal.util.e.a(str, "onException: exception = " + kiwiException.getMessage());
        if ("UNHANDLED_EXCEPTION".equals(kiwiException.getType()) && "2.0".equals(this.e) && (iVar = this.j) != null) {
            iVar.a(this.k);
            this.j.a_();
            return;
        }
        if (this.h) {
            a(this.g.map(kiwiException));
        }
        if (this.k) {
            return;
        }
        this.b.b();
    }

    protected final void onFailure(FailureResult failureResult) {
        i iVar;
        String str;
        String str2 = a;
        com.amazon.device.iap.internal.util.e.a(str2, "onFailure: result = " + failureResult);
        if (((failureResult == null || (str = (String) failureResult.getExtensionData().get("maxVersion")) == null || !str.equalsIgnoreCase("1.0")) ? false : true) && (iVar = this.j) != null) {
            iVar.a(this.k);
            this.j.a_();
            return;
        }
        if (this.h) {
            a(new PromptContent(failureResult.getDisplayableName(), failureResult.getDisplayableMessage(), failureResult.getButtonLabel(), failureResult.show()));
        }
        if (this.k) {
            return;
        }
        this.b.b();
    }

    protected final void onSuccess(SuccessResult successResult) {
        i iVar;
        String str = (String) successResult.getData().get("errorMessage");
        String str2 = a;
        com.amazon.device.iap.internal.util.e.a(str2, "onSuccess: result = " + successResult + ", errorMessage: " + str);
        if (com.amazon.device.iap.internal.util.d.a(str)) {
            boolean z = false;
            try {
                z = a(successResult);
            } catch (Exception e) {
                String str3 = a;
                com.amazon.device.iap.internal.util.e.b(str3, "Error calling onResult: " + e);
            }
            if (z && (iVar = this.i) != null) {
                iVar.a_();
                return;
            } else if (this.k) {
                return;
            } else {
                if (z) {
                    this.b.a();
                    return;
                }
            }
        } else if (this.k) {
            return;
        }
        this.b.b();
    }
}
