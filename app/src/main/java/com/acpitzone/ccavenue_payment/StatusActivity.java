package com.acpitzone.ccavenue_payment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import de.hdodenhof.circleimageview.CircleImageView;

public class StatusActivity extends AppCompatActivity {

	CircleImageView circleImageView;
	String payment_status;
	@Override
	public void onCreate(Bundle bundle) {
		super.onCreate(bundle);
		setContentView(R.layout.activity_status);



		circleImageView=findViewById(R.id.status_image);

		Intent mainIntent = getIntent();
		payment_status=mainIntent.getStringExtra("transStatus");


		Log.d("inMain",payment_status);

		TextView tv4 = (TextView) findViewById(R.id.textView);
		tv4.setText(mainIntent.getStringExtra("transStatus"));
	}
	
	public void showToast(String msg) {
		Toast.makeText(this, "Toast: " + msg, Toast.LENGTH_LONG).show();
	}

} 