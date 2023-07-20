package net.gree.gamelib.payment.shop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import net.gree.gamelib.payment.PaymentListener;
import net.gree.gamelib.payment.internal.b.b;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class ProductList extends net.gree.gamelib.payment.internal.b.a {
    protected static final String KEY_PRODUCTS = "products";
    protected static final String KEY_PRODUCT_ID = "product_id";
    protected static final String KEY_WELCOME = "welcome";
    private static final String a = "ProductList";
    protected Product[] mProducts;
    protected int mWelcome;

    /* loaded from: classes.dex */
    protected static class ResponseAdapter extends b<ProductList> {
        public ResponseAdapter(PaymentListener<ProductList> paymentListener) {
            super(ProductList.a, paymentListener);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // net.gree.gamelib.payment.internal.b.b
        /* renamed from: toPaymentResponse  reason: collision with other method in class */
        public ProductList mo54toPaymentResponse(String str) {
            return new ProductList(str);
        }
    }

    protected ProductList(String str) {
        super(str);
        JSONObject entry = getEntry();
        JSONArray jSONArray = entry.getJSONArray(KEY_PRODUCTS);
        int length = jSONArray.length();
        this.mWelcome = entry.getInt(KEY_WELCOME);
        this.mProducts = new Product[length];
        for (int i = 0; i < length; i++) {
            this.mProducts[i] = new Product(jSONArray.getJSONObject(i));
        }
        if (this.mProducts.length > 0) {
            sortProductsWithPriority();
        }
    }

    public Product[] getProducts() {
        return this.mProducts;
    }

    public int getWelcome() {
        return this.mWelcome;
    }

    public void removeProductsNotDefinedInStore(HashMap<String, JSONObject> hashMap) {
        Product[] productArr;
        ArrayList arrayList = new ArrayList(Arrays.asList(this.mProducts));
        for (Product product : this.mProducts) {
            if (hashMap.get(product.getId()) == null) {
                arrayList.remove(product);
            }
        }
        this.mProducts = (Product[]) arrayList.toArray(new Product[arrayList.size()]);
        JSONObject entry = getEntry();
        JSONArray jSONArray = entry.getJSONArray(KEY_PRODUCTS);
        JSONArray jSONArray2 = new JSONArray();
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            if (hashMap.get(jSONArray.getJSONObject(i).getString("product_id")) != null) {
                jSONArray2.put(jSONArray.getJSONObject(i));
            }
        }
        entry.remove(KEY_PRODUCTS);
        entry.put(KEY_PRODUCTS, jSONArray2);
    }

    protected void sortProductsWithPriority() {
        Arrays.sort(this.mProducts, new Comparator<Product>() { // from class: net.gree.gamelib.payment.shop.ProductList.1
            @Override // java.util.Comparator
            /* renamed from: a */
            public int compare(Product product, Product product2) {
                return product.getPriority() - product2.getPriority();
            }
        });
        JSONArray jSONArray = new JSONArray();
        int i = 0;
        while (true) {
            Product[] productArr = this.mProducts;
            if (i >= productArr.length) {
                JSONObject entry = getEntry();
                entry.remove(KEY_PRODUCTS);
                entry.put(KEY_PRODUCTS, jSONArray);
                return;
            }
            jSONArray.put(productArr[i].getJson());
            i++;
        }
    }
}
