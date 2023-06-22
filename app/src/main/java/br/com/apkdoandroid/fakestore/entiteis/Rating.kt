package br.com.apkdoandroid.fakestore.entiteis

data class Rating(
    val count: Int,
    val rate: Double
) {
    override fun toString(): String {
        return "Rating(count=$count, rate=$rate)"
    }
}