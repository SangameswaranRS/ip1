package com.example.sangameswaran.practice;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
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
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Sangameswaran on 08-05-2017.
 */

public class VolleyGetJsonObject extends AppCompatActivity {

TextView t1,t2,t3;
    String SERVER_URL="http://10.1.19.188/app/insert.php";
    Button b1;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.volley_layout);

        t1=(TextView)findViewById(R.id.tv1);
        t2=(TextView)findViewById(R.id.tv2);
        t3=(TextView)findViewById(R.id.tv3);
        b1=(Button)findViewById(R.id.b1);
        JSONObject o;
        final JSONObject finalO = o=null;
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RequestQueue requestQueue= Volley.newRequestQueue(VolleyGetJsonObject.this);
                StringRequest overall=new StringRequest(Request.Method.POST, SERVER_URL, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        Toast.makeText(getApplicationContext(),"the responce is positive"+response,Toast.LENGTH_LONG).show();
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(),"Error"+error,Toast.LENGTH_LONG).show();

                    }
                }){
                    @Override
                        protected Map<String, String> getParams() throws AuthFailureError {
                            Map<String,String> params=new HashMap<String, String>();
                            params.put("name","PrabhuSiva");
                            params.put("username","prabhusivam26");
                            params.put("password","passwd");

                            params.put("email","emaild");
                            return params;
                    }
                };

                requestQueue.add(overall);


            }
        });
    }
}
