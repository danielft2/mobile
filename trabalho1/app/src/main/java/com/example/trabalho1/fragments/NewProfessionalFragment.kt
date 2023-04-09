package com.example.trabalho1.fragments

import android.media.MediaPlayer
import android.os.Bundle
import android.util.Log

import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.get
import com.example.trabalho1.R
import com.example.trabalho1.databinding.FragmentNewProfessionalBinding
import com.example.trabalho1.models.Professional
import com.example.trabalho1.repository.ProfessionalsRepository

class NewProfessionalFragment : Fragment(), View.OnClickListener {
    private var _binding: FragmentNewProfessionalBinding? = null
    private lateinit var professionalsRepository: ProfessionalsRepository
    private var mediaPlay: MediaPlayer = MediaPlayer()

    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, b: Bundle?): View? {
        _binding = FragmentNewProfessionalBinding.inflate(inflater, container, false)
        binding.buttonNewProfessional.setOnClickListener(this)
        binding.radioBoy.isChecked = true

        mediaPlay = MediaPlayer.create(activity, R.raw.notificacao)
        professionalsRepository = ProfessionalsRepository.getInstance()

        return binding.root
    }

    override fun onClick(v: View) {
        val name = binding.editName.text.toString()
        val function = binding.spinnerFunction.selectedItem.toString()
        val acess = binding.toogleAcess.isChecked
        var sex = "Homem"
        val sexId = binding.radioGroupSex.checkedRadioButtonId

        if (sexId === R.id.radio_girl) sex = "Mulher"

        if (validationsFields()) {
            val professional = Professional(name, function, acess, sex)
            Log.d("teste", professional.toString())
            professionalsRepository.insertProfessional(professional)
            professionalsRepository.printProfessionals()

            mediaPlay.start();
            Toast.makeText(activity, "Adicionado com sucesso", Toast.LENGTH_SHORT).show()

            clearField()
        } else {
            Toast.makeText(activity, R.string.validation_fields, Toast.LENGTH_SHORT).show()
        }

    }

    private fun validationsFields(): Boolean {
        if (binding.editName.text.toString() == "" &&
            binding.spinnerFunction.selectedItem.toString() == "") {
            return false
        }

        return true
    }

    private fun clearField() {
        binding.editName.setText("")
        binding.toogleAcess.isChecked = false
        binding.radioBoy.isChecked = true
    }
}