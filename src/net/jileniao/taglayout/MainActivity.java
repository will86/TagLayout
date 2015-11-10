package net.jileniao.taglayout;

import java.util.ArrayList;
import java.util.List;

import net.jileniao.taglayout.view.TagLayout.TagItemClickListener;
import net.jileniao.taglayout.view.TagsAdapter;
import net.jileniao.taglayout.view.TagLayout;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {

    private TagLayout newLayout;
    private List<String> newList;
    private TagsAdapter newAdapter;

    private List<String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TagLayout layout = (TagLayout) findViewById(R.id.tags);
        layout.setItemClickListener(new TagItemClickListener() {

            @Override
            public void itemClick(int position) {
                if (newAdapter.getCount() >= 3) {
                    Toast.makeText(MainActivity.this, "Max 3!!!",
                            Toast.LENGTH_LONG).show();
                    return;
                }
                newList.add(list.get(position));
                newAdapter.notifyDataSetChanged();
            }
        });
        list = new ArrayList<String>();
        list.add("萌大叔");
        list.add("赛亚人");
        list.add("一杯红酒一支烟");
        list.add("呆呆");
        list.add("文艺范十足");
        list.add("搞怪");
        list.add("技术偏执狂");
        list.add("宅");
        list.add("有钱任性");
        TagsAdapter adapter = new TagsAdapter(this, list);
        layout.setAdapter(adapter);

        newLayout = (TagLayout) findViewById(R.id.tags_new);
        newLayout.setVisibility(View.GONE);
        newLayout.setItemClickListener(new TagItemClickListener() {

            @Override
            public void itemClick(int position) {
                newList.remove(position);
                newAdapter.notifyDataSetChanged();
            }
        });
        newList = new ArrayList<String>();
        newAdapter = new TagsAdapter(this, newList);
        newLayout.setAdapter(newAdapter);
    }
}
