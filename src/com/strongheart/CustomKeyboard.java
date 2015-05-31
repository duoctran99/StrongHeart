package com.strongheart;

import com.strongheart.R;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.inputmethodservice.Keyboard;
import android.inputmethodservice.KeyboardView;
import android.inputmethodservice.KeyboardView.OnKeyboardActionListener;
import android.text.Editable;
import android.text.InputType;
import android.text.Spanned;
import android.text.style.ImageSpan;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnTouchListener;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

class CustomKeyboard {

	/** A link to the KeyboardView that is used to render this CustomKeyboard. */
	private KeyboardView mKeyboardView;
	/** A link to the activity that hosts the {@link #mKeyboardView}. */
	private Activity mHostActivity;
	private EmoticonHandler mEmoticonHandler;
	EditText editText;
	int layoutId;

	/** The key (code) handler. */
	private OnKeyboardActionListener mOnKeyboardActionListener = new OnKeyboardActionListener() {

		public final static int CodeDelete = -5; // Keyboard.KEYCODE_DELETE

		@Override
		public void onKey(int primaryCode, int[] keyCodes) {
			View focusCurrent = mHostActivity.getWindow().getCurrentFocus();
			if (focusCurrent == null
					|| focusCurrent.getClass() != EditText.class)
				return;
			EditText edittext = (EditText) focusCurrent;
			Editable editable = edittext.getText();
			int start = edittext.getSelectionStart();
			if (primaryCode == CodeDelete) {
				if (editable != null && start > 0)
					editable.delete(start - 1, start);
			} else if (primaryCode == 113) {
				mEmoticonHandler.insert("q", R.drawable.q);
			} else if (primaryCode == 119) {
				mEmoticonHandler.insert("w", R.drawable.w);
			} else if (primaryCode == 101) {
				mEmoticonHandler.insert("e", R.drawable.e);
			} else if (primaryCode == 114) {
				mEmoticonHandler.insert("r", R.drawable.r);
			} else if (primaryCode == 116) {
				mEmoticonHandler.insert("t", R.drawable.t);
			} else if (primaryCode == 121) {
				mEmoticonHandler.insert("y", R.drawable.y);
			} else if (primaryCode == 113) {
				mEmoticonHandler.insert("q", R.drawable.q);
			} else if (primaryCode == 117) {
				mEmoticonHandler.insert("u", R.drawable.u);
			} else if (primaryCode == 105) {
				mEmoticonHandler.insert("i", R.drawable.i);
			} else if (primaryCode == 113) {
				mEmoticonHandler.insert("q", R.drawable.q);
			} else if (primaryCode == 111) {
				mEmoticonHandler.insert("o", R.drawable.o);
			} else if (primaryCode == 112) {
				mEmoticonHandler.insert("p", R.drawable.p);
			} else if (primaryCode == 97) {
				mEmoticonHandler.insert("a", R.drawable.a);
			} else if (primaryCode == 115) {
				mEmoticonHandler.insert("s", R.drawable.s);
			} else if (primaryCode == 100) {
				mEmoticonHandler.insert("d", R.drawable.d);
			} else if (primaryCode == 102) {
				mEmoticonHandler.insert("f", R.drawable.f);
			} else if (primaryCode == 103) {
				mEmoticonHandler.insert("g", R.drawable.g);
			} else if (primaryCode == 104) {
				mEmoticonHandler.insert("h", R.drawable.h);
			} else if (primaryCode == 106) {
				mEmoticonHandler.insert("j", R.drawable.j);
			} else if (primaryCode == 107) {
				mEmoticonHandler.insert("k", R.drawable.k);
			} else if (primaryCode == 108) {
				mEmoticonHandler.insert("l", R.drawable.l);
			} else if (primaryCode == 122) {
				mEmoticonHandler.insert("z", R.drawable.z);
			} else if (primaryCode == 120) {
				mEmoticonHandler.insert("x", R.drawable.x);
			} else if (primaryCode == 99) {
				mEmoticonHandler.insert("c", R.drawable.c);
			} else if (primaryCode == 118) {
				mEmoticonHandler.insert("v", R.drawable.v);
			} else if (primaryCode == 98) {
				mEmoticonHandler.insert("b", R.drawable.b);
			} else if (primaryCode == 110) {
				mEmoticonHandler.insert("n", R.drawable.n);
			} else if (primaryCode == 109) {
				mEmoticonHandler.insert("m", R.drawable.m);
			} else if (primaryCode == 32) {
				editable.insert(start, Character.toString((char) primaryCode));
			} else if (primaryCode == 10) {
				editable.insert(start, Character.toString((char) primaryCode));
			} else if (primaryCode == 46) {
				editable.insert(start, Character.toString((char) primaryCode));
			} else if (primaryCode == -2) {
				layoutId = R.xml.hexkbd;
				mKeyboardView
						.setKeyboard(new Keyboard(mHostActivity, layoutId));
				mKeyboardView
						.setOnKeyboardActionListener(mOnKeyboardActionListener);
			} else if (primaryCode == 200) {
				layoutId = R.xml.qwerty;
				mKeyboardView
						.setKeyboard(new Keyboard(mHostActivity, layoutId));
				mKeyboardView
						.setOnKeyboardActionListener(mOnKeyboardActionListener);
			} else if (primaryCode == 55) {
				mEmoticonHandler.insert("7", R.drawable.bay);
			} else if (primaryCode == 56) {
				mEmoticonHandler.insert("8", R.drawable.tam);
			} else if (primaryCode == 57) {
				mEmoticonHandler.insert("9", R.drawable.chin);
			} else if (primaryCode == 52) {
				mEmoticonHandler.insert("4", R.drawable.bon);
			} else if (primaryCode == 53) {
				mEmoticonHandler.insert("5", R.drawable.nam);
			} else if (primaryCode == 54) {
				mEmoticonHandler.insert("6", R.drawable.sau);
			} else if (primaryCode == 49) {
				mEmoticonHandler.insert("1", R.drawable.mot);
			} else if (primaryCode == 50) {
				mEmoticonHandler.insert("2", R.drawable.hai);
			} else if (primaryCode == 51) {
				mEmoticonHandler.insert("3", R.drawable.ba);
			} else if (primaryCode == 48) {
				mEmoticonHandler.insert("0", R.drawable.khong);
			}
			/*
			 * else { // insert character editable.insert(start,
			 * Character.toString((char) primaryCode)); }
			 */
		}

		@Override
		public void onPress(int arg0) {
		}

		@Override
		public void onRelease(int primaryCode) {
		}

		@Override
		public void onText(CharSequence text) {
		}

		@Override
		public void swipeDown() {
		}

		@Override
		public void swipeLeft() {
		}

		@Override
		public void swipeRight() {
		}

		@Override
		public void swipeUp() {
		}
	};

