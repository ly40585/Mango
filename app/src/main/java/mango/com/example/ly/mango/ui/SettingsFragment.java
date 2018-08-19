package mango.com.example.ly.mango.ui;

import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.preference.SwitchPreference;
import android.support.annotation.Nullable;

import mango.com.example.ly.mango.R;
import mango.com.example.ly.mango.Util;

/**
 * Created by ly on 2018/8/19.
 */

public class SettingsFragment extends PreferenceFragment implements Preference.OnPreferenceChangeListener {

    private static final String KEY_SWITCH = "switch";

    private SwitchPreference mSwitch;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.settings_fragment);

        mSwitch = (SwitchPreference) findPreference(KEY_SWITCH);
        mSwitch.setOnPreferenceChangeListener(this);
    }


    @Override
    public boolean onPreferenceChange(Preference preference, Object newValue) {
        if (preference == mSwitch) {
            Util.enable(getContext(), (boolean) newValue);
        }
        return true;
    }

}
