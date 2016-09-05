SuperIndicator
===============
a superindicatorlibray for viewpager, banner

## Features:
- 仿爱奇艺视频，腾讯视频，搜狐视频首页推荐位轮播图
- 专业轮播图库，没有之一
- 也可以应用于广告位banner
- 支持无限循环（4->5，5->1），可以自己设定点的样试
- 图片支持设置圆角边
- 只需要几行代码就能写了banner图
- 新增自动轮播，无须手触摸控制，如果设置LooperViewPager.setLoopPic(true) ---- 2016/8/28
- 修复在scrollview左右滑动和上下冲突问题 ---- 2016/9/5


效果图
------------
![SuperIndicator](/image/SuperIndicator.gif)

1.0.3 版本效果,fix issue:在scrollview左右滑动和上下冲突问题
------------
![SuperIndicator](/image/device-2016-09-05-162915.gif)


爱奇艺视频，腾讯视频，搜狐视频首页推荐位轮播图
------------
![SuperIndicator](/image/iqiyi.png) ![SuperIndicator](/image/sohu.png) ![SuperIndicator](/image/tencent.png)

## Import
------------

####Gradle
```groovy
dependencies {
   compile 'com.hejunlin.superindicatorlibray:superindicatorlibray:1.0.2'
}
```
####Maven
```groovy
<dependency>
  <groupId>com.hejunlin.superindicatorlibray</groupId>
  <artifactId>superindicatorlibray</artifactId>
  <version>1.0.2</version>
  <type>pom</type>
</dependency>
```

Usage
--------
```xml
<com.hejunlin.superindicatorlibray.CircleIndicator
    android:id="@id/indicator"
    android:layout_width="match_parent"
    android:layout_height="48dp"
    android:layout_gravity="right|center_vertical"
    android:layout_marginRight="@dimen/dimen_14dp"
    android:gravity="center"
    android:orientation="horizontal"/>
```
```xml
<com.hejunlin.superindicatorlibray.LoopViewPager
    android:id="@+id/viewpager"
    android:layout_width="match_parent"
    android:layout_marginTop="@dimen/dimen_25dp"
    android:layout_height="@dimen/dimen_400dp"/>
```
Java代码中
```java
    ViewPager viewpager = (ViewPager) view.findViewById(R.id.viewpager);
    CircleIndicator indicator = (CircleIndicator) view.findViewById(R.id.indicator);
    viewpager.setAdapter(mPageAdapter);
    viewpager.setLooperPic(true);//是否设置自动轮播
    indicator.setViewPager(viewpager);
```



####欢迎关注我的个人公众号，android 技术干货，问题深度总结，FrameWork源码解析，插件化研究，最新开源项目推荐
![这里写图片描述](https://github.com/hejunlin2013/RedPackage/blob/master/image/qrcode.jpg)

License
--------
```
Copyright (C) 2016 hejunlin

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```