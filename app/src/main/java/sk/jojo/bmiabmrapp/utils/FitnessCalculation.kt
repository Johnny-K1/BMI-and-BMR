package sk.jojo.bmiabmrapp.utils

import sk.jojo.bmiabmrapp.data.PersonData

class FitnessCalculation(val personData: PersonData) {

    fun calculateBMI(): Double{
        val bmi =
                personData.weight.toDouble() /
                        ( (personData.height.toDouble() / 100 )
                                * (personData.height.toDouble() / 100) )
        return Math.round(bmi * 10) / 10.0
    }

    fun calculateBMR(): Long{
        val bmr:Double
        if(personData.gender.equals("man")){
            bmr = 10 * personData.weight + 6.25 * personData.height - 5 * personData.age + 5
        }else{
            bmr = 10 * personData.weight + 6.25 * personData.height - 5 * personData.age - 161
        }
        return Math.round(bmr)
    }
}