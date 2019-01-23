package example.com.elearning;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class RecyclerViewHolders extends RecyclerView.ViewHolder implements View.OnClickListener{

    public TextView countryName;
    public ImageView countryPhoto;
    String dude="";
    Context context;

    public RecyclerViewHolders(View itemView) {
        super(itemView);
        itemView.setOnClickListener(this);
        countryName = itemView.findViewById(R.id.country_name);
        countryPhoto = itemView.findViewById(R.id.country_photo);
    }

    @Override
    public void onClick(View view) {
        if(getPosition() == 0){
            Intent intent = new Intent(view.getContext(),VideoList.class);
            view.getContext().startActivity(intent);
        }else if(getPosition() == 1){
            Intent intent = new Intent(view.getContext(),Learning.class);
            view.getContext().startActivity(intent);
        }else if(getPosition() == 3){
            Intent intent = new Intent(view.getContext(),Documents.class);
            view.getContext().startActivity(intent);
        }
    }
}