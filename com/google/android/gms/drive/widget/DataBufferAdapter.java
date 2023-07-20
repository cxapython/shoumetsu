package com.google.android.gms.drive.widget;

import android.content.Context;
import android.database.CursorIndexOutOfBoundsException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.google.android.gms.common.data.DataBuffer;
import com.google.android.gms.common.internal.GmsLogger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public class DataBufferAdapter<T> extends BaseAdapter {
    private static final GmsLogger a = new GmsLogger("DataBufferAdapter", "");
    private final Context b;
    private final int c;
    private int d;
    private final int e;
    private final List<DataBuffer<T>> f;
    private final LayoutInflater g;
    private boolean h;

    public DataBufferAdapter(Context context, int i) {
        this(context, i, 0, new ArrayList());
    }

    public DataBufferAdapter(Context context, int i, int i2) {
        this(context, i, i2, new ArrayList());
    }

    public DataBufferAdapter(Context context, int i, int i2, List<DataBuffer<T>> list) {
        this.h = true;
        this.b = context;
        this.d = i;
        this.c = i;
        this.e = i2;
        this.f = list;
        this.g = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    public DataBufferAdapter(Context context, int i, int i2, DataBuffer<T>... dataBufferArr) {
        this(context, i, i2, Arrays.asList(dataBufferArr));
    }

    public DataBufferAdapter(Context context, int i, List<DataBuffer<T>> list) {
        this(context, i, 0, list);
    }

    public DataBufferAdapter(Context context, int i, DataBuffer<T>... dataBufferArr) {
        this(context, i, 0, Arrays.asList(dataBufferArr));
    }

    private final View a(int i, View view, ViewGroup viewGroup, int i2) {
        if (view == null) {
            view = this.g.inflate(i2, viewGroup, false);
        }
        try {
            TextView textView = this.e == 0 ? (TextView) view : (TextView) view.findViewById(this.e);
            T item = getItem(i);
            textView.setText(item instanceof CharSequence ? (CharSequence) item : item.toString());
            return view;
        } catch (ClassCastException e) {
            a.e("DataBufferAdapter", "You must supply a resource ID for a TextView", e);
            throw new IllegalStateException("DataBufferAdapter requires the resource ID to be a TextView", e);
        }
    }

    public void append(DataBuffer<T> dataBuffer) {
        this.f.add(dataBuffer);
        if (this.h) {
            notifyDataSetChanged();
        }
    }

    public void clear() {
        for (DataBuffer<T> dataBuffer : this.f) {
            dataBuffer.release();
        }
        this.f.clear();
        if (this.h) {
            notifyDataSetChanged();
        }
    }

    public Context getContext() {
        return this.b;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        int i = 0;
        for (DataBuffer<T> dataBuffer : this.f) {
            i += dataBuffer.getCount();
        }
        return i;
    }

    @Override // android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public View getDropDownView(int i, View view, ViewGroup viewGroup) {
        return a(i, view, viewGroup, this.d);
    }

    @Override // android.widget.Adapter
    public T getItem(int i) {
        int i2 = i;
        for (DataBuffer<T> dataBuffer : this.f) {
            int count = dataBuffer.getCount();
            if (count > i2) {
                try {
                    return dataBuffer.mo27get(i2);
                } catch (CursorIndexOutOfBoundsException unused) {
                    throw new CursorIndexOutOfBoundsException(i, getCount());
                }
            }
            i2 -= count;
        }
        throw new CursorIndexOutOfBoundsException(i, getCount());
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        return a(i, view, viewGroup, this.c);
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        this.h = true;
    }

    public void setDropDownViewResource(int i) {
        this.d = i;
    }

    public void setNotifyOnChange(boolean z) {
        this.h = z;
    }
}
