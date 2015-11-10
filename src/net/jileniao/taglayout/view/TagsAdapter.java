package net.jileniao.taglayout.view;

import java.util.ArrayList;
import java.util.List;

import net.jileniao.taglayout.R;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ToggleButton;

public class TagsAdapter extends BaseAdapter {

    private List<String> mList;
    private LayoutInflater mInflater;

    public TagsAdapter(Context context, List<String> list) {
        if (list == null) {
            mList = new ArrayList<String>();
        } else {
            mList = list;
        }
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public String getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final String text = getItem(position);
        ViewHolder holder;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.tags_item, null);
            holder = new ViewHolder();
            holder.tagBtn = (ToggleButton) convertView
                    .findViewById(R.id.tag_btn);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.tagBtn.setText(text);
        holder.tagBtn.setTextOff(text);
        holder.tagBtn.setTextOn(text);
        return holder.tagBtn;
    }

    static class ViewHolder {
        ToggleButton tagBtn;
    }
}
