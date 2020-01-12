# Hack Sprint Session 1: Basics of Kotlin
**Date**: January 16th, 2020
**Location**: Covel 227
**Teacher**: Jody Lin

## Resources
**Slides**
*[Session 1- Basics of Kotlin](TODO)

**ACM Membership Attendance Portal**
* [Portal](http://members.uclaacm.com/login)

**Questions**
* [Ask your question here!](TODO)

**Other useful resources**
TODO

## Prerequisites
???Maybe 

## What we'll be learning today
- Data Types
- Control Flow
- Functions
- Classes
- Inheritance

## A Brief History of Kotlin
TODO


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
// java
var name = "Jody"
```

In Kotlin, variables are declared in the **Pascal Notation**. Here's an example.

```kt
// kotlin
val name: String = "Jody"
var age: Int = 19
var gpa: Double = 4.0 //haha i wish :(
```

Let's break down what these mean. 

`val` or `var` specifies that we are declaring a variable. Every time we declare a variable we _must_ start the declaration with `var` or `val`. 

>What's the difference?

>`var` is short for _variable_, which means that we are able to change the value of this _variable_ at any time. In programming, we'll call this type of data _mutable_. 

>`val` is short for _value_, which means that once we assign this a value, we **cannot change the _value_ of the variable**. In programming we would say that `val` is _immutable_. 

Next we have the parameter name. 

>Variable naming in Kotlin follows `camelCase`. This means that you `nameYourVariablesLikeThis`.

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
```kt
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

## Control Flow

### if, else if, and else
Often times when we code, we only want to run code _if_ a certain condition is true. For example, if concert tickets cost $1000 and your bank account has $19, then you probably don't want to buy the ticket. 

In Kotlin, this might look something like this:
```kt
var bankAccount: Int = $19
val kConTix: Int = $1000

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
```kt
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
```kt
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
```kt
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
```kt
repeat(20) {
    println("Go Bruins")
}
```
This will output `Go Bruins` on 20 lines. 

**while(_some condition is true_) {...}**

This will repeat the code block until a certain condition given is false. 

Example:
```kt
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
```kt
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
```kt
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
```kt
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
```kt
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
```kt
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
```kt
fun nameOfFunction(parameter: ParamType, ...) : ReturnType {
    // code to execute here
    return (value with type ReturnType)
}
```

Often times we don't want to explicitly return anything from our function. Perhaps our function only prints something. We can write our function like this:
```kt
fun speakChinese() {
    println("wo ai ni")
}
```
In this example, we do not specify a return type, neither do we return anything. When we write a function like this, Kotlin implicitly returns a type called `Unit`, which means nothing is returned. (If you've languages like C/C++/Java/etc, this is comparable to `void`.)

Writing this out explicity would like like this:
```kt
fun speakChinese(): Unit {
    println("wo ai ni")
}
```

## Classes
Sometimes we need a way to group similar data together. In Kotlin, we are able to use a class to do this. Think of classes as a special more complicated data type that a programmer creates out of pre-existing data types. 

Let's create a simple empty class called **Idol**
```kt
class Idol {
}
```
```kt
// OR because this class is empty, we could also declare it without brackets
class Idol 
```

But this is pretty boring. Let's add some member variables to this class. 
```kt
class Idol {
    name: String = "Solar"
    age: Int = 28
}
```
Now we can instantiate this and access our member variables with the `.` dot operator!
```kt
val singer = Idol()
println(singer.name) // OUTPUT: Solar
println(singer.age) // OUTPUT: 28
```

However, not all singers are going to be named "Solar" and be age 28. Kotlin provides a way to specify how we initialize our class member variables for each object of the class we declare. This is called a **constructor**.

Let's add one to our example class. 
```kt
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

```kt
val solar = Idol("Solar", 28)
val moonbyul = Idol("Moonbyul", 27)

println(solar.name) // OUTPUT: Solar
println(solar.age) // OUTPUT: 28
println(moonbyul.name) // OUTPUT: Moonbyul
println(moonbyul.age) // OUTPUT: 27
```

Okay, so we have a _secondary constructor_, then do we have a _primary constructor_??? We DO in fact have one. 

Let's convert our secondary constructor from the last example to a primary constructor. 
```kt
class Idol(_name: String, _age: Int) {
    val name: String = _name
    var age: Int = _age
}
```
We can call this create objects from with the class the exact same way as before. 

```kt
val hwasa = Idol("Hwasa", 24)
println(hwasa.name) // OUTPUT: Hwasa
println(hwasa.age) // OUTPUT: 24
```

But WAIT, there's more!

As we can see, we have to name our constructor parameter something different from the _actual_ member variable name, otherwise we end up unable to set the member variable in the class. (We can get around this with the `this` keyword, but Kotlin gives us a way to avoid the problem entirely). 

In Kotlin, we can declare our member variables _directly in the constructor_. 

Let's do this with our `name` member variable. 
```kt
class Idol(val name: String, _age: Int) {
    var age: Int = _age
}
```
And then let's do the same with our `age` member variable. 
```kt
class Idol(val name: String, var age: Int) {
}
```
Now that are class is now empty, we can get rid of the brackets all together. 
```kt
class Idol(val name: String, var age: Int)
```

This is equivalent to our original class!


### Member Functions
Let's now add functions to this class. Whenever we instantiate an object of the class we will now be able to use this function on this object. 

Let's continue with out Idol example and add a function that allows our idol to sing. 

```kt
class Idol(val name: String, var age: Int) {
    fun sing() {
        println("My name is " + this.name)
        println("Mama mama moooo")
    }
}
```

We can now use this function when we instantiate an Idol object. 

```kt
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
```kt
class Student(val name: String, var age: Int) {
    fun eatFood() {
        println("I <3 BPlate")
    }
    fun sing() {
        println("Hello darkness my old friend...")
    }
}

class Idol(val name: String, var age: Int) {
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
```kt
class Person (val name: String, var age: Int) {
    fun sing() {
        println("Happy Birthday to you...")
    }
}
```

By default, classes in Kotlin **do not** allow inheritance. We must _open_ the class to inheritance. Thus we prepare our Person class to be open for inheritance by adding the keyword `open` in front. 
```kt
open class Person (val name: String, var age: Int) {
    fun sing() {
        println("Happy Birthday to you...")
    }
}
```

Let's have our Idol and Student class inherit from this class. 
```kt
class Idol(val name: String, var age: Int): Person(name, age) {
}

class Student(val name: String, var age: Int): Person(name, age) {
}
```
In order for Idol and Student to inherit from the person class, we need to add a `:` after the Idol and Student constructor and then call the Person constructor, ensuring to pass in the appropriate parameters. 

Now we can do this:
```kt
val taemin = Idol("Taemin", 26)
val connie = Student("Connie", 20)

println(taemin.age) // OUTPUT: 26
println(connie.age) // OUTPUT: 20
taemin.sing() // OUTPUT: Happy Birthday to you...
connie.sing() // OUTPUT: Happy Birthday to you...
```

As we can see, both Idol and Student are able to use the `sing()` function defined in the Person class! 

We call the Person class the **super class** and Idol and Student **child classes**. 

Okay, but in our example from earlier, Idol had it's own way to sing that differed from Person. Kotlin allows us to _override_ the function in the super class. 

First we specify in the parent class that `sing()` is a function we wish to override in a child class. 
```kt
open class Person (val name: String, var age: Int) {
    open fun sing() {
        println("Happy Birthday to you...")
    }
}
```
Next, we define our own `sing()` functions in Idol and Person with the `override` keyword. 

```kt
class Idol(val name: String, var age: Int): Person(name, age) {
    override fun sing() {
        println("Mama mama moooo")
    }
}

class Student(val name: String, var age: Int): Person(name, age) {
    override fun sing() {
        println("Hello darkness my old friend...")
    }
}
```

Now when we call our code, Idol and Student objects will have their own specialized `sing()` functions called. 

```kt
val taemin = Idol("Taemin", 26)
val connie = Student("Connie", 20)

taemin.sing() // OUTPUT: Mama mama moo
connie.sing() // OUTPUT: Hello darkness my old friend
```

Earlier when we had defined the Student class, we also had an extra function called `eatFood()`, which was not in the Idol class. We can simply add this to our Student class now. 

```kt
class Idol(val name: String, var age: Int): Person(name, age) {
    override fun sing() {
        println("Mama mama moooo")
    }
}

class Student(val name: String, var age: Int): Person(name, age) {
    fun eatFood() {
        println("I <3 BPlate")
    }
    override fun sing() {
        println("Hello darkness my old friend...")
    }
}
```

Now our Students can properly eat and our Idols can't (oof). 
```kt
val taemin = Idol("Taemin", 26)
val connie = Student("Connie", 20)

connie.eatFood() // OUTPUT: I <3 BPlate
taemin.eatFood() // OUTPUT: Error: function doesn't exist in this class
```

As we can see, inheritance is a powerful tool that allows us to generalize classes and then have other classes make them more specific. We can not only have single-level inheritance (like the previous example), we can classes inherit from classes that inherit from _other_ classes.

If this seems like a confusing concept, it will begin to make more sense as you get practice with it. 

# Practice Problems
And those are the basics of Kotlin! Try out these practice problems and begin familiarizing yourself with Kotlin. 

In our future sessions, we will be using Kotlin to control many parts of our Android app, so familiarizing yourself with the syntax will help increase your understanding later on :)




