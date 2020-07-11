package in.rohitha.anivaletask.network;


import androidx.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import static in.rohitha.anivaletask.network.NetworkConstants.RequestCode.SESSION_EXPIRE;



public interface NetworkConstants {
    static int PAGE = 0;
    String LIMIT = "&limit=";


    /**
     * This is the network request to all apis.
     */
    interface URL {

        String BASE_URL = "https://pixabay.com/";

        String LOGIN = BASE_URL + "deliveryboy_login";
        String GETIMAGES = "api/";


    }

    /**
     * Application Controller events ids
     * Maintain all app level event ids and def of that event ids
     */
    @Retention(RetentionPolicy.CLASS)
    @IntDef(value = {

             RequestCode.NOTIFICATIONS,SESSION_EXPIRE
    })
    @interface RequestCode {
        int SESSION_EXPIRE = 1017;
        int NOTIFICATIONS = 121;

    }

}