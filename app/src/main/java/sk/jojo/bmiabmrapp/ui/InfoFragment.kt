package sk.jojo.bmiabmrapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import sk.jojo.bmiabmrapp.R
import sk.jojo.bmiabmrapp.databinding.FragmentInfoBinding
import sk.jojo.bmiabmrapp.databinding.FragmentWelcomeBinding


class InfoFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentInfoBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_info, container, false)

        binding.heightBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                binding.heightEdit.setText(progress.toString())
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }

        })

        binding.weightBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                binding.weightEdit.setText(progress.toString())
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }
        })

        binding.heightEdit.setOnFocusChangeListener { view: View, hasFocus: Boolean ->
            binding.heightBar.setProgress(binding.heightEdit.text.toString().toInt())
        }

        binding.weightEdit.setOnFocusChangeListener { v: View, hasFocus: Boolean ->
            binding.weightBar.setProgress(binding.weightEdit.text.toString().toInt())
        }

        binding.calculateButton.setOnClickListener {view: View ->

            val age = binding.ageEdit.text
            val height = binding.heightEdit.text
            val weight = binding.weightEdit.text
            val genderID = binding.radioGroup.checkedRadioButtonId
            val gender: String

            if(genderID == binding.manRadioButton.id){
                gender = "man"
            }
            else{
                gender = "woman"
            }

            if(age.isEmpty() || age.toString().toInt() <= 0
                    || height.toString().toInt() <= 0
                    || weight.toString().toInt() <= 0){
                Toast.makeText(context,"Please insert all value",Toast.LENGTH_LONG).show()
            }
            else{
                view.findNavController().navigate(
                InfoFragmentDirections.actionInfoFragmentToResultsFragment(age.toString().toInt(),
                                                                            height.toString().toInt(),
                                                                            weight.toString().toInt(), gender))

            }
        }


        return binding.root
    }


}