package joseph.developer.peru.gridviewexamples.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import joseph.developer.peru.gridviewexamples.R;
import joseph.developer.peru.gridviewexamples.models.Product;

public class ProductAdapter extends ArrayAdapter<Product> {

    private Context context;
    private List<Product> productList;

    public ProductAdapter(Context context, List<Product> productList) {

        super(context, R.layout.items_productos_gridview,productList);
        this.context = context;
        this.productList = productList;
    }


    @NonNull
    @Override
    public View getView(int position, View convertView,  ViewGroup parent) {

        LayoutInflater layoutInflater =
                (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);

        View view =  layoutInflater.inflate(R.layout.items_productos_gridview,parent,false);
        Product product = productList.get(position);
        ImageView productImageView  = view.findViewById(R.id.productImageView);
        productImageView.setImageResource(product.getPhotoProduct());
        TextView nameProductTextView = view.findViewById(R.id.nameProductTextView);
        nameProductTextView.setText(product.getNameProduct());

        return view;

    }
}
