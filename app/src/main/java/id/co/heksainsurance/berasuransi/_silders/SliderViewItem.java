package id.co.heksainsurance.berasuransi._silders;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Scroller;

import java.lang.reflect.Field;

public class SliderViewItem extends ViewPager {

    public static final int DEFAULT_SCROLL_DURATION = 200;
//    public static final int SLIDE_MODE_SCROLL_DURATION = 1000;

    public SliderViewItem(Context context) {
        super(context);
        init();
    }

    public SliderViewItem(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {

        this.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return true;
            }
        });
    }


    public class OwnScroller extends Scroller {

        private int durationScrollMillis = 1;

        public OwnScroller(Context context, int durationScroll) {
            super(context, new DecelerateInterpolator());
            this.durationScrollMillis = durationScroll;
        }

        @Override
        public void startScroll(int startX, int startY, int dx, int dy, int duration) {
            super.startScroll(startX, startY, dx, dy, durationScrollMillis);
        }
    }
}
