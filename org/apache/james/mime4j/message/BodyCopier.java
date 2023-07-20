package org.apache.james.mime4j.message;

/* loaded from: classes.dex */
public class BodyCopier {
    private BodyCopier() {
    }

    public static Body copy(Body body) {
        if (body != null) {
            if (body instanceof Message) {
                return new Message((Message) body);
            }
            if (body instanceof Multipart) {
                return new Multipart((Multipart) body);
            }
            if (!(body instanceof SingleBody)) {
                throw new IllegalArgumentException("Unsupported body class");
            }
            return ((SingleBody) body).mo66copy();
        }
        throw new IllegalArgumentException("Body is null");
    }
}
