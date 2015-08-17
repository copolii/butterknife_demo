package ca.mahram.demo.butterknife.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.ButterKnife;
import butterknife.Bind;
import butterknife.OnCheckedChanged;
import butterknife.OnClick;
import butterknife.OnFocusChange;
import ca.mahram.demo.butterknife.R;

/**
 Created by mahram on 15-03-04.
 */
public class BindingFragment
  extends Fragment {
    @Bind (R.id.header_image)  ImageView header;
    @Bind (R.id.click_counter) TextView  clickCounter;
    @Bind (R.id.focus_check)   CheckBox  focusCheck;
    @Bind (R.id.focus_text)    TextView  focusText;

    private int tapCount = 0;

    @Nullable @Override public View onCreateView (final LayoutInflater inflater,
                                                  final ViewGroup container,
                                                  final Bundle savedInstanceState) {
        return inflater.inflate (R.layout.activity_binding, container, false);
    }

    @Override public void onViewCreated (final View view, final Bundle savedInstanceState) {
        super.onViewCreated (view, savedInstanceState);
        ButterKnife.bind (this, view);
        header.setImageResource (R.drawable.big_buttery_header);
    }

    @Override public void onDestroyView () {
        super.onDestroyView ();
        ButterKnife.unbind (this);
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
