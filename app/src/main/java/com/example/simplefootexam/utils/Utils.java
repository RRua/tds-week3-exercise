package com.example.simplefootexam.utils;

import android.content.Context;
import androidx.annotation.RawRes;
import com.example.simplefootexam.R;
import org.json.JSONArray;
import org.json.JSONException;
import java.io.InputStream;
import java.util.Scanner;


public class Utils {

    public String readRawResource(@RawRes int res, Context context) {
        return readStream(context.getResources().openRawResource(res));
    }

    private static String readStream(InputStream is) {
        Scanner s = new Scanner(is).useDelimiter("\\A");
        return s.hasNext() ? s.next() : "";
    }

    public static JSONArray loadSONFile(Context ctx) {
        String filecontent = null;
        JSONArray jo = new JSONArray();
        try {
            filecontent = readStream(ctx.getResources().openRawResource(R.raw.questions));
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            return new JSONArray(filecontent);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jo;
    }
}
