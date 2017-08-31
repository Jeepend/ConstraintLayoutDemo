package com.example.jipengfei.myapplication;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.util.Log;

/**
 * Created by Jeepend on 27/4/2017.
 */

public class TypefaceLoader {
    private static final String TAG = "TypefaceLoader";
    private static final String TYPEFACE_PREFIX = "fonts/";
    private static final String[] TYPEFACE_FILE_LIST = {"BebasNeue-Regular.ttf", "BebasNeueBook.ttf", "Roboto-Medium.ttf", "Roboto-Light.ttf", "Roboto-Regular.ttf", "San-Francisco-Display-Medium.ttf", "MyriadPro-Regular.ttf"};
    private static final Typeface[] TYPEFACE_LIST = new Typeface[TYPEFACE_FILE_LIST.length];

    private static boolean isLoaded = false;
    public static Typeface getTypeface(Context context, int index) {
        if (context == null) {
            Log.e(TAG, "getTypeface() context is null.");
            return Typeface.DEFAULT;
        }
        int maxIndex = TYPEFACE_FILE_LIST.length - 1;
        if (index < 0 && index >= maxIndex) {
            Log.e(TAG, String.format("getTypeface() index out of range, should be in range [0, %d], but pass in %d.", maxIndex, index));
            return Typeface.DEFAULT;
        }
        loadTypefaceIfNeeded(context);
        return TYPEFACE_LIST[index];
    }

    public static void loadTypefaceIfNeeded(Context context) {
        if (!isLoaded) {
            AssetManager assetManager = context.getAssets();
            for (int i = 0; i < TYPEFACE_FILE_LIST.length; i++) {
                TYPEFACE_LIST[i] = Typeface.createFromAsset(assetManager, TYPEFACE_PREFIX + TYPEFACE_FILE_LIST[i]);
            }
            isLoaded = true;
        }
    }

}
