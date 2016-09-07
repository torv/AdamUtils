package com.torv.adam.utils.log;

public class L {

    private static boolean isDebug = false;
    private static String DEFAULT_TAG = "Adam";

    public static void setIsDebug(boolean debug){
        isDebug = debug;
    }

    public static boolean getIsDebug(){
        return  isDebug;
    }

    public static void setDefaultTag(String tag){
        if(null == tag) {
            return;
        }
        DEFAULT_TAG = tag;
    }

    public static void i(String tag,String message){
        if(isDebug){
            StackTraceElement stack[] = Thread.currentThread().getStackTrace();
            message = stack[3].getClassName()+"."+stack[3].getMethodName() +"()<"+stack[3].getLineNumber() + "> : "+ message;

            android.util.Log.i(tag, message);
        }
    }

    public static void v(String tag,String message){
        if(isDebug){
            StackTraceElement stack[] = Thread.currentThread().getStackTrace();
            message = stack[3].getClassName()+"."+stack[3].getMethodName() +"()<"+stack[3].getLineNumber() + "> : "+ message;

            android.util.Log.v(tag, message);
        }
    }

    public static void d(String tag,String message){
        if(isDebug){
            StackTraceElement stack[] = Thread.currentThread().getStackTrace();
            message = stack[3].getClassName()+"."+stack[3].getMethodName() +"()<"+stack[3].getLineNumber() + "> : "+ message;

            android.util.Log.d(tag, message);
        }
    }

    public static void w(String tag,String message){
        if(isDebug){
            StackTraceElement stack[] = Thread.currentThread().getStackTrace();
            message = stack[3].getClassName()+"."+stack[3].getMethodName() +"()<"+stack[3].getLineNumber() + "> : "+ message;

            android.util.Log.w(tag, message);
        }
    }

    public static void e(String tag,String message){
        if(isDebug){
            StackTraceElement stack[] = Thread.currentThread().getStackTrace();
            message = stack[3].getClassName()+"."+stack[3].getMethodName() +"()<"+stack[3].getLineNumber() + "> : "+ message;

            android.util.Log.e(tag, message);
        }
    }

    public static void i(String message){
        if(isDebug){
            StackTraceElement stack[] = Thread.currentThread().getStackTrace();
            message = stack[3].getClassName()+"."+stack[3].getMethodName() +"()<"+stack[3].getLineNumber() + "> : "+ message;

            android.util.Log.i(DEFAULT_TAG, message);
        }
    }

    public static void v(String message){
        if(isDebug){
            StackTraceElement stack[] = Thread.currentThread().getStackTrace();
            message = stack[3].getClassName()+"."+stack[3].getMethodName() +"()<"+stack[3].getLineNumber() + "> : "+ message;

            android.util.Log.v(DEFAULT_TAG, message);
        }
    }

    public static void d(String message){
        if(isDebug){
            StackTraceElement stack[] = Thread.currentThread().getStackTrace();
            message = stack[3].getClassName()+"."+stack[3].getMethodName() +"()<"+stack[3].getLineNumber() + "> : "+ message;

            android.util.Log.d(DEFAULT_TAG, message);
        }
    }

    public static void w(String message){
        if(isDebug){
            StackTraceElement stack[] = Thread.currentThread().getStackTrace();
            message = stack[3].getClassName()+"."+stack[3].getMethodName() +"()<"+stack[3].getLineNumber() + "> : "+ message;

            android.util.Log.w(DEFAULT_TAG, message);
        }
    }

    public static void e(String message){
        if(isDebug){
            StackTraceElement stack[] = Thread.currentThread().getStackTrace();
            message = stack[3].getClassName()+"."+stack[3].getMethodName() +"()<"+stack[3].getLineNumber() + "> : "+ message;

            android.util.Log.e(DEFAULT_TAG, message);
        }
    }
}
