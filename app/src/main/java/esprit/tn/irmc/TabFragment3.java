package esprit.tn.irmc;

import android.app.ProgressDialog;
import android.net.Uri;
import android.os.AsyncTask;
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
import com.github.barteksc.pdfviewer.PDFView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import esprit.tn.irmc.model.Article;

public class TabFragment3 extends Fragment {

PDFView pdfView;
    String mParam1;
    private List<Article> l = new ArrayList<>();
    private static final String TAG = TabFragment3.class.getSimpleName();
    Article e = new Article();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {








            View y =    inflater.inflate(R.layout.tab_fragment_3, container, false);
        pdfView =  y.findViewById(R.id.pdfView);


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



                            Uri myUri = Uri.parse("http://localhost:8080/IRMC/"+obj.getString("file"));

                           //  new RetrievePDFStream().execute("http://localhost:8080/IRMC/"+obj.getString("file"));
                            System.out.println("http://localhost:8080/IRMC/"+obj.getString("file"));
        pdfView.fromAsset(obj.getString("file"))

                .pages(0, 2, 1, 3, 3, 3) // all pages are displayed by default
                .enableSwipe(true)
                .swipeHorizontal(false)
                .enableDoubletap(true)
                .defaultPage(0)
                .enableAnnotationRendering(false)
                .password(null)
                .scrollHandle(null)
                .load();


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
        //new RetrievePDFStream().execute("http://localhost:8080/IRMC/DevisSebac.pdf");


// Adding request to request queue
        AppController.getInstance().addToRequestQueue(req, tag_json_arry);


        return y;




    }
    class RetrievePDFStream extends AsyncTask<String, Void, InputStream> {

        @Override
        protected InputStream doInBackground(String... strings) {
            InputStream inputStream = null;
            try {
                URL url = new URL(strings[0]);
                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                if (urlConnection.getResponseCode() == 200) {
                    inputStream = new BufferedInputStream(urlConnection.getInputStream());
                }
            } catch (IOException e) {
                return null;
            }
            return inputStream;
        }
        @Override
        protected void onPostExecute(InputStream inputStream) {
            pdfView.fromStream(inputStream).load();
        }
    }
}
