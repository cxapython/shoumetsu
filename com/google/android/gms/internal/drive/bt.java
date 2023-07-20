package com.google.android.gms.internal.drive;

import com.google.android.gms.drive.events.ChangeEvent;
import com.google.android.gms.drive.events.ChangeListener;
import com.google.android.gms.drive.events.OnChangeListener;

/* loaded from: classes.dex */
final /* synthetic */ class bt implements ChangeListener {
    private final OnChangeListener a;

    private bt(OnChangeListener onChangeListener) {
        this.a = onChangeListener;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ChangeListener a(OnChangeListener onChangeListener) {
        return new bt(onChangeListener);
    }

    @Override // com.google.android.gms.drive.events.ChangeListener
    public final void onChange(ChangeEvent changeEvent) {
        this.a.onChange(changeEvent);
    }
}
