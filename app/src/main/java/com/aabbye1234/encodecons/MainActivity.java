package com.aabbye1234.encodecons;

import android.app.Activity;
import android.os.Bundle;

import com.aabbye1234.encodecons.utils.VarUtils;

public class MainActivity extends Activity {

    private static final String STR_1 = VarUtils.decrypt(BuildConfig.STR_1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        System.out.println(STR_1);
    }
}