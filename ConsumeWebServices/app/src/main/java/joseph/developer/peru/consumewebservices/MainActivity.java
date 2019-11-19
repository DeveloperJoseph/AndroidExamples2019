package joseph.developer.peru.consumewebservices;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;

import joseph.developer.peru.consumewebservices.Adapters.DetailsItemActivity;
import joseph.developer.peru.consumewebservices.Adapters.ItemsAdapter;
import joseph.developer.peru.consumewebservices.Models.Items;

public class MainActivity extends AppCompatActivity implements ItemsAdapter.OnItemClickListener {

    private RecyclerView myItemsRecyclerView;
    private ItemsAdapter itemsAdapter;
    private ArrayList<Items> listaItems;
    private RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myItemsRecyclerView = findViewById(R.id.myRecyclerView);
        myItemsRecyclerView.setHasFixedSize(true);
        myItemsRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        listaItems = new ArrayList<Items>();

        requestQueue = Volley.newRequestQueue(this);
        consumeWebService();
    }

    private void consumeWebService() {

        String urlWebService = "https://pixabay.com/api/?key=5303976-fd6581ad4ac165d1b75ccb3&q=yellow+flowers&image_type=photo";

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, urlWebService,
                null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                //get json array from web service
                try {
                    JSONArray jsonArray = response.getJSONArray("hits");
                    for(int i=0;i<jsonArray.length();i++){
                        JSONObject hit = jsonArray.getJSONObject(i);
                        Long idItem = hit.getLong("id");
                        String imageURL = hit.getString("webformatURL");
                        String creator  =hit.getString("user");
                        Integer likes = hit.getInt("likes");

                        listaItems.add(new Items(idItem,imageURL,creator,likes));
                    }

                    //set adapter recycler view
                    itemsAdapter = new ItemsAdapter(MainActivity.this,listaItems);
                    myItemsRecyclerView.setAdapter(itemsAdapter);
                    itemsAdapter.setOnItemClickListener(MainActivity.this);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        requestQueue.add(request);
    }

    @Override
    public void onItemClick(int position) {
        Items item = listaItems.get(position);
        Intent intent = new Intent(MainActivity.this, DetailsItemActivity.class);
        intent.putExtra("items",item);
        startActivity(intent);
    }
}
