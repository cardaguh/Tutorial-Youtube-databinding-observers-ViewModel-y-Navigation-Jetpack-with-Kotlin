package com.example.databindingejemplo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.databindingejemplo.databinding.ActivityMainBinding
import com.example.databindingejemplo.databinding.FragmentHomeBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"
private const val ARG_PARAM3 = "param3"


/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var param3: String? = null
    var value: String? = null

    lateinit var binding: FragmentHomeBinding
    lateinit var viewModel: MainActivityViewModel
    var count: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        binding.myViewModel = viewModel

        viewModel.changeCount.observe(viewLifecycleOwner, Observer {
            binding.textView.text = it.toString()
            value = it.toString()
        })

        param1 = binding.textView.text.toString()

        //arguments?.getString(binding.textView.text.toString())
        val valueToPass = param1.toString()
        val bundleSend = Bundle()
        bundleSend.putString("valueSend", valueToPass)
        viewModel.navigateSecond.observe(viewLifecycleOwner, Observer {
            findNavController().navigate(R.id.action_homeFragment2_to_detailFragment2, bundleSend)
        })
        // Inflate the layout for this fragment

        return binding.root
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment HomeFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                    putString(ARG_PARAM3, param3)
                }
            }
    }
}