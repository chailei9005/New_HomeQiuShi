package chailei.com.new_homeqiushi.adapters;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import chailei.com.new_homeqiushi.CircleTransformation;
import chailei.com.new_homeqiushi.R;
import chailei.com.new_homeqiushi.entity.Item;

/**
 * Created by Administrator on 15-12-29.
 */
public class ItemAdapter extends BaseAdapter{
    private static final String TAG = "ItemAdapter";
    private Context context;
    private List<Item.ItemsEntity> list;

    public ItemAdapter(Context context) {
        this.context = context;
        list = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item,parent,false);
            convertView.setTag(new ViewHolder(convertView));
        }
        Item.ItemsEntity item = list.get(position);
        ViewHolder holder = (ViewHolder) convertView.getTag();
        if(item.getUser() !=null){
            holder.user_name.setText(item.getUser().getLogin());
            Picasso.with(context)
                    .load(getIconURL(item.getUser().getId(),item.getUser().getIcon()))
                    .transform(new CircleTransformation())
                    .into(holder.icon);

        }else{
            holder.user_name.setText("匿名用户");
            holder.icon.setImageResource(R.mipmap.ic_launcher);
            holder.content.setText("无内容");
        }
        holder.content.setText(item.getContent());

        return convertView;
    }
    public void addAll(Collection<? extends Item.ItemsEntity> collection){
        list.addAll(collection);
        notifyDataSetChanged();
    }
    public static String getImageURL(String image){
        String url = "http://pic.qiushibaike.com/system/pictures/%s/%s/%s/%s";
        Pattern pattern = Pattern.compile("(\\d+)\\d{4}");
        Matcher matcher = pattern.matcher(image);
        matcher.find();
        Log.d(TAG, "getImageURL: " + matcher.group());
        return String.format(url, matcher.group(1), matcher.group(), "medium", image);
    }
    public static String getIconURL(long id, String icon){
        String url = "http://pic.qiushibaike.com/system/avtnew/%s/%s/thumb/%s";
        return String.format(url, id / 10000, id, icon);

    }
    public static class ViewHolder{

        private final ImageView icon;
        private final TextView user_name;
        private final TextView content;

        public ViewHolder(View view){
            icon = (ImageView) view.findViewById(R.id.item_icon);
            user_name = (TextView) view.findViewById(R.id.item_name);
            content = (TextView) view.findViewById(R.id.item_content);
        }
    }
}
