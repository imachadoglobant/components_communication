package com.globant.android.training.communication;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.globant.android.training.communication.databinding.FragmentChildBinding;

public class ChildFragment extends Fragment {

  public interface MyFragmentDelegate {

    void onMyFragmentButtonClicked();

  }

  private MyFragmentDelegate delegate;

  @Override
  public void onAttach(@NonNull Context context) {
    super.onAttach(context);
    if (context instanceof MyFragmentDelegate) {
      delegate = (MyFragmentDelegate) context;
    }
  }

  @Nullable
  @Override
  public View onCreateView(
      @NonNull LayoutInflater inflater,
      @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    FragmentChildBinding binding = FragmentChildBinding.inflate(inflater, container, false);

    binding.buttonChildFragmentCta.setOnClickListener(view -> delegate.onMyFragmentButtonClicked());

    return binding.getRoot();
  }

}
