package com.hf.energy.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

public class DuplicateParentStateAwareLinearLayout extends LinearLayout {

    public DuplicateParentStateAwareLinearLayout(Context context) {
        super(context);
    }
    
    public DuplicateParentStateAwareLinearLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

     @Override
     protected void  dispatchSetPressed(boolean pressed) {
          for (int i = 0; i < getChildCount(); i++) {
             View child = getChildAt(i);
             if (child.isDuplicateParentStateEnabled()){
                 getChildAt(i).setPressed(pressed);
             }
         }
      }
}
