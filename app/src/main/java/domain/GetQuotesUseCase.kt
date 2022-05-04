package domain

import data.QuoteRepository
import model.QuoteModel
import javax.inject.Inject

class GetQuotesUseCase @Inject constructor(private val repository: QuoteRepository) {
    suspend operator fun invoke() = repository.getAllQuotes()
}