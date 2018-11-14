package esprit.tn.irmc;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import esprit.tn.irmc.model.Article;


public class CustomListAdapter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private ListView listView;
    private List<Article> ArticleItems;

    public CustomListAdapter(Activity activity, List<Article> Items) {
        this.activity = activity;
        this.ArticleItems = Items;
    }

    @Override
    public int getCount() {
        return ArticleItems.size();
    }

    @Override
    public Object getItem(int location) {
        return ArticleItems.get(location);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (inflater == null)
            inflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = inflater.inflate(R.layout.list_row, null);



        TextView nom = (TextView) convertView.findViewById(R.id.nom);
        TextView addresse = (TextView) convertView.findViewById(R.id.address);


        // getting movie data for the row
        Article e = ArticleItems.get(position);

        // thumbnail image

        // title
        nom.setText(e.getTitre());
        addresse.setText(e.getDate());





        return convertView;


}}