# Hack Sprint Session 2: Dive into Android

**Date**: January 23rd, 2020
**Location**: Covel 227
**Teacher**: Sahen Rai, Miles Wu, Timothy Rediehs

## Resources

- [Session 2– Dive Into Android](https://docs.google.com/presentation/d/1pJqlSMJtpLAcprp3cPzGIiNfDhnxWn6_O8LMmpBiNgE/edit?usp=sharing)

**ACM Membership Attendance Portal**

- [Portal](http://members.uclaacm.com/login)

**Questions**
Please join our Facebook page for announcements and more! We will do our best to answer questions on our page every week.

- [Facebook Page](https://www.facebook.com/groups/1399200097134287)

**Other useful resources**

- [K Documentation](https://klang.org/docs/reference/)
- [Interactive K Tutorial](https://blog.jetbrains.com/blog/2019/12/05/jetbrains-academy-k/)
- [Google Codelabs](https://codelabs.developers.google.com/codelabs/k-android-training-welcome/index.html#1)

## What we'll be learning today

- [Review on Nullable](#nullable-types)
- [Activities and Views](#activities)
- [A Brief Tour of Android Studio](#a-tour-of-android-studio)
- [Making Your First App](#let's-make-an-app)

## Reviewing Nullable Types

### What are Nullable Types?

Most of the time we want our variables to hold data, but there also also times when we don't yet know the value and wish to leave the variable empty.

Kotlin provides us with a way to do this. We refer to these data types as nullable types.

You can think of a variable that is of a nullable type as a box that may contain a value or null. When you want to use the value, you have to open the box, and tell the computer what to do if the box is empty. Do you use a default value? Do you stop executing an expression and just make it null? Maybe you crash the entire program? The world is your oyster. Nullable types give you the benefit of being able to set a variable to null while making it harder for these null values to break your program.

<img src="images/boxes.png" width=500>

### Declaring Nullable Types

To declare a type as nullable, you put a question mark after the type name like so:

```k
var brothersName: String? = "Chris"

var sistersName: String? //Initially null
sistersName = "Alyssa"
```

### Using Nullable Types

When you want to use the value in your nullable box, you have to open the box. There are a few ways to do this. The first is called **Safe Calls**. Here is an example:

```k
var myInt: Int? = /*[Int or null]*/
var myStr: String? = myInt?.toString()
```

<img src="images/SafeCall.png" width=500>

A safe call does a similar thing as this:

```k
if (myInt != null) {
  myStr = myInt.toString()
}
else {
  myStr = null
}
```

---

Another way is the **Elvis Operator**. The Elvis Operator lets you specify a default value in the case that your variable is null. It looke this:

```k
var myInt: Int? = /*[Int or null]*/
var myStr: String = myInt?.toString() ?: "Default"
```

<img src="images/Elvis.png" width=500>

The Elvis operator does something like this:

```k
if (myInt != null) {
  myStr = myInt.toString()
}
else {
  myStr = "Default"
}
```

---

A final way to access your value is the **Not-null Assertion**. You should avoid using this if you can, because it will cause an error if your variable is null.

```k
var myInt: Int? = /*[Int or null]*/
var myStr: String? = myInt!!.toString() //ERROR if myInt==null
```

<img src="images/Assert.png" width=500>

The Elvis operator does somethine this:

```k
if (myInt != null) {
  myStr = myInt.toString()
}
else {
  /*Big Ugly Error*/
}
```

## An Important New Concept: Lambda Functions

**Lambda functions** are a way to define functions on the fly. You'll often use them when you want to pass a function to another piece of code that is expected to call it later (this is aptly called a **callback**).

Take the following code:

```kotlin
class Person(val name: String, var age: Int) {
  fun celebrateBirthday() {
    this.age++;
  }
}

fun main(args: Array<String>) {
  val tim = Person("Tim", 20)
  tim.celebrateBirthday()
  val alex = Person("Alex", 19)
  alex.celebrateBirthday()
}
```

When you take a look at this code, it appears that it has the correct behavior. On a `Person`'s birthday, their `age` increments by one, and that's it. This would be correct... if it wasn't so **_sad_**. We do so much stuff on our birthdays! Have birthday parties! Eat with friends! Open birthday presents! Each person has something they do on their birthday. Let's try to represent this in our code.

We need a few things:

1. Create a **variable** that holds your **function** that says what you do on your birthday
2. Set that variable for your `Person`
3. Call the function from `celebrateBirthday`

To do this, we can use **Lambda Functions**. The syntax of a lambda function is the following (you may have a `return` inside of the code):

```kotlin
//0 Parameters (usually: we'll talk about the exception)
{
    [code]
}
//1 Parameter
{ parameterName: ParameterType ->
    [code]
}
//2 Parameters
{ parameterName0: ParameterType0, parameterName1: parameterType1 ->
    [code]
}
//This pattern continues...
```

You can assign a lambda to a variable or even pass it to another function.

```kotlin
var myFunction = {
    println("OMG I'M IN A LAMBDA")
}

button.setOnClickListener({ v ->
    Log.i("Is he... forshadowing?")
})
```

Let's add a `onBirthday` function to our `Person` class and set it to some default function.

```kotlin
class Person(val name: String, var age: Int) {
    /*
    1: Create a variable for your function
    The type of our variable is (Person) -> Unit
    In English: "A function that takes a Person and returns nothing"
    */
    var onBirthday: (Person) -> Unit = { me: Person ->
        println("${me.name} is ${me.age} years old!")
        //Same as: me.name + " is " + me.age + " years old!"
    }

    fun celebrateBirthday() {
        this.age++;
    }
}

fun main(args: Array<String>) {
    val tim = Person("Tim", 20)
    tim.celebrateBirthday()

    val alex = Person("Alex", 19)
    alex.celebrateBirthday()
}
```

ℹ️ Notice that the type of our `onBirthday` function is `(Person) -> Unit`. This makes it easier for us to tell the function whose birthday it is. Remember, when we are outside of the person class, we may not be able to access it's properties directly.

Now, let's set `onBirthday` for our People.

```kotlin
fun main(args: Array<String>) {
  val tim = Person("Tim", 20)
  //2: We set the onBirthday function for the Person
  tim.onBirthday = { me ->
    println("Anyone want to play some Elder Dragon Hammered? 🐉🍻")
    println("Whenever a player casts a blue spell that player takes a drink.")
  }
  tim.celebrateBirthday()

  val alex = Person("Alex", 19)
  alex.onBirthday = { me ->
    println("I, ${me.name}, am going to play League of Legends.")
  }
  alex.celebrateBirthday()
}
```

Finally, we call that function from `celebrateBirthday`.

```kotlin
class Person(val name: String, var age: Int) {
  var onBirthday: (Person) -> Unit = { me: Person ->
    println("${me.name} is ${me.age} years old!")
  }

  fun celebrateBirthday() {
    this.age++;
    //3: Call the onBirthday function
    this.onBirthday(this)
  }
}
```

From the example above, we see that lambda functions allow us to **quickly define one-off functions that we can give to other functions are variables to be called later**.

## Setup: Installing Android Studio

1. Go to the Android Studio [download page](https://developer.android.com/studio)
2. Click the green "Download Android Studio" button
3. Click the downloaded file to start the install
4. Follow the instructions on your screen, they may vary based on your operating system
5. Click through the installer. The default settings should work. If you're feeling edgy, you can choose the dark theme.
6. After you finish on the last page, the installer will download a lot of components. This may take some time.
   1. Things you can do while Android Studio is downloading:
      1. Make a sandwich
      2. Take a shower
      3. Learn Swift
7. If all went well, the menu should show up like this after it's done!

<img src="images/welcome.png" width=500>

## Setup: Try creating a project

1. From the welcome menu, select "Start a new Android Studio project"
2. On the "Choose your project" window, select **Empty Activity**
3. The next page should ask you for some information for your project. You can name it anything. Make sure the language is **Kotlin** and "use AndroidX artifacts" is checked. You can set the minimum API version to **API 19: Android 4.4 (KitKat)**.
   4.k finish

## Setup: Try running the project

1. You'll need an emulator! Select **Tools>AVD Manager**. It should show you your virtual devices which will probably be empty.
2. Click **+Create a Virtual Device** and choose a device like the Pixel XL.
3. Next, the **System Image Dialog** should appear. Select an option in the recommended list and click **next**. We'll use **Q**.
   1. NOTE: You'll likely have to download it by clicking the **download** link next to it. ⚠️**THIS MAY TAKE A WHILE** ⚠️.
4. Click **finish** on the next window
5. You should be able to run your project with the **green play button** on the top right corner of the screen now!
   1. ℹ️ Starting the device the first time may take a minute

## Activities

Any app made in android studio is composed of many activities so it is important to understand what an activity is, what the components of an activity are, and how we create activities.

So what is an activity? \
Every activity in a project describes some set of user interactions. These interactions are then presented to the user through the visual window that displays on their device. We summarize this concept on a high level by saying that an activity represents a screen in your app.

For example I could have a screen that acts as navigation for several different screens in my app. The user has the ability to interact with each tab to select which screen they want to navigate to. I would implement the logic that controls this navigation screen with a NavigationActivity and it would then be presented to the user like so:

<img src="./images/NavActivityExample.png">

Another example is a screen that requests some user's login information. I would represent this Login screen with a corresponding LoginActivity file which handles the user input and submission button and present it to the user visually through something like this:

<img src="./images/LoginActivityExample.png">

When we actually work with activity files you will notice that the activity file contains code, more specifically an Activity class. It is important to understand that the activity file primarily serves to implement the logic of a screen (not the visual layout). This usually means keeping track of data that is displayed onto the screen, handling updates to the screen, and handling events, all of which we will get into later.

### The Main Activity

If every activity represents a screen, the Main Activity is the launcher or startup screen. This acts as the entry point for your application and will be the first thing to display whenever a user opens up your app.

Whenever you create a new project, the Android Studio IDE should handle the creation of this MainActivity file for you.
If you are in the 'Project' view of the project directory, then you can locate the MainActivity file under app > src > main > java > your.package.name > MainActivity

<img src="./images/ProjectMainActivity.png" >

If you are in the 'Android' view of the project directory, then the MainActivity file will be under app > java > your.package.name > MainActivity

<img src="./images/AndroidMainActivity.png" >

## Layouts

Now that we have established that activities implement the logic of a screen, what dictates the visuals? The answer is layouts.

Layouts are implementations of the visual components associated with a screen. Essentially, layout files specify where everything on the screen is located and how it should look. If you are familiar with the browser, you can think of the layout as the HTML / CSS component of the screen.

If in the 'Project' view of directory, layouts can be found under app > src > main > res > layout

<img src="./images/ProjectLayout.png">

If in the 'Android' view of directory, layouts can be found under app > res > layout

<img src="./images/AndroidLayout.png">

### Activities with Layouts

Every activity in your application must have an associated layout, otherwise the set of interactions that an activity implements will not have a way to be presented visually to the user.

We associate a layout with an activity using the `setContentView()` function call inside the `onCreate()` method. This sets the activity's layout when the activity is created.

<img src="./images/SetActivityContentView.png" >

To quickly break down the `setContentView(R.layout.activity_main)` function call:

- R refers to the resources/res folder
- R.layout refers to the layout folder within the res folder
- R.layout.activity_main refers to the layout file `activity_main.xml` which contains the visual logic for the MainActivity

## Views

Before we can actually start creating layouts to go with our activities, we have to introduce Views. Views are the components of any layout. Every element the user sees on the screen is a view or is part of a view.

Here are some examples of basic views:

- TextView: displays some text
- ImageView: contains an image
- Button: creates a button that can be clicked by user

<img src="./images/ViewsExample.png">

We combine these views together, specifying where they should be positioned and how they should look, to ultimately create a layout. With our completed layout, we finally have a fully functional activity with an associated display!

## A Tour of Android Studio

Android Studio has a lot of different tools. Some of these we will be using, but many of them aren’t useful for right now. The main two files you want to look at as a beginner developer will be the MainActivity file, and activity_main.xml.

![activity_main.xml](images/activity_main.png)

Activity files and xml files are the two puzzle pieces of making a screen. Activity files are the code side of things and xml files represent the design of the screen. Eventually we will cover using multiples of these things in order to do multiple screens, but for now we don’t need to.

The build output pane in the bottom is the same as the output in all other IDEs. It tells you status messages about your app and also any debugging messages.

![MainActivity.kt](images/main_activity.png)

The folders inside the java folder are used for advanced testing. The other folders inside res will be used for everything from storing long term values, to the app icon, and so on. The Android Manifest file is sort of a management file for important app settings, which we will address later in the course.

## Setting up A Virtual Device

![Tool Bar](images/toolbar.png)

The tools area is where we’re going to create our virtual device. Click tools and AVD manager to create a virtual device to test your app.

![Pick Virtual Device](images/avd.png)

Pick the Pixel 2 to start, and then we can test our apps out! It will take around 7 GB of space so keep that in mind.

## Let’s Make an App!

We will now be demoing a simple app so we can introduce the different panels and files we will use in app development. In this app, we will be making a button clicking counter!

This will have a button centered under a line of text. When we start pressing the button, the line of text will begin displaying the number of times we have clicked the button, updating whenever the button is clicked.

Before we begin, go to **File** and create a New Project. Create an Empty Activity and name the project HackSprintS2 with an API level of 19.

### Creating Our App Interface

First we’ll need to create the buttons and text for our app. To do this, we’ll first need to navigate to our the design tab of the visual layout editor.

![Deisgn Tab](images/designview.png)

Here we will be able to add different Views (Text, Buttons, etc.) to our app.

In this panel, on the top left, we should see a section called Palette. This contains different things we can add to our app. Currently we should see things like TextView, Button, ImageView, and a few more.

![Palette](images/palette.png)

First, let’s add a TextView (a fancy name for text) from the area called Palette, drag and drop it from your app.

When we select this TextView in our app or under Component, we should see the Attribute panel pop up on the right. In this section, we can change different properties about our TestView. There should be a field here called **id**. Change the for the textView to `numberText`.

![TextView ID](images/textid.png)

Around our text, we should see 4 bubbles on each edge. These bubbles help us to position our text. Drag each of the bubbles to the edge to set the _constraints_ for the TextView (Our way of making sure our design elements are where we want them to be).

![TextView with Constraints](images/textconstraints.png)

Now let’s add a Button. Click the Button on our app or under the Component Tree and go to the attributes panel. Give the Button an **id** of `buttonClick`.

> Ensure that the tab that says id has a set id you can remember; later this ties the code in MainActivity.kt to the design elements. It connects the elements to your code, and you have to remember it to make this connection

## Adding the Code to our app

Now go to the MainActivity.kt file. This file contains code that will control how our app behaves. Add the following code:

```kotlin
package com.example.hacksprints2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
  super.onCreate(savedInstanceState)
  setContentView(R.layout.activity_main)

    val textView = findViewById<TextView>(R.id.numberText) //Turns our text view into a variable access or change properties of

    val button = findViewById<Button>(R.id.clickButton) //Turns our button into a variable we can edit

    button.text = "Increment"

    button.setOnClickListener {
    //Allows for the sensing of when a button is set
      number += 1
      textView.text = "Our Value: " + number.toString() //Uses integer function to set the text to our value
    }
  }
}
```

Let’s breakdown how this code works. If many of the functions seem unfamiliar, do not worry. We will be going more into detail about these next week. Many will also start making more sense with practice!

```kotlin
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
```

These statements here import external libraries for our project. We will explain what these are in further classes.

```kotlin
val textView = findViewById<TextView>(R.id.numberText) //Turns our text view into a variable access or change properties of

val button = findViewById<Button>(R.id.clickButton) //Turns our button into a variable we can edit
```

These statements make our design elements accessible via code. Essentially turning them into objects in code that we can access and manipulate.

```kotlin
button.text = "Increment"

button.setOnClickListener {
//Allows for the sensing of when a button is set
   number += 1
   textView.text = "Our Value: " + number.toString() //Uses integer function to set the text to our value
}
```

These statements here allow us to set details on our button class, and also start paying attention to the clicking of a button.

Now at the top of Android Studio, hit the green play button and run your app! When it starts, every time we press our button, the text should show the number of times we have clicked it!
