package br.com.apkdoandroid.fakestore.view.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.apkdoandroid.fakestore.entiteis.Produto
import br.com.apkdoandroid.fakestore.entiteis.Resposta
import br.com.apkdoandroid.fakestore.repositorio.ProdutosRepositorio
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repositorio: ProdutosRepositorio) : ViewModel() {

    private val _Produtos = MutableLiveData<List<Produto>>()
    var produtos : LiveData<List<Produto>> = _Produtos

    private val _Resposta = MutableLiveData<Resposta>()
    var resposta : LiveData<Resposta> = _Resposta


    fun getProdutos(){
        CoroutineScope(Dispatchers.Main).launch {
            _Produtos.value = repositorio.getProdutos()
        }
    }
}