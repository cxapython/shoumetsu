package com.amazon.device.iap.model;

/* loaded from: classes.dex */
public final class CoinsReward {
    private final int amount;

    protected CoinsReward(int i) {
        this.amount = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static final CoinsReward from(int i) {
        if (i > 0) {
            return new CoinsReward(i);
        }
        return null;
    }

    public int getAmount() {
        return this.amount;
    }
}
