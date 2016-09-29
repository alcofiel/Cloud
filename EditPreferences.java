package com.example.josh.findmyplace;

import android.os.Bundle;
import android.preference.PreferenceActivity;

/**
 * Created by Josh on 3/4/2016.
 */

public class EditPreferences extends PreferenceActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferences);
    }


}
