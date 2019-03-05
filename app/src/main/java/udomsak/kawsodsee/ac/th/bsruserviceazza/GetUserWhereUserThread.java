package udomsak.kawsodsee.ac.th.bsruserviceazza;

import android.content.Context;
import android.os.AsyncTask;

import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

public class GetUserWhereUserThread extends AsyncTask<String,Void,String> {

    private Context context;

    // 1. สร้าง context ประกาศตัวแปรแล้ว จากนั้นกด alt + insert -> constructor -> enter -> enter
    // 2. extends AsyncTask <ส่งค่า,process,ผลลัพธ์กลับมา>
    // 3. จากนั้น cursor ไว้ที่ extend แล้วกด alt + enter -> implement method -> enter -> enter
    public GetUserWhereUserThread(Context context) {
        this.context = context;
    }

    @Override
    protected String doInBackground(String... strings) {

        try {

            OkHttpClient okHttpClient = new OkHttpClient();
            // OkHttpClient okHttpClient = new OkHttpClient();
            // class object = new class
            RequestBody requestBody = new FormEncodingBuilder()
                    .add("isAdd","true")
                    .add("User",strings[0])
                    .build();
            Request.Builder builder = new Request.Builder();
            Request request = builder.url(strings[1]).post(requestBody).build();
            Response response = okHttpClient.newCall(request).execute();

            return response.body().string();

        } catch (Exception e) { // เก็บ Error ไว้ที่ตัวแปร e
            e.printStackTrace();
            return null;
        }
    }
}
