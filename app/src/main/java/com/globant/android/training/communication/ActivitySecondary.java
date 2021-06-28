package com.globant.android.training.communication;

import static android.widget.Toast.LENGTH_SHORT;

import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.globant.android.training.communication.ChildFragment.MyFragmentDelegate;
import com.globant.android.training.communication.databinding.ActivitySecondaryBinding;

public class ActivitySecondary extends AppCompatActivity implements MyFragmentDelegate {

  public static final String VALUE_EXTRA = "VALUE_EXTRA";

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    ActivitySecondaryBinding binding = ActivitySecondaryBinding.inflate(getLayoutInflater());
    setContentView(binding.getRoot());

    String value = getIntent().getStringExtra(VALUE_EXTRA);
    binding.textSecondaryValue.setText(value);

    ChildFragment childFragment = new ChildFragment();

    getSupportFragmentManager()
        .beginTransaction()
        .replace(R.id.frame_secondary, childFragment)
        .commitNow();
  }

  @Override
  public void onMyFragmentButtonClicked() {
    Toast.makeText(this, "Child Fragment Button clicked", LENGTH_SHORT).show();
  }

}