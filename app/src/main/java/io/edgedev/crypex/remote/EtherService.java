package io.edgedev.crypex.remote;

import io.edgedev.crypex.EtherResponse;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by OPEYEMI OLORUNLEKE on 10/27/2017.
 */

public interface EtherService {
    @GET("/data/price?fsym=ETH&tsyms=BTC,NGN,USD,EUR,GBP,CNY,JPY,INR,SGD,TWD,BHD,MXN,OMR,MYR,NZD,SEK,RUB,CHF,NOK,BRL,TRY,AUD,HKD,ZAR")
    Call<EtherResponse> getCurrencies();
}
