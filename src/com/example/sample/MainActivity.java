package com.example.sample;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.text.Editable;
import android.text.TextWatcher;

public class MainActivity extends Activity implements TextWatcher,
	OnClickListener {
	// 数値入力用のEditText
	EditText mEditText1;
	EditText mEditText2;
	EditText mEditText3;
	EditText mEditText4;
	EditText mEditText5;
	//結果表示用のTextView
	TextView mTextView9;
	TextView mTextView12;
	TextView mTextView19;
	// 演算を実行するButton
	Button mButton1;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		//画面のインスタンスを取得
		mEditText1 = (EditText) findViewById(R.id.editText1);
		mEditText2 = (EditText) findViewById(R.id.editText2);
		mEditText3 = (EditText) findViewById(R.id.editText3);
		mEditText4 = (EditText) findViewById(R.id.editText4);
		mEditText5 = (EditText) findViewById(R.id.editText5);
		mTextView9 = (TextView)findViewById(R.id.textView9);
		mTextView12 = (TextView)findViewById(R.id.textView12);
		mTextView19 = (TextView)findViewById(R.id.textView19);
		mButton1 = (Button) findViewById(R.id.button1);
		//演算実行ボタンのクリック時のリスナー設定
		findViewById(R.id.button1).setOnClickListener(this);
		// 入力された文字列の変更を取得するリスナー設定
		mEditText1.addTextChangedListener(this);
		mEditText2.addTextChangedListener(this);
		mEditText3.addTextChangedListener(this);
		mEditText4.addTextChangedListener(this);
		mEditText5.addTextChangedListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	@Override
	public void afterTextChanged(Editable s) {
		mTextView9.setText("0");
		mTextView12.setText("0");
		mTextView19.setText("0");
	}

	@Override
	public void onClick(View v) {
		int soShiharai = 0;
		int marume = 0;
		int men = 0;
		int women = 0;
		double ninzu = 0.0;
		double jyoshiwari = 0.0;
		int menShiharai = 0;
		int womenShiharai = 0;
		int otsuri = 0;
		double wari = 0.0;
		try{
			soShiharai = Integer.parseInt(mEditText1.getText().toString());
			marume = Integer.parseInt(mEditText2.getText().toString());
			men = Integer.parseInt(mEditText3.getText().toString());
			women =Integer.parseInt(mEditText4.getText().toString());
			jyoshiwari = Double.parseDouble(mEditText5.getText().toString());
			
			ninzu = men + ((1-jyoshiwari/100) * women);
			wari = soShiharai / ninzu;
			menShiharai = (int)Math.ceil(wari / marume) * marume;
			womenShiharai = (int)Math.ceil(wari * (1 - jyoshiwari /100) / marume) * marume;
			otsuri = (menShiharai * men) + (womenShiharai * women) - soShiharai;
			
			mTextView9.setText(Integer.toString(menShiharai));
			mTextView19.setText(Integer.toString(womenShiharai));
			mTextView12.setText(Integer.toString(otsuri));
		} catch (NumberFormatException e) {
			Toast.makeText(this, "数字を入力して下さい", Toast.LENGTH_LONG).show();
		}
	}

	@Override
	public void beforeTextChanged(CharSequence s, int start, int count,
			int after) {
		// TODO 自動生成されたメソッド・スタブ
		
	}

	@Override
	public void onTextChanged(CharSequence s, int start, int before, int count) {
		// TODO 自動生成されたメソッド・スタブ
		
	}
}
