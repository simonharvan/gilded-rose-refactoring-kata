package com.gildedrose.items

import com.gildedrose.Item
import com.gildedrose.factory.Updatable

class AgedBrieItemWrapper(item: Item): BaseItemWrapper(item), Updatable {
    override fun getBeforeSellInDecreaseRate(): Int {
        return +1
    }

    override fun getAfterSellInDecreaseRate(): Int {
        return +2
    }
}
