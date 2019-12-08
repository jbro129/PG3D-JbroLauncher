package com.jbro129.mod.pg3dlauncher;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.ImageReader;
import android.media.MediaCodec;
import android.net.Uri;
import android.os.Bundle;
import android.os.Debug;
import android.os.Environment;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.internal.BottomNavigationItemView;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AlertDialog;
import android.util.Base64;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.jbro129.mod.QVMProtect;
import com.jbro129.mod.vending.Constants;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Random;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

import lib.folderpicker.FolderPicker;
import tgio.rncryptor.RNCryptorNative;

public class EditorActivity extends BaseActivity
{

    private Button addskin;
    private Button setcape;
    private Button setname;
    private Button backup;
    private Button restore;
    private EditText name;
    private EditText capepath;
    private EditText skinpath;
    private File prefs;
    private AlertDialog.Builder builder;
    private AlertDialog alertDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        addskin = (Button) findViewById(R.id.editor_skinbutton);
        setcape = (Button) findViewById(R.id.editor_capebutton);
        setname = (Button) findViewById(R.id.editor_namebutton);
        backup = (Button) findViewById(R.id.editor_backup);
        restore = (Button) findViewById(R.id.editor_restore);
        skinpath = (EditText) findViewById(R.id.editor_skin);
        capepath = (EditText) findViewById(R.id.editor_cape);
        name = (EditText) findViewById(R.id.editor_name);

        prefs = new File(this.getApplicationInfo().dataDir + "/virtual/data/user/0/com.pixel.gun3d/shared_prefs/com.pixel.gun3d.v2.playerprefs.xml");

        ((Button) addskin).setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View paramAnonymousView)
            {
                if (prefs.exists())
                {
                    selectSkin();
                }
                else
                {
                    Toast.makeText(EditorActivity.this, "PG3D data was not found.", Toast.LENGTH_SHORT).show();
                }
            }
        });
        ((Button) setcape).setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View paramAnonymousView)
            {
                if (prefs.exists())
                {
                    selectCape();
                }
                else
                {
                    Toast.makeText(EditorActivity.this, "PG3D data was not found.", Toast.LENGTH_SHORT).show();
                }
            }
        });
        ((Button) setname).setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View paramAnonymousView)
            {
                if (prefs.exists())
                {
                    setName(name.getText().toString().trim());
                }
                else
                {
                    Toast.makeText(EditorActivity.this, "PG3D data was not found.", Toast.LENGTH_SHORT).show();
                }
            }
        });
        ((Button) backup).setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View paramAnonymousView)
            {
                Toast.makeText(EditorActivity.this, "Creating Backup, Please wait...", Toast.LENGTH_LONG).show();
                backup.setEnabled(false);
                try
                {
                    File Prefs = new File(EditorActivity.this.getApplicationInfo().dataDir + "/virtual/data/user/0/com.pixel.gun3d/shared_prefs/com.pixel.gun3d.v2.playerprefs.xml");
                    if (Prefs.isFile() && Prefs.exists())
                    {
                        File JDir = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/JbroPG3D/");
                        //Constants.DLog("JDir: " + JDir.getAbsolutePath());
                        if (!JDir.isDirectory())
                        {
                            JDir.mkdir();
                        }
                        File out = new File(JDir.getAbsolutePath() + "/JbroBackup-" + dateString() + ".bak");
                        //Constants.DLog("Out: " + out.getAbsolutePath());
                        out.createNewFile();
                        RNCryptorNative.encryptFile(Prefs, out, Constants.PASSWORD);
                        backup.setEnabled(true);
                        Toast.makeText(EditorActivity.this, "Backup created in: " + out.getAbsolutePath(), Toast.LENGTH_LONG).show();
                    }
                    else
                    {
                        Toast.makeText(EditorActivity.this, "Nothing To Backup", Toast.LENGTH_SHORT).show();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        ((Button) restore).setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View paramAnonymousView)
            {
                restore.setEnabled(false);
                File Prefs = new File(EditorActivity.this.getApplicationInfo().dataDir + "/virtual/data/user/0/com.pixel.gun3d/shared_prefs/com.pixel.gun3d.v2.playerprefs.xml");
                if (Prefs.isFile() && Prefs.exists())
                {
                    builder = new AlertDialog.Builder(EditorActivity.this);
                    builder.setTitle("Warning")
                            .setCancelable(false)
                            .setMessage("You have PG3D data already in use. If you continue then it will overwrite your current data. Press 'Continue' to proceed anyways.")
                            .setPositiveButton("Continue", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which)
                                {
                                    Toast.makeText(EditorActivity.this, "Data Backups Are Usually In /JbroPG3D/", Toast.LENGTH_SHORT).show();
                                    selectBackup();
                                }
                            })
                            .setNegativeButton("Back", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which)
                                {
                                    restore.setEnabled(true);
                                    dialog.dismiss();
                                }
                            });

                    alertDialog = builder.create();

                    alertDialog.show();
                }
                else
                {
                    Toast.makeText(EditorActivity.this, "Data Backups Are Usually In /JbroPG3D/", Toast.LENGTH_SHORT).show();
                    selectBackup();
                }
            }
        });
    }

    @SuppressLint("SimpleDateFormat")
    private String dateString()
    {
        return new SimpleDateFormat("yyyy:MM:dd-HH:mm:ss").format(Calendar.getInstance().getTime());
    }


    private String randInt(int length)
    {
        StringBuilder ok = new StringBuilder();
        Random rnd = new Random();
        for (int i = 0; i < length; i++)
        {
            ok.append(rnd.nextInt(7));
        }
        return String.valueOf(ok);
    }

    public String base64Image(String filePath) {

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        Bitmap bitmap = BitmapFactory.decodeFile(filePath);
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, baos);
        byte[] imageBytes = baos.toByteArray();
        return Base64.encodeToString(imageBytes, Base64.DEFAULT);
    }

    private void selectSkin()
    {
        Intent intent = new Intent(this, FolderPicker.class);
        intent.putExtra("title", "Select Old-Format Minecraft Skin");
        intent.putExtra("location", Environment.getExternalStorageDirectory().getAbsolutePath());
        intent.putExtra("pickFiles", true);
        startActivityForResult(intent, 69);
    }

    private void selectCape()
    {
        Intent intent = new Intent(this, FolderPicker.class);
        intent.putExtra("title", "Select Cape");
        intent.putExtra("location", Environment.getExternalStorageDirectory().getAbsolutePath());
        intent.putExtra("pickFiles", true);
        startActivityForResult(intent, 96);
    }

    private void selectBackup()
    {
        Intent intent = new Intent(this, FolderPicker.class);
        intent.putExtra("title", "Select Backup");
        intent.putExtra("location", Environment.getExternalStorageDirectory().getAbsolutePath());
        intent.putExtra("pickFiles", true);
        startActivityForResult(intent, 969);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        if (requestCode == 69 && resultCode == Activity.RESULT_OK)
        {
            File picked = new File(data.getExtras().getString("data"));
            skinpath.setText(picked.getAbsolutePath());
            putSkin(picked);
        }
        if (requestCode == 96 && resultCode == Activity.RESULT_OK)
        {
            File picked = new File(data.getExtras().getString("data"));
            capepath.setText(picked.getAbsolutePath());
            putCape(picked);
        }
        if (requestCode == 969 && resultCode == Activity.RESULT_OK)
        {
            File picked = new File(data.getExtras().getString("data"));
            restoreData(picked);
        }
    }

    @QVMProtect
    private void restoreData(File picked)
    {
        File Prefs = new File(EditorActivity.this.getApplicationInfo().dataDir + "/shared_prefs/com.pixel.gun3d.v2.playerprefs.xml");
        if (Prefs.isFile() && Prefs.exists())
        {
            Prefs.delete();
        }
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run()
            {
                try {
                    RNCryptorNative.decryptFile(picked, Prefs, Constants.PASSWORD);

                    prefs.renameTo(new File(EditorActivity.this.getApplicationInfo().dataDir + "/virtual/data/user/0/com.pixel.gun3d/shared_prefs/com.pixel.gun3d.v2.playerprefs.xml"));

                    restore.setEnabled(true);
                    Toast.makeText(EditorActivity.this, "Restored", Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }, 1000);
    }

    @QVMProtect
    private void putCape(File picked)
    {
        setcape.setEnabled(false);
        File playerprefs = new File(EditorActivity.this.getApplicationInfo().dataDir + "/shared_prefs/com.pixel.gun3d.v2.playerprefs.xml");
        if (playerprefs.exists() && playerprefs.isFile())
        {
            playerprefs.delete();
        }
        new Handler().postDelayed(new Runnable() {
            public void run() {
                try
                {
                    if (prefs.exists())
                    {
                        if (prefs.renameTo(playerprefs))
                        {
                            prefs.delete();
                            if (JPlayerPrefs.with(EditorActivity.this).contains("NewUserCape") || JPlayerPrefs.with(EditorActivity.this).contains("User%20Cape%20Skin"))
                            {
                                JPlayerPrefs.with(EditorActivity.this).remove("NewUserCape");
                                JPlayerPrefs.with(EditorActivity.this).remove("User%20Cape%20Skin");
                                String base64img = base64Image(picked.getAbsolutePath());
                                JSONObject json = new JSONObject();
                                json.put("id", "636682816675349590");
                                json.put("cape", base64img);
                                JPlayerPrefs.with(EditorActivity.this).write("User%20Cape%20Skin", URLEncoder.encode(json.toString().replace("\"636682816675349590\"", "636682816675349590"), "UTF-8"));
                                new Handler().postDelayed(new Runnable() {
                                    public void run() {
                                        if (playerprefs.renameTo(prefs)) {
                                            setcape.setEnabled(true);
                                            Toast.makeText(EditorActivity.this, "Success!", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                }, 1000);
                                //String all = readFromFile(playerprefs);
                                //writeTxt2File(all, prefs);
                            }
                            else if (!JPlayerPrefs.with(EditorActivity.this).contains("NewUserCape") && !JPlayerPrefs.with(EditorActivity.this).contains("User%20Cape%20Skin"))
                            {
                                setcape.setEnabled(true);
                                Toast.makeText(EditorActivity.this, "Please open the game at least one time before applying a custom cape.", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                    else
                    {
                        setcape.setEnabled(true);
                        Toast.makeText(EditorActivity.this, "PG3D data was not found.", Toast.LENGTH_SHORT).show();
                    }
                } catch (JSONException e) {
                    setcape.setEnabled(true);
                    e.printStackTrace();
                } catch (UnsupportedEncodingException e) {
                    setcape.setEnabled(true);
                    e.printStackTrace();
                }
            }
        }  , 1000);
    }

    @QVMProtect
    private void setName(String name)
    {
        File playerprefs = new File(EditorActivity.this.getApplicationInfo().dataDir + "/shared_prefs/com.pixel.gun3d.v2.playerprefs.xml");
        if (playerprefs.exists() && playerprefs.isFile())
        {
            playerprefs.delete();
        }
        new Handler().postDelayed(new Runnable() {
            public void run() {
                try {
                    if (prefs.exists()) {
                        if (prefs.renameTo(playerprefs)) {
                            prefs.delete();
                            if (JPlayerPrefs.with(EditorActivity.this).contains("NamePlayer")) {
                                JPlayerPrefs.with(EditorActivity.this).remove("NamePlayer");
                                JPlayerPrefs.with(EditorActivity.this).write("NamePlayer", name);
                                new Handler().postDelayed(new Runnable() {
                                    public void run() {
                                        if (playerprefs.renameTo(prefs)) {
                                            PointsController.get().AddPointsServer(-2);
                                            Toast.makeText(EditorActivity.this, "Success!", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                }, 1000);
                                //String all = readFromFile(playerprefs);
                                //writeTxt2File(all, prefs);
                                //playerprefs.delete();
                            } else if (!JPlayerPrefs.with(EditorActivity.this).contains("NamePlayer")) {
                                JPlayerPrefs.with(EditorActivity.this).write("NamePlayer", name);
                                new Handler().postDelayed(new Runnable() {
                                    public void run() {
                                        if (playerprefs.renameTo(prefs)) {
                                            Toast.makeText(EditorActivity.this, "Success!", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                }, 1000);
                                //String all = readFromFile(playerprefs);
                                //writeTxt2File(all, prefs);
                                //playerprefs.delete();
                            }
                        }
                    } else {
                        Toast.makeText(EditorActivity.this, "PG3D data was not found.", Toast.LENGTH_SHORT).show();
                    }
                } catch (Exception a) {
                    a.printStackTrace();
                }
            }
        }, 1000);
    }

    @QVMProtect
    private void putSkin(File picked)
    {
        addskin.setEnabled(false);
        File playerprefs = new File(EditorActivity.this.getApplicationInfo().dataDir + "/shared_prefs/com.pixel.gun3d.v2.playerprefs.xml");
        if (playerprefs.exists() && playerprefs.isFile()) {
            playerprefs.delete();
        }
        new Handler().postDelayed(new Runnable() {
            public void run() {
                try {
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inJustDecodeBounds = true;
                    BitmapFactory.decodeFile(picked.getAbsolutePath(), options);
                    int width = options.outWidth;
                    int height = options.outHeight;
                    if (width == 64 && height == 32 || width > 65 && height > 65) // No HD Skins :/
                    {
                        if (prefs.exists()) {
                            if (prefs.renameTo(playerprefs)) {
                                prefs.delete();
                                if (JPlayerPrefs.with(EditorActivity.this).contains("User%20Skins")) {
                                    String base64img = base64Image(picked.getAbsolutePath());
                                    String value = JPlayerPrefs.with(EditorActivity.this).read("User%20Skins");
                                    JSONObject json = new JSONObject(URLDecoder.decode(value, "UTF-8"));
                                    json.put("6362686966760" + randInt(5), base64img);
                                    JPlayerPrefs.with(EditorActivity.this).remove("User%20Skins");
                                    JPlayerPrefs.with(EditorActivity.this).write("User%20Skins", URLEncoder.encode(json.toString(), "UTF-8"));
                                    new Handler().postDelayed(new Runnable() {
                                        public void run() {
                                            if (playerprefs.renameTo(prefs)) {
                                                addskin.setEnabled(true);
                                                PointsController.get().AddPointsServer(-5);
                                                Toast.makeText(EditorActivity.this, "Success!", Toast.LENGTH_SHORT).show();
                                            }
                                        }
                                    }, 1000);
                                    //String all = readFromFile(playerprefs);
                                    //writeTxt2File(all, prefs);
                                    //playerprefs.delete();
                                } else if (!JPlayerPrefs.with(EditorActivity.this).contains("User%20Skins")) {
                                    String base64img = base64Image(picked.getAbsolutePath());
                                    JSONObject json = new JSONObject();
                                    json.put("6362686966760" + randInt(5), base64img);
                                    JPlayerPrefs.with(EditorActivity.this).write("User%20Skins", URLEncoder.encode(json.toString(), "UTF-8"));
                                    new Handler().postDelayed(new Runnable() {
                                        public void run() {
                                            if (playerprefs.renameTo(prefs)) {
                                                addskin.setEnabled(true);
                                                Toast.makeText(EditorActivity.this, "Success!", Toast.LENGTH_SHORT).show();
                                            }
                                        }
                                    }, 1000);
                                    //String all = readFromFile(playerprefs);
                                    //writeTxt2File(all, prefs);
                                    //playerprefs.delete();
                                }
                            }
                        } else {
                            addskin.setEnabled(true);
                            Toast.makeText(EditorActivity.this, "PG3D data was not found.", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else if (width == 64 && height == 64)
                    {
                        addskin.setEnabled(true);
                        Toast.makeText(EditorActivity.this, "The skin you have selected in not correctly formatted. Please use 'http://old.minecraft.novaskin.me/' to format you skin correctly.", Toast.LENGTH_SHORT).show();
                    }
                } catch (JSONException e) {
                    addskin.setEnabled(true);
                    e.printStackTrace();
                } catch (UnsupportedEncodingException e) {
                    addskin.setEnabled(true);
                    e.printStackTrace();
                }
            }
        }, 1000);
    }

    @Override
    int getContentViewId() {
        return R.layout.editor;
    }

    @Override
    int getNavigationMenuItemId() {
        return R.id.navigation_editor;
    }
}
