package com.jbro129.mod;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.PorterDuff.Mode;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.jbro129.mod.pg3dlauncher.MainActivity;
import com.jbro129.mod.pg3dlauncher.PointsController;
import com.jbro129.mod.pg3dlauncher.R;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import dalvik.system.DexClassLoader;

public class Loader
{
    private static Loader inst = new Loader();
    private static Context ctx;
    private static LinearLayout patches;
    private static RandomAccessFile raf;
    private static RandomAccessFile raf2;
    private static int swOff = -1;
    private static int swOn = -1;
    private static int txtColor = -1;
    private static float txtSize = 18.0F;

    @QVMProtect
    public static void antiBan(RandomAccessFile random)
    {
        raf = random;
        try {

            fakerBan(random);

            Loader.write(formatOffset("0x17DAAEC"), "1E FF 2F E1"); // CheatDetectedBanner$$.ctor
            Loader.write(formatOffset("0x17DAAF4"), "1E FF 2F E1"); // CheatDetectedBanner$$ShowAndClearProgress
            Loader.write(formatOffset("0x17DABC8"), "1E FF 2F E1"); // CheatDetectedBanner$$ClearAllProgress
            Loader.write(formatOffset("0x17DAC90"), "1E FF 2F E1"); //
            Loader.write(formatOffset("0x17DB008"), "1E FF 2F E1"); //
            Loader.write(formatOffset("0x17DB368"), "1E FF 2F E1"); //
            Loader.write(formatOffset("0x17DB18C"), "1E FF 2F E1"); //
            Loader.write(formatOffset("0x17DB430"), "1E FF 2F E1"); //
            Loader.write(formatOffset("0x17DAF7C"), "1E FF 2F E1"); //
            Loader.write(formatOffset("0x1AD9954"), "1E FF 2F E1"); //
            Loader.write(formatOffset("0x1383EE8"), "1E FF 2F E1"); // AdsConfigMemento$$get_CheaterConfig
            Loader.write(formatOffset("0x1383EF0"), "1E FF 2F E1"); // AdsConfigMemento$$set_CheaterConfig


            Loader.write(formatOffset("0x1E5231C"), "1E FF 2F E1"); // CheaterConfigMemento$$.ctor
            Loader.write(formatOffset("0x1E52350"), "1E FF 2F E1"); // CheaterConfigMemento$$get_CheckSignatureTampering
            Loader.write(formatOffset("0x1E52358"), "1E FF 2F E1"); // CheaterConfigMemento$$set_CheckSignatureTampering
            Loader.write(formatOffset("0x1E52360"), "1E FF 2F E1"); // CheaterConfigMemento$$get_CoinThreshold
            Loader.write(formatOffset("0x1E52340"), "1E FF 2F E1"); // CheaterConfigMemento$$set_CoinThreshold
            Loader.write(formatOffset("0x1E52368"), "1E FF 2F E1"); // CheaterConfigMemento$$get_GemThreshold
            Loader.write(formatOffset("0x1E52348"), "1E FF 2F E1"); // CheaterConfigMemento$$set_GemThreshold
            Loader.write(formatOffset("0x1E52370"), "1E FF 2F E1"); // CheaterConfigMemento$$FromDictionary


            Loader.write(formatOffset("0x25E0AC4"), "1E FF 2F E1"); // AbstractBankView$$get_CrackersWarningLabelEnabled
            Loader.write(formatOffset("0x25E0BB8"), "1E FF 2F E1"); // AbstractBankView$$set_CrackersWarningLabelEnabled
            Loader.write(formatOffset("0x160BDD8"), "00 00 A0 E3 1E FF 2F E1"); //
            Loader.write(formatOffset("0x160C2A0"), "00 00 A0 E3 1E FF 2F E1"); //
            Loader.write(formatOffset("0x160DF04"), "00 00 A0 E3 1E FF 2F E1"); //
            Loader.write(formatOffset("0x160DF04"), "00 00 A0 E3 1E FF 2F E1"); //

            // internal sealed class VersionBlocker : MonoBehaviour
            Loader.write(formatOffset("0xA57738"), "1E FF 2F E1"); //
            Loader.write(formatOffset("0xA57740"), "1E FF 2F E1"); //
            Loader.write(formatOffset("0xA57FC4"), "00 00 A0 E3 1E FF 2F E1"); //
            Loader.write(formatOffset("0xA577C4"), "1E FF 2F E1"); //
            Loader.write(formatOffset("0xA57938"), "1E FF 2F E1"); //
            Loader.write(formatOffset("0xA57A24"), "1E FF 2F E1"); //
            Loader.write(formatOffset("0xA5868C"), "1E FF 2F E1"); //
            Loader.write(formatOffset("0xA58698"), "1E FF 2F E1"); //
            Loader.write(formatOffset("0xA5820C"), "1E FF 2F E1"); //
            Loader.write(formatOffset("0xA587F8"), "1E FF 2F E1"); //
            Loader.write(formatOffset("0xA58CDC"), "00 00 A0 E3 1E FF 2F E1"); //
            Loader.write(formatOffset("0xA58CC8"), "1E FF 2F E1"); //
            Loader.write(formatOffset("0xA58EE8"), "1E FF 2F E1"); //
            Loader.write(formatOffset("0xA59174"), "00 00 A0 E3 1E FF 2F E1"); //
            Loader.write(formatOffset("0xA59170"), "1E FF 2F E1"); //

            // internal sealed class UpdatesChecker : MonoBehaviour
            Loader.write(formatOffset("0x1F80AE4"), "1E FF 2F E1"); //
            Loader.write(formatOffset("0x1F80AEC"), "1E FF 2F E1"); //
            Loader.write(formatOffset("0x1F80BB4"), "1E FF 2F E1"); //
            Loader.write(formatOffset("0x1F80C64"), "1E FF 2F E1"); //
            Loader.write(formatOffset("0x1F80D18"), "01 00 A0 E3 1E FF 2F E1"); //
            Loader.write(formatOffset("0x1F80DC8"), "1E FF 2F E1"); //
            Loader.write(formatOffset("0x1F80E7C"), "00 00 A0 E3 1E FF 2F E1"); //
            Loader.write(formatOffset("0x1F80F2C"), "1E FF 2F E1"); //
            Loader.write(formatOffset("0x1F80FE0"), "1E FF 2F E1"); //
            Loader.write(formatOffset("0x1F81228"), "1E FF 2F E1"); //
            Loader.write(formatOffset("0x1F81470"), "1E FF 2F E1"); //
            Loader.write(formatOffset("0x1F815A8"), "1E FF 2F E1"); //
            Loader.write(formatOffset("0x1F816E0"), "1E FF 2F E1"); //
            Loader.write(formatOffset("0x1F81228"), "1E FF 2F E1"); //
            Loader.write(formatOffset("0x1F81470"), "1E FF 2F E1"); //
            Loader.write(formatOffset("0x1F815A8"), "1E FF 2F E1"); //
            Loader.write(formatOffset("0x1F816E0"), "1E FF 2F E1"); //
            Loader.write(formatOffset("0x1F817E0"), "1E FF 2F E1"); //
            Loader.write(formatOffset("0x1F83810"), "1E FF 2F E1"); //
            Loader.write(formatOffset("0x1F83858"), "1E FF 2F E1"); //
            Loader.write(formatOffset("0x1F8376C"), "1E FF 2F E1"); //
            Loader.write(formatOffset("0x1F83950"), "1E FF 2F E1"); //
            Loader.write(formatOffset("0x1F84000"), "1E FF 2F E1"); //
            Loader.write(formatOffset("0x1F840A4"), "1E FF 2F E1"); //
            Loader.write(formatOffset("0x1F81C24"), "1E FF 2F E1"); //
            Loader.write(formatOffset("0x1F841E4"), "1E FF 2F E1"); //
            Loader.write(formatOffset("0x1F83E80"), "1E FF 2F E1"); //
            Loader.write(formatOffset("0x1F84854"), "1E FF 2F E1"); //
            Loader.write(formatOffset("0x1F84B14"), "1E FF 2F E1"); //
            Loader.write(formatOffset("0x1F82EB0"), "1E FF 2F E1"); //
            Loader.write(formatOffset("0x1F84DD4"), "1E FF 2F E1"); //

            Loader.write(formatOffset("0x12831D0"), "1E FF 2F E1"); //
            Loader.write(formatOffset("0x1283028"), "1E FF 2F E1"); //
            Loader.write(formatOffset("0x1220AB4"), "00 F0 20 E3"); //

            Loader.write(formatOffset("0x121EF4C"), "01 00 A0 E3"); //
            Loader.write(formatOffset("0x121E93C"), "01 00 A0 E3"); //
            Loader.write(formatOffset("0x12200B8"), "01 00 A0 E3"); //

            Loader.write(formatOffset("0x122533C"), "00 F0 20 E3"); //

            Loader.write(formatOffset("0xD88DBC"), "1E FF 2F E1"); //
            Loader.write(formatOffset("0x1213E50"), "1E FF 2F E1"); //

            Loader.write(formatOffset("0x1225FE8"), "00 F0 20 E3"); // _NextCoroutine_c__Iterator2$$MoveNext ORR             R2, R0, #2
            Loader.write(formatOffset("0x1225FF4"), "00 F0 20 E3"); //

            Loader.write(formatOffset("0x97A20C"), "00 F0 20 E3"); // Player_move_c$$Update
            Loader.write(formatOffset("0x97A218"), "00 F0 20 E3"); // Player_move_c$$Update
            Loader.write(formatOffset("0x9BE6B4"), "00 F0 20 E3"); // Player_move_c$$Update
            Loader.write(formatOffset("0x9BE6C0"), "00 F0 20 E3"); // Player_move_c$$Update
            Loader.write(formatOffset("0x1283714"), "00 F0 20 E3"); // ORR             R2, R0, #2
            Loader.write(formatOffset("0x1283720"), "00 F0 20 E3"); // ORR             R2, R0, #2
            Loader.write(formatOffset("0x1224F10"), "00 F0 20 E3"); // ORR             R2, R0, #1
            Loader.write(formatOffset("0x1224F1C"), "00 F0 20 E3"); // ORR             R2, R0, #1
            Loader.write(formatOffset("0x12209A8"), "00 F0 20 E3"); // _InitializeSwitcher_c__Iterator1$$MoveNext ORR             R2, R0, #0x40
            Loader.write(formatOffset("0x12209B4"), "00 F0 20 E3"); // _InitializeSwitcher_c__Iterator1$$MoveNext ORR             R2, R0, #0x40
            Loader.write(formatOffset("0xD9EB2C"), "00 F0 20 E3"); // ORR             R2, R0, #0x100
            Loader.write(formatOffset("0xD9EB38"), "00 F0 20 E3"); // ORR             R2, R0, #0x100

            Loader.write(formatOffset("0x12209A8"), "2B 00 00 0A");  // ORR             R2, R0, #0x40
            Loader.write(formatOffset("0x12209B4"), "28 00 00 1A");  // ORR             R2, R0, #0x40
            Loader.write(formatOffset("0xC890A0"), "00 F0 20 E3"); // ORR             R2, R0, #0x40
            Loader.write(formatOffset("0xC890AC"), "00 F0 20 E3"); // ORR             R2, R0, #0x40
            Loader.write(formatOffset("0xC8900C"), "00 F0 20 E3"); // AppsMenu
            Loader.write(formatOffset("0xC89018"), "00 F0 20 E3"); // AppsMenu

            //Loader.write(formatOffset("1657104"), "00 00 A0 E3");


            //Loader.write(formatOffset("8BB088"),"00 00 A0 E3");

            Loader.write(formatOffset("0xD01704"), "00 F0 20 E3"); // AbstractBankView$$set_CrackersWarningLabelEnabled

            Loader.write(formatOffset("0x12965BC"), "1E FF 2F E1"); // OldFrameSelect$$.ctor
            Loader.write(formatOffset("0x12965C4"), "1E FF 2F E1"); // OldFrameSelect$$.cctor
            Loader.write(formatOffset("0x1296648"), "1E FF 2F E1"); // OldFrameSelect$$Start
            Loader.write(formatOffset("0x1283810"), "1E FF 2F E1"); //

            Loader.write(formatOffset("0x166677C"), "1E FF 2F E1"); // CustomHungerBase$$.ctor
            Loader.write(formatOffset("0x1666840"), "1E FF 2F E1"); //
            Loader.write(formatOffset("0x1666914"), "1E FF 2F E1"); //
            Loader.write(formatOffset("0x1666C24"), "1E FF 2F E1"); //
            Loader.write(formatOffset("0x1666DA8"), "1E FF 2F E1"); //
            Loader.write(formatOffset("0x1666F84"), "1E FF 2F E1"); //
            Loader.write(formatOffset("0x1666FB8"), "1E FF 2F E1"); //
            Loader.write(formatOffset("0x1666B80"), "1E FF 2F E1"); //


            Loader.write(formatOffset("0x1243AF0"), "1E FF 2F E1"); // NewVersionBanner$$.ctor
            Loader.write(formatOffset("0x1243B04"), "00 00 A0 E3 1E FF 2F E1"); //
            Loader.write(formatOffset("0x1244214"), "1E FF 2F E1"); //
            Loader.write(formatOffset("0x1244B78"), "1E FF 2F E1"); //
            Loader.write(formatOffset("0x1244E10"), "1E FF 2F E1"); //
            Loader.write(formatOffset("0x1245278"), "1E FF 2F E1"); //
            Loader.write(formatOffset("0x12453F8"), "1E FF 2F E1"); //
            Loader.write(formatOffset("0x12458A8"), "1E FF 2F E1"); //
            Loader.write(formatOffset("0x1245B18"), "1E FF 2F E1"); //
            Loader.write(formatOffset("0x124554C"), "1E FF 2F E1"); //
            Loader.write(formatOffset("0x1244064"), "1E FF 2F E1"); //
            Loader.write(formatOffset("0x1243B00"), "1E FF 2F E1"); //

            Loader.write(formatOffset("0xC88738"), "0C 00 A0 E3"); // AppsMenu$$Awake
            Loader.write(formatOffset("0xC8877C"), "0C 00 A0 E3"); // _Start_c__Iterator1$$MoveNext
            //Loader.write(formatOffset("CC4CE0"), "0C 00 A0 E3"); //
            Loader.write(formatOffset("0x160D5F4"), "0C 00 A0 E3"); // coinsShop$$IsBangerrySupported
            Loader.write(formatOffset("0x15F3C50"), "0C 00 A0 E3"); // _Start_c__Iterator2$$MoveNext
            Loader.write(formatOffset("0x15F3C50"), "0C 00 A0 E3"); // GetAbuseKey_d4d3cbab
            Loader.write(formatOffset("0x9BE670"), "0C 00 A0 E3"); //

            //Loader.write(formatOffset("BEF408"),"00 00 A0 E3 1E FF 2F E1");

            // Loader.write(formatOffset("119A430"),"1E FF 2F E1");

            //Loader.write(formatOffset("C75068"), "00 00 A0 E3 00 00 50 E3"); //

            //ORR             R2, R0, #

            //Loader.write(formatOffset("E778E0"), "00 00 A0 E3 00 00 50 E3"); //
            Loader.write(formatOffset("0xD9E70C"), "00 00 A0 E3 00 00 50 E3"); //
            Loader.write(formatOffset("0x121E980"), "00 00 A0 E3 00 00 50 E3"); //

            Loader.write(formatOffset("0xC85ABC"), "00 00 A0 E3 00 00 50 E3"); //
            Loader.write(formatOffset("0xC85BA0"), "00 00 A0 E3 00 00 50 E3"); //
            Loader.write(formatOffset("0x21D8788"), "00 00 A0 E3 00 00 50 E3"); //
            //Loader.write(formatOffset("E7B508"), "00 00 A0 E3 00 00 50 E3"); //
            //Loader.write(formatOffset("E7B508"), "00 00 A0 E3 00 00 50 E3"); //
            //Loader.write(formatOffset("E7EA00"), "00 00 A0 E3 00 00 50 E3"); //
            Loader.write(formatOffset("0x1224FA0"), "00 00 A0 E3 00 00 50 E3"); // _NextCoroutine_c__Iterator2$$MoveNext

            //Loader.write(formatOffset("63273C"), "00 00 A0 E3 00 00 50 E3");//Initialize
            //Loader.write(formatOffset("15494E0"), "00 00 A0 E3 00 00 50 E3");//ShowPanelHandledCoroutine
            //Loader.write(formatOffset("E822B8"), "00 00 A0 E3 00 00 50 E3");//StartNewAndUnload
            //Loader.write(formatOffset("1F10AE4"), "00 00 A0 E3 00 00 50 E3");//HandleShopButtonFromItemCoroutine
            //Loader.write(formatOffset("2183FC4"), "00 00 A0 E3 00 00 50 E3");//BackgroundLoading


            //Loader.write(formatOffset("1A74698"), "1E FF 2F E1"); // no more after match ads
            //Loader.write(formatOffset("FB979C"), "1E FF 2F E1"); // no more after match ads


            Loader.write(formatOffset("0x2046A98"), "01 00 A0 E3 1E FF 2F E1"); //
            Loader.write(formatOffset("0x2046B68"), "01 00 A0 E3 1E FF 2F E1"); //
            Loader.write(formatOffset("0x2046C38"), "01 00 A0 E3 1E FF 2F E1"); //
            Loader.write(formatOffset("0x2047048"), "01 00 A0 E3 1E FF 2F E1"); //
            Loader.write(formatOffset("0x2046F78"), "01 00 A0 E3 1E FF 2F E1"); //
            Loader.write(formatOffset("0x20468D8"), "01 00 A0 E3 1E FF 2F E1"); //
            Loader.write(formatOffset("0x20469B8"), "01 00 A0 E3 1E FF 2F E1"); //
            Loader.write(formatOffset("0x2046D08"), "01 00 A0 E3 1E FF 2F E1"); //
            Loader.write(formatOffset("0x2046DD8"), "01 00 A0 E3 1E FF 2F E1"); //
            Loader.write(formatOffset("0x2046EA8"), "01 00 A0 E3 1E FF 2F E1"); //

            //Loader.write(formatOffset("0xAF5658"), "1E FF 2F E1"); //


            Loader.write(formatOffset("0x19A91E0"), "00 00 A0 E3 15 00 50 E3 EA 01 00 1A"); // Longer name | ProfileController$$GetPlayerNameOrDefault
            Loader.write(formatOffset("0x107BD64"), "00 00 A0 E3 15 00 50 E3 05 00 00 1A"); // Longer name | SquadController$$SendChatMessage
            Loader.write(formatOffset("0x1EF99D4"), "00 00 A0 E3 15 00 50 E3 07 00 00 1A"); // Longer name | FriendsController$$UpdatePlayer
            Loader.write(formatOffset("0x1EF99D4"), "00 00 A0 E3 15 00 50 E3 07 00 00 1A"); // Longer name | FriendsController$$SendLikeLobbyCoroutine
            Loader.write(formatOffset("0x1D538B4"), "01 00 A0 E1 1E FF 2F E1"); // Longer name | FilterBadWorld$$FilterString

            // HD Skin/Cape
            Loader.write(formatOffset("0x1046404"), "41 00 50 E3 3E 00 00 0A"); // SkinsController$$SetCurrentSkin
            Loader.write(formatOffset("0x10463A0"), "21 00 50 E3 25 00 00 0A"); // SkinsController$$SetCurrentSkin

            /*
            Loader.write(formatOffset("18AB8F8"), "0D 00 50 E3 90 00 00 0A"); // SkinName$$SetCape
            Loader.write(formatOffset("18AB914"), "11 00 50 E3 89 00 00 0A"); // SkinName$$SetCape
            Loader.write(formatOffset("18A9628"), "0D 00 50 E3 0F 00 00 0A"); // SkinName$$setCapeCustomRPCLocal
            Loader.write(formatOffset("18A9644"), "11 00 50 E3 08 00 00 0A"); // SkinName$$setCapeCustomRPCLocal
            Loader.write(formatOffset("18A923C"), "0D 00 50 E3 11 00 00 0A"); // SkinName$$setCapeCustomRPC
            Loader.write(formatOffset("18A9258"), "11 00 50 E3 0A 00 00 0A"); // SkinName$$setCapeCustomRPC
            Loader.write(formatOffset("81C2A8"), "0D 00 50 E3 7D 00 00 0A"); // NetworkStartTable$$SendMyCape
            Loader.write(formatOffset("81C2C4"), "11 00 50 E3 76 00 00 0A"); // NetworkStartTable$$SendMyCape
            Loader.write(formatOffset("16DDB54"), "0D 00 50 E3 68 00 00 0A"); // DuelController$$SendMyCape
            Loader.write(formatOffset("16DDB70"), "11 00 50 E3 61 00 00 0A"); // DuelController$$SendMyCape
            // HD Skin/Cape
            */

            // Prefs decrypt + logging
            //Loader.write(formatOffset("0x1B3B0B4"),"30 48 2D E9 08 B0 8D E2 01 50 A0 E1 02 40 A0 E1 4ED920EB 04 10 A0 E1 4CD920EB 00 00 A0 E3 05 10 A0 E1 04 20 A0 E1 00 30 A0 E3 30 48 BD E8 6A5C29EA 1E FF 2F E1"); // setstring
            //Loader.write(formatOffset("0x1B397C8"),"30 48 2D E9 08 B0 8D E2 01 40 A0 E1 00 00 A0 E3 00 20 A0 E3 056329EB 04 10 A0 E1 00 50 A0 E1 85DF20EB 05 10 A0 E1 83DF20EB 05 00 A0 E1 30 88 BD E8 1E FF 2F E1"); // getstring
            //Loader.write(formatOffset("0x1B395A0"),"10 4C 2D E9 08 B0 8D E2 01 40 A0 E1 14E020EB 00 00 A0 E3 04 10 A0 E1 00 20 A0 E3 10 4C BD E8 AD6329EA 1E FF 2F E1"); //haskey;

            //Loader.write(formatOffset("0x1B068C4"), "1E FF 2F E1");// allow log
            //Loader.write(formatOffset("0x1B06018"), "1E FF 2F E1");// allow log
            //Loader.write(formatOffset("0x1B05C44"), "1E FF 2F E1");// allow log
            //Loader.write(formatOffset("0x1B063EC"), "1E FF 2F E1");// allow log
            //Loader.write(formatOffset("0x1B06650"), "1E FF 2F E1");// allow log
            //Loader.write(formatOffset("0x238F3BC"), "01 00 A0 E3 1E FF 2F E1");// Debug
            //Loader.write(formatOffset("0x1677064"), "01 00 A0 E3 1E FF 2F E1");// Developer
            //Loader.write(formatOffset("0x237E794"), "01 00 A0 E3 1E FF 2F E1");// Application$$get_isEditor
            //Loader.write(formatOffset("0x2125804"), "01 00 A0 E3 1E FF 2F E1");// Tools$$get_isEditor
        }
        catch (Exception a)
        {
            a.printStackTrace();
        }
    }



