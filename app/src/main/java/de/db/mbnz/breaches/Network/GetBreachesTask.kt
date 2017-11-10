package de.db.mbnz.breaches.Network

import android.nfc.Tag
import android.os.AsyncTask
import android.util.Log
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import de.db.mbnz.breaches.Models.Breach
import java.io.BufferedInputStream
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.lang.reflect.Type
import java.net.HttpURLConnection
import java.net.URL
import java.nio.Buffer


/**
 * Created by mbnz on 08.11.17.
 */

interface AsyncTaskCallback {
    fun onSuccess(output: List<Breach>?)
}

class GetBreachesTask(): AsyncTask<Unit, Unit, String>() {

    public lateinit var delegate: de.db.mbnz.breaches.Network.AsyncTaskCallback

    override fun onPreExecute() {
        super.onPreExecute()
    }

    override fun doInBackground(vararg p0: Unit?): String? {
        var result: String? = ""
        val url = URL(BREACHESURL)
        val httpClient = url.openConnection() as HttpURLConnection
        if (httpClient.responseCode == HttpURLConnection.HTTP_OK) {
            try {
                val stream = BufferedInputStream(httpClient.inputStream)
                val data: String = read(inputStream = stream)
                return data
            } catch (e: Exception) {
                Log.d("", "Error in doInBackground " + e.stackTrace);
            } finally {
                httpClient.disconnect()
            }
        } else {
            Log.d("", "ERROR: ${httpClient.responseCode}")
        }
        return null
    }

    override fun onPostExecute(result: String) {
        super.onPostExecute(result)
        val moshi = Moshi.Builder().build()
        val type: Type = Types.newParameterizedType(List::class.java, Breach::class.java)
        val adapter: JsonAdapter<List<Breach>> = moshi.adapter(type)
        val breaches = adapter.fromJson(result)
        delegate.onSuccess(breaches)
    }

    private fun read(inputStream: InputStream): String {
        val bufferedReader = BufferedReader(InputStreamReader(inputStream))
        val stringBuilder = StringBuilder()
        bufferedReader.forEachLine { stringBuilder.append(it) }
        return stringBuilder.toString()
    }

    companion object BreachesEndpoint {
        val BREACHESURL = "https://haveibeenpwned.com/api/v2/breaches"
    }
}