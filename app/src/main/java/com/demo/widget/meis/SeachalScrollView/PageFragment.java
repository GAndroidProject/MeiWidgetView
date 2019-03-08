package com.demo.widget.meis.SeachalScrollView;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.demo.widget.R;
import com.meis.widget.horizontal.HorizontalScrollView;

import java.util.ArrayList;
import java.util.List;

public class PageFragment extends Fragment {
    @LayoutRes
    int sampleLayoutRes;
    @LayoutRes
    int practiceLayoutRes;


    private Toolbar mToolbar;
    private HorizontalScrollView mScrollView;
    private RecyclerView mRecyclerView;
    private CardAdapter mAdapter;


    public static PageFragment newInstance(@LayoutRes int sampleLayoutRes, @LayoutRes int practiceLayoutRes) {
        PageFragment fragment = new PageFragment();
        Bundle args = new Bundle();
        args.putInt("sampleLayoutRes", sampleLayoutRes);
        args.putInt("practiceLayoutRes", practiceLayoutRes);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.seachal_fragment_page, container, false);

        ViewStub sampleStub = (ViewStub) view.findViewById(R.id.sampleStub);
        sampleStub.setLayoutResource(sampleLayoutRes);
        sampleStub.inflate();

        ViewStub practiceStub = (ViewStub) view.findViewById(R.id.practiceStub);
        practiceStub.setLayoutResource(practiceLayoutRes);
        practiceStub.inflate();





        mScrollView = view.findViewById(R.id.scroll_view);
        mRecyclerView = view.findViewById(R.id.recycler);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false));
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            list.add("");
        }
        mRecyclerView.setAdapter(mAdapter = new CardAdapter(list));

        mScrollView.setOnReleaseListener(new HorizontalScrollView.OnReleaseListener() {
            @Override
            public void onRelease() {
                Toast.makeText(getContext(), "触发了查看更多回调接口", Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle args = getArguments();
        if (args != null) {
            sampleLayoutRes = args.getInt("sampleLayoutRes");
            practiceLayoutRes = args.getInt("practiceLayoutRes");
        }
    }

    class CardAdapter extends BaseQuickAdapter<String, BaseViewHolder> {

        public CardAdapter(@Nullable List<String> data) {
            super(R.layout.mei_item_card, data);
        }

        @Override
        protected void convert(BaseViewHolder helper, String item) {

        }
    }
}
