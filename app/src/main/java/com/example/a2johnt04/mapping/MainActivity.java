package com.example.a2johnt04.mapping;

import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import org.osmdroid.config.Configuration;
import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;import android.view.View.OnClickListener;import android.view.View;import android.widget.TextView;
import android.widget.EditText;import android.widget.Button;import android.view.View.OnClickListener;import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;



public class MainActivity extends AppCompatActivity implements OnClickListener
{

    MapView mv;




    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);

        // This line sets the user agent, a requirement to download OSM maps
        Configuration.getInstance().load(this, PreferenceManager.getDefaultSharedPreferences(this));

        setContentView(R.layout.activity_main);

        mv = (MapView)findViewById(R.id.map1);

        mv.setBuiltInZoomControls(true);
        mv.getController().setZoom(16);
        mv.getController().setCenter(new GeoPoint(42.05,1.72));
        Button b = (Button)findViewById(R.id.btn1);
        b.setOnClickListener(this);

    }

        public void onClick(View view)
        {
        EditText longtxt = (EditText) findViewById(R.id.longitude);
        EditText lattxt = (EditText)findViewById(R.id.latitude);
        double longitude = Double.parseDouble(lattxt.getText().toString());
        double latitude = Double.parseDouble(longtxt.getText().toString());
            mv.getController().setCenter(new GeoPoint(latitude,longitude));
        }

        public boolean onCreateOptionsMenu(Menu menu)
        {
            MenuInflater inflater=getMenuInflater();
            inflater.inflate(R.menu.menu, menu);
            return true;
        }

        public boolean onOptionsItemSelected(MenuItem item)
        {
            if(item.getItemId() == R.id.choosemap)
            {
                Intent intent = new Intent(this,MapChooseActivity.class);
                startActivity(intent);
                // react to the menu item being selected...
                return true;
            }
            return false;
        }
}







