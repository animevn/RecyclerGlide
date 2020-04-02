package com.haanhgs.recyclerglide.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.haanhgs.recyclerglide.R;
import com.haanhgs.recyclerglide.model.Sport;
import com.haanhgs.recyclerglide.view.DetailActivity;
import java.util.List;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private List<Sport> sports;

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
        holder.bindView(sports.get(position));
    }

    @Override
    public int getItemCount() {
        return sports.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.ivRvMain)
        ImageView ivRvMain;
        @BindView(R.id.tvRvTitle)
        TextView tvRvTitle;
        @BindView(R.id.tvRvInfo)
        TextView tvRvInfo;

        private void openDetail(){
            Sport sport = sports.get(getAdapterPosition());
            Intent intent = new Intent(itemView.getContext(), DetailActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.putExtra("img", sport.getImgResource());
            intent.putExtra("title", sport.getTitle());
            intent.putExtra("info", sport.getInfo());
            itemView.getContext().startActivity(intent);
        }

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(v -> openDetail());
        }

        private void bindView(Sport sport){
            Glide.with(itemView.getContext()).load(sport.getImgResource()).into(ivRvMain);
            tvRvTitle.setText(sport.getTitle());
            tvRvInfo.setText(sport.getInfo());
        }
    }
}
