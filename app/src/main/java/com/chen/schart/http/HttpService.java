package com.chen.schart.http;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by lichen on 2017/11/29.
 */

public interface HttpService {

    @GET("stock_chart/")
    Flowable<String> getStock(@Query("candle_period") int period, @Query("data_count") int count, @Query("prod_code") String code);

}
