# DataBindingRecyclerAdapter
A simple universal `RecyclerView.Adapter` based on Android's DataBinding. Created to support the following series on Medium:
- [RecyclerView 2020: a modern way of dealing with lists in Android using DataBinding — Part 1](https://medium.com/@fraggjkee/recyclerview-2020-a-modern-way-of-dealing-with-lists-in-android-using-databinding-d97abf5fb55f)
- [RecyclerView 2020: a modern way of dealing with lists in Android using DataBinding — Part 2](https://medium.com/@fraggjkee/recyclerview-2020-a-modern-way-of-dealing-with-lists-in-android-using-databinding-d97abf5fb55f)

# Installation
**Step 1.** Add the JitPack repository to your build file. Add it in your root build.gradle at the end of repositories:
```gradle
allprojects {
	repositories {
		...
		maven { url 'https://jitpack.io' }
	}
}
```
**Step 2.** Add the dependency
```gradle
dependencies {
    implementation "com.github.fraggjkee:DataBindingRecyclerAdapter:0.1"
}
```
License
----
Apache 2.0
