package br.com.apkdoandroid.fakestore.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.apkdoandroid.fakestore.R
import br.com.apkdoandroid.fakestore.adapter.ProdutoAdapter
import br.com.apkdoandroid.fakestore.databinding.ActivityMainBinding
import br.com.apkdoandroid.fakestore.helper.TAG
import br.com.apkdoandroid.fakestore.view.model.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var viewModel  : MainViewModel
    private val bindding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val adapter = ProdutoAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(bindding.root)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        bindding.recyclerViewProdutos.layoutManager = GridLayoutManager(this,2,RecyclerView.VERTICAL,false)
        bindding.recyclerViewProdutos.adapter = adapter

        observe()
    }

    private fun observe() {
        viewModel.produtos.observe(this){
            adapter.attack(it)
            Log.d(TAG.fakeStore,it.toString())
        }
    }

    override fun onResume() {
        super.onResume()
        viewModel.getProdutos()
    }
}