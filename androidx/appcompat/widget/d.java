package androidx.appcompat.widget;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.database.DataSetObservable;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;
import android.util.Xml;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends DataSetObservable {
    static final String a = "d";
    private static final Object e = new Object();
    private static final Map<String, d> f = new HashMap();
    final Context b;
    final String c;
    boolean d;
    private final Object g;
    private final List<a> h;
    private final List<c> i;
    private Intent j;
    private b k;
    private int l;
    private boolean m;
    private boolean n;
    private boolean o;
    private InterfaceC0017d p;

    /* loaded from: classes.dex */
    public static final class a implements Comparable<a> {
        public final ResolveInfo a;
        public float b;

        public a(ResolveInfo resolveInfo) {
            this.a = resolveInfo;
        }

        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(a aVar) {
            return Float.floatToIntBits(aVar.b) - Float.floatToIntBits(this.b);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && Float.floatToIntBits(this.b) == Float.floatToIntBits(((a) obj).b);
        }

        public int hashCode() {
            return Float.floatToIntBits(this.b) + 31;
        }

        public String toString() {
            return "[resolveInfo:" + this.a.toString() + "; weight:" + new BigDecimal(this.b) + "]";
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        void a(Intent intent, List<a> list, List<c> list2);
    }

    /* loaded from: classes.dex */
    public static final class c {
        public final ComponentName a;
        public final long b;
        public final float c;

        public c(ComponentName componentName, long j, float f) {
            this.a = componentName;
            this.b = j;
            this.c = f;
        }

        public c(String str, long j, float f) {
            this(ComponentName.unflattenFromString(str), j, f);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            c cVar = (c) obj;
            ComponentName componentName = this.a;
            if (componentName == null) {
                if (cVar.a != null) {
                    return false;
                }
            } else if (!componentName.equals(cVar.a)) {
                return false;
            }
            return this.b == cVar.b && Float.floatToIntBits(this.c) == Float.floatToIntBits(cVar.c);
        }

        public int hashCode() {
            ComponentName componentName = this.a;
            int hashCode = componentName == null ? 0 : componentName.hashCode();
            long j = this.b;
            return ((((hashCode + 31) * 31) + ((int) (j ^ (j >>> 32)))) * 31) + Float.floatToIntBits(this.c);
        }

        public String toString() {
            return "[; activity:" + this.a + "; time:" + this.b + "; weight:" + new BigDecimal(this.c) + "]";
        }
    }

    /* renamed from: androidx.appcompat.widget.d$d  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0017d {
        boolean a(d dVar, Intent intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public final class e extends AsyncTask<Object, Void, Void> {
        e() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:10:0x006f, code lost:
            if (r12 != null) goto L15;
         */
        /* JADX WARN: Code restructure failed: missing block: B:11:0x0071, code lost:
            r12.close();
         */
        /* JADX WARN: Code restructure failed: missing block: B:18:0x0096, code lost:
            if (r12 == null) goto L13;
         */
        /* JADX WARN: Code restructure failed: missing block: B:23:0x00b8, code lost:
            if (r12 == null) goto L13;
         */
        /* JADX WARN: Code restructure failed: missing block: B:28:0x00da, code lost:
            if (r12 == null) goto L13;
         */
        /* JADX WARN: Code restructure failed: missing block: B:30:0x00dd, code lost:
            return null;
         */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public Void doInBackground(Object... objArr) {
            List list = (List) objArr[0];
            String str = (String) objArr[1];
            try {
                FileOutputStream openFileOutput = d.this.b.openFileOutput(str, 0);
                XmlSerializer newSerializer = Xml.newSerializer();
                try {
                    try {
                        try {
                            newSerializer.setOutput(openFileOutput, null);
                            newSerializer.startDocument("UTF-8", true);
                            newSerializer.startTag(null, "historical-records");
                            int size = list.size();
                            for (int i = 0; i < size; i++) {
                                c cVar = (c) list.remove(0);
                                newSerializer.startTag(null, "historical-record");
                                newSerializer.attribute(null, "activity", cVar.a.flattenToString());
                                newSerializer.attribute(null, "time", String.valueOf(cVar.b));
                                newSerializer.attribute(null, "weight", String.valueOf(cVar.c));
                                newSerializer.endTag(null, "historical-record");
                            }
                            newSerializer.endTag(null, "historical-records");
                            newSerializer.endDocument();
                            d.this.d = true;
                        } catch (IOException e) {
                            String str2 = d.a;
                            Log.e(str2, "Error writing historical record file: " + d.this.c, e);
                            d.this.d = true;
                        } catch (IllegalArgumentException e2) {
                            String str3 = d.a;
                            Log.e(str3, "Error writing historical record file: " + d.this.c, e2);
                            d.this.d = true;
                        }
                    } catch (IllegalStateException e3) {
                        String str4 = d.a;
                        Log.e(str4, "Error writing historical record file: " + d.this.c, e3);
                        d.this.d = true;
                    }
                } catch (Throwable th) {
                    d.this.d = true;
                    if (openFileOutput != null) {
                        try {
                            openFileOutput.close();
                        } catch (IOException unused) {
                        }
                    }
                    throw th;
                }
            } catch (FileNotFoundException e4) {
                String str5 = d.a;
                Log.e(str5, "Error writing historical record file: " + str, e4);
                return null;
            }
        }
    }

    private boolean a(c cVar) {
        boolean add = this.i.add(cVar);
        if (add) {
            this.n = true;
            h();
            c();
            e();
            notifyChanged();
        }
        return add;
    }

    private void c() {
        if (this.m) {
            if (!this.n) {
                return;
            }
            this.n = false;
            if (TextUtils.isEmpty(this.c)) {
                return;
            }
            new e().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new ArrayList(this.i), this.c);
            return;
        }
        throw new IllegalStateException("No preceding call to #readHistoricalData");
    }

    private void d() {
        boolean f2 = f() | g();
        h();
        if (f2) {
            e();
            notifyChanged();
        }
    }

    private boolean e() {
        if (this.k == null || this.j == null || this.h.isEmpty() || this.i.isEmpty()) {
            return false;
        }
        this.k.a(this.j, this.h, Collections.unmodifiableList(this.i));
        return true;
    }

    private boolean f() {
        if (!this.o || this.j == null) {
            return false;
        }
        this.o = false;
        this.h.clear();
        List<ResolveInfo> queryIntentActivities = this.b.getPackageManager().queryIntentActivities(this.j, 0);
        int size = queryIntentActivities.size();
        for (int i = 0; i < size; i++) {
            this.h.add(new a(queryIntentActivities.get(i)));
        }
        return true;
    }

    private boolean g() {
        if (!this.d || !this.n || TextUtils.isEmpty(this.c)) {
            return false;
        }
        this.d = false;
        this.m = true;
        i();
        return true;
    }

    private void h() {
        int size = this.i.size() - this.l;
        if (size <= 0) {
            return;
        }
        this.n = true;
        for (int i = 0; i < size; i++) {
            this.i.remove(0);
        }
    }

    private void i() {
        XmlPullParser newPullParser;
        try {
            FileInputStream openFileInput = this.b.openFileInput(this.c);
            try {
                try {
                    try {
                        newPullParser = Xml.newPullParser();
                        newPullParser.setInput(openFileInput, "UTF-8");
                        for (int i = 0; i != 1 && i != 2; i = newPullParser.next()) {
                        }
                    } catch (IOException e2) {
                        String str = a;
                        Log.e(str, "Error reading historical recrod file: " + this.c, e2);
                        if (openFileInput == null) {
                            return;
                        }
                    }
                } catch (XmlPullParserException e3) {
                    String str2 = a;
                    Log.e(str2, "Error reading historical recrod file: " + this.c, e3);
                    if (openFileInput == null) {
                        return;
                    }
                }
                if (!"historical-records".equals(newPullParser.getName())) {
                    throw new XmlPullParserException("Share records file does not start with historical-records tag.");
                }
                List<c> list = this.i;
                list.clear();
                while (true) {
                    int next = newPullParser.next();
                    if (next == 1) {
                        if (openFileInput == null) {
                            return;
                        }
                    } else if (next != 3 && next != 4) {
                        if (!"historical-record".equals(newPullParser.getName())) {
                            throw new XmlPullParserException("Share records file not well-formed.");
                        }
                        list.add(new c(newPullParser.getAttributeValue(null, "activity"), Long.parseLong(newPullParser.getAttributeValue(null, "time")), Float.parseFloat(newPullParser.getAttributeValue(null, "weight"))));
                    }
                }
                try {
                    openFileInput.close();
                } catch (IOException unused) {
                }
            } catch (Throwable th) {
                if (openFileInput != null) {
                    try {
                        openFileInput.close();
                    } catch (IOException unused2) {
                    }
                }
                throw th;
            }
        } catch (FileNotFoundException unused3) {
        }
    }

    public int a() {
        int size;
        synchronized (this.g) {
            d();
            size = this.h.size();
        }
        return size;
    }

    public int a(ResolveInfo resolveInfo) {
        synchronized (this.g) {
            d();
            List<a> list = this.h;
            int size = list.size();
            for (int i = 0; i < size; i++) {
                if (list.get(i).a == resolveInfo) {
                    return i;
                }
            }
            return -1;
        }
    }

    public ResolveInfo a(int i) {
        ResolveInfo resolveInfo;
        synchronized (this.g) {
            d();
            resolveInfo = this.h.get(i).a;
        }
        return resolveInfo;
    }

    public Intent b(int i) {
        synchronized (this.g) {
            if (this.j == null) {
                return null;
            }
            d();
            a aVar = this.h.get(i);
            ComponentName componentName = new ComponentName(aVar.a.activityInfo.packageName, aVar.a.activityInfo.name);
            Intent intent = new Intent(this.j);
            intent.setComponent(componentName);
            if (this.p != null) {
                if (this.p.a(this, new Intent(intent))) {
                    return null;
                }
            }
            a(new c(componentName, System.currentTimeMillis(), 1.0f));
            return intent;
        }
    }

    public ResolveInfo b() {
        synchronized (this.g) {
            d();
            if (!this.h.isEmpty()) {
                return this.h.get(0).a;
            }
            return null;
        }
    }

    public void c(int i) {
        synchronized (this.g) {
            d();
            a aVar = this.h.get(i);
            a aVar2 = this.h.get(0);
            a(new c(new ComponentName(aVar.a.activityInfo.packageName, aVar.a.activityInfo.name), System.currentTimeMillis(), aVar2 != null ? (aVar2.b - aVar.b) + 5.0f : 1.0f));
        }
    }
}
