package com.jbro129.mod.vending;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.ActivityCompat;
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
import com.jbro129.mod.pg3dlauncher.MainActivity;
import com.jbro129.mod.pg3dlauncher.Prefs;
import com.jbro129.mod.pg3dlauncher.R;
import com.scottyab.aescrypt.AESCrypt;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;

public class AccountActivity
        extends AppCompatActivity
{
    public static String email = "";
    public static String password = "";
    private SharedPreferences prefs;

    private Button login;
    private Button register;

    private EditText emailedit;
    private EditText passwordedit;

    @Override
    @QVMProtect
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.accountlayout);

        prefs = getSharedPreferences("com.jbro129.mod.pg3dlauncher", MODE_PRIVATE);

        register = (Button) findViewById(R.id.registerbttn);
        login = (Button) findViewById(R.id.loginbttn);
        emailedit = (EditText) findViewById(R.id.email);
        passwordedit = (EditText) findViewById(R.id.password);

        login.setEnabled(false);
        register.setEnabled(false);
        ((Button) register).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                AccountActivity.this.startActivity(new Intent(AccountActivity.this, RegisterActivity.class));
            }
        });
        ((Button) login).setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View paramAnonymousView)
            {
                email = emailedit.getText().toString();
                password = passwordedit.getText().toString();
                if (!email.equals("") || !password.equals(""))
                {
                    try
                    {
                        //   CODE REMOVED
                    }
                    catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                }
                else
                {
                    Toast.makeText(AccountActivity.this, "Email and/or Password is empty.", Toast.LENGTH_SHORT).show();
                }
            }
        });
        new Handler().postDelayed(new Runnable()
        {
            public void run()
            {
                try {

                    Update();

                    //Log.d(Constants.TAG, "Email: " + emaill + "| Pass: " + passss);

                    if (Prefs.with(AccountActivity.this).contains(AESCrypt.encrypt(Constants.PASSWORD, "Password")) && Prefs.with(AccountActivity.this).contains(AESCrypt.encrypt(Constants.PASSWORD, "Email")))
                    {
                        String emaill = Prefs.with(AccountActivity.this).read(AESCrypt.encrypt(Constants.PASSWORD, "Email"));
                        String passss = Prefs.with(AccountActivity.this).read(AESCrypt.encrypt(Constants.PASSWORD, "Password"));

                        doLoggin(emaill, passss);
                    }
                    else
                    {
                        login.setEnabled(true);
                        register.setEnabled(true);
                    }

                } catch (GeneralSecurityException e) {
                    e.printStackTrace();
                }
            }
        }, 1000);
    }

    private void doLoggin(String emaill, String passwordd)
    {
        //   CODE REMOVED
    }

    @SuppressLint({"StaticFieldLeak"})
    public void Update() {
        new AsyncTask<Void, Void, Void>() {

            private String newestMsg = "";
            private String currentMsg = "";
            private boolean network;

            protected void onPreExecute()
            {
                network = isNetworkAvailable();
            }

            protected Void doInBackground(Void... voids)
            {
                if (network)

                {
                    RequestQueue req = Volley.newRequestQueue(AccountActivity.this);

                    JsonObjectRequest jsObjRequest = new JsonObjectRequest(Request.Method.GET, Constants.NOTIF_URL, null, new Response.Listener<JSONObject>()
                    {

                        public void onResponse(JSONObject response)
                        {

                            try
                            {

                                newestMsg = response.getJSONObject("update").getString("newestMsg");
                                currentMsg = response.getJSONObject("update").getString(newestMsg);

                                String encKey = AESCrypt.encrypt(Constants.PASSWORD, newestMsg);

                                if (!(Prefs.with(AccountActivity.this).contains(encKey)) || !(Prefs.with(AccountActivity.this).readInt(encKey) == 1))
                                {
                                    Prefs.with(AccountActivity.this).writeInt(encKey, 1);
                                    new AlertDialog.Builder(AccountActivity.this)
                                            .setTitle("New Message From Jbro.")
                                            .setCancelable(false)
                                            .setMessage(currentMsg)
                                            .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialog, int which)
                                                {
                                                    dialog.dismiss();
                                                }
                                            });
                                }
                            }
                            catch (JSONException e)
                            {
                                Log.d("JbroMain: ", e.getMessage());
                                e.printStackTrace();
                            } catch (GeneralSecurityException e) {
                                e.printStackTrace();
                            }
                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Log.e("JbroMain", "Notification Request Error: " + error.getMessage());
                        }
                    });
                    req.add(jsObjRequest);
                }
                else if (!network)
                {
                    AccountActivity.this.runOnUiThread(new Runnable() {
                        public void run()
                        {
                            Toast.makeText(getBaseContext(), "Please Connect To The Internet", Toast.LENGTH_LONG).show();
                        }
                    });
                }
                return null;
            }

            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);

            }
        }.execute();
    }

    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = null;
        if (connectivityManager != null) {
            activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        }
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    @QVMProtect
    public static String JbroFormat(String password, String before) throws GeneralSecurityException {
        String str = "Code removed for security purposes.";
        return str;
    }

    @QVMProtect
    public static String JbroFormatNoEnc(String encryptedstring)
    {
        String str = "Code removed for security purposes.";
        return str;
    }

    @QVMProtect
    public static String JbroUnFormat(String password, String after) throws GeneralSecurityException {
        String str = "Code removed for security purposes.";
        return str;
    }

    @QVMProtect
    public static String JbroUnFormatNoDec(String fortmattedstring) {
        String str = "Code removed for security purposes.";
        return str;
    }


}
