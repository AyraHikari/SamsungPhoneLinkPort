package me.ayra.samsung.mdx.util;

import de.robv.android.xposed.XposedBridge;

public final class Log {

    private final static String TAG = "Ayra-MDX";
    private final static int debug = 1;

    //debug
    public static void d(String tag, String logMesg){
        if(debug == 1)
        XposedBridge.log("[" + TAG + "-"+ tag + "]: " + logMesg);
    }

    //normal
    public static void n(String tag, String logMesg){
        XposedBridge.log("[" + TAG + "-"+ tag + "]: " + logMesg);
    }

    public static void error(String tag, Throwable e){
        XposedBridge.log("[AYRA-MDX-ERROR:-"+ tag + "]: " + e.getLocalizedMessage());
    }
}
