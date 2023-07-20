package com.c.a.a;

import cz.msebera.android.httpclient.client.utils.URLEncodedUtils;
import cz.msebera.android.httpclient.message.BasicNameValuePair;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public class m implements Serializable {
    protected final ConcurrentHashMap<String, String> a;
    protected final ConcurrentHashMap<String, Object> b;
    protected final ConcurrentHashMap<String, Object> c;
    protected final ConcurrentHashMap<String, List<Object>> d;
    protected final ConcurrentHashMap<String, Object> e;
    protected String f;

    private List<BasicNameValuePair> a(String str, Object obj) {
        Object obj2;
        LinkedList linkedList = new LinkedList();
        if (obj instanceof Map) {
            Map map = (Map) obj;
            ArrayList arrayList = new ArrayList(map.keySet());
            if (arrayList.size() > 0 && (arrayList.get(0) instanceof Comparable)) {
                Collections.sort(arrayList);
            }
            for (Object obj3 : arrayList) {
                if ((obj3 instanceof String) && (obj2 = map.get(obj3)) != null) {
                    linkedList.addAll(a(str == null ? (String) obj3 : String.format(Locale.US, "%s[%s]", str, obj3), obj2));
                }
            }
        } else if (obj instanceof List) {
            List list = (List) obj;
            int size = list.size();
            for (int i = 0; i < size; i++) {
                linkedList.addAll(a(String.format(Locale.US, "%s[%d]", str, Integer.valueOf(i)), list.get(i)));
            }
        } else if (obj instanceof Object[]) {
            Object[] objArr = (Object[]) obj;
            int length = objArr.length;
            for (int i2 = 0; i2 < length; i2++) {
                linkedList.addAll(a(String.format(Locale.US, "%s[%d]", str, Integer.valueOf(i2)), objArr[i2]));
            }
        } else if (obj instanceof Set) {
            for (Object obj4 : (Set) obj) {
                linkedList.addAll(a(str, obj4));
            }
        } else {
            linkedList.add(new BasicNameValuePair(str, obj.toString()));
        }
        return linkedList;
    }

    protected List<BasicNameValuePair> a() {
        LinkedList linkedList = new LinkedList();
        for (Map.Entry<String, String> entry : this.a.entrySet()) {
            linkedList.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
        }
        linkedList.addAll(a(null, this.e));
        return linkedList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String b() {
        return URLEncodedUtils.format(a(), this.f);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : this.a.entrySet()) {
            if (sb.length() > 0) {
                sb.append("&");
            }
            sb.append(entry.getKey());
            sb.append("=");
            sb.append(entry.getValue());
        }
        for (Map.Entry<String, Object> entry2 : this.b.entrySet()) {
            if (sb.length() > 0) {
                sb.append("&");
            }
            sb.append(entry2.getKey());
            sb.append("=");
            sb.append("STREAM");
        }
        for (Map.Entry<String, Object> entry3 : this.c.entrySet()) {
            if (sb.length() > 0) {
                sb.append("&");
            }
            sb.append(entry3.getKey());
            sb.append("=");
            sb.append("FILE");
        }
        for (Map.Entry<String, List<Object>> entry4 : this.d.entrySet()) {
            if (sb.length() > 0) {
                sb.append("&");
            }
            sb.append(entry4.getKey());
            sb.append("=");
            sb.append("FILES(SIZE=");
            sb.append(entry4.getValue().size());
            sb.append(")");
        }
        for (BasicNameValuePair basicNameValuePair : a(null, this.e)) {
            if (sb.length() > 0) {
                sb.append("&");
            }
            sb.append(basicNameValuePair.getName());
            sb.append("=");
            sb.append(basicNameValuePair.getValue());
        }
        return sb.toString();
    }
}
