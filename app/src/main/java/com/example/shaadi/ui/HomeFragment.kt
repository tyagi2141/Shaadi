package com.example.shaadi.ui

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.shaadi.R
import com.example.shaadi.common.CommonConstant
import com.example.shaadi.databinding.FragmentHomeBinding
import com.example.shaadi.model.Results
import com.example.shaadi.ui.adapter.HomeAdapter
import com.example.shaadi.viewmodel.HomeViewModel
import com.pranavpandey.android.dynamic.toasts.DynamicToast
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch


@AndroidEntryPoint
class HomeFragment : Fragment(), HomeAdapter.OnTabCallback {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private val viewModel: HomeViewModel by viewModels()
    private lateinit var manager: LinearLayoutManager
    private var homeAdapter: HomeAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        manager = LinearLayoutManager(requireContext())
        binding.recyclerView.layoutManager = manager
        homeAdapter = HomeAdapter(eventsList = ArrayList(), this)
        binding.recyclerView.adapter = homeAdapter
        setupView()
    }


    private fun setupView() {

        binding.progressBar.visibility = View.VISIBLE
        viewModel.getApiResponse(requireContext(), 20)
        viewModel.getResult().observe(viewLifecycleOwner, { response ->
            lifecycleScope.launch {

                if (response.isNullOrEmpty()){
                    binding.txtNoData.visibility=View.VISIBLE
                    binding.progressBar.visibility = View.GONE
                }else{
                    binding.txtNoData.visibility=View.GONE
                    binding.progressBar.visibility = View.GONE
                    setAdapter(response)
                }

            }
        })


    }

    private fun setAdapter(response: List<Results>) {

        when (homeAdapter) {
            null -> {
                homeAdapter = HomeAdapter(response, this@HomeFragment)
                binding.recyclerView.adapter = homeAdapter
            }
            else -> {
                homeAdapter?.eventsList = response
                homeAdapter?.notifyDataSetChanged()
            }
        }

    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onSelected(result: Results?, statusType: Int) {
        result?.email?.let { viewModel.updateStatus(statusType, result.primerId, it) }

        if (statusType == CommonConstant.APPROVED) {
            DynamicToast.makeSuccess(
                requireContext(),
                "${result?.name?.first} ${result?.name?.last} ${context?.resources?.getString(R.string.accepted)}"
            ).show();
        } else {
            DynamicToast.makeError(
                requireContext(),
                "${result?.name?.first} ${result?.name?.last} ${context?.resources?.getString(R.string.declined)}"
            ).show();
        }

    }

}


