package frc.robot

import java.util.LinkedList

abstract class MovingWindowFilter() {
    abstract var window: Int
    abstract val calculation: (LinkedList<Double>) -> Double

    private val latestValues = LinkedList<Double>()

    fun calculate(newValue: Double): Double {
        while(latestValues.size >= window) latestValues.removeLast()
        latestValues.addFirst(newValue)
        return calculation.invoke(latestValues)
    }

    fun reset(newValues: DoubleArray) {
        latestValues.clear()
        for(i in 0..newValues.size) {
            latestValues[i] = newValues[i]
        }
    }

    fun reset(newValues: Collection<Double>) {
        reset(newValues.toDoubleArray())
    }

    fun reset(newValue: Double) {
        reset(DoubleArray(window) {newValue})
    }

    fun empty() {
        latestValues.clear()
    }
}