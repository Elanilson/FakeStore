package br.com.apkdoandroid.fakestore.repositorio

import android.provider.SyncStateContract.Constants
import android.util.Log
import br.com.apkdoandroid.fakestore.entiteis.Produto
import br.com.apkdoandroid.fakestore.helper.TAG
import br.com.apkdoandroid.fakestore.interfaces.FakeStore
import retrofit2.Response
import java.lang.Exception
import javax.inject.Inject

class ProdutosRepositorio @Inject  constructor(private val fakeStore: FakeStore){


    suspend fun  getProdutos () :List<Produto>?{
        var retorno : Response<List<Produto>>? = null
        var produtos : List<Produto>? = emptyList()

        try {
            retorno = fakeStore.getProdutos()
        }catch (e : Exception){
            Log.d(TAG.fakeStore,e.message.toString())
        }

        if(retorno != null){
            if(retorno.isSuccessful){
                produtos = retorno.body()
            }else{
                Log.d(TAG.fakeStore,"Erro: Código - ${retorno.code()} mensagem: ${retorno.message()}")
            }
        }else{
            Log.d(TAG.fakeStore,"Null, não foi possível fazer a conexão")
        }

        return produtos
    }
}