package filters.movingwindowfilters

import java.util.LinkedList

class MovingMedianFilter(override var window: Int) : MovingWindowFilter() {
    override val calculation = {values: LinkedList<Double> -> median(values) }
}

private fun median(linkedList: LinkedList<Double>): Double {
    val list = linkedList.toDoubleArray()
    val listSize = list.size
    return if(listSize % 2 == 0) {
        (list[listSize / 2] + list[(listSize / 2) + 1]) / 2.0
    }
    else {
        list[((listSize / 2) + 0.5).toInt()]
    }
}