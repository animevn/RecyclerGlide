package com.haanhgs.recyclerglidedemo.view;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.haanhgs.recyclerglidedemo.R;
import com.haanhgs.recyclerglidedemo.adapter.Adapter;
import com.haanhgs.recyclerglidedemo.model.Repo;
import com.haanhgs.recyclerglidedemo.model.Sport;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.tbrMain)
    Toolbar tbrMain;
    @BindView(R.id.rvContent)
    RecyclerView rvContent;
    @BindView(R.id.fbnMain)
    FloatingActionButton fbnMain;

    private Adapter adapter;
    private List<Sport> sportList;

    private void setToolBar(){
        setSupportActionBar(tbrMain);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) actionBar.setTitle("Hohohohoho");
    }

    private void initRecyclerView() {
        rvContent.setLayoutManager(new GridLayoutManager(this, 2));
        rvContent.setItemAnimator(new DefaultItemAnimator());
        sportList = new ArrayList<>();
        adapter = new Adapter(sportList);
        rvContent.setAdapter(adapter);
    }

    private void initSportList() {
        sportList.clear();
        sportList.addAll(Repo.getList(this));
        adapter.notifyDataSetChanged();
    }

    private void moveItem(RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
        int from = viewHolder.getAdapterPosition();
        int to = target.getAdapterPosition();
        Collections.swap(sportList, from, to);
        adapter.notifyItemMoved(from, to);
    }

    private void deleteItem(RecyclerView.ViewHolder viewHolder) {
        sportList.remove(viewHolder.getAdapterPosition());
        adapter.notifyItemRemoved(viewHolder.getAdapterPosition());
    }

    private void setupSwipe() {
        ItemTouchHelper helper = new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(
                ItemTouchHelper.UP | ItemTouchHelper.DOWN | ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT,
                ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView,
                                  @NonNull RecyclerView.ViewHolder viewHolder,
                                  @NonNull RecyclerView.ViewHolder target) {
                moveItem(viewHolder, target);
                return true;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                deleteItem(viewHolder);
            }
        });
        helper.attachToRecyclerView(rvContent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setToolBar();
        initRecyclerView();
        initSportList();
        setupSwipe();
    }


    @OnClick(R.id.fbnMain)
    public void onViewClicked() {
        initSportList();
    }
}
