package com.example.airgallery.utils

import android.text.TextWatcher
import android.view.View
import android.widget.AutoCompleteTextView
import android.widget.EditText
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.textfield.MaterialAutoCompleteTextView
import com.google.android.material.textfield.TextInputEditText


@BindingAdapter("adapter")
fun setAdapter(view: RecyclerView, adapter: RecyclerView.Adapter<*>) {
    view.adapter = adapter
}

@BindingAdapter("android:visibility")
fun setMutableVisibility(view: View, visibility: Boolean) {
    view.visibility = if (visibility) View.INVISIBLE else View.VISIBLE
}

@BindingAdapter("textChangedListener")
fun bindTextWatcher(editText: TextInputEditText, textWatcher: TextWatcher?) {
    editText.addTextChangedListener(textWatcher)
}

@BindingAdapter("textChangedWatcher")
fun bindAutoTextWatcher(editText: MaterialAutoCompleteTextView, textWatcher: TextWatcher?) {
    editText.addTextChangedListener(textWatcher)
}