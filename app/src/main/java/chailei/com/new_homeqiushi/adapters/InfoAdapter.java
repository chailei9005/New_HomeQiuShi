package chailei.com.new_homeqiushi.adapters;

import android.content.Context;
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
import chailei.com.new_homeqiushi.entity.Comment;

/**
 * Created by Administrator on 15-12-30.
 */
public class InfoAdapter  extends BaseAdapter{
    private static final String TAG = "InfoAdapter";
    private Context context;
    private List<Comment.ItemsEntity> list;

    public InfoAdapter(Context context) {
        this.context = context;
        list = new ArrayList<Comment.ItemsEntity>();
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
            convertView = LayoutInflater.from(context).inflate(R.layout.comment_item,parent,false);
            convertView.setTag(new ViewHolder(convertView));
        }
        Comment.ItemsEntity item = list.get(position);
        ViewHolder holder = (ViewHolder) convertView.getTag();
        if(item.getUser() !=null){
            holder.name.setText(item.getUser().getLogin());
            Picasso.with(context)
                    .load(getIconURL(item.getUser().getId(),item.getUser().getIcon()))
                    .transform(new CircleTransformation())
                    .into(holder.icon);

        }else{
            holder.name.setText("匿名用户");
            holder.icon.setImageResource(R.mipmap.ic_launcher);
            holder.content.setText("无内容");
        }
        holder.content.setText(item.getContent());
        return convertView;
    }
    public void addAll(Collection<? extends Comment.ItemsEntity> collection){
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


    public class ViewHolder{

        private final ImageView icon;
        private final TextView name;
        private final TextView index;
        private final TextView content;
        private final TextView time;
        private final TextView zan;

        public ViewHolder(View view){

            icon = (ImageView) view.findViewById(R.id.info_item_icon);
            name = (TextView) view.findViewById(R.id.info_item_name);
            index = (TextView) view.findViewById(R.id.info_item_index);
            content = (TextView) view.findViewById(R.id.info_item_content);
            time = (TextView) view.findViewById(R.id.info_item_time);
            zan = (TextView) view.findViewById(R.id.info_item_zan);
        }
    }
}
