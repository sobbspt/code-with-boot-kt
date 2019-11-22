package com.wanichnun.codewithbootkt.gildedrose

interface ItemBehavior {
    fun updateQuality(item: Item)
}

class AgedBrieBehavior : ItemBehavior {
    override fun updateQuality(item: Item) {
        decreaseSellIn(item, 1)
        increaseQuality(item, 1)
    }
}

class SulfurasBehavior : ItemBehavior {
    override fun updateQuality(item: Item) {}
}

class BackstagePassBehavior : ItemBehavior {
    override fun updateQuality(item: Item) {
        decreaseSellIn(item, 1)
        when {
            item.sellIn <= 0 -> {
                item.quality = 0
            }
            item.sellIn <= 5 -> {
                increaseQuality(item, 3)
            }
            item.sellIn <= 10 -> {
                increaseQuality(item, 2)
            }
            else -> {
                increaseQuality(item, 1)
            }
        }
    }
}

class NormalBehavior : ItemBehavior {
    override fun updateQuality(item: Item) {
        decreaseQuality(item, 1)
        decreaseSellIn(item, 1)
    }
}

class ConjuredBehavior : ItemBehavior {
    override fun updateQuality(item: Item) {
        decreaseSellIn(item, 1)
        decreaseQuality(item, 2)
    }
}

private fun increaseQuality(item: Item, delta: Int) {
    if (item.quality < 50) {
        item.quality += delta
    }
}

private fun decreaseQuality(item: Item, delta: Int) {
    if (item.quality > 0) {
        item.quality -= delta
    }
}

private fun decreaseSellIn(item: Item, delta: Int) {
    item.sellIn -= delta
}