    private static byte[] Hex2b(String hex) {
        if(hex.contains(" ")) {
            hex = hex.replace(" ", "");
        }

        if(hex == null) {
            throw new IllegalArgumentException("hex == null");
        } else if(hex.length() % 2 != 0) {
            throw new IllegalArgumentException("Unexpected hex string: " + hex);
        } else {
            byte[] result = new byte[hex.length() / 2];

            for(int i = 0; i < result.length; ++i) {
                int d1 = decodeHexDigit(hex.charAt(i * 2)) << 4;
                int d2 = decodeHexDigit(hex.charAt(i * 2 + 1));
                result[i] = (byte)(d1 + d2);
            }

            return result;
        }
    }

    @QVMProtect
    public static void unityads(RandomAccessFile paramRandomAccessFile)
    {
        
        /*
            PG3D uses an external library to check to see if its being ran from within a virtual environment.
         
            https://github.com/ysrc/AntiVirtualApp
        */
        
        raf2 = paramRandomAccessFile;
        write2nd(formatOffset("1896"), "01 24");
        write2nd(formatOffset("1624"), "01 20 70 47");
        write2nd(formatOffset("14DC"), "01 20 70 47");
        write2nd(formatOffset("2138"), "01 20 70 47");
        write2nd(formatOffset("13A0"), "01 20 70 47");
        write2nd(formatOffset("1EB4"), "01 20 70 47");
        write2nd(formatOffset("1FF4"), "01 20 70 47");
        write2nd(formatOffset("1D74"), "01 20 70 47");
        write2nd(formatOffset("1C34"), "01 20 70 47");
        write2nd(formatOffset("1AF8"), "01 20 70 47");
    }

    @QVMProtect
    public static void Init(View paramView, Context paramContext, RandomAccessFile paramRandomAccessFile)
    {
        ctx = paramContext;
        raf = paramRandomAccessFile;
        patches = (LinearLayout)paramView.findViewById(getID("patches"));
        paramView = (LinearLayout)paramView.findViewById(getID("menu_container"));

        //antiBan(); // real antiban

        //fakerBan(); // fake antiban

        setTxtColor(Color.WHITE);
        setTxtSize(19.0F);
        setSwitchOnColor(Color.GREEN);
        setSwitchOffColor(Color.RED);

        /*
        addSwitch("WWWForm", new CompoundButton.OnCheckedChangeListener()
        {
          public void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
          {
            if (paramAnonymousBoolean)
            {
              Loader.write(formatOffset("1F44318"), "10 4C 2D E9 08 B0 8D E2 02 40 A0 E1 ECD1F7EB 04 10 A0 E1 10 4C BD E8 E9D1F7EA 1E FF 2F E1");// WWWForm AddField
              return;
            }
            Loader.write(formatOffset("1F44318"), "F0 4D 2D E9 18 B0 8D E2 08 D0 4D E2 00 60 A0 E1 98 00 9F E5 98 70 9F E5 02 80 A0 E1 00 00 8F E0 01 50 A0 E1");// WWWForm AddField
          }
        });
        addSpinner("Clipping", new String[]{"Unchanged","0","1000","-1000","NaN","-NaN","-NaN 2","-Epsilon","Infinity","-Infinity","Max Value","Min Value"},new AdapterView.OnItemSelectedListener()
        {
        public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l)
          {
            switch (position){
              case 0://unchanged
                Loader.write(formatOffset("17F28F0"), "90 00 94 E5 00 00 50 E3 7C 01 00 0A 00 10 A0 E3 C1 7B 15 EB 01 00 50 E3 74 01 00 1A F8 05 9F E5");
                break;
              case 1://0
                Loader.write(formatOffset("17F28F0"), "90 00 94 E5 00 10 A0 E3 00 20 A0 E3 0010A0E3 B87915EB 00 F0 20 E3 00 F0 20 E3");
                break;
              case 2://1000
                Loader.write(formatOffset("17F28F0"), "90 00 94 E5 00 10 A0 E3 00 20 A0 E3 7A1444E3 B87915EB 00 F0 20 E3 00 F0 20 E3");
                break;
              case 3://-1000
                Loader.write(formatOffset("17F28F0"), "90 00 94 E5 00 10 A0 E3 00 20 A0 E3 7A144CE3 B87915EB 00 F0 20 E3 00 F0 20 E3");
                break;
              case 4://NaN
                Loader.write(formatOffset("17F28F0"), "90 00 94 E5 00 10 A0 E3 00 20 A0 E3 0211E0E3 B87915EB 00 F0 20 E3 00 F0 20 E3");
                break;
              case 5://-NaN
                Loader.write(formatOffset("17F28F0"), "90 00 94 E5 00 10 A0 E3 00 20 A0 E3 0211A0E3 B87915EB 00 F0 20 E3 00 F0 20 E3");
                break;
              case 6://-NaN 2
                Loader.write(formatOffset("17F28F0"), "90 00 94 E5 00 10 A0 E3 00 20 A0 E3 001000E3C10F47E3 B77915EB 00 F0 20 E3");
                break;
              case 7://-Epsilon
                Loader.write(formatOffset("17F28F0"), "90 00 94 E5 00 10 A0 E3 00 20 A0 E3 0601A0E3 B87915EB 00 F0 20 E3 00 F0 20 E3");
                break;
              case 8://Infinity
                Loader.write(formatOffset("17F28F0"), "90 00 94 E5 00 10 A0 E3 00 20 A0 E3 001000E3801F47E3 B77915EB 00 F0 20 E3");
                break;
              case 9://-Infinity
                Loader.write(formatOffset("17F28F0"), "90 00 94 E5 00 10 A0 E3 00 20 A0 E3 001000E3801F4FE3 B77915EB 00 F0 20 E3");
                break;
              case 10://Max
                Loader.write(formatOffset("17F28F0"), "90 00 94 E5 00 10 A0 E3 00 20 A0 E3 FF1F0FE37F1F47E3 B77915EB 00 F0 20 E3");
                break;
              case 11://Min
                Loader.write(formatOffset("17F28F0"), "90 00 94 E5 00 10 A0 E3 00 20 A0 E3 0205E0E3 B87915EB 00 F0 20 E3 00 F0 20 E3");
                break;
            }
          }
          public void onNothingSelected(AdapterView<?> adapterView) {}
        });
        addSwitch("Force Good Cloud", new CompoundButton.OnCheckedChangeListener()
        {
          public void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
          {
            if (paramAnonymousBoolean)
            {
              Loader.write(formatOffset("12AA830"), "01 00 A0 E3 1E FF 2F E1");
              return;
            }
            Loader.write(formatOffset("12AA830"), "30 48 2D E9 08 B0 8D E2");
          }
        });*/
        addSwitch("GodMode", new CompoundButton.OnCheckedChangeListener()
        {
            public void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
            {
                if (paramAnonymousBoolean)
                {
                    Loader.write(formatOffset("0x9933A4"), "00 F0 20 E3"); // Player_move_c$$GetDamageInternal 1 VSUB.F32        S0, S0, S16
                    Loader.write(formatOffset("0x993504"), "00 F0 20 E3"); // Player_move_c$$GetDamageInternal 2 VSUB.F32        S0, S0, S16
                    Loader.write(formatOffset("0x19A0F00"), "00 F0 20 E3"); // PlayerArmor$$GetDamage VSUB.F32        S0, S0, S16
                    Loader.write(formatOffset("0x992BC0"), "1E FF 2F E1");
                    //Loader.write(formatOffset("0x94D964"), "1E FF 2F E1");
                    return;
                }
                Loader.write(formatOffset("0x9933A4"), "48 0A 30 EE"); // Player_move_c$$GetDamageInternal 1 VSUB.F32        S0, S0, S16
                Loader.write(formatOffset("0x993504"), "48 0A 30 EE"); // Player_move_c$$GetDamageInternal 2 VSUB.F32        S0, S0, S16
                Loader.write(formatOffset("0x19A0F00"), "48 0A 30 EE"); // PlayerArmor$$GetDamage VSUB.F32        S0, S0, S16
                Loader.write(formatOffset("0x992BC0"), "F0 4F 2D E9");
                //Loader.write(formatOffset("0x94D964"), "F0 4F 2D E9");
            }
        });
        addSwitch("FireRate Mod", new CompoundButton.OnCheckedChangeListener()
        {
            public void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
            {
                if (paramAnonymousBoolean)
                {
                    Loader.write(formatOffset("0x999D5C"), "AD0900EA 1E FF 2F E1"); // Player_move_c$$ShotPressed -> Player_move_c$$_Shot
                    Loader.write(formatOffset("0x99D70C"), "01 00 A0 E3 1E FF 2F E1"); // Player_move_c$$CanAutoShoot
                    return;
                }
                Loader.write(formatOffset("0x999D5C"), "F0 4F 2D E9 1C B0 8D E2"); // Player_move_c$$ShotPressed -> Player_move_c$$_Shot
                Loader.write(formatOffset("0x99D70C"), "70 4C 2D E9 10 B0 8D E2"); // Player_move_c$$CanAutoShoot
            }
        });/*
        addSwitch("shop button log", new CompoundButton.OnCheckedChangeListener()
        {
            public void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
            {
                if (paramAnonymousBoolean)
                {
                    Loader.write(formatOffset("13A7F44"), "D6 00 00 0A");
                    Loader.write(formatOffset("13A7F50"), "D3 00 00 1A");
                    Loader.write(formatOffset("13A8360"), "9C 71 01 00");
                    Loader.write(formatOffset("816A28"), "9C 71 01 00"); // gfts
                    return;
                }
                Loader.write(formatOffset("13A7F44"), "03 00 00 0A");
                Loader.write(formatOffset("13A7F50"), "00 00 00 1A");
                Loader.write(formatOffset("13A8360"), "60 4E 01 00");
                Loader.write(formatOffset("816A28"), "60 4E 01 00");
            }
        });*/
        addSpinner("Gadget Cooldown", new String[]{"Unchanged","Immediate","Never"},new AdapterView.OnItemSelectedListener()
        {
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l)
            {
                switch (position){
                    case 0:
                        Loader.write(formatOffset("0x6A8A90"), "30 48 2D E9 08 B0 8D E2"); // EffectsController$$GadgetCooldownModificator
                        break;
                    case 1:
                        Loader.write(formatOffset("0x6A8A90"), "7A 04 44 E3 1E FF 2F E1"); // EffectsController$$GadgetCooldownModificator
                        break;
                    case 2:
                        Loader.write(formatOffset("0x6A8A90"), "87 05 43 E3 1E FF 2F E1"); // EffectsController$$GadgetCooldownModificator
                        break;
                }
            }
            public void onNothingSelected(AdapterView<?> adapterView) {}
        });
        addSwitch("Gadget Spam", new CompoundButton.OnCheckedChangeListener()
        {
            public void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
            {
                if (paramAnonymousBoolean)
                {
                    Loader.write(formatOffset("0x980C80"), "01 00 A0 E3 1E FF 2F E1"); // Player_move_c$$get_backClicked
                    Loader.write(formatOffset("0x98098C"), "01 00 A0 E3 1E FF 2F E1"); // Player_move_c$$ResetControls
                    Loader.write(formatOffset("0x804DC0"), "01 00 A0 E3 1E FF 2F E1"); // Player_move_c$$get_pausedInPanel
                    Loader.write(formatOffset("0x81DD34"), "1E FF 2F E1"); // TurretGadget$$StartedCurrentTurret
                    Loader.write(formatOffset("0x8201E8"), "1E FF 2F E1"); // ThrowGadget$$KillCurrentRocket
                    return;
                }
                Loader.write(formatOffset("0x980C80"), "70 4C 2D E9 10 B0 8D E2"); // Player_move_c$$get_backClicked
                Loader.write(formatOffset("0x98098C"), "F0 4D 2D E9 18 B0 8D E2"); // Player_move_c$$ResetControls
                Loader.write(formatOffset("0x804DC0"), "30 48 2D E9 08 B0 8D E2"); // Player_move_c$$get_pausedInPanel
                Loader.write(formatOffset("0x81DD34"), "F0 48 2D E9"); // TurretGadget$$StartedCurrentTurret
                Loader.write(formatOffset("0x8201E8"), "70 4C 2D E9"); // ThrowGadget$$KillCurrentRocket
            }
        });/*
        addSwitch("No Player ID", new CompoundButton.OnCheckedChangeListener()
        {
            public void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
            {
                if (paramAnonymousBoolean)
                {
                    Loader.write(formatOffset("CA17F8"), "00 10 A0 E3 64 10 80 E5 1E FF 2F E1");
                    return;
                }
                Loader.write(formatOffset("CA17F8"), "F0 48 2D E9 10 B0 8D E2  02 8B 2D ED 08 D0 4D E2");
            }
        });*/
        addSpinner("Damage", new String[]{"Unchanged","1-Shot Kill","0 Damage","Give 1 Health","Give 100 Health","Give 1000 Health"},new AdapterView.OnItemSelectedListener()
        {
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l)
            {
                String address = "0x9A8138"; // Player_move_c$$GetWeaponDamage
                switch (position){
                    case 0:
                        Loader.write(formatOffset(address), "F0 4D 2D E9 18 B0 8D E2");
                        //Loader.write(formatOffset("11A4A74"), "F0 4F 2D E9 1C B0 8D E2");
                        //Loader.write(formatOffset("11A4DA8"), "F0 4F 2D E9 1C B0 8D E2");
                        break;
                    case 1:
                        Loader.write(formatOffset(address), "7A 04 44 E3 1E FF 2F E1");
                        //Loader.write(formatOffset("11A4A74"), "7A 04 44 E3 1E FF 2F E1");
                        //Loader.write(formatOffset("11A4DA8"), "7A 04 44 E3 1E FF 2F E1");
                        break;
                    case 2:
                        Loader.write(formatOffset(address), "00 00 40 E3 1E FF 2F E1");
                        //Loader.write(formatOffset("11A4A74"), "00 00 40 E3 1E FF 2F E1");
                        //Loader.write(formatOffset("11A4DA8"), "00 00 40 E3 1E FF 2F E1");
                        break;
                    case 3:
                        Loader.write(formatOffset(address), "80 0F 4B E3 1E FF 2F E1");
                        //Loader.write(formatOffset("11A4A74"), "80 0F 4B E3 1E FF 2F E1");
                        //Loader.write(formatOffset("11A4DA8"), "80 0F 4B E3 1E FF 2F E1");
                        break;
                    case 4:
                        Loader.write(formatOffset(address), "C8 02 4C E3 1E FF 2F E1");
                        //Loader.write(formatOffset("11A4A74"), "C8 02 4C E3 1E FF 2F E1");
                        //Loader.write(formatOffset("11A4DA8"), "C8 02 4C E3 1E FF 2F E1");
                        break;
                    case 5:
                        Loader.write(formatOffset(address), "7A 04 4C E3 1E FF 2F E1");
                        //Loader.write(formatOffset("11A4A74"), "7A 04 4C E3 1E FF 2F E1");
                        //Loader.write(formatOffset("11A4DA8"), "7A 04 4C E3 1E FF 2F E1");
                        break;
                }
            }
            public void onNothingSelected(AdapterView<?> adapterView) {}
        });
        addSpinner("Speed Force", new String[]{"Unchanged","Freeze","Slow","Normal","Fast","The Flash"},new AdapterView.OnItemSelectedListener()
        {
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l)
            {
                // Player_move_c$$DamageTargetWithWeapon
                switch (position){
                    case 0://Unchanged
                        Loader.write(formatOffset("0x9A03A4"), "F0 4F 2D E9 1C B0 8D E2 04 D0 4D E2 04 8B 2D ED 20 D0 4D E2 00 70 A0 E1 18 08 9F E5 18 58 9F E5 03 80 A0 E1 00 00 8F E0 02 A0 A0 E1 00 00 85 E0");
                        break;
                    case 1://Freeze
                        Loader.write(formatOffset("0x9A03A4"), "00 48 2D E9 0D B0 A0 E1 08 D0 4D E2 02 10 A0 E1 1C2644E3 0030A0E3 3B2600EB 0B D0 A0 E1 00 88 BD E8 1E FF 2F E1"); // 7 Player_move_c$$SlowdownTarget
                        break;
                    case 2://Slow
                        Loader.write(formatOffset("0x9A03A4"), "00 48 2D E9 0D B0 A0 E1 08 D0 4D E2 02 10 A0 E1 1C2644E3 803E43E3 3B2600EB 0B D0 A0 E1 00 88 BD E8 1E FF 2F E1"); // 7 Player_move_c$$SlowdownTarget
                        break;
                    case 3://Normal
                        Loader.write(formatOffset("0x9A03A4"), "00 48 2D E9 0D B0 A0 E1 08 D0 4D E2 02 10 A0 E1 1C2644E3 F83340E3 3B2600EB 0B D0 A0 E1 00 88 BD E8 1E FF 2F E1"); // 7 Player_move_c$$SlowdownTarget
                        break;
                    case 4://Fast
                        Loader.write(formatOffset("0x9A03A4"), "00 48 2D E9 0D B0 A0 E1 08 D0 4D E2 02 10 A0 E1 1C2644E3 A03044E3 3B2600EB 0B D0 A0 E1 00 88 BD E8 1E FF 2F E1"); // 7 Player_move_c$$SlowdownTarget
                        break;
                    case 5://The Flash
                        Loader.write(formatOffset("0x9A03A4"), "00 48 2D E9 0D B0 A0 E1 08 D0 4D E2 02 10 A0 E1 1C2644E3 A03144E3 3B2600EB 0B D0 A0 E1 00 88 BD E8 1E FF 2F E1"); // 7 Player_move_c$$SlowdownTarget
                        break;
                }
            }
            public void onNothingSelected(AdapterView<?> adapterView) {}
        });
        addSwitch("Fly", new CompoundButton.OnCheckedChangeListener()
        {
            public void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
            {
                if (paramAnonymousBoolean)
                {
                    Loader.write(formatOffset("0x6A1068"), "01 00 A0 E3 1E FF 2F E1"); // EffectsController$$get_NinjaJumpEnabled
                    Loader.write(formatOffset("0x1D641AC"), "01 60 A0 E3");
                    Loader.write(formatOffset("0x1D641BC"), "00 00 A0 E3");
                    return;
                }
                Loader.write(formatOffset("0x6A1068"), "F0 4D 2D E9 18 B0 8D E2"); // EffectsController$$get_NinjaJumpEnabled
                Loader.write(formatOffset("0x1D641AC"), "00 60 A0 E3");
                Loader.write(formatOffset("0x1D641BC"), "01 00 A0 E3");
            }
        });
        addSpinner("Freedom", new String[]{"Unchanged","0","-1","-100","-1000"},new AdapterView.OnItemSelectedListener()
        {
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l)
            {
                switch (position){
                    case 0://Unchanged
                        Loader.write(formatOffset("0x69DA78"), "00 48 2D E9 0D B0 A0 E1"); // ItemPrice$$get_Price
                        Loader.write(formatOffset("0x1291C68"), "00 50 45 E0");
                        break;
                    case 1://0
                        Loader.write(formatOffset("0x69DA78"), "0000A0E3 1E FF 2F E1"); // ItemPrice$$get_Price
                        Loader.write(formatOffset("0x1291C68"), "00 50 85 E0");
                        break;
                    case 2://-1
                        Loader.write(formatOffset("0x69DA78"), "0000E0E3 1E FF 2F E1"); // ItemPrice$$get_Price
                        Loader.write(formatOffset("0x1291C68"), "00 50 85 E0");
                        break;
                    case 3://-100
                        Loader.write(formatOffset("0x69DA78"), "6300E0E3 1E FF 2F E1"); // ItemPrice$$get_Price
                        Loader.write(formatOffset("0x1291C68"), "00 50 85 E0");
                        break;
                    case 4://-1000
                        Loader.write(formatOffset("0x69DA78"), "F90FE0E3 1E FF 2F E1"); // ItemPrice$$get_Price
                        Loader.write(formatOffset("0x1291C68"), "00 50 85 E0");
                        break;
                }
            }
            public void onNothingSelected(AdapterView<?> adapterView) {}
        });
        /*
        addSpinner("BattlePass Freedom", new String[]{"Unchanged","0","-1","-100","-1000"},new AdapterView.OnItemSelectedListener()
        {
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l)
            {
                switch (position){
                    case 0://Unchanged
                        Loader.write(formatOffset("18F63B8"), "30 00 80 E2 00 10 A0 E3");
                        Loader.write(formatOffset("18F64A0"), "38 00 80 E2 00 10 A0 E3");
                        Loader.write(formatOffset("18F6588"), "40 00 80 E2 00 10 A0 E3");
                        Loader.write(formatOffset("18F6670"), "48 00 80 E2 00 10 A0 E3");
                        break;
                    case 1://0
                        Loader.write(formatOffset("5DB558"), "0000A0E3 1E FF 2F E1");
                        Loader.write(formatOffset("18F63B8"), "0000A0E3 1E FF 2F E1");
                        Loader.write(formatOffset("18F64A0"), "0000A0E3 1E FF 2F E1");
                        Loader.write(formatOffset("18F6588"), "0000A0E3 1E FF 2F E1");
                        Loader.write(formatOffset("18F6670"), "0000A0E3 1E FF 2F E1");
                        break;
                    case 2://-1
                        Loader.write(formatOffset("5DB558"), "0000E0E3 1E FF 2F E1");
                        Loader.write(formatOffset("18F63B8"), "0000E0E3 1E FF 2F E1");
                        Loader.write(formatOffset("18F64A0"), "0000E0E3 1E FF 2F E1");
                        Loader.write(formatOffset("18F6588"), "0000E0E3 1E FF 2F E1");
                        Loader.write(formatOffset("18F6670"), "0000E0E3 1E FF 2F E1");
                        break;
                    case 3://-100
                        Loader.write(formatOffset("18F63B8"), "6300E0E3 1E FF 2F E1");
                        Loader.write(formatOffset("18F64A0"), "6300E0E3 1E FF 2F E1");
                        Loader.write(formatOffset("18F6588"), "6300E0E3 1E FF 2F E1");
                        Loader.write(formatOffset("18F6670"), "6300E0E3 1E FF 2F E1");
                        break;
                    case 4://-1000
                        Loader.write(formatOffset("18F63B8"), "F90FE0E3 1E FF 2F E1");
                        Loader.write(formatOffset("18F64A0"), "F90FE0E3 1E FF 2F E1");
                        Loader.write(formatOffset("18F6588"), "F90FE0E3 1E FF 2F E1");
                        Loader.write(formatOffset("18F6670"), "F90FE0E3 1E FF 2F E1");
                        break;
                }
            }
            public void onNothingSelected(AdapterView<?> adapterView) {}
        });*/
        addSwitch("NoClip", new CompoundButton.OnCheckedChangeListener()
        {
            public void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
            {
                if (paramAnonymousBoolean) // FirstPersonControlSharp$$Update2
                {
                    Loader.write(formatOffset("0x1D6598C"), "84 00 94 E5 00 10 A0 E3 00 20 A0 E3 001000E3801F47E3 B59218EB 00 F0 20 E3 00 F0 20 E3 00 F0 20 E3"); // 6    LDR             R0, [R4,#0xB4] CharacterController$$set_radius
                    new Handler().postDelayed(new Runnable() {
                        public void run()
                        {
                            Loader.write(formatOffset("0x1D6598C"),"84 00 94 E5 00 00 50 E3 A4 01 00 0A 00 10 A0 E3 30 90 1B E5 2C A0 1B E5 3C 95 18 EB 01 00 50 E3 9A 01 00 1A");
                        }
                    }, 500);
                    return;
                } // 7DD026EB
                Loader.write(formatOffset("0x1D6598C"), "B4 00 94 E5 00 10 A0 E3 00 20 A0 E3 001000E3801F43E3 B59218EB 00 F0 20 E3 00 F0 20 E3 00 F0 20 E3"); // // 6    LDR             R0, [R4,#0xB4] CharacterController$$set_radius
                new Handler().postDelayed(new Runnable() {
                    public void run()
                    {
                        Loader.write(formatOffset("0x1D6598C"),"84 00 94 E5 00 00 50 E3 A4 01 00 0A 00 10 A0 E3 30 90 1B E5 2C A0 1B E5 3C 95 18 EB 01 00 50 E3 9A 01 00 1A");
                    }
                }, 500);
            }
        });/*
        addButton("Add 100 Coins", new OnClickListener()
        {
            public void onClick(View v)
            {//                                                                                        4 MainMenuController$$IsShowRentExpiredPoint             9 BankController$$AddCoins
                Loader.write(formatOffset("1535CA4"), "00 48 2D E9 0D B0 A0 E1 08 D0 4D E2 ADF1FFEB 01 00 50 E3 02 00 00 1A 64 10 A0 E3 00 20 A0 E3 121AE0EB 0B D0 A0 E1 00 88 BD E8 1E FF 2F E1"); // MainMenuController$$UpdateInappBonusChestActiveState
                Loader.write(formatOffset("D4C3A8"), "00 F0 20 E3");
                Loader.write(formatOffset("153236C"), "00 00 A0 E3 1E FF 2F E1");  // MainMenuController$$IsShowRentExpiredPoint
                new Handler().postDelayed(new Runnable() {
                    public void run()
                    {
                        Loader.write(formatOffset("153236C"), "01 00 A0 E3 1E FF 2F E1");  // MainMenuController$$IsShowRentExpiredPoint
                        new Handler().postDelayed(new Runnable() {
                            public void run()
                            {
                                Loader.write(formatOffset("153236C"), "00 00 A0 E3 1E FF 2F E1");  // MainMenuController$$IsShowRentExpiredPoint
                                new Handler().postDelayed(new Runnable() {
                                    public void run()
                                    {
                                        Loader.write(formatOffset("1535CA4"), "F0 4D 2D E9 18 B0 8D E2 00 40 A0 E1 44 04 9F E5 44 54 9F E5 00 00 8F E0 00 00 85 E0 A6 00 D0 E5 00 00 50 E3 08 00 00 1A 30 04 9F E5 30 14 9F E5"); // MainMenuController$$UpdateInappBonusChestActiveState
                                        Loader.write(formatOffset("D4C3A8"), "EF 97 1F EB");
                                        Loader.write(formatOffset("153236C"), "F0 48 2D E9 10 B0 8D E2");  // MainMenuController$$IsShowRentExpiredPoint
                                    }
                                }, 20);
                            }
                        }, 20);
                    }
                }, 20);
            }
        });
        addButton("Sub 100 Coins", new OnClickListener()
        {
            public void onClick(View v)
            {//                                                                                        4 MainMenuController$$IsShowRentExpiredPoint             9 BankController$$AddCoins
                Loader.write(formatOffset("1535CA4"), "00 48 2D E9 0D B0 A0 E1 08 D0 4D E2 ADF1FFEB 01 00 50 E3 02 00 00 1A 63 10 E0 E3 00 20 A0 E3 121AE0EB 0B D0 A0 E1 00 88 BD E8 1E FF 2F E1"); // MainMenuController$$UpdateInappBonusChestActiveState
                Loader.write(formatOffset("D4C3A8"), "00 F0 20 E3");
                Loader.write(formatOffset("153236C"), "00 00 A0 E3 1E FF 2F E1");  // MainMenuController$$IsShowRentExpiredPoint
                new Handler().postDelayed(new Runnable() {
                    public void run()
                    {
                        Loader.write(formatOffset("153236C"), "01 00 A0 E3 1E FF 2F E1"); // MainMenuController$$IsShowRentExpiredPoint
                        new Handler().postDelayed(new Runnable() {
                            public void run()
                            {
                                Loader.write(formatOffset("153236C"), "00 00 A0 E3 1E FF 2F E1"); // MainMenuController$$IsShowRentExpiredPoint
                                new Handler().postDelayed(new Runnable() {
                                    public void run()
                                    {
                                        Loader.write(formatOffset("1535CA4"), "F0 4D 2D E9 18 B0 8D E2 00 40 A0 E1 44 04 9F E5 44 54 9F E5 00 00 8F E0 00 00 85 E0 A6 00 D0 E5 00 00 50 E3 08 00 00 1A 30 04 9F E5 30 14 9F E5"); // MainMenuController$$UpdateInappBonusChestActiveState
                                        Loader.write(formatOffset("D4C3A8"), "EF 97 1F EB");
                                        Loader.write(formatOffset("153236C"), "F0 48 2D E9 10 B0 8D E2"); // MainMenuController$$IsShowRentExpiredPoint
                                    }
                                }, 20);
                            }
                        }, 20);
                    }
                }, 20);
            }
        });
        addButton("Add 100 Gems", new OnClickListener()
        {
            public void onClick(View v)
            {//                                                                                        4 MainMenuController$$IsShowRentExpiredPoint             9 BankController$$AddGems
                Loader.write(formatOffset("1535CA4"), "00 48 2D E9 0D B0 A0 E1 08 D0 4D E2 ADF1FFEB 01 00 50 E3 02 00 00 1A 64 10 A0 E3 00 20 A0 E3 541BE0EB 0B D0 A0 E1 00 88 BD E8 1E FF 2F E1"); // MainMenuController$$UpdateInappBonusChestActiveState
                Loader.write(formatOffset("D4C3A8"), "00 F0 20 E3");
                Loader.write(formatOffset("153236C"), "00 00 A0 E3 1E FF 2F E1"); // MainMenuController$$IsShowRentExpiredPoint
                new Handler().postDelayed(new Runnable() {
                    public void run()
                    {
                        Loader.write(formatOffset("153236C"), "01 00 A0 E3 1E FF 2F E1"); // MainMenuController$$IsShowRentExpiredPoint
                        new Handler().postDelayed(new Runnable() {
                            public void run()
                            {
                                Loader.write(formatOffset("153236C"), "00 00 A0 E3 1E FF 2F E1"); // MainMenuController$$IsShowRentExpiredPoint
                                new Handler().postDelayed(new Runnable() {
                                    public void run()
                                    {
                                        Loader.write(formatOffset("1535CA4"), "F0 4D 2D E9 18 B0 8D E2 00 40 A0 E1 44 04 9F E5 44 54 9F E5 00 00 8F E0 00 00 85 E0 A6 00 D0 E5 00 00 50 E3 08 00 00 1A 30 04 9F E5 30 14 9F E5"); // MainMenuController$$UpdateInappBonusChestActiveState
                                        Loader.write(formatOffset("D4C3A8"), "EF 97 1F EB");
                                        Loader.write(formatOffset("153236C"), "F0 48 2D E9 10 B0 8D E2"); // MainMenuController$$IsShowRentExpiredPoint
                                    }
                                }, 20);
                            }
                        }, 20);
                    }
                }, 20);
            }
        });
        addButton("Sub 100 Gems", new OnClickListener()
        {
            public void onClick(View v)
            {//                                                                                        4 MainMenuController$$IsShowRentExpiredPoint             9 BankController$$AddGems
                Loader.write(formatOffset("1535CA4"), "00 48 2D E9 0D B0 A0 E1 08 D0 4D E2 ADF1FFEB 01 00 50 E3 02 00 00 1A 63 10 E0 E3 00 20 A0 E3 541BE0EB 0B D0 A0 E1 00 88 BD E8 1E FF 2F E1"); // MainMenuController$$UpdateInappBonusChestActiveState
                Loader.write(formatOffset("D4C3A8"), "00 F0 20 E3");
                Loader.write(formatOffset("153236C"), "00 00 A0 E3 1E FF 2F E1"); // MainMenuController$$IsShowRentExpiredPoint
                new Handler().postDelayed(new Runnable() {
                    public void run()
                    {
                        Loader.write(formatOffset("153236C"), "01 00 A0 E3 1E FF 2F E1"); // MainMenuController$$IsShowRentExpiredPoint
                        new Handler().postDelayed(new Runnable() {
                            public void run()
                            {
                                Loader.write(formatOffset("153236C"), "00 00 A0 E3 1E FF 2F E1"); // MainMenuController$$IsShowRentExpiredPoint
                                new Handler().postDelayed(new Runnable() {
                                    public void run()
                                    {
                                        Loader.write(formatOffset("1535CA4"), "F0 4D 2D E9 18 B0 8D E2 00 40 A0 E1 44 04 9F E5 44 54 9F E5 00 00 8F E0 00 00 85 E0 A6 00 D0 E5 00 00 50 E3 08 00 00 1A 30 04 9F E5 30 14 9F E5"); // MainMenuController$$UpdateInappBonusChestActiveState
                                        Loader.write(formatOffset("D4C3A8"), "EF 97 1F EB");
                                        Loader.write(formatOffset("153236C"), "F0 48 2D E9 10 B0 8D E2"); // MainMenuController$$IsShowRentExpiredPoint
                                    }
                                }, 20);
                            }
                        }, 20);
                    }
                }, 20);
            }
        });
        addButton("Add 100 Keys", new OnClickListener()
        {
            public void onClick(View v)
            {//                                                                                        4 MainMenuController$$IsShowRentExpiredPoint             9 BankController$$AddEventCurrency
                Loader.write(formatOffset("1535CA4"), "00 48 2D E9 0D B0 A0 E1 08 D0 4D E2 ADF1FFEB 01 00 50 E3 02 00 00 1A 64 10 A0 E3 00 20 A0 E3 3319E0EB 0B D0 A0 E1 00 88 BD E8 1E FF 2F E1"); // MainMenuController$$UpdateInappBonusChestActiveState
                Loader.write(formatOffset("D4C3A8"), "00 F0 20 E3");
                Loader.write(formatOffset("153236C"), "00 00 A0 E3 1E FF 2F E1"); // MainMenuController$$IsShowRentExpiredPoint
                new Handler().postDelayed(new Runnable() {
                    public void run()
                    {
                        Loader.write(formatOffset("153236C"), "01 00 A0 E3 1E FF 2F E1"); // MainMenuController$$IsShowRentExpiredPoint
                        new Handler().postDelayed(new Runnable() {
                            public void run()
                            {
                                Loader.write(formatOffset("153236C"), "00 00 A0 E3 1E FF 2F E1"); // MainMenuController$$IsShowRentExpiredPoint
                                new Handler().postDelayed(new Runnable() {
                                    public void run()
                                    {
                                        Loader.write(formatOffset("1535CA4"), "F0 4D 2D E9 18 B0 8D E2 00 40 A0 E1 44 04 9F E5 44 54 9F E5 00 00 8F E0 00 00 85 E0 A6 00 D0 E5 00 00 50 E3 08 00 00 1A 30 04 9F E5 30 14 9F E5"); // MainMenuController$$UpdateInappBonusChestActiveState
                                        Loader.write(formatOffset("D4C3A8"), "EF 97 1F EB");
                                        Loader.write(formatOffset("153236C"), "F0 48 2D E9 10 B0 8D E2"); // MainMenuController$$IsShowRentExpiredPoint
                                    }
                                }, 20);
                            }
                        }, 20);
                    }
                }, 20);
            }
        });
        addButton("Sub 100 Keys", new OnClickListener()
        {
            public void onClick(View v)
            {//                                                                                        4 MainMenuController$$IsShowRentExpiredPoint             9 BankController$$AddEventCurrency
                Loader.write(formatOffset("1535CA4"), "00 48 2D E9 0D B0 A0 E1 08 D0 4D E2 ADF1FFEB 01 00 50 E3 02 00 00 1A 63 10 E0 E3 00 20 A0 E3 3319E0EB 0B D0 A0 E1 00 88 BD E8 1E FF 2F E1"); // MainMenuController$$UpdateInappBonusChestActiveState
                Loader.write(formatOffset("D4C3A8"), "00 F0 20 E3");
                Loader.write(formatOffset("153236C"), "00 00 A0 E3 1E FF 2F E1"); // MainMenuController$$IsShowRentExpiredPoint
                new Handler().postDelayed(new Runnable() {
                    public void run()
                    {
                        Loader.write(formatOffset("153236C"), "01 00 A0 E3 1E FF 2F E1"); // MainMenuController$$IsShowRentExpiredPoint
                        new Handler().postDelayed(new Runnable() {
                            public void run()
                            {
                                Loader.write(formatOffset("153236C"), "00 00 A0 E3 1E FF 2F E1"); // MainMenuController$$IsShowRentExpiredPoint
                                new Handler().postDelayed(new Runnable() {
                                    public void run()
                                    {
                                        Loader.write(formatOffset("1535CA4"), "F0 4D 2D E9 18 B0 8D E2 00 40 A0 E1 44 04 9F E5 44 54 9F E5 00 00 8F E0 00 00 85 E0 A6 00 D0 E5 00 00 50 E3 08 00 00 1A 30 04 9F E5 30 14 9F E5"); // MainMenuController$$UpdateInappBonusChestActiveState
                                        Loader.write(formatOffset("D4C3A8"), "EF 97 1F EB");
                                        Loader.write(formatOffset("153236C"), "F0 48 2D E9 10 B0 8D E2"); // MainMenuController$$IsShowRentExpiredPoint
                                    }
                                }, 20);
                            }
                        }, 20);
                    }
                }, 20);
            }
        });
        addButton("Add 999 medals", new OnClickListener()
        {
            public void onClick(View v)
            {//                                                                            3 MainMenuController$$IsShowRentExpiredPoint                         9 ClansController$$AddCurrency
                Loader.write(formatOffset("1535CA4"), "00 48 2D E9 0D B0 A0 E1 0338DFEB 01 00 50 E3 00 88 BD 18 E7 13 00 E3 00 20 A0 E3 00 48 BD E8 7ADEEFEA 1E FF 2F E1"); // MainMenuController$$UpdateInappBonusChestActiveState
                Loader.write(formatOffset("D4C3A8"), "00 F0 20 E3");
                Loader.write(formatOffset("153236C"), "00 00 A0 E3 1E FF 2F E1"); // MainMenuController$$IsShowRentExpiredPoint
                new Handler().postDelayed(new Runnable() {
                    public void run()
                    {
                        Loader.write(formatOffset("153236C"), "01 00 A0 E3 1E FF 2F E1"); // MainMenuController$$IsShowRentExpiredPoint
                        new Handler().postDelayed(new Runnable() {
                            public void run()
                            {
                                Loader.write(formatOffset("153236C"), "00 00 A0 E3 1E FF 2F E1"); // MainMenuController$$IsShowRentExpiredPoint
                                new Handler().postDelayed(new Runnable() {
                                    public void run()
                                    {
                                        Loader.write(formatOffset("1535CA4"), "F0 4D 2D E9 18 B0 8D E2 00 40 A0 E1 44 04 9F E5 44 54 9F E5 00 00 8F E0 00 00 85 E0 A6 00 D0 E5 00 00 50 E3 08 00 00 1A 30 04 9F E5 30 14 9F E5"); // MainMenuController$$UpdateInappBonusChestActiveState
                                        Loader.write(formatOffset("D4C3A8"), "EF 97 1F EB");
                                        Loader.write(formatOffset("153236C"), "F0 48 2D E9 10 B0 8D E2"); // MainMenuController$$IsShowRentExpiredPoint
                                    }
                                }, 20);
                            }
                        }, 20);
                    }
                }, 20);
            }
        });*/
        /*
        addSpinner("News Button Click", new String[]{"Unchanged","Add 100 Coins","Sub 100 Coins","Add 100 Gems","Sub 100 Gems","Add 100 Keys","Sub 100 Keys","Add 999 Medals","Add 100 Trophies","Sub 100 Trophies"},new AdapterView.OnItemSelectedListener()
        {
          public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l)
          {
            switch (position){
              case 0:
                Loader.write(formatOffset("E0120C"), "70 4C 2D E9 10 B0 8D E2 00 40 A0 E1 58 02 9F E5 58 52 9F E5 00 00 8F E0 00 00 85 E0 E5 00 D0 E5 00 00 50 E3 08 00 00 1A 44 02 9F E5 44 12 9F E5 00 60 8F E0 06 00 91 E7 00 00 90 E5");
                break;
              case 1:  // 100 Coins
                Loader.write(formatOffset("E0120C"), "00 48 2D E9 0D B0 A0 E1 08 D0 4D E2 64 10 A0 E3 00 20 A0 E3 482FF4EB 0B D0 A0 E1 00 88 BD E8 1E FF 2F E1");
                break;
              case 2:  // -100 Coins
                Loader.write(formatOffset("E0120C"), "00 48 2D E9 0D B0 A0 E1 08 D0 4D E2 63 10 E0 E3 00 20 A0 E3 482FF4EB 0B D0 A0 E1 00 88 BD E8 1E FF 2F E1");
                break;
              case 3:  // 100 Gems
                Loader.write(formatOffset("E0120C"), "00 48 2D E9 0D B0 A0 E1 08 D0 4D E2 64 10 A0 E3 00 20 A0 E3 A72FF4EB 0B D0 A0 E1 00 88 BD E8 1E FF 2F E1");
                break;
              case 4:  // -100 Gems
                Loader.write(formatOffset("E0120C"), "00 48 2D E9 0D B0 A0 E1 08 D0 4D E2 63 10 E0 E3 00 20 A0 E3 A72FF4EB 0B D0 A0 E1 00 88 BD E8 1E FF 2F E1");
                break;
              case 5:  // 100 Keys
                Loader.write(formatOffset("E0120C"), "00 48 2D E9 0D B0 A0 E1 08 D0 4D E2 64 10 A0 E3 00 20 A0 E3 692EF4EB 0B D0 A0 E1 00 88 BD E8 1E FF 2F E1");
                break;
              case 6:  // -100 Keys
                Loader.write(formatOffset("E0120C"), "00 48 2D E9 0D B0 A0 E1 08 D0 4D E2 63 10 E0 E3 00 20 A0 E3 692EF4EB 0B D0 A0 E1 00 88 BD E8 1E FF 2F E1");
                break;
              case 7:  // 999 Medals
                Loader.write(formatOffset("E0120C"), "E7 13 00 E3 00 20 A0 E3 6FE205EA 1E FF 2F E1");
                break;
              case 8:  // 100 Trophies
                Loader.write(formatOffset("E0120C"), "64 10 A0 E3 00 20 A0 E3 3C782EEA 1E FF 2F E1");
                break;
              case 9:  // -100 Trophies
                Loader.write(formatOffset("E0120C"), "63 10 E0 E3 00 20 A0 E3 3C782EEA 1E FF 2F E1");
                break;
            }
          }
          public void onNothingSelected(AdapterView<?> adapterView) {}
        });
        */
        addSwitch("Ammo", new CompoundButton.OnCheckedChangeListener()
        {
            public void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
            {
                if (paramAnonymousBoolean)
                {
                    Loader.write(formatOffset("0x99A7A4"), "00 F0 20 E3"); // Weapon$$get_currentAmmoInClip 9
                    Loader.write(formatOffset("0x99AB00"), "00 F0 20 E3"); // Weapon$$get_currentAmmoInClip 11
                    Loader.write(formatOffset("0x99BD1C"), "00 F0 20 E3"); // Weapon$$get_currentAmmoInClip 12
                    return;
                }
                Loader.write(formatOffset("0x99A7A4"), "01 10 40 E2"); // Weapon$$get_currentAmmoInClip 9
                Loader.write(formatOffset("0x99AB00"), "01 10 40 E2"); // Weapon$$get_currentAmmoInClip 11
                Loader.write(formatOffset("0x99BD1C"), "01 10 40 E2"); // Weapon$$get_currentAmmoInClip 12
            }
        });
        addSwitch("Anti Self-Kill", new CompoundButton.OnCheckedChangeListener()
        {
            public void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
            {
                if (paramAnonymousBoolean)
                {
                    //Loader.write(formatOffset("A8A1CC"), "1E FF 2F E1"); // Player_move_c$$SuicidePenalty
                    Loader.write(formatOffset("0x992150"), "1E FF 2F E1"); // Player_move_c$$SuicideFall
                    Loader.write(formatOffset("0x987B7C"), "1E FF 2F E1"); // Player_move_c$$ImSuicide
                    Loader.write(formatOffset("0x992424"), "1E FF 2F E1"); // Player_move_c$$KillSelf
                    Loader.write(formatOffset("0x992378"), "1E FF 2F E1"); // Player_move_c$$SuicideFallCoroutine
                    return;
                }
                //Loader.write(formatOffset("A8A1CC"), "70 4C 2D E9"); // Player_move_c$$SuicidePenalty
                Loader.write(formatOffset("0x992150"), "70 4C 2D E9"); // Player_move_c$$SuicideFall
                Loader.write(formatOffset("0x987B7C"), "F0 48 2D E9"); // Player_move_c$$ImSuicide
                Loader.write(formatOffset("0x992424"), "F0 48 2D E9"); // Player_move_c$$KillSelf
                Loader.write(formatOffset("0x992378"), "70 4C 2D E9"); // Player_move_c$$SuicideFallCoroutine
            }
        });
        addSeekbar(8, new SeekBar.OnSeekBarChangeListener()
        {
            String name = "Bullet Spread: ";
            TextView zoomtext = Loader.addText(name +"Default");
            String offset = "0x9A3E68"; // Player_move_c$$BulletShot

            public void onProgressChanged(SeekBar paramAnonymousSeekBar, int paramAnonymousInt, boolean paramAnonymousBoolean)
            {
                switch (paramAnonymousInt)
                {
                    case 0:
                        this.zoomtext.setText(name +"Default");
                        Loader.write(formatOffset(offset), "92 8E 33 EB");
                        break;
                    case 1:
                        this.zoomtext.setText(name +"x0.00");
                        Loader.write(formatOffset(offset), "00 F0 20 E3");
                        break;
                    case 2:
                        this.zoomtext.setText(name +"x1.00");
                        Loader.write(formatOffset(offset), "80 0F 43 E3");
                        break;
                    case 3:
                        this.zoomtext.setText(name +"x1.25");
                        Loader.write(formatOffset(offset), "A0 0F 43 E3");
                        break;
                    case 4:
                        this.zoomtext.setText(name +"x1.50");
                        Loader.write(formatOffset(offset), "C0 0F 43 E3");
                        break;
                    case 5:
                        this.zoomtext.setText(name +"x1.75");
                        Loader.write(formatOffset(offset), "E0 0F 43 E3");
                        break;
                    case 6:
                        this.zoomtext.setText(name +"x2.00");
                        Loader.write(formatOffset(offset), "00 00 44 E3");
                        break;
                    case 7:
                        this.zoomtext.setText(name +"x10.00");
                        Loader.write(formatOffset(offset), "20 01 44 E3");
                        break;
                    case 8:
                        this.zoomtext.setText(name +"x20.00");
                        Loader.write(formatOffset(offset), "A0 01 44 E3");
                        break;
                }
            }

            public void onStartTrackingTouch(SeekBar paramAnonymousSeekBar) {}

            public void onStopTrackingTouch(SeekBar paramAnonymousSeekBar) {}
        });
        addSeekbar(11, new SeekBar.OnSeekBarChangeListener()
        {
            String name = "Field Of View: ";
            TextView zoomtext = Loader.addText(name +"Default");
            String offset = "0x238517C"; // Camera$$set_fieldOfView    MOV             R4, R1
            String offset2 = "0x23850D8"; // Camera$$get_fieldOfView    MOV             R4, R0

            public void onProgressChanged(SeekBar paramAnonymousSeekBar, int paramAnonymousInt, boolean paramAnonymousBoolean)
            {
                switch (paramAnonymousInt)
                {
                    case 0:
                        this.zoomtext.setText(name +"Default");
                        Loader.write(formatOffset(offset), "01 40 A0 E1");
                        Loader.write(formatOffset(offset2), "00 40 A0 E1");
                        break;
                    case 1:
                        this.zoomtext.setText(name +"x0");
                        Loader.write(formatOffset(offset), "00 40 A0 E3");
                        Loader.write(formatOffset(offset2), "00 40 A0 E3");
                        break;
                    case 2:
                        this.zoomtext.setText(name +"25");
                        Loader.write(formatOffset(offset), "C84144E3");
                        Loader.write(formatOffset(offset2), "C84144E3");
                        break;
                    case 3:
                        this.zoomtext.setText(name +"50");
                        Loader.write(formatOffset(offset), "484244E3");
                        Loader.write(formatOffset(offset2), "484244E3");
                        break;
                    case 4:
                        this.zoomtext.setText(name +"75");
                        Loader.write(formatOffset(offset), "964244E3");
                        Loader.write(formatOffset(offset2), "964244E3");
                        break;
                    case 5:
                        this.zoomtext.setText(name +"100");
                        Loader.write(formatOffset(offset), "C84244E3");
                        Loader.write(formatOffset(offset2), "C84244E3");
                        break;
                    case 6:
                        this.zoomtext.setText(name +"125");
                        Loader.write(formatOffset(offset), "FA4244E3");
                        Loader.write(formatOffset(offset2), "FA4244E3");
                        break;
                    case 7:
                        this.zoomtext.setText(name +"150");
                        Loader.write(formatOffset(offset), "164344E3");
                        Loader.write(formatOffset(offset2), "164344E3");
                        break;
                    case 8:
                        this.zoomtext.setText(name +"x175");
                        Loader.write(formatOffset(offset), "2F4344E3");
                        Loader.write(formatOffset(offset2), "2F4344E3");
                        break;
                    case 9:
                        this.zoomtext.setText(name +"x200");
                        Loader.write(formatOffset(offset), "484344E3");
                        Loader.write(formatOffset(offset2), "484344E3");
                        break;
                    case 10:
                        this.zoomtext.setText(name +"x225");
                        Loader.write(formatOffset(offset), "614344E3");
                        Loader.write(formatOffset(offset2), "614344E3");
                        break;
                    case 11:
                        this.zoomtext.setText(name +"x250");
                        Loader.write(formatOffset(offset), "C84244E3");
                        Loader.write(formatOffset(offset2), "C84244E3");
                        break;
                }
            }

            public void onStartTrackingTouch(SeekBar paramAnonymousSeekBar) {}

            public void onStopTrackingTouch(SeekBar paramAnonymousSeekBar) {}
        });
        addSeekbar(8, new SeekBar.OnSeekBarChangeListener()
        {
            String name = "Run Speed: ";
            TextView zoomtext = Loader.addText(name +"Default");
            String offset = "0x6A50D4"; // EffectsController$$SpeedModifier

            public void onProgressChanged(SeekBar paramAnonymousSeekBar, int paramAnonymousInt, boolean paramAnonymousBoolean)
            {
                switch (paramAnonymousInt)
                {
                    case 0:
                        this.zoomtext.setText(name +"Default");
                        Loader.write(formatOffset(offset), "F0 48 2D E9 10 B0 8D E2");
                        break;
                    case 1:
                        this.zoomtext.setText(name +"x0.01");
                        Loader.write(formatOffset(offset), "24 0C 43 E3 1E FF 2F E1");
                        break;
                    case 2:
                        this.zoomtext.setText(name +"x1.00");
                        Loader.write(formatOffset(offset), "80 0F 43 E3 1E FF 2F E1");
                        break;
                    case 3:
                        this.zoomtext.setText(name +"x1.25");
                        Loader.write(formatOffset(offset), "A0 0F 43 E3 1E FF 2F E1");
                        break;
                    case 4:
                        this.zoomtext.setText(name +"x1.50");
                        Loader.write(formatOffset(offset), "C0 0F 43 E3 1E FF 2F E1");
                        break;
                    case 5:
                        this.zoomtext.setText(name +"x1.75");
                        Loader.write(formatOffset(offset), "E0 0F 43 E3 1E FF 2F E1");
                        break;
                    case 6:
                        this.zoomtext.setText(name +"x2.00");
                        Loader.write(formatOffset(offset), "00 00 44 E3 1E FF 2F E1");
                        break;
                    case 7:
                        this.zoomtext.setText(name +"x10.00");
                        Loader.write(formatOffset(offset), "20 01 44 E3 1E FF 2F E1");
                        break;
                    case 8:
                        this.zoomtext.setText(name +"x20.00");
                        Loader.write(formatOffset(offset), "A0 01 44 E3 1E FF 2F E1");
                        break;
                }
            }

            public void onStartTrackingTouch(SeekBar paramAnonymousSeekBar) {}

            public void onStopTrackingTouch(SeekBar paramAnonymousSeekBar) {}
        });
        addSeekbar(8, new SeekBar.OnSeekBarChangeListener()
        {
            String name = "Jump Height: ";
            TextView zoomtext = Loader.addText(name + "Default");
            String offset = "0x6A0644"; // EffectsController$$get_JumpModifier

            public void onProgressChanged(SeekBar paramAnonymousSeekBar, int paramAnonymousInt, boolean paramAnonymousBoolean)
            {
                switch (paramAnonymousInt)
                {
                    case 0:
                        this.zoomtext.setText(name + "Default");
                        Loader.write(formatOffset(offset), "F0 48 2D E9 10 B0 8D E2");
                        break;
                    case 1:
                        this.zoomtext.setText(name + "x0.01");
                        Loader.write(formatOffset(offset), "24 0C 43 E3 1E FF 2F E1");
                        break;
                    case 2:
                        this.zoomtext.setText(name + "x1.00");
                        Loader.write(formatOffset(offset), "80 0F 43 E3 1E FF 2F E1");
                        break;
                    case 3:
                        this.zoomtext.setText(name + "x1.25");
                        Loader.write(formatOffset(offset), "A0 0F 43 E3 1E FF 2F E1");
                        break;
                    case 4:
                        this.zoomtext.setText(name + "x1.50");
                        Loader.write(formatOffset(offset), "C0 0F 43 E3 1E FF 2F E1");
                        break;
                    case 5:
                        this.zoomtext.setText(name + "x1.75");
                        Loader.write(formatOffset(offset), "E0 0F 43 E3 1E FF 2F E1");
                        break;
                    case 6:
                        this.zoomtext.setText(name + "x2.00");
                        Loader.write(formatOffset(offset), "00 00 44 E3 1E FF 2F E1");
                        break;
                    case 7:
                        this.zoomtext.setText(name + "x10.00");
                        Loader.write(formatOffset(offset), "20 01 44 E3 1E FF 2F E1");
                        break;
                    case 8:
                        this.zoomtext.setText(name +"x20.00");
                        Loader.write(formatOffset(offset), "A0 01 44 E3 1E FF 2F E1");
                        break;
                }
            }

            public void onStartTrackingTouch(SeekBar paramAnonymousSeekBar) {}

            public void onStopTrackingTouch(SeekBar paramAnonymousSeekBar) {}
        });
        addSpinner("Level Changer", new String[] {"Unchanged","Level 1","Level 6","Level 11","Level 16","Level 21","Level 26","Level 31","Level 36","Level 38"} ,new AdapterView.OnItemSelectedListener()
        {
            String offset1 = "0x21D6834"; // ExperienceController$$get_currentLevel
            String offset2 = "0x21DF130"; // ExperienceController$$GetCurrentLevel
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l)
            {
                switch (position){
                    case 0:
                        Loader.write(formatOffset(offset1), "70 4C 2D E9 10 B0 8D E2");
                        Loader.write(formatOffset(offset2), "30 48 2D E9 08 B0 8D E2");
                        break;
                    case 1:
                        Loader.write(formatOffset(offset1), "01 00 A0 E3 1E FF 2F E1");
                        Loader.write(formatOffset(offset2), "01 00 A0 E3 1E FF 2F E1");
                        break;
                    case 2:
                        Loader.write(formatOffset(offset1), "06 00 A0 E3 1E FF 2F E1");
                        Loader.write(formatOffset(offset2), "06 00 A0 E3 1E FF 2F E1");
                        break;
                    case 3:
                        Loader.write(formatOffset(offset1), "0B 00 A0 E3 1E FF 2F E1");
                        Loader.write(formatOffset(offset2), "0B 00 A0 E3 1E FF 2F E1");
                        break;
                    case 4:
                        Loader.write(formatOffset(offset1), "10 00 A0 E3 1E FF 2F E1");
                        Loader.write(formatOffset(offset2), "10 00 A0 E3 1E FF 2F E1");
                        break;
                    case 5:
                        Loader.write(formatOffset(offset1), "15 00 A0 E3 1E FF 2F E1");
                        Loader.write(formatOffset(offset2), "15 00 A0 E3 1E FF 2F E1");
                        break;
                    case 6:
                        Loader.write(formatOffset(offset1), "1A 00 A0 E3 1E FF 2F E1");
                        Loader.write(formatOffset(offset2), "1A 00 A0 E3 1E FF 2F E1");
                        break;
                    case 7:
                        Loader.write(formatOffset(offset1), "1F 00 A0 E3 1E FF 2F E1");
                        Loader.write(formatOffset(offset2), "1F 00 A0 E3 1E FF 2F E1");
                        break;
                    case 8:
                        Loader.write(formatOffset(offset1), "24 00 A0 E3 1E FF 2F E1");
                        Loader.write(formatOffset(offset2), "24 00 A0 E3 1E FF 2F E1");
                        break;
                    case 9:
                        Loader.write(formatOffset(offset1), "26 00 A0 E3 1E FF 2F E1");
                        Loader.write(formatOffset(offset2), "26 00 A0 E3 1E FF 2F E1");
                        break;
                }
            }
            public void onNothingSelected(AdapterView<?> adapterView) {}
        });
        addSwitch("God Turret", new CompoundButton.OnCheckedChangeListener()
        {
            public void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
            {
                if (paramAnonymousBoolean)
                {
                    Loader.write(formatOffset("0x1BC537C"), "1E FF 2F E1"); // TurretController$$MinusLive
                    Loader.write(formatOffset("0x1BCA4B0"), "1E FF 2F E1"); // TurretController$$MinusLive_xxxx
                    Loader.write(formatOffset("0x1BCA824"), "1E FF 2F E1"); // TurretController$$MinusLiveReal
                    Loader.write(formatOffset("0x1BC7974"), "01 10 A0 E3"); // TurretController$$UpdateTurret | DCFS 0.05 -> MOV             R1, #0
                    return;
                }
                Loader.write(formatOffset("0x1BC537C"), "F0 4F 2D E9"); // TurretController$$MinusLive
                Loader.write(formatOffset("0x1BCA4B0"), "F0 4F 2D E9"); // TurretController$$MinusLive_xxxx
                Loader.write(formatOffset("0x1BCA824"), "F0 4F 2D E9"); // TurretController$$MinusLiveReal
                Loader.write(formatOffset("0x1BC7974"), "00 10 A0 E3"); // TurretController$$UpdateTurret | DCFS 0.05 -> MOV             R1, #0
            }
        });
        addSwitch("God Drone", new CompoundButton.OnCheckedChangeListener()
        {
            public void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
            {
                if (paramAnonymousBoolean)
                {
                    Loader.write(formatOffset("0x98783C"), "1E FF 2F E1"); // Player_move_c$$RemoveDrone
                    return;
                }
                Loader.write(formatOffset("0x98783C"), "70 4C 2D E9"); // Player_move_c$$RemoveDrone
            }
        });/*
        addSwitch("Pet Points", new CompoundButton.OnCheckedChangeListener()
        {
            public void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
            {
                if (paramAnonymousBoolean)
                {
                    Loader.write(formatOffset("1BB8D74"), "FF 00 80 E2");
                    Loader.write(formatOffset("1BB9FA4"), "0F 07 02 E3");

                    return;
                }
                Loader.write(formatOffset("1BB8D74"), "01 00 80 E2");
                Loader.write(formatOffset("1BB9FA4"), "0D 00 12 EB");
            }
        });*/
        addSwitch("Tutorial Done", new CompoundButton.OnCheckedChangeListener()
        {
            public void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
            {
                if (paramAnonymousBoolean)
                {
                    Loader.write(formatOffset("0x1B91898"), "01 00 A0 E3 1E FF 2F E1"); // TrainingController$$get_TrainingCompleted
                    return;
                }
                Loader.write(formatOffset("0x1B91898"), "F0 4D 2D E9 18 B0 8D E2"); // TrainingController$$get_TrainingCompleted
            }
        });
        addSwitch("VIP Mode", new CompoundButton.OnCheckedChangeListener()
        {
            public void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
            {
                if (paramAnonymousBoolean)
                {
                    Loader.write(formatOffset("0x2121CEC"), "01 00 A0 E3 1E FF 2F E1"); // VIPController$$get_VIPActive
                    return;
                }
                Loader.write(formatOffset("0x2121CEC"), "00 48 2D E9 0D B0 A0 E1"); // VIPController$$get_VIPActive
            }
        });/*
        addSwitch("NOT-Family-Friendly", new CompoundButton.OnCheckedChangeListener()
        {
            public void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
            {
                if (paramAnonymousBoolean)
                {
                    Loader.write(formatOffset("169BFE0"), "01 00 A0 E1 1E FF 2F E1");
                    return;
                }
                Loader.write(formatOffset("169BFE0"), "F0 4F 2D E9 1C B0 8D E2");
            }
        });
        addSwitch("Violence", new CompoundButton.OnCheckedChangeListener()
        {
            public void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
            {
                if (paramAnonymousBoolean)
                {
                    Loader.write(formatOffset("9C53BC"), "33 10 A0 E3");
                    Loader.write(formatOffset("9C53C4"), "33 10 A0 E3");
                    Loader.write(formatOffset("9C5648"), "33 10 A0 E3");
                    Loader.write(formatOffset("9C565C"), "33 10 A0 E3");
                    Loader.write(formatOffset("9C5670"), "33 10 A0 E3");
                    Loader.write(formatOffset("9C5684"), "33 10 A0 E3");
                    Loader.write(formatOffset("9C5698"), "33 10 A0 E3");
                    return;
                }
                Loader.write(formatOffset("9C53BC"), "2C 10 A0 E3");
                Loader.write(formatOffset("9C53C4"), "32 10 A0 E3");
                Loader.write(formatOffset("9C5648"), "2D 10 A0 E3");
                Loader.write(formatOffset("9C565C"), "2E 10 A0 E3");
                Loader.write(formatOffset("9C5670"), "2F 10 A0 E3");
                Loader.write(formatOffset("9C5684"), "30 10 A0 E3");
                Loader.write(formatOffset("9C5698"), "31 10 A0 E3");

            }
        });
        addSwitch("100 Kills Plus", new CompoundButton.OnCheckedChangeListener()
        {
            public void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
            {
                if (paramAnonymousBoolean)
                {
                    Loader.write(formatOffset("9C3008"), "64 10 80 E2");
                    Loader.write(formatOffset("9C5780"), "64 10 80 E2");
                    return;
                }
                Loader.write(formatOffset("9C3008"), "01 10 80 E2");
                Loader.write(formatOffset("9C5780"), "01 10 80 E2");
            }
        });*/
        addSwitch("Always Go", new CompoundButton.OnCheckedChangeListener()
        {
            public void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
            {
                if (paramAnonymousBoolean)
                {
                    Loader.write(formatOffset("0x94B43C"), "01 00 A0 E3 1E FF 2F E1"); // Player_move_c$$get_isGo
                    return;
                }
                Loader.write(formatOffset("0x94B43C"), "30 48 2D E9 08 B0 8D E2"); // Player_move_c$$get_isGo
            }
        });
        addSwitch("Always Wear", new CompoundButton.OnCheckedChangeListener()
        {
            public void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
            {
                if (paramAnonymousBoolean)
                {
                    Loader.write(formatOffset("0x1C25B5C"), "00 00 A0 E3 1E FF 2F E1"); // GameConnect$$get_wearEffectsDisabled
                    return;
                }
                Loader.write(formatOffset("0x1C25B5C"), "30 48 2D E9 08 B0 8D E2"); // GameConnect$$get_wearEffectsDisabled
            }
        });/*
        addSwitch("Clan Chests", new CompoundButton.OnCheckedChangeListener()
        {
          public void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
          {
            if (paramAnonymousBoolean)
            {
              Loader.write(formatOffset("F2B840"), "01 00 A0 E3 1E FF 2F E1");
              Loader.write(formatOffset("F2B8B8"), "01 00 A0 E3 1E FF 2F E1");
              Loader.write(formatOffset("F2B614"), "00 00 A0 E3 1E FF 2F E1");
              Loader.write(formatOffset("F2B6C4"), "00 00 A0 E3 1E FF 2F E1");
              Loader.write(formatOffset("F59B1C"), "01 00 A0 E3 1E FF 2F E1");
              Loader.write(formatOffset("F29FF4"), "01 00 A0 E3 1E FF 2F E1");
              return;
            }
            Loader.write(formatOffset("F2B840"), "30 48 2D E9 08 B0 8D E2");
            Loader.write(formatOffset("F2B8B8"), "70 4C 2D E9 10 B0 8D E2");
            Loader.write(formatOffset("F2B614"), "70 4C 2D E9 10 B0 8D E2");
            Loader.write(formatOffset("F2B6C4"), "F0 4B 2D E9 18 B0 8D E2");
            Loader.write(formatOffset("F59B1C"), "F0 4B 2D E9 18 B0 8D E2");
            Loader.write(formatOffset("F29FF4"), "70 4C 2D E9 10 B0 8D E2");
          }
        });
        addSwitch("More Clan Parts", new CompoundButton.OnCheckedChangeListener()
        {
          public void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
          {
            if (paramAnonymousBoolean)
            {
              //Loader.write(formatOffset("1562D24"), "FF 10 80 E2");
              Loader.write(formatOffset("FC8C08"), "FF 00 A0 E3");
              //Loader.write(formatOffset("15632E4"), "FF 20 84 E2");
              return;
            }
            //Loader.write(formatOffset("1562D24"), "04 10 80 E0");
            Loader.write(formatOffset("FC8C08"), "3E F3 3E EB");
            //Loader.write(formatOffset("15632E4"), "01 20 84 E2");
          }
        });*/
        addSwitch("Can Access Clans", new CompoundButton.OnCheckedChangeListener()
        {
            public void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
            {
                if (paramAnonymousBoolean)
                {
                    Loader.write(formatOffset("0xCBB4C0"), "01 00 A0 E3 1E FF 2F E1"); // BalanceController$$get_LevelOpenClans
                    Loader.write(formatOffset("0x1323B6C"), "01 00 A0 E3 1E FF 2F E1"); // ClansController$$get_LevelOpenClans
                    return;
                }
                Loader.write(formatOffset("0xCBB4C0"), "30 48 2D E9 08 B0 8D E2"); // BalanceController$$get_LevelOpenClans
                Loader.write(formatOffset("0x1323B6C"), "30 48 2D E9 08 B0 8D E2"); // ClansController$$get_LevelOpenClans
            }
        });/*
        addSwitch("All Fort Items", new CompoundButton.OnCheckedChangeListener()
        {
          public void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
          {
            if (paramAnonymousBoolean)
            {
              Loader.write(formatOffset("16209C4"), "01 00 A0 E3 1E FF 2F E1");
              Loader.write(formatOffset("162868C"), "01 00 A0 E3 1E FF 2F E1");
              Loader.write(formatOffset("1621A4C"), "88 03 01 E3 1E FF 2F E1");
              Loader.write(formatOffset("16216D4"), "88 03 01 E3 1E FF 2F E1");
              Loader.write(formatOffset("1621A90"), "88 03 01 E3 1E FF 2F E1");
              return;
            }
            Loader.write(formatOffset("16209C4"), "70 4C 2D E9 10 B0 8D E2");
            Loader.write(formatOffset("162868C"), "70 4C 2D E9 10 B0 8D E2");
            Loader.write(formatOffset("1621A4C"), "10 4C 2D E9 08 B0 8D E2");
            Loader.write(formatOffset("16216D4"), "70 4C 2D E9 10 B0 8D E2");
            Loader.write(formatOffset("1621A90"), "70 4C 2D E9 10 B0 8D E2");
          }
        });/*
        addSwitch("Fort Damage God", new CompoundButton.OnCheckedChangeListener()
        {
          public void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
          {
            if (paramAnonymousBoolean)
            {
              Loader.write(formatOffset("C1A2B4"), "7A 04 44 E3 1E FF 2F E1");
              Loader.write(formatOffset("13ED258"), "7A 04 44 E3 1E FF 2F E1");
              Loader.write(formatOffset("13EEB28"), "7A 04 44 E3 1E FF 2F E1");
              return;
            }
            Loader.write(formatOffset("C1A2B4"), "F0 48 2D E9 10 B0 8D E2");
            Loader.write(formatOffset("13ED258"), "70 4C 2D E9 10 B0 8D E2");
            Loader.write(formatOffset("13EEB28"), "F0 4B 2D E9 18 B0 8D E2");
          }
        });
        */
        addSwitch("All Guns", new CompoundButton.OnCheckedChangeListener()
        {
            public void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
            {
                if (paramAnonymousBoolean)
                {
                    //Loader.write(formatOffset("8F0CF4"), "0000A0E3 000050E3 7D00000A");
                    Loader.write(formatOffset("0xA8855C"), "00 48 2D E9 0D B0 A0 E1 21F82FEB 00 10 A0 E1 00 48 BD E8 F25200EB 1E FF 2F E1"); // WeaponManager$$SetWeaponsSet  | 3 BL Defs$$get_MultiplayerWSSN | 6 B WeaponManager$$LoadWeaponSet
                    Loader.write(formatOffset("0xA9F658"), "C1A9FFEA 1E FF 2F E1"); // WeaponManager$$DefaultSetForWeaponSetSettingName
                    return;
                }
                //Loader.write(formatOffset("8F0CF4"), "B9 1A D0 E1 01 1C 01 E2 1B 00 00 0A");
                Loader.write(formatOffset("0xA8855C"), "F0 4F 2D E9 1C B0 8D E2 43 DF 4D E2 1C 00 8D E5 01 90 A0 E1 AC 0F 9F E5 AC 5F 9F E5 00 00 8F E0");  // WeaponManager$$SetWeaponsSet  | 3 BL Defs$$get_MultiplayerWSSN | 6 B WeaponManager$$LoadWeaponSet
                Loader.write(formatOffset("0xA9F658"), "F0 4F 2D E9 1C B0 8D E2"); // WeaponManager$$DefaultSetForWeaponSetSettingName
            }
        });
        addSpinner("Rocket Mode", new String[] {"Unchanged","Auto-Homing","Crosshair-Aim"} ,new AdapterView.OnItemSelectedListener()
        {
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l)
            {
                switch (position){
                    case 0:
                        Loader.write(formatOffset("0x1E18D94"), "02 00 00 0A"); // Rocket$$Update
                        break;
                    case 1:// auto homing
                        Loader.write(formatOffset("0x1E18D94"), "250000EA"); // Rocket$$Update
                        break;
                    case 2:// auto aim
                        Loader.write(formatOffset("0x1E18D94"), "220000EA"); // Rocket$$Update;
                        break;
                }
            }
            public void onNothingSelected(AdapterView<?> adapterView) {}
        });
        addSwitch("Rocket No Clip", new CompoundButton.OnCheckedChangeListener()
        {
            public void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
            {
                if (paramAnonymousBoolean)
                {
                    Loader.write(formatOffset("0x1E2284C"), "01 00 A0 E3 1E FF 2F E1"); // Rocket$$IsSkipCollision
                    return;
                }
                Loader.write(formatOffset("0x1E2284C"), "F0 4F 2D E9 1C B0 8D E2"); // Rocket$$IsSkipCollision
            }
        });
        addSwitch("Friendly Fire", new CompoundButton.OnCheckedChangeListener()
        {
            public void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
            {
                if (paramAnonymousBoolean)
                {
                    Loader.write(formatOffset("0x1C2625C"), "00 00 A0 E3 1E FF 2F E1"); // GameConnect$$get_isTeamRegim
                    Loader.write(formatOffset("0x1C256F0"), "00 00 A0 E3 1E FF 2F E1"); // GameConnect$$isTeamMode
                    return;
                }
                Loader.write(formatOffset("0x1C2625C"), "30 48 2D E9 08 B0 8D E2"); // GameConnect$$get_isTeamRegim
                Loader.write(formatOffset("0x1C256F0"), "02 00 41 E2 11 00 50 E3"); // GameConnect$$isTeamMode
            }
        });/*
        addSwitch("Game Never Full", new CompoundButton.OnCheckedChangeListener()
        {
            public void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
            {
                if (paramAnonymousBoolean)
                {
                    Loader.write(formatOffset("FCD1C4"), "01 00 A0 E3 00 00 50 E3");// ConnectScene$$JoinToRoomPhoton
                    Loader.write(formatOffset("180C824"), "FF 00 A0 E3");//
                    Loader.write(formatOffset("180D028"), "FF 00 A0 E3");//
                    return;
                }
                Loader.write(formatOffset("FCD1C4"), "97 FF 20 EB 00 00 56 E1");// ConnectScene$$JoinToRoomPhoton
                Loader.write(formatOffset("180C824"), "10 00 D0 E5");//
                Loader.write(formatOffset("180D028"), "10 00 D0 E5");//
            }
        });*/
        addSwitch("Any Password", new CompoundButton.OnCheckedChangeListener()
        {
            public void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
            {
                if (paramAnonymousBoolean)
                {
                    Loader.write(formatOffset("0x1627C3C"), "01 00 A0 E3"); // ConnectScene$$HandleJoinRoomFromEnterPasswordBtnClicked
                    Loader.write(formatOffset("0x11CEDE4"), "01 00 A0 E3"); // JoinToFriendRoomController$$EnterPassword
                    Loader.write(formatOffset("0x11C9748"), "01 00 A0 E3"); // JoinRoomFromFrends$$EnterPassword
                    Loader.write(formatOffset("0x1671A18"), "01 00 A0 E3"); // CustomMiniGameController$$HandleJoinRoomFromEnterPasswordBtnClicked
                    //Loader.write(formatOffset("183D240"), "01 00 A0 E3"); // CustomMiniGameController$$JoinToRoomPhoton
                    return;
                }
                Loader.write(formatOffset("0x1627C3C"), "6C 16 0F EB"); // ConnectScene$$HandleJoinRoomFromEnterPasswordBtnClicked
                Loader.write(formatOffset("0x11CEDE4"), "65 65 20 EB"); // JoinToFriendRoomController$$EnterPassword
                Loader.write(formatOffset("0x11C9748"), "0C 7B 20 EB"); // JoinRoomFromFrends$$EnterPassword
                Loader.write(formatOffset("0x1671A18"), "F5 EE 0D EB"); // CustomMiniGameController$$HandleJoinRoomFromEnterPasswordBtnClicked
                //Loader.write(formatOffset("183D240"), "63 72 12 EB"); // CustomMiniGameController$$JoinToRoomPhoton
            }
        });/*
        addSwitch("Dater Hater", new CompoundButton.OnCheckedChangeListener()
        {
            public void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
            {
                if (paramAnonymousBoolean)
                {
                    //Loader.write(formatOffset("9CD784"), "CF 00 00 EA");
                    Loader.write(formatOffset("130F270"), "00 00 A0 E3 1E FF 2F E1");
                    //Loader.write(formatOffset("127D3A8"), "00 00 50 E3");
                    //Loader.write(formatOffset("12802A4"), "18 C0 80 E5");
                    return;
                }
                //Loader.write(formatOffset("9CD784"), "CF 00 00 0A");
                Loader.write(formatOffset("130F270"), "30 48 2D E9 08 B0 8D E2");
                //Loader.write(formatOffset("127D3A8"), "09 00 50 E3");
                //Loader.write(formatOffset("12802A4"), "18 90 80 E5");
            }
        });*/
        addSwitch("Fortnite Hater", new CompoundButton.OnCheckedChangeListener()
        {
            public void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
            {
                if (paramAnonymousBoolean)
                {
                    Loader.write(formatOffset("0x1C16A28"), "00 00 A0 E3 1E FF 2F E1"); // GameConnect$$get_isBattleRoyale
                    return;
                }
                Loader.write(formatOffset("0x1C16A28"), "30 48 2D E9 08 B0 8D E2"); // GameConnect$$get_isBattleRoyale
            }
        });
        addSwitch("Fully Charged", new CompoundButton.OnCheckedChangeListener()
        {
            public void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
            {
                if (paramAnonymousBoolean)
                {
                    Loader.write(formatOffset("0x99AA68"), "7E4F5FEB"); // (class Math) public static float Max(float val1, float val2); 3
                    return;
                }
                Loader.write(formatOffset("0x99AA68"), "C8 4F 5F EB"); // (class Math) public static float Min(float val1, float val2); 3
            }
        });
        addSwitch("Silent AimBot", new CompoundButton.OnCheckedChangeListener()
        {
            public void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
            {
                if (paramAnonymousBoolean)
                {
                    //Loader.write(formatOffset("0x9A1BF0"), "70 8A 9A ED"); // TargetsList$$GetEnumerator 8 VLDR
                    //Loader.write(formatOffset("ABD4EC"), "70 0A 90 ED"); // TargetsList$$GetEnumerator 11 VLDR
                    //Loader.write(formatOffset("ABA1E4"), "70 0A 90 ED"); // TargetsList$$GetEnumerator 10 VLDR
                    Loader.write(formatOffset("0xAC69D4"), "00 00 00 E3 9C 05 44 E3"); // WeaponSounds$$.ctor MOV             R2, #0x40400000
                    //Loader.write(formatOffset("B64BD8"), "3C C1 84 E5"); // WeaponSounds$$.ctor STR             R2, [R4,#0x13C]
                    return;
                }
                //Loader.write(formatOffset("0x9A1BF0"), "6E 8A 9A ED"); // TargetsList$$GetEnumerator 8 VLDR
                //Loader.write(formatOffset("ABD4EC"), "4F 0A 90 ED"); // TargetsList$$GetEnumerator 11 VLDR
                //Loader.write(formatOffset("ABA1E4"), "23 0A 90 ED"); // TargetsList$$GetEnumerator 10 VLDR
                Loader.write(formatOffset("0xAC69D4"), "00 20 00 E3 40 20 44 E3"); // WeaponSounds$$.ctor MOV             R2, #0x40400000
                //Loader.write(formatOffset("B64BD8"), "3C 21 84 E5"); // WeaponSounds$$.ctor STR             R2, [R4,#0x13C]
            }
        });
        addSpinner("Mega Gun: ", new String[] {"Unchanged","Railgun","Explosion","Slowdown","Shotgun"} ,new AdapterView.OnItemSelectedListener()
        {
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l)
            {
                switch (position){ // WeaponSounds$$CheckPlayDefaultAnimInMulti
                    case 0:// Unchanged
                        Loader.write(formatOffset("0xACC820"), "70 4C 2D E9 10 B0 8D E2 00 40 A0 E1 F8 01 9F E5 F8 51 9F E5 00 00 8F E0 00 00 85 E0 C0 02 D0 E5");
                        break;
                    case 1:// Railgun
                        Loader.write(formatOffset("0xACC820"), "01 10 A0 E3 B011C0E5 1E FF 2F E1");
                        break;
                    case 2:// Explosion
                        Loader.write(formatOffset("0xACC820"), "01 10 A0 E3 7A 24 44 E3 00 30 40 E3 86 10 C0 E5 70 20 80 E5 74 30 80 E5 78 20 80 E5 1E FF 2F E1");
                        break;
                    case 3:// Slowdown
                        Loader.write(formatOffset("0xACC820"), "01 10 A0 E3 7A 24 44 E3 52 11 C0 E5 E0 21 80 E5 E4 21 80 E5 1E FF 2F E1");
                        break;
                    case 4:// Shotgun
                        Loader.write(formatOffset("0xACC820"), "01 10 A0 E3 50 11 C0 E5 1E FF 2F E1");
                        break;
                }
            }
            public void onNothingSelected(AdapterView<?> adapterView) {}
        });/*
        addSwitch("Freeze", new CompoundButton.OnCheckedChangeListener()
        {
            public void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
            {
                if (paramAnonymousBoolean)
                {
                    Loader.write(formatOffset("16D9890"), "00 00 A0 E3"); // FirstPersonControlSharp$$Update2
                    return;
                }
                Loader.write(formatOffset("16D9890"), "05 D3 26 EB"); // FirstPersonControlSharp$$Update2
            }
        });
        addSwitch("Unhidden Fort", new CompoundButton.OnCheckedChangeListener()
        {
          public void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
          {
            if (paramAnonymousBoolean)
            {
              Loader.write(formatOffset("1493E3C"), "00 00 A0 E3 1E FF 2F E1");
              Loader.write(formatOffset("DD24FC"), "00 00 A0 E3 1E FF 2F E1");
              Loader.write(formatOffset("14935F0"), "01 C0 A0 E3");
              Loader.write(formatOffset("1493604"), "3C C0 C4 E5");
              Loader.write(formatOffset("149360C"), "24 C0 C4 E5");
              return;
            }
            Loader.write(formatOffset("1493E3C"), "3C 00 D0 E5 1E FF 2F E1");
            Loader.write(formatOffset("DD24FC"), "3C 10 C0 E5 1E FF 2F E1");
            Loader.write(formatOffset("14935F0"), "1C 00 9B E5");
            Loader.write(formatOffset("1493604"), "3C 00 C4 E5");
            Loader.write(formatOffset("149360C"), "24 00 C4 E5");
          }
        });
        addSwitch("Unhidden Drop Fort", new CompoundButton.OnCheckedChangeListener()
        {
          public void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
          {
            if (paramAnonymousBoolean)
            {
              Loader.write(formatOffset("14936D4"), "01 00 A0 E3 1E FF 2F E1");
              Loader.write(formatOffset("149369C"), "01 00 A0 E3 1E FF 2F E1");
              return;
            }
            Loader.write(formatOffset("14936D4"), "24 00 D0 E5 1E FF 2F E1");
            Loader.write(formatOffset("149369C"), "24 10 C0 E5 1E FF 2F E1");
          }
        });
        addSwitch("Start Siege Early", new CompoundButton.OnCheckedChangeListener()
        {
          public void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
          {
            if (paramAnonymousBoolean)
            {
              Loader.write(formatOffset("1412974"), "06 10 A0 E3");
              return;
            }
            Loader.write(formatOffset("1412974"), "02 10 A0 E3");
          }
        });
        addButton("Start Siege Early", new OnClickListener()
        {
          public void onClick(View v)
          {
            Loader.write(formatOffset("14123A0"), "01 10 A0 E3 39 10 80 E5 BD 07 00 EA 1E FF 2F E1");
            new Handler().postDelayed(new Runnable() {
              public void run()
              {
                Loader.write(formatOffset("14123A0"), "F0 4F 2D E9 1C B0 8D E2 04 D0 4D E2 02 8B 2D ED");
              }
            }, 100);
          }
        });
        addButton("End Siege Early", new OnClickListener()
        {
          public void onClick(View v)
          {
            Loader.write(formatOffset("14123A0"), "01 10 A0 E3 6D 08 00 EA 1E FF 2F E1");
            Loader.write(formatOffset("167DDC0"), "01 00 A0 E3");
            Loader.write(formatOffset("B91588"), "3A 00 00 0A");
            Loader.write(formatOffset("B91580"), "00 00 A0 E3");
            Loader.write(formatOffset("16D1D8C"), "00 F0 20 E3");
            new Handler().postDelayed(new Runnable() {
              public void run()
              {
                Loader.write(formatOffset("14123A0"), "F0 4F 2D E9 1C B0 8D E2 04 D0 4D E2 02 8B 2D ED");
                Loader.write(formatOffset("167DDC0"), "10 00 D0 E5");
                Loader.write(formatOffset("B91588"), "46 08 00 0A");
                Loader.write(formatOffset("B91580"), "CE 00 D9 E5");
                Loader.write(formatOffset("16D1D8C"), "03 00 00 0A");
              }
            }, 100);
          }
        });
        addButton("End Siege Early Orig", new OnClickListener()
        {
          public void onClick(View v)
          {
            Loader.write(formatOffset("1413284"), "00 F0 20 E3 00 00 A0 E3 01 00 50 E3");
            Loader.write(formatOffset("1413290"), "35 00 00 1A");
            new Handler().postDelayed(new Runnable() {
              public void run()
              {
                Loader.write(formatOffset("1413284"), "01 00 50 E3 8C 00 D9 05 00 00 50 03");
                Loader.write(formatOffset("1413290"), "14 00 00 1A");
              }
            }, 1000);
          }
        });*/

        //addText("=================");
	    addReturn();
        addText("Mod Menu Made With <3 By Jbro129 & KMODs");
        //addText("=================");
    }

    @QVMProtect
    public static void fakerBan(RandomAccessFile random) // For CPAntiDumper
    {

        //raf = random;

    }
    
    public static EditText addEditText(String hint) {
        EditText localEditText = new EditText(ctx);
        localEditText.setHint(hint);
        localEditText.setLayoutParams(setParams());
        localEditText.setFocusableInTouchMode(true);
        //localEditText.setFocusable(true);
        patches.addView(localEditText);
        return localEditText;
    }

    public static SeekBar addSeekbar(int bars, SeekBar.OnSeekBarChangeListener paramOnSeekBarChangeListener)
    {
        SeekBar localSeekBar = new SeekBar(ctx);
        localSeekBar.setMax(bars);
        //localSeekBar.setThumb(ctx.getResources().getDrawable(R.drawable.j));
        localSeekBar.setLayoutParams(setParams());
        localSeekBar.setOnSeekBarChangeListener(paramOnSeekBarChangeListener);
        patches.addView(localSeekBar);
		return localSeekBar;
    }


    @SuppressLint({"ResourceType"})
    public static Spinner addSpinner(String name, String[] items, AdapterView.OnItemSelectedListener listener) {
        TextView tv = new TextView(ctx);
        tv.setText(name);
        tv.setTextSize(txtSize);
        tv.setTextColor(txtColor);
        tv.setLayoutParams(setParams());
        Spinner sp = new Spinner(ctx);
        sp.setLayoutParams(setParams());
        ArrayAdapter<?extends String> dataAdapter = new ArrayAdapter<>(ctx, 17367048, items);
        dataAdapter.setDropDownViewResource(17367049);
        sp.setAdapter(dataAdapter);
        sp.setOnItemSelectedListener(listener);
        patches.addView(tv);
        patches.addView(sp);
		return sp;
    }

    //@SuppressLint("NewApi")
    public static Switch addSwitch(String name, CompoundButton.OnCheckedChangeListener listener)
    {
        final Switch sw = new Switch(ctx);
        sw.setText(name);
        sw.setTextSize(txtSize);
        sw.setTextColor(txtColor);
        if(Build.VERSION.SDK_INT >= 16)
        {
            sw.getThumbDrawable().setColorFilter(swOff, PorterDuff.Mode.MULTIPLY);
        }
        sw.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View view)
            {
                if(Build.VERSION.SDK_INT >= 16)
                {
                    if(sw.isChecked())
                    {
                        sw.getThumbDrawable().setColorFilter(swOn, PorterDuff.Mode.MULTIPLY);
                    }
                    else
                    {
                        sw.getThumbDrawable().setColorFilter(swOff, PorterDuff.Mode.MULTIPLY);
                    }
                }
            }
        });
        sw.setOnCheckedChangeListener(listener);
        sw.setLayoutParams(setParams());
        patches.addView(sw);
		return sw;
    }

    public static CheckBox addCheckBox(String name, View.OnClickListener listener)
    {
        final CheckBox check = new CheckBox(ctx);
        check.setText(name);
        check.setTextSize(txtSize);
        check.setTextColor(txtColor);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
        {
            check.setTextAppearance(Gravity.CENTER);
        }
        check.setOnClickListener(listener);
        check.setLayoutParams(setParams());
        patches.addView(check);
		return check;
    }

    public static Button addButton(String name, View.OnClickListener listener)
    {
        final Button but = new Button(ctx);
        but.setText(name);
        but.setTextSize(txtSize);
        but.setTextColor(txtColor);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
        {
            but.setTextAppearance(Gravity.CENTER);
        }
        but.setOnClickListener(listener);
        but.setLayoutParams(setParams());
        patches.addView(but);
		return but;
    }

    public static void addReturn()
    {
        addText(" ");
    }

    public static TextView addText(String txt)
    {
        TextView localTextView = new TextView(ctx);
        localTextView.setText(txt);
        localTextView.setTextColor(txtColor);
        localTextView.setTextSize(txtSize);
        localTextView.setLayoutParams(setParams());
        patches.addView(localTextView);
        return localTextView;
    }

    public static TextView addText(String txt, int color)
    {
        TextView localTextView = new TextView(ctx);
        localTextView.setText(txt);
        localTextView.setTextColor(color);
        localTextView.setTextSize(txtSize);
        localTextView.setLayoutParams(setParams());
        patches.addView(localTextView);
        return localTextView;
    }

    public static TextView addText(String txt, float size)
    {
        TextView localTextView = new TextView(ctx);
        localTextView.setText(txt);
        localTextView.setTextColor(txtColor);
        localTextView.setTextSize(size);
        localTextView.setLayoutParams(setParams());
        patches.addView(localTextView);
        return localTextView;
    }

    public static TextView addText(String txt, float size, int color)
    {
        TextView localTextView = new TextView(ctx);
        localTextView.setText(txt);
        localTextView.setTextColor(color);
        localTextView.setTextSize(size);
        localTextView.setLayoutParams(setParams());
        patches.addView(localTextView);
        return localTextView;
    }

    private static int decodeHexDigit(char paramChar)
    {
        if ((paramChar >= '0') && (paramChar <= '9')) {
            return paramChar - '0';
        }
        if ((paramChar >= 'a') && (paramChar <= 'f')) {
            return paramChar - 'a' + 10;
        }
        if ((paramChar >= 'A') && (paramChar <= 'F')) {
            return paramChar - 'A' + 10;
        }
        throw new IllegalArgumentException("Unexpected hex digit: " + paramChar);
    }

    private static float dipToPixels()
    {
        return TypedValue.applyDimension(1, 8.0F, ctx.getResources().getDisplayMetrics());
    }

    private static int getID(String paramString)
    {
        return getResID(paramString, "id");
    }

    private static int getIndex(int[] paramArrayOfInt, int paramInt)
    {
        int i = 0;
        while (i < paramArrayOfInt.length)
        {
            if (paramArrayOfInt[i] == paramInt) {
                return i;
            }
            i += 1;
        }
        return -1;
    }

    private static int getResID(String paramString1, String paramString2)
    {
        return ctx.getResources().getIdentifier(paramString1, paramString2, ctx.getPackageName());
    }

    public static int getSwitchOffColor()
    {
        return swOff;
    }

    public static int getSwitchOnColor()
    {
        return swOn;
    }

    public static int getTxtColor()
    {
        return txtColor;
    }

    private static String hex(int paramInt)
    {
        return String.format("%2s", new Object[] { Integer.toHexString(paramInt) }).replace(' ', '0');
    }

    private static byte[] iTob(int[] paramArrayOfInt)
    {
        byte[] arrayOfByte = new byte[paramArrayOfInt.length];
        int i = 0;
        while (i < paramArrayOfInt.length)
        {
            arrayOfByte[i] = ((byte)(paramArrayOfInt[i] & 0xFF));
            i += 1;
        }
        return arrayOfByte;
    }

    private static byte[] sTob(String paramString)
    {
        byte[] arrayOfByte = new byte[paramString.length()];
        int i = 0;
        while (i < paramString.length())
        {
            arrayOfByte[i] = ((byte)paramString.charAt(i));
            i += 1;
        }
        return arrayOfByte;
    }

    private static LinearLayout.LayoutParams setParams()
    {
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -1);
        localLayoutParams.gravity = 16;
        return localLayoutParams;
    }

    public static void setSwitchOffColor(int paramInt)
    {
        swOff = paramInt;
    }

    public static void setSwitchOnColor(int paramInt)
    {
        swOn = paramInt;
    }

    public static void setTxtColor(int paramInt)
    {
        txtColor = paramInt;
    }

    public static void setTxtSize(float paramFloat)
    {
        txtSize = paramFloat;
    }

    private static void write(int paramInt, String paramString)
    {
        try
        {
            raf.seek(paramInt);
            raf.write(Hex2b(paramString));
            return;
        }
        catch (IOException paramString1)
        {
            paramString1.printStackTrace();
        }
    }

    private static int formatOffset(String offset)
    {
        if(offset.contains("0x"))
        {
            return Integer.parseInt(offset.replace("0x", ""), 16);
        }
        if(offset.contains("0X"))
        {
            return Integer.parseInt(offset.replace("0X", ""), 16);
        }
        return Integer.parseInt(offset, 16);
    }

    private static void write(int paramInt, int[] paramArrayOfInt)
    {
        try
        {
            raf.seek(paramInt);
            raf.write(iTob(paramArrayOfInt));
            return;
        }
        catch (IOException paramArrayOfInt1)
        {
            paramArrayOfInt1.printStackTrace();
        }
    }

    private static void writeS(int paramInt, String paramString)
    {
        try
        {
            raf.seek(paramInt);
            raf.write(sTob(paramString));
            return;
        }
        catch (IOException paramString1)
        {
            paramString1.printStackTrace();
        }
    }

    private static void write2nd(int paramInt, String paramString)
    {
        try
        {
            raf2.seek(paramInt);
            raf2.write(Hex2b(paramString));
            return;
        }
        catch (IOException paramString1)
        {
            paramString1.printStackTrace();
        }
    }
}
