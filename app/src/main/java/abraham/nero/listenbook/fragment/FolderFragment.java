package abraham.nero.listenbook.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import abraham.nero.listenbook.R;
import abraham.nero.listenbook.adapter.MusicAdapter;
import abraham.nero.listenbook.entity.MusicEntity;

/**
 * Created by Abraham on 2017/12/26.
 */

public class FolderFragment extends Fragment implements View.OnClickListener{

    private RecyclerView mRecyclerView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_folder, container, false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.folder_recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mRecyclerView.getContext()));
        mRecyclerView.addItemDecoration(new DividerItemDecoration(mRecyclerView.getContext(), DividerItemDecoration.VERTICAL));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

        List<MusicEntity> list = new ArrayList<>();
        MusicEntity entity = new MusicEntity();
        entity.setTitle("鬼吹灯第一卷:精绝古城");
        entity.setType(MusicEntity.MusicType.FOLDER);
        list.add(entity);
        entity = new MusicEntity();
        entity.setTitle("鬼吹灯第二卷:云南虫谷");
        entity.setType(MusicEntity.MusicType.FOLDER);
        list.add(entity);
        entity = new MusicEntity();
        entity.setTitle("鬼吹灯第六卷:南海归墟");
        entity.setType(MusicEntity.MusicType.FOLDER);
        list.add(entity);
        MusicAdapter adapter = new MusicAdapter(list, this);
        mRecyclerView.setAdapter(adapter);

        return view;
    }

    @Override
    public void onClick(View v) {

    }
}
