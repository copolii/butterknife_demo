package ca.mahram.demo.butterknife.activity.base;

import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.MenuItem;

/**
 Created by mahram on 15-03-02.
 */
public class BaseDemoActivity extends ActionBarActivity {

    protected BaseDemoActivity () {
        super();
    }

    @Override protected void onCreate (final Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);

        final ActionBar ab = getSupportActionBar ();
        ab.setDisplayHomeAsUpEnabled (true);
    }

    @Override public boolean onOptionsItemSelected (final MenuItem item) {
        if (item.getItemId () == android.R.id.home) {
            NavUtils.navigateUpFromSameTask (this);
            return true;
        }

        return super.onOptionsItemSelected (item);
    }
}
