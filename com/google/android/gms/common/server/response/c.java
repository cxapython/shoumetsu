package com.google.android.gms.common.server.response;

import com.google.android.gms.common.server.response.FastParser;
import java.io.BufferedReader;

/* loaded from: classes.dex */
final class c implements FastParser.a<Float> {
    @Override // com.google.android.gms.common.server.response.FastParser.a
    public final /* synthetic */ Float a(FastParser fastParser, BufferedReader bufferedReader) {
        float g;
        g = fastParser.g(bufferedReader);
        return Float.valueOf(g);
    }
}
