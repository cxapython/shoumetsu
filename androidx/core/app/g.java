package androidx.core.app;

import android.app.Notification;
import android.app.RemoteInput;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import android.widget.RemoteViews;
import androidx.core.app.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
class g implements e {
    private final Notification.Builder a;
    private final f.d b;
    private RemoteViews c;
    private RemoteViews d;
    private final List<Bundle> e = new ArrayList();
    private final Bundle f = new Bundle();
    private int g;
    private RemoteViews h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f.d dVar) {
        Bundle bundle;
        String str;
        this.b = dVar;
        this.a = Build.VERSION.SDK_INT >= 26 ? new Notification.Builder(dVar.a, dVar.I) : new Notification.Builder(dVar.a);
        Notification notification = dVar.N;
        this.a.setWhen(notification.when).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, dVar.h).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).setOngoing((notification.flags & 2) != 0).setOnlyAlertOnce((notification.flags & 8) != 0).setAutoCancel((notification.flags & 16) != 0).setDefaults(notification.defaults).setContentTitle(dVar.d).setContentText(dVar.e).setContentInfo(dVar.j).setContentIntent(dVar.f).setDeleteIntent(notification.deleteIntent).setFullScreenIntent(dVar.g, (notification.flags & 128) != 0).setLargeIcon(dVar.i).setNumber(dVar.k).setProgress(dVar.r, dVar.s, dVar.t);
        if (Build.VERSION.SDK_INT < 21) {
            this.a.setSound(notification.sound, notification.audioStreamType);
        }
        if (Build.VERSION.SDK_INT >= 16) {
            this.a.setSubText(dVar.p).setUsesChronometer(dVar.n).setPriority(dVar.l);
            Iterator<f.a> it = dVar.b.iterator();
            while (it.hasNext()) {
                a(it.next());
            }
            if (dVar.B != null) {
                this.f.putAll(dVar.B);
            }
            if (Build.VERSION.SDK_INT < 20) {
                if (dVar.x) {
                    this.f.putBoolean("android.support.localOnly", true);
                }
                if (dVar.u != null) {
                    this.f.putString("android.support.groupKey", dVar.u);
                    if (dVar.v) {
                        bundle = this.f;
                        str = "android.support.isGroupSummary";
                    } else {
                        bundle = this.f;
                        str = "android.support.useSideChannel";
                    }
                    bundle.putBoolean(str, true);
                }
                if (dVar.w != null) {
                    this.f.putString("android.support.sortKey", dVar.w);
                }
            }
            this.c = dVar.F;
            this.d = dVar.G;
        }
        if (Build.VERSION.SDK_INT >= 19) {
            this.a.setShowWhen(dVar.m);
            if (Build.VERSION.SDK_INT < 21 && dVar.O != null && !dVar.O.isEmpty()) {
                this.f.putStringArray("android.people", (String[]) dVar.O.toArray(new String[dVar.O.size()]));
            }
        }
        if (Build.VERSION.SDK_INT >= 20) {
            this.a.setLocalOnly(dVar.x).setGroup(dVar.u).setGroupSummary(dVar.v).setSortKey(dVar.w);
            this.g = dVar.M;
        }
        if (Build.VERSION.SDK_INT >= 21) {
            this.a.setCategory(dVar.A).setColor(dVar.C).setVisibility(dVar.D).setPublicVersion(dVar.E).setSound(notification.sound, notification.audioAttributes);
            Iterator<String> it2 = dVar.O.iterator();
            while (it2.hasNext()) {
                this.a.addPerson(it2.next());
            }
            this.h = dVar.H;
            if (dVar.c.size() > 0) {
                Bundle bundle2 = dVar.a().getBundle("android.car.EXTENSIONS");
                bundle2 = bundle2 == null ? new Bundle() : bundle2;
                Bundle bundle3 = new Bundle();
                for (int i = 0; i < dVar.c.size(); i++) {
                    bundle3.putBundle(Integer.toString(i), h.a(dVar.c.get(i)));
                }
                bundle2.putBundle("invisible_actions", bundle3);
                dVar.a().putBundle("android.car.EXTENSIONS", bundle2);
                this.f.putBundle("android.car.EXTENSIONS", bundle2);
            }
        }
        if (Build.VERSION.SDK_INT >= 24) {
            this.a.setExtras(dVar.B).setRemoteInputHistory(dVar.q);
            if (dVar.F != null) {
                this.a.setCustomContentView(dVar.F);
            }
            if (dVar.G != null) {
                this.a.setCustomBigContentView(dVar.G);
            }
            if (dVar.H != null) {
                this.a.setCustomHeadsUpContentView(dVar.H);
            }
        }
        if (Build.VERSION.SDK_INT >= 26) {
            this.a.setBadgeIconType(dVar.J).setShortcutId(dVar.K).setTimeoutAfter(dVar.L).setGroupAlertBehavior(dVar.M);
            if (dVar.z) {
                this.a.setColorized(dVar.y);
            }
            if (TextUtils.isEmpty(dVar.I)) {
                return;
            }
            this.a.setSound(null).setDefaults(0).setLights(0, 0, 0).setVibrate(null);
        }
    }

    private void a(Notification notification) {
        notification.sound = null;
        notification.vibrate = null;
        notification.defaults &= -2;
        notification.defaults &= -3;
    }

    private void a(f.a aVar) {
        if (Build.VERSION.SDK_INT < 20) {
            if (Build.VERSION.SDK_INT < 16) {
                return;
            }
            this.e.add(h.a(this.a, aVar));
            return;
        }
        Notification.Action.Builder builder = new Notification.Action.Builder(aVar.a(), aVar.b(), aVar.c());
        if (aVar.f() != null) {
            for (RemoteInput remoteInput : i.a(aVar.f())) {
                builder.addRemoteInput(remoteInput);
            }
        }
        Bundle bundle = aVar.d() != null ? new Bundle(aVar.d()) : new Bundle();
        bundle.putBoolean("android.support.allowGeneratedReplies", aVar.e());
        if (Build.VERSION.SDK_INT >= 24) {
            builder.setAllowGeneratedReplies(aVar.e());
        }
        bundle.putInt("android.support.action.semanticAction", aVar.g());
        if (Build.VERSION.SDK_INT >= 28) {
            builder.setSemanticAction(aVar.g());
        }
        bundle.putBoolean("android.support.action.showsUserInterface", aVar.i());
        builder.addExtras(bundle);
        this.a.addAction(builder.build());
    }

    @Override // androidx.core.app.e
    public Notification.Builder a() {
        return this.a;
    }

    public Notification b() {
        Bundle a;
        RemoteViews d;
        RemoteViews c;
        f.e eVar = this.b.o;
        if (eVar != null) {
            eVar.a(this);
        }
        RemoteViews b = eVar != null ? eVar.b(this) : null;
        Notification c2 = c();
        if (b == null) {
            if (this.b.F != null) {
                b = this.b.F;
            }
            if (Build.VERSION.SDK_INT >= 16 && eVar != null && (c = eVar.c(this)) != null) {
                c2.bigContentView = c;
            }
            if (Build.VERSION.SDK_INT >= 21 && eVar != null && (d = this.b.o.d(this)) != null) {
                c2.headsUpContentView = d;
            }
            if (Build.VERSION.SDK_INT >= 16 && eVar != null && (a = f.a(c2)) != null) {
                eVar.a(a);
            }
            return c2;
        }
        c2.contentView = b;
        if (Build.VERSION.SDK_INT >= 16) {
            c2.bigContentView = c;
        }
        if (Build.VERSION.SDK_INT >= 21) {
            c2.headsUpContentView = d;
        }
        if (Build.VERSION.SDK_INT >= 16) {
            eVar.a(a);
        }
        return c2;
    }

    protected Notification c() {
        if (Build.VERSION.SDK_INT >= 26) {
            return this.a.build();
        }
        if (Build.VERSION.SDK_INT >= 24) {
            Notification build = this.a.build();
            if (this.g != 0) {
                if (build.getGroup() != null && (build.flags & 512) != 0 && this.g == 2) {
                    a(build);
                }
                if (build.getGroup() != null && (build.flags & 512) == 0 && this.g == 1) {
                    a(build);
                }
            }
            return build;
        } else if (Build.VERSION.SDK_INT >= 21) {
            this.a.setExtras(this.f);
            Notification build2 = this.a.build();
            RemoteViews remoteViews = this.c;
            if (remoteViews != null) {
                build2.contentView = remoteViews;
            }
            RemoteViews remoteViews2 = this.d;
            if (remoteViews2 != null) {
                build2.bigContentView = remoteViews2;
            }
            RemoteViews remoteViews3 = this.h;
            if (remoteViews3 != null) {
                build2.headsUpContentView = remoteViews3;
            }
            if (this.g != 0) {
                if (build2.getGroup() != null && (build2.flags & 512) != 0 && this.g == 2) {
                    a(build2);
                }
                if (build2.getGroup() != null && (build2.flags & 512) == 0 && this.g == 1) {
                    a(build2);
                }
            }
            return build2;
        } else if (Build.VERSION.SDK_INT >= 20) {
            this.a.setExtras(this.f);
            Notification build3 = this.a.build();
            RemoteViews remoteViews4 = this.c;
            if (remoteViews4 != null) {
                build3.contentView = remoteViews4;
            }
            RemoteViews remoteViews5 = this.d;
            if (remoteViews5 != null) {
                build3.bigContentView = remoteViews5;
            }
            if (this.g != 0) {
                if (build3.getGroup() != null && (build3.flags & 512) != 0 && this.g == 2) {
                    a(build3);
                }
                if (build3.getGroup() != null && (build3.flags & 512) == 0 && this.g == 1) {
                    a(build3);
                }
            }
            return build3;
        } else if (Build.VERSION.SDK_INT >= 19) {
            SparseArray<Bundle> a = h.a(this.e);
            if (a != null) {
                this.f.putSparseParcelableArray("android.support.actionExtras", a);
            }
            this.a.setExtras(this.f);
            Notification build4 = this.a.build();
            RemoteViews remoteViews6 = this.c;
            if (remoteViews6 != null) {
                build4.contentView = remoteViews6;
            }
            RemoteViews remoteViews7 = this.d;
            if (remoteViews7 != null) {
                build4.bigContentView = remoteViews7;
            }
            return build4;
        } else if (Build.VERSION.SDK_INT < 16) {
            return this.a.getNotification();
        } else {
            Notification build5 = this.a.build();
            Bundle a2 = f.a(build5);
            Bundle bundle = new Bundle(this.f);
            for (String str : this.f.keySet()) {
                if (a2.containsKey(str)) {
                    bundle.remove(str);
                }
            }
            a2.putAll(bundle);
            SparseArray<Bundle> a3 = h.a(this.e);
            if (a3 != null) {
                f.a(build5).putSparseParcelableArray("android.support.actionExtras", a3);
            }
            RemoteViews remoteViews8 = this.c;
            if (remoteViews8 != null) {
                build5.contentView = remoteViews8;
            }
            RemoteViews remoteViews9 = this.d;
            if (remoteViews9 != null) {
                build5.bigContentView = remoteViews9;
            }
            return build5;
        }
    }
}
