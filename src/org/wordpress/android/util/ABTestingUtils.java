package org.wordpress.android.util;

import android.content.Context;

import com.apptimize.Apptimize;

import org.wordpress.android.BuildConfig;

public class ABTestingUtils {
    // APPTIMIZE_* int constants are defined in the Apptimize web console
    final private static int APPTIMIZE_BASELINE = 0;
    final private static int APPTIMIZE_HELPSHIFT_ENABLED = 1;

    public enum Feature {
        HELPSHIFT
    }

    public static void init(Context context) {
        Apptimize.setup(context, BuildConfig.APPTIMIZE_APP_KEY);
    }

    public static boolean isFeatureEnabled(Feature feature) {
        switch (feature) {
            case HELPSHIFT:
                return Apptimize.integerForTest("Helpshift", 0) == APPTIMIZE_HELPSHIFT_ENABLED;
        }
        return false;
    }
}
