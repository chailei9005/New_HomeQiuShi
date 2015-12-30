package chailei.com.new_homeqiushi;

import chailei.com.new_homeqiushi.entity.Item;
import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

/**
 * Created by Administrator on 15-12-29.
 */
public interface QsbkService {
    @GET("article/list/{type}")
    Call<Item> getList(@Path("type") String type, @Query("page") int page);
}
