package com.torv.adam.utils.permission;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;

import com.torv.adam.utils.log.L;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by AdamLi on 2016/9/7.
 */
public class PermissionTool {

    private static Context mAppCtx;

    private static int REQUEST_CODE = 0x87;

    public static void setAppContext(Context context) {
        if(null == context){
            throw new NullPointerException("You should pass a valid context");
        }
        if(context instanceof Activity) {
            throw new UnsupportedOperationException("please set Application context here, to avoid memory leak!!");
        }
        mAppCtx = context;
    }

    public static boolean checkNeedRequestPermission(String[] permissions) {
        L.d("E");
        if (null == permissions) {
            return false;
        }

        if(null == mAppCtx) {
            throw new UnsupportedOperationException("please call setAppContext first");
        }

        for (String per : permissions) {
            if(!TextUtils.isEmpty(per) && ContextCompat.checkSelfPermission(mAppCtx, per) != PackageManager.PERMISSION_GRANTED) {
                return true;
            }
        }
        L.d("X");
        return false;
    }

    public static void checkNeedShowRationable(Activity activity, String[] permissions, IRationableResultCallback callback) {
        L.d("E");
        if(null != permissions) {
            List<String> needShowRationablePermissions = new ArrayList<>();
            List<String> needRequestPermissions = new ArrayList<>();

            for(String per : permissions) {
                if(!TextUtils.isEmpty(per) && ContextCompat.checkSelfPermission(mAppCtx, per) != PackageManager.PERMISSION_GRANTED) {
                    if(ActivityCompat.shouldShowRequestPermissionRationale(activity, per)) {
                        needShowRationablePermissions.add(per);
                    } else {
                        needRequestPermissions.add(per);
                    }
                }
            }

            if(null != callback) {
                callback.onNeedShowRationablePermissions(needShowRationablePermissions);
                callback.onNeedRequestPermissions(needRequestPermissions);
            }
        }
        L.d("X");
    }

    public static void requestPermission(Activity activity, String[] permissions){
        requestPermission(activity, permissions, REQUEST_CODE);
    }

    public static void requestPermission(Activity activity, String[] permissions, int requestCode){
        if(null == mAppCtx) {
            throw new UnsupportedOperationException("please call setAppContext first");
        }

        REQUEST_CODE = requestCode;
        if(null != permissions) {
            List<String> permissionNeedRequest = new ArrayList<>();
            for(String per : permissions) {
                if(!TextUtils.isEmpty(per) && ContextCompat.checkSelfPermission(mAppCtx, per) != PackageManager.PERMISSION_GRANTED) {
                    permissionNeedRequest.add(per);
                }
            }
            ActivityCompat.requestPermissions(activity, permissionNeedRequest.toArray(new String[permissionNeedRequest.size()]), REQUEST_CODE);
        }
    }

    public static void handleGrantResult(int requestCode, String[] permissions, int[] grantResults, IGrantResultCallback callback){
        if(requestCode == REQUEST_CODE) {
            if(null != permissions) {
                int size = permissions.length;
                List<String> grantedPermissions = new ArrayList<>();
                List<String> deniedPermissions = new ArrayList<>();
                for(int i = 0 ; i < size ; i++){
                    if(grantResults[i] == PackageManager.PERMISSION_GRANTED) {
                        grantedPermissions.add(permissions[i]);
                    } else {
                        deniedPermissions.add(permissions[i]);
                    }
                }

                if(null != callback) {
                    callback.onGrantedPermissions(grantedPermissions);
                    callback.onDeniedPermissions(deniedPermissions);
                }
            }
        }
    }

    public interface IGrantResultCallback{
        public void onGrantedPermissions(List<String> grantedPermissions);
        public void onDeniedPermissions(List<String> deniedPermissions);
    }

    public interface IRationableResultCallback{
        public void onNeedShowRationablePermissions(List<String> rationablePermisssions);
        public void onNeedRequestPermissions(List<String> needRequestPermisssions);
    }
}
