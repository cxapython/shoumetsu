package net.wrightflyer.shoumetsu;

/* loaded from: classes.dex */
public class AthenaBuild {
    private static Target sTarget = Target.Release;

    /* loaded from: classes.dex */
    public enum Target {
        Debug,
        Develop,
        Internal,
        Exhibition,
        QA,
        Release
    }

    public static Target getTarget() {
        return sTarget;
    }
}
