# Hack Sprint Session 1: Basics of Kotlin
**Date**: January 23rd, 2020
**Location**: Covel 227
**Teacher**: Sahen Rai

## Resources
**Slides**
* [Session 2– Dive Into Android](https://docs.google.com/presentation/d/1pJqlSMJtpLAcprp3cPzGIiNfDhnxWn6_O8LMmpBiNgE/edit?usp=sharing)

**ACM Membership Attendance Portal**
* [Portal](http://members.uclaacm.com/login)

**Questions**
Please join our Facebook page for announcements and more! We will do our best to answer questions on our page every week. 
* [Facebook Page](https://www.facebook.com/groups/1399200097134287)

**Other useful resources**
* [Kotlin Documentation](https://kotlinlang.org/docs/reference/)
* [Interactive Kotlin Tutorial](https://blog.jetbrains.com/blog/2019/12/05/jetbrains-academy-kotlin/)
* [Google Codelabs](https://codelabs.developers.google.com/codelabs/kotlin-android-training-welcome/index.html#1)

## What we'll be learning today
- [Review on Nullable](#nullable-types)

## Reviewing Nullable Types
### What are Nullable Types?
Most of the time we want our variables to hold data, but there also also times when we don't yet know the value and wish to leave the variable empty.

Kotlin provides us with a way to do this. We refer to these data types as nullable types.

You can think of a variable that is of a nullable type as a box that may contain a value or null.  When you want to use the value, you have to open the box, and tell the computer what to do if the box is empty. Do you use a default value? Do you stop executing an expression and just make it null? Maybe you crash the entire program? The world is your oyster. Nullable types give you the benefit of being able to set a variable to null while making it harder for these null values to break your program.

<img src="images/boxes.png" width=500>

### Declaring Nullable Types
To declare a type as nullable, you put a question mark after the type name like so:
```kotlin
var brothersName: String? = "Chris"

var sistersName: String? //Initially null
sistersName = "Alyssa"
```

### Using Nullable Types
When you would like to use the value in your nullable box, you have to open the box.  There are a few ways to do this. The first is called **Safe Calls**.  Here is an example:
```kotlin
var myInt: Int? = /*[Int or null]*/
var myStr: String? = myInt?.toString()
```
<img src="images/SafeCall.png" width=500>
A safe call does a similar thing as this:
```kotlin
if (myInt != null) {
  myStr = myInt.toString()
}
else {
  myStr = null
}
```

---

Another way is the **Elvis Operator**.  The Elvis Operator lets you specify a default value in the case that your variable is null. It looks like this:
```kotlin
var myInt: Int? = /*[Int or null]*/
var myStr: String? = myInt?.toString() ?: "Default"
```
<img src="images/Elvis.png" width=500>
The Elvis operator does something like this:
```kotlin
if (myInt != null) {
  myStr = myInt.toString()
}
else {
  myStr = "Default"
}
```

---

A final way to access your value is the **Not-null Assertion**.  You should avoid using this if you can, because it will cause an error if your variable is null.
```kotlin
var myInt: Int? = /*[Int or null]*/
var myStr: String? = myInt!!.toString() //ERROR if myInt==null
```
<img src="images/Assert.png" width=500>
The Elvis operator does something like this:
```kotlin
if (myInt != null) {
  myStr = myInt.toString()
}
else {
  /*Big Ugly Error*/
}
```
