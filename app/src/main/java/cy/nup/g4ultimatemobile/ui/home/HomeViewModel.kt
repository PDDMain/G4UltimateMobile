package cy.nup.g4ultimatemobile.ui.home

import android.content.Context
import android.widget.LinearLayout
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import cy.nup.g4ultimatemobile.data.model.User
import cy.nup.g4ultimatemobile.data.repository.UserRepository
import cy.nup.g4ultimatemobile.data.repository.UserRepositoryProvider

class HomeViewModel : ViewModel() {
    private val userRepository by lazy { UserRepositoryProvider.userRepository }

    private val _text = MutableLiveData<String>().apply {
        value = "Welcome to our new app, ${userRepository.userName()}!"
    }

    val text: LiveData<String> = _text
    private val _textBalance = MutableLiveData<String>().apply {
        value = "Balance: ${userRepository.balance()}"
    }

    val textBalance: LiveData<String> = _textBalance
    private val _textMinutes = MutableLiveData<String>().apply {
        value = "Minutes: ${userRepository.minutesLeft()} / ${userRepository.minutesMax()}"
    }

    val textMinutes: LiveData<String> = _textMinutes
    private val _textSms = MutableLiveData<String>().apply {
        value = "Sms: ${userRepository.smsLeft()} / ${userRepository.smsMax()}"
    }

    val textSms: LiveData<String> = _textSms
    private val _textInternet = MutableLiveData<String>().apply {
        value = "Internet: ${userRepository.internetLeft()} / ${userRepository.internetMax()}"
    }

    val textInternet: LiveData<String> = _textInternet
    private val _progressMinutes = MutableLiveData<Int>().apply {
        value = userRepository.progressMinutes()
    }

    val progressMinutes: LiveData<Int> = _progressMinutes
    private val _progressSms = MutableLiveData<Int>().apply {
        value = userRepository.progressSms()
    }

    val progressSms: LiveData<Int> = _progressSms
    private val _progressInternet = MutableLiveData<Int>().apply {
        value = userRepository.progressInternet()
    }

    val progressInternet: LiveData<Int> = _progressInternet
    private val _textPackage = MutableLiveData<String>().apply {
        value = userRepository.packageName()
    }

    val textPackage: LiveData<String> = _textPackage
    fun transactionLayoutInit(transactionLayout: LinearLayout, context: Context?) {
        val transactions = userRepository.allTransactions()

        for (transaction in transactions) {
            val transactionTextView = TextView(context)
            transactionTextView.text = transaction
            transactionTextView.textSize = 16f
            transactionTextView.layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            transactionTextView.setPadding(0, 0, 0, 8) // Adjust padding as needed
            transactionLayout.addView(transactionTextView)
        }

    }
}