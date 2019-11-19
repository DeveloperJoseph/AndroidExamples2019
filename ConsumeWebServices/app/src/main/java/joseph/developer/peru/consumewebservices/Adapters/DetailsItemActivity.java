package joseph.developer.peru.consumewebservices.Adapters;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import joseph.developer.peru.consumewebservices.Models.Items;
import joseph.developer.peru.consumewebservices.R;

public class DetailsItemActivity extends AppCompatActivity {

    private TextView idItem;
    private TextView creatorItem;
    private TextView likes;
    private ImageView imageItemView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_item);

        Intent intent = getIntent();
        Items item = (Items) intent.getSerializableExtra("items");
        idItem = findViewById(R.id.idItemDetailsTextView);
        idItem.setText(String.valueOf("ID: "+item.getIdItem()));
        creatorItem = findViewById(R.id.creatorDetailsTextView);
        creatorItem.setText("CREATOR: "+item.getCreator());
        likes = findViewById(R.id.likesDetailsTextView);
        likes.setText("LIKES: "+item.getLikes());


        //load image
        imageItemView = findViewById(R.id.imageDetailsImageView);
        Picasso.with(this).load(item.getImageURL()).fit().centerInside().into(imageItemView);

    }
}
