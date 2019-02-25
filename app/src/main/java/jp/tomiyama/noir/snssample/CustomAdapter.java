package jp.tomiyama.noir.snssample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CustomAdapter extends ArrayAdapter<Item> {

    private List<Item> items;

    private OnLikeClickListener likeClickListener = null;

    public CustomAdapter(Context context, int resource, List<Item> items) {
        super(context, resource, items);

        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Item getItem(int position) {
        return items.get(position);
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final ViewHolder viewHolder;

        if (convertView != null) {
            viewHolder = (ViewHolder) convertView.getTag();
        } else {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item_cell, parent, false);
            viewHolder = new ViewHolder();

            viewHolder.titleText = convertView.findViewById(R.id.title_text);
            viewHolder.contentText = convertView.findViewById(R.id.content_text);
            viewHolder.likeImage = convertView.findViewById(R.id.like_image);
            viewHolder.likeCountText = convertView.findViewById(R.id.like_count_text);

            convertView.setTag(viewHolder);
        }

        Item item = items.get(position);

        viewHolder.titleText.setText(item.getTitle());
        viewHolder.contentText.setText(item.getContent());
        viewHolder.likeCountText.setText(String.valueOf(item.getLikeCount()));
        viewHolder.likeImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (likeClickListener != null) {
                    likeClickListener.onLikeClick(position);
                }
            }
        });

        return convertView;
    }

    public Item getItemByKey(String key) {
        for (Item item : items) {
            if (item.getKey().equals(key)) {
                return item;
            }
        }

        return null;
    }

    public void setOnLikeClickListener(OnLikeClickListener likeClickListener) {
        this.likeClickListener = likeClickListener;
    }

    static class ViewHolder {
        TextView titleText;
        TextView contentText;
        ImageView likeImage;
        TextView likeCountText;
    }

    interface OnLikeClickListener {
        void onLikeClick(int position);
    }
}
