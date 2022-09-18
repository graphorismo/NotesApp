package com.bignerdranch.android.notesapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.bignerdranch.android.notesapp.databinding.FragmentLoadBinding

private const val ARG_TITLE = "ARG_FRAGMENT_LOAD_TITLE"

/**
 * A simple [Fragment] subclass.
 * Use the [LoadFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class LoadFragment(var callbacks: ICallbacks) : Fragment() {

    interface ICallbacks {
        fun onLoadEnd()
    }

    private var _binding: FragmentLoadBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    val activityViewModel: MainViewModel by activityViewModels()


    private var title: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            title = it.getString(ARG_TITLE)
            if(title == null) title = "LOADING"
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        _binding = FragmentLoadBinding.inflate(inflater, container, false)
        binding.textView.setText(title)
        val view = binding.root
        return view
    }

    override fun onStart() {
        super.onStart()
        //TODO: Add database and load data from it here
        activityViewModel.appModel.fillWithDummyData()
        callbacks.onLoadEnd()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    companion object {
        @JvmStatic fun newInstance(callbacks: ICallbacks,titleParam: String = "Loading") =
                LoadFragment(callbacks).apply {
                    arguments = Bundle().apply {
                        putString(ARG_TITLE, titleParam)
                    }
                }
    }
}