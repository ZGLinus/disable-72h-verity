package com.zglinus.disable72hverify;

import android.content.ComponentName;
import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;   // 导入外部类
import android.content.ComponentName;

public class XposedInit implements IXposedHookLoadPackage {
    @Override
    public void handleLoadPackage(XC_LoadPackage.LoadPackageParam lpparam) throws Throwable {
        if (!"android".equals(lpparam.packageName)) return;

        try {
            XposedHelpers.findAndHookMethod(
                "android.app.admin.DevicePolicyManager",
                lpparam.classLoader,
                "getRequiredStrongAuthTimeout",
                ComponentName.class,
                int.class,
                new XC_MethodHook() {
                    @Override
		    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                         param.setResult(Long.MAX_VALUE);
			 long original = (long) param.getResult();
			 XposedBridge.log("Original timeout: " + original);
                    }
                }
            );
            SystemPropertiesHelper.set("sys.disable72h.status", "active");
            XposedBridge.log("Disable72h: Hook succeeded");
        } catch (Throwable t) {
            SystemPropertiesHelper.set("sys.disable72h.status", "failed");
            XposedBridge.log("Disable72h: Hook failed - " + t.getMessage());
        }
    }
}
