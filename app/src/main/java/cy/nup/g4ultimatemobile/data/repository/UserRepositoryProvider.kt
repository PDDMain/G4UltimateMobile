package cy.nup.g4ultimatemobile.data.repository

object UserRepositoryProvider {
    val userRepository: UserRepository by lazy {
        UserRepository()
    }
}