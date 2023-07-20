package com.google.android.gms.games.internal;

import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import java.util.Arrays;
import java.util.Set;

/* loaded from: classes.dex */
public final class zzc {
    public static int zza(Bundle bundle) {
        int size;
        int hashCode;
        int i;
        int hashCode2;
        Object[] objArr;
        int hashCode3;
        if (bundle == null || (size = bundle.size()) == 0) {
            return 0;
        }
        String[] strArr = (String[]) bundle.keySet().toArray(new String[size]);
        Arrays.sort(strArr);
        int i2 = 1;
        for (String str : strArr) {
            i2 *= 31;
            Object obj = bundle.get(str);
            if (obj != null) {
                if (obj instanceof Bundle) {
                    hashCode = zza((Bundle) obj);
                } else if (obj instanceof byte[]) {
                    hashCode = Arrays.hashCode((byte[]) obj);
                } else if (obj instanceof char[]) {
                    hashCode = Arrays.hashCode((char[]) obj);
                } else if (obj instanceof short[]) {
                    hashCode = Arrays.hashCode((short[]) obj);
                } else if (obj instanceof float[]) {
                    hashCode = Arrays.hashCode((float[]) obj);
                } else if (obj instanceof CharSequence[]) {
                    hashCode = Arrays.hashCode((CharSequence[]) obj);
                } else {
                    if (obj instanceof Object[]) {
                        i = 1;
                        for (Object obj2 : (Object[]) obj) {
                            i *= 31;
                            if (obj2 instanceof Bundle) {
                                hashCode3 = zza((Bundle) obj2);
                            } else if (obj2 != null) {
                                hashCode3 = obj2.hashCode();
                            }
                            i += hashCode3;
                        }
                    } else if (obj instanceof SparseArray) {
                        SparseArray sparseArray = (SparseArray) obj;
                        int size2 = sparseArray.size();
                        i = 1;
                        for (int i3 = 0; i3 < size2; i3++) {
                            i = ((i * 31) + sparseArray.keyAt(i3)) * 31;
                            Object valueAt = sparseArray.valueAt(i3);
                            if (valueAt instanceof Bundle) {
                                hashCode2 = zza((Bundle) valueAt);
                            } else if (valueAt != null) {
                                hashCode2 = valueAt.hashCode();
                            }
                            i += hashCode2;
                        }
                    } else {
                        hashCode = obj.hashCode();
                    }
                    i2 += i;
                }
                i2 += hashCode;
            }
        }
        return i2;
    }

    /* JADX WARN: Removed duplicated region for block: B:158:0x00f4 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:162:0x014a A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:169:0x0029 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:170:0x0029 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean zza(Bundle bundle, Bundle bundle2) {
        boolean z;
        boolean z2;
        if (bundle == bundle2) {
            return true;
        }
        if (bundle == null || bundle2 == null || bundle.size() != bundle2.size()) {
            return false;
        }
        Set<String> keySet = bundle.keySet();
        if (!keySet.equals(bundle2.keySet())) {
            return false;
        }
        for (String str : keySet) {
            Object obj = bundle.get(str);
            Object obj2 = bundle2.get(str);
            if (obj == null) {
                if (obj2 != null) {
                    return false;
                }
            } else if (obj instanceof Bundle) {
                if (!(obj2 instanceof Bundle) || !zza((Bundle) obj, (Bundle) obj2)) {
                    return false;
                }
            } else if (obj instanceof byte[]) {
                if (!(obj2 instanceof byte[]) || !Arrays.equals((byte[]) obj, (byte[]) obj2)) {
                    return false;
                }
            } else if (obj instanceof char[]) {
                if (!(obj2 instanceof char[]) || !Arrays.equals((char[]) obj, (char[]) obj2)) {
                    return false;
                }
            } else if (obj instanceof short[]) {
                if (!(obj2 instanceof short[]) || !Arrays.equals((short[]) obj, (short[]) obj2)) {
                    return false;
                }
            } else if (obj instanceof float[]) {
                if (!(obj2 instanceof float[]) || !Arrays.equals((float[]) obj, (float[]) obj2)) {
                    return false;
                }
            } else if (obj instanceof CharSequence[]) {
                if (!(obj2 instanceof CharSequence[]) || !Arrays.equals((CharSequence[]) obj, (CharSequence[]) obj2)) {
                    return false;
                }
            } else if (obj instanceof Object[]) {
                if (obj2 instanceof Object[]) {
                    Parcelable[] parcelableArr = (Parcelable[]) obj;
                    Parcelable[] parcelableArr2 = (Parcelable[]) obj2;
                    if (parcelableArr != parcelableArr2) {
                        int length = parcelableArr.length;
                        if (parcelableArr2.length == length) {
                            for (int i = 0; i < length; i++) {
                                Parcelable parcelable = parcelableArr[i];
                                Parcelable parcelable2 = parcelableArr2[i];
                                if (parcelable == null) {
                                    if (parcelable2 == null) {
                                    }
                                } else if (parcelable instanceof Bundle) {
                                    if ((parcelable2 instanceof Bundle) && zza((Bundle) parcelable, (Bundle) parcelable2)) {
                                    }
                                } else if (parcelable.equals(parcelable2)) {
                                }
                            }
                        }
                        z = false;
                        if (z) {
                        }
                    }
                    z = true;
                    if (z) {
                    }
                }
                return false;
            } else if (obj instanceof SparseArray) {
                if (obj2 instanceof SparseArray) {
                    SparseArray sparseArray = (SparseArray) obj;
                    SparseArray sparseArray2 = (SparseArray) obj2;
                    if (sparseArray != sparseArray2) {
                        int size = sparseArray.size();
                        if (sparseArray2.size() == size) {
                            for (int i2 = 0; i2 < size; i2++) {
                                if (sparseArray.keyAt(i2) == sparseArray2.keyAt(i2)) {
                                    Object valueAt = sparseArray.valueAt(i2);
                                    Object valueAt2 = sparseArray2.valueAt(i2);
                                    if (valueAt == null) {
                                        if (valueAt2 == null) {
                                        }
                                    } else if (valueAt instanceof Bundle) {
                                        if ((valueAt2 instanceof Bundle) && zza((Bundle) valueAt, (Bundle) valueAt2)) {
                                        }
                                    } else if (valueAt.equals(valueAt2)) {
                                    }
                                }
                            }
                        }
                        z2 = false;
                        if (z2) {
                        }
                    }
                    z2 = true;
                    if (z2) {
                    }
                }
                return false;
            } else if (!obj.equals(obj2)) {
                return false;
            }
        }
        return true;
    }
}
