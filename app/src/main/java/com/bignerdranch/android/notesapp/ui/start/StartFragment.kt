package com.bignerdranch.android.notesapp.ui.start

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.bignerdranch.android.notesapp.databinding.FragmentStartBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class StartFragment : Fragment() {
    //Dummy start fragment calls a forced type callback after 1 sec

    interface ICallbacks {
        fun onStartScreenEnd()
    }

    private var _binding: FragmentStartBinding? = null
    // This property is only valid between onCreateView and
// onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentStartBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onResume() {
        super.onResume()
        viewLifecycleOwner.lifecycleScope
            .launch(Dispatchers.Default){
                delay(3000L)
                (activity as ICallbacks).onStartScreenEnd()
            }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }



}