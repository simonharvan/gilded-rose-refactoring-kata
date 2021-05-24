package com.gildedrose.factory

import com.gildedrose.Item
import com.gildedrose.items.*

object ItemFactory {

    fun create(item: Item): Updatable {
        return when (item.name) {
            "Backstage passes to a TAFKAL80ETC concert" -> BackstagePassItemWrapper(item)
            "Conjured Mana Cake" -> ConjuredItemWrapper(item)
            "Sulfuras, Hand of Ragnaros" -> SulfurasItemWrapper(item)
            "Aged Brie" -> AgedBrieItemWrapper(item)
            else -> BaseItemWrapper(item)
        }
    }
}