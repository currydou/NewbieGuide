package com.app.hubert.newbieguide.test;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.app.hubert.guide.NewbieGuide;
import com.app.hubert.guide.model.GuidePage;
import com.app.hubert.guide.model.HighlightOptions;
import com.app.hubert.newbieguide.R;

public class Test2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test2);

        Button button=findViewById(R.id.button);

        HighlightOptions.Builder builder=new HighlightOptions.Builder();
        builder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                startActivity(new Intent(Test2Activity.this,Test2Activity.class));

            }
        });

        NewbieGuide.with(this)
                .setLabel("guide1")
//                        .setShowCounts(3)//控制次数
                .alwaysShow(true)//总是显示，调试时可以打开
                .addGuidePage(GuidePage.newInstance()
                        .addHighLightWithOptions(button,builder.build())
                        .setEverywhereCancelable(false))
                .show();


    }
}
