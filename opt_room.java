package com.example.josh.findmyplace;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class opt_room extends ActionBarActivity {
    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {

            if (msg.what == 1){
                Intent intent = new Intent(opt_room.this , confirm.class);
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
        setContentView(R.layout.room_options);
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
    public void proveIt(View image) {

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
        Thread walkingThread = new Thread (r);
        walkingThread.start();

    }
}
