Dependencies are basically using other people’s code in order to make our lives easier, make cooler projects faster, and essentially act like building blocks to making a  better app. They can do anything from access Twitter user data, to making fragment management easier. Some are used in every project people every make, and some are more for fun one off projects. 

Timber: used for advanced logging

ThreeTen: used to easily format dates and times

How to add a new dependency and sync with Gradle:



1. Open build.gradle (Module:app) file.
2. Add the following line with your module name
3. implementation 'com.jakewharton.threetenabp:threetenabp:1.2.2'

    It should look something like this:



![alt_text](https://www.dropbox.com/s/tp00t755t26bho8/image2.png?raw=1 "image_tooltip")


4. After this Android Studio would start saying “gradle files have changed since last project sync”, press the “sync now” link to start a sync. We do this to ensure that our project downloads the dependency. During each sync, Gradle will look at this file and decide if it needs to download or change anything. 

We then initialize the library

![alt_text](https://www.dropbox.com/s/peak5xivhqsz4n6/image6.png?raw=1 "image_tooltip")


Then we can use it!

Add this part to your onCreate Method. 

![alt_text](https://www.dropbox.com/s/c0zf8zgkmxe3u34/image1.png?raw=1 "image_tooltip")


/* Current DateTime */

LocalDateTime.now()

/* String to DateTime */

        val localDateTimeString = "2011-12-03T10:15:30"

       val localDateTime = LocalDateTime.parse(localDateTimeString)

Next we copy in the next dependency:

Copy the Timber dependency line into it:



![alt_text](https://www.dropbox.com/s/5ku1unkr4y4amz9/image3.png?raw=1 "image_tooltip")


implementation **'com.jakewharton.timber:timber:4.7.1'**

To initialize Timber, we have to use a special class called the Application activity of Android. This class essentially acts as the “manager” activity of our app. It runs before our other activities, and must be defined in our AndroidManifest.xml file so our app knows which activity is our Application activity. Some libraries have to be initialized this way, as they have to be initialized before everything else. All the activities can share initialization, thus its more efficient. 



![alt_text](https://www.dropbox.com/s/e2xpruvjzulkurz/image5.png?raw=1 "image_tooltip")


package com.example.proj

import android.app.Application

import timber.log.Timber

class Application : Application() {

   // Called when the application is starting, before any other application objects have been created._

   // Overriding this method is totally optional!_

   override fun onCreate() {

       super.onCreate()

       Timber.plant(Timber.DebugTree())

//This initializes Timber to use it for logging

   }

}




![alt_text](https://www.dropbox.com/s/1ckyedptadlqtrp/image4.png?raw=1 "image_tooltip")


In your AndroidManifest.xml file, add the android:name attribute to tell the app you want that to be your application activity.

**.APPLICATION**

Replace **APPLICATION** with the name of your activity file

**override fun onCreate(savedInstanceState: Bundle?) {

       super.onCreate(savedInstanceState)

       setContentView(R.layout._activity_main_)

       AndroidThreeTen.init(**this**);

/* Current DateTime */

      LocalDateTime.now()

/* String to DateTime */

         **val localDateTimeString = **"2011-12-03T10:15:30"**

          val localDateTime = LocalDateTime.parse(localDateTimeString) 

       Timber.e(**"Hey"**)

       Timber.d(String._format_(**"Hello today is , %s and %s"**, localDateTime._dayOfWeek_, localDateTime._hour_));

   }

Timber.e will log your messages to the error part of the log

![alt_text](https://www.dropbox.com/s/i3u7ieso9yzo1ho/image7.png?raw=1 "image_tooltip")


While .d will put it in the debug section 

Logcat is a powerful tool built into Android Studio that allows you to connect to either your device or emulator and see the result of any logs in your app. This can be anything from debug messages, to errors, to just simple print statements. 

Explore now!:

[FancyToast-Android: Make your native android Toasts Fancy. A library that takes the standard Android toast to the next level with a variety of styling options. Style your toast from code.](https://github.com/Shashank02051997/FancyToast-Android)

Hints:

Follow the same steps we did in class

Ask for help from mentors or us if you need anything

Follow the exact steps we did for the other libraries 

build.gradle(module)

Explore Later!:

[https://infinum.com/the-capsized-eight/top-10-android-libraries-every-android-developer-should-know-about](https://infinum.com/the-capsized-eight/top-10-android-libraries-every-android-developer-should-know-about)

[A categorized directory of libraries and tools for Android | Android-Arsenal.com](https://android-arsenal.com)
