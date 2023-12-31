package org.apache.james.mime4j.util;

/* loaded from: classes.dex */
final class EmptyByteSequence implements ByteSequence {
    private static final byte[] EMPTY_BYTES = new byte[0];

    @Override // org.apache.james.mime4j.util.ByteSequence
    public byte byteAt(int i) {
        throw new IndexOutOfBoundsException();
    }

    @Override // org.apache.james.mime4j.util.ByteSequence
    public int length() {
        return 0;
    }

    @Override // org.apache.james.mime4j.util.ByteSequence
    public byte[] toByteArray() {
        return EMPTY_BYTES;
    }
}
