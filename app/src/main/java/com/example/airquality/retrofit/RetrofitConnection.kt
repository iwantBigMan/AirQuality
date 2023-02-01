package com.example.airquality.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitConnection {

    // 객체를 하나만 생성하는 싱글턴 패턴을 적용한다.
    companion object {
        // API 서버의 주소가 BASE_URL이 된다.
        private const val BASE_URL = "https://api.airvisual.com/v2/"
        private var INSTANCE: Retrofit? = null

        fun getInstance(): Retrofit {
            if (INSTANCE == null) { // null인 경우에만 생성
                INSTANCE = Retrofit.Builder()
                    .baseUrl(BASE_URL) // API 베이스 URL 설정
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return INSTANCE!!
        }
    }
}