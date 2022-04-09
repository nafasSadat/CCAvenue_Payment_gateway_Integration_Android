package com.acpitzone.ccavenue_payment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.acpitzone.ccavenue_payment.Utility.AvenuesParams;
import com.acpitzone.ccavenue_payment.Utility.Constants;
import com.acpitzone.ccavenue_payment.Utility.ServiceUtility;

public class MainActivity extends AppCompatActivity {
String amount, order_ID;;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText editamount=findViewById(R.id.enter_amount);


        Button paybutton=findViewById(R.id.hellobutton);

        paybutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                amount=editamount.getText().toString();


                String vAccessCode = ServiceUtility.chkNull(Constants.access_code).toString().trim();
                Log.d("Access_code",vAccessCode);
                String vMerchantId = ServiceUtility.chkNull(Constants.merchantId).toString().trim();
                String vCurrency = ServiceUtility.chkNull(Constants.currency).toString().trim();
                String vAmount = ServiceUtility.chkNull(amount).toString().trim();

                if(!vAccessCode.equals("") && !vMerchantId.equals("") && !vCurrency.equals("") && !vAmount.equals("")){
                    Intent intent = new Intent(MainActivity.this,WebViewActivity.class);
                    intent.putExtra(AvenuesParams.ACCESS_CODE, ServiceUtility.chkNull(Constants.access_code).toString().trim());
                    intent.putExtra(AvenuesParams.MERCHANT_ID, ServiceUtility.chkNull(Constants.merchantId).toString().trim());
                    intent.putExtra(AvenuesParams.ORDER_ID, ServiceUtility.chkNull(order_ID).toString().trim());
                    intent.putExtra(AvenuesParams.CURRENCY, ServiceUtility.chkNull(Constants.currency).toString().trim());
                    intent.putExtra(AvenuesParams.AMOUNT, ServiceUtility.chkNull(amount).toString().trim());

                    intent.putExtra(AvenuesParams.REDIRECT_URL, ServiceUtility.chkNull(Constants.redirectUrl).toString().trim());
                    intent.putExtra(AvenuesParams.CANCEL_URL, ServiceUtility.chkNull(Constants.cancelUrl).toString().trim());
                    intent.putExtra(AvenuesParams.RSA_KEY_URL, ServiceUtility.chkNull(Constants.rsaKeyUrl).toString().trim());

                    startActivity(intent);
                }else{
                    showToast("All parameters are mandatory.");
                }


            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        //generating new order number for every transaction
        Integer randomNum = ServiceUtility.randInt(0, 9999999);
        order_ID=randomNum.toString();
    }

    public void showToast(String msg) {
        Toast.makeText(this, "Toast: " + msg, Toast.LENGTH_LONG).show();
    }

}