package esprit.tn.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter<Center> implements View.OnClickListener{

    private ArrayList<Center> dataSet;
    Context mContext;

    private static class ViewHolder {
        TextView centerName;
        TextView sigle;
    }

    public CustomAdapter(ArrayList<Center> data, Context context) {
        super(context, R.layout.row_item, data);
        this.dataSet = data;
        this.mContext=context;
    }

    @Override
    public void onClick(View v) {
        int position=(Integer) v.getTag();
        Object object= getItem(position);
        Center dataModel=(Center)object;

        switch (v.getId())
        {
        }
    }

    private int lastPosition = -1;

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Center dataModel = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        ViewHolder viewHolder; // view lookup cache stored in tag

        final View result;

        if (convertView == null) {

            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.row_item, parent, false);
            viewHolder.centerName = (TextView) convertView.findViewById(R.id.name);
            viewHolder.sigle = (TextView) convertView.findViewById(R.id.sigle);

            result=convertView;

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            result=convertView;
        }

        lastPosition = position;

        viewHolder.centerName.setText(dataModel.getCenter_name());
        viewHolder.sigle.setText(dataModel.getSigle());
        // Return the completed view to render on screen
        return convertView;
    }
}
