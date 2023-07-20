package net.gree.gamelib.moderation;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.regex.PatternSyntaxException;
import net.gree.gamelib.core.CallbackListener;
import net.gree.gamelib.core.Config;
import net.gree.gamelib.core.Core;
import net.gree.gamelib.core.GLog;
import net.gree.gamelib.core.http.SignedRequest;
import net.gree.gamelib.moderation.a.a.a;
import net.gree.gamelib.moderation.a.b;
import net.gree.gamelib.moderation.a.b.c;
import net.gree.gamelib.moderation.a.c;
import net.gree.gamelib.moderation.a.d;
import net.gree.gamelib.moderation.a.e;
import net.gree.gamelib.moderation.a.f;
import net.gree.gamelib.moderation.a.g;
import org.json.JSONException;

/* loaded from: classes.dex */
public class KeywordFilter {
    public static final int FILTERING_RESULT_BLACK = 0;
    public static final int FILTERING_RESULT_GRAY = 1;
    public static final int FILTERING_RESULT_NOT_READY = 3;
    public static final int FILTERING_RESULT_OK = 2;
    public static final int KEYWORD_TYPE_REGEX = 1;
    public static final int KEYWORD_TYPE_TEXT = 0;
    private static final String a = "KeywordFilter";
    private static final String b = "2.0.0";
    private static final String c = "v1.0";
    private static KeywordFilter d;
    private Core e;
    private Context f;
    private Map<String, String> g;
    private c h;
    private d i;
    private e j;
    private boolean k = false;
    private net.gree.gamelib.moderation.a.c l;
    private net.gree.gamelib.moderation.a.a.d m;
    private g n;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: net.gree.gamelib.moderation.KeywordFilter$2  reason: invalid class name */
    /* loaded from: classes.dex */
    public class AnonymousClass2 implements Runnable {
        final /* synthetic */ KeywordFilterListener a;

        AnonymousClass2(KeywordFilterListener keywordFilterListener) {
            this.a = keywordFilterListener;
        }

