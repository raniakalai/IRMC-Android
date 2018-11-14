package esprit.tn.irmc;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import esprit.tn.irmc.model.Article;

public class TabFragment1 extends Fragment {

    TextView textView ;
    TextView textView1 ;
    TextView textView2 ;
    TextView textView3 ;
    TextView textView4 ;
    TextView textView5 ;
    String mParam1;
    private List<Article> l = new ArrayList<>();
    private static final String TAG = TabFragment1.class.getSimpleName();
    Article e = new Article();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

         View y =    inflater.inflate(R.layout.tab_fragment_1, container, false);

        textView = (TextView) y.findViewById(R.id.titre);
        textView1 = (TextView) y.findViewById(R.id.date);
        textView2 = (TextView) y.findViewById(R.id.pays);
        textView3 = (TextView) y.findViewById(R.id.numero);
        textView4 = (TextView) y.findViewById(R.id.abstrait);
        textView5 = (TextView) y.findViewById(R.id.date_ajout);


        //textView.setText("hhh"+ListActivity.article.getId());

        String url = "http://10.0.2.2:18080/IRMC-web/rest/Article/article?id="+ListActivity.article.getId();

        String tag_json_arry = "json_array_req";


      /* final ProgressDialog pDialog = new ProgressDialog(this);
        pDialog.setMessage("chargement...");
        pDialog.show();*/



        JsonObjectRequest req = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>()
                {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d(TAG, response.toString());
                            try {




                                JSONObject obj = response;

                                String titre = obj.getString("titre");
                                String date = obj.getString("date");
                                Integer id  = obj.getInt("id");
                                Integer numero  = obj.getInt("numero");
                                String pays = obj.getString("pays");
                                String date_ajout = obj.getString("date_ajout");
                                String abstrait = obj.getString("abstrait");
                                String file = obj.getString("file");






                                e.setId(id);
                                e.setDate(date);
                                e.setTitre(titre);
                                e.setNumero(numero);
                                e.setPays(pays);
                                e.setDate_ajout(date_ajout);
                                e.setAbstrait(abstrait);
                                e.setFile(file);



                                textView.setText(obj.getString("titre"));
                                textView1.setText(obj.getString("date"));
                                textView2.setText(obj.getString("pays"));
                                textView3.setText(obj.getString("numero"));
                                textView4.setText(obj.getString("abstrait"));
                                textView5.setText(obj.getString("date_ajout"));






                            } catch (JSONException e) {
                                e.printStackTrace();
                            }













                    }

                }

                , new Response.ErrorListener() {


            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "Error: " + error.getMessage());

            }
        });

      //  System.out.println(e.getTitre());


// Adding request to request queue
        AppController.getInstance().addToRequestQueue(req, tag_json_arry);

        textView.setText(e.getTitre());

        return y;




    }
}
