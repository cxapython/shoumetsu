package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.Icon;
import android.os.Build;
import android.os.Parcelable;
import android.util.Log;
import androidx.versionedparcelable.CustomVersionedParcelable;
import cz.msebera.android.httpclient.protocol.HTTP;
import java.io.ByteArrayOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.Charset;

/* loaded from: classes.dex */
public class IconCompat extends CustomVersionedParcelable {
    static final PorterDuff.Mode h = PorterDuff.Mode.SRC_IN;
    public int a;
    Object b;
    public byte[] c;
    public Parcelable d;
    public int e;
    public int f;
    public ColorStateList g = null;
    PorterDuff.Mode i = h;
    public String j;

    private static String a(int i) {
        switch (i) {
            case 1:
                return "BITMAP";
            case 2:
                return "RESOURCE";
            case 3:
                return "DATA";
            case 4:
                return "URI";
            case 5:
                return "BITMAP_MASKABLE";
            default:
                return "UNKNOWN";
        }
    }

    private static String a(Icon icon) {
        if (Build.VERSION.SDK_INT >= 28) {
            return icon.getResPackage();
        }
        try {
            return (String) icon.getClass().getMethod("getResPackage", new Class[0]).invoke(icon, new Object[0]);
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            Log.e("IconCompat", "Unable to get icon package", e);
            return null;
        }
    }

    private static int b(Icon icon) {
        if (Build.VERSION.SDK_INT >= 28) {
            return icon.getResId();
        }
        try {
            return ((Integer) icon.getClass().getMethod("getResId", new Class[0]).invoke(icon, new Object[0])).intValue();
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            Log.e("IconCompat", "Unable to get icon resource", e);
            return 0;
        }
    }

    public String a() {
        if (this.a != -1 || Build.VERSION.SDK_INT < 23) {
            if (this.a == 2) {
                return ((String) this.b).split(":", -1)[0];
            }
            throw new IllegalStateException("called getResPackage() on " + this);
        }
        return a((Icon) this.b);
    }

    @Override // androidx.versionedparcelable.CustomVersionedParcelable
    public void a(boolean z) {
        byte[] byteArray;
        String str;
        this.j = this.i.name();
        int i = this.a;
        if (i != -1) {
            switch (i) {
                case 1:
                case 5:
                    if (z) {
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        ((Bitmap) this.b).compress(Bitmap.CompressFormat.PNG, 90, byteArrayOutputStream);
                        byteArray = byteArrayOutputStream.toByteArray();
                        break;
                    }
                    break;
                case 2:
                    str = (String) this.b;
                    byteArray = str.getBytes(Charset.forName(HTTP.UTF_16));
                    break;
                case 3:
                    byteArray = (byte[]) this.b;
                    break;
                case 4:
                    str = this.b.toString();
                    byteArray = str.getBytes(Charset.forName(HTTP.UTF_16));
                    break;
                default:
                    return;
            }
            this.c = byteArray;
            return;
        } else if (z) {
            throw new IllegalArgumentException("Can't serialize Icon created with IconCompat#createFromIcon");
        }
        this.d = (Parcelable) this.b;
    }

    public int b() {
        if (this.a != -1 || Build.VERSION.SDK_INT < 23) {
            if (this.a == 2) {
                return this.e;
            }
            throw new IllegalStateException("called getResId() on " + this);
        }
        return b((Icon) this.b);
    }

    @Override // androidx.versionedparcelable.CustomVersionedParcelable
    public void c() {
        Object obj;
        this.i = PorterDuff.Mode.valueOf(this.j);
        int i = this.a;
        if (i != -1) {
            switch (i) {
                case 1:
                case 5:
                    obj = this.d;
                    if (obj == null) {
                        byte[] bArr = this.c;
                        this.b = bArr;
                        this.a = 3;
                        this.e = 0;
                        this.f = bArr.length;
                        return;
                    }
                    break;
                case 2:
                case 4:
                    obj = new String(this.c, Charset.forName(HTTP.UTF_16));
                    break;
                case 3:
                    obj = this.c;
                    break;
                default:
                    return;
            }
        } else {
            obj = this.d;
            if (obj == null) {
                throw new IllegalArgumentException("Invalid icon");
            }
        }
        this.b = obj;
    }

    public String toString() {
        int height;
        if (this.a == -1) {
            return String.valueOf(this.b);
        }
        StringBuilder sb = new StringBuilder("Icon(typ=");
        sb.append(a(this.a));
        switch (this.a) {
            case 1:
            case 5:
                sb.append(" size=");
                sb.append(((Bitmap) this.b).getWidth());
                sb.append("x");
                height = ((Bitmap) this.b).getHeight();
                sb.append(height);
                break;
            case 2:
                sb.append(" pkg=");
                sb.append(a());
                sb.append(" id=");
                sb.append(String.format("0x%08x", Integer.valueOf(b())));
                break;
            case 3:
                sb.append(" len=");
                sb.append(this.e);
                if (this.f != 0) {
                    sb.append(" off=");
                    height = this.f;
                    sb.append(height);
                    break;
                }
                break;
            case 4:
                sb.append(" uri=");
                sb.append(this.b);
                break;
        }
        if (this.g != null) {
            sb.append(" tint=");
            sb.append(this.g);
        }
        if (this.i != h) {
            sb.append(" mode=");
            sb.append(this.i);
        }
        sb.append(")");
        return sb.toString();
    }
}
