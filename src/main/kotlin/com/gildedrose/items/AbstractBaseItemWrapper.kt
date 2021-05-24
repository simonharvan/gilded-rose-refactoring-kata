package com.gildedrose.items

import com.gildedrose.Item
import com.gildedrose.factory.Updatable

abstract class AbstractBaseItemWrapper(val item: Item) : Updatable {
    override fun update() {
        if (item.sellIn > 0) {
            addQuality(getBeforeSellInDecreaseRate())
        }

        if (item.sellIn <= 0) {
            addQuality(getAfterSellInDecreaseRate())
        }

        item.sellIn += getSellInMinusOnUpdate()
    }

    private fun addQuality(amount: Int) {
        val quality = item.quality + amount
        when {
            quality > getMaxQuality() -> {
                item.quality = getMaxQuality()
            }
            quality < getMinQuality() -> {
                item.quality = getMinQuality()
            }
            else -> {
                item.quality = quality
            }
        }
    }

    private fun getMinQuality(): Int {
        return 0
    }

    abstract fun getBeforeSellInDecreaseRate(): Int
    abstract fun getAfterSellInDecreaseRate(): Int
    abstract fun getMaxQuality(): Int
    abstract fun getSellInMinusOnUpdate(): Int


    companion object {
        const val SELL_IN_MINUS = 1
    }
}
