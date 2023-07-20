package com.google.android.gms.internal.gtm;

import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.text.TextUtils;
import com.google.android.gms.internal.gtm.v;
import java.io.IOException;
import java.util.Locale;
import net.gree.gamelib.payment.shop.Product;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w<T extends v> extends zzam {
    private zzbp<T> a;

    public w(zzap zzapVar, zzbp<T> zzbpVar) {
        super(zzapVar);
        this.a = zzbpVar;
    }

    private final T a(XmlResourceParser xmlResourceParser) {
        String trim;
        String str;
        try {
            xmlResourceParser.next();
            int eventType = xmlResourceParser.getEventType();
            while (eventType != 1) {
                if (xmlResourceParser.getEventType() == 2) {
                    String lowerCase = xmlResourceParser.getName().toLowerCase(Locale.US);
                    if (lowerCase.equals("screenname")) {
                        String attributeValue = xmlResourceParser.getAttributeValue(null, Product.KEY_NAME);
                        String trim2 = xmlResourceParser.nextText().trim();
                        if (!TextUtils.isEmpty(attributeValue) && !TextUtils.isEmpty(trim2)) {
                            this.a.zzb(attributeValue, trim2);
                        }
                    } else if (lowerCase.equals("string")) {
                        String attributeValue2 = xmlResourceParser.getAttributeValue(null, Product.KEY_NAME);
                        String trim3 = xmlResourceParser.nextText().trim();
                        if (!TextUtils.isEmpty(attributeValue2) && trim3 != null) {
                            this.a.zzc(attributeValue2, trim3);
                        }
                    } else if (lowerCase.equals("bool")) {
                        String attributeValue3 = xmlResourceParser.getAttributeValue(null, Product.KEY_NAME);
                        trim = xmlResourceParser.nextText().trim();
                        if (!TextUtils.isEmpty(attributeValue3) && !TextUtils.isEmpty(trim)) {
                            try {
                                this.a.zza(attributeValue3, Boolean.parseBoolean(trim));
                            } catch (NumberFormatException e) {
                                e = e;
                                str = "Error parsing bool configuration value";
                                zzc(str, trim, e);
                                eventType = xmlResourceParser.next();
                            }
                        }
                    } else if (lowerCase.equals("integer")) {
                        String attributeValue4 = xmlResourceParser.getAttributeValue(null, Product.KEY_NAME);
                        trim = xmlResourceParser.nextText().trim();
                        if (!TextUtils.isEmpty(attributeValue4) && !TextUtils.isEmpty(trim)) {
                            try {
                                this.a.zzb(attributeValue4, Integer.parseInt(trim));
                            } catch (NumberFormatException e2) {
                                e = e2;
                                str = "Error parsing int configuration value";
                                zzc(str, trim, e);
                                eventType = xmlResourceParser.next();
                            }
                        }
                    }
                }
                eventType = xmlResourceParser.next();
            }
        } catch (IOException | XmlPullParserException e3) {
            zze("Error parsing tracker configuration file", e3);
        }
        return this.a.zzel();
    }

    public final T zzq(int i) {
        try {
            return a(zzcm().zzdc().getResources().getXml(i));
        } catch (Resources.NotFoundException e) {
            zzd("inflate() called with unknown resourceId", e);
            return null;
        }
    }
}
