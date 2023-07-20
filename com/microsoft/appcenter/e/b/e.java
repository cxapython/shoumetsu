package com.microsoft.appcenter.e.b;

import java.util.LinkedHashSet;
import java.util.Map;
import java.util.NavigableMap;
import java.util.Set;
import java.util.TreeMap;
import java.util.UUID;

/* loaded from: classes.dex */
public class e {
    private static e a;
    private final NavigableMap<Long, a> b = new TreeMap();
    private final long c = System.currentTimeMillis();

    /* loaded from: classes.dex */
    public static class a {
        private final long a;
        private final UUID b;
        private final long c;

        a(long j, UUID uuid, long j2) {
            this.a = j;
            this.b = uuid;
            this.c = j2;
        }

        long a() {
            return this.a;
        }

        public UUID b() {
            return this.b;
        }

        public long c() {
            return this.c;
        }

        public String toString() {
            String str = a() + "/";
            if (b() != null) {
                str = str + b();
            }
            return str + "/" + c();
        }
    }

    private e() {
        Set<String> b = com.microsoft.appcenter.e.d.d.b("sessions");
        if (b != null) {
            for (String str : b) {
                String[] split = str.split("/", -1);
                try {
                    long parseLong = Long.parseLong(split[0]);
                    String str2 = split[1];
                    this.b.put(Long.valueOf(parseLong), new a(parseLong, str2.isEmpty() ? null : UUID.fromString(str2), split.length > 2 ? Long.parseLong(split[2]) : parseLong));
                } catch (RuntimeException e) {
                    com.microsoft.appcenter.e.a.a("AppCenter", "Ignore invalid session in store: " + str, e);
                }
            }
        }
        com.microsoft.appcenter.e.a.b("AppCenter", "Loaded stored sessions: " + this.b);
        a((UUID) null);
    }

    public static synchronized e a() {
        e eVar;
        synchronized (e.class) {
            if (a == null) {
                a = new e();
            }
            eVar = a;
        }
        return eVar;
    }

    public synchronized a a(long j) {
        Map.Entry<Long, a> floorEntry = this.b.floorEntry(Long.valueOf(j));
        if (floorEntry != null) {
            return floorEntry.getValue();
        }
        return null;
    }

    public synchronized void a(UUID uuid) {
        long currentTimeMillis = System.currentTimeMillis();
        this.b.put(Long.valueOf(currentTimeMillis), new a(currentTimeMillis, uuid, this.c));
        if (this.b.size() > 10) {
            this.b.pollFirstEntry();
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (a aVar : this.b.values()) {
            linkedHashSet.add(aVar.toString());
        }
        com.microsoft.appcenter.e.d.d.b("sessions", linkedHashSet);
    }

    public synchronized void b() {
        this.b.clear();
        com.microsoft.appcenter.e.d.d.c("sessions");
    }
}
