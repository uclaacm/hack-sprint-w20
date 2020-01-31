
# Hack Sprint Session 4: Navigation

**Date**: February 6, 2020
**Location**: Covel 227
**Teacher**: Galen Wong and Alex Xia

## Resources

- [Session 4 – Dive Into Android (TODO)]()

**ACM Membership Attendance Portal**

- [Portal](http://members.uclaacm.com/login)

**Questions**
Please join our Facebook page for announcements and more! We will do our best to answer questions on our page every week.

- [Facebook Page](https://www.facebook.com/groups/1399200097134287)

**Other useful resources**

- [Kotlin Documentation](https://kotlinlang.org/docs/reference/)
- [Interactive Kotlin Tutorial](https://blog.jetbrains.com/blog/2019/12/05/jetbrains-academy-kotlin/)
- [Google Codelabs](https://codelabs.developers.google.com/codelabs/kotlin-android-training-welcome/index.html#1)

## What is "Gradle"?

## What are Fragments?

## How to Make a New Fragment

Let's make a few fragments. To create a fragment, 
right click on the Project View and go to 
_New_ > _Fragment_ > _Fragment (Blank)_.

![](images/new_fragment.gif)

The _Fragment Name_ should be in CamelCase, and usually
the naming should be `XxxFragment`.
Uncheck the box for "_Include fragment factory methods?_"
and "_Include interface methods?_".

![](images/new_framgent.png)

Once you have created a fragment, there will be 
two new files generated. One under the `java` folder
and another one under `res/layout`. 
Let's say your new fragment is named `NewFragment`.
The new kotlin file will be named `NewFragment`, 
and the layout file associated with the new fragment
will be named `fragment_new`.

![](images/new_fragment_files.png)

Now you know how to create a fragment, let's create 
the different fragments that we need to complete our 
app!

> __Task__: Create 3 fragments called `StartFragment`,
> `GameFragment`, `ScoreFragment`.


The three new fragments you just made have empty
layout files (click on them to see for yourself).
Let's populate the layout with what we want. 

You can copy the layout XML directly into the 
fragments XML layout files. You can copy from the 
files here:
- [fragment_start.xml](code_src/fragment_start.xml)
- [fragment_game.xml](code_src/fragment_score.xml)
- [fragment_score.xml](code_src/fragment_game.xml)

> If you want a challenge, try to replicate the design 
> just by looking at the picture below.

If you have copied the layout correctly, you
should see the layout as follow:

<figure align=center>

<img src="images/fragment_start.png" width="250px">

<figcaption>
fragment_start.xml
</figcaption>
</figure>


<figure align=center>

<img src="images/fragment_game.png" width="250px">

<figcaption>
fragment_game.xml
</figcaption>
</figure>

<figure align=center>

<img src="images/fragment_score.png" width="250px">

<figcaption>
fragment_score.xml
</figcaption>
</figure>


## How to Navigate: Introduction to Navigation Graph

Now we have different fragments, we need to "relate"
them to each other. Meaning, how we navigate through
the different fragments. In Android, we can define
a __navigation graph__. 


To support navigation, we need to introduce some libraries.
We add the following two lines to the `build.gradle (Module: App)`. 

![](images/navigation_dep.png)

**Android Studio should prompt you at the top, asking you 
to sync the project be sure to click _Sync Now_.**

----

Our application has an extremely basic flow:

> `StartFragment` -> `GameFragment` -> `ScoreFragment`

After `ScoreFragment`, we go back to `StartFragment`.

Just now, I have basically described the navigation
graph in words. To create a navigation graph in Android
Studio. Right click on the Project View and go to 
_New_ > _Android Resource File_. 


![](images/new_navigation.gif)

In the new resource file dialog, set name to 
`navigation.xml`, and select "Resource type"
as `Navigation`. 

![](images/new_navigation.png)


If a navigation graph is created successfully, 
you should see it under the `res` folder. 
It will be in `res/navigation/navigation.xml`.


Right now, it is empty. Let's put our fragments into 
the navigation graph. 

![](images/add_fragment_in_nav.gif)

After adding all of our three fragments into the navigation
graph, link our fragments together. 

![](images/link_frag.gif)



