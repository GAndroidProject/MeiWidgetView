//package com.demo.widget.meis;
//
//import android.os.Bundle;
//import android.support.annotation.Nullable;
//import android.support.v4.app.Fragment;
//import android.support.v7.widget.LinearLayoutManager;
//import android.support.v7.widget.RecyclerView;
//import android.support.v7.widget.Toolbar;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.Toast;
//
//import com.chad.library.adapter.base.BaseQuickAdapter;
//import com.chad.library.adapter.base.BaseViewHolder;
//import com.demo.widget.R;
//import com.meis.widget.horizontal.HorizontalScrollView;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * Created by wenshi on 2018/12/13.
// * Description
// */
//public class MeiScrollViewFragment1 extends Fragment {
//
//    private Toolbar mToolbar;
//    private HorizontalScrollView mScrollView;
//    private RecyclerView mRecyclerView;
//    private CardAdapter mAdapter;
//
//    @Nullable
//    @Override
//    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//              super.onCreateView(inflater,container,savedInstanceState);
//
//            setContentView(R.layout.mei_scroll_view_activity);
//
//            mToolbar = findViewById(R.id.toolbar);
//            mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    finish();
//                }
//            });
//
//            mScrollView = findViewById(R.id.scroll_view);
//            mRecyclerView = findViewById(R.id.recycler);
//
//            mRecyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));
//            List<String> list = new ArrayList<>();
//            for (int i = 0; i < 6; i++) {
//                list.add("");
//            }
//            mRecyclerView.setAdapter(mAdapter = new CardAdapter(list));
//
//            mScrollView.setOnReleaseListener(new HorizontalScrollView.OnReleaseListener() {
//                @Override
//                public void onRelease() {
//                    Toast.makeText(MeiScrollViewFragment1.this, "触发了查看更多回调接口", Toast.LENGTH_SHORT).show();
//                }
//            });
//
//
//        }
//    }
//
//    class CardAdapter extends BaseQuickAdapter<String, BaseViewHolder> {
//
//        public CardAdapter(@Nullable List<String> data) {
//            super(R.layout.mei_item_card, data);
//        }
//
//        @Override
//        protected void convert(BaseViewHolder helper, String item) {
//
//        }
//    }
//}
