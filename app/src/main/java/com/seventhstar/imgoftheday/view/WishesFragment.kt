package com.seventhstar.imgoftheday.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.seventhstar.imgoftheday.R
import com.seventhstar.imgoftheday.WishesFragmentAdapter
import com.seventhstar.imgoftheday.databinding.WishesFragmentBinding
import com.seventhstar.imgoftheday.viewmodel.AppState
import com.seventhstar.imgoftheday.viewmodel.MainViewModel

class WishesFragment : Fragment() {

    private var _binding: WishesFragmentBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: MainViewModel

    companion object {
        fun newInstance() = WishesFragment()
    }

    private val adapter = WishesFragmentAdapter(object : OnItemViewClickListener {
//        override fun onItemViewClick(film: FilmDTO) {
//            val manager = activity?.supportFragmentManager
//            if (manager != null) {
//                val bundle = Bundle()
//                bundle.putParcelable(DetailsFragment.BUNDLE_EXTRA_DTO, film)
//                manager.beginTransaction()
//                    .replace(R.id.container, DetailsFragment.newInstance(bundle))
//                    .addToBackStack("")
//                    .commitAllowingStateLoss()
//            }
//        }
    })

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = WishesFragmentBinding.inflate(inflater, container, false)

        return binding.root
    }


    private fun renderData(appState: AppState) {
        when (appState) {
            is AppState.Success -> {
                val wishesData = appState.wishesData
                adapter.setData(wishesData)
            }
            is AppState.Loading -> {
//                binding.loadingLayout.visibility = View.VISIBLE
            }
            is AppState.Error -> {
//                binding.loadingLayout.visibility = View.GONE
//                Snackbar
//                    .make(binding.mainView, getString(R.string.error), Snackbar.LENGTH_INDEFINITE)
//                    .setAction(getString(R.string.reload)) { viewModel.getFilmsFromLocalStorage() }
//                    .show()
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerView.adapter = adapter

        val divider = DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
        divider.setDrawable(
            context?.let { ContextCompat.getDrawable(it, R.drawable.list_item_separator) }!!
        )
        binding.recyclerView.addItemDecoration(divider)


        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel.getLiveData().observe(
            viewLifecycleOwner,
            Observer { renderData(it) }
        )

        viewModel.getLocalWishes()
    }

    override fun onDestroyView() {
        //adapter.removeListener()
        super.onDestroyView()
        _binding = null
    }

    interface OnItemViewClickListener {
        //fun onItemViewClick(film: FilmDTO)
    }
}
