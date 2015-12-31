package chailei.com.new_homeqiushi.fragments;

import chailei.com.new_homeqiushi.entity.Comment;
import chailei.com.new_homeqiushi.entity.Item;
import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

/**
 * Created by Administrator on 15-12-30.
 */
public interface CommentService {
        @GET("article/{type}/comments")
        Call<Comment> getList(@Path("type") int type, @Query("page") int page);
}