package com.hai.bt.custom;

import android.content.Context;
import android.view.View;
import android.widget.Toast;

/**
 * Created by Hai on 04/07/2018.
 */

public class ToastCustom implements View.OnClickListener {
    private Context mContext;
    private String mText;

    public ToastCustom(Context mContext, String mText) {
        this.mContext = mContext;
        this.mText = mText;
    }

    @Override
    public void onClick(View view) {
        Toast.makeText(mContext,mText,Toast.LENGTH_SHORT).show();
    }
}
