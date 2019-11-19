package joseph.developer.peru.gridviewexamples.Adapters;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import joseph.developer.peru.gridviewexamples.R;
import joseph.developer.peru.gridviewexamples.models.Product;

public class DetalleProductoGridViewActivity extends AppCompatActivity {

    private TextView idProductTextView;
    private TextView nameProductTextView;
    private TextView priceProductTextView;
    private ImageView imageProductImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_producto_grid_view);
        getSupportActionBar().setTitle("Detalles de Producto");
        Intent intent = getIntent();
        Product product = (Product)intent.getSerializableExtra("producto");
        idProductTextView = findViewById(R.id.idProductTextView);
        idProductTextView.setText(product.getIdProduct());
        nameProductTextView = findViewById(R.id.nameProductTextView);
        nameProductTextView.setText(product.getNameProduct());
        priceProductTextView = findViewById(R.id.priceProductTextView);
        priceProductTextView.setText(String.valueOf(product.getPriceProduct()));
        imageProductImageView = findViewById(R.id.productDetailsImageView);
        imageProductImageView.setImageResource(product.getPhotoProduct());


    }
}
