package com.gildedrose

import com.gildedrose.factory.ItemFactory
import com.gildedrose.factory.Updatable

class GildedRose(var items: Array<Item>) {

    var updatableItems: List<Updatable> = items.map { item ->
        ItemFactory.create(item)
    }

    fun updateQuality() {
        updatableItems.forEach { item ->
            item.update()
        }
    }

}

