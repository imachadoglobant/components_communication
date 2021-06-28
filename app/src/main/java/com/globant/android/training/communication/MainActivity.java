package com.globant.android.training.communication;

import static com.globant.android.training.communication.ActivitySecondary.VALUE_EXTRA;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    findViewById(R.id.button_send).setOnClickListener(v -> {
      EditText textView = findViewById(R.id.edit_text_field);
      String value = textView.getText().toString();

      Intent intent = new Intent(this, ActivitySecondary.class);
      intent.putExtra(VALUE_EXTRA, value);
      startActivity(intent);
    });
  }
}