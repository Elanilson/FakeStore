package br.com.apkdoandroid.fakestore.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.apkdoandroid.fakestore.databinding.ProdutoBinding
import br.com.apkdoandroid.fakestore.entiteis.Produto
import br.com.apkdoandroid.fakestore.view.holder.ProdutoViewHolder

class ProdutoAdapter : RecyclerView.Adapter<ProdutoViewHolder>() {

    private var produtos : List<Produto> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProdutoViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding  = ProdutoBinding.inflate(inflater,parent,false)

        return ProdutoViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return produtos.size
    }

    override fun onBindViewHolder(holder: ProdutoViewHolder, position: Int) {
        holder.bind(produtos.get(position))
    }

    fun attack(produtos : List<Produto>){
        this.produtos = produtos
        notifyDataSetChanged()
    }
}