package com.google.android.gms.common.server.response;

import com.google.android.gms.common.server.response.FastParser;
import java.io.BufferedReader;

/* loaded from: classes.dex */
final class a implements FastParser.a<Integer> {
    @Override // com.google.android.gms.common.server.response.FastParser.a
    public final /* synthetic */ Integer a(FastParser fastParser, BufferedReader bufferedReader) {
        int d;
        d = fastParser.d(bufferedReader);
        return Integer.valueOf(d);
    }
}
