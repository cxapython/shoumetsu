package com.microsoft.appcenter.c.a.a;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import org.json.JSONException;

/* loaded from: classes.dex */
public final class d {
    private static final ThreadLocal<DateFormat> a = new ThreadLocal<DateFormat>() { // from class: com.microsoft.appcenter.c.a.a.d.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* renamed from: a */
        public DateFormat initialValue() {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US);
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
            return simpleDateFormat;
        }
    };

    public static String a(Date date) {
        a((Object) date);
        return a.get().format(date);
    }

    public static Date a(String str) {
        a((Object) str);
        try {
            return a.get().parse(str);
        } catch (ParseException e) {
            throw new JSONException(e.getMessage());
        }
    }

    private static void a(Object obj) {
        if (obj != null) {
            return;
        }
        throw new JSONException("date cannot be null");
    }
}
