package com.example.instragramclone;

import android.app.Application;
import android.util.Log;

import com.parse.Parse;
import com.parse.ParseACL;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseUser;
import com.parse.SaveCallback;

public class StarterApplication extends Application
{
    //// Reference: https://docs.parseplatform.org/android/guide/#the-parseobject
    @Override
    public void onCreate()
    {
        super.onCreate();
    
//        Parse.initialize(new Parse.Configuration.Builder(this)
//                                 .applicationId("YOUR_APP_ID")
//                                 // if defined
//                                 .clientKey("YOUR_CLIENT_KEY")
//                                 .server("http://localhost:1337/parse/")
//                                 .build()
//        );
//
        // Enable Local Datastore.
//        Parse.enableLocalDatastore(this);

        // Add your initialization code here
        Parse.initialize(new Parse.Configuration.Builder(getApplicationContext())

                                 .applicationId("YOUR_APP_ID")
                                 // if defined
                                 .clientKey("YOUR_CLIENT_KEY")
                                 .server("http://localhost:1337/parse/")
                                 .build()
        );

        ParseObject object = new ParseObject("ExampleObject");
        object.put("myNumber", "123");
        object.put("myString", "rob");

        object.saveInBackground(new SaveCallback() {
          @Override
          public void done(ParseException ex) {
            if (ex == null) {
              Log.i("Parse Result", "Successful!");
            } else {
              Log.i("Parse Result", "Failed" + ex.toString());
            }
          }
        });


        ParseUser.enableAutomaticUser();

        ParseACL defaultACL = new ParseACL();
        defaultACL.setPublicReadAccess(true);
        defaultACL.setPublicWriteAccess(true);
        ParseACL.setDefaultACL(defaultACL, true);
    
    }// onCreate()

}// class StarterApplication
