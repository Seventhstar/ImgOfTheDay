package com.seventhstar.imgoftheday.view

import android.content.Intent
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.seventhstar.imgoftheday.R
import com.seventhstar.imgoftheday.WishesFragmentAdapter
import com.seventhstar.imgoftheday.viewmodel.AppState
import com.seventhstar.imgoftheday.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.wishes_fragment.*

class WishesFragment : Fragment() {

    private lateinit var bottomSheetBehavior: BottomSheetBehavior<ConstraintLayout>

//    private var _binding: WishesFragmentBinding? = null
//    private val binding get() = _binding!!


    private val viewModel: MainViewModel by lazy {
        ViewModelProvider(this).get(MainViewModel::class.java)
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
        return inflater.inflate(R.layout.wishes_fragment, container, false)
//        _binding = WishesFragmentBinding.inflate(inflater, container, false)
//
//        return binding.root
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

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_bottom_bar, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        //Toast.makeText(this, "ewkwkejh", Toast.LENGTH_SHORT)
        val toast = Toast.makeText(context, item.itemId.toString(), Toast.LENGTH_SHORT)
        toast.show()
        when (item.itemId) {
            //R.id.app_bar_fav -> activity?.let { startActivity(Intent(it, ApiBottomActivity::class.java)) }
            R.id.app_bar_settings -> parentFragmentManager.beginTransaction()
                ?.replace(R.id.container, SettingsFragment())?.addToBackStack(null)?.commit()
            android.R.id.home -> {
                activity?.let {
                    BottomNavigationDrawerFragment().show(it.supportFragmentManager, "tag")
                }
            }
//            R.id.app_bar_api -> activity?.let { startActivity(Intent(it, ApiActivity::class.java)) }
        }
        return super.onOptionsItemSelected(item)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView.adapter = adapter

        val divider = DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
        divider.setDrawable(
            context?.let { ContextCompat.getDrawable(it, R.drawable.list_item_separator) }!!
        )
        recyclerView.addItemDecoration(divider)


        viewModel.getLiveData().observe(
            viewLifecycleOwner,
            Observer { renderData(it) }
        )

        viewModel.getLocalWishes()
        //setBottomSheetBehavior(view.findViewById(R.id.bottom_sheet_container))
        setBottomAppBar(view)
    }

    private fun setBottomSheetBehavior(bottomSheet: ConstraintLayout) {
        bottomSheetBehavior = BottomSheetBehavior.from(bottomSheet)
        bottomSheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED
    }

    private fun setBottomAppBar(view: View) {
        val context = activity as MainActivity
        context.setSupportActionBar(view.findViewById(R.id.bottom_app_bar))
        setHasOptionsMenu(true)
        fab.setOnClickListener {
//            if (isMain) {
//                isMain = false
//                bottom_app_bar.navigationIcon = null
//                bottom_app_bar.fabAlignmentMode = BottomAppBar.FAB_ALIGNMENT_MODE_END
//                fab.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_back_fab))
//                bottom_app_bar.replaceMenu(R.menu.menu_bottom_bar_other_screen)
//            } else {
//                isMain = true
//                bottom_app_bar.navigationIcon =
//                    ContextCompat.getDrawable(context, R.drawable.ic_hamburger_menu_bottom_bar)
//                bottom_app_bar.fabAlignmentMode = BottomAppBar.FAB_ALIGNMENT_MODE_CENTER
//                fab.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_plus_fab))
//                bottom_app_bar.replaceMenu(R.menu.menu_bottom_bar)
//            }
        }
    }


    override fun onDestroyView() {
        //adapter.removeListener()
        super.onDestroyView()
        //    _binding = null
    }

    interface OnItemViewClickListener {
        //fun onItemViewClick(film: FilmDTO)
    }

    companion object {
        fun newInstance() = WishesFragment()
        private var isMain = true
    }
}
