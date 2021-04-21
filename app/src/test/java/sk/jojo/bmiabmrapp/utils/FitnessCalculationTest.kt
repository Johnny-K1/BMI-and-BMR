package sk.jojo.bmiabmrapp.utils

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import sk.jojo.bmiabmrapp.data.PersonData

internal class FitnessCalculationTest{
    lateinit var personDataMan: PersonData
    lateinit var personDataMan2: PersonData
    lateinit var personDataWoman: PersonData
    lateinit var personDataWoman2: PersonData

    lateinit var fitnessCalculations: FitnessCalculation
    lateinit var fitnessCalculations2: FitnessCalculation
    lateinit var fitnessCalculationswoman: FitnessCalculation
    lateinit var fitnessCalculationswoman2: FitnessCalculation

    @BeforeEach
    internal fun setUp(){
        personDataMan = PersonData("man", 32, 197, 102)
        personDataMan2 = PersonData("man", 50, 160, 85)
        personDataWoman = PersonData("woman", 32, 197, 102)
        personDataWoman2 = PersonData("woman", 50, 160, 85)

        fitnessCalculations = FitnessCalculation(personDataMan)
        fitnessCalculations2 = FitnessCalculation(personDataMan2)
        fitnessCalculationswoman = FitnessCalculation(personDataWoman)
        fitnessCalculationswoman2 = FitnessCalculation(personDataWoman2)
    }

    @Test
    fun age32Male102Weight197HeightBmiIs26point3(){
        assertEquals(26.3, fitnessCalculations.calculateBMI())
    }

    @Test
    fun age50Male85Weight160HeightBmiIs33point2() {
        assertEquals(33.2, fitnessCalculations2.calculateBMI())
    }

    @Test
    fun age50Male85Weight160HeightBmiIsNot12point2() {
        assertNotEquals(12.2, fitnessCalculations2.calculateBMI())
    }

    @Test
    fun age32Male102Weight197HeightBmrIs2096() {
        assertEquals(2096, fitnessCalculations.calculateBMR())
    }

    @Test
    fun age50Male85Weight160HeightBmrIs1605() {
        assertEquals(1605, fitnessCalculations2.calculateBMR())
    }

    @Test
    fun age32Woman102Weight197HeightBmrIs1930() {
        assertEquals(1930, fitnessCalculationswoman.calculateBMR())
    }

    @Test
    fun age50Woman85Weight160HeightBmrIs1439() {
        assertEquals(1439, fitnessCalculationswoman2.calculateBMR())
    }

    @Test
    fun age50Woman85Weight160HeightBmiIs33point2(){
        assertEquals(33.2, fitnessCalculationswoman2.calculateBMI())
    }
}

