package com.strongheart;

import com.strongheart.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class tab1_Activity extends Activity {
	ImageButton chucnang1;
	ImageButton chucnang2;
	ImageButton chucnang3;
	ImageButton chucnang4;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tab1);
		chucnang1 = (ImageButton) findViewById(R.id.chucnang1);
		chucnang1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent chucnang1 = new Intent(v.getContext(), chucnang1.class);
				startActivity(chucnang1);
			}
		});
		chucnang2 = (ImageButton) findViewById(R.id.chucnang2);
		chucnang2.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent chucnang2 = new Intent(v.getContext(), chucnang2.class);
				startActivity(chucnang2);
			}
		});
		chucnang3 = (ImageButton) findViewById(R.id.chucnang3);
		chucnang3.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent chucnag3= new Intent(v.getContext(),chucnang3.class);
				startActivity(chucnag3);
			}
		});
		chucnang4 = (ImageButton) findViewById(R.id.chucnang4);
		chucnang4.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent chucnag4= new Intent(v.getContext(),chucnang4.class);
				startActivity(chucnag4);
			}
		});
	}
}
