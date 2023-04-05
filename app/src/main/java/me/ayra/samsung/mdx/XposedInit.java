package me.ayra.samsung.mdx;

import me.ayra.samsung.mdx.plugin.HookMsPhone;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

public class XposedInit implements IXposedHookLoadPackage {

    @Override
    public void handleLoadPackage(XC_LoadPackage.LoadPackageParam lpparam) {
        new HookMsPhone().hook(lpparam);
    }
}