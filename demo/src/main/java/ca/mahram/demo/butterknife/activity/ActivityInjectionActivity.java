package ca.mahram.demo.butterknife.activity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnCheckedChanged;
import butterknife.OnClick;
import butterknife.OnFocusChange;
import ca.mahram.demo.butterknife.R;
import ca.mahram.demo.butterknife.activity.base.BaseDemoActivity;

/**
 Created by mahram on 15-03-04.
 */
public class ActivityInjectionActivity
  extends BaseDemoActivity {

    @InjectView (R.id.header_image)  ImageView header;
    @InjectView (R.id.click_counter) TextView  clickCounter;
    @InjectView (R.id.focus_check)   CheckBox  focusCheck;
    @InjectView (R.id.focus_text)    TextView  focusText;

    private int tapCount = 0;

    @Override protected void onCreate (final Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_injection);
        ButterKnife.inject (this);

        header.setImageResource (R.drawable.big_buttery_header);
    }

    @OnClick (R.id.left) public void onTap () {
        registerTap ();
    }

    @OnClick (R.id.right) public void onTap (final Button button) {
        registerTap ();
    }

    private void registerTap () {
        tapCount++;
        clickCounter.setText (getResources ().getQuantityString (R.plurals.tapped_d_times, tapCount, tapCount));
    }

    @OnFocusChange (R.id.input_edit) public void inputEditFocusChanged (final boolean hasFocus) {
        focusCheck.setChecked (hasFocus);
    }

    @OnCheckedChanged (R.id.focus_check) public void onFocusCheckChanged (final boolean isChecked) {
        focusText.setText ( isChecked ? R.string.input_has_focus : R.string.input_no_focus);
    }
}
