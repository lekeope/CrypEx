package io.edgedev.crypex;

import io.edgedev.crypex.remote.BitCoinService;
import io.edgedev.crypex.remote.EtherService;
import io.edgedev.crypex.remote.RetrofitClient;

/**
 * Created by OPEYEMI OLORUNLEKE on 10/27/2017.
 */

public class ApiUtils {
    private static final String BASE_URL = "https://min-api.cryptocompare.com/";

    public static BitCoinService getBitCoinService() {
        return RetrofitClient.getClient(BASE_URL).create(BitCoinService.class);
    }
    public static EtherService getEtherService() {
        return RetrofitClient.getClient(BASE_URL).create(EtherService.class);
    }
}
