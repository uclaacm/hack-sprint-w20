# Hack Sprint Session 1: Basics of Kotlin
**Date**: January 16th, 2020
**Location**: Covel 227
**Teacher**: Jody Lin and Sahen Rai

## Resources
**Slides**
* [Session 1- Basics of Kotlin](https://docs.google.com/presentation/d/1ZyaiM5MffFLa_yJ5gB7-VaizTskio8d597T7ICkdaZ4/edit?usp=sharingTODO)

**ACM Membership Attendance Portal**
* [Portal](http://members.uclaacm.com/login)

**Questions**
Please join our Facebook page for announcements and more! We will do our best to answer questions on our page every week. 
* [Facebook Page](https://www.facebook.com/groups/1399200097134287)

**Other useful resources**
* [Kotlin Documentation](https://kotlinlang.org/docs/reference/)
* [Interactive Kotlin Tutorial](https://blog.jetbrains.com/blog/2019/12/05/jetbrains-academy-kotlin/)

## Prerequisites
Before we begin, it will be helpful to have a basic understanding of a few topics, as we will merely be explaining their syntax and usage in Kotlin. Here are some concepts you should have knowledge of (doesn't matter from which language)
* Basic Data Types
* Conditionals (If /Else If / Else)
* Loops
* Functions
* Classes
    * Do not need to know Class Composition, Inheritance, or Polymorphism


## What we'll be learning today
- [Data Types](#data-types)
- [Control Flow](#control-flow)
- [Functions](#functions)
- [Classes](#classes)
- [Inheritance](#inheritance)
- [Practice Problems](#practice-problems)

## A Brief History of Kotlin
Up until the last few years, Android was done entirely through Java. But as well known and widely used as Java is, it had its issues. It didn’t have some of the tools that newer languages like Swift or Python possessed, and it needed to be updated to fit some of the newer language standards. That’s why a company called JetBrain created Kotlin to be an in-house used interoperable version of Java that was open to anyone. 

Though they initially created it to be used in house, it eventually spread to the open source community, where a man by the name of Jake Wharton, who worked at Square, started making it really popular by making open source libraries for it. Around this time, Google themselves began embracing Kotlin as a modern language for Android Development, and encouraged its use. Now, its the “main” language for Android Development. 

## Data Types
In programming, we use variables as a way to hold and store data. Across different languages you may be see varying syntaxes for this. 
```cpp
// C++
string name = "Jody";
```
```py
# python
name = "Jody"
```
```js
// javascript
var name = "Jody"
```

In Kotlin, variables are declared in the **Pascal Notation**. Here's an example.

```kotlin
// kotlin
val name: String = "Jody"
var age: Int = 19
var gpa: Double = 4.0 //haha i wish :(
```

Let's break down what these mean. 

`val` or `var` specifies that we are declaring a variable. Every time we declare a variable we _must_ start the declaration with `var` or `val`. 

What's the difference?

`var` is short for _variable_, which means that we are able to change the value of this _variable_ at any time. In programming, we'll call this type of data _mutable_. 

`val` is short for _value_, which means that once we assign this a value, we **cannot change the _value_ of the variable**. In programming we would say that `val` is _immutable_. 

Next we have the parameter name. 

Variable naming in Kotlin follows `camelCase`. This means that you `nameYourVariablesLikeThis`.

Next we have a `:` followed by the data type. Here are the common data types in Kotlin:

- Boolean 
    - true or false
- Int
    - 32-bit long whole number
- Long
    - 64-bit long whole number
- Float
    - 32-bit long decimal number
- Double
    - 64-bit long decimal number
- Char
    - a single character
- String
    - words and sentences made of Chars
- Unit 
    - think of this like `void` in Java or C++
    - Note: we also will only use this in functions

We then assign our value with an equals sign. 

So declaring variables follows this format:
```
var/val nameOfVariable: DataType = value
```

### All Data Types are Objects
All these data types under the hood are represented as _objects_. This becomes convenient because for each data type, Kotlin provides some useful object properties and functions that we can access.

Though we won't be covering many today, here are a few you may find useful!
```kotlin
// store max value of an integer in variable
val maxValOfInt: Int = Int.MAX_VALUE
println(maxValOfInt.SIZE_BITS) //OUTPUT: 32

// fun with strings
val group: String = "Blackpink"
println(group.length()) //OUTPUT: 9
println(group.lastIndex()) // OUTPUT: 8
println(group.first()) //OUTPUT: 'B'

// type casting
val twiceStr: String = "9" // note this of type string
val twiceNum: Int = twiceStr.toInt() // now holds integer value 9
```

## Nullable Types
Most of the time we want our variables to hold data, but there also also times when we don't yet know the value and wish to leave the variable empty. 

Kotlin provides us with a way to do this. We refer to these data types as nullable types. 
> Historically NullPointerExceptions have caused countless issues that crash programs and make a lot of people want to smash their computers with sledgehammers. Basically nullable types protect against this. 

Let's look at an example. 
```kotlin
var favoriteShow: String? = null

println("Jody's favorite show is " + favoriteShow)

favoriteShow = "Parks and Recreation"

println("Jody's favorite show is " + favoriteShow)
```
```
OUTPUT: 
Jody's favorite show is null
Jody's favorite show is Parks and Recreation
```

As we can see, we have assigned `favoriteShow` with the type `String?`. By adding the `?` we have now given our variable the ability to hold either a `String` or `null` value. 

When we try to access the String when it's null, the variable will return `null`. When finally assign it a value, the String value is able to be accessed and used. 

Here's the general syntax for nullable types:
```kotlin
var variableName: DataType? = (null or value of type DataType)
```
> Note: more often than not, we want to reassign our nullable type with a non-null value later, so we should use `var`, which allows us to change the value of the variable, instead of `val`, which does not let us change the data once we initialize it. 

In addition to being able to store `null`, in our variable, Kotlin provides us a way to not accidentally access data from a `null`.

Take this C++ code for example:
```cpp
char* m_friend = NULL;
cout << *m_friend;  // throws a NullPointerException and DIES
```
Here we try access the length of a string that doesn't exist. The program freaks out and throws an exception and stops running the program. 

In Kotlin, we now must call functions and access member variables differently. 

```kotlin
var friend: String? = null
println(friend?.length)

friend = "Galen"
println(friend?.length)
```
```
OUTPUT: 
null
5
```


Notice that we add a `?` _before_ the dot operator. We call this a **safe call**. Basically we can safely ensure that our program will not throw a NullPointerException. 

If the variable is `null`, the variable will simply be returned as `null`. If the value is _not_ `null`, we can call the appropriate function or access the data member. 

_Rule_: If you have a nullable type, every time you wish to use the `.` (dot operator), you MUST use a **safe call** `?.`

### The Elvis Operator ( ?: )
Often times when we'll check with an if statement to perform special behavior when a value is null. Take the example below:
```kotlin
var friend: String? = null
val length: Int? = friend?.length // will be null because 'friend' is null

println(
    if (length != null)
        return length
    else
        return 0
) // OUTPUT: 0
```

If `length` is `null`, we don't really want to return `null`, but `0` instead. When `length` is not `null`, we just return its value. 

Kotlin gives a very shorthand to do this with the **Elvis Operator**. 

The above code can be equivalently written as:
```kotlin
var friend: String? = null
val length: Int? = friend?.length // null

println( length ?: 0 ) // OUTPUT: 0
```

What this does: Kotlin checks if the value on to the left of the `?:` is null. If it is not `null`, then return the value. Otherwise return the value to the right of `?:`. 


Why is this called the Elvis Operator?

![That's why](images/elvis.png)

That's why. 

## Control Flow

### if, else if, and else
Often times when we code, we only want to run code _if_ a certain condition is true. For example, if concert tickets cost $1000 and your bank account has $19, then you probably don't want to buy the ticket. 

In Kotlin, this might look something like this:
```kotlin
var bankAccount: Int = 19
val kConTix: Int = 1000

if (bankAccount > kConTix) {
    bankAccount -= kConTix
    println("Yay we're going to KCON")
}
else {
    println("Go get a job you koreaboo")
}
```
OUTPUT: `Go get a job you koreaboo`

We may also add an additional `else if` statement to this code as well. This will only execute the block of code below if the previous condition was false and the current condition is true. 

Using the previous example, this could look like this:
```kotlin
var bankAccount: Int = 19
var richParents: Boolean = true
val kConTix: Int = 1000

if (bankAccount > kConTix) {
    bankAccount -= kConTix
    println("Yay we're going to KCON")
}
else if (richParents == true) {
    println("I go to USC and my parents will pay for me")
}
else {
    println("Go get a job you koreaboo")
}
```
OUTPUT: `I go to USC and my parents will pay for me`

The general syntax for conditionals look like this:
```kotlin
if (conditionOne) {
    //code to execute if conditionOne true
    ...
}
else if (conditionTwo) {
    //code to execute if conditionTwo true
    ...
}
else {
    //code to execute if all conditions before fail
    ...
}
```

### Loops
Sometimes we need to repeat code. 

For example, I want to be super hip and yell "Go Bruins" 20 times. I could theoretically type the following lines 20 times
```kotlin
println("Go Bruins")
println("Go Bruins")
println("Go Bruins")
... // print a total of 20 times
```
But that's really long and cumbersome. I mean, what if I miscount? How am I supposed to prove I have supreme school spirit??? 

This is where loops come in!

**repeat(n) {...}**

This will repeat the code block `n` times. 

For example:
```kotlin
repeat(20) {
    println("Go Bruins")
}
```
This will output `Go Bruins` on 20 lines. 

**while(_some condition is true_) {...}**

This will repeat the code block until a certain condition given is false. 

Example:
```kotlin
var hoursBinged: Int = 0
while( hoursBinged < 20 ) {
    println("Binge Hotel del Luna")
    hoursBinged++
}

println("Stop watching and be productive Eugene")
```

**for loop**

Kotlin also provides us with a loop that allows programmers to increment through numbers, strings, arrays, and more!

Suppose I want to print a list of numbers from 1-100, each on a new line. There are a few ways we could code this.

_Inclusive Range Loop_
```kotlin
for (i in 1..100) {
    println(i)
}
```
This will print the numbers 1 to 100, inclusive (meaning we include the number 1 100)
```
OUTPUT:
1
2
...
100
```

_Not Inclusive Interation_
```kotlin
for (i in 1 until 100) {
    println(i)
}
```
This will print the numbers 1 to 99, _without_ printing 100. 
```
OUTPUT:
1
2
...
99
```

There are variations of iteration with a for loop. Here are a few of them.

_Backwards Iteration_

Sometimes we want to iterate backwards through something. Kotlin lets us do this with the `downTo` keyword. 
```kotlin
for (i in 100 downTo 1) {
    println(i)
}
```
This will iterate from 100 down to 1, inclusive. 
```
OUTPUT: 
100
99
...
1
```

_Specified Step Size_

Sometimes don't always want to increment by 1 every time. For example, what if we only want to print even numbers?

Kotlin lets us specify our step size with the keyword `step`. 
```kotlin
for (i in 1..100 step 2) {
    println(i)
}
```
This will increment `i` by 2 each iteration of the loop. 
```
OUTPUT: 
1
3
5
...
99
```
> Notice, this _won't_ print out 100 even though we did an inclusive range. This is because when `i` equal **99** and then increments by **2**, `i` becomes **101**, which is out of the range **1 to 100**.


>_Further Reading_: If you are interested in learning more, look up the `when` statement in Kotlin. This is Kotlin's version of a `switch` statement. However, since there is nothing that we can't do with an `if/else if/else` block that we can do with a `switch` statement, we will not cover this today. 

## Functions
A fundamental concept in programming is that code should be resuable. We may have some instructions of code that we want to reuse over and over again, except not consecutively, meaning loops fail us. This is where functions come in. 

Here is an example of how this might look:
```kotlin
// program to log how many hours a day i waste
fun hoursWasted(tv: Int, slept: Int): Int {
    return tv + slept
}

var hoursOnTV = 7
var hoursSleeping = 8

println("Hours wasted: " + hoursWasted(hoursOnTV, hoursSleeping) )
```
```
OUTPUT: Hours wasted: 15
```

Let's break down the syntax of the function here:
```kotlin
fun nameOfFunction(parameter: ParamType, ...) : ReturnType {
    // code to execute here
    return (value with type ReturnType)
}
```

Often times we don't want to explicitly return anything from our function. Perhaps our function only prints something. We can write our function like this:
```kotlin
fun speakChinese() {
    println("wo ai ni")
}
```
In this example, we do not specify a return type, neither do we return anything. When we write a function like this, Kotlin implicitly returns a type called `Unit`, which means nothing is returned. (If you've languages like C/C++/Java/etc, this is comparable to `void`.)

Writing this out explicity would like like this:
```kotlin
fun speakChinese(): Unit {
    println("wo ai ni")
}
```

### Functions References
In Kotlin, functions are incredibly versatile. Here is a list of some of the things we can do with functions:
* be stored as a variable
* be returned by a function
* be passed as a function argument

You might notice that these are things we can do with data types like `Int`, `String`, `Double`, etc. Well, in Kotlin, functions can _also_ do these!

#### Storing functions as variables
We've stored types like `Int`'s and `String`'s as variables, so how do we do this functions?

Recall the general syntax of declaring variables:
```kotlin
var/val nameOfVariable: DataType = value
```

How do we write the Type of a function (also called Function Type)?

If we have the function:
```kotlin
fun add(a: Int, b: Int): Int {
    return a + b
}
```
The Function Type would be:
```kotlin
(Int, Int) -> Int
```

Function Types follow this general format:
```
(DataTypeOfParemeter, ...) -> ReturnType
```

In our `add(a: Int, b: Int)` function, we have 2 parameters of type `Int`, and then the function returns an `Int`. 

Knowing this, let's store our `add()` function in a variable and look at the syntax!
```kotlin
val addObject: (Int, Int) -> Int = ::add

// note: the Kotlin compiler is smart enough to figure out the Function Type by itself
// thus we could equivalently write:
// val addObject = ::add
```

Notice how we write our Function Type in the same place as we wrote our Data Types for other variables. 

To pass the specific function, we add `::` in front of the function name (this generates a reference to the function), and then leave out the parentheses `()`. 

We can now call this new function the same was as we called our original `add()` function:
```kotlin
println( addObject(5, 13) ) //OUTPUT: 18
```

Here's another example of a function with no parameters and no explicit return:
```kotlin
fun helloInChinese() { // implicitly returns Unit type
    println("Nihao")
}

val helloChineseObject: () -> Unit = ::helloInChinese
```

As we can see, `helloInChinese()` takes in no parameters and does not return anything. Thus the Function Type is `() -> Unit`. 

#### Returning Functions from Functions
Functions can _also_ return other functions! Mind blowing? Let's look at an example:
```kotlin
fun multiplier(score: Int) {
    return 2 * score
}
fun noMultiplier(score: Int) {
    return score
}

fun getGameScore(hasPowerUp: Boolean) : (Int) -> Int {
    if (hasPowerUp == true)
        return ::multiplier
    else
        return ::noMultiplier
}
```

In this case we can see that the return type of `gameStart()` is the Function Type of the functions we return. We can also see that we return the functions by adding `::` to the name and dropping the `()`. 

In the case, if we call the function like this: `getGameScore(true)`, we'll be returned a reference to the function `multiplier()`. If we call it like this: `getGameScore(false)`, we'll be returned a reference to `noMultiplier()`. 

#### Passing Functions as Parameters
In Kotlin, we are also able to pass a function as a parameter to another function. The format is the same as how we'd pass normal parameters. Let's look at an example:
```kotlin
fun square(num: Int) : Int {
    return num * num
}
fun cube(num: Int) : Int {
    return num * num * num
}

fun applyAndSum(a: Int, b: Int, m_fun: (Int) -> Int) : Int {
    return m_fun(a) + m_fun(b)
}

applyAndSum(1, 2, ::square) // OUTPUT: 5
applyAndSum(2, 2, ::cube) // OUTPUT: 16
```

Notice that in the paramter list, we specify the Function Type for `m_fun`, just as we specify the Data Type `Int` for `a` and `b`. 

When we want to use the function we passed in our parameter, we simply call it with the parameter name and the proper arguments. 

In this case, `square()` and `cube()` both take in integers, so we must call `m_fun()`, with an integer as the parameter. 

If this seems strange or confusing, know that this will become more familiar with practice!

## Classes
Sometimes we need a way to group similar data together. In Kotlin, we are able to use a class to do this. Think of classes as a special more complicated data type that a programmer creates out of pre-existing data types. 

Let's create a simple empty class called **Idol**
```kotlin
class Idol {
}
```
```kotlin
// OR because this class is empty, we could also declare it without brackets
class Idol 
```

But this is pretty boring. Let's add some member variables to this class. 
```kotlin
class Idol {
    val name: String = "Solar"
    var age: Int = 28
}
```
Now we can instantiate this and access our member variables with the `.` dot operator!
```kotlin
val singer = Idol()
println(singer.name) // OUTPUT: Solar
println(singer.age) // OUTPUT: 28
```

However, not all singers are going to be named "Solar" and be age 28. Kotlin provides a way to specify how we initialize our class member variables for each object of the class we declare. This is called a **constructor**.

Let's add one to our example class. 
```kotlin
class Idol {
    val name: String
    var age: Int

    constructor(_name: String, _age: Int) {
        name = _name
        age = _age
    }
}
```
This constructor we've added is called a _secondary constructor_. When we have a constructor present, we no longer are required to give each member variable an initial value, as long as we initialize it in the constructor. 

We can call it to initial our Idol objects now. 

```kotlin
val solar = Idol("Solar", 28)
val moonbyul = Idol("Moonbyul", 27)

println(solar.name) // OUTPUT: Solar
println(solar.age) // OUTPUT: 28
println(moonbyul.name) // OUTPUT: Moonbyul
println(moonbyul.age) // OUTPUT: 27
```

Okay, so we have a _secondary constructor_, then do we have a _primary constructor_??? We DO in fact have one. 

Let's convert our secondary constructor from the last example to a primary constructor. 
```kotlin
class Idol(_name: String, _age: Int) {
    val name: String = _name
    var age: Int = _age
}
```
We can call this create objects from with the class the exact same way as before. 

```kotlin
val hwasa = Idol("Hwasa", 24)
println(hwasa.name) // OUTPUT: Hwasa
println(hwasa.age) // OUTPUT: 24
```

But WAIT, there's more!

As we can see, we have to name our constructor parameter something different from the _actual_ member variable name, otherwise we end up unable to set the member variable in the class. (We can get around this with the `this` keyword, but Kotlin gives us a way to avoid the problem entirely). 

In Kotlin, we can declare our member variables _directly in the constructor_. 

Let's do this with our `name` member variable. 
```kotlin
class Idol(val name: String, _age: Int) {
    var age: Int = _age
}
```
And then let's do the same with our `age` member variable. 
```kotlin
class Idol(val name: String, var age: Int) {
}
```
Now that are class is now empty, we can get rid of the brackets all together. 
```kotlin
class Idol(val name: String, var age: Int)
```

This is equivalent to our original class!


### Member Functions
Let's now add functions to this class. Whenever we instantiate an object of the class we will now be able to use this function on this object. 

Let's continue with out Idol example and add a function that allows our idol to sing. 

```kotlin
class Idol(val name: String, var age: Int) {
    fun sing() {
        println("My name is " + this.name)
        println("Mama mama moooo")
    }
}
```

We can now use this function when we instantiate an Idol object. 

```kotlin
var wheein = Idol("Wheein", 24)
wheein.sing()
```
```
OUTPUT: 
My name is Wheein
Mama mama moooo
```

With our member functions, you can manipulate member variables (**only if they are created with `var`**), print lines, and so much more!


## Inheritance

Suppose we want to make multiple classes representing people. Let's create a Student class along with our Idol class.
```kotlin
class Student(val name: String, var age: Int, val id: Int) {
    fun eat() {
        println("I <3 BPlate")
    }
    fun sing() {
        println("Hello darkness my old friend...")
    }
}

class Idol(val name: String, var age: Int) {
    fun dance() {
        println("I love to dance")
    }
    fun sing() {
        println("Mama mama mooo")
    }
}
```
As we can see, both Idols and Students have a `name`, `age`, and function that allows them to `sing`. 

_The problem_: Both Idols and Students share common properties and functions. Is there a way we can generalize it so that we don't have to keep duplicating code?


We call this **Inheritance**. This is a way that allows us to create general classes that other classes can build on and specialize for themselves. 

Let's look at how this is done.

Since Idols and Students have some properties in common, let's create a generalized Person class that holds these shared properties. 
```kotlin
class Person (val name: String, var age: Int) {
    fun sing() {
        println("Happy Birthday to you...")
    }
}
```

By default, classes in Kotlin **do not** allow inheritance. We must _open_ the class to inheritance. Thus we prepare our Person class to be open for inheritance by adding the keyword `open` in front. 
```kotlin
open class Person (val name: String, var age: Int) {
    fun sing() {
        println("Happy Birthday to you...")
    }
}
```

Let's have our Idol and Student class inherit from this class. 
```kotlin
class Idol(val name: String, var age: Int): Person(name, age) {
}

class Student(val name: String, var age: Int, val id: Int): Person(name, age) {
}
```
In order for Idol and Student to inherit from the person class, we need to add a `:` after the Idol and Student constructor and then call the Person constructor, ensuring to pass in the appropriate parameters. 

Now we can do this:
```kotlin
val taemin = Idol("Taemin", 26)
val connie = Student("Connie", 20)

println(taemin.age) // OUTPUT: 26
println(connie.age) // OUTPUT: 20
taemin.sing() // OUTPUT: Happy Birthday to you...
connie.sing() // OUTPUT: Happy Birthday to you...
```

As we can see, both Idol and Student are able to use the `sing()` function defined in the Person class! 

We call the Person class the **super class** and Idol and Student **child classes**. 

Okay, but in our example from earlier, Idol had it's own way to sing that differed from Person. So how do we write _specialized_ functions for each of these classes? Kotlin allows us to specialize (or what we call _override_) the function in the super class. 

First we specify in the parent class that `sing()` is a function we wish to override in a child class. 
```kotlin
open class Person (val name: String, var age: Int) {
    open fun sing() {
        println("Happy Birthday to you...")
    }
}
```
Next, we define our own `sing()` functions in Idol and Person with the `override` keyword. 

```kotlin
class Idol(val name: String, var age: Int): Person(name, age) {
    override fun sing() {
        println("Mama mama moooo")
    }
}

class Student(val name: String, var age: Int, val id: Int): Person(name, age) {
    override fun sing() {
        println("Hello darkness my old friend...")
    }
}
```

Now when we call our code, Idol and Student objects will have their own specialized `sing()` functions called. 

```kotlin
val taemin = Idol("Taemin", 26)
val connie = Student("Connie", 20)

taemin.sing() // OUTPUT: Mama mama moo
connie.sing() // OUTPUT: Hello darkness my old friend
```

Earlier when we had defined the Student class, we also had an extra function called `eat()`, which was not in the Idol class. Similarly, the Idol class had a dance function that the Student class did not have. We can simply add these to their respective classes. 

```kotlin
class Idol(val name: String, var age: Int): Person(name, age) {
    fun dance() {
        println("I love to dance")
    }
    override fun sing() {
        println("Mama mama moooo")
    }
}

class Student(val name: String, var age: Int, val id: Int): Person(name, age) {
    fun eat() {
        println("I <3 BPlate")
    }
    override fun sing() {
        println("Hello darkness my old friend...")
    }
}
```

Now our Students can properly eat and our Idols can't (oof). 
```kotlin
val taemin = Idol("Taemin", 26)
val connie = Student("Connie", 20)

connie.eat() // OUTPUT: I <3 BPlate
taemin.eat() // OUTPUT: Error: function doesn't exist in this class
```

As we can see, inheritance is a powerful tool that allows us to generalize classes and then have other classes make them more specific. We can not only have single-level inheritance (like the previous example), we can classes inherit from classes that inherit from _other_ classes.

If this seems like a confusing concept, it will begin to make more sense as you get practice with it. 

# Practice Problems
And those are the basics of Kotlin! Try out these practice problems and begin familiarizing yourself with Kotlin. 

In our future sessions, we will be using Kotlin to control many parts of our Android app, so familiarizing yourself with the syntax will help increase your understanding later on :)

# Hacksprint Kotlin Challenges
## Variables and Strings
### String?... String.
1. Write some Kotlin code that declares two declares a `String` variable called `school`, sets it to "You See Ell Aye", than prints the string and it's length (using the `length` function).

<details>
<summary><b>Answer:</b></summary>

```kotlin
var school = "You See Ell Aye"
println(school)
println(school.length)
```
</details>

2. Change the `school` variable from before to be a `String?`.  Something in your program will break here.  Try fixing it.

<details>
<summary><b>Answer:</b></summary>

```kotlin
var school: String? = "You See Ell Aye"
println(school)
println(school?.length)
```
</details>

3. Set `school` to `null` and print it. 

<details>
<summary><b>Answer:</b></summary>

```kotlin
var school: String? = null
println(school)
println(school?.length)
```
</details>

## Functions
### Repeat Yourself
1. Write a function called `reciprocal` that takes in `num` of type `Int` and returns the reciprocal (`1.0/num`) of type `Double?`.
   1. If `num` is 0, don't do any division and return null.

<details>
<summary><b>Answer:</b></summary>

**Answer:**
```Kotlin
fun reciprocal(num: Int): Double? {
    if(num == 0){
        return null
    }
    return 1.0/num
}
```
</details>

## Conditionals
### Hippopotomonstrosesquippedaliophobia
1. Write a function that takes a `String` and prints it only if its length is less than 7.  If its length is 7 or more, print `"scared"` instead.

<details>
<summary><b>Answer:</b></summary>

```kotlin
fun hippophob(word: String) {
    if(word.length < 7){
        println(word)
    }
    else {
        println("scared")
    }
}
```
</details>

## Loop practice
### Alphabot
Write a loop that prints out the alphabet in reverse, each character on a newline

<details>
<summary><b>Answer:</b></summary>

```kotlin
for (letter in 'z' downTo 'a') {
    println(letter)
}
```
</details>

### We're an Odd Group
1. Write a loop that prints out only odd numbers from 1 to 19 (inclusive)

<details>
<summary><b>Answer:</b></summary>

```kotlin
for (name in 1..19 step 2) {
    println(name)
}

//Alternate
for (num in 1 until 20) {
    if (num % 2 != 0) {
        println(num)
    }
}
```
</details>

### Just Like the "Hot Singles"
1. Print the phrase “BLACKPINK in your area” 3 times

<details>
<summary><b>Answer:</b></summary>

```kotlin
repeat(3) {
    println("BLACKPINK in your area")
}

//Alternate 1
for(x in 1..3) {
    println("BLACKPINK in your area")
}

//Alternate 2
var i = 0
while(i < 3) {
    println("BLACKPINK in your area")
    i++
}
```
</details>

## Classes
### Don't "Have" Class, Create It
1. Create a class named `Hacksprint` that initializes a variable and prints it out when a `Hacksprint` object is created

<details>
<summary><b>Answer:</b></summary>

```kotlin
class Hacksprint(name: String) {
    init {
        println(name)
    }
}
```
</details>

### I'm a People Person
1. Create a class called `Person` that has a constant property `species` that is set to `"human"` automatically for each object. Give the `Person` class have two properties that it gets from its constructor parameters:
   1. a `name` of type `String` that **can't** be changed
   2. a `hairColor` of type `String?` that **can** be changed

<details>
<summary><b>Answer:</b></summary>

```kotlin
class Person(val name: String, var hairColor: String?) {
    val species = "human"
}
```
</details>

2. Change your `Person` class so that, whenever a `Person` is created, it prints "Hello, my name is [*put the name here*]"

<details>
<summary><b>Answer:</b></summary>

```kotlin
class Person(val name: String, var hairColor: String?) {
    val species = "human"
    init {
        println("Hello, my name is ${name}")
    }
}
```
</details>

3. Finally, add a function in the `Person` class that called `sayHairColor` that take no parameters and prints "My hair is [*put the color here*]"
   1. HOLD IT! `hairColor` is **nullable**. You should also check if it is null before printing anything. If it is null, print "I'm bald, and I look fabulous!"

<details>
<summary><b>Answer:</b></summary>

```kotlin
class Person(val name: String, var hairColor: String?) {
    val species = "human"
    init {
        println("Hello, my name is ${name}")
    }
    fun sayHairColor() {
        if(hairColor == null){
            println("I'm bald, and I look fabulous")
        }
        else {
            println("My hair is ${hairColor!!}")
        }
    }
}
```
</details>

## Inheritance

Create a class Shape with a subclass called Rectangle.  Define a variable for Shape that is also defined in Rectangle.

<details>
<summary><b>Answer:</b></summary>

```kotlin
open class Shape {
    open val vertexCount: Int = 0
}
class Rectangle : Shape() {
    override val vertexCount = 4
}
```
</details>


Now create a class Square that is a subclass of Rectangle. Have the Square class contains a function named printVertex() that prints out the number of vertices that it has. 

<details>
<summary><b>Answer:</b></summary>

```kotlin
open class Shape {
    open val vertexCount: Int = 0
}
open class Rectangle : Shape() {
    override val vertexCount = 4
}

class Square : Rectangle() {
    fun print() {
        println(vertexCount)
    }
}
```
</details>

## Bonus
### We Know, You Can't Even
1. Write a function that takes in an `Int` (nonnegative) and returns a `Boolean`.  Return `true` if the number has an odd number of digits.  Otherwise, return `false`. 0 has one digit.

<details>
<summary><b>Answer:</b></summary>

```Kotlin
fun cantEven(num: Int): Boolean {
    var temp = num
    if(temp == 0){
        return true
    }
    var odd = false
    while(temp > 0) {
        temp = temp / 10
        odd = !odd
    }
    return odd
}
```
</details>