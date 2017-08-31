package com.example.jipengfei.myapplication;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;

/**
 * Created by Jeepend on 27/4/2017.
 */

public class TypeFaceTextView extends android.support.v7.widget.AppCompatTextView {
    public TypeFaceTextView(Context context) {
        super(context);
    }

    public TypeFaceTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        Resources.Theme theme = context.getTheme();
        TypedArray array =  theme.obtainStyledAttributes(attrs, R.styleable.TypeFaceTextView, 0, 0);
        int typefaceIndex = array.getInt(R.styleable.TypeFaceTextView_typeface, -1);
        Typeface typeface = Typeface.DEFAULT;
        if (typefaceIndex != -1) {
            typeface = TypefaceLoader.getTypeface(context, typefaceIndex);
        }
        setTypeface(typeface);
    }
}
