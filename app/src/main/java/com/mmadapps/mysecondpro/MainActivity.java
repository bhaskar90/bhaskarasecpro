package com.mmadapps.mysecondpro;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends HomeDrawer {

    ImageView imageView,imageView3,imageView4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar bar=getSupportActionBar();
        bar.hide();
        LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View contentView = inflater.inflate(R.layout.activity_main, null, false);
        drawer.addView(contentView, 0);

        initializeViewsforhome();

    }

    private void initializeViewsforhome() {

        imageView= (ImageView) findViewById(R.id.imageView);
        imageView3= (ImageView) findViewById(R.id.imageView3);
        imageView4= (ImageView) findViewById(R.id.imageView4);
        setValues();

    }

    private void setValues() {
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,ViewPagersActivity.class);
                startActivity(intent);
            }
        });

        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,ServiceCallingActivity.class);
                startActivity(intent);
            }
        });

        imageView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,RecyclerViewActivity.class);
                startActivity(intent);
            }
        });



    }
}
