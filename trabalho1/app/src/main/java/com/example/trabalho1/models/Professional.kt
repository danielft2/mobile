package com.example.trabalho1.models

class Professional(var name: String, var function: String, var acess: Boolean, var sex: String) {
    override fun toString(): String {
        return "${name} - ${sex}\n"  +
                "${function}\n" +
                "Acesso especial: ${if(acess) "Sim" else "Não"}"
    }
}