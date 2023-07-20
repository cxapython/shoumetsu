package com.google.android.gms.games;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes.dex */
public final class GamesCallbackStatusCodes {
    @Deprecated
    public static final int CLIENT_RECONNECT_REQUIRED = 2;
    public static final int INTERNAL_ERROR = 1;
    public static final int MULTIPLAYER_DISABLED = 6003;
    public static final int OK = 0;
    public static final int REAL_TIME_CONNECTION_FAILED = 7000;
    public static final int REAL_TIME_MESSAGE_SEND_FAILED = 7001;
    public static final int REAL_TIME_ROOM_NOT_JOINED = 7004;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface OnJoinedRoomStatusCodes {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface OnLeftRoomStatusCodes {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface OnRealTimeMessageSentStatusCodes {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface OnRoomConnectedStatusCodes {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface OnRoomCreatedStatusCodes {
    }

    private GamesCallbackStatusCodes() {
    }

    public static String getStatusCodeString(int i) {
        if (i != 6003) {
            if (i == 7004) {
                return "REAL_TIME_ROOM_NOT_JOINED";
            }
            switch (i) {
                case 0:
                    return net.gree.gamelib.core.a.b.b.d;
                case 1:
                    return "INTERNAL_ERROR";
                case 2:
                    return "CLIENT_RECONNECT_REQUIRED";
                default:
                    switch (i) {
                        case 7000:
                            return "REAL_TIME_CONNECTION_FAILED";
                        case 7001:
                            return "REAL_TIME_MESSAGE_SEND_FAILED";
                        default:
                            StringBuilder sb = new StringBuilder(47);
                            sb.append("unknown games callback status code: ");
                            sb.append(i);
                            return sb.toString();
                    }
            }
        }
        return "MULTIPLAYER_DISABLED";
    }
}
