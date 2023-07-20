package org.apache.james.mime4j.message;

import java.io.OutputStream;

/* loaded from: classes.dex */
public abstract class SingleBody implements Body {
    private Entity parent = null;

    /* renamed from: copy */
    public SingleBody mo66copy() {
        throw new UnsupportedOperationException();
    }

    @Override // org.apache.james.mime4j.message.Disposable
    public void dispose() {
    }

    @Override // org.apache.james.mime4j.message.Body
    public Entity getParent() {
        return this.parent;
    }

    @Override // org.apache.james.mime4j.message.Body
    public void setParent(Entity entity) {
        this.parent = entity;
    }

    public abstract void writeTo(OutputStream outputStream);
}
