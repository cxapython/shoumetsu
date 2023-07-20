package com.google.android.gms.nearby.connection;

import android.bluetooth.BluetoothDevice;

/* loaded from: classes.dex */
public final class DiscoveredEndpointInfo {
    private final String a;
    private final String b;
    private final BluetoothDevice c;

    public DiscoveredEndpointInfo(String str, BluetoothDevice bluetoothDevice) {
        this.a = str;
        this.b = "__UNRECOGNIZED_BLUETOOTH_DEVICE__";
        this.c = bluetoothDevice;
    }

    @Deprecated
    public DiscoveredEndpointInfo(String str, String str2) {
        this.a = str;
        this.b = str2;
        this.c = null;
    }

    public final String getEndpointName() {
        return this.b;
    }

    public final String getServiceId() {
        return this.a;
    }
}
