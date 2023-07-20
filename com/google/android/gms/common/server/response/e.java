package com.google.android.gms.common.server.response;

import com.google.android.gms.common.server.response.FastParser;
import java.io.BufferedReader;

/* loaded from: classes.dex */
final class e implements FastParser.a<Boolean> {
    @Override // com.google.android.gms.common.server.response.FastParser.a
    public final /* synthetic */ Boolean a(FastParser fastParser, BufferedReader bufferedReader) {
        boolean a;
        a = fastParser.a(bufferedReader, false);
        return Boolean.valueOf(a);
    }
}
