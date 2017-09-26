package com.reactnativenavigation.views;

import android.app.Activity;
import android.graphics.Typeface;
import android.support.annotation.ColorInt;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class TopBar extends AppBarLayout {
	private final Toolbar titleBar;

	public TopBar(final Activity context) {
		super(context);
		titleBar = new Toolbar(context);
		addView(titleBar);
	}

	public void setTitle(String title) {
		titleBar.setTitle(title);
	}

	public String getTitle() {
		return titleBar.getTitle() != null ? titleBar.getTitle().toString() : "";
	}

	public void setTitleTextColor(@ColorInt int color) {
		titleBar.setTitleTextColor(color);
	}

	public void setTitleFontSize(float size) {
		TextView titleTextView = getTitleTextView();
		if (titleTextView != null) {
			titleTextView.setTextSize(size);
		}
	}

	public void setTitleTypeface(Typeface typeface) {
		TextView titleTextView = getTitleTextView();
		if (titleTextView != null) {
			titleTextView.setTypeface(typeface);
		}
	}

	public TextView getTitleTextView() {
		return findTextView(titleBar);
	}

	public void setTopBarHidden(boolean hidden) {
		setVisibility(hidden ? GONE : VISIBLE);
	}

	@Nullable
	private TextView findTextView(ViewGroup root) {
		for (int i = 0; i < root.getChildCount(); i++) {
			View view = root.getChildAt(i);
			if (view instanceof TextView) {
				return (TextView) view;
			}
			if (view instanceof ViewGroup) {
				return findTextView((ViewGroup) view);
			}
		}
		return null;
	}
}
