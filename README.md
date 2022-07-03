RawG game API Example Implementation (Future Changes expected and inline by adding ** Data ** and ** Domain ** Layers)
Google recommended app architecture MVVM with their official guidelines, includes:
 - ViewModel

 - LiveData

 - Hilt (for dependency injection)

 - Kotlin Coroutines

 - Retrofit (Network calls)

 - JetPack Compose binding (To get rid of findViewById)

 - Navigation Component (Navigating between different screens. [See!](https://developer.android.com/guide/navigation)

 - Safe Args (Passing data between fragments)

 [Guide!](https://developer.android.com/jetpack/guide#recommended-app-arch)


** Use vector drawables instead of pngs **

** JetPack Navigation Component **
                              A navigation graph is defined under res/navigation directory which contains all the screens in our app. This graph has actions like moving from one screen
                              to another and passing any data between screens. These screens are all fragments it's just like Story board in iOS.
                              If any new screen is required to be designed it should be added in graph.

** ViewModel **
           Each screen has a separate viewModel class to store and manage UI related data in a lifecycle conscious way. It allows data to survive configuration changes such as screen rotation.


** NetworkRepository **
                    All logic should come here to access data sources and if we want to save data to local storage if required

** RemoteDataSource **
                    Data source class which is getting data from Retrofit API service

                    [Guide!](https://developer.android.com/jetpack/guide#fetch-data)

** APIsService **
              Interface for Retrofit that get methods with end points and the data and returns results of WebAPI

** Resource **
           For loading, error and success statuses that need to be shown at any screen
           A helper class which helps in encapsulating repository responses based on response state (could be success/error)
           Also used in fragments to display values based on states
           A Fragment observing a LiveData object and updates it's views whatever API state is error or success.


** BaseResponse **
                   Using Resource helper class return success data or error with messages

** AutoClearedValue **
                    Garbage collection of fragment views to release memory of dataBinding of fragments while having transactions
                    like replacing fragment with another and adding the one to backStack
                    [Google Samples!](https://github.com/android/architecture-components-samples/blob/master/GithubBrowserSample/app/src/main/java/com/android/example/github/util/AutoClearedValue.kt)

** Logs **
       Timber is used to see debug logs in case of API callings See in MainApplication
       if (BuildConfig.DEBUG) {
                   Timber.plant(Timber.DebugTree())
               }
