package net.gree.gamelib.payment.internal.a;

/* loaded from: classes.dex */
public class d extends Exception {
    private static final long serialVersionUID = -708437134258254263L;
    f a;

    public d(int i, String str) {
        this(new f(i, str));
    }

    public d(int i, String str, Exception exc) {
        this(new f(i, str), exc);
    }

    protected d(f fVar) {
        this(fVar, (Exception) null);
    }

    protected d(f fVar, Exception exc) {
        super(fVar.b(), exc);
        this.a = fVar;
    }

    public f a() {
        return this.a;
    }
}
