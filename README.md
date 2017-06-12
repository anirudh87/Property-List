# Property-List

Property List Project

This project consists of a listing of Properties which are fetched from Domain's REST API and displayed in a vertical RecyclerView. 
On any property click, it will show details in a new screen.

Here are the major features of this project:
1. Built in MVVM architecture using Android Databinding to bind views with ViewModels.
2. Uses Single Activity and multiple Fragments structure. Activity behaves as the container of all screens and handling all life cycle callbacks.
3. Network operations are handled in RequestManager class which implements Retrofit 2 and RxAndroid library to make asynchronous network API calls. An AsyncTask has also been created to download the images.
4. Custom data binding is implemented using BindingAdapter to load images in ImageViews using Picasso library.
5. Dependency Injection has been implemented using Dagger 2 library.
6. Application supports both Phone and Tablet screens. For tablets, it has double pane layout which shows both Property List and Property Details on same screen.
7. Application supporty both Portrait and Landscape modes and retain the fragments during orientation change without reloading data from server.
8. Material components added in the layout. e.g: CoordinateLayout, SnackBar for toast messages.
9. Separate Styles have been created using style hierarchy for all layout elements.
10. Created Unit Test using Mockito and JUnit to test ViewModel functionality
11. Release Keystore and a signed build has also been added in this repository. 
