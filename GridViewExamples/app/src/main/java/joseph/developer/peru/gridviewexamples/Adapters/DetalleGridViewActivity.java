package joseph.developer.peru.gridviewexamples.Adapters;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import joseph.developer.peru.gridviewexamples.R;

public class DetalleGridViewActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_detalle_persona_gridview);

        getSupportActionBar().setTitle(getIntent().getExtras().get("name").toString());
    }
}
