一种背景可渐变的布局

![](https://github.com/lavalike/GradientLayout/blob/master/docs/images/gif.gif)

添加gradle依赖：
> compile 'com.wangzhen:GradientLayout:1.0.0'

属性值：
```xml
<declare-styleable name="GradientLayout">
    <attr name="fromColor" format="color" />
    <attr name="toColor" format="color" />
    <attr name="progress" format="float" />
</declare-styleable>
```

xml使用：
```xml
<com.wangzhen.gradientlayout.GradientLayout
        android:id="@+id/gradientLayout"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        app:fromColor="@color/colorPrimary"
        app:toColor="@color/colorAccent"
        app:progress="30">

    <TextView
        android:layout_width="wrap_content"
        android:layout_height="56dp"
        android:layout_marginLeft="18dp"
        android:fitsSystemWindows="true"
        android:gravity="center"
        android:text="@string/app_name"
        android:textColor="@android:color/white"
        android:textSize="20sp"
        android:textStyle="bold" />
    </RelativeLayout>
</com.wangzhen.gradientlayout.GradientLayout>
    
<SeekBar
    android:id="@+id/seekbar"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:layout_marginLeft="16dp"
    android:layout_marginRight="16dp"
    android:layout_marginTop="50dp"
    android:max="100"
    android:progress="20" />
```

Activity使用：
```java
gradientLayout = (GradientLayout) findViewById(R.id.gradientLayout);
//设置进度（0~100）
gradientLayout.setProgress(progress);
```