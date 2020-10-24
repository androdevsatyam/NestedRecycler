package me.ps.nestedrecycler.adapter;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

import java.util.List;

import me.ps.nestedrecycler.R;
import me.ps.nestedrecycler.model.FirstModel;

public class SecondAdapter extends RecyclerView.Adapter<SecondAdapter.SecondViewHolder> {

    Context context;
    List<FirstModel.ImageData> imageData;
    String img_url, base_url, load_url;
    ProgressDialog dialog;

    public SecondAdapter(Context context, List<FirstModel.ImageData> imageData) {
        this.context = context;
        this.imageData = imageData;
        base_url = context.getResources().getString(R.string.img_url);
        load_url = context.getResources().getString(R.string.load_url);

        dialog = new ProgressDialog(context);
    }

    @NonNull
    @Override
    public SecondViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.second_list, parent, false);
        return new SecondViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final SecondViewHolder holder, int position) {
        holder.title.setText(imageData.get(position).category);
        Log.d("Img_Url", "Url=" + img_url);
        img_url = base_url + imageData.get(position).icon + "/0.jpg";
        Glide.with(context)
                .load(img_url)
//                .placeholder(load_url)
                .listener(new RequestListener<Drawable>() {
                    @Override
                    public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                        holder.progressBar.setVisibility(View.GONE);
                        holder.icon.setVisibility(View.VISIBLE);
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                        holder.progressBar.setVisibility(View.GONE);
                        holder.icon.setVisibility(View.VISIBLE);
                        return false;
                    }
                })
                .error(R.drawable.ic_image_not_found)
                .into(holder.icon);

        holder.icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "Clicked=" + img_url, Toast.LENGTH_SHORT).show();
                Log.d("Img_Url", img_url);
            }
        });
    }

    @Override
    public int getItemCount() {
        return imageData.size();
    }

    public class SecondViewHolder extends RecyclerView.ViewHolder {

        ImageView icon;
        TextView title;
        ProgressBar progressBar;

        public SecondViewHolder(@NonNull View itemView) {
            super(itemView);
            icon = itemView.findViewById(R.id.icon);
            title = itemView.findViewById(R.id.title);
            progressBar = itemView.findViewById(R.id.progress);
        }
    }
}
