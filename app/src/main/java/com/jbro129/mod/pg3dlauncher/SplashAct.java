package com.jbro129.mod.pg3dlauncher;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.jbro129.mod.vending.AccountActivity;

public class SplashAct extends AppCompatActivity
{
    protected void onCreate(Bundle paramBundle)
    {
        super.onCreate(paramBundle);
        getWindow().setFlags(1024, 1024);
        setContentView(R.layout.splash_activity);
        new Handler().postDelayed(new Runnable()
        {
            public void run()
            {
                if (!Prefs.with(SplashAct.this).readBoolean("firstboot", false)) {
                    SplashAct.this.startActivity(new Intent(SplashAct.this, IntroAct.class));
                    return;
                }
                for (;;)
                {
                    SplashAct.this.startActivity(new Intent(SplashAct.this, /* AccountActivity.class */ MainActivity.class));
                    SplashAct.this.finish();
                    return;
                }
            }
        }, 700L);
    }
}
