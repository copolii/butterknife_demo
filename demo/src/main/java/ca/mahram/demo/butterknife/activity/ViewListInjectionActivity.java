package ca.mahram.demo.butterknife.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import java.util.Locale;

import butterknife.ButterKnife;
import butterknife.Bind;
import butterknife.OnCheckedChanged;
import butterknife.OnClick;
import ca.mahram.demo.butterknife.R;
import ca.mahram.demo.butterknife.activity.base.BaseDemoActivity;

/**
 Created by mahram on 15-03-04.
 */
public class ViewListInjectionActivity
  extends BaseDemoActivity
  implements SeekBar.OnSeekBarChangeListener {

    @Bind ( {R.id.image_1, R.id.image_2, R.id.image_3, R.id.image_4, R.id.image_5, R.id.image_6})
    List<ImageView> images;

    @Bind ({R.id.button_1, R.id.button_2, R.id.button_3, R.id.button_4, R.id.button_5, R.id.button_6})
    List<Button> buttons;

    @Bind (R.id.alpha_seeker) SeekBar  alphaSeeker;
    @Bind (R.id.alpha_value)  TextView alphaValue;

    @Override protected void onCreate (final Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_viewlist_injection);
        ButterKnife.bind (this);

        alphaSeeker.setOnSeekBarChangeListener (this);
        alphaSeeker.setProgress (alphaSeeker.getMax ());
    }

    @OnClick ( {R.id.button_1, R.id.button_2, R.id.button_3, R.id.button_4, R.id.button_5, R.id.button_6})
    public void onButtonClicked (final Button button) {
        Toast.makeText (this, button.getText (), Toast.LENGTH_SHORT).show ();
    }

    @Override public void onProgressChanged (final SeekBar seekBar, final int progress, final boolean fromUser) {
        final float alpha = (float) progress / (float) seekBar.getMax ();

        alphaValue.setText (String.format (Locale.ENGLISH, "%d%%", (int)(alpha * 100f)));

        ButterKnife.apply (images, View.ALPHA, alpha);
    }

    @OnCheckedChanged (R.id.checkbox) public void onCheckChanged (final boolean ischecked) {
        ButterKnife.apply (buttons, ischecked ? SHOW : HIDE);
    }

    static final ButterKnife.Action <View> SHOW = new ButterKnife.Action<View> () {
        @Override public void apply (final View view, final int index) {
            view.setVisibility (View.VISIBLE);
        }
    };

    static final ButterKnife.Action <View> HIDE = new ButterKnife.Action<View> () {
        @Override public void apply (final View view, final int index) {
            view.setVisibility (View.INVISIBLE);
        }
    };

    @Override public void onStartTrackingTouch (final SeekBar seekBar) { /* Dang boilerplate */ }

    @Override public void onStopTrackingTouch (final SeekBar seekBar) { /* Dang boilerplate */ }
}
