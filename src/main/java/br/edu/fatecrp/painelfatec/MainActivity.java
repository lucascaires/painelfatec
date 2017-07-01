package br.edu.fatecrp.painelfatec;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainActivity extends AppCompatActivity {



    private RecyclerView mRecyclerView;
    private LinearLayoutManager mLinearLayoutManager;
    private MessageAdapter mAdapter;

    ArrayList<Message> message = new ArrayList<Message>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //RecyclerView implemetação
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mLinearLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLinearLayoutManager);


        //Retrofit implementação
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(MessageService.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        MessageService service = retrofit.create(MessageService.class);

        Call<MessageList> lista = service.ListMessages();

        lista.enqueue(new Callback<MessageList>() {
            @Override
            public void onResponse(Call<MessageList> call, Response<MessageList> response) {
                if(response.isSuccessful()) {
                    Log.e("LOG", "Sucesso!");
                    MessageList result_list = response.body();
                    mAdapter = new MessageAdapter(result_list.messages);
                    mRecyclerView.setAdapter(mAdapter);
                } else {
                    Log.e("LOG", "Erro:" + response.code());
                }
            }

            @Override
            public void onFailure(Call<MessageList> call, Throwable t) {
                Log.e("LOG", "Erro:" + t.getMessage());
            }
        });




    }
}
