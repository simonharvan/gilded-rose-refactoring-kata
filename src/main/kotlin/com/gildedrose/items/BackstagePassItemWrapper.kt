package com.gildedrose.items

import com.gildedrose.Item
import com.gildedrose.factory.Updatable

class BackstagePassItemWrapper(item: Item): BaseItemWrapper(item), Updatable {
    override fun getBeforeSellInDecreaseRate(): Int {
        return when {
            item.sellIn <= 5 -> 3
            item.sellIn <= 10 -> 2
            else -> 1
        }
    }

    override fun getAfterSellInDecreaseRate(): Int {
        return super.getMaxQuality() * -1
    }
}
