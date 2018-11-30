package com.mine.zhuo.learnandroid;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator
 * @date 2018/11/27
 * 滑动冲突Activity
 */

public class ScrollerActivity extends Activity {
    private HorizontalScrollViewEx horizontalScrollViewEx;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aty_scroller);

        horizontalScrollViewEx = findViewById(R.id.recycler_root);
        List<String> dataList = new ArrayList<>();


        for (int i = 0; i < 10; i++) {
            dataList.add("哦你五千");

        }
for (int i=0;i<5;i++) {
    RecyclerView recyclerView = (RecyclerView) LayoutInflater.from(getApplicationContext())
            .inflate(R.layout.content_recycler, null);
    recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
    recyclerView.addItemDecoration(new RecyclerViewDivider(
            getApplicationContext(), LinearLayoutManager.HORIZONTAL));

    recyclerView.setAdapter(new ScrollerAdapter(dataList));

    horizontalScrollViewEx.addView(recyclerView);
}
//        horizontalScrollViewEx.addView(recyclerView);
//        horizontalScrollViewEx.addView(recyclerView);


    }
}
