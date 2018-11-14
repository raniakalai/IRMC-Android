package esprit.tn.myapplication;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

public class Details extends AppCompatActivity {
    TextView url_facebook;
    TextView centername;
    TextView pays;
    TextView centerSigle;
    TextView codePostale;
    TextView activity;
    TextView type;
    TextView adresse_center;
    TextView pret;
    TextView connexion;
    Button supprimerbtn;
    Fragment fmap = new Fragment();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        centername=(TextView)findViewById(R.id.CenterName);
        centerSigle=(TextView)findViewById(R.id.CenterSigle);
        codePostale=(TextView)findViewById(R.id.CodePostale);
        url_facebook =(TextView)findViewById(R.id.Url_facebook);
        pays =(TextView)findViewById(R.id.Pays);
        adresse_center =(TextView)findViewById(R.id.Adresse);
        activity=(TextView)findViewById(R.id.Activity);
        type =(TextView)findViewById(R.id.Type);
        connexion =(TextView)findViewById(R.id.Connexion);
        pret =(TextView)findViewById(R.id.Pret);
        supprimerbtn = (Button)findViewById(R.id.buttonsupprimer);
        Button map = findViewById(R.id.mapbtn);

        Bundle b = new Bundle();
        Gson gson = new Gson();
        b = getIntent().getExtras();
        String centerstring = b.getString("center");
        final Center center = gson.fromJson(centerstring, Center.class);
        Log.d("detail center",center.toString());
        map.setOnClickListener(v -> {
            if (!center.getX().equals("0")) {
                fmap = new MapFragments();
                android.support.v4.app.FragmentManager manager = getSupportFragmentManager();
                Bundle bundle2 = new Bundle();
                bundle2.putString("myObject", centerstring);

                fmap.setArguments(bundle2);
                android.support.v4.app.FragmentTransaction transaction = manager.beginTransaction();
                transaction.replace(R.id.container, fmap, "SC");
                transaction.commit();
            }else{
                Toast.makeText(getApplicationContext(),"this center has no coordinations!",Toast.LENGTH_LONG).show();

            }
        });
        //Log.d("center : ",center.toString());
        centername.setText(centername.getText()+center.getCenter_name());
        centerSigle.setText(centerSigle.getText()+center.getSigle());
        codePostale.setText(codePostale.getText()+String.valueOf(center.getCode_postale()));
        url_facebook.setText(url_facebook.getText()+String.valueOf(center.getFacebook_url()));
        adresse_center.setText(adresse_center.getText()+String.valueOf(center.getCenter_adresse()));
        pays.setText(pays.getText()+String.valueOf(center.getPays()));
        activity.setText(activity.getText()+String.valueOf(center.getActivity_type()));
        type.setText(type.getText()+String.valueOf(center.getCenter_type()));
        pret.setText(type.getText()+String.valueOf(center.getCenter_pret()));
        connexion.setText(type.getText()+String.valueOf(center.getCenter_internet()));

        url_facebook.setOnClickListener(v -> {
            Intent viewIntent =
                    new Intent("android.intent.action.VIEW",
                            Uri.parse(center.getFacebook_url()));
            startActivity(viewIntent);
        });
        final RequestQueue queue = Volley.newRequestQueue(this);
        supprimerbtn.setOnClickListener(v -> {
             final String url = "http://10.0.2.2:18080/IRMCPI-web/IRMCPI/"+center.getCenter_id();
    StringRequest dr = new StringRequest(Request.Method.DELETE, url,
            new Response.Listener<String>()
            {
                @Override
                public void onResponse(String response) {
                    Toast.makeText(getApplicationContext(),center.getCenter_name()+" is Deleted !",Toast.LENGTH_LONG).show();
                    startActivity(new Intent(Details.this,MainActivity.class));
                }
                },
            new Response.ErrorListener()
            {
                @Override
                public void onErrorResponse(VolleyError error) {
                }
            }
    );
    queue.add(dr);
        });
    }
}