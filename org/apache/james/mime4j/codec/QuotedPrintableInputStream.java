package org.apache.james.mime4j.codec;

import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/* loaded from: classes.dex */
public class QuotedPrintableInputStream extends InputStream {
    private static Log log = LogFactory.getLog(QuotedPrintableInputStream.class);
    private InputStream stream;
    ByteQueue byteq = new ByteQueue();
    ByteQueue pushbackq = new ByteQueue();
    private byte state = 0;
    private boolean closed = false;

    public QuotedPrintableInputStream(InputStream inputStream) {
        this.stream = inputStream;
    }

    private byte asciiCharToNumericValue(byte b) {
        int i;
        if (b < 48 || b > 57) {
            byte b2 = 65;
            if (b < 65 || b > 90) {
                b2 = 97;
                if (b < 97 || b > 122) {
                    throw new IllegalArgumentException(((char) b) + " is not a hexadecimal digit");
                }
            }
            i = (b - b2) + 10;
        } else {
            i = b - 48;
        }
        return (byte) i;
    }

    private void fillBuffer() {
        byte b;
        byte b2 = 0;
        while (this.byteq.count() == 0) {
            if (this.pushbackq.count() == 0) {
                populatePushbackQueue();
                if (this.pushbackq.count() == 0) {
                    return;
                }
            }
            byte dequeue = this.pushbackq.dequeue();
            switch (this.state) {
                case 0:
                    if (dequeue == 61) {
                        b = 1;
                        this.state = b;
                        break;
                    } else {
                        this.byteq.enqueue(dequeue);
                        break;
                    }
                case 1:
                    if (dequeue != 13) {
                        if ((dequeue >= 48 && dequeue <= 57) || ((dequeue >= 65 && dequeue <= 70) || (dequeue >= 97 && dequeue <= 102))) {
                            this.state = (byte) 3;
                            b2 = dequeue;
                            break;
                        } else if (dequeue != 61) {
                            if (log.isWarnEnabled()) {
                                Log log2 = log;
                                log2.warn("Malformed MIME; expected \\r or [0-9A-Z], got " + ((int) dequeue));
                            }
                            this.state = (byte) 0;
                            this.byteq.enqueue((byte) 61);
                            this.byteq.enqueue(dequeue);
                            break;
                        } else {
                            if (log.isWarnEnabled()) {
                                log.warn("Malformed MIME; got ==");
                            }
                            this.byteq.enqueue((byte) 61);
                            break;
                        }
                    } else {
                        b = 2;
                        this.state = b;
                        break;
                    }
                case 2:
                    if (dequeue != 10) {
                        if (log.isWarnEnabled()) {
                            Log log3 = log;
                            log3.warn("Malformed MIME; expected 10, got " + ((int) dequeue));
                        }
                        this.state = (byte) 0;
                        this.byteq.enqueue((byte) 61);
                        this.byteq.enqueue((byte) 13);
                        this.byteq.enqueue(dequeue);
                        break;
                    } else {
                        this.state = (byte) 0;
                        break;
                    }
                case 3:
                    if ((dequeue >= 48 && dequeue <= 57) || ((dequeue >= 65 && dequeue <= 70) || (dequeue >= 97 && dequeue <= 102))) {
                        byte asciiCharToNumericValue = asciiCharToNumericValue(b2);
                        byte asciiCharToNumericValue2 = asciiCharToNumericValue(dequeue);
                        this.state = (byte) 0;
                        this.byteq.enqueue((byte) (asciiCharToNumericValue2 | (asciiCharToNumericValue << 4)));
                        break;
                    } else {
                        if (log.isWarnEnabled()) {
                            Log log4 = log;
                            log4.warn("Malformed MIME; expected [0-9A-Z], got " + ((int) dequeue));
                        }
                        this.state = (byte) 0;
                        this.byteq.enqueue((byte) 61);
                        this.byteq.enqueue(b2);
                        this.byteq.enqueue(dequeue);
                        break;
                    }
                default:
                    Log log5 = log;
                    log5.error("Illegal state: " + ((int) this.state));
                    this.state = (byte) 0;
                    this.byteq.enqueue(dequeue);
                    break;
            }
        }
    }

    private void populatePushbackQueue() {
        int read;
        if (this.pushbackq.count() != 0) {
            return;
        }
        while (true) {
            read = this.stream.read();
            if (read == -1) {
                this.pushbackq.clear();
                return;
            } else if (read != 13) {
                if (read != 32) {
                    switch (read) {
                        case 9:
                            break;
                        case 10:
                            break;
                        default:
                            this.pushbackq.enqueue((byte) read);
                            return;
                    }
                }
                this.pushbackq.enqueue((byte) read);
            }
        }
        this.pushbackq.clear();
        this.pushbackq.enqueue((byte) read);
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.closed = true;
    }

    @Override // java.io.InputStream
    public int read() {
        if (!this.closed) {
            fillBuffer();
            if (this.byteq.count() == 0) {
                return -1;
            }
            byte dequeue = this.byteq.dequeue();
            return dequeue >= 0 ? dequeue : dequeue & 255;
        }
        throw new IOException("QuotedPrintableInputStream has been closed");
    }
}
