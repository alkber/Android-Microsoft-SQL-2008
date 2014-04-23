package com.alkber.androidmssql2008;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;

import com.alkber.androidmssql2008.datastore.Dao;
import com.alkber.androidmssql2008.listeners.DBConnectionListener;

/**
 * Main activity class for the demo
 * 
 * @author Althaf K Backer <althafkbacker@gmail.com>
 *
 */
public class MSSQLConnActivity extends Activity implements DBConnectionListener {

	private static final String LOG_TAG = MSSQLConnActivity.class.getName();
	private TextView tvConnectionLog;
	private Dao dao;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_mssqlconnection);
		tvConnectionLog = (TextView) findViewById(R.id.tv_connection_log);
		dao = Dao.instance(this);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.mssqlconnection, menu);
		return true;

	}

	@Override
	public void onResume() {

		super.onResume();
		dao.connect("xxx.xxx.xxx.xxx:1433", "password", "user",
				"dbname");

	}

	@Override
	protected void onDestroy() {

		super.onDestroy();
		dao.disconnect();

	}

	@Override
	public void onConnectionStatusInfo(final String status) {

		this.runOnUiThread(new Runnable() {

			@Override
			public void run() {

				tvConnectionLog.setText(tvConnectionLog.getText() + "\n"
						+ status);

			}
		});

	}

	@Override
	public void onConnectionSuccessful() {

		// Once connection is established
		// dao.addUser();
		// dao.delUser();

	}

	@Override
	public void onConnectionFailed() {

		// May be retry or show some error, errors are usually reported in
		// onConnectionStatusInfo()

	}

}
