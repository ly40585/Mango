package mango.com.example.ly.mango.ui;

import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.preference.SwitchPreference;
import android.support.annotation.Nullable;

import mango.com.example.ly.mango.R;
import mango.com.example.ly.mango.Util;
import mango.com.example.ly.mango.view.SeekBarPreference;

/**
 * Created by ly on 2018/8/19.
 */

public class SettingsFragment extends PreferenceFragment implements Preference.OnPreferenceChangeListener {

    private static final String KEY_SWITCH = "switch";
    private static final String KEY_TOUCH_HEIGHT = "touch_height";
    private SwitchPreference mSwitch;
    private SeekBarPreference mTouchHeight;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.settings_fragment);

        mSwitch = (SwitchPreference) findPreference(KEY_SWITCH);
        mTouchHeight = (SeekBarPreference) findPreference(KEY_TOUCH_HEIGHT);

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
