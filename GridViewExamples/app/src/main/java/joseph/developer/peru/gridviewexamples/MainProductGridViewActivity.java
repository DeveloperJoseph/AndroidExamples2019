package joseph.developer.peru.gridviewexamples;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import joseph.developer.peru.gridviewexamples.Adapters.DetalleProductoGridViewActivity;
import joseph.developer.peru.gridviewexamples.Adapters.ProductAdapter;
import joseph.developer.peru.gridviewexamples.models.Product;

public class MainProductGridViewActivity extends AppCompatActivity {

    private GridView productsGridView;

    private List<Product> listProductos = new ArrayList<Product>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main_product_grid_view);
        getSupportActionBar().setTitle("Lista de Frutas");

        listProductos.add(new Product("p001","Product Orange",100.00,
                R.drawable.oranges));
        listProductos.add(new Product("p002","Product Strawberry",100.00,
                R.drawable.strawberry));
        listProductos.add(new Product("p003","Product Watermelon",100.00,
                R.drawable.watermelon));
        listProductos.add(new Product("p004","Product Apple",100.00,
                R.drawable.apple));
        listProductos.add(new Product("p005","Product Kiwi",100.00,
                R.drawable.kiwi));
        listProductos.add(new Product("p006","Product Banana",100.00,
                R.drawable.banana));


        productsGridView = findViewById(R.id.myGridViewProducts);
        productsGridView.setAdapter(new ProductAdapter(this,listProductos));


        productsGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Product product = listProductos.get(position);
                Toast.makeText(getApplicationContext(),
                        product.getNameProduct(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainProductGridViewActivity.this, DetalleProductoGridViewActivity.class);
                intent.putExtra("producto",product);
                startActivity(intent);
            }
        });
    }




}
