# Retrofit2Tutorial
A tutorial on how to use the network library Retrofit 2

# Step 1
Add Retrofit and Gson dependencies in app level gradle

    implementation 'com.google.code.gson:gson:2.8.2'
    implementation 'com.squareup.retrofit2:retrofit:2.3.0'
    implementation 'com.squareup.retrofit2:converter-gson:2.3.0'

# Step 2
    a. make the API call with your browser or with softwares like [Postman](https://www.getpostman.com)
       or [CocoaRestClient](http://mmattozzi.github.io/cocoa-rest-client)

    b. copy the json response to http://www.jsonschema2pojo.org/ and generate object java class(es)

    c.  give it the package name and Class name.
        Options ::
        Target language: Java
        Source type: JSON
        Annotation style: GSON
        Use double numbers
        Include getters and setters
        Allow additional properties
        Make classes parcelable

    d.  click on the zip button below the page and download the zip file of the generated classes.
    e.  extract, then copy and paste the classes in your android studio project.
    f.  Here in this example, The network call response is BookSearchResult.
    g.  You can go through the models package to figure out how the classes were generated.
    h.  DO NOT edit the generated classes.

# Step 3

Create Endpoint Interface ::
    public interface ApiEndpointService {

        @GET("volumes")
        Call<BookSearchResult> searchForBook(@Query("q")String bookName);
        //@Query("q") is for attaching parameter names to the url, i.e volumes?q={bookNmae}

        If you are not sure of what the server response would be, use the Object class,
        then you can later convert to any other Object.
        @POST("login")
        Call<Object> loginUser(@Body LoginBody loginBody);
        //@Body is to specify the body that would be sent to the server

    }

# Step 4

Create BASE_URL string
        public static final String BASE_URL = "https://www.googleapis.com/books/v1/";

# Step 5

Create Retrofit Creator class that gives an instance of Retrofit for later use anywhere

    public class RetrofitBuilder {

        public static Retrofit getRetrofit(){
            Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            return retrofit;
        }
    }

# Step 6

In MainActivity ::
 public void searchClickListener(View view){ //button click listener
        String word = searchEditText.getText().toString().trim();
        Retrofit retrofit = RetrofitBuilder.getRetrofit(); //Retrofit instance
        ApiEndpointService apiEndpointService = retrofit.create(ApiEndpointService.class); //Endpoint Interface instance

        Call<BookSearchResult> searchCall = apiEndpointService.searchForBook(word); //Create a Call instance

        //Make the call here
        searchCall.enqueue(new Callback<BookSearchResult>() {
            @Override
            public void onResponse(Call<BookSearchResult> call, Response<BookSearchResult> response) {
                //Callback method if the call was successful
                BookSearchResult bookSearchResult = response.body();
                ArrayList<Item> allBooks = (ArrayList<Item>) bookSearchResult.getItems();
            }

            //Callback method if the call failed
            @Override
            public void onFailure(Call<BookSearchResult> call, Throwable t) {

            }
        });

        //for POST example -> doesn't work
        Call<Object> loginCall =  apiEndpointService.loginUser(new LoginBody("Kante", "0123456789"));

        loginCall.enqueue(new Callback<Object>() {
            @Override
            public void onResponse(Call<Object> call, Response<Object> response) {

            }

            @Override
            public void onFailure(Call<Object> call, Throwable t) {

            }
        });
    }

Thank you, if you have any questions, feel free to open an issue.
