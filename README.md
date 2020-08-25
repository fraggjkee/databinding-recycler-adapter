# DataBindingRecyclerAdapter
A simple universal `RecyclerView.Adapter` based on Android's DataBinding. Created to support the following series on Medium:
- [RecyclerView 2020: a modern way of dealing with lists in Android using DataBinding — Part 1](https://medium.com/@fraggjkee/recyclerview-2020-a-modern-way-of-dealing-with-lists-in-android-using-databinding-d97abf5fb55f)
- [RecyclerView 2020: a modern way of dealing with lists in Android using DataBinding — Part 2](https://medium.com/@fraggjkee/recyclerview-2020-a-modern-way-of-dealing-with-lists-in-android-using-databinding-part-2-df69f0a741f8)

# Installation
**Step 0.** Make sure that your project is [DataBinding-ready](https://developer.android.com/topic/libraries/data-binding/start). Double check that `kotlin-kapt` plugin is [applied](https://stackoverflow.com/a/54197326/984014) to the target module.
 
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
    implementation "com.github.fraggjkee:databinding-recycler-adapter:0.2"
}
```

# Sample project structure
`/sample` folder contains the following examples:
- **[Simple](https://github.com/fraggjkee/databinding-recycler-adapter/tree/master/sample/src/main/java/com/fraggjkee/databindingadapter/simple)**: a minimal functional implementation of a static list. Single view type is shared across all items.
- **[Simple (Multi Type)](https://github.com/fraggjkee/databinding-recycler-adapter/tree/master/sample/src/main/java/com/fraggjkee/databindingadapter/simple_multitype)**: similar to **Simple** sample but additionally demonstrates how to use different view types within a single `RecyclerView`.
- **[Dynamic List](https://github.com/fraggjkee/databinding-recycler-adapter/tree/master/sample/src/main/java/com/fraggjkee/databindingadapter/dynamic)**: a more advanced implementation demonstrating how to update the adapter's content (add, remove & reorder operations). Additionally provides a primitive implementation of click handling.
- **[Dynamic Items](https://github.com/fraggjkee/databinding-recycler-adapter/tree/master/sample/src/main/java/com/fraggjkee/databindingadapter/dynamic_items)**: Demonstrates how to update individual items without touching the adapter and it's underlying dataset. Additionally provides a primitive implementation of click handling.
- **Advanced**: TODO

License
----
Apache 2.0
