package sk.jojo.bmiabmrapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import sk.jojo.bmiabmrapp.R
import sk.jojo.bmiabmrapp.data.PersonData
import sk.jojo.bmiabmrapp.databinding.FragmentResultsBinding
import sk.jojo.bmiabmrapp.databinding.FragmentWelcomeBinding
import sk.jojo.bmiabmrapp.utils.FitnessCalculation


class ResultsFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentResultsBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_results, container, false)

        val personData: PersonData

        arguments?.let {
            personData = PersonData(
                    ResultsFragmentArgs.fromBundle(it).gender,
                    ResultsFragmentArgs.fromBundle(it).age,
                    ResultsFragmentArgs.fromBundle(it).height,
                    ResultsFragmentArgs.fromBundle(it).weight
            )

            val fitnessCalculation = FitnessCalculation(personData)

            val bmi = fitnessCalculation.calculateBMI()
            val bmr = fitnessCalculation.calculateBMR()

            binding.bmiEdit.setText(bmi.toString())
            binding.bmrEdit.setText(bmr.toString())
        }

        return binding.root
    }

}