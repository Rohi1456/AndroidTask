package in.rohitha.anivaletask.network;

import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.util.Map;

import in.rohitha.anivaletask.R;
import retrofit2.Call;

public class UserApiCallModel extends BaseApiModel {
    Context context;
    APIResponseCallback apiResponseCallback;
    APIInterface apiInterface;
    APIHandler apiHandler;

    public UserApiCallModel(Context context, APIResponseCallback apiResponseCallback) {
        super(context);
        this.apiResponseCallback = apiResponseCallback;
        this.context = context;
        apiInterface = APIClient.getClient().create(APIInterface.class);
    }


    public void notifications(int requestId, Map params, String key, int page) {

        try
        {
            Gson gsone = new Gson();
            JsonObject res = gsone.toJsonTree(params).getAsJsonObject();
            Call<Object> call = apiInterface.getImages(key,page,50);
            commoncall(requestId, call);
        }catch (Exception e)
        {
            Log.e("networkerror: ",e.toString());
        }


    }

    public void commoncall(int requestId, Call<Object> call) {
        apiHandler = new APIHandler(context, this, requestId,
                false, false,
                "Please Wait", call);
        apiHandler.requestAPI();
    }

    @Override
    public void onAPISuccessResponse(int requestId, String responseString) {
        super.onAPISuccessResponse(requestId, responseString);
        apiResponseCallback.onSuccessResponse(requestId, responseString, "");
    }

    @Override
    public void onAPIFailureResponse(int requestId, String errorString) {
        super.onAPIFailureResponse(requestId, errorString);
        apiResponseCallback.onSuccessResponse(requestId, errorString, "");
    }

}
