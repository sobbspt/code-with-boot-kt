package com.wanichnun.codewithbootkt.gildedrose;

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test;

class GildedRoseTest {
    @Test
    fun `should reduce sellIn and quality`() {
        val item = NormalItem(
                name = "any-item",
                sellIn = 3,
                quality = 3,
                itemBehavior = NormalBehavior()
        )

        GildedRose(arrayOf(item)).updateQuality()

        assertEquals(2, item.sellIn)
        assertEquals(2, item.quality)
    }


    @Test
    fun `should not decrease the quality lower than 0`() {
        val item = NormalItem(
                name = "any-item",
                sellIn = 3,
                quality = 0,
                itemBehavior = NormalBehavior()
        )

        GildedRose(arrayOf(item)).updateQuality()

        assertEquals(0, item.quality)
    }

    @Test
    fun `"Aged Brie" should increase the quality and decrease sellIn`() {
        val item = AgedBrieItem(
                name = "Aged Brie",
                sellIn = 3,
                quality = 1,
                itemBehavior = AgedBrieBehavior()
        )

        GildedRose(arrayOf(item)).updateQuality()

        assertEquals(2, item.sellIn)
        assertEquals(2, item.quality)
    }

    @Test
    fun `should not increase the quality over than 50`() {
        val item = AgedBrieItem(
                name = "Aged Brie",
                sellIn = 3,
                quality = 50,
                itemBehavior = AgedBrieBehavior()
        )

        GildedRose(arrayOf(item)).updateQuality()

        assertEquals(50, item.quality)
    }

    @Test
    fun `"Sulfuras" should not decrease the quality and sellIn`() {
        val item = SulfurasItem(
                name = "Sulfuras, Hand of Ragnaros",
                sellIn = 3,
                quality = 4,
                itemBehavior = SulfurasBehavior()
        )

        GildedRose(arrayOf(item)).updateQuality()

        assertEquals(3, item.sellIn)
        assertEquals(4, item.quality)
    }

    @Test
    fun `"Backstage passes" should increase quality by 2 when not over than 10 days left`() {
        val item = BackstagePassItem(
                name = "Backstage passes to a TAFKAL80ETC concert",
                sellIn = 8,
                quality = 4,
                itemBehavior = BackstagePassBehavior()
        )

        GildedRose(arrayOf(item)).updateQuality()

        assertEquals(7, item.sellIn)
        assertEquals(6, item.quality)
    }

    @Test
    fun `"Backstage passes" should increase quality by 3 when not over than 5 days left`() {
        val item = BackstagePassItem(
                name = "Backstage passes to a TAFKAL80ETC concert",
                sellIn = 5,
                quality = 4,
                itemBehavior = BackstagePassBehavior()
        )

        GildedRose(arrayOf(item)).updateQuality()

        assertEquals(4, item.sellIn)
        assertEquals(7, item.quality)
    }

    @Test
    fun `"Backstage passes" should increase quality by 1 when more than 10 days left`() {
        val item = BackstagePassItem(
                name = "Backstage passes to a TAFKAL80ETC concert",
                sellIn = 14,
                quality = 5,
                itemBehavior = BackstagePassBehavior()
        )

        GildedRose(arrayOf(item)).updateQuality()

        assertEquals(13, item.sellIn)
        assertEquals(6, item.quality)
    }

    @Test
    fun `"Backstage passes" should update quality to 0 when after concert`() {
        val item = BackstagePassItem(
                name = "Backstage passes to a TAFKAL80ETC concert",
                sellIn = 0,
                quality = 5,
                itemBehavior = BackstagePassBehavior()
        )

        GildedRose(arrayOf(item)).updateQuality()

        assertEquals(-1, item.sellIn)
        assertEquals(0, item.quality)
    }

    @Test
    fun `"Conjured" should decrease quality by 2`() {
        val item = ConjuredItem(
                name = "Conjured",
                sellIn = 4,
                quality = 5,
                itemBehavior = ConjuredBehavior()
        )

        GildedRose(arrayOf(item)).updateQuality()

        assertEquals(3, item.sellIn)
        assertEquals(3, item.quality)
    }
}
