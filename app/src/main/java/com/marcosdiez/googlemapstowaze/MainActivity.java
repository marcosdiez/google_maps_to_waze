package com.marcosdiez.googlemapstowaze;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


public class MainActivity extends Activity {
    static String TAG = "GM2W";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        processIntent();
    }

    private void processIntent() {
        Intent intent = getIntent();
        if(intent == null){
            Toast.makeText(this, R.string.intent_not_received, Toast.LENGTH_SHORT).show();
            return;
        }
        String data = intent.getDataString();
        if( data == null ){
            Toast.makeText(this,R.string.intent_contains_not_data, Toast.LENGTH_SHORT).show();
            return;
        }
        Log.d(TAG, "Received URL:" + data);
        ParseGoogleMapsUrl parsedData = new ParseGoogleMapsUrl(data);
        openGpsUrl(parsedData);

    }

    void openGpsUrl(ParseGoogleMapsUrl theDataX){
        // google maps
        String url = buildGoogleMapsUrl(theDataX.getLongitude(), theDataX.getLatitude());
        openUrl(url, this);
        finish();
    }

    static String buildGoogleMapsUrl(String longitude, String latitude){
        // waze://?ll=<lat>,<lon>&navigate=yes
        String theURL = "waze://?ll=" + latitude + "," + longitude + "&navigate=yes";
        return theURL;
    }

    static void openUrl(String theURL, Activity theActivity){
        Log.d(TAG, "Opening location:" + theURL);
        final Intent intent = new Intent(Intent.ACTION_VIEW,
                Uri.parse(theURL));
        theActivity.startActivity(intent);
    }
}
