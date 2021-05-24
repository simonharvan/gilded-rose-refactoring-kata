package com.gildedrose

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class GildedRoseTest {

    @Test
    fun sellInPassed_qualityDegradesTwiceAsFast() {
        val items = arrayOf(Item("Item", 1, 3))
        val app = GildedRose(items)

        app.updateQuality()
        assertEquals(2, app.items[0].quality)
        app.updateQuality()
        assertEquals(0, app.items[0].quality)
    }

    @Test
    fun qualityNeverBelowZero() {
        val items = arrayOf(Item("Item", 1, 10))
        val app = GildedRose(items)

        for (i in 0 until 1000) {
            app.updateQuality()
        }
        assertEquals(0, app.items[0].quality)
    }

    @Test
    fun agedBrieQualityIncreasesByOneUntilSellin() {
        val items = arrayOf(Item("Aged Brie", 10, 10))
        val app = GildedRose(items)

        for (i in 0 until 10) {
            app.updateQuality()
        }
        assertEquals(20, app.items[0].quality)
    }

    @Test
    fun agedBrieQualityIncreasesByTwoUntilSellin() {
        val items = arrayOf(Item("Aged Brie", 0, 10))
        val app = GildedRose(items)

        for (i in 0 until 10) {
            app.updateQuality()
        }

        assertEquals(30, app.items[0].quality)
    }


    @Test
    fun sulfurasNeverChangeQuality() {
        val items = arrayOf(Item("Sulfuras, Hand of Ragnaros", 1, 80))
        val app = GildedRose(items)
        for (i in 0 until 10) {
            app.updateQuality()
        }

        assertEquals(80, app.items[0].quality)
        assertEquals(1, app.items[0].sellIn)
    }

    @Test
    fun backstagePassesIncreaseQualityByOneUntil10Days() {
        val items = arrayOf(Item("Backstage passes to a TAFKAL80ETC concert", 15, 10))
        val app = GildedRose(items)
        for (i in 0 until 5) {
            app.updateQuality()
        }
        assertEquals(15, app.items[0].quality)
        assertEquals(10, app.items[0].sellIn)
    }

    @Test
    fun backstagePassesIncreaseQualityByTwoUntil5() {
        val items = arrayOf(Item("Backstage passes to a TAFKAL80ETC concert", 10, 10))
        val app = GildedRose(items)
        for (i in 0 until 5) {
            app.updateQuality()
        }
        assertEquals(20, app.items[0].quality)
        assertEquals(5, app.items[0].sellIn)
    }

    @Test
    fun backstagePassesIncreaseQualityByThreeUntil0() {
        val items = arrayOf(Item("Backstage passes to a TAFKAL80ETC concert", 5, 10))
        val app = GildedRose(items)
        for (i in 0 until 5) {
            app.updateQuality()
        }
        assertEquals(25, app.items[0].quality)
        assertEquals(0, app.items[0].sellIn)
    }

    @Test
    fun backstagePassesDropToZeroAfterConcert() {
        val items = arrayOf(Item("Backstage passes to a TAFKAL80ETC concert", 4, 10))
        val app = GildedRose(items)
        for (i in 0 until 5) {
            app.updateQuality()
        }
        assertEquals(0, app.items[0].quality)
        assertEquals(-1, app.items[0].sellIn)
    }

    @Test
    fun conjuredDegradeTwiceAsFast() {
        val items = arrayOf(Item("Conjured", 4, 16))
        val app = GildedRose(items)
        for (i in 0 until 4) {
            app.updateQuality()
        }
        assertEquals(8, app.items[0].quality)
    }

    @Test
    fun conjuredDegradeTwiceAsFastAfterSellIn() {
        val items = arrayOf(Item("Conjured", 2, 16))
        val app = GildedRose(items)
        for (i in 0 until 4) {
            app.updateQuality()
        }
        assertEquals(4, app.items[0].quality)
    }

}


