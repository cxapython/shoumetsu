package com.google.android.gms.drive;

import android.text.TextUtils;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.internal.drive.zzaw;

/* loaded from: classes.dex */
public class ExecutionOptions {
    public static final int CONFLICT_STRATEGY_KEEP_REMOTE = 1;
    public static final int CONFLICT_STRATEGY_OVERWRITE_REMOTE = 0;
    public static final int MAX_TRACKING_TAG_STRING_LENGTH = 65536;
    private final String a;
    private final boolean b;
    private final int c;

    /* loaded from: classes.dex */
    public static class Builder {
        protected String a;
        protected boolean b;
        protected int c = 0;

        /* JADX INFO: Access modifiers changed from: protected */
        public final void a() {
            if (this.c != 1 || this.b) {
                return;
            }
            throw new IllegalStateException("Cannot use CONFLICT_STRATEGY_KEEP_REMOTE without requesting completion notifications");
        }

        public ExecutionOptions build() {
            a();
            return new ExecutionOptions(this.a, this.b, this.c);
        }

        public Builder setConflictStrategy(int i) {
            boolean z;
            switch (i) {
                case 0:
                case 1:
                    z = true;
                    break;
                default:
                    z = false;
                    break;
            }
            if (z) {
                this.c = i;
                return this;
            }
            StringBuilder sb = new StringBuilder(53);
            sb.append("Unrecognized value for conflict strategy: ");
            sb.append(i);
            throw new IllegalArgumentException(sb.toString());
        }

        public Builder setNotifyOnCompletion(boolean z) {
            this.b = z;
            return this;
        }

        public Builder setTrackingTag(String str) {
            if (!TextUtils.isEmpty(str) && str.length() <= 65536) {
                this.a = str;
                return this;
            }
            throw new IllegalArgumentException(String.format("trackingTag must not be null nor empty, and the length must be <= the maximum length (%s)", Integer.valueOf((int) ExecutionOptions.MAX_TRACKING_TAG_STRING_LENGTH)));
        }
    }

    public ExecutionOptions(String str, boolean z, int i) {
        this.a = str;
        this.b = z;
        this.c = i;
    }

    public static boolean zza(int i) {
        return i == 1;
    }

    public boolean equals(Object obj) {
        if (obj != null && obj.getClass() == getClass()) {
            if (obj == this) {
                return true;
            }
            ExecutionOptions executionOptions = (ExecutionOptions) obj;
            if (Objects.equal(this.a, executionOptions.a) && this.c == executionOptions.c && this.b == executionOptions.b) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return Objects.hashCode(this.a, Integer.valueOf(this.c), Boolean.valueOf(this.b));
    }

    @Deprecated
    public final void zza(GoogleApiClient googleApiClient) {
        zza((zzaw) googleApiClient.getClient(Drive.CLIENT_KEY));
    }

    public final void zza(zzaw zzawVar) {
        if (!this.b || zzawVar.zzag()) {
            return;
        }
        throw new IllegalStateException("Application must define an exported DriveEventService subclass in AndroidManifest.xml to be notified on completion");
    }

    public final String zzk() {
        return this.a;
    }

    public final boolean zzl() {
        return this.b;
    }

    public final int zzm() {
        return this.c;
    }
}
