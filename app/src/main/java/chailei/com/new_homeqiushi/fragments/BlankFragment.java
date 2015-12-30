package chailei.com.new_homeqiushi.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import chailei.com.new_homeqiushi.QsbkService;

import android.widget.Toast;

import chailei.com.new_homeqiushi.entity.Item;
import retrofit.Call;
import retrofit.Callback;

import chailei.com.new_homeqiushi.R;
import chailei.com.new_homeqiushi.adapters.ItemAdapter;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;


/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment extends Fragment implements Callback<Item> {

    private static final String TAG = "BlankFragment";
    private static final String TEXT = "text";
    private ItemAdapter adapter;
    private Call<chailei.com.new_homeqiushi.entity.Item> call;
    public BlankFragment() {
        // Required empty public constructor
    }

    public static BlankFragment newInstance(String str) {

        Bundle args = new Bundle();

        BlankFragment fragment = new BlankFragment();
        args.putString(TEXT,str);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_blank, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        adapter = new ItemAdapter(getContext());
        ListView listView = (ListView) view.findViewById(R.id.list_view_item);
        listView.setAdapter(adapter);

        Retrofit build = new Retrofit.Builder().baseUrl("http://m2.qiushibaike.com")
                .addConverterFactory(GsonConverterFactory.create()).build();

        QsbkService service = build.create(QsbkService.class);
        call = service.getList("text", 1);
        call.enqueue(this);

    }

    @Override
    public void onResponse(Response<Item> response, Retrofit retrofit) {
        adapter.addAll(response.body().getItems());
    }

    @Override
    public void onFailure(Throwable t) {
        Toast.makeText(getContext(), "网络错误", Toast.LENGTH_SHORT).show();
    }
}
