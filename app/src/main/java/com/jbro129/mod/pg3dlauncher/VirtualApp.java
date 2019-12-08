package com.jbro129.mod.pg3dlauncher;

import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;

import com.lody.virtual.client.core.InstallStrategy;
import com.lody.virtual.client.core.VirtualCore;
import com.lody.virtual.client.stub.VASettings;
import com.lody.virtual.remote.InstallResult;

import java.util.Arrays;
import java.util.List;


public class VirtualApp
  extends Application
{
  protected void attachBaseContext(Context paramContext)
  {
    super.attachBaseContext(paramContext);
    //com.lody.virtual.client.stub.StubManifest.ENABLE_IO_REDIRECT = true;
    //com.lody.virtual.client.stub.StubManifest.ENABLE_INNER_SHORTCUT = false;
    //com.lody.virtual.client.stub.StubManifest.ENABLE_GMS = true;
    VASettings.ENABLE_IO_REDIRECT = true;
    VASettings.ENABLE_INNER_SHORTCUT = true;
    VASettings.INTERCEPT_BACK_HOME = true;
    try
    {
      VirtualCore.get().startup(paramContext);
      return;
    }
    catch (Throwable paramContext1)
    {
      paramContext1.printStackTrace();
    }
  }

  @Override
  public void onCreate()
  {
    super.onCreate();
    //installGms();
  }


  private static final String[] GMS_PKG = {
          "com.google.android.gsf",
          "com.google.android.gsf.login",
          "com.google.android.gms",
          "com.android.vending"
  };

  private void installGms() {
    PackageManager pm = VirtualCore.get().getUnHookPackageManager();
    for (String pkg : GMS_PKG) {
      try {
        ApplicationInfo appInfo = pm.getApplicationInfo(pkg, 0);
        String apkPath = appInfo.sourceDir;
        VirtualCore.get().installPackage(apkPath,
                InstallStrategy.DEPEND_SYSTEM_IF_EXIST | InstallStrategy.TERMINATE_IF_EXIST);
      } catch (Throwable e) {
        e.printStackTrace();
      }
    }
  }

}
