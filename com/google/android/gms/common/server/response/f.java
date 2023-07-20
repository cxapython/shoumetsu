package com.google.android.gms.common.server.response;

import com.google.android.gms.common.server.response.FastParser;
import java.io.BufferedReader;

/* loaded from: classes.dex */
final class f implements FastParser.a<String> {
    @Override // com.google.android.gms.common.server.response.FastParser.a
    public final /* synthetic */ String a(FastParser fastParser, BufferedReader bufferedReader) {
        String c;
        c = fastParser.c(bufferedReader);
        return c;
    }
}
