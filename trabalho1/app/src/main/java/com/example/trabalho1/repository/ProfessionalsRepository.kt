package com.example.trabalho1.repository

import android.util.Log
import com.example.trabalho1.models.Professional
import kotlin.math.log

class ProfessionalsRepository private constructor() {
    private var professionals: ArrayList<Professional> = ArrayList<Professional>();

    companion object {
        private lateinit var repository: ProfessionalsRepository

        fun getInstance(): ProfessionalsRepository {
            if (!Companion::repository.isInitialized) {
                repository = ProfessionalsRepository()
            }
            return repository
        }
    }

    fun insertProfessional(professional: Professional) {
        professionals.add(professional);
    }

    fun printProfessionals() {
        for (p in professionals) {
            Log.d("Profissional", p.toString())
        }
    }

    fun getProfessionals(): ArrayList<Professional> {
        return professionals
    }
}