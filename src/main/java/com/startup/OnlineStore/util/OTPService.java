package com.startup.OnlineStore.util;

import com.google.common.cache.LoadingCache;
import java.util.Random;

public class OTPService {
private LoadingCache<String, Integer> otpCache;

    public int generateOTP(String key){
        Random random = new Random();
        int otp = 100000 + random.nextInt(900000);
        otpCache.put(key, otp);
        return otp;
    }
}
