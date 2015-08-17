package ca.mahram.demo.butterknife.activity;

import android.os.Bundle;

import ca.mahram.demo.butterknife.R;
import ca.mahram.demo.butterknife.activity.base.BaseDemoActivity;

/**
 Created by mahram on 15-03-04.
 */
public class FragmentBindingActivity
  extends BaseDemoActivity {
    @Override protected void onCreate (final Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_fragment_binding);
    }
}
