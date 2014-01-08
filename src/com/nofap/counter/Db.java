package com.nofap.counter;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import android.database.sqlite.SQLiteOpenHelper;

public class Db extends SQLiteOpenHelper{
	private static final int db_version = 1;
    private static final String db_name = "nofapcounter";
    private static final String db_table = "nofap";  
    
    
	public Db(Context context) {
		super(context,db_name, null, db_version);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
	 String CREATE_CONTACTS_TABLE = "CREATE TABLE " + db_table + 
			 "(id INTEGER PRIMARY KEY, count INTEGER)";
	 db.execSQL(CREATE_CONTACTS_TABLE);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
	  onCreate(db);
	}
	
	public int getFap(){
		SQLiteDatabase db = this.getReadableDatabase();
		Cursor c = db.rawQuery("SELECT count FROM " + db_table, null);
		Integer R = c.getCount();
		if (R > 0){c.moveToFirst();R = c.getInt(0);}
		db.close();
		return R;
	}
	
	public void NoFap() {
		String sql;
		Integer inc = getFap();
		if (inc==0){
			sql="INSERT INTO " + db_table + " (id,count) VALUES (1,1)" ;
		}else{
			inc++;
			sql="UPDATE " + db_table + " SET count=" + inc.toString() + " WHERE id=1";
		}
		
		SQLiteDatabase db = this.getWritableDatabase();
				
		db.execSQL(sql);
		db.close();
	}
	
	public void Fap(){
		String sql;
		Integer inc = getFap();
		if (inc==0){
			sql="INSERT INTO " + db_table + " (id,count) VALUES (1,1)" ;
		}else{
			inc=inc-1;
			sql="UPDATE " + db_table + " SET count=" + inc.toString() + " WHERE id=1";
		}
		
		SQLiteDatabase db = this.getWritableDatabase();
		db.execSQL(sql);
		db.close();
		

	}
}
