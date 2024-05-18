package cy.nup.g4ultimatemobile.data.model

class Transaction(val type: TransactionType, val cost : Long, val date: String) {
    override fun toString(): String = "${type}: $$cost - $date"
}

enum class TransactionType {
    POP_UP,
    BASIC_PACKAGE,
    ADVANCED_PACKAGE,
    VIP_PACKAGE,
    TAX
}
