package in.rohitha.anivaletask.network;


public interface APICallback {
     void onAPISuccessResponse(int requestId, String responseString);

     void onAPIFailureResponse(int requestId, String errorString);
}
