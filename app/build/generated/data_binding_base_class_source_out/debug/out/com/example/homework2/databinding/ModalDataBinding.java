// Generated by view binder compiler. Do not edit!
package com.example.homework2.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.homework2.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ModalDataBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final TextView txModalFoodName;

  @NonNull
  public final TextView txModalFoodnums;

  @NonNull
  public final TextView txModalFoodprice;

  private ModalDataBinding(@NonNull LinearLayout rootView, @NonNull TextView txModalFoodName,
      @NonNull TextView txModalFoodnums, @NonNull TextView txModalFoodprice) {
    this.rootView = rootView;
    this.txModalFoodName = txModalFoodName;
    this.txModalFoodnums = txModalFoodnums;
    this.txModalFoodprice = txModalFoodprice;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ModalDataBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ModalDataBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.modal_data, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ModalDataBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.tx_modalFoodName;
      TextView txModalFoodName = ViewBindings.findChildViewById(rootView, id);
      if (txModalFoodName == null) {
        break missingId;
      }

      id = R.id.tx_modalFoodnums;
      TextView txModalFoodnums = ViewBindings.findChildViewById(rootView, id);
      if (txModalFoodnums == null) {
        break missingId;
      }

      id = R.id.tx_modalFoodprice;
      TextView txModalFoodprice = ViewBindings.findChildViewById(rootView, id);
      if (txModalFoodprice == null) {
        break missingId;
      }

      return new ModalDataBinding((LinearLayout) rootView, txModalFoodName, txModalFoodnums,
          txModalFoodprice);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
