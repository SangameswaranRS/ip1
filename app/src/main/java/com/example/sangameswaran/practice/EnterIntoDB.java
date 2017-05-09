package com.example.sangameswaran.practice;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Sangameswaran on 09-05-2017.
 */

public class EnterIntoDB extends AppCompatActivity {

    EditText name,age;
    Button send;
    String URL="http://10.1.19.187:3356/hitmeforsignin";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.enter_into_db_layout);
        name=(EditText)findViewById(R.id.name);
        age=(EditText)findViewById(R.id.age);
        send=(Button) findViewById(R.id.send);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EnterIntoDBModelClass modelClass=new EnterIntoDBModelClass(name.getText().toString(),age.getText().toString());
                Gson gson=new Gson();
                String jsoninString=gson.toJson(modelClass);
                Toast.makeText(getApplicationContext(),""+jsoninString,Toast.LENGTH_LONG).show();
                JSONObject object=null;
                try {
                    object=new JSONObject(jsoninString);
                    Toast.makeText(getApplicationContext(),""+object.toString(),Toast.LENGTH_LONG).show();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                RequestQueue requestQueue= Volley.newRequestQueue(EnterIntoDB.this);
                JsonObjectRequest jsonObjectRequest=new JsonObjectRequest(Request.Method.POST, URL, object, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                        Toast.makeText(getApplicationContext(),"Response inserted",Toast.LENGTH_LONG).show();
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(),"Request Failed",Toast.LENGTH_LONG).show();

                    }
                });
                requestQueue.add(jsonObjectRequest);



            }
        });
    }
}
