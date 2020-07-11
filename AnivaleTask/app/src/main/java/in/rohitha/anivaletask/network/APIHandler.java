package in.rohitha.anivaletask.network;

import android.app.ProgressDialog;
import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class APIHandler implements IDialogCallback {


    private Context context;
    private int requestId;
    private boolean showLoading = false;
    private String loadingText;
    private String url;
    private ProgressDialog pDialog = null;
    private APICallback apiCallback = null;
    private Map<String, String> headers = null;
    private Map<String, String> params = null;
    private boolean showToastOnResponse = true;
    private boolean isCanceledOnTouchOutside = false;
    Call<Object> call;

    public APIHandler(Context context, APICallback apiCallback, int requestId,
                      boolean showLoading, boolean isCanceledOnTouchOutside, String loadingText, Call<Object> call) {

        this.context = context;
        this.apiCallback = apiCallback;
        this.requestId = requestId;
        this.url = url;
        this.showLoading = showLoading;
        this.isCanceledOnTouchOutside = isCanceledOnTouchOutside;
        this.loadingText = loadingText;
        this.params = params;
        this.call = call;
    }

    /**
     * Show loading.
     */
    private void showLoading() {
        try {
            pDialog = new ProgressDialog(context);
            pDialog.setMessage(loadingText);
            pDialog.setCanceledOnTouchOutside(isCanceledOnTouchOutside);
            pDialog.show();
        } catch (Exception e) {
            Log.d("AlertDialog", "Progress dialog can not be shown. ;-(");
        }
    }

    /**
     * Hide loading.
     */
    private void hideLoading() {
        try {
            if (pDialog != null && pDialog.isShowing())
                pDialog.dismiss();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Request API to get response for respective request.
     */
    public void requestAPI() {
        //check if internet connect found or not
        try {
            if (!Utils.checkInternetConnection(context)) {
                String networkErrorBody = Utils.getNetworkErrorBody(context);
                apiCallback.onAPISuccessResponse(requestId, networkErrorBody);
                //  Util.getInstance().cusToast(context,networkErrorBody);
            } else {
               /* System.out.println("[API] request url = " + url);
                System.out.println("[API] request body = " + params);
                System.out.println("[API] request Auth_Token: = " + headers.get(NetworkConstants.Headers.X_AUTH_TOKEN));*/

                if (showLoading) {
                    showLoading();
                }
                //Send the request to get the response.
                retrofitServiceCall(call);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void retrofitServiceCall(final Call<Object> call) throws IOException {

        call.enqueue(new Callback<Object>() {
            @Override
            public void onResponse(Call<Object> call, Response<Object> response) {
                Log.e("TAG", "response 33: " + new Gson().toJson(response.body()));
                try {
                    if (pDialog != null && pDialog.isShowing())
                        pDialog.dismiss();
                    String serverResponse = new Gson().toJson(response.body());
                    if (serverResponse != null && serverResponse.length() > 0) {
                        handelResponse(requestId, serverResponse);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<Object> call, Throwable t) {
                Log.e("TAG", "onFailure: " + t.toString());
                // Log error here since request failed
                if (pDialog != null && pDialog.isShowing())
                    pDialog.dismiss();
            }
        });
        call.execute();


    }


    /**
     * Handel The API response
     *
     * @param requestId
     * @param response
     */
    private void handelResponse(int requestId, String response) {
        Gson gson = new Gson();
        CommonResponse commonResponse = gson.fromJson(response, CommonResponse.class);
        if (commonResponse != null) {
            String message = commonResponse.getMessage();
            int status_code = commonResponse.getStatus_code();

            switch (status_code) {
                case NetworkConstants.RequestCode.SESSION_EXPIRE:
                    Utils.showErrorDialog(context, "Ok", message,
                            true, this, NetworkConstants.RequestCode.SESSION_EXPIRE);
                    break;
                default:
                    try {
                        apiCallback.onAPISuccessResponse(requestId, response);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
            }
        }
    }


    @Override
    public void onPositiveButtonPress(int requestCode) {

        switch (requestCode) {
            case NetworkConstants.RequestCode.SESSION_EXPIRE:
                //TODO call logout logic
                break;
        }

    }

    @Override
    public void onNegativeButtonPress(int requestCode) {

    }
}
