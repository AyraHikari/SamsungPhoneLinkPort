package me.ayra.samsung.mdx.plugin.base;

import me.ayra.samsung.mdx.BuildConfig;

import de.robv.android.xposed.callbacks.XC_LoadPackage;

public abstract class HookBase {

    static final boolean enableLog = BuildConfig.DEBUG;

    public void hook() {
        if (enableLog) hookLog();
    }

    public void hook(XC_LoadPackage.LoadPackageParam lpparam) {
        if (enableLog) hookLog(lpparam);
    }

    public void hookLog() {
    }

    public void hookLog(XC_LoadPackage.LoadPackageParam lpparam) {
    }
}
