package com.app.hubert.newbieguide.test;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.app.hubert.guide.NewbieGuide;
import com.app.hubert.guide.core.Controller;
import com.app.hubert.guide.model.GuidePage;
import com.app.hubert.guide.model.HighlightOptions;
import com.app.hubert.newbieguide.R;

public class Test1Activity extends AppCompatActivity {

    private Controller controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test1);

        Button button=findViewById(R.id.button);
        Button button2=findViewById(R.id.button2);

        HighlightOptions.Builder builder=new HighlightOptions.Builder();
        builder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    controller.remove();
            }
        });
        HighlightOptions.Builder builder2 = new HighlightOptions.Builder();
        builder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    startActivity(new Intent(Test1Activity.this,Test2Activity.class));
            }
        });

        //是否每次都显示引导层，默认false，只显示一次
//                        .addHighLightWithOptions(button,builder.build())
        controller = NewbieGuide.with(this)
                .setLabel("guide1")
                .alwaysShow(true)//是否每次都显示引导层，默认false，只显示一次
                .addGuidePage(GuidePage.newInstance()
//                        .addHighLightWithOptions(button,builder.build())
                        .addHighLight(button)
//                        .setEverywhereCancelable(false)
                )

                .addGuidePage(GuidePage.newInstance()
                        .addHighLightWithOptions(button2,builder2.build())
                        .setEverywhereCancelable(false))
                .show();

    }
}
