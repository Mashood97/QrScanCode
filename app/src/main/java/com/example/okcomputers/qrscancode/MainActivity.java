package com.example.okcomputers.qrscancode;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class MainActivity extends AppCompatActivity {

    private ZXingScannerView scannerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void scanCode(View view)
    {
        scannerView = new ZXingScannerView(this);
        scannerView.setResultHandler(new ZxingScannerResult());
        setContentView(scannerView);
        scannerView.startCamera();
    }

    @Override
    protected void onPause() {
        super.onPause();
        scannerView.stopCamera();
    }

    class  ZxingScannerResult implements ZXingScannerView.ResultHandler
{
    @Override
    public void handleResult(Result result) {
        String resultCode = result.getText();
        Toast.makeText(MainActivity.this,resultCode,Toast.LENGTH_LONG).show();
        setContentView(R.layout.activity_main);
        scannerView.stopCamera();
    }
}
}
