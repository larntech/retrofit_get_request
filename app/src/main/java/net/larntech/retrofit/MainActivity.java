package net.larntech.retrofit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import net.larntech.retrofit.adapter.UserAdapter;
import net.larntech.retrofit.model.response.UserResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements UserAdapter.ClickListener{


    UserAdapter userAdapter;
    RecyclerView recyclerView;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);
        this.setSupportActionBar(toolbar);
        this.getSupportActionBar().setTitle("");

        recyclerView = findViewById(R.id.recyclerView);

        fetchUsers();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));

        userAdapter = new UserAdapter(this);





    }



    public void fetchUsers(){


        Call<List<UserResponse>> userResponseCall = ApiClient.getService().getAllUsers();
        userResponseCall.enqueue(new Callback<List<UserResponse>>() {
            @Override
            public void onResponse(Call<List<UserResponse>> call, Response<List<UserResponse>> response) {

                if(response.isSuccessful()){
                    List<UserResponse> userResponses  = response.body();

                    userAdapter.setData(userResponses);
                    recyclerView.setAdapter(userAdapter);
                }

            }

            @Override
            public void onFailure(Call<List<UserResponse>> call, Throwable t) {
            }
        });



    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search,menu);

        MenuItem menuItem = menu.findItem(R.id.searchView);
        SearchView searchView = (SearchView) menuItem.getActionView();
        searchView.setMaxWidth(Integer.MAX_VALUE);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                userAdapter.getFilter().filter(newText);

                return true;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void clickedItem(UserResponse userResponse) {
        Log.e("TAG","======");
        Log.e("userResponse",userResponse.toString());
        startActivity(new Intent(MainActivity.this,MoreDetailsActivity.class).putExtra("data",userResponse));

    }
}
