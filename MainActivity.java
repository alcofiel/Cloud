package com.example.josh.findmyplace;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class MainActivity extends ActionBarActivity {
    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {

            if (msg.what == 1){
                Intent intent = new Intent(MainActivity.this , room_prefs.class);
                //EditText editText = (EditText) findViewById(R.id.editText); //get input from textfield
                //String message = editText.getText().toString();//make a message based on the textfield
                //intent.putExtra(EXTRA_MESSAGE, message);
                startActivity(intent);


            }
            else if (msg.what == 2){
                Intent intent = new Intent(MainActivity.this , EditPreferences.class);
                //EditText editText = (EditText) findViewById(R.id.editText); //get input from textfield
                //String message = editText.getText().toString();//make a message based on the textfield
                //intent.putExtra(EXTRA_MESSAGE, message);
                startActivity(intent);


            }

        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    public void getRooms(View image) {

        Runnable r = new Runnable (){
            @Override
            public void run(){
                long futureTime = System.currentTimeMillis()+2000;
                while(System.currentTimeMillis() < futureTime){
                    synchronized (this){
                        try{
                            wait(futureTime-System.currentTimeMillis());
                        }catch(Exception e){}
                    }
                }
                handler.sendEmptyMessage(1);
            }
        };
        Thread joshsThread = new Thread (r);
        joshsThread.start();

    }
    public void jazzUpApp (View image) {

        Runnable r = new Runnable (){
            @Override
            public void run(){
                long futureTime = System.currentTimeMillis()+2000;
                while(System.currentTimeMillis() < futureTime){
                    synchronized (this){
                        try{
                            wait(futureTime-System.currentTimeMillis());
                        }catch(Exception e){}
                    }
                }
                handler.sendEmptyMessage(2);
            }
        };
        Thread joshsThread = new Thread (r);
        joshsThread.start();

    }
}
