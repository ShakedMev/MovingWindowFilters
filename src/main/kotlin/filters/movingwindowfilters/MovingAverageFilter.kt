package filters.movingwindowfilters

import java.util.LinkedList

open class MovingAverageFilter(override var window: Int) : MovingWindowFilter() {
    override val calculation = { values: LinkedList<Double> -> values.average()}
}