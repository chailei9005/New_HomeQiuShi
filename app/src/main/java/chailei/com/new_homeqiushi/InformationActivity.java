package chailei.com.new_homeqiushi;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import chailei.com.new_homeqiushi.adapters.InfoCommentAdapter;
import chailei.com.new_homeqiushi.entity.Information;

public class InformationActivity extends AppCompatActivity {

//    private ListView infoListView;
    private ViewPager infoViewPager;
    private TabLayout infoTab;
    private InfoCommentAdapter adapter;
    private List<String> list;

    private TextView textViewName;
    private TextView textViewContent;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);

//        infoListView = (ListView) findViewById(R.id.info_list_view);
        infoViewPager = (ViewPager) findViewById(R.id.info_view_pager);
        infoTab = (TabLayout) findViewById(R.id.info_tab);
        textViewName = (TextView) findViewById(R.id.info_name);
        textViewContent = (TextView) findViewById(R.id.info_content);
        imageView = (ImageView) findViewById(R.id.info_icon);
        Intent intent = getIntent();
        Information info= (Information) intent.getSerializableExtra("info");
        Picasso.with(this)
                .load(getIconURL(info.getId_user(), info.getIcon()))
                .transform(new CircleTransformation())
                .into(imageView);
        textViewName.setText(info.getName());
        textViewContent.setText(info.getContent());
        list = new ArrayList<>();
        list.add("全部");
        list.add("热门");
        adapter = new InfoCommentAdapter(getSupportFragmentManager(),list,info);
        infoViewPager.setAdapter(adapter);
        infoTab.setupWithViewPager(infoViewPager);

    }
    public static String getIconURL(long id, String icon){
        String url = "http://pic.qiushibaike.com/system/avtnew/%s/%s/thumb/%s";
        return String.format(url, id / 10000, id, icon);

    }
}
