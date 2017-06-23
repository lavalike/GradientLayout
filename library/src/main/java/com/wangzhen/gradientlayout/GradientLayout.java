package com.wangzhen.gradientlayout;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.WindowInsets;
import android.widget.RelativeLayout;

/**
 * 渐变背景布局
 * Created by wangzhen on 2017/6/14.
 */
public class GradientLayout extends RelativeLayout {
    private int fromColor;
    private int toColor;
    private float progress;//0~100

    public GradientLayout(Context context) {
        this(context, null);
    }

    public GradientLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public GradientLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    private void init(AttributeSet attrs) {
        fromColor = ContextCompat.getColor(getContext(), android.R.color.transparent);
        toColor = ContextCompat.getColor(getContext(), android.R.color.white);

        TypedArray typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.GradientLayout);
        fromColor = typedArray.getColor(R.styleable.GradientLayout_fromColor, fromColor);
        toColor = typedArray.getColor(R.styleable.GradientLayout_toColor, toColor);
        progress = typedArray.getFloat(R.styleable.GradientLayout_progress, 0);
        progress = checkProgress(progress);
        typedArray.recycle();
        setProgress(progress);
    }

    /**
     * 根据进度进行颜色渐变 （0~100）
     *
     * @param progress 当前进度
     */
    public void setProgress(float progress) {
        progress = checkProgress(progress);
        this.progress = progress;
        setBackgroundColor(RGBColorTransform(progress * 1f / 100, fromColor, toColor));
    }

    /**
     * 校验范围
     *
     * @param progress 进度
     * @return 校验后的进度 0~100
     */
    private float checkProgress(float progress) {
        if (progress < 0) progress = 0;
        if (progress > 100) progress = 100;
        return progress;
    }

    /**
     * 颜色渐变
     *
     * @param progress  进度 0~1
     * @param fromColor 开始颜色(ARGB)
     * @param toColor   结束颜色(ARGB)
     * @return 变化后的颜色值(ARGB)
     */
    private int RGBColorTransform(float progress, int fromColor, int toColor) {
        int oa = (fromColor >> 24) & 0xFF;
        int or = (fromColor >> 16) & 0xFF;
        int og = (fromColor >> 8) & 0xFF;
        int ob = fromColor & 0xFF;

        int na = (toColor >> 24) & 0xFF;
        int nr = (toColor >> 16) & 0xFF;
        int ng = (toColor >> 8) & 0xFF;
        int nb = toColor & 0xFF;

        int aGap = (int) ((float) (na - oa) * progress);
        int rGap = (int) ((float) (nr - or) * progress);
        int gGap = (int) ((float) (ng - og) * progress);
        int bGap = (int) ((float) (nb - ob) * progress);

        return ((oa + aGap) << 24) | ((or + rGap) << 16) | ((og + gGap) << 8)
                | (ob + bGap);
    }

    @TargetApi(Build.VERSION_CODES.KITKAT_WATCH)
    @Override
    public WindowInsets dispatchApplyWindowInsets(WindowInsets insets) {
        if (insets != null) {
            insets = insets.replaceSystemWindowInsets(insets.getSystemWindowInsetLeft(),
                    insets.getSystemWindowInsetTop(),
                    insets.getSystemWindowInsetRight(),
                    0);
        }
        return super.dispatchApplyWindowInsets(insets);

    }

    @Override
    protected boolean fitSystemWindows(Rect insets) {
        if (insets != null) {
            insets.set(insets.left, insets.top, insets.right, 0);
        }
        return super.fitSystemWindows(insets);
    }
}
