package abraham.nero.listenbook.adapter;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import abraham.nero.listenbook.R;
import abraham.nero.listenbook.entity.MusicEntity;

/**
 * Created by Abraham_Nero on 2017/12/26.
 */

public class MusicAdapter extends RecyclerView.Adapter<MusicAdapter.MusicHolder> {

    private View.OnClickListener mListener;
    private List<MusicEntity> mList;

    public MusicAdapter(@Nullable List<MusicEntity> list, @NonNull View.OnClickListener listener){
        mList = list;
        mListener = listener;
    }

    public void setDataSet(List<MusicEntity> list) {
        mList = list;
    }

    public List<MusicEntity> getDataSet() {
        return mList;
    }

    @Override
    public MusicHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MusicHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_music, parent, false));
    }

    @Override
    public void onBindViewHolder(MusicHolder holder, int position) {
        MusicEntity entity = mList.get(position);
        holder.rootView.setTag(entity);
        holder.titleTextView.setText(entity.getTitle());
        if (MusicEntity.MusicType.FOLDER.equals(entity.getType())) {
            holder.moreImageView.setImageResource(R.drawable.ic_folder_more);
        } else {
            holder.moreImageView.setImageResource(R.drawable.ic_file_more);
        }
    }

    @Override
    public int getItemCount() {
        return null == mList ? 0 : mList.size();
    }

    class MusicHolder extends RecyclerView.ViewHolder {
        View rootView;
        TextView titleTextView;
        ImageView moreImageView;

        MusicHolder(View itemView) {
            super(itemView);
            rootView = itemView;
            rootView.setOnClickListener(mListener);
            titleTextView = (TextView) itemView.findViewById(R.id.item_text_title);
            moreImageView = (ImageView) itemView.findViewById(R.id.item_image_more);
        }
    }
}
