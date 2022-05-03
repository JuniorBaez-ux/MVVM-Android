package ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import domain.GetQuotesUseCase
import kotlinx.coroutines.launch
import model.QuoteModel
import model.QuoteProvider

class QuoteViewModel : ViewModel() {

    val quoteModel = MutableLiveData<QuoteModel>()

    fun randomQuote() {

    }
    val isLoading = MutableLiveData<Boolean>()
    var getQuotesUseCase = GetQuotesUseCase()

    fun onCreate() {
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = getQuotesUseCase()

            if(!result.isNullOrEmpty()){
                quoteModel.postValue(result[0])
                isLoading.postValue(false)
            }
        }
    }
}