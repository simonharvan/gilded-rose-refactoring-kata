package com.gildedrose.items

import com.gildedrose.Item
import com.gildedrose.factory.Updatable

class SulfurasItemWrapper(item: Item): BaseItemWrapper(item), Updatable {

    init {
        item.quality = 80
    }

    override fun getMaxQuality(): Int {
        return 80
    }

    override fun getBeforeSellInDecreaseRate(): Int {
        return 0
    }

    override fun getAfterSellInDecreaseRate(): Int {
        return 0
    }

    override fun getSellInMinusOnUpdate(): Int {
        return 0
    }
}
