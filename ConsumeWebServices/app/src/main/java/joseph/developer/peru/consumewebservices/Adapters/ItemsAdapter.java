package joseph.developer.peru.consumewebservices.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;


import joseph.developer.peru.consumewebservices.Models.Items;
import joseph.developer.peru.consumewebservices.R;

public class ItemsAdapter extends RecyclerView.Adapter<ItemsAdapter.ItemsViewHolder> {

    private Context context;
    private ArrayList<Items> listaItems;
    //instance class OnItemClickListener
    private OnItemClickListener onItemClickListener;

    //create public interface on item click listener
    public interface  OnItemClickListener{
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }


    public ItemsAdapter(Context context, ArrayList<Items> listaItems) {
        this.context = context;
        this.listaItems = listaItems;
    }


    @NonNull
    @Override
    public ItemsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view =  LayoutInflater.from(context).inflate(R.layout.item_cardview,viewGroup,false);
        return new ItemsViewHolder(view);//new view with
    }


    @Override
    public void onBindViewHolder(@NonNull ItemsViewHolder itemsViewHolder, int i) {
        //create a item for get position of item ,also get values and  set values of layout item
            Items item = listaItems.get(i);
            //get values of object
            String imageURL = item.getImageURL();
            String creator = item.getCreator();
            Integer likes = item.getLikes();

            //set values object
          Picasso.with(context).load(imageURL).fit().centerInside().into(itemsViewHolder.imageView);
          itemsViewHolder.createTextView.setText(creator);
          itemsViewHolder.likesTextView.setText("Likes: "+likes);
    }

    @Override
    public int getItemCount() {
        return listaItems.size();
    }

    //capture values layout
    public class ItemsViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageView;
        private TextView createTextView;
        private TextView likesTextView;

        public ItemsViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageViewCard);
            createTextView = itemView.findViewById(R.id.creatorTextView);
            likesTextView = itemView.findViewById(R.id.likesTextView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(onItemClickListener!=null){
                        Integer itemPosition = getAdapterPosition();//get adapter position
                        if(itemPosition != RecyclerView.NO_POSITION){
                            onItemClickListener.onItemClick(itemPosition);
                        }
                    }
                }
            });
        }

    }
}
