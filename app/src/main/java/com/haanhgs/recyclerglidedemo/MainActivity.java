package com.haanhgs.recyclerglidedemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Adapter adapter;
    private RecyclerView rvMain;
    private List<Sport> sportList;



    private void initViews(){
        sportList = new ArrayList<>();
        adapter = new Adapter(sportList);
        rvMain = findViewById(R.id.rvContent);
        rvMain.setLayoutManager(new GridLayoutManager(this, 2));
        rvMain.setItemAnimator(new DefaultItemAnimator());
        rvMain.setAdapter(adapter);
    }

    private void initSportList(){
        sportList.clear();
        sportList.addAll(Sport.createList());
        adapter.notifyDataSetChanged();
    }

    private void handleFloatingButton(){
        FloatingActionButton fbnMain = findViewById(R.id.fbnMain);
        fbnMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               initSportList();
            }
        });
    }

    private void enableSwipe(){
        ItemTouchHelper helper = new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(
            ItemTouchHelper.UP|ItemTouchHelper.DOWN|ItemTouchHelper.LEFT|ItemTouchHelper.RIGHT,
                ItemTouchHelper.LEFT|ItemTouchHelper.RIGHT
        ) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView,
                                  @NonNull RecyclerView.ViewHolder viewHolder,
                                  @NonNull RecyclerView.ViewHolder target) {
                int from = viewHolder.getAdapterPosition();
                int to = target.getAdapterPosition();
                Collections.swap(sportList, from, to);
                adapter.notifyItemMoved(from, to);
                return true;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                sportList.remove(viewHolder.getAdapterPosition());
                adapter.notifyItemRemoved(viewHolder.getAdapterPosition());
            }
        });
        helper.attachToRecyclerView(rvMain);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar tbrMain = findViewById(R.id.tbrMain);
        setSupportActionBar(tbrMain);

        initViews();
        initSportList();
        handleFloatingButton();
        enableSwipe();
    }
}
