package com.microsoft.appcenter.e.b;

import java.util.Calendar;
import java.util.Date;

/* loaded from: classes.dex */
public class d {
    private final String a;
    private final Date b;
    private final Date c;

    public d() {
        this(null, null, null);
    }

    public d(String str, Date date, Date date2) {
        this.a = str;
        this.b = date;
        this.c = date2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a() {
        if (this.c == null) {
            return false;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.add(13, 600);
        return calendar.getTime().after(this.c);
    }

    public String b() {
        return this.a;
    }

    public Date c() {
        return this.b;
    }

    public Date d() {
        return this.c;
    }
}
