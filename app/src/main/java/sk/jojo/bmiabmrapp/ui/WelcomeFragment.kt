package sk.jojo.bmiabmrapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import sk.jojo.bmiabmrapp.R
import sk.jojo.bmiabmrapp.databinding.FragmentWelcomeBinding


class WelcomeFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentWelcomeBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_welcome, container, false)

        binding.startButton.setOnClickListener { view: View ->
            view.findNavController().navigate(
                WelcomeFragmentDirections.actionWelcomeFragmentToInfoFragment()
            )
        }

        return binding.root
    }

}