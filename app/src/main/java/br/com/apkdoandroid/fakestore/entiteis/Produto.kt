package br.com.apkdoandroid.fakestore.entiteis

data class Produto(
    val category: String,
    val description: String,
    val id: Int,
    val image: String,
    val price: Double,
    val rating: Rating,
    val title: String
) {
    override fun toString(): String {
        return "Produto(category='$category', description='$description', id=$id, image='$image', price=$price, rating=$rating, title='$title')"
    }
}