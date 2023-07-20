package net.gree.gamelib.payment;

import net.gree.gamelib.payment.internal.b.b;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class AgeVerification extends net.gree.gamelib.payment.internal.b.a {
    public static final int AGE_GROUP_ADULT = 3;
    public static final int AGE_GROUP_MINOR_JUNIOR = 1;
    public static final int AGE_GROUP_MINOR_SENIOR = 2;
    public static final int AGE_GROUP_UNSUBMITTED = 0;
    protected static final String KEY_AGE_GROUP = "age_group";
    protected static final String KEY_BIRTHDAY = "birthday";
    protected static final String KEY_LIMIT = "limit";
    private static final String a = "AgeVerification";
    protected int mAgeGroup;
    protected String mBirthday;
    protected JSONObject mEntry;
    protected double mLimit;

    /* loaded from: classes.dex */
    protected static class ResponseAdapter extends b<AgeVerification> {
        public ResponseAdapter(PaymentListener<AgeVerification> paymentListener) {
            super(AgeVerification.a, paymentListener);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // net.gree.gamelib.payment.internal.b.b
        /* renamed from: toPaymentResponse */
        public AgeVerification mo54toPaymentResponse(String str) {
            return new AgeVerification(str);
        }
    }

    protected AgeVerification(String str) {
        super(str);
        this.mEntry = getEntry();
        this.mAgeGroup = this.mEntry.getInt(KEY_AGE_GROUP);
        this.mBirthday = this.mEntry.optString(KEY_BIRTHDAY);
        this.mLimit = this.mEntry.getDouble("limit");
    }

    public int getAgeGroup() {
        return this.mAgeGroup;
    }

    public String getBirthday() {
        return this.mBirthday;
    }

    public double getLimit() {
        return this.mLimit;
    }
}
