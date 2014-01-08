package com.nofap.counter;

/* Aplikasi Penghitung Tidak FAP :D
 * Lisensi Bebas mau diapain aja :D
 * Buatan Junker #65 Forum Kaskus :D 
 */

import com.fap.counter.R;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {
	TextView disp;
	Db db;
	Integer get;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		disp = (TextView)findViewById(R.id.textView1);		
		db = new Db(this);
		
		get = db.getFap();
		disp.setText(get.toString());
	}

	public void NoFap(View v){
		db.NoFap();
		get = db.getFap();
		disp.setText(get.toString());
	}
	
	public void Fap(View v){
		db.Fap();
		get = db.getFap();
		disp.setText(get.toString());
	}
	


}
