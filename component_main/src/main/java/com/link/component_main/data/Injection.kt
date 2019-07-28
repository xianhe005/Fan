package com.link.component_main.data

import com.link.component_main.data.source.http.HttpDataSourceImpl
import com.link.component_main.data.source.http.HttpService
import com.link.component_main.data.source.local.LocalDataSourceImpl
import com.link.general_network.RetrofitClient

class Injection {

    companion object {

        fun provideRepository(): MainRepository {

            val service: HttpService = RetrofitClient.getInstance().create(HttpService::class.java)
            //网络数据源
            val httpService = HttpDataSourceImpl.getInstance(service)
            //本地数据源
            val localService = LocalDataSourceImpl()

            return MainRepository.getInstance(httpService, localService)
        }

    }
}