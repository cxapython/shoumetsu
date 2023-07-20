package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.util.VisibleForTesting;
import cz.msebera.android.httpclient.impl.client.cache.CacheConfig;

@ShowFirstParty
@VisibleForTesting
/* loaded from: classes.dex */
public final class zzby {
    private static zzbz<Integer> g;
    private static zzbz<Long> h;
    private static zzbz<String> i;
    private static zzbz<Integer> j;
    private static zzbz<Long> k;
    private static zzbz<Long> l;
    public static zzbz<String> zzaaa;
    public static zzbz<Integer> zzaab;
    public static zzbz<Integer> zzaad;
    public static zzbz<Integer> zzaae;
    public static zzbz<Long> zzaaf;
    public static zzbz<Boolean> zzaai;
    public static zzbz<Long> zzaaj;
    public static zzbz<Long> zzaak;
    public static zzbz<Long> zzaan;
    public static zzbz<Long> zzaao;
    public static zzbz<Long> zzaap;
    public static zzbz<Boolean> zzaaq;
    public static zzbz<String> zzzv;
    public static zzbz<Integer> zzzx;
    public static zzbz<Integer> zzzy;
    public static zzbz<Integer> zzzz;
    private static zzbz<Boolean> a = zzbz.a("analytics.service_enabled", false, false);
    public static zzbz<Boolean> zzza = zzbz.a("analytics.service_client_enabled", true, true);
    public static zzbz<String> zzzb = zzbz.a("analytics.log_tag", "GAv4", "GAv4-SVC");
    private static zzbz<Long> b = zzbz.a("analytics.max_tokens", 60L, 60L);
    private static zzbz<Float> c = zzbz.a("analytics.tokens_per_sec", 0.5f, 0.5f);
    public static zzbz<Integer> zzze = zzbz.a("analytics.max_stored_hits", 2000, 20000);
    private static zzbz<Integer> d = zzbz.a("analytics.max_stored_hits_per_app", 2000, 2000);
    public static zzbz<Integer> zzzg = zzbz.a("analytics.max_stored_properties_per_app", 100, 100);
    public static zzbz<Long> zzzh = zzbz.a("analytics.local_dispatch_millis", 1800000L, 120000L);
    public static zzbz<Long> zzzi = zzbz.a("analytics.initial_local_dispatch_millis", 5000L, 5000L);
    private static zzbz<Long> e = zzbz.a("analytics.min_local_dispatch_millis", 120000L, 120000L);
    private static zzbz<Long> f = zzbz.a("analytics.max_local_dispatch_millis", 7200000L, 7200000L);
    public static zzbz<Long> zzzl = zzbz.a("analytics.dispatch_alarm_millis", 7200000L, 7200000L);
    public static zzbz<Long> zzzm = zzbz.a("analytics.max_dispatch_alarm_millis", 32400000L, 32400000L);
    public static zzbz<Integer> zzzn = zzbz.a("analytics.max_hits_per_dispatch", 20, 20);
    public static zzbz<Integer> zzzo = zzbz.a("analytics.max_hits_per_batch", 20, 20);
    public static zzbz<String> zzzp = zzbz.a("analytics.insecure_host", "http://www.google-analytics.com", "http://www.google-analytics.com");
    public static zzbz<String> zzzq = zzbz.a("analytics.secure_host", "https://ssl.google-analytics.com", "https://ssl.google-analytics.com");
    public static zzbz<String> zzzr = zzbz.a("analytics.simple_endpoint", "/collect", "/collect");
    public static zzbz<String> zzzs = zzbz.a("analytics.batching_endpoint", "/batch", "/batch");
    public static zzbz<Integer> zzzt = zzbz.a("analytics.max_get_length", 2036, 2036);
    public static zzbz<String> zzzu = zzbz.a("analytics.batching_strategy.k", zzbg.BATCH_BY_COUNT.name(), zzbg.BATCH_BY_COUNT.name());

    static {
        String name = zzbm.GZIP.name();
        zzzv = zzbz.a("analytics.compression_strategy.k", name, name);
        g = zzbz.a("analytics.max_hits_per_request.k", 20, 20);
        zzzx = zzbz.a("analytics.max_hit_length.k", (int) CacheConfig.DEFAULT_MAX_OBJECT_SIZE_BYTES, (int) CacheConfig.DEFAULT_MAX_OBJECT_SIZE_BYTES);
        zzzy = zzbz.a("analytics.max_post_length.k", (int) CacheConfig.DEFAULT_MAX_OBJECT_SIZE_BYTES, (int) CacheConfig.DEFAULT_MAX_OBJECT_SIZE_BYTES);
        zzzz = zzbz.a("analytics.max_batch_post_length", (int) CacheConfig.DEFAULT_MAX_OBJECT_SIZE_BYTES, (int) CacheConfig.DEFAULT_MAX_OBJECT_SIZE_BYTES);
        zzaaa = zzbz.a("analytics.fallback_responses.k", "404,502", "404,502");
        zzaab = zzbz.a("analytics.batch_retry_interval.seconds.k", 3600, 3600);
        h = zzbz.a("analytics.service_monitor_interval", 86400000L, 86400000L);
        zzaad = zzbz.a("analytics.http_connection.connect_timeout_millis", 60000, 60000);
        zzaae = zzbz.a("analytics.http_connection.read_timeout_millis", 61000, 61000);
        zzaaf = zzbz.a("analytics.campaigns.time_limit", 86400000L, 86400000L);
        i = zzbz.a("analytics.first_party_experiment_id", "", "");
        j = zzbz.a("analytics.first_party_experiment_variant", 0, 0);
        zzaai = zzbz.a("analytics.test.disable_receiver", false, false);
        zzaaj = zzbz.a("analytics.service_client.idle_disconnect_millis", 10000L, 10000L);
        zzaak = zzbz.a("analytics.service_client.connect_timeout_millis", 5000L, 5000L);
        k = zzbz.a("analytics.service_client.second_connect_delay_millis", 5000L, 5000L);
        l = zzbz.a("analytics.service_client.unexpected_reconnect_millis", 60000L, 60000L);
        zzaan = zzbz.a("analytics.service_client.reconnect_throttle_millis", 1800000L, 1800000L);
        zzaao = zzbz.a("analytics.monitoring.sample_period_millis", 86400000L, 86400000L);
        zzaap = zzbz.a("analytics.initialization_warning_threshold", 5000L, 5000L);
        zzaaq = zzbz.a("analytics.gcm_task_service", false, false);
    }
}
