package com.mmadapps.mysecondpro;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.mmadapps.mysecondpro.utils.ConnectionDetector;
import com.mmadapps.mysecondpro.utils.OnResponseListner;
import com.mmadapps.mysecondpro.utils.WebServices;

public class ServiceCallingActivity extends AppCompatActivity implements OnResponseListner{

    ImageView imageView2;
    ConnectionDetector detector;
    RelativeLayout activity_service_calling;
    ProgressDialog pdLoading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_calling);

        initializeViews();

    }

    private void initializeViews() {
        imageView2= (ImageView) findViewById(R.id.imageView2);
        detector=new ConnectionDetector(ServiceCallingActivity.this);
        activity_service_calling= (RelativeLayout) findViewById(R.id.activity_service_calling);
        pdLoading = new ProgressDialog(ServiceCallingActivity.this);
        setValues();
    }

    private void setValues() {

        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(detector.isConnectingToInternet()){

                    Snackbar.make(activity_service_calling," internet is available",Snackbar.LENGTH_SHORT).show();

                   /* if (detector.isConnectingToInternet()) {
                        pdLoading.setMessage("Processing...");
                        pdLoading.setCanceledOnTouchOutside(false);
                        pdLoading.show();
                        WebServices<Loginbeansresult> postLogindata = new WebServices<Loginbeansresult>(LoginActivity.this);
                        postLogindata.userLoginservice(WebServices.RadioCitytesturl, WebServices.ApiType.Userlogin,
                                new Loginbeanscons(new UserProfile(vE_al_username.getText().toString().trim(), vE_al_pswd.getText().toString().trim())));
                    } else {
                        SnackBar.makeText(LoginActivity.this, R.string.pleasecheckinternet, SnackBar.LENGTH_SHORT)
                                .setDuration(2000).show();
                    }
*/
                }else{
                    Snackbar.make(activity_service_calling,"Please check internet",Snackbar.LENGTH_SHORT).show();
                }

            }
        });
    }


    @Override
    public void onResponse(Object response, WebServices.ApiType URL, boolean isSucces) {

       /* if (URL == WebServices.ApiType.Userlogin) {

            if (isSucces) {
                if (pdLoading.isShowing())
                    pdLoading.cancel();
                Loginbeansresult loginResponse = (Loginbeansresult) response;
                if (loginResponse != null) {
                    if (!loginResponse.getUserLoginResult().getIsError()) {

                        SharedPreferences sp = getSharedPreferences("LoginInfo", 0);
                        SharedPreferences.Editor et = sp.edit();
                        et.putString("Username", loginResponse.getUserLoginResult().getResponseObject().getName() + "");
                        et.putString("Email", loginResponse.getUserLoginResult().getResponseObject().getEmail() + "");
                        et.apply();

                        Intent iRedirectScreen = new Intent(LoginActivity.this, HomeActivity.class);
                        iRedirectScreen.putExtra("isFromLogin", "true");
                        startActivity(iRedirectScreen);
                    } else {
                        SnackBar.makeText(LoginActivity.this, loginResponse.getUserLoginResult().getExceptionObject().getErrorMessage(), SnackBar.LENGTH_SHORT)
                                .setDuration(2000).show();
                    }
                }
            } else {
                if (pdLoading.isShowing())
                    pdLoading.cancel();
            }

        }*/

    }
}