	public CustomKeyboard(Activity host, EditText view, int layoutid) {
		mHostActivity = host;
		editText = view;
		layoutId = layoutid;
		int viewid = R.id.keyboardview;
		mKeyboardView = (KeyboardView) mHostActivity.findViewById(viewid);
		editText.setTextSize(5);
		mEmoticonHandler = new EmoticonHandler(editText);
		
		mKeyboardView.setKeyboard(new Keyboard(mHostActivity, layoutId));
		mKeyboardView.setPreviewEnabled(false); // NOTE Do not show the preview
												// balloons
		mKeyboardView.setOnKeyboardActionListener(mOnKeyboardActionListener);
		// Hide the standard keyboard initially
		mHostActivity.getWindow().setSoftInputMode(
				WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
	}

	/** Returns whether the CustomKeyboard is visible. */
	public boolean isCustomKeyboardVisible() {
		return mKeyboardView.getVisibility() == View.VISIBLE;
	}

	/**
	 * Make the CustomKeyboard visible, and hide the system keyboard for view v.
	 */
	public void showCustomKeyboard(View v) {
		mKeyboardView.setVisibility(View.VISIBLE);
		mKeyboardView.setEnabled(true);
		if (v != null)
			((InputMethodManager) mHostActivity
					.getSystemService(Activity.INPUT_METHOD_SERVICE))
					.hideSoftInputFromWindow(v.getWindowToken(), 0);
	}

	/** Make the CustomKeyboard invisible. */
	public void hideCustomKeyboard() {
		mKeyboardView.setVisibility(View.VISIBLE);
		mKeyboardView.setEnabled(true);
	}

	public void registerEditText(int resid) {
		// Find the EditText 'resid'
		EditText edittext = (EditText) mHostActivity.findViewById(resid);
		// Make the custom keyboard appear
		edittext.setOnFocusChangeListener(new OnFocusChangeListener() {
			// NOTE By setting the on focus listener, we can show the custom
			// keyboard when the edit box gets focus, but also hide it when the
			// edit box loses focus
			@Override
			public void onFocusChange(View v, boolean hasFocus) {
				if (hasFocus)
					showCustomKeyboard(v);
				else
					hideCustomKeyboard();
			}
		});
		edittext.setOnClickListener(new OnClickListener() {
			// NOTE By setting the on click listener, we can show the custom
			// keyboard again, by tapping on an edit box that already had focus
			// (but that had the keyboard hidden).
			@Override
			public void onClick(View v) {
				showCustomKeyboard(v);
			}
		});
		// Disable standard keyboard hard way
		// NOTE There is also an easy way:
		// 'edittext.setInputType(InputType.TYPE_NULL)' (but you will not have a
		// cursor, and no 'edittext.setCursorVisible(true)' doesn't work )
		edittext.setOnTouchListener(new OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				EditText edittext = (EditText) v;
				int inType = edittext.getInputType(); // Backup the input type
				edittext.setInputType(InputType.TYPE_NULL); // Disable standard
															// keyboard
				edittext.onTouchEvent(event); // Call native handler
				edittext.setInputType(inType); // Restore input type
				return true; // Consume touch event
			}
		});
		// Disable spell check (hex strings look like words to Android)
		edittext.setInputType(edittext.getInputType()
				| InputType.TYPE_TEXT_FLAG_NO_SUGGESTIONS);
	}

	private static class EmoticonHandler {

		private final EditText mEditor;
		public EmoticonHandler(EditText editor) {
			// Attach the handler to listen for text changes.
			mEditor = editor;
			// mEditor.addTextChangedListener(this);
		}

		public void insert(String emoticon, int resource) {
			// Create the ImageSpan
			Drawable drawable = mEditor.getResources().getDrawable(resource);
			drawable.setBounds(0, 0, drawable.getIntrinsicWidth(),
					drawable.getIntrinsicHeight());
			ImageSpan span = new ImageSpan(drawable, ImageSpan.ALIGN_BASELINE);

			// Get the selected text.
			int start = mEditor.getSelectionStart();
			int end = mEditor.getSelectionEnd();
			Editable message = mEditor.getEditableText();

			// Insert the emoticon.
			message.replace(start, end, emoticon);
			message.setSpan(span, start, start + emoticon.length(),
					Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
		}
	}

}
