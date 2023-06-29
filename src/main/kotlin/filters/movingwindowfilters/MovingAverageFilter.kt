package filters.movingwindowfilters

import java.util.LinkedList

/**
 * A class for a moving average filter, a type of low-pass filter with a finite memory.
 * ```
 * Since filters have memory, use a separate instance for every input stream.
 * ```
 * @param window - The number of samples to be included in the median calculation.
 *                 Assuming calculate is called periodically, the period times the
 *                 window is the time frame of the filter. The filter will more-or-less
 *                 cancel out dynamics that happen in a shorter time frame than this,
 *                 and that will also be the approximate phase lag.
 */
open class MovingAverageFilter(override var window: Int) : MovingWindowFilter() {
    override val calculation = { values: LinkedList<Double> -> values.average()}
}