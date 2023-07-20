package com.adjust.sdk.network;

import com.adjust.sdk.ActivityKind;
import com.adjust.sdk.AdjustConfig;
import com.adjust.sdk.Constants;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public class UrlStrategy {
    private static final String BASE_URL_CHINA = "https://app.adjust.world";
    private static final String BASE_URL_EU = "https://app.eu.adjust.com";
    private static final String BASE_URL_INDIA = "https://app.adjust.net.in";
    private static final String GDPR_URL_CHINA = "https://gdpr.adjust.world";
    private static final String GDPR_URL_EU = "https://gdpr.eu.adjust.com";
    private static final String GDPR_URL_INDIA = "https://gdpr.adjust.net.in";
    private static final String SUBSCRIPTION_URL_CHINA = "https://subscription.adjust.world";
    private static final String SUBSCRIPTION_URL_EU = "https://subscription.eu.adjust.com";
    private static final String SUBSCRIPTION_URL_INDIA = "https://subscription.adjust.net.in";
    final List<String> baseUrlChoicesList;
    private final String baseUrlOverwrite;
    final List<String> gdprUrlChoicesList;
    private final String gdprUrlOverwrite;
    final List<String> subscriptionUrlChoicesList;
    private final String subscriptionUrlOverwrite;
    boolean wasLastAttemptSuccess = false;
    int choiceIndex = 0;
    int startingChoiceIndex = 0;
    boolean wasLastAttemptWithOverwrittenUrl = false;

    public UrlStrategy(String str, String str2, String str3, String str4) {
        this.baseUrlOverwrite = str;
        this.gdprUrlOverwrite = str2;
        this.subscriptionUrlOverwrite = str3;
        this.baseUrlChoicesList = baseUrlChoices(str4);
        this.gdprUrlChoicesList = gdprUrlChoices(str4);
        this.subscriptionUrlChoicesList = subscriptionUrlChoices(str4);
    }

    private static List<String> baseUrlChoices(String str) {
        return AdjustConfig.URL_STRATEGY_INDIA.equals(str) ? Arrays.asList(BASE_URL_INDIA, Constants.BASE_URL) : AdjustConfig.URL_STRATEGY_CHINA.equals(str) ? Arrays.asList(BASE_URL_CHINA, Constants.BASE_URL) : AdjustConfig.DATA_RESIDENCY_EU.equals(str) ? Collections.singletonList(BASE_URL_EU) : Arrays.asList(Constants.BASE_URL, BASE_URL_INDIA, BASE_URL_CHINA);
    }

    private static List<String> gdprUrlChoices(String str) {
        return AdjustConfig.URL_STRATEGY_INDIA.equals(str) ? Arrays.asList(GDPR_URL_INDIA, Constants.GDPR_URL) : AdjustConfig.URL_STRATEGY_CHINA.equals(str) ? Arrays.asList(GDPR_URL_CHINA, Constants.GDPR_URL) : AdjustConfig.DATA_RESIDENCY_EU.equals(str) ? Collections.singletonList(GDPR_URL_EU) : Arrays.asList(Constants.GDPR_URL, GDPR_URL_INDIA, GDPR_URL_CHINA);
    }

    private static List<String> subscriptionUrlChoices(String str) {
        return AdjustConfig.URL_STRATEGY_INDIA.equals(str) ? Arrays.asList(SUBSCRIPTION_URL_INDIA, Constants.SUBSCRIPTION_URL) : AdjustConfig.URL_STRATEGY_CHINA.equals(str) ? Arrays.asList(SUBSCRIPTION_URL_CHINA, Constants.SUBSCRIPTION_URL) : AdjustConfig.DATA_RESIDENCY_EU.equals(str) ? Collections.singletonList(SUBSCRIPTION_URL_EU) : Arrays.asList(Constants.SUBSCRIPTION_URL, SUBSCRIPTION_URL_INDIA, SUBSCRIPTION_URL_CHINA);
    }

    public void resetAfterSuccess() {
        this.startingChoiceIndex = this.choiceIndex;
        this.wasLastAttemptSuccess = true;
    }

    public boolean shouldRetryAfterFailure(ActivityKind activityKind) {
        this.wasLastAttemptSuccess = false;
        if (this.wasLastAttemptWithOverwrittenUrl) {
            return false;
        }
        this.choiceIndex = (this.choiceIndex + 1) % (activityKind == ActivityKind.GDPR ? this.gdprUrlChoicesList : activityKind == ActivityKind.SUBSCRIPTION ? this.subscriptionUrlChoicesList : this.baseUrlChoicesList).size();
        return this.choiceIndex != this.startingChoiceIndex;
    }

    public String targetUrlByActivityKind(ActivityKind activityKind) {
        List<String> list;
        if (activityKind == ActivityKind.GDPR) {
            String str = this.gdprUrlOverwrite;
            if (str != null) {
                this.wasLastAttemptWithOverwrittenUrl = true;
                return str;
            }
            this.wasLastAttemptWithOverwrittenUrl = false;
            list = this.gdprUrlChoicesList;
        } else if (activityKind == ActivityKind.SUBSCRIPTION) {
            String str2 = this.subscriptionUrlOverwrite;
            if (str2 != null) {
                this.wasLastAttemptWithOverwrittenUrl = true;
                return str2;
            }
            this.wasLastAttemptWithOverwrittenUrl = false;
            list = this.subscriptionUrlChoicesList;
        } else {
            String str3 = this.baseUrlOverwrite;
            if (str3 != null) {
                this.wasLastAttemptWithOverwrittenUrl = true;
                return str3;
            }
            this.wasLastAttemptWithOverwrittenUrl = false;
            list = this.baseUrlChoicesList;
        }
        return list.get(this.choiceIndex);
    }
}
