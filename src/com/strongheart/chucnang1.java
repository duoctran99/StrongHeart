package com.strongheart;

import com.strongheart.R;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.EditText;

public class chucnang1 extends Activity {
	CustomKeyboard mCustomKeyboard;
	EditText edittext;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_chucnang1);
		edittext = (EditText) findViewById(R.id.display);
		mCustomKeyboard= new CustomKeyboard(this, edittext, R.xml.qwerty );
        mCustomKeyboard.registerEditText(R.id.display);  
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}
