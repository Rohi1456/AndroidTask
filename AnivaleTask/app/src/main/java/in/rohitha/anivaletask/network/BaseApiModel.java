package in.rohitha.anivaletask.network;

import android.content.Context;

import java.util.ArrayList;
import java.util.prefs.Preferences;

public abstract class BaseApiModel implements APICallback {

    protected Context context;
    protected APIResponseCallback apiResponseCallback;
    protected APIHandler apiHandler;
    protected Preferences preferences;

    private ArrayList<APIHandler> requestsQueue;


    public BaseApiModel(Context context) {

        requestsQueue = new ArrayList<>();
    }




    @Override
    public void onAPISuccessResponse(int requestId, String responseString) {

    }

    @Override
    public void onAPIFailureResponse(int requestId, String errorString) {

    }
}
