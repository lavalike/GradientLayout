# gradient-layout
> 渐变背景布局

[![Platform](https://img.shields.io/badge/Platform-Android-00CC00.svg?style=flat)](https://www.android.com)
[![](https://jitpack.io/v/lavalike/sequence-controller.svg)](https://jitpack.io/#lavalike/sequence-controller)


### 依赖导入

项目根目录

``` gradle
allprojects {
	repositories {
		...
		maven { url 'https://jitpack.io' }
	}
}
```

模块目录

``` gradle
dependencies {
	implementation 'com.github.lavalike:GradientLayout:0.0.1'
}
```

### 属性说明

``` xml
<declare-styleable name="GradientLayout">
    <attr name="fromColor" format="color" />
    <attr name="toColor" format="color" />
    <attr name="progress" format="float" />
</declare-styleable>
```

### 代码示例

``` java
GradientLayout gradientLayout = (GradientLayout) findViewById(R.id.gradientLayout);
gradientLayout.setProgress(10);
```

### 效果
![](https://tva1.sinaimg.cn/large/007S8ZIlgy1gjvrzm49rgg30ad0iitiu.gif)
