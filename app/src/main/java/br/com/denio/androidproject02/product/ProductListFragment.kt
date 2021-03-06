package br.com.denio.androidproject02.product

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView.VERTICAL
import br.com.denio.androidproject02.databinding.FragmentProductsListsBinding

private const val TAG = "ProductsListFragment"

class ProductsListFragment : Fragment() {

    private val productListViewModel: ProductListViewModel by lazy {
        ViewModelProvider(this).get(ProductListViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val binding = FragmentProductsListsBinding.inflate(inflater)
        binding.lifecycleOwner = this
        binding.productListViewModel = productListViewModel
        val itemDecor = DividerItemDecoration(context, VERTICAL)
        binding.rcvProducts.addItemDecoration(itemDecor);
        binding.rcvProducts.adapter = ProductAdapter(ProductAdapter.ProductClickListener
        {
            Log.i(TAG,"Product selected: ${it.name}")
            this.findNavController()
                .navigate(ProductsListFragmentDirections.actionShowProductDetail(it.code))
        })
        return binding.root
    }
}