        @Override // java.lang.Runnable
        public void run() {
            net.gree.gamelib.moderation.a.c e = KeywordFilter.this.e();
            KeywordFilter.this.getSignedRequest().request("GET", KeywordFilter.this.d().a(KeywordFilter.c, e != null ? e.a() : null), new c.a(new KeywordFilterListener<net.gree.gamelib.moderation.a.c>() { // from class: net.gree.gamelib.moderation.KeywordFilter.2.1
                @Override // net.gree.gamelib.core.CallbackListener
                /* renamed from: a */
                public void onSuccess(net.gree.gamelib.moderation.a.c cVar) {
                    if (cVar == null) {
                        onError(0, "response is null");
                        return;
                    }
                    b[] b = cVar.b();
                    if (b == null || b.length == 0) {
                        GLog.i(KeywordFilter.a, "Keyword List is not updated");
                        if (AnonymousClass2.this.a == null) {
                            return;
                        }
                        AnonymousClass2.this.a.onSuccess(null);
                        return;
                    }
                    KeywordFilter.this.i.a(cVar);
                    if (KeywordFilter.this.k) {
                        KeywordFilter.this.l = cVar;
                    }
                    new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: net.gree.gamelib.moderation.KeywordFilter.2.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            GLog.i(KeywordFilter.a, "Keyword List is updated");
                            if (AnonymousClass2.this.a != null) {
                                AnonymousClass2.this.a.onSuccess(null);
                            }
                        }
                    });
                }

                @Override // net.gree.gamelib.core.CallbackListener
                public void onError(int i, String str) {
                    if (AnonymousClass2.this.a != null) {
                        AnonymousClass2.this.a.onError(i, str);
                    }
                }
            }));
            KeywordFilter.this.c();
        }
    }

    protected KeywordFilter(Context context, String str, String str2, Map<String, String> map) {
        this.f = context.getApplicationContext();
        this.g = map;
        this.h = new net.gree.gamelib.moderation.a.b.c(map);
        Config config = new Config(this.h.getDomain(), str, str2);
        config.setServerBaseUrl(this.h.getBaseUrl());
        if (map != null) {
            config.setScramble(map.get("ksrle"));
            String str3 = map.get("isTestUser");
            if (str3 != null) {
                config.setTestUserEnabled(Boolean.valueOf(str3).booleanValue());
            }
        }
        a();
        if (this.e == null) {
            GLog.i(a, "New core instance");
            this.e = new Core(context, config);
        }
        this.i = new d(context);
        this.j = new e(this);
        this.m = new net.gree.gamelib.moderation.a.a.d(context);
        this.n = new g(this);
    }

    static void b() {
        d = null;
    }

    public static KeywordFilter getInstance() {
        return d;
    }

    public static String getVersion() {
        return b;
    }

    public static void initialize(Context context, String str, String str2, Map<String, String> map) {
        if (d == null) {
            d = new KeywordFilter(context, str, str2, map);
        }
    }

    void a() {
        Object invoke;
        Method method;
        try {
            Class<?> cls = Class.forName("net.gree.gamelib.payment.Payment");
            if (cls == null) {
                return;
            }
            GLog.i(a, "Get Payment core instance");
            Method method2 = cls.getMethod("getInstance", new Class[0]);
            if (method2 == null || (invoke = method2.invoke(null, new Object[0])) == null || (method = cls.getMethod("getCore", new Class[0])) == null) {
                return;
            }
            this.e = (Core) method.invoke(invoke, new Object[0]);
        } catch (Exception unused) {
        }
    }

    void a(Core core) {
        this.e = core;
    }

    public void authorize(String str, final KeywordFilterListener<Void> keywordFilterListener) {
        this.e.authorize(str, new CallbackListener<Void>() { // from class: net.gree.gamelib.moderation.KeywordFilter.1
            @Override // net.gree.gamelib.core.CallbackListener
            /* renamed from: a */
            public void onSuccess(Void r2) {
                KeywordFilter.this.n.a();
                KeywordFilterListener keywordFilterListener2 = keywordFilterListener;
                if (keywordFilterListener2 != null) {
                    keywordFilterListener2.onSuccess(null);
                }
            }

            @Override // net.gree.gamelib.core.CallbackListener
            public void onError(int i, String str2) {
                KeywordFilterListener keywordFilterListener2 = keywordFilterListener;
                if (keywordFilterListener2 != null) {
                    keywordFilterListener2.onError(i, str2);
                }
            }
        });
    }

    void c() {
        this.n.a();
    }

    public void clearCache() {
        this.l = null;
    }

    net.gree.gamelib.moderation.a.b.c d() {
        if (this.h == null) {
            this.h = new net.gree.gamelib.moderation.a.b.c(this.g);
        }
        return this.h;
    }

    net.gree.gamelib.moderation.a.c e() {
        net.gree.gamelib.moderation.a.c cVar = this.l;
        if (cVar != null) {
            return cVar;
        }
        net.gree.gamelib.moderation.a.c f = f();
        if (this.k) {
            this.l = f;
        }
        return f;
    }

    net.gree.gamelib.moderation.a.c f() {
        return this.i.a();
    }

    public void filter(final String str, final FilteringResultListener filteringResultListener) {
        Core.EXECUTOR.execute(new Runnable() { // from class: net.gree.gamelib.moderation.KeywordFilter.3
            /* JADX WARN: Code restructure failed: missing block: B:10:0x0045, code lost:
                if (r1.matches("(?i).*" + r6.e() + ".*") != false) goto L9;
             */
            /* JADX WARN: Code restructure failed: missing block: B:15:0x0062, code lost:
                if (r1.toLowerCase(java.util.Locale.ENGLISH).indexOf(r6.e().toLowerCase(java.util.Locale.ENGLISH)) != (-1)) goto L9;
             */
            /* JADX WARN: Code restructure failed: missing block: B:16:0x0064, code lost:
                r3 = r6;
             */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void run() {
                a aVar;
                net.gree.gamelib.moderation.a.c e = KeywordFilter.this.e();
                String a2 = new f().a(str);
                final int i = 3;
                if (e != null) {
                    b bVar = null;
                    b[] b2 = e.b();
                    int length = b2.length;
                    for (int i2 = 0; i2 < length; i2++) {
                        b bVar2 = b2[i2];
                        switch (bVar2.b()) {
                            case 1:
                                try {
                                    break;
                                } catch (PatternSyntaxException e2) {
                                    e2.printStackTrace();
                                    break;
                                }
                        }
                        if (bVar == null) {
                        }
                    }
                    try {
                        if (bVar == null) {
                            aVar = new a();
                            i = 2;
                        } else {
                            aVar = new a(bVar.a());
                            i = bVar.c();
                        }
                        KeywordFilter.this.j.a(aVar);
                    } catch (JSONException e3) {
                        e3.printStackTrace();
                    }
                }
                if (filteringResultListener != null) {
                    new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: net.gree.gamelib.moderation.KeywordFilter.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            filteringResultListener.onCompleted(i);
                        }
                    });
                }
            }
        });
    }

    net.gree.gamelib.moderation.a.c g() {
        return this.l;
    }

    public Context getContext() {
        return this.f;
    }

    public Map<String, String> getParams() {
        return this.g;
    }

    public SignedRequest getSignedRequest() {
        SignedRequest signedRequest = this.e.getSignedRequest();
        signedRequest.addCustomValues(net.gree.gamelib.moderation.a.b.c.a, getVersion());
        return signedRequest;
    }

    protected net.gree.gamelib.moderation.a.a.c getUserRestriction() {
        return this.m.a();
    }

    public net.gree.gamelib.moderation.a.a.d getUserRestrictionStorage() {
        return this.m;
    }

    public boolean isRestricted(String str) {
        boolean z = false;
        if (!this.e.isAuthorized()) {
            return false;
        }
        net.gree.gamelib.moderation.a.a.c userRestriction = getUserRestriction();
        if (userRestriction != null && userRestriction.a() != null && str.matches(userRestriction.a())) {
            z = true;
        }
        this.n.a();
        return z;
    }

    public void queryKeywordList(KeywordFilterListener<Void> keywordFilterListener) {
        Core.EXECUTOR.execute(new AnonymousClass2(keywordFilterListener));
    }

    public void resetAuthorization() {
        this.e.resetAuthorization();
    }

    public void setCacheEnabled(boolean z) {
        this.k = z;
        if (!z) {
            this.l = null;
        }
    }
}
