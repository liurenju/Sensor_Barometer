package com.example.liurenju.sensor_barometer;

import android.app.Activity;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.wearable.view.WatchViewStub;
import android.widget.TextView;
import android.hardware.Sensor;

public class MainActivity extends Activity implements SensorEventListener{

    private TextView mTextView;
    Sensor accelerometer;
    SensorManager sm;
    TextView acceleration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final WatchViewStub stub = (WatchViewStub) findViewById(R.id.watch_view_stub);
        stub.setOnLayoutInflatedListener(new WatchViewStub.OnLayoutInflatedListener() {
            @Override
            public void onLayoutInflated(WatchViewStub stub) {
                mTextView = (TextView) stub.findViewById(R.id.text);
                acceleration=(TextView)findViewById(R.id.acceleration);
                sm = (SensorManager) getSystemService(SENSOR_SERVICE);
                accelerometer = sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
                getStepCount();
            }
        });
        //acceleration=(TextView)findViewById(R.id.acceleration);

    }

    private void getStepCount() {
        sm.registerListener(this,accelerometer,SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        //acceleration = (TextView)findViewById(R.id.acceleration);
        //System.out.println("X: "+event.values[0]);
        //if (event.sensor.getType() == Sensor.TYPE_HEART_RATE) {
            //heart rate = (int) event.values[0];
            acceleration.setText("X: "+event.values[0]);
        //}
        //acceleration.setText("X: "+event.values[0]);//+ "\nY: "+event.values[1]+"\nZ: "+event.values[2]);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    /*@Override
    protected void onResume() {
        super.onResume();
        //Register the listener
        if (sm != null){
            sm.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_NORMAL);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        //Unregister the listener
        if (sm!=null)
            sm.unregisterListener(this);
    }*/

}
