package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.IAccountAccessor;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import javax.annotation.Nullable;

@SafeParcelable.Class(creator = "AuthAccountRequestCreator")
/* loaded from: classes.dex */
public class AuthAccountRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<AuthAccountRequest> CREATOR = new zaa();
    @SafeParcelable.VersionField(id = 1)
    private final int a;
    @SafeParcelable.Field(id = 2)
    @Deprecated
    private final IBinder b;
    @SafeParcelable.Field(id = 3)
    private final Scope[] c;
    @SafeParcelable.Field(id = 4)
    private Integer d;
    @SafeParcelable.Field(id = 5)
    private Integer e;
    @SafeParcelable.Field(id = 6, type = "android.accounts.Account")
    private Account f;

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public AuthAccountRequest(@SafeParcelable.Param(id = 1) int i, @SafeParcelable.Param(id = 2) IBinder iBinder, @SafeParcelable.Param(id = 3) Scope[] scopeArr, @SafeParcelable.Param(id = 4) Integer num, @SafeParcelable.Param(id = 5) Integer num2, @SafeParcelable.Param(id = 6) Account account) {
        this.a = i;
        this.b = iBinder;
        this.c = scopeArr;
        this.d = num;
        this.e = num2;
        this.f = account;
    }

    public AuthAccountRequest(Account account, Set<Scope> set) {
        this(3, null, (Scope[]) set.toArray(new Scope[set.size()]), null, null, (Account) Preconditions.checkNotNull(account));
    }

    @Deprecated
    public AuthAccountRequest(IAccountAccessor iAccountAccessor, Set<Scope> set) {
        this(3, iAccountAccessor.asBinder(), (Scope[]) set.toArray(new Scope[set.size()]), null, null, null);
    }

    public Account getAccount() {
        Account account = this.f;
        if (account != null) {
            return account;
        }
        IBinder iBinder = this.b;
        if (iBinder == null) {
            return null;
        }
        return AccountAccessor.getAccountBinderSafe(IAccountAccessor.Stub.asInterface(iBinder));
    }

    @Nullable
    public Integer getOauthPolicy() {
        return this.d;
    }

    @Nullable
    public Integer getPolicyAction() {
        return this.e;
    }

    public Set<Scope> getScopes() {
        return new HashSet(Arrays.asList(this.c));
    }

    public AuthAccountRequest setOauthPolicy(@Nullable Integer num) {
        this.d = num;
        return this;
    }

    public AuthAccountRequest setPolicyAction(@Nullable Integer num) {
        this.e = num;
        return this;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.a);
        SafeParcelWriter.writeIBinder(parcel, 2, this.b, false);
        SafeParcelWriter.writeTypedArray(parcel, 3, this.c, i, false);
        SafeParcelWriter.writeIntegerObject(parcel, 4, this.d, false);
        SafeParcelWriter.writeIntegerObject(parcel, 5, this.e, false);
        SafeParcelWriter.writeParcelable(parcel, 6, this.f, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
