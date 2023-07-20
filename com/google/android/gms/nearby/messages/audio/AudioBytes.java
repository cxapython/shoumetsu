package com.google.android.gms.nearby.messages.audio;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.nearby.messages.Message;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class AudioBytes {
    public static final int MAX_SIZE = 10;
    private final byte[] a;

    public AudioBytes(byte[] bArr) {
        Preconditions.checkNotNull(bArr);
        boolean z = true;
        Preconditions.checkArgument(bArr.length <= 10, "Given byte array longer than 10 bytes, given by AudioBytes.MAX_SIZE.");
        Preconditions.checkArgument(bArr.length <= 0 ? false : z, "Given byte array is of zero length.");
        this.a = bArr;
    }

    public static AudioBytes from(Message message) {
        Preconditions.checkNotNull(message);
        boolean zzl = message.zzl(Message.MESSAGE_TYPE_AUDIO_BYTES);
        String type = message.getType();
        StringBuilder sb = new StringBuilder(String.valueOf(type).length() + 56);
        sb.append("Message type '");
        sb.append(type);
        sb.append("' is not Message.MESSAGE_TYPE_AUDIO_BYTES.");
        Preconditions.checkArgument(zzl, sb.toString());
        return new AudioBytes(message.getContent());
    }

    public final byte[] getBytes() {
        return this.a;
    }

    public final Message toMessage() {
        return new Message(this.a, Message.MESSAGE_NAMESPACE_RESERVED, Message.MESSAGE_TYPE_AUDIO_BYTES);
    }

    public final String toString() {
        String arrays = Arrays.toString(this.a);
        StringBuilder sb = new StringBuilder(String.valueOf(arrays).length() + 14);
        sb.append("AudioBytes [");
        sb.append(arrays);
        sb.append(" ]");
        return sb.toString();
    }
}
