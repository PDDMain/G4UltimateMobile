package cy.nup.g4ultimatemobile.data.model

enum class PackageType(val packageName: String, val minuteMax: Long, val smsMax : Long, val internetMax : Long) {
    NO_PACKAGE("Expired package", 0, 0,0),
    BASIC("Basic package", 500, 50, 10),
    ADVANCED("Advanced package", 1000, 100, 50),
    VIP("Package for VIP", 10000, 1000, 100)
}
