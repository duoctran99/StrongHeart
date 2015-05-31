package com.strongheart;

import com.strongheart.R;

import android.os.Bundle;
import android.app.TabActivity;
import android.content.Intent;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

public class MainActivity extends TabActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		TabHost tabHost = extracted();
		
		// Tab 1
        TabSpec tab1spec = tabHost.newTabSpec("tab1");
        tab1spec.setIndicator("Chức Năng", getResources().getDrawable(R.drawable.home));
        Intent tab1Intent = new Intent(this, tab1_Activity.class);
        tab1spec.setContent(tab1Intent);
        
    
        // Tab 3
        TabSpec tabspec = tabHost.newTabSpec("tab");
        tabspec.setIndicator("Giới Thiệu", getResources().getDrawable(R.drawable.info));
        Intent tab3Intent = new Intent(this,tab2_Activity.class);
        tabspec.setContent(tab3Intent);

        tabHost.addTab(tab1spec);
        tabHost.addTab(tabspec);
	}

	private TabHost extracted() {
		return getTabHost();
	}
}
