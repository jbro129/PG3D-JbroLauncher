package com.jbro129.mod.pg3dlauncher;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.jbro129.mod.QVMProtect;
import com.jbro129.mod.vending.AccountActivity;
import com.jbro129.mod.vending.Constants;
import com.jbro129.mod.pg3dlauncher.PurchaseActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.security.GeneralSecurityException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class PointsActivity extends BaseActivity {

    private Button addpoints;

    private Button buypoints1;
    private Button buypoints2;

    private TextView currentjpoints;
    private TextView available;
    private String[] urls;


    @Override
    @QVMProtect
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        addpoints = (Button)findViewById(R.id.addpoints);
        currentjpoints = (TextView) findViewById(R.id.current_points2);
        available = (TextView) findViewById(R.id.current_available);


        buypoints1 = (Button)findViewById(R.id.buypoints1);
        buypoints2 = (Button)findViewById(R.id.buypoints2);

        urls();

        addpoints.setEnabled(false);
        ((Button)addpoints).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                String url = getRandomYTID();
                watchYoutubeVideo(PointsActivity.this, url);
            }
        });
        ((Button)buypoints1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                doPayment("0.99");
            }
        });
        ((Button)buypoints2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                doPayment("4.99");
            }
        });

        try
        {
            currentjpoints.setText("Current JPoints: " + PointsController.get().getPointsServer());
            checkLimit();
        }
        catch (Exception a) {
            a.printStackTrace();
        }
    }

    @QVMProtect
    private void checkLimit()
    {
        //   CODE REMOVED
    }

    @QVMProtect
    public void watchYoutubeVideo(Context context, String id){
        Intent appIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube:" + id));
        Intent webIntent = new Intent(Intent.ACTION_VIEW,
                Uri.parse("http://www.youtube.com/watch?v=" + id));
        try {
            context.startActivity(appIntent);
        } catch (ActivityNotFoundException ex) {
            context.startActivity(webIntent);
        }
        doTimer();
    }

    @QVMProtect
    private void doTimer()
    {
        //   CODE REMOVED
    }

    @QVMProtect
    private void doWaitLock()
    {
        //   CODE REMOVED
    }

    @QVMProtect
    private String getRandomYTID()
    {
        String[] array = urls;
        return array[new Random().nextInt(array.length)];
    }

    public void setURLS(JSONArray array) {
        urls=new String[array.length()];
        for(int i=0; i<urls.length; i++) {
            urls[i]=array.optString(i);
        }
    }

    private void urls()
    {
        RequestQueue req = Volley.newRequestQueue(PointsActivity.this);

        JsonObjectRequest jsObjRequest = new JsonObjectRequest(Request.Method.GET, Constants.YTURLS_URL, null, new Response.Listener<JSONObject>() {

            public void onResponse(JSONObject response)
            {
                try {
                    JSONArray urls2 = response.getJSONArray("urls");

                    setURLS(urls2);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error)
            {
                urls = null;
            }
        });
        req.add(jsObjRequest);
    }

    @QVMProtect
    private void doPayment(String type)
    {
        PurchaseActivity.email = AccountActivity.email;
        PurchaseActivity.pass = AccountActivity.password;
        Intent intent = new Intent(this, PurchaseActivity.class);
        intent.putExtra("price", type);
        startActivity(intent);
    }

    @Override
    int getContentViewId() {
       return R.layout.activity_points;
    }

    @Override
    int getNavigationMenuItemId() {
        return R.id.navigation_points;
    }
}

