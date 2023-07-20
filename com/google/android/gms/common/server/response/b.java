package com.google.android.gms.common.server.response;

import com.google.android.gms.common.server.response.FastParser;
import java.io.BufferedReader;

/* loaded from: classes.dex */
final class b implements FastParser.a<Long> {
    @Override // com.google.android.gms.common.server.response.FastParser.a
    public final /* synthetic */ Long a(FastParser fastParser, BufferedReader bufferedReader) {
        long e;
        e = fastParser.e(bufferedReader);
        return Long.valueOf(e);
    }
}
