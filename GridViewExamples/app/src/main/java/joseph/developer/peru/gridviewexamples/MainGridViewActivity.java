package joseph.developer.peru.gridviewexamples;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;

import joseph.developer.peru.gridviewexamples.Adapters.DetalleGridViewActivity;
import joseph.developer.peru.gridviewexamples.Adapters.GridViewAdapter;

public class MainGridViewActivity extends AppCompatActivity {


    private GridView myGridViewWithImages;
    private GridViewAdapter gridViewAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_grid_view);

        myGridViewWithImages  = findViewById(R.id.myGridViewWithImages);
        gridViewAdapter = new GridViewAdapter(this,listNames());
        myGridViewWithImages.setAdapter(gridViewAdapter);

        myGridViewWithImages.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent  =
                        new Intent(MainGridViewActivity.this,
                                DetalleGridViewActivity.class);

                intent.putExtra("name",gridViewAdapter.getItem(position).toString());
                startActivity(intent);
            }
        });

    }

    private ArrayList<String> listNames() {
        ArrayList<String> listName = new ArrayList<>();
        listName.add("Joseph");
        listName.add("Maria");
        listName.add("Daniel");
        listName.add("Melany");
        return listName;
    }
}
