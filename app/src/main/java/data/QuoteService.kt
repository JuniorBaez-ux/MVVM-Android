package data

import core.RetrofitHelper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import model.QuoteModel
import data.network.QuoteApiClient
import javax.inject.Inject

class QuoteService @Inject constructor(private val api:QuoteApiClient) {
    suspend fun getQuotes(): List<QuoteModel> {
        return withContext(Dispatchers.IO) {
            val response = api.getAllQuotes()
            response.body() ?: emptyList()
        }
    }
}