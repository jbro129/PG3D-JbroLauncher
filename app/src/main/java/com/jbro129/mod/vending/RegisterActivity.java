package com.jbro129.mod.vending;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.jbro129.mod.QVMProtect;
import com.jbro129.mod.pg3dlauncher.Prefs;
import com.jbro129.mod.pg3dlauncher.R;
import com.scottyab.aescrypt.AESCrypt;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.GeneralSecurityException;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.Map;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

public class RegisterActivity extends AppCompatActivity
{
    private String email = "";
    private String password = "";
    private String confpass = "";

    private Button register;

    private EditText emailedit;
    private EditText passwordedit;
    private EditText passwordconfirm;

    private SharedPreferences prefs;

    @Override
    @QVMProtect
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.registerlayout);

        prefs = getSharedPreferences("com.jbro129.mod.pg3dlauncher", MODE_PRIVATE);

        register = (Button) findViewById(R.id.registernowbttn);
        emailedit = (EditText) findViewById(R.id.regemail);
        passwordedit = (EditText) findViewById(R.id.regpassword);
        passwordconfirm = (EditText) findViewById(R.id.regpassword2);

        //   CODE REMOVED
    }
}

