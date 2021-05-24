package com.gildedrose.items

import com.gildedrose.Item
import com.gildedrose.factory.Updatable

open class BaseItemWrapper(item: Item) : AbstractBaseItemWrapper(item), Updatable {
    override fun getBeforeSellInDecreaseRate(): Int {
        return -1
    }

    override fun getAfterSellInDecreaseRate(): Int {
        return -2
    }

    override fun getMaxQuality(): Int {
        return 50
    }

    override fun getSellInMinusOnUpdate(): Int {
        return -1
    }

}
