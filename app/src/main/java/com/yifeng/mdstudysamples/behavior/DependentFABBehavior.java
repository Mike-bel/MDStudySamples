package com.yifeng.mdstudysamples.behavior;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by yifeng on 16/9/20.
 *
 */
public class DependentFABBehavior extends CoordinatorLayout.Behavior {

    public DependentFABBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     * 判断依赖对象
     * @param parent
     * @param child
     * @param dependency
     * @return
     */
    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, View child, View dependency) {
        return dependency instanceof Snackbar.SnackbarLayout;
    }

    /**
     * 当依赖对象发生变化时,产生回调,自定义改变child view
     * @param parent
     * @param child
     * @param dependency
     * @return
     */
    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, View child, View dependency) {
        float translationY = Math.min(0, dependency.getTranslationY() - dependency.getHeight());
        child.setTranslationY(translationY);
        return true;
    }
}
