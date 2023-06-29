package filters.movingwindowfilters

import java.util.LinkedList

abstract class MovingWindowFilter() {
    /**
     * The number of samples to be included in the calculation. If not enough samples were
     * provided yet, then the calculation will simply use less samples.
     */
    abstract var window: Int

    /**
     * The calculation to use on the samples list in [calculate]
     */
    protected abstract val calculation: (LinkedList<Double>) -> Double

    private val latestSamples = LinkedList<Double>()

    fun calculate(newSample: Double): Double {
        while(latestSamples.size >= window) latestSamples.removeLast()
        latestSamples.addFirst(newSample)
        return calculation.invoke(latestSamples)
    }

    fun reset(newValues: DoubleArray) {
        latestSamples.clear()
        for(i in 0..newValues.size) {
            latestSamples[i] = newValues[i]
        }
    }

    fun reset(newValues: Collection<Double>) {
        reset(newValues.toDoubleArray())
    }

    fun reset(newValue: Double) {
        reset(DoubleArray(window) {newValue})
    }

    fun empty() {
        latestSamples.clear()
    }
}