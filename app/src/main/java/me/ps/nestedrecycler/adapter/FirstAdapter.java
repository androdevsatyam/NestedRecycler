package me.ps.nestedrecycler.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import me.ps.nestedrecycler.R;
import me.ps.nestedrecycler.model.FirstModel;

public class FirstAdapter extends RecyclerView.Adapter<FirstAdapter.FirstViewHolder> {

    Context context;
    List<FirstModel.Category> category;
    SecondAdapter secondAdapter;
    public FirstAdapter(Context context,FirstModel firstModel){
        this.context=context;
        category =firstModel.getCategories();
    }


    @NonNull
    @Override
    public FirstViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view=inflater.inflate(R.layout.first_list,parent,false);
        return new FirstViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FirstViewHolder holder, int position) {
        holder.title.setText(category.get(position).getTitle());
        secondAdapter=new SecondAdapter(context,category.get(position).getItems());
        holder.secondList.setAdapter(secondAdapter);
    }

    @Override
    public int getItemCount() {
        return category.size();
    }

    public class FirstViewHolder extends RecyclerView.ViewHolder{

        TextView title;
        RecyclerView secondList;
        public FirstViewHolder(@NonNull View itemView) {
            super(itemView);
            title=itemView.findViewById(R.id.title);
            secondList=itemView.findViewById(R.id.second_list);
            prepList();
        }

        private void prepList() {
            LinearLayoutManager linearLayoutManager=new LinearLayoutManager(context);
            linearLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
            secondList.setHasFixedSize(true);
            secondList.setLayoutManager(linearLayoutManager);
        }
    }
}
