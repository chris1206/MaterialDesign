package com.minicup.materialdesign.RecyclerView;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.TextView;

import com.minicup.materialdesign.R;

import java.util.ArrayList;
import java.util.List;

public class RecyclerviewHorizontalActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;

    private List<String> mData = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview_horizontal);

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        initData();

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        mRecyclerView.addItemDecoration(new LinearCustomItemDecoration(this, LinearLayoutManager.HORIZONTAL));

        mRecyclerView.setAdapter(new LocalAdapter());

    }

    private void initData() {
        for (int i = 'A'; i <= 'z'; i++) {
            mData.add(String.valueOf((char)i));
        }
    }

    private class LocalAdapter extends RecyclerView.Adapter<RecyclerviewHorizontalActivity.VH> {
        @Override
        public RecyclerviewHorizontalActivity.VH onCreateViewHolder(ViewGroup parent, int viewType) {
            TextView textView = new TextView(RecyclerviewHorizontalActivity.this);
            ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT);
            params.width = 200;
            textView.setLayoutParams(params);
            textView.setGravity(Gravity.CENTER);
            textView.setBackgroundColor(Color.parseColor("#f3aead"));
            return new RecyclerviewHorizontalActivity.VH(textView);
        }

        @Override
        public void onBindViewHolder(RecyclerviewHorizontalActivity.VH holder, int position) {
            holder.textView.setText(mData.get(position));
        }



        @Override
        public int getItemCount() {
            return mData.size();
        }
    }

    private class VH extends RecyclerView.ViewHolder {
        public TextView textView;

        public VH(TextView textView) {
            super(textView);
            this.textView = textView;
        }
    }
}
