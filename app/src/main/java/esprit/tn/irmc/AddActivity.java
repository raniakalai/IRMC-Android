package esprit.tn.myapplication;

import android.content.Intent;
import android.os.Bundle;
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
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

public class AddActivity extends AppCompatActivity {
    EditText centerName;
    EditText sigle;
    Button btnAdd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        centerName=(EditText)findViewById(R.id.editName);
        sigle=(EditText)findViewById(R.id.editSigle);
        btnAdd=(Button)findViewById(R.id.addBtn);

        final RequestQueue queue = Volley.newRequestQueue(this);
        final String url = "http://10.0.2.2:18080/IRMCPI-web/IRMCPI";
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                JSONObject jsonObject = new JSONObject();
                try {
                    jsonObject.put("center_name", centerName.getText()); //min
                    jsonObject.put("sigle", sigle.getText());
                } catch (Exception e) {
                    e.printStackTrace();
                }

                JsonObjectRequest postRequest = new JsonObjectRequest(Request.Method.POST,
                        url, jsonObject,
                        new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {
                                Toast.makeText(getApplicationContext(),"Center Created !",Toast.LENGTH_LONG).show();
                                startActivity(new Intent(AddActivity.this,MainActivity.class));
                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();

                    }
                });
                queue.add(postRequest);
            }
        });


      /*  final String url = "http://10.0.2.2:18080/IRMCPI-web/IRMCPI/68"; //fi bok3et 68 hot ay id w baed twali /{id}
        StringRequest dr = new StringRequest(Request.Method.DELETE, url,
                new Response.Listener<String>()
                {
                    @Override
                    public void onResponse(String response) {

                        Toast.makeText(getApplicationContext(), "Deleted",Toast.LENGTH_LONG).show();

                    }
                    },
                new Response.ErrorListener()
                {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                    }
                }
        );
        queue.add(dr);*/

    }




}
