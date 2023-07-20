package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;
import com.google.android.gms.analytics.ecommerce.Product;
import com.google.android.gms.analytics.ecommerce.ProductAction;
import com.google.android.gms.analytics.ecommerce.Promotion;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.gtm.zzb;
import com.google.android.gms.internal.gtm.zzl;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@ShowFirstParty
@VisibleForTesting
/* loaded from: classes.dex */
public final class zzgk extends dy {
    private static final String a = com.google.android.gms.internal.gtm.zza.UNIVERSAL_ANALYTICS.toString();
    private static final String b = zzb.ACCOUNT.toString();
    private static final String c = zzb.ANALYTICS_PASS_THROUGH.toString();
    private static final String d = zzb.ENABLE_ECOMMERCE.toString();
    private static final String e = zzb.ECOMMERCE_USE_DATA_LAYER.toString();
    private static final String f = zzb.ECOMMERCE_MACRO_DATA.toString();
    private static final String g = zzb.ANALYTICS_FIELDS.toString();
    private static final String h = zzb.TRACK_TRANSACTION.toString();
    private static final String i = zzb.TRANSACTION_DATALAYER_MAP.toString();
    private static final String j = zzb.TRANSACTION_ITEM_DATALAYER_MAP.toString();
    private static final List<String> k = Arrays.asList(ProductAction.ACTION_DETAIL, ProductAction.ACTION_CHECKOUT, ProductAction.ACTION_CHECKOUT_OPTION, "click", ProductAction.ACTION_ADD, ProductAction.ACTION_REMOVE, ProductAction.ACTION_PURCHASE, ProductAction.ACTION_REFUND);
    private static final Pattern l = Pattern.compile("dimension(\\d+)");
    private static final Pattern m = Pattern.compile("metric(\\d+)");
    private static Map<String, String> n;
    private static Map<String, String> o;
    private final Set<String> p;
    private final zzgf q;
    private final DataLayer r;

    public zzgk(Context context, DataLayer dataLayer) {
        this(context, dataLayer, new zzgf(context));
    }

    @VisibleForTesting
    private zzgk(Context context, DataLayer dataLayer, zzgf zzgfVar) {
        super(a, new String[0]);
        this.r = dataLayer;
        this.q = zzgfVar;
        this.p = new HashSet();
        this.p.add("");
        this.p.add("0");
        this.p.add("false");
    }

    private static Product a(Map<String, Object> map) {
        String str;
        String valueOf;
        String str2;
        Product product = new Product();
        Object obj = map.get("id");
        if (obj != null) {
            product.setId(String.valueOf(obj));
        }
        Object obj2 = map.get(net.gree.gamelib.payment.shop.Product.KEY_NAME);
        if (obj2 != null) {
            product.setName(String.valueOf(obj2));
        }
        Object obj3 = map.get("brand");
        if (obj3 != null) {
            product.setBrand(String.valueOf(obj3));
        }
        Object obj4 = map.get("category");
        if (obj4 != null) {
            product.setCategory(String.valueOf(obj4));
        }
        Object obj5 = map.get("variant");
        if (obj5 != null) {
            product.setVariant(String.valueOf(obj5));
        }
        Object obj6 = map.get("coupon");
        if (obj6 != null) {
            product.setCouponCode(String.valueOf(obj6));
        }
        Object obj7 = map.get("position");
        if (obj7 != null) {
            product.setPosition(b(obj7).intValue());
        }
        Object obj8 = map.get("price");
        if (obj8 != null) {
            product.setPrice(a(obj8).doubleValue());
        }
        Object obj9 = map.get("quantity");
        if (obj9 != null) {
            product.setQuantity(b(obj9).intValue());
        }
        for (String str3 : map.keySet()) {
            Matcher matcher = l.matcher(str3);
            if (matcher.matches()) {
                try {
                    product.setCustomDimension(Integer.parseInt(matcher.group(1)), String.valueOf(map.get(str3)));
                } catch (NumberFormatException unused) {
                    str = "illegal number in custom dimension value: ";
                    valueOf = String.valueOf(str3);
                    if (valueOf.length() == 0) {
                        str2 = new String(str);
                        zzdi.zzac(str2);
                    }
                    str2 = str.concat(valueOf);
                    zzdi.zzac(str2);
                }
            } else {
                Matcher matcher2 = m.matcher(str3);
                if (matcher2.matches()) {
                    try {
                        product.setCustomMetric(Integer.parseInt(matcher2.group(1)), b(map.get(str3)).intValue());
                    } catch (NumberFormatException unused2) {
                        str = "illegal number in custom metric value: ";
                        valueOf = String.valueOf(str3);
                        if (valueOf.length() == 0) {
                            str2 = new String(str);
                            zzdi.zzac(str2);
                        }
                        str2 = str.concat(valueOf);
                        zzdi.zzac(str2);
                    }
                }
            }
        }
        return product;
    }

