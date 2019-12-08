package com.jbro129.mod.vending;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Environment;
import android.util.Log;

import com.jbro129.mod.QVMProtect;

@QVMProtect
public class Constants
{
    public static final String TAG = "JbroMain";

    public static final String SHARED_PREFS = "com.jbro129.mod.pg3dlauncher";

    public static final String JBRO_PATH = Environment.getExternalStorageDirectory().getAbsolutePath() + "/JbroPG3D/";

    public static final String SUPPORT_EMAIL = "jbropg3dlaunchersupp@gmail.com"; // gmail account deleted

    @QVMProtect
    public final static String PASSWORD = "REMOVED";

    //public final static String REGISTER_URL = "REMOVED";

    //public final static String LOGIN_URL = "REMOVED";

    public final static String REGISTER_V2_URL = "REMOVED";

    public final static String LOGIN_V2_URL = "REMOVED";

    //public final static String SETACC_URL = "REMOVED";

    //public final static String CHECKACC_URL = "REMOVED";

    //public final static String GETSUBS_URL = "REMOVED";

    //public final static String SETSUBS_URL = "REMOVED";

    //public final static String SETINFO_URL = "REMOVED";

    public final static String GETPOINTS_URL = "REMOVED";

    public final static String SETPOINTS_URL = "REMOVED";

    public final static String NOTIF_URL = "REMOVED";

    public final static String UPDATE_URL = "REMOVED";

    public final static String YTURLS_URL = "REMOVED";

    public static void DLog(String log)
    {
        Log.d(Constants.TAG, log);
    }
    public static void ELog(String log)
    {
        Log.e(Constants.TAG, log);
    }

    //@SuppressLint("HardwareIds") public final static String MODEL_ID = Build.MODEL;

    //@SuppressLint("HardwareIds") public final static String SERIAL_ID = Build.SERIAL;

    //@SuppressLint("HardwareIds") public final static String FINGER_ID = Build.FINGERPRINT;
}
