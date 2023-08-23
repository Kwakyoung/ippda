import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

    public interface RetrofitApi {
    @GET("posts")
    Call<List<POST>> getData(@Query("userid") String id);

    }

