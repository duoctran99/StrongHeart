package com.strongheart;

import com.strongheart.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;

public class hinhchao extends Activity{
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chao);
        LinearLayout rchao = (LinearLayout) findViewById(R.id.manhinhchao); 
        rchao.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent Main = new Intent(v.getContext(), MainActivity.class);
		        startActivity(Main);
			}
		});      
    }
}
