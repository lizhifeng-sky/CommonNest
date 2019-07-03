package android.com.test;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.view.NestedScrollingChild;
import android.support.v4.view.NestedScrollingChildHelper;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class NestChildView extends View implements NestedScrollingChild {
    private float mLastX;
    private float mLastY;

    private float mDownX;
    private float mDownY;

    private int [] consumed=new int[2];//消耗的距离
    private int [] offsetInWindow=new int[2];//窗口偏移

    private NestedScrollingChildHelper mScrollingChildHelper;
    public NestChildView(Context context) {
        this(context,null);
    }

    public NestChildView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public NestChildView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mScrollingChildHelper=new NestedScrollingChildHelper(this);
        setNestedScrollingEnabled(true);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x=event.getX();
        float y=event.getY();
        int action=event.getAction();
        switch (action){
            case MotionEvent.ACTION_DOWN:{
                mDownX=x;
                mDownY=y;

                mLastX=x;
                mLastY=y;
                //当开始滑动的时候，告诉父view
                startNestedScroll(ViewCompat.SCROLL_AXIS_HORIZONTAL|ViewCompat.SCROLL_AXIS_VERTICAL);
                break;
            }
            case MotionEvent.ACTION_MOVE:{
                int dx= (int) (x-mDownX);
                int dy= (int) (y-mDownY);

                //分发触屏事件给父类处理
                if(dispatchNestedPreScroll(dx,dy,consumed,offsetInWindow)){
                    dx=dx-consumed[0];
                    dy=dy-consumed[1];
                }
                offsetTopAndBottom(dy);
                offsetLeftAndRight(dx);
                break;
            }
            case MotionEvent.ACTION_UP:{
                stopNestedScroll();
                break;
            }
        }
        mLastX=x;
        mLastY=y;
        return true;
    }

    @Override
    public void setNestedScrollingEnabled(boolean enabled) {
        mScrollingChildHelper.setNestedScrollingEnabled(enabled);
    }

    @Override
    public boolean isNestedScrollingEnabled() {
        return mScrollingChildHelper.isNestedScrollingEnabled();
    }

    @Override
    public boolean startNestedScroll(int axes) {
        return mScrollingChildHelper.startNestedScroll(axes);
    }

    @Override
    public void stopNestedScroll() {
        mScrollingChildHelper.stopNestedScroll();
    }

    @Override
    public boolean hasNestedScrollingParent() {
        return mScrollingChildHelper.hasNestedScrollingParent();
    }

    @Override
    public boolean dispatchNestedScroll(int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed,
                                        @Nullable int[] offsetInWindow) {
        return mScrollingChildHelper.dispatchNestedScroll(dxConsumed,dyConsumed,dxUnconsumed,dyUnconsumed,offsetInWindow);
    }

    @Override
    public boolean dispatchNestedPreScroll(int dx, int dy,
                                           @Nullable int[] consumed,
                                           @Nullable int[] offsetInWindow) {
        return mScrollingChildHelper.dispatchNestedPreScroll(dx, dy, consumed, offsetInWindow);
    }

    @Override
    public boolean dispatchNestedFling(float velocityX, float velocityY, boolean consumed) {
        return mScrollingChildHelper.dispatchNestedFling(velocityX, velocityY, consumed);
    }

    @Override
    public boolean dispatchNestedPreFling(float velocityX, float velocityY) {
        return mScrollingChildHelper.dispatchNestedPreFling(velocityX, velocityY);
    }
}
