package com.jbro129.mod.pg3dlauncher;

        import android.Manifest;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.github.paolorotolo.appintro.AppIntro2;
import com.github.paolorotolo.appintro.AppIntroFragment;
import com.github.paolorotolo.appintro.model.SliderPage;
import com.jbro129.mod.vending.AccountActivity;

public class IntroAct extends AppIntro2 {

    protected void onCreate(@Nullable Bundle paramBundle)
    {
        super.onCreate(paramBundle);
        SliderPage slide = new SliderPage();
        slide.setTitle("Welcome!");
        slide.setDescription("© 2018 PG3D Mod Launcher");
        slide.setImageDrawable(R.mipmap.jicon);
        slide.setBgColor(getResources().getColor(R.color.jblue2));
        addSlide(AppIntroFragment.newInstance(slide));
        SliderPage slide1 = new SliderPage();
        slide1.setTitle("Features");
        slide1.setDescription("PG3D Mod Launcher Has Many Features That Are Very Handy In Pixel Gun 3D");
        slide1.setImageDrawable(R.drawable.menu);
        slide1.setBgColor(getResources().getColor(R.color.jblue2));
        addSlide(AppIntroFragment.newInstance(slide1));
        SliderPage slide2 = new SliderPage();
        slide2.setTitle("User Friendly");
        slide2.setDescription("PG3D Mod Launcher UI Is Easy To Read & Use");
        slide2.setImageDrawable(R.drawable.check);
        slide2.setBgColor(getResources().getColor(R.color.jblue2));
        addSlide(AppIntroFragment.newInstance(slide2));
        SliderPage slide3 = new SliderPage();
        slide3.setTitle("Subscribe");
        slide3.setDescription("Make sure to subscribe to Jbro129 on YouTube (https://youtube.com/Jbro129) :D");
        slide3.setImageDrawable(R.drawable.yticon);
        slide3.setBgColor(getResources().getColor(R.color.jblue2));
        addSlide(AppIntroFragment.newInstance(slide3));
        setFlowAnimation();
        showSkipButton(false);
        showStatusBar(false);
        askForPermissions(new String[] { Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_PHONE_STATE }, 1);
        setBarColor(getResources().getColor(R.color.jblue));

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && !Settings.canDrawOverlays((IntroAct.this)))
        {
            IntroAct.this.startActivity(new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION, Uri.parse("package:" + getPackageName())));
            return;
        }

    }

    public void onDonePressed(Fragment paramFragment)
    {
        super.onDonePressed(paramFragment);
        Prefs.with(this).writeBoolean("firstboot", true);
        startActivity(new Intent(this, /* AccountActivity.class */ MainActivity.class));
        finish();
    }
}
