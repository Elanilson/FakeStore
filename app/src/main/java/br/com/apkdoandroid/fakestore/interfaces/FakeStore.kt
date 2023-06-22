package br.com.apkdoandroid.fakestore.interfaces

import br.com.apkdoandroid.fakestore.entiteis.Produto
import retrofit2.Response
import retrofit2.http.GET

interface FakeStore {
    @GET("products")
    suspend fun getProdutos() : Response<List<Produto>>
}