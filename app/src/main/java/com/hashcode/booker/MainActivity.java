package com.hashcode.booker;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

import com.hashcode.booker.models.BookSearchResult;
import com.hashcode.booker.models.Item;
import com.hashcode.booker.models.LoginBody;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    EditText searchEditText;
    Button searchButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        searchButton = findViewById(R.id.search_button);
        searchEditText = findViewById(R.id.edt_search);

        searchEditText.setOnClickListener(this::searchClickListener);


    }

    public void searchClickListener(View view){
        String word = searchEditText.getText().toString().trim();
        Retrofit retrofit = RetrofitBuilder.getRetrofit();
        ApiEndpointService apiEndpointService = retrofit.create(ApiEndpointService.class);

        Call<BookSearchResult> searchCall = apiEndpointService.searchForBook(word);

        searchCall.enqueue(new Callback<BookSearchResult>() {
            @Override
            public void onResponse(Call<BookSearchResult> call, Response<BookSearchResult> response) {
                BookSearchResult bookSearchResult = response.body();
                ArrayList<Item> allBooks = (ArrayList<Item>) bookSearchResult.getItems();
            }

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
