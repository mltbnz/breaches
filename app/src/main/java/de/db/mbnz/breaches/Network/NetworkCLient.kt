package de.db.mbnz.breaches.Network

import okhttp3.*
import java.io.InputStream

/**
 * Created by mbnz on 08.11.17.
 */

open class NetworkClient {

    fun get(url: String): InputStream? {
        val request = Request.Builder()
                .url(url)
                .build()
        val response = OkHttpClient()
                .newCall(request)
                .execute()
        return response.body()?.byteStream()
    }

}