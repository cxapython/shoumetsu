package com.google.android.gms.drive;

import com.google.android.gms.drive.ExecutionOptions;

/* loaded from: classes.dex */
public final class zzp extends ExecutionOptions.Builder {
    private boolean d = true;

    @Override // com.google.android.gms.drive.ExecutionOptions.Builder
    public final /* synthetic */ ExecutionOptions build() {
        a();
        return new zzn(this.a, this.b, this.c, this.d);
    }

    @Override // com.google.android.gms.drive.ExecutionOptions.Builder
    public final /* synthetic */ ExecutionOptions.Builder setConflictStrategy(int i) {
        super.setConflictStrategy(i);
        return this;
    }

    @Override // com.google.android.gms.drive.ExecutionOptions.Builder
    public final /* synthetic */ ExecutionOptions.Builder setNotifyOnCompletion(boolean z) {
        super.setNotifyOnCompletion(z);
        return this;
    }

    @Override // com.google.android.gms.drive.ExecutionOptions.Builder
    public final /* synthetic */ ExecutionOptions.Builder setTrackingTag(String str) {
        super.setTrackingTag(str);
        return this;
    }
}
