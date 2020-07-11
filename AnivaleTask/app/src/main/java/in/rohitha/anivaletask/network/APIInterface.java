package in.rohitha.anivaletask.network;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIInterface {


    @GET(NetworkConstants.URL.GETIMAGES)
    Call<Object> getImages(@Query(value = "key", encoded = true) String key, @Query(value = "page", encoded = true) int page, @Query(value = "per_page") int count);

}
