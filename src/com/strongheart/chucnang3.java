package com.strongheart;

import com.strongheart.R;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Vibrator;
import android.os.Handler;
import android.os.PowerManager;
import android.util.Log;
import android.view.View;
/*import android.view.animation.Animation;
import android.view.animation.AnimationUtils;*/
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class chucnang3 extends Activity  {
        /* constants */
        private static final int POLL_INTERVAL = 500;
       
        /** running state **/
        private boolean mRunning = false;
        
        /** config state **/
        private int mThreshold;
        
        private PowerManager.WakeLock mWakeLock;

        private Handler mHandler = new Handler();

        /* References to view elements */
        private TextView mStatusView;
        private SoundLevelView mDisplay;

        /* sound data source */
        private SoundMeter mSensor;
        
        // Get instance of Vibrator from current Context
        private Vibrator vibrator;
        
        private Button mButtonStop;
        private Button mButtonStart;
        private Button mButtonResume;
        
       /****************** Define runnable thread again and again detect noise *********/
        
        private Runnable mSleepTask = new Runnable() {
                public void run() {
                	//Log.i("Noise", "runnable mSleepTask");
                	start();
                }
        };
        
        // Create runnable thread to Monitor Voice
        private Runnable mPollTask = new Runnable() {
                public void run() {                	
                        double amp = mSensor.getAmplitude();
                        //Log.i("Noise", "runnable mPollTask");
                        updateDisplay("Đang theo dõi tiếng động...", amp);

                        if ((amp > mThreshold)) {
                              callForHelp();
                              //Log.i("Noise", "==== onCreate ===");                             
                        }                  
                        // Runnable(mPollTask) will again execute after POLL_INTERVAL
                        mHandler.postDelayed(mPollTask, POLL_INTERVAL);
                }
        };
               
        /** Called when the activity is first created. */
        @Override
        public void onCreate(Bundle savedInstanceState) throws IllegalStateException{
                super.onCreate(savedInstanceState);
                // Defined SoundLevelView in main.xml file
                setContentView(R.layout.activity_chucnang3);
                mStatusView = (TextView) findViewById(R.id.status);
                //Button
                mButtonStop		= (Button)findViewById(R.id.buttonStop);
                mButtonStart	= (Button)findViewById(R.id.buttonStart);
                mButtonResume	= (Button)findViewById(R.id.buttonResume);
                // Used to record voice
                mSensor			= new SoundMeter();
                mDisplay		= (SoundLevelView) findViewById(R.id.volume);
                
                PowerManager pm = (PowerManager) getSystemService(Context.POWER_SERVICE);
                mWakeLock 		= pm.newWakeLock(PowerManager.SCREEN_DIM_WAKE_LOCK, "NoiseAlert");
                super.onStop();
        }
        
        public void onClickStop(View v)
    	{
    		vibrator.cancel();
    		Toast.makeText(getApplicationContext(), "Cảnh báo tiếng ồn đã tắt.", 
      			  Toast.LENGTH_LONG).show();
    		onStop();
    		mButtonStop.setEnabled(false);
    		mButtonResume.setEnabled(true);
    	}
        
    	public void onClickResume(View v)
    	{
    		onResume();
    		Toast.makeText(getApplicationContext(), "Tiếp tục cảnh báo tiếng ồn.", 
        			  Toast.LENGTH_LONG).show();
    		mButtonStop.setEnabled(true);
    		mButtonResume.setEnabled(false);
    	}
    	
    	public void onClickStart(View v)
    	{
    		start();
            mButtonStart.setEnabled(false);
            mButtonStop.setEnabled(true);
    	}
    	
        @Override
        public void onResume() {
                super.onResume();
                //Log.i("Noise", "==== onResume ===");
                
                initializeApplicationConstants();
                mDisplay.setLevel(0, mThreshold);
                
                if (!mRunning) {
                    mRunning = true;
                    start();
                }
        }

        @Override
        public void onStop() {
        	super.onStop();
        	// Log.i("Noise", "==== onStop ===");
        	//Stop noise monitoring
        	stop();               
        }

        private void start() {
        	//Log.i("Noise", "==== start ===");
            mSensor.start();
            if (!mWakeLock.isHeld()) {
            	mWakeLock.acquire();
            }
            //Noise monitoring start
            // Runnable(mPollTask) will execute after POLL_INTERVAL
            mHandler.postDelayed(mPollTask, POLL_INTERVAL);               
        }

        private void stop() {
        	Log.i("Cảnh báo tiếng ồn", "==== Đã dừng bộ cảnh báo tiếng ồn ===");
                if (mWakeLock.isHeld()) {
                        mWakeLock.release();
                }
                mHandler.removeCallbacks(mSleepTask);
                mHandler.removeCallbacks(mPollTask);
                mSensor.stop();
                mDisplay.setLevel(0,0);
                updateDisplay("Đã dừng...", 0.0);
                mRunning = false;      
        }
       
        private void initializeApplicationConstants() {
                // Set Noise Threshold
        	    mThreshold = 7;            
        }

        private void updateDisplay(String status, double signalEMA) {
                mStatusView.setText(status);
                mDisplay.setLevel((int)signalEMA, mThreshold);
        }
        
        private void callForHelp() throws IllegalStateException{
        	
        	//Set the pattern, like vibrate for 300 milliseconds and then stop for 200 ms, then 
            //vibrate for 300 milliseconds and then stop for 500 ms. You can change the pattern and 
            // test the result for better clarity.
            long pattern[]={0, 500, 200};

            // Start the vibration
            vibrator = (Vibrator)getSystemService(Context.VIBRATOR_SERVICE);
            //start vibration with repeated count, use -1 if you don't want to repeat the vibration
            vibrator.vibrate(pattern, -1); 
            //vibrator.vibrate(500);
           
        	// Show alert when noise thersold crossed
        	//Toast.makeText(getApplicationContext(), "Noise Thersold Crossed, do here your stuff.", 
        		//	  Toast.LENGTH_LONG).show();
        }
        
};
