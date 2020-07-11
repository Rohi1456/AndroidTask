package in.rohitha.anivaletask.network;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Base64;


import org.json.JSONObject;

import java.io.UnsupportedEncodingException;

import in.rohitha.anivaletask.R;


public class Utils {


    private static final int NETWORK_ERROR_CODE = 5000;
    private static final int ERROR_CODE = 5001;

    /**
     * Check internet availability.
     *
     * @param context
     * @return
     */
    public static boolean checkInternetConnection(Context context) {
        ConnectivityManager connMgr = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connMgr.getActiveNetworkInfo();
        if (activeNetworkInfo != null) { // connected to the internet
            if (activeNetworkInfo.getType() == ConnectivityManager.TYPE_WIFI) {
                // connected to wifi
                return true;
            } else if (activeNetworkInfo.getType() == ConnectivityManager.TYPE_MOBILE) {
                // connected to the mobile provider's data plan
                return true;
            }
        }
        return false;
    }


    /**
     * get the error body for network error
     *
     * @param context
     * @return
     */
    public static String getNetworkErrorBody(Context context) {
        CommonResponse commonResponse = new CommonResponse();
        JSONObject jsonFormat = commonResponse.getJSONFormat(NETWORK_ERROR_CODE, "No Internet ");
        return jsonFormat.toString();

    }

    /**
     * Construct the error body
     *
     * @param message
     * @return
     */
    public static String constructJSONBody(String message) {
        CommonResponse commonResponse = new CommonResponse();
        JSONObject jsonFormat = commonResponse.getJSONFormat(ERROR_CODE, message);
        return jsonFormat.toString();

    }

    /**
     * Construct json body with eror code and message
     * @param message
     * @param error_code
     * @return
     */
    public static String constructJSONBody(String message, int error_code) {
        CommonResponse commonResponse = new CommonResponse();
        JSONObject jsonFormat = commonResponse.getJSONFormat(error_code, message);
        return jsonFormat.toString();

    }

    /**
     * Show dialog if there is no internet connection.
     *  @param dialogTitle
     * @param dialogMessage
     * @param isOutsideCancalabel
     * @param iDialogCallback
     */
    public static void showErrorDialog(final Context context, final String dialogTitle, final String dialogMessage, final boolean isOutsideCancalabel, final APIHandler iDialogCallback, final int requestCode) {
        if (context instanceof Activity) {
            ((Activity) context).runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    AlertDialog.Builder builder = new AlertDialog.Builder(context);
                    builder.setTitle(dialogTitle);
                    builder.setMessage(dialogMessage);

                    builder.setPositiveButton("Ok",
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    if (iDialogCallback != null) {
                                        iDialogCallback.onPositiveButtonPress(requestCode);
                                    }
                                    // positive button logic
                                    dialog.dismiss();

                                }
                            });

                    AlertDialog dialog = builder.create();
                    dialog.setCanceledOnTouchOutside(isOutsideCancalabel);
                    dialog.show();
                }
            });

        }
    }
}
