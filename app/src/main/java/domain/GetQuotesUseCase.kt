package domain

import data.QuoteRepository
import data.database.entities.toDatabase
import domain.model.Quote
import model.QuoteModel
import javax.inject.Inject

class GetQuotesUseCase @Inject constructor(private val repository: QuoteRepository) {
    suspend operator fun invoke():List<Quote> {
        val quotes = repository.getAllQuotesFromApi()

        return if (quotes.isNotEmpty()){

            repository.insertQuotes(quotes.map {it.toDatabase()})
            quotes
        }
        else{
            repository.getAllQuotesFromDatabase()
        }
    }
}