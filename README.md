# CustomViews
This repository contains different types of CustomViews we can create in Android Application Development.
I have also implemented Google Analytics.

- Check out the APK [here](https://appetize.io/app/2fcng57f0ng55x7e1dahzgay7m)

### Home Page:
![Main](https://github.com/activesince93/CustomViews/blob/master/screenshots/main.png)

### TextView:
```sh
<active.since93.librery.textview.CustomTextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_margin="@dimen/text_padding"
        android:gravity="center"
        android:text="@string/text"
        android:textSize="@dimen/text_size"
        customtextview:typeface="Roboto-Light.ttf" />
```
**Custom Scrolling TextView**
```sh
<active.since93.librery.textview.ScrollingTextView
                android:id="@+id/scrollTextView"
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:layout_margin="@dimen/text_padding"
                android:singleLine="true"
                android:text="@string/text_text"
                android:textSize="@dimen/text_size"
                customtextview:scrollType="ifLengthExceeds"
                customtextview:typeface="Almost_Japanese_Smooth.ttf" />
```
![TextView](https://github.com/activesince93/CustomViews/blob/master/screenshots/textview.gif)

### Button:
**Custom Button**
```sh
<active.since93.librery.button.CustomButton
        android:id="@+id/customButton"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        custombutton:text="Custom Button"
        custombutton:text_color="@color/colorPrimary"
        custombutton:text_size="10dp" />
```

**Ripple Button**
```sh
<active.since93.librery.button.ButtonRectangle
        android:id="@+id/customRippleButton"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_centerInParent="true"
        android:background="#1E88E5"
        android:text="Button" />
```
![Button](https://github.com/activesince93/CustomViews/blob/master/screenshots/button.png)

### ImageView:
```sh
<active.since93.librery.imageview.CircleImageView
        android:layout_width="100dp"
        android:layout_height="100dp"
        android:src="@drawable/lauren" />
```
![ImageView](https://github.com/activesince93/CustomViews/blob/master/screenshots/imageview.png)

### EditText:
```sh
<active.since93.librery.edittext.CustomEditText
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_margin="5dp"
        android:text="This is custom EditText."
        customedittext:typeface="androidnation.ttf" />
```
![EditText](https://github.com/activesince93/CustomViews/blob/master/screenshots/edittext.png)

### ChipView:
```sh
<active.since93.librery.chipview.ChipView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_margin="5dp"
        chipview:background_color="@color/colorAccent"
        chipview:show_image="false"
        chipview:chip_text="text" />
```
![ChipView](https://github.com/activesince93/CustomViews/blob/master/screenshots/chipview.png)

**Add the following line to your build.gradle dependencies:**
```sh
compile project(':library')
```
