package eu.carryT.rider.FCM;

/**
 * Created by jayakumar on 16/02/17.
 */


import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;
import eu.carryT.rider.Helper.SharedHelper;

public class MyFirebaseInstanceIDService extends FirebaseInstanceIdService {
    private static final String TAG = MyFirebaseInstanceIDService.class.getSimpleName();

    @Override
    public void onTokenRefresh() {
        super.onTokenRefresh();
        String refreshedToken = FirebaseInstanceId.getInstance().getToken();
        SharedHelper.putKey(getApplicationContext(),"device_token",""+refreshedToken);
        Log.e(TAG,""+refreshedToken);
    }
}