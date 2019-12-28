package com.haanhgs.recyclerglidedemo;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import java.util.List;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private final List<Sport>sports;

    public Adapter(List<Sport> sports) {
        this.sports = sports;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.recyclerview_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Sport sport = sports.get(position);
        Glide.with(App.context()).load(sport.getImageResource()).into(holder.ivRv);
        holder.tvRvTitle.setText(sport.getTitle());
        holder.tvRvInfo.setText(sport.getInfo());
    }

    @Override
    public int getItemCount() {
        return sports.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView ivRv;
        private TextView tvRvTitle;
        private TextView tvRvInfo;

        private void initViews(View itemView){
            ivRv = itemView.findViewById(R.id.ivRvMain);
            tvRvTitle = itemView.findViewById(R.id.tvRvTitle);
            tvRvInfo = itemView.findViewById(R.id.tvRvInfo);
        }

        private void openDetail(){
            Sport sport = sports.get(getAdapterPosition());
            Intent intent = new Intent(App.context(), DetailActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.putExtra("img", sport.getImageResource());
            intent.putExtra("title", sport.getTitle());
            intent.putExtra("info", sport.getInfo());
            App.context().startActivity(intent);
        }

        private void handleItemClicked(View view){
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    openDetail();
                }
            });
        }

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            initViews(itemView);
            handleItemClicked(itemView);
        }
    }
}
