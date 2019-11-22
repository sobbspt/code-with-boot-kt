package com.wanichnun.codewithbootkt.gildedrose

class GildedRose(var items: Array<Item>) {

    fun updateQuality() {
        for (i in items.indices) {
            updateSingleItem(items[i])
        }
    }

    private fun updateSingleItem(item: Item) {
        item.performUpdateQuality()
    }

}