package cy.nup.g4ultimatemobile.data.repository

import cy.nup.g4ultimatemobile.data.model.PackageType
import cy.nup.g4ultimatemobile.data.model.Transaction
import cy.nup.g4ultimatemobile.data.model.TransactionType
import cy.nup.g4ultimatemobile.data.model.User

class UserRepository {
    private val user = User("Augusta", PackageType.BASIC, 10, 42, 2, 100)
    private val transactions = mutableListOf(
        Transaction(TransactionType.POP_UP, 90, "18/05/2024"),
        Transaction(TransactionType.POP_UP, 10, "17/05/2024"),
        Transaction(TransactionType.BASIC_PACKAGE, 20, "01/05/2024"),
        Transaction(TransactionType.POP_UP, 20, "06/05/2024"),
        Transaction(TransactionType.BASIC_PACKAGE, 20, "01/04/2024"),
        Transaction(TransactionType.POP_UP, 20, "17/03/2024"),
        Transaction(TransactionType.ADVANCED_PACKAGE, 40, "01/03/2024"),
        Transaction(TransactionType.ADVANCED_PACKAGE, 40, "01/02/2024"),
        Transaction(TransactionType.BASIC_PACKAGE, 20, "01/01/2024"),
        Transaction(TransactionType.POP_UP, 100, "17/03/2024"),
        Transaction(TransactionType.TAX, 2, "31/12/2023"),
    )

    fun userName(): String = user.name
    fun balance(): String = "$${user.balance}"
    fun minutesLeft(): String = (user.packageType.minuteMax - user.minutesUsed).toString()
    fun smsLeft(): String = (user.packageType.smsMax - user.smsUsed).toString()
    fun internetLeft(): String = "${user.packageType.internetMax - user.internetUsed} GB"
    fun minutesMax(): String = user.packageType.minuteMax.toString()
    fun smsMax(): String = user.packageType.smsMax.toString()
    fun internetMax(): String = "${user.packageType.internetMax} GB"
    fun progressMinutes(): Int = 100 - (100 * user.minutesUsed / user.packageType.minuteMax).toInt()
    fun progressSms(): Int = 100 - (100 * user.smsUsed / user.packageType.smsMax).toInt()
    fun progressInternet(): Int = 100 - (100 * user.internetUsed / user.packageType.internetMax).toInt()

    fun packageName(): String = user.packageType.packageName
    fun allTransactions(): List<String> = transactions.map { it.toString() }
}
