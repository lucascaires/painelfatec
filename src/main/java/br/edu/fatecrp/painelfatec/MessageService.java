package br.edu.fatecrp.painelfatec;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by lucas on 30/06/17.
 */

public interface MessageService {

    public static final String BASE_URL = "http://init4.me/fatec/painel/";
    //public static final String BASE_URL = "http://www.fatecrp.edu.br/wp-json/wp/v2/";



    @GET("posts")
    Call<MessageList> ListMessages();

}
