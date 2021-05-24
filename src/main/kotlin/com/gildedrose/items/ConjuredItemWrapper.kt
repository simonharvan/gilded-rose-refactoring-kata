package com.gildedrose.items

import com.gildedrose.Item
import com.gildedrose.factory.Updatable

class ConjuredItemWrapper(item: Item): BaseItemWrapper(item), Updatable {
    override fun getBeforeSellInDecreaseRate(): Int {
        return super.getBeforeSellInDecreaseRate() * 2
    }

    override fun getAfterSellInDecreaseRate(): Int {
        return super.getAfterSellInDecreaseRate() * 2
    }
}
