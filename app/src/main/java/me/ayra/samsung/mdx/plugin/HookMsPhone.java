package me.ayra.samsung.mdx.plugin;

import android.annotation.SuppressLint;

import me.ayra.samsung.mdx.plugin.base.HookBase;
import me.ayra.samsung.mdx.util.Log;

import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XC_MethodReplacement;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

public class HookMsPhone extends HookBase {

    private static final String tag = "AyraDebug";

    @Override
    public void hook(XC_LoadPackage.LoadPackageParam lpparam) {
        super.hook(lpparam);
        hookClass(lpparam);
    }

    @SuppressLint("PrivateApi")
    private void hookClass(XC_LoadPackage.LoadPackageParam lpparam) {
        Class<?> clazz;
        try {
            String className = "com.samsung.android.sdk.mdx.windowslink.deviceinfo.DeviceInfo";
            clazz = lpparam.classLoader.loadClass(className);
            XposedHelpers.findAndHookMethod(clazz, "isTablet", new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                    param.setResult(false);
                }
            });

            Log.d(tag, "Hook mdx 1 ok!");

            String className2 = "com.samsung.android.sdk.mdx.windowslink.bluetoothtransport.PackageSignatureChecker";
            clazz = lpparam.classLoader.loadClass(className2);
            XposedHelpers.findAndHookMethod(clazz, "isShipBuild", new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                    param.setResult(true);
                }
            });

            Log.d(tag, "Hook mdx 2 ok!");

            String className3 = "com.samsung.android.sdk.mdx.windowslink.messaging.RcsChecker";
            clazz = lpparam.classLoader.loadClass(className3);
            XposedHelpers.findAndHookMethod(clazz, "setRcsMessageListener", "android.content.Context", "com.samsung.android.sdk.mdx.windowslink.messaging.RcsChecker$RcsMessageListener", new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                    param.setResult(null);
                }
            });

            Log.d(tag, "Hook mdx 3 ok!");
        } catch (Exception e) {
            Log.d(tag, "Hook mdx error!");
            Log.error(tag, e);
        }
    }

}
