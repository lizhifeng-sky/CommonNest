package android.com.test;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.NestedScrollingParent;
import android.support.v4.view.NestedScrollingParentHelper;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import org.jetbrains.annotations.NotNull;

public class NestParentLayout extends FrameLayout implements NestedScrollingParent {
    private NestedScrollingParentHelper mNestedScrollingParentHelper;

    public NestParentLayout(@NonNull Context context) {
        this(context, null);
    }

    public NestParentLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public NestParentLayout(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mNestedScrollingParentHelper = new NestedScrollingParentHelper(this);
    }

    public boolean isNestedAble(){
        return true;
    }

    //子类请求滑动
    @Override
    public boolean onStartNestedScroll(@NotNull View child, @NotNull View target, int nestedScrollAxes) {
        return true;
    }

    @Override
    public void onNestedScrollAccepted(@NotNull View child, @NotNull View target, int axes) {
        mNestedScrollingParentHelper.onNestedScrollAccepted(child, target, axes);
    }

    @Override
    public int getNestedScrollAxes() {
        return mNestedScrollingParentHelper.getNestedScrollAxes();
    }

    @Override
    public void onStopNestedScroll(@NotNull View child) {
        mNestedScrollingParentHelper.onStopNestedScroll(child);
    }

    @Override
    public void onNestedPreScroll(@NotNull View target, int dx, int dy, @NotNull int[] consumed) {
        if (dx>0){
            if (target.getRight()+dx>getWidth()){
                dx=dx+ target.getRight()-getWidth();//多出来的
                offsetLeftAndRight(dx);
                consumed[0]=consumed[0]+dx;//父亲消耗
            }
        }else {
            if (target.getLeft()+dx<0){
                dx=dx+ target.getLeft();
                offsetLeftAndRight(dx);
                consumed[0]=consumed[0]+dx;//父亲消耗
            }
        }


        if (dy>0){
            if (target.getBottom()+dy>getHeight()){
                dy=dy+ target.getBottom()-getHeight();
                offsetTopAndBottom(dy);
                consumed[1]=consumed[1]+dy;
            }
        }else {
            if (target.getTop()+dy<0){
                dy=dy+ target.getTop();
                offsetTopAndBottom(dy);
                consumed[1]=consumed[1]+dy;
            }
        }


    }
}
