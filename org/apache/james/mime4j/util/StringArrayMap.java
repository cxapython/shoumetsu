package org.apache.james.mime4j.util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

/* loaded from: classes.dex */
public class StringArrayMap implements Serializable {
    private static final long serialVersionUID = -5833051164281786907L;
    private final Map<String, Object> map = new HashMap();

    public static Map<String, String[]> asMap(Map<String, Object> map) {
        HashMap hashMap = new HashMap(map.size());
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            hashMap.put(entry.getKey(), asStringArray(entry.getValue()));
        }
        return Collections.unmodifiableMap(hashMap);
    }

    public static String asString(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof String[]) {
            return ((String[]) obj)[0];
        }
        if (obj instanceof List) {
            return (String) ((List) obj).get(0);
        }
        throw new IllegalStateException("Invalid parameter class: " + obj.getClass().getName());
    }

    public static String[] asStringArray(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof String) {
            return new String[]{(String) obj};
        }
        if (obj instanceof String[]) {
            return (String[]) obj;
        }
        if (obj instanceof List) {
            List list = (List) obj;
            return (String[]) list.toArray(new String[list.size()]);
        }
        throw new IllegalStateException("Invalid parameter class: " + obj.getClass().getName());
    }

    public static Enumeration<String> asStringEnum(final Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof String) {
            return new Enumeration<String>() { // from class: org.apache.james.mime4j.util.StringArrayMap.1
                private Object value;

                {
                    this.value = obj;
                }

                @Override // java.util.Enumeration
                public boolean hasMoreElements() {
                    return this.value != null;
                }

                @Override // java.util.Enumeration
                public String nextElement() {
                    Object obj2 = this.value;
                    if (obj2 != null) {
                        String str = (String) obj2;
                        this.value = null;
                        return str;
                    }
                    throw new NoSuchElementException();
                }
            };
        }
        if (obj instanceof String[]) {
            final String[] strArr = (String[]) obj;
            return new Enumeration<String>() { // from class: org.apache.james.mime4j.util.StringArrayMap.2
                private int offset;

                @Override // java.util.Enumeration
                public boolean hasMoreElements() {
                    return this.offset < strArr.length;
                }

                @Override // java.util.Enumeration
                public String nextElement() {
                    int i = this.offset;
                    String[] strArr2 = strArr;
                    if (i < strArr2.length) {
                        this.offset = i + 1;
                        return strArr2[i];
                    }
                    throw new NoSuchElementException();
                }
            };
        } else if (obj instanceof List) {
            return Collections.enumeration((List) obj);
        } else {
            throw new IllegalStateException("Invalid parameter class: " + obj.getClass().getName());
        }
    }

    protected void addMapValue(Map<String, Object> map, String str, String str2) {
        ArrayList arrayList;
        ArrayList arrayList2;
        Object obj = map.get(str);
        if (obj == null) {
            arrayList2 = str2;
        } else {
            if (obj instanceof String) {
                arrayList = new ArrayList();
                arrayList.add(obj);
            } else if (obj instanceof List) {
                ((List) obj).add(str2);
                arrayList2 = obj;
            } else if (!(obj instanceof String[])) {
                throw new IllegalStateException("Invalid object type: " + obj.getClass().getName());
            } else {
                arrayList = new ArrayList();
                for (String str3 : (String[]) obj) {
                    arrayList.add(str3);
                }
            }
            arrayList.add(str2);
            arrayList2 = arrayList;
        }
        map.put(str, arrayList2);
    }

    public void addValue(String str, String str2) {
        addMapValue(this.map, convertName(str), str2);
    }

    protected String convertName(String str) {
        return str.toLowerCase();
    }

    public Map<String, String[]> getMap() {
        return asMap(this.map);
    }

    public String[] getNameArray() {
        Set<String> keySet = this.map.keySet();
        return (String[]) keySet.toArray(new String[keySet.size()]);
    }

    public Enumeration<String> getNames() {
        return Collections.enumeration(this.map.keySet());
    }

    public String getValue(String str) {
        return asString(this.map.get(convertName(str)));
    }

    public Enumeration<String> getValueEnum(String str) {
        return asStringEnum(this.map.get(convertName(str)));
    }

    public String[] getValues(String str) {
        return asStringArray(this.map.get(convertName(str)));
    }
}
