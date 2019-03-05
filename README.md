# PersianDialog
PersianDialog for Android,Very attractive with plenty of access

# ScreenShot
![](PersianDialog.gif)

# Setup
The simplest way to use PersianDialog is to add the library as aar dependency to your build <br /> <br />
[![](https://jitpack.io/v/mahmoodkarimizade/PersianDialog.svg)](https://jitpack.io/#mahmoodkarimizade/PersianDialog)

**Gradle**
1. Add the JitPack repository to your build file <br /> <br />
<pre>allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}</pre>
2. Add the dependency <br />
<pre>dependencies {
  implementation 'com.github.mahmoodkarimizade:PersianDialog:1.0.0'
	}</pre>
  
# Usage
- define true and false dialog (question dialog)
<pre>
trueFalseDialog=new TrueFalseDialog(this);
trueFalseDialog.message.setText("Your Question ?");
trueFalseDialog.tFalse.setText("Cancel");
trueFalseDialog.tTrue.setText("OK");
trueFalseDialog.iFalse.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {

        //do some thing
        trueFalseDialog.dialog.dismiss();
    }
});
trueFalseDialog.iTrue.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {

        //do some thing
        trueFalseDialog.dialog.dismiss();
    }
});
</pre>

- define message dialog
<pre>
messageDialog=new MessageDialog(this);
messageDialog.message.setText("Your Message !");
messageDialog.tOK.setText("OK");
messageDialog.iOK.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {

        //do some thing
        messageDialog.dialog.dismiss();
    }
});
</pre>

- define check network dialog (wifi dialog)
<pre>
checkNetWorkDialog=new CheckNetWorkDialog(this);
checkNetWorkDialog.message.setText("Plz check your network and try again!");
checkNetWorkDialog.tWifi.setText("OK");
checkNetWorkDialog.iWifi.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {

        //do some thing
        checkNetWorkDialog.dialog.dismiss();
    }
});
</pre>

- define select image Dialog
<pre>
selectImageDialog=new SelectImageDialog(this);
selectImageDialog.message.setText("plz select your image!");
selectImageDialog.tCamera.setText("Camera");
selectImageDialog.tGallery.setText("Gallery");
selectImageDialog.iCamera.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {

        //do some thing
        selectImageDialog.dialog.dismiss();
    }
});
selectImageDialog.iCamera.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {

        //do some thing
        selectImageDialog.dialog.dismiss();
    }
});
</pre>

# License
[MIT License](License.txt)
<pre>
Copyright (c) 2019 Mahmood Karimizade

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
</pre>

