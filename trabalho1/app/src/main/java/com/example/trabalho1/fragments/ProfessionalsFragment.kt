package com.example.trabalho1.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.example.trabalho1.databinding.FragmentProfessionalsBinding
import com.example.trabalho1.models.Professional
import com.example.trabalho1.repository.ProfessionalsRepository

class ProfessionalsFragment : Fragment() {
    private var param1: String? = null
    private var param2: String? = null
    private var _binding: FragmentProfessionalsBinding? = null
    private lateinit var professionals: ArrayAdapter<Professional>
    private lateinit var professionalsRepository: ProfessionalsRepository

    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, b: Bundle?): View? {
        _binding = FragmentProfessionalsBinding.inflate(inflater, container, false)
        professionalsRepository = ProfessionalsRepository.getInstance()

        var listView = binding.listviewProfessionals;
        professionals = ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, professionalsRepository.getProfessionals())
        listView.adapter = professionals

        return binding.root
    }


}