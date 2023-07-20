package org.apache.james.mime4j.storage;

import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes.dex */
public class CipherStorageProvider extends AbstractStorageProvider {
    private final String algorithm;
    private final StorageProvider backend;
    private final KeyGenerator keygen;

    /* loaded from: classes.dex */
    private static final class CipherStorage implements Storage {
        private final String algorithm;
        private Storage encrypted;
        private final SecretKeySpec skeySpec;

        public CipherStorage(Storage storage, String str, SecretKeySpec secretKeySpec) {
            this.encrypted = storage;
            this.algorithm = str;
            this.skeySpec = secretKeySpec;
        }

        @Override // org.apache.james.mime4j.storage.Storage
        public void delete() {
            Storage storage = this.encrypted;
            if (storage != null) {
                storage.delete();
                this.encrypted = null;
            }
        }

        @Override // org.apache.james.mime4j.storage.Storage
        public InputStream getInputStream() {
            if (this.encrypted != null) {
                try {
                    Cipher cipher = Cipher.getInstance(this.algorithm);
                    cipher.init(2, this.skeySpec);
                    return new CipherInputStream(this.encrypted.getInputStream(), cipher);
                } catch (GeneralSecurityException e) {
                    throw ((IOException) new IOException().initCause(e));
                }
            }
            throw new IllegalStateException("storage has been deleted");
        }
    }

    /* loaded from: classes.dex */
    private static final class CipherStorageOutputStream extends StorageOutputStream {
        private final String algorithm;
        private final CipherOutputStream cipherOut;
        private final SecretKeySpec skeySpec;
        private final StorageOutputStream storageOut;

        public CipherStorageOutputStream(StorageOutputStream storageOutputStream, String str, SecretKeySpec secretKeySpec) {
            try {
                this.storageOut = storageOutputStream;
                this.algorithm = str;
                this.skeySpec = secretKeySpec;
                Cipher cipher = Cipher.getInstance(str);
                cipher.init(1, secretKeySpec);
                this.cipherOut = new CipherOutputStream(storageOutputStream, cipher);
            } catch (GeneralSecurityException e) {
                throw ((IOException) new IOException().initCause(e));
            }
        }

        @Override // org.apache.james.mime4j.storage.StorageOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            super.close();
            this.cipherOut.close();
        }

        @Override // org.apache.james.mime4j.storage.StorageOutputStream
        protected Storage toStorage0() {
            return new CipherStorage(this.storageOut.toStorage(), this.algorithm, this.skeySpec);
        }

        @Override // org.apache.james.mime4j.storage.StorageOutputStream
        protected void write0(byte[] bArr, int i, int i2) {
            this.cipherOut.write(bArr, i, i2);
        }
    }

    public CipherStorageProvider(StorageProvider storageProvider) {
        this(storageProvider, "Blowfish");
    }

    public CipherStorageProvider(StorageProvider storageProvider, String str) {
        if (storageProvider != null) {
            try {
                this.backend = storageProvider;
                this.algorithm = str;
                this.keygen = KeyGenerator.getInstance(str);
                return;
            } catch (NoSuchAlgorithmException e) {
                throw new IllegalArgumentException(e);
            }
        }
        throw new IllegalArgumentException();
    }

    private SecretKeySpec getSecretKeySpec() {
        return new SecretKeySpec(this.keygen.generateKey().getEncoded(), this.algorithm);
    }

    @Override // org.apache.james.mime4j.storage.StorageProvider
    public StorageOutputStream createStorageOutputStream() {
        return new CipherStorageOutputStream(this.backend.createStorageOutputStream(), this.algorithm, getSecretKeySpec());
    }
}
