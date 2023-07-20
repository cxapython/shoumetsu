package com.google.android.gms.nearby.connection;

import android.os.ParcelFileDescriptor;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.drive.DriveFile;
import java.io.InputStream;
import java.util.UUID;

/* loaded from: classes.dex */
public class Payload {
    private final long a;
    @Type
    private final int b;
    private final byte[] c;
    private final File d;
    private final Stream e;

    /* loaded from: classes.dex */
    public static class File {
        private final java.io.File a;
        private final ParcelFileDescriptor b;
        private final long c;

        private File(java.io.File file, ParcelFileDescriptor parcelFileDescriptor, long j) {
            this.a = file;
            this.b = parcelFileDescriptor;
            this.c = j;
        }

        public static File zza(ParcelFileDescriptor parcelFileDescriptor) {
            return new File(null, (ParcelFileDescriptor) Preconditions.checkNotNull(parcelFileDescriptor, "Cannot create Payload.File from null ParcelFileDescriptor."), parcelFileDescriptor.getStatSize());
        }

        public static File zza(java.io.File file, long j) {
            return new File((java.io.File) Preconditions.checkNotNull(file, "Cannot create Payload.File from null java.io.File."), ParcelFileDescriptor.open(file, DriveFile.MODE_READ_ONLY), j);
        }

        public java.io.File asJavaFile() {
            return this.a;
        }

        public ParcelFileDescriptor asParcelFileDescriptor() {
            return this.b;
        }

        public long getSize() {
            return this.c;
        }
    }

    /* loaded from: classes.dex */
    public static class Stream {
        private final ParcelFileDescriptor a;
        private InputStream b;

        private Stream(ParcelFileDescriptor parcelFileDescriptor, InputStream inputStream) {
            this.a = parcelFileDescriptor;
            this.b = inputStream;
        }

        public static Stream zza(InputStream inputStream) {
            Preconditions.checkNotNull(inputStream, "Cannot create Payload.Stream from null InputStream.");
            return new Stream(null, inputStream);
        }

        public static Stream zzb(ParcelFileDescriptor parcelFileDescriptor) {
            Preconditions.checkNotNull(parcelFileDescriptor, "Cannot create Payload.Stream from null ParcelFileDescriptor.");
            return new Stream(parcelFileDescriptor, null);
        }

        public InputStream asInputStream() {
            if (this.b == null) {
                this.b = new ParcelFileDescriptor.AutoCloseInputStream(this.a);
            }
            return this.b;
        }

        public ParcelFileDescriptor asParcelFileDescriptor() {
            return this.a;
        }
    }

    /* loaded from: classes.dex */
    public @interface Type {
        public static final int BYTES = 1;
        public static final int FILE = 2;
        public static final int STREAM = 3;
    }

    private Payload(long j, int i, byte[] bArr, File file, Stream stream) {
        this.a = j;
        this.b = i;
        this.c = bArr;
        this.d = file;
        this.e = stream;
    }

    public static Payload fromBytes(byte[] bArr) {
        Preconditions.checkNotNull(bArr, "Cannot create a Payload from null bytes.");
        return zza(bArr, UUID.randomUUID().getLeastSignificantBits());
    }

    public static Payload fromFile(ParcelFileDescriptor parcelFileDescriptor) {
        return zza(File.zza(parcelFileDescriptor), UUID.randomUUID().getLeastSignificantBits());
    }

    public static Payload fromFile(java.io.File file) {
        return zza(File.zza(file, file.length()), UUID.randomUUID().getLeastSignificantBits());
    }

    public static Payload fromStream(ParcelFileDescriptor parcelFileDescriptor) {
        return zza(Stream.zzb(parcelFileDescriptor), UUID.randomUUID().getLeastSignificantBits());
    }

    public static Payload fromStream(InputStream inputStream) {
        return zza(Stream.zza(inputStream), UUID.randomUUID().getLeastSignificantBits());
    }

    public static Payload zza(File file, long j) {
        return new Payload(j, 2, null, file, null);
    }

    public static Payload zza(Stream stream, long j) {
        return new Payload(j, 3, null, null, stream);
    }

    public static Payload zza(byte[] bArr, long j) {
        return new Payload(j, 1, bArr, null, null);
    }

    public byte[] asBytes() {
        return this.c;
    }

    public File asFile() {
        return this.d;
    }

    public Stream asStream() {
        return this.e;
    }

    public long getId() {
        return this.a;
    }

    @Type
    public int getType() {
        return this.b;
    }
}
