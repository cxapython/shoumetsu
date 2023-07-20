package com.google.android.gms.games.event;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.apps.common.proguard.UsedByReflection;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.DataUtils;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.internal.zzd;

@UsedByReflection("GamesClientImpl.java")
@SafeParcelable.Class(creator = "EventEntityCreator")
@SafeParcelable.Reserved({1000})
/* loaded from: classes.dex */
public final class EventEntity extends zzd implements Event {
    public static final Parcelable.Creator<EventEntity> CREATOR = new zza();
    @SafeParcelable.Field(getter = "getEventId", id = 1)
    private final String a;
    @SafeParcelable.Field(getter = "getName", id = 2)
    private final String b;
    @SafeParcelable.Field(getter = "getDescription", id = 3)
    private final String c;
    @SafeParcelable.Field(getter = "getIconImageUri", id = 4)
    private final Uri d;
    @SafeParcelable.Field(getter = "getIconImageUrl", id = 5)
    private final String e;
    @SafeParcelable.Field(getter = "getPlayer", id = 6)
    private final PlayerEntity f;
    @SafeParcelable.Field(getter = "getValue", id = 7)
    private final long g;
    @SafeParcelable.Field(getter = "getFormattedValue", id = 8)
    private final String h;
    @SafeParcelable.Field(getter = "isVisible", id = 9)
    private final boolean i;

    public EventEntity(Event event) {
        this.a = event.getEventId();
        this.b = event.getName();
        this.c = event.getDescription();
        this.d = event.getIconImageUri();
        this.e = event.getIconImageUrl();
        this.f = (PlayerEntity) event.getPlayer().mo28freeze();
        this.g = event.getValue();
        this.h = event.getFormattedValue();
        this.i = event.isVisible();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public EventEntity(@SafeParcelable.Param(id = 1) String str, @SafeParcelable.Param(id = 2) String str2, @SafeParcelable.Param(id = 3) String str3, @SafeParcelable.Param(id = 4) Uri uri, @SafeParcelable.Param(id = 5) String str4, @SafeParcelable.Param(id = 6) Player player, @SafeParcelable.Param(id = 7) long j, @SafeParcelable.Param(id = 8) String str5, @SafeParcelable.Param(id = 9) boolean z) {
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = uri;
        this.e = str4;
        this.f = new PlayerEntity(player);
        this.g = j;
        this.h = str5;
        this.i = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(Event event) {
        return Objects.hashCode(event.getEventId(), event.getName(), event.getDescription(), event.getIconImageUri(), event.getIconImageUrl(), event.getPlayer(), Long.valueOf(event.getValue()), event.getFormattedValue(), Boolean.valueOf(event.isVisible()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(Event event, Object obj) {
        if (!(obj instanceof Event)) {
            return false;
        }
        if (event == obj) {
            return true;
        }
        Event event2 = (Event) obj;
        return Objects.equal(event2.getEventId(), event.getEventId()) && Objects.equal(event2.getName(), event.getName()) && Objects.equal(event2.getDescription(), event.getDescription()) && Objects.equal(event2.getIconImageUri(), event.getIconImageUri()) && Objects.equal(event2.getIconImageUrl(), event.getIconImageUrl()) && Objects.equal(event2.getPlayer(), event.getPlayer()) && Objects.equal(Long.valueOf(event2.getValue()), Long.valueOf(event.getValue())) && Objects.equal(event2.getFormattedValue(), event.getFormattedValue()) && Objects.equal(Boolean.valueOf(event2.isVisible()), Boolean.valueOf(event.isVisible()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String b(Event event) {
        return Objects.toStringHelper(event).add("Id", event.getEventId()).add("Name", event.getName()).add("Description", event.getDescription()).add("IconImageUri", event.getIconImageUri()).add("IconImageUrl", event.getIconImageUrl()).add("Player", event.getPlayer()).add("Value", Long.valueOf(event.getValue())).add("FormattedValue", event.getFormattedValue()).add("isVisible", Boolean.valueOf(event.isVisible())).toString();
    }

    public final boolean equals(Object obj) {
        return a(this, obj);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.android.gms.common.data.Freezable
    /* renamed from: freeze */
    public final Event mo28freeze() {
        return this;
    }

    @Override // com.google.android.gms.games.event.Event
    public final String getDescription() {
        return this.c;
    }

    @Override // com.google.android.gms.games.event.Event
    public final void getDescription(CharArrayBuffer charArrayBuffer) {
        DataUtils.copyStringToBuffer(this.c, charArrayBuffer);
    }

    @Override // com.google.android.gms.games.event.Event
    public final String getEventId() {
        return this.a;
    }

    @Override // com.google.android.gms.games.event.Event
    public final String getFormattedValue() {
        return this.h;
    }

    @Override // com.google.android.gms.games.event.Event
    public final void getFormattedValue(CharArrayBuffer charArrayBuffer) {
        DataUtils.copyStringToBuffer(this.h, charArrayBuffer);
    }

    @Override // com.google.android.gms.games.event.Event
    public final Uri getIconImageUri() {
        return this.d;
    }

    @Override // com.google.android.gms.games.event.Event
    public final String getIconImageUrl() {
        return this.e;
    }

    @Override // com.google.android.gms.games.event.Event
    public final String getName() {
        return this.b;
    }

    @Override // com.google.android.gms.games.event.Event
    public final void getName(CharArrayBuffer charArrayBuffer) {
        DataUtils.copyStringToBuffer(this.b, charArrayBuffer);
    }

    @Override // com.google.android.gms.games.event.Event
    public final Player getPlayer() {
        return this.f;
    }

    @Override // com.google.android.gms.games.event.Event
    public final long getValue() {
        return this.g;
    }

    public final int hashCode() {
        return a(this);
    }

    @Override // com.google.android.gms.common.data.Freezable
    public final boolean isDataValid() {
        return true;
    }

    @Override // com.google.android.gms.games.event.Event
    public final boolean isVisible() {
        return this.i;
    }

    public final String toString() {
        return b(this);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, getEventId(), false);
        SafeParcelWriter.writeString(parcel, 2, getName(), false);
        SafeParcelWriter.writeString(parcel, 3, getDescription(), false);
        SafeParcelWriter.writeParcelable(parcel, 4, getIconImageUri(), i, false);
        SafeParcelWriter.writeString(parcel, 5, getIconImageUrl(), false);
        SafeParcelWriter.writeParcelable(parcel, 6, getPlayer(), i, false);
        SafeParcelWriter.writeLong(parcel, 7, getValue());
        SafeParcelWriter.writeString(parcel, 8, getFormattedValue(), false);
        SafeParcelWriter.writeBoolean(parcel, 9, isVisible());
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
