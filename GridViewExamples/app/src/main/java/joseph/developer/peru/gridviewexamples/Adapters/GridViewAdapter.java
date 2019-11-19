package joseph.developer.peru.gridviewexamples.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import joseph.developer.peru.gridviewexamples.R;

public class GridViewAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<String> myList;

    public GridViewAdapter(Context context, ArrayList<String> myList) {
        this.context = context;
        this.myList = myList;
    }

    @Override
    public int getCount() {
        return myList.size();
    }

    @Override
    public Object getItem(int position) {
        return myList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null){
            //create class layout inflater
            LayoutInflater layoutInflater =
                    (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.items_personas_gridview,null);
        }
        TextView nameTextView = convertView.findViewById(R.id.namePersonaTextView);
        nameTextView.setText(myList.get(position));
        return convertView;
    }
}
