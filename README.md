# MaskedEditText

![Install the app to check image](https://user-images.githubusercontent.com/42740495/47081704-db9daf00-d224-11e8-8a60-92a0b2f8da48.jpeg)

### Usage

##### Gradle

    dependencies {
        implementation 'com.snapps.etlib:etlib:1.0'
    }
##### XML

    <?xml version="1.0" encoding="utf-8"?>
    <RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        xmlns:mask="http://schemas.android.com/apk/res-auto">
    
    <com.snapps.etlib.MaskedEditText
        android:id="@+id/editText"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_alignParentStart="true"
        android:layout_alignParentTop="true"
        android:hint="12345-6789000-1"
        mask:mask="#####-#######-#
        android:inputType="number"
         />
    </RelativeLayout>
    
Consider the below two lines for adding the masking functionality
```
xmlns:mask="http://schemas.android.com/apk/res-auto"

mask:mask="#####-#######-#"

```

**#** sign is the placeholder of the input to be placed.


### CopyRights

    Copyright 2018 Naila Nawaz

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at
       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
