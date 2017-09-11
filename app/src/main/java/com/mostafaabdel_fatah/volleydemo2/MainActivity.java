package com.mostafaabdel_fatah.volleydemo2;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    String image_Url = "http://10.0.2.2/MyWebSites/Optimistic.jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = (ImageView) findViewById(R.id.imageView);
    }

    public void DownloadImage_btnClicked(View view) {
        final ImageRequest imageRequest = new ImageRequest(image_Url
                , new Response.Listener<Bitmap>() {
            @Override
            public void onResponse(Bitmap response) {
                imageView.setImageBitmap(response);
            }
        }, 0, 0, ImageView.ScaleType.CENTER_CROP, null
                , new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this,"Something is error",Toast.LENGTH_SHORT).show();
                error.printStackTrace();
            }
        });
        SingleTon.getsInstance(getApplicationContext()).addToRequestQueue(imageRequest);
    }
}
