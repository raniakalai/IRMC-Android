package esprit.tn.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Gson gson;
    RequestQueue queue;
    Button btnAjouter;
    ArrayList<Center> dataModels;
    ListView listView;
    private static CustomAdapter adapter;
    //TextView nameCenter;
   Center c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GsonBuilder gsonBuilder = new GsonBuilder();
        gson = gsonBuilder.create();
        queue = Volley.newRequestQueue(this);

        fetchLocations();

        //nameCenter = (TextView)findViewById(R.id.name_center);
        listView=(ListView)findViewById(R.id.listView);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Center dataModel= dataModels.get(position);
                Gson gson = new Gson();
                String json = gson.toJson(dataModel);
                Intent intent=new Intent(MainActivity.this,Details.class);
                intent.putExtra("center",json );
                startActivity(intent);
                Toast.makeText(getApplicationContext(),dataModel.getCenter_name()+" clicked !", Toast.LENGTH_LONG).show();
            }
        });

        btnAjouter = (Button) findViewById(R.id.buttonAdd);
        btnAjouter.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                startActivity(new Intent(MainActivity.this, AddActivity.class));

            }
    });}

     /*   ListView listView = (ListView)findViewById(R.id.listView);



   class CenterAdapter extends BaseAdapter{

    }*/
    private void fetchLocations() {
        StringRequest request = new StringRequest(Request.Method.GET, "http://10.0.2.2:18080/IRMCPI-web/IRMCPI", onPostsLoaded, onPostsError);
        Log.d("url",request.toString());
        queue.add(request);
    }

    private final Response.Listener<String> onPostsLoaded = new Response.Listener<String>() {
        @Override
        public void onResponse(String response) {
            String ch=response;
            Gson gson = new Gson();
            Center c = new Center();
            Type listType = new TypeToken<List<Center>>(){}.getType();
            List<Center> centers = new Gson().fromJson(ch, listType);
            //Log.d("ch" ,ch);
            Log.d("List" ,centers.toString());
            //dataModels= new ArrayList<>();
            dataModels = new ArrayList<>();
            dataModels.addAll(centers);
            adapter= new CustomAdapter(dataModels,getApplicationContext());
            listView.setAdapter(adapter);

        /*
          nameCenter.setText(c.getCenter_name());*/
        //nameCenter.setText(centers.toString());


        }
    };

    private final Response.ErrorListener onPostsError = new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {
           Log.e("PostActivity", error.toString());
            //nameCenter.setText("something went worring!");
        }
    };
}