    private static Double a(Object obj) {
        if (obj instanceof String) {
            try {
                return Double.valueOf((String) obj);
            } catch (NumberFormatException e2) {
                String valueOf = String.valueOf(e2.getMessage());
                throw new RuntimeException(valueOf.length() != 0 ? "Cannot convert the object to Double: ".concat(valueOf) : new String("Cannot convert the object to Double: "));
            }
        } else if (obj instanceof Integer) {
            return Double.valueOf(((Integer) obj).doubleValue());
        } else {
            if (obj instanceof Double) {
                return (Double) obj;
            }
            String valueOf2 = String.valueOf(obj.toString());
            throw new RuntimeException(valueOf2.length() != 0 ? "Cannot convert the object to Double: ".concat(valueOf2) : new String("Cannot convert the object to Double: "));
        }
    }

    private final String a(String str) {
        Object obj = this.r.get(str);
        if (obj == null) {
            return null;
        }
        return obj.toString();
    }

    private static Map<String, String> a(zzl zzlVar) {
        Object zzh = zzgj.zzh(zzlVar);
        if (!(zzh instanceof Map)) {
            return null;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry entry : ((Map) zzh).entrySet()) {
            linkedHashMap.put(entry.getKey().toString(), entry.getValue().toString());
        }
        return linkedHashMap;
    }

    private static void a(Map<String, String> map, String str, String str2) {
        if (str2 != null) {
            map.put(str, str2);
        }
    }

    private static boolean a(Map<String, zzl> map, String str) {
        zzl zzlVar = map.get(str);
        if (zzlVar == null) {
            return false;
        }
        return zzgj.zzg(zzlVar).booleanValue();
    }

    private static Integer b(Object obj) {
        if (obj instanceof String) {
            try {
                return Integer.valueOf((String) obj);
            } catch (NumberFormatException e2) {
                String valueOf = String.valueOf(e2.getMessage());
                throw new RuntimeException(valueOf.length() != 0 ? "Cannot convert the object to Integer: ".concat(valueOf) : new String("Cannot convert the object to Integer: "));
            }
        } else if (obj instanceof Double) {
            return Integer.valueOf(((Double) obj).intValue());
        } else {
            if (obj instanceof Integer) {
                return (Integer) obj;
            }
            String valueOf2 = String.valueOf(obj.toString());
            throw new RuntimeException(valueOf2.length() != 0 ? "Cannot convert the object to Integer: ".concat(valueOf2) : new String("Cannot convert the object to Integer: "));
        }
    }

    private final Map<String, String> b(zzl zzlVar) {
        Map<String, String> a2;
        if (zzlVar != null && (a2 = a(zzlVar)) != null) {
            String str = a2.get("&aip");
            if (str != null && this.p.contains(str.toLowerCase())) {
                a2.remove("&aip");
            }
            return a2;
        }
        return new HashMap();
    }

    @Override // com.google.android.gms.tagmanager.dy, com.google.android.gms.tagmanager.ag
    public final /* bridge */ /* synthetic */ zzl zzb(Map map) {
        return super.zzb(map);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0052, code lost:
        if ((r11 instanceof java.util.Map) != false) goto L144;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0054, code lost:
        r11 = (java.util.Map) r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0057, code lost:
        r11 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0041, code lost:
        if ((r11 instanceof java.util.Map) != false) goto L144;
     */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x017a  */
    @Override // com.google.android.gms.tagmanager.dy
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zzd(Map<String, zzl> map) {
        Map<String, String> map2;
        Map<String, String> map3;
        Map map4;
        String str;
        ProductAction productAction;
        Tracker zzbm = this.q.zzbm("_GTM_DEFAULT_TRACKER_");
        zzbm.enableAdvertisingIdCollection(a(map, "collect_adid"));
        int i2 = 0;
        List<Map> list = null;
        if (!a(map, d)) {
            if (a(map, c)) {
                zzbm.send(b(map.get(g)));
                return;
            } else if (!a(map, h)) {
                zzdi.zzac("Ignoring unknown tag.");
                return;
            } else {
                String a2 = a("transactionId");
                if (a2 == null) {
                    zzdi.zzav("Cannot find transactionId in data layer.");
                    return;
                }
                ArrayList arrayList = new ArrayList();
                try {
                    Map<String, String> b2 = b(map.get(g));
                    b2.put("&t", "transaction");
                    zzl zzlVar = map.get(i);
                    if (zzlVar != null) {
                        map2 = a(zzlVar);
                    } else {
                        if (n == null) {
                            HashMap hashMap = new HashMap();
                            hashMap.put("transactionId", "&ti");
                            hashMap.put("transactionAffiliation", "&ta");
                            hashMap.put("transactionTax", "&tt");
                            hashMap.put("transactionShipping", "&ts");
                            hashMap.put("transactionTotal", "&tr");
                            hashMap.put("transactionCurrency", "&cu");
                            n = hashMap;
                        }
                        map2 = n;
                    }
                    for (Map.Entry<String, String> entry : map2.entrySet()) {
                        a(b2, entry.getValue(), a(entry.getKey()));
                    }
                    arrayList.add(b2);
                    Object obj = this.r.get("transactionProducts");
                    if (obj != null) {
                        if (!(obj instanceof List)) {
                            throw new IllegalArgumentException("transactionProducts should be of type List.");
                        }
                        for (Object obj2 : (List) obj) {
                            if (!(obj2 instanceof Map)) {
                                throw new IllegalArgumentException("Each element of transactionProducts should be of type Map.");
                            }
                        }
                        list = (List) obj;
                    }
                    if (list != null) {
                        for (Map map5 : list) {
                            if (map5.get(net.gree.gamelib.payment.shop.Product.KEY_NAME) == null) {
                                zzdi.zzav("Unable to send transaction item hit due to missing 'name' field.");
                                return;
                            }
                            Map<String, String> b3 = b(map.get(g));
                            b3.put("&t", "item");
                            b3.put("&ti", a2);
                            zzl zzlVar2 = map.get(j);
                            if (zzlVar2 != null) {
                                map3 = a(zzlVar2);
                            } else {
                                if (o == null) {
                                    HashMap hashMap2 = new HashMap();
                                    hashMap2.put(net.gree.gamelib.payment.shop.Product.KEY_NAME, "&in");
                                    hashMap2.put("sku", "&ic");
                                    hashMap2.put("category", "&iv");
                                    hashMap2.put("price", "&ip");
                                    hashMap2.put("quantity", "&iq");
                                    hashMap2.put("currency", "&cu");
                                    o = hashMap2;
                                }
                                map3 = o;
                            }
                            for (Map.Entry<String, String> entry2 : map3.entrySet()) {
                                a(b3, entry2.getValue(), (String) map5.get(entry2.getKey()));
                            }
                            arrayList.add(b3);
                        }
                    }
                    ArrayList arrayList2 = arrayList;
                    int size = arrayList2.size();
                    while (i2 < size) {
                        Object obj3 = arrayList2.get(i2);
                        i2++;
                        zzbm.send((Map) obj3);
                    }
                    return;
                } catch (IllegalArgumentException e2) {
                    zzdi.zza("Unable to send transaction", e2);
                    return;
                }
            }
        }
        HitBuilders.ScreenViewBuilder screenViewBuilder = new HitBuilders.ScreenViewBuilder();
        Map<String, String> b4 = b(map.get(g));
        screenViewBuilder.setAll(b4);
        Object zzh = a(map, e) ? this.r.get("ecommerce") : zzgj.zzh(map.get(f));
        if (map4 != null) {
            String str2 = b4.get("&cu");
            if (str2 == null) {
                str2 = (String) map4.get("currencyCode");
            }
            if (str2 != null) {
                screenViewBuilder.set("&cu", str2);
            }
            Object obj4 = map4.get("impressions");
            if (obj4 instanceof List) {
                for (Map map6 : (List) obj4) {
                    try {
                        screenViewBuilder.addImpression(a((Map<String, Object>) map6), (String) map6.get("list"));
                    } catch (RuntimeException e3) {
                        String valueOf = String.valueOf(e3.getMessage());
                        zzdi.zzav(valueOf.length() != 0 ? "Failed to extract a product from DataLayer. ".concat(valueOf) : new String("Failed to extract a product from DataLayer. "));
                    }
                }
            }
            if (map4.containsKey("promoClick")) {
                str = "promoClick";
            } else {
                if (map4.containsKey("promoView")) {
                    str = "promoView";
                }
                if (list != null) {
                    for (Map map7 : list) {
                        try {
                            Promotion promotion = new Promotion();
                            String str3 = (String) map7.get("id");
                            if (str3 != null) {
                                promotion.setId(String.valueOf(str3));
                            }
                            String str4 = (String) map7.get(net.gree.gamelib.payment.shop.Product.KEY_NAME);
                            if (str4 != null) {
                                promotion.setName(String.valueOf(str4));
                            }
                            String str5 = (String) map7.get("creative");
                            if (str5 != null) {
                                promotion.setCreative(String.valueOf(str5));
                            }
                            String str6 = (String) map7.get("position");
                            if (str6 != null) {
                                promotion.setPosition(String.valueOf(str6));
                            }
                            screenViewBuilder.addPromotion(promotion);
                        } catch (RuntimeException e4) {
                            String valueOf2 = String.valueOf(e4.getMessage());
                            zzdi.zzav(valueOf2.length() != 0 ? "Failed to extract a promotion from DataLayer. ".concat(valueOf2) : new String("Failed to extract a promotion from DataLayer. "));
                        }
                    }
                    if (map4.containsKey("promoClick")) {
                        screenViewBuilder.set("&promoa", "click");
                        if (i2 != 0) {
                            Iterator<String> it = k.iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    break;
                                }
                                String next = it.next();
                                if (map4.containsKey(next)) {
                                    Map map8 = (Map) map4.get(next);
                                    List<Object> list2 = (List) map8.get("products");
                                    if (list2 != null) {
                                        for (Object obj5 : list2) {
                                            try {
                                                screenViewBuilder.addProduct(a((Map<String, Object>) obj5));
                                            } catch (RuntimeException e5) {
                                                String valueOf3 = String.valueOf(e5.getMessage());
                                                zzdi.zzav(valueOf3.length() != 0 ? "Failed to extract a product from DataLayer. ".concat(valueOf3) : new String("Failed to extract a product from DataLayer. "));
                                            }
                                        }
                                    }
                                    try {
                                        if (map8.containsKey("actionField")) {
                                            Map map9 = (Map) map8.get("actionField");
                                            productAction = new ProductAction(next);
                                            Object obj6 = map9.get("id");
                                            if (obj6 != null) {
                                                productAction.setTransactionId(String.valueOf(obj6));
                                            }
                                            Object obj7 = map9.get("affiliation");
                                            if (obj7 != null) {
                                                productAction.setTransactionAffiliation(String.valueOf(obj7));
                                            }
                                            Object obj8 = map9.get("coupon");
                                            if (obj8 != null) {
                                                productAction.setTransactionCouponCode(String.valueOf(obj8));
                                            }
                                            Object obj9 = map9.get("list");
                                            if (obj9 != null) {
                                                productAction.setProductActionList(String.valueOf(obj9));
                                            }
                                            Object obj10 = map9.get("option");
                                            if (obj10 != null) {
                                                productAction.setCheckoutOptions(String.valueOf(obj10));
                                            }
                                            Object obj11 = map9.get("revenue");
                                            if (obj11 != null) {
                                                productAction.setTransactionRevenue(a(obj11).doubleValue());
                                            }
                                            Object obj12 = map9.get("tax");
                                            if (obj12 != null) {
                                                productAction.setTransactionTax(a(obj12).doubleValue());
                                            }
                                            Object obj13 = map9.get("shipping");
                                            if (obj13 != null) {
                                                productAction.setTransactionShipping(a(obj13).doubleValue());
                                            }
                                            Object obj14 = map9.get("step");
                                            if (obj14 != null) {
                                                productAction.setCheckoutStep(b(obj14).intValue());
                                            }
                                        } else {
                                            productAction = new ProductAction(next);
                                        }
                                        screenViewBuilder.setProductAction(productAction);
                                    } catch (RuntimeException e6) {
                                        String valueOf4 = String.valueOf(e6.getMessage());
                                        zzdi.zzav(valueOf4.length() != 0 ? "Failed to extract a product action from DataLayer. ".concat(valueOf4) : new String("Failed to extract a product action from DataLayer. "));
                                    }
                                }
                            }
                        }
                    } else {
                        screenViewBuilder.set("&promoa", Promotion.ACTION_VIEW);
                    }
                }
                i2 = 1;
                if (i2 != 0) {
                }
            }
            list = (List) ((Map) map4.get(str)).get("promotions");
            if (list != null) {
            }
            i2 = 1;
            if (i2 != 0) {
            }
        }
        zzbm.send(screenViewBuilder.build());
    }

    @Override // com.google.android.gms.tagmanager.dy, com.google.android.gms.tagmanager.ag
    public final /* bridge */ /* synthetic */ boolean zzgw() {
        return super.zzgw();
    }

    @Override // com.google.android.gms.tagmanager.ag
    public final /* bridge */ /* synthetic */ String zzif() {
        return super.zzif();
    }

    @Override // com.google.android.gms.tagmanager.ag
    public final /* bridge */ /* synthetic */ Set zzig() {
        return super.zzig();
    }
}
