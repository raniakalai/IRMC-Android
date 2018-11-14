package esprit.tn.irmc;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import esprit.tn.irmc.model.Article;

public class ListActivity extends AppCompatActivity {
    private List<Article> l = new ArrayList<>();
    private CustomListAdapter adapter;
    private static final String TAG = ListActivity.class.getSimpleName();
    private ListView listView;
    public static Article article;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        listView = (ListView) findViewById(R.id.data);
        adapter = new CustomListAdapter(this,l);
//System.out.println("adaaaapter"+adapter.toString());
        //   System.out.println("liiiiiiiiiiiiiist"+listView.toString());

        listView.setAdapter(adapter);


        String url = "http://10.0.2.2:18080/IRMC-web/rest/Article";

        String tag_json_arry = "json_array_req";


       /* final ProgressDialog pDialog = new ProgressDialog(this);
       pDialog.setMessage("chargement...");
      pDialog.show();*/


        JsonArrayRequest req = new JsonArrayRequest(url,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        Log.d(TAG, response.toString());
                        //pDialog.hide();
                        for (int i = 0; i < response.length(); i++) {
                            try {
                                Article e = new Article();


                                JSONObject obj = response.getJSONObject(i);

                                String titre = obj.getString("titre");
                                String date = obj.getString("date");
                                Integer id  = obj.getInt("id");

                                e.setId(id);
                                e.setDate(date);
                                e.setTitre(titre);





                                l.add(e);
                                System.out.println("adaaaapter"+l.toString());


                            } catch (JSONException e) {
                                e.printStackTrace();
                            }


                        }





                        adapter.notifyDataSetChanged();



                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "Error: " + error.getMessage());
              //  pDialog.hide();
            }
        });

// Adding request to request queue
        AppController.getInstance().addToRequestQueue(req, tag_json_arry);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Article a = l.get(position);
                // retrieve from movie whatever you want


                article =  l.get(position);

                a.getId();
                Toast.makeText(getApplicationContext(),"id: "+a.getId(),Toast.LENGTH_LONG).show();
                // creaet intent and add data to it.
                Intent intent = new Intent(ListActivity.this,detailActivity.class);
                intent.putExtra("id",a.getId());
                startActivity(intent);
            }
        });
    }




}





