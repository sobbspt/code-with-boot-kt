package com.wanichnun.codewithbootkt.gildedrose

abstract class Item(var name: String, var sellIn: Int, var quality: Int, var itemBehavior: ItemBehavior) {
    open fun performUpdateQuality() {
        return itemBehavior.updateQuality(this)
    }
}

class AgedBrieItem(
        name: String,
        sellIn: Int,
        quality: Int,
        itemBehavior: AgedBrieBehavior
) : Item(name, sellIn, quality, itemBehavior)

class SulfurasItem(
        name: String,
        sellIn: Int,
        quality: Int,
        itemBehavior: SulfurasBehavior
) : Item(name, sellIn, quality, itemBehavior)

class BackstagePassItem(
        name: String,
        sellIn: Int,
        quality: Int,
        itemBehavior: BackstagePassBehavior
) : Item(name, sellIn, quality, itemBehavior)

class NormalItem(
        name: String,
        sellIn: Int,
        quality: Int,
        itemBehavior: NormalBehavior
) : Item(name, sellIn, quality, itemBehavior)

class ConjuredItem(
        name: String,
        sellIn: Int,
        quality: Int,
        itemBehavior: ConjuredBehavior
) : Item(name, sellIn, quality, itemBehavior)
