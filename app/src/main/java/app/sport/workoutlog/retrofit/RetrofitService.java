package app.sport.workoutlog.retrofit;

import com.google.gson.Gson;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitService {
    private Retrofit retrofit;

    public RetrofitService(){
        initializeRetrofit();
    }

    private void initializeRetrofit() {

        final OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .readTimeout(30, TimeUnit.SECONDS)
                .connectTimeout(30, TimeUnit.SECONDS)
                .build();

        retrofit =  new Retrofit.Builder()
                .baseUrl("http://10.183.238.198:9000")
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();

    }

    public Retrofit getRetrofit(){
        return retrofit;
    }
}
