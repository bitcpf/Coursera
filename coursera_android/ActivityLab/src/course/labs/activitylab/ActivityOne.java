package course.labs.activitylab;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class ActivityOne extends Activity {

	private static final String RESTART_KEY = "restart";
	private static final String RESUME_KEY = "resume";
	private static final String START_KEY = "start";
	private static final String CREATE_KEY = "create";

    private static final String PAUSE_KEY = "pause";
	// String for LogCat documentation
	private final static String TAG = "Lab-ActivityOne";
	
	// Lifecycle counters

	// TODO:
	// Create counter variables for onCreate(), onRestart(), onStart() and
	// onResume(), called mCreate, etc.
	// You will need to increment these variables' values when their
	// corresponding lifecycle methods get called
    private int mCreate=0;
    private int mStart=0;
    private int mResume=0;
    private int mRestart=0;



	// TODO: Create variables for each of the TextViews, called
        // mTvCreate, etc.
    TextView mTvCreate;
    TextView mTvRestart;
    TextView mTvResume;
    TextView mTvStart;


    @Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_one);
		
		// TODO: Assign the appropriate TextViews to the TextView variables
		// Hint: Access the TextView by calling Activity's findViewById()
		// textView1 = (TextView) findViewById(R.id.textView1);
        mTvCreate=(TextView)findViewById(R.id.create);
        mTvRestart=(TextView)findViewById(R.id.restart);
        mTvResume=(TextView)findViewById(R.id.resume);
        mTvStart=(TextView)findViewById(R.id.start);






        Button launchActivityTwoButton = (Button) findViewById(R.id.bLaunchActivityTwo);
		launchActivityTwoButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO:
				// Launch Activity Two
				// Hint: use Context's startActivity() method

                // Create an intent stating which Activity you would like to start
                Intent myIntent = new Intent(ActivityOne.this, ActivityTwo.class);

                // Launch the Activity using the intent
                ActivityOne.this.startActivity(myIntent);



            }
		});
		
		// Check for previously saved state
		if (savedInstanceState != null) {

			// TODO:
			// Restore value of counters from saved state
			// Only need 4 lines of code, one for every count variable
            mCreate = (Integer) savedInstanceState.get(CREATE_KEY);
            mStart = (Integer) savedInstanceState.get(START_KEY);
            mResume = (Integer) savedInstanceState.get(RESUME_KEY);
            mRestart = (Integer) savedInstanceState.get(RESTART_KEY);

			
		
		}

		// TODO: Emit LogCat message
		Log.i(TAG,"Entered the onCreate() method");


		// TODO:
		// Update the appropriate count variable
		// Update the user interface via the displayCounts() method
        mCreate+=1;
        displayCounts();


	}

	// Lifecycle callback overrides

	@Override
	public void onStart() {
		super.onStart();

		// TODO: Emit LogCat message
		Log.i(TAG,"Entered the onStart() method");

        // TODO:
        // Update the appropriate count variable
        mStart+=1;
        // Update the user interface
        displayCounts();


	}

	@Override
	public void onResume() {
		super.onResume();

		// TODO: Emit LogCat message
		Log.i(TAG,"Entered the onResume() method");

		// TODO:
		// Update the appropriate count variable
		// Update the user interface
        mResume+=1;
        displayCounts();


	}

	@Override
	public void onPause() {
		super.onPause();

		// TODO: Emit LogCat message
		Log.i(TAG,"Entered the onPause() method");

	}

	@Override
	public void onStop() {
		super.onStop();

		// TODO: Emit LogCat message
		Log.i(TAG,"Entered the onStop() method");

	}

	@Override
	public void onRestart() {
		super.onRestart();

		// TODO: Emit LogCat message
		Log.i(TAG,"Entered the onRestart() method");

		// TODO:
		// Update the appropriate count variable
		// Update the user interface
        mRestart+=1;
        displayCounts();


	}

	@Override
	public void onDestroy() {
		super.onDestroy();

		// TODO: Emit LogCat message
        Log.i(TAG,"Entered the onDestroy() method");

	}

	@Override
	public void onSaveInstanceState(Bundle savedInstanceState) {
		// TODO:
		// Save state information with a collection of key-value pairs
		// 4 lines of code, one for every count variable
        savedInstanceState.putInt(RESTART_KEY, mRestart);
        savedInstanceState.putInt(RESUME_KEY, mResume);
        savedInstanceState.putInt(START_KEY, mStart);
        savedInstanceState.putInt(CREATE_KEY, mCreate);





	}
	
	// Updates the displayed counters
	public void displayCounts() {

		mTvCreate.setText("onCreate() calls: " + mCreate);
		mTvStart.setText("onStart() calls: " + mStart);
		mTvResume.setText("onResume() calls: " + mResume);
		mTvRestart.setText("onRestart() calls: " + mRestart);
	
	}
}
