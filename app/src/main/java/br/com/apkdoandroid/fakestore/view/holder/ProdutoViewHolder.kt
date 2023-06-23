package br.com.apkdoandroid.fakestore.view.holder

import androidx.recyclerview.widget.RecyclerView
import br.com.apkdoandroid.fakestore.databinding.ProdutoBinding
import br.com.apkdoandroid.fakestore.entiteis.Produto
import com.bumptech.glide.Glide

class ProdutoViewHolder( private val binding: ProdutoBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(produto: Produto){
        Glide.with(binding.root).load(produto.image).into(binding.imageViewProduto);
        binding.textViewTituloProduto.text = produto.title
        binding.textViewPreco.text = "R$ ${produto.price}"
    }
}