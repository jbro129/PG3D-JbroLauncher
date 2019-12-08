package com.jbro129.mod.pg3dlauncher;

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

import org.json.JSONObject;

import java.security.GeneralSecurityException;
import java.security.spec.ECField;
import java.util.HashMap;
import java.util.Map;

public class PointsController
{
    private int amount;
    private static PointsController act = new PointsController();


    public static PointsController get() {
        return act;
    }

    @QVMProtect
    public void AddPointsServer(int add)
    {
        /*
        int current = getPointsServer();

        int added = current + add;

        setPointsServer(added);
        */
    }

    @QVMProtect
    public /*int*/ void getPointsServer()
    {
        // CODE REMOVED
    }

    @QVMProtect
    private void setPointsServer(int amountt)
    {
        // CODE REMOVED
    }
}
