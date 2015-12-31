package chailei.com.new_homeqiushi.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import chailei.com.new_homeqiushi.QsbkService;
import chailei.com.new_homeqiushi.R;
import chailei.com.new_homeqiushi.adapters.InfoAdapter;
import chailei.com.new_homeqiushi.entity.Comment;

import chailei.com.new_homeqiushi.entity.Information;
import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * A simple {@link Fragment} subclass.
 */
public class InfoFragment extends Fragment implements Callback<Comment> {


    private static final String TITLE = "title";
    private InfoAdapter adapter;
    private Call<Comment> call;
    private static int id;
    public InfoFragment() {
        // Required empty public constructor
    }

    public static InfoFragment newInstance(String str,Information info) {

        Bundle args = new Bundle();
        id = info.getId();
        InfoFragment fragment = new InfoFragment();
        args.putString(TITLE,str);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_info, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ListView infoListView  = (ListView) view.findViewById(R.id.info_list_view);
        adapter = new InfoAdapter(getContext());
        infoListView.setAdapter(adapter);
        Retrofit build = new Retrofit.Builder().baseUrl("http://m2.qiushibaike.com")
                .addConverterFactory(GsonConverterFactory.create()).build();

        CommentService service = build.create(CommentService.class);
        call = service.getList(id, 1);
        call.enqueue(this);

    }

    @Override
    public void onResponse(Response<Comment> response, Retrofit retrofit) {
        adapter.addAll(response.body().getItems());
    }

    @Override
    public void onFailure(Throwable t) {
        Toast.makeText(getContext(),"网络失败",Toast.LENGTH_SHORT).show();
    }
}
