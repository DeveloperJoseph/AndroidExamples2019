package joseph.developer.peru.gridviewexamples;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private GridView myGridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myGridView = findViewById(R.id.myGridView);
        myGridView.setAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, listaPersonas()));
    }

    private List<String> listaPersonas() {
        List<String> listNamePersonas  = new ArrayList<String>();

        for(int i=0;i<5;i++){
            listNamePersonas.add("Joseph");
            listNamePersonas.add("Daniel");
            listNamePersonas.add("Sypware");
            listNamePersonas.add("Joseph");
            listNamePersonas.add("Daniel");
            listNamePersonas.add("Sypware");
        }

       return listNamePersonas;
    }
}
