package chailei.com.new_homeqiushi.customview;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ListView;

/**
 * Created by Administrator on 15-12-30.
 */
public class MyListView extends ListView {
    public MyListView(Context context) {
        super(context);
    }

    public MyListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int height =MeasureSpec.makeMeasureSpec(
                Integer.MAX_VALUE>>2,
                MeasureSpec.AT_MOST
        );
        Log.d("listview","height"+height);
        super.onMeasure(widthMeasureSpec,height);
//        setMeasuredDimension(widthMeasureSpec, height);
    }
}
