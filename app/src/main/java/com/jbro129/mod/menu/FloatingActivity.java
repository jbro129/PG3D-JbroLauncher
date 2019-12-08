package com.jbro129.mod.menu;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.jbro129.mod.Loader;
import com.jbro129.mod.pg3dlauncher.MainActivity;
import com.jbro129.mod.pg3dlauncher.R;
import com.lody.virtual.client.core.VirtualCore;

import java.io.RandomAccessFile;
import java.lang.reflect.Method;

import static android.view.Gravity.LEFT;

public class FloatingActivity
  extends Service
{
  private static Method method;
  //private static Method method1;
  private static Object ob;
  //private static Object ob1;
  private String htmltxt;
  public View mFloatingView;
  private LinearLayout patches;
  private WindowManager windowManager;
  private static Context ctx;

  private int getResID(String name,String type){
    return getResources().getIdentifier(name, type, getPackageName());
  }
  private int getLayout(String name){
    return getResID(name,"layout");
  }

  private int getID(String name){
    return getResID(name,"id");
  }
  public static String hex(int n) {
    return String.format("%2s", new Object[]{Integer.toHexString(n)}).replace(' ', '0');
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    return null;
  }

  public void onCreate() {
    super.onCreate();
    this.windowManager = (WindowManager) getSystemService(WINDOW_SERVICE);
    this.mFloatingView = LayoutInflater.from(this).inflate(R.layout.activity_floating, null);
    this.htmltxt = "<html><head><style>body{font-size: 12;color: blue;font-weight:bold;font-family:Courier, monospace;}</style></head><body><marquee class=\"GeneratedMarquee\" direction=\"left\" scrollamount=\"5\" behavior=\"scroll\">Pixel Gun 3D Mod Menu By Jbro129 %26 KMODs</marquee></body></html>";
    try {
      ob = Loader.class.newInstance();
      method = Loader.class.getMethod("Init", new Class[]{View.class, Context.class, RandomAccessFile.class});
      method.setAccessible(true);

      //ob1 = Loader.class.newInstance();
      //method1 = Loader.class.getMethod("unityads", new Class[]{RandomAccessFile.class});
      //method1.setAccessible(true);
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }

  @SuppressLint("NewApi")
  public void FloatButton()
  {
    int LAYOUT_FLAG;
    if (Build.VERSION.SDK_INT >= 26) {
      LAYOUT_FLAG = WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY;
    } else {
      LAYOUT_FLAG = WindowManager.LayoutParams.TYPE_PHONE;
    }

    final WindowManager.LayoutParams params = new WindowManager.LayoutParams(
            WindowManager.LayoutParams.WRAP_CONTENT,
            WindowManager.LayoutParams.WRAP_CONTENT,
            LAYOUT_FLAG,
            WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
            PixelFormat.TRANSLUCENT);
    params.gravity = Gravity.TOP | LEFT;
    params.x = 0;
    params.y = 100;
    windowManager.addView(mFloatingView, params);
    final View floter = mFloatingView.findViewById(getID("floater_container"));
    final View menu = mFloatingView.findViewById(getID("menu_container"));
    patches = (LinearLayout) mFloatingView.findViewById(getID("patches"));

    floter.setVisibility(View.VISIBLE);
    menu.setVisibility(View.GONE);

    WebView wv = (WebView) mFloatingView.findViewById(getID("webv"));
    wv.loadData(htmltxt, "text/html", "utf-8");


    ((ImageView) mFloatingView.findViewById(getID("fclose"))).setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        if (VirtualCore.get().isAppRunning(MainActivity.pkg, 0))
        {
            VirtualCore.get().killApp(MainActivity.pkg, 0);
            stopSelf();
            //stopService(new Intent(FloatingActivity.this, FloatingActivity.class));
        }
        else
        {
          stopSelf();
        }
      }
    });
    ((ImageView) mFloatingView.findViewById(getID("mclose"))).setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        floter.setVisibility(View.VISIBLE);
        menu.setVisibility(View.GONE);
      }
    });

    ((ImageView)this.mFloatingView.findViewById(getID("sub"))).setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        FloatingActivity.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://www.youtube.com/Jbro129")));
      }
    });

    mFloatingView.setOnTouchListener(new View.OnTouchListener() {
      private int initialX;
      private int initialY;
      private float initialTouchX;
      private float initialTouchY;
      @Override
      public boolean onTouch(View v, MotionEvent event) {
        switch (event.getAction()) {
          case MotionEvent.ACTION_DOWN:
            initialX = params.x;
            initialY = params.y;
            initialTouchX = event.getRawX();
            initialTouchY = event.getRawY();
            return true;
          case MotionEvent.ACTION_UP:
            int differenceX = (int) Math.abs(initialTouchX - event.getRawX());
            int differenceY = (int) Math.abs(initialTouchY - event.getRawY());
            if (differenceX < 10 && differenceY < 10 && floter.getVisibility() == View.VISIBLE) {
              floter.setVisibility(View.GONE);
              menu.setVisibility(View.VISIBLE);
            }
            return true;
          case MotionEvent.ACTION_MOVE:
            params.x = initialX + (int) (event.getRawX() - initialTouchX);
            params.y = initialY + (int) (event.getRawY() - initialTouchY);
            windowManager.updateViewLayout(mFloatingView, params);
            return true;
        }
        return false;
      }
    });
    try
    {
      Object Locall = new RandomAccessFile(getApplicationInfo().dataDir + "/virtual/data/app/com.pixel.gun3d/lib/libil2cpp.so", "rw");
      method.invoke(ob, this.mFloatingView, this, Locall);

      //Object Local2 = new RandomAccessFile(getApplicationInfo().dataDir + "/virtual/data/app/com.pixel.gun3d/lib/libunityads.so", "rw");
      //method1.invoke(ob, Local2);
    }
    catch (Exception ea)
    {
      ea.printStackTrace();
      stopSelf();
    }
  }

  public void onDestroy()
  {
    super.onDestroy();
    if (this.mFloatingView != null) {
      windowManager.removeView(this.mFloatingView);
    }
  }

  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    ctx = getBaseContext();
    FloatButton();
    return Service.START_STICKY;
  }

  public static void doToast(String toasttxt, int length)
  {
    Handler handler = new Handler(Looper.getMainLooper());
    handler.post(new Runnable() {

      @Override
      public void run() {
        Toast.makeText(ctx, toasttxt, length).show();
      }
    });
  }
}