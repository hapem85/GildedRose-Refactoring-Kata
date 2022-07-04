package com.gildedrose;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class GildedRoseTest {

	private static final String NORMAL_ITEM = "+5 Dexterity Vest";
	private final static String SULFURAS_ITEM = "Sulfuras, Hand of Ragnaros";
	private final static String AGED_BRIE_ITEM = "Aged Brie";
	private final static String BACKSTAGE_PASSES_ITEM = "Backstage passes to a TAFKAL80ETC concert";
	private final static String CONJURED_ITEM = "Conjured Mana Cake";

	@Test
	public void foo() {
		GildedRose app = this.createGildedRoseItem("foo", 0, 0);

		app.updateQuality();

		assertEquals(-1, app.items[0].sellIn);
		assertEquals(0, app.items[0].quality);
		assertEquals("foo", app.items[0].name);
	}

	@Test
	public void normalItemDegradesSellByDay() {
		GildedRose app = this.createGildedRoseItem(NORMAL_ITEM, 10, 20);

		app.updateQuality();

		assertEquals(NORMAL_ITEM, itemNameValue(app));
		assertEquals(9, itemSellByDayValue(app));
		assertEquals(19, itemQualityValue(app));
	}
	
	@Test
	public void normalItemQualityDegradesOneWhenSellByDayGreaterThanZero() {
		GildedRose app = this.createGildedRoseItem(NORMAL_ITEM, 2, 1);

		app.updateQuality();

		assertEquals(NORMAL_ITEM, itemNameValue(app));
		assertEquals(1, itemSellByDayValue(app));
		assertEquals(0, itemQualityValue(app));
	}

	@Test
	public void normalItemQualityDegradesTwiceOnceSellByDayHasPassed() {
		GildedRose app = this.createGildedRoseItem(NORMAL_ITEM, 0, 5);

		app.updateQuality();

		assertEquals(NORMAL_ITEM, itemNameValue(app));
		assertEquals(-1, itemSellByDayValue(app));
		assertEquals(3, itemQualityValue(app));
	}

	@Test
	public void normalItemQualityMinimumIsZero() {
		GildedRose app = this.createGildedRoseItem(NORMAL_ITEM, 0, 0);

		app.updateQuality();

		assertEquals(NORMAL_ITEM, itemNameValue(app));
		assertEquals(-1, itemSellByDayValue(app));
		assertEquals(0, itemQualityValue(app));
	}

	@Test
	public void agedBrieItemDegradesSellByDay() {
		GildedRose app = this.createGildedRoseItem(AGED_BRIE_ITEM, 0, 0);

		app.updateQuality();
		
		assertEquals(AGED_BRIE_ITEM, itemNameValue(app));
		assertEquals(-1, itemSellByDayValue(app));
		assertEquals(1, itemQualityValue(app));
	}


	@Test
	public void agedBrieIncreasesQualityOlderItsGet() {
		GildedRose app = this.createGildedRoseItem(AGED_BRIE_ITEM, 2, 0);

		app.updateQuality();

		assertEquals(AGED_BRIE_ITEM, itemNameValue(app));
		assertEquals(1, itemSellByDayValue(app));
		assertEquals(1, itemQualityValue(app));
	}

	@Test
	public void agedBrieQualityNeverGreaterThanFifty() {
		GildedRose app = this.createGildedRoseItem(AGED_BRIE_ITEM, 1, 50);
		
		app.updateQuality();

		assertEquals(AGED_BRIE_ITEM, itemNameValue(app));
		assertEquals(0, itemSellByDayValue(app));
		assertEquals(50, itemQualityValue(app));
	}
	
	@Test
	public void agedBrieItemQualityNeverGreaterThanFiftyEvenWhenSellByDayLessThanZero() {
		GildedRose app = this.createGildedRoseItem(AGED_BRIE_ITEM, -1, 50);

		app.updateQuality();

		assertEquals(AGED_BRIE_ITEM, itemNameValue(app));
		assertEquals(-2, itemSellByDayValue(app));
		assertEquals(50, itemQualityValue(app));
	}
	
	@Test
	public void sulfurasItemQualityIsEighty() {
		GildedRose app = this.createGildedRoseItem(SULFURAS_ITEM, 1, 80);

		assertEquals(SULFURAS_ITEM, itemNameValue(app));
		assertEquals(1, itemSellByDayValue(app));
		assertEquals(80, itemQualityValue(app));
	}

	@Test
	public void sulfurasItemNeverAlterValues() {
		GildedRose app = this.createGildedRoseItem(SULFURAS_ITEM, 0, 80);

		app.updateQuality();

		assertEquals(SULFURAS_ITEM, itemNameValue(app));
		assertEquals(0, itemSellByDayValue(app));
		assertEquals(80, itemQualityValue(app));
	}
	
	@Test
	public void sulfurasItemNeverAlterValuesEvenSellByDayLessThanZero() {
		GildedRose app = this.createGildedRoseItem(SULFURAS_ITEM, -1, 80);

		app.updateQuality();

		assertEquals(SULFURAS_ITEM, itemNameValue(app));
		assertEquals(-1, itemSellByDayValue(app));
		assertEquals(80, itemQualityValue(app));
	}
	
	@Test
	public void backstagePassesItemDegradesSellByDay() {
		GildedRose app = this.createGildedRoseItem(BACKSTAGE_PASSES_ITEM, 0, 0);

		app.updateQuality();

		assertEquals(BACKSTAGE_PASSES_ITEM, itemNameValue(app));
		assertEquals(-1, itemSellByDayValue(app));
		assertEquals(0, itemQualityValue(app));
	}

	@Test
	public void backstagePassesItemIncreasesQualityByOneWhenSellByDayEqualEleven() {
		GildedRose app = this.createGildedRoseItem(BACKSTAGE_PASSES_ITEM, 11, 1);

		app.updateQuality();

		assertEquals(2, itemQualityValue(app));
	}
	
	@Test
	public void backstagePassesItemIncreasesQualityByOneWhenSellByDayGreaterThanEleven() {
		GildedRose app = this.createGildedRoseItem(BACKSTAGE_PASSES_ITEM, 12, 1);

		app.updateQuality();

		assertEquals(2, itemQualityValue(app));
	}
	
	@Test
	public void backstagePassesItemIncreasesQualityTwiceWhenSellByDayLessThanEleven() {
		GildedRose app = this.createGildedRoseItem(BACKSTAGE_PASSES_ITEM, 10, 1);

		app.updateQuality();

		assertEquals(3, itemQualityValue(app));
	}
	
	@Test
	public void backstagePassesItemIncreasesQualityWhenSellByDayLessThanElevenAndReachToFifty() {
		GildedRose app = this.createGildedRoseItem(BACKSTAGE_PASSES_ITEM, 9, 49);

		app.updateQuality();

		assertEquals(50, itemQualityValue(app));
	}
	
	@Test
	public void backstagePassesItemIncreasesQualityWhenSellByDayLessThanElevenAndMaxFifty() {
		GildedRose app = this.createGildedRoseItem(BACKSTAGE_PASSES_ITEM, 9, 50);

		app.updateQuality();

		assertEquals(50, itemQualityValue(app));
	}
	
	@Test
	public void backstagePassesItemIncreasesQualityTwiceWhenSellByDayEqualSix() {
		GildedRose app = this.createGildedRoseItem(BACKSTAGE_PASSES_ITEM, 6, 1);

		app.updateQuality();

		assertEquals(3, itemQualityValue(app));
	}

	@Test
	public void backstagePassesItemIncreasesQualityByThreeWhenSellByDayLessThanSix() {
		GildedRose app = this.createGildedRoseItem(BACKSTAGE_PASSES_ITEM, 5, 1);

		app.updateQuality();

		assertEquals(4, itemQualityValue(app));
	}
	
	@Test
	public void backstagePassesItemIncreasesQualityByThreeWhenSellByDayEqualOne() {
		GildedRose app = this.createGildedRoseItem(BACKSTAGE_PASSES_ITEM, 1, 1);

		app.updateQuality();

		assertEquals(4, itemQualityValue(app));
	}
	
	@Test
	public void backstagePassesItemIncreasesQualityByThreeWhenSellByDayLessThanOne() {
		GildedRose app = this.createGildedRoseItem(BACKSTAGE_PASSES_ITEM, 0, 1);

		app.updateQuality();

		assertEquals(0, itemQualityValue(app));
	}
	
	@Test
	public void backstagePassesItemIncreasesQualityWhenSellByDayLessThanSixAndMaxFifty() {
		GildedRose app = this.createGildedRoseItem(BACKSTAGE_PASSES_ITEM, 4, 50);

		app.updateQuality();

		assertEquals(50, itemQualityValue(app));
	}
	
	@Test
	public void backstagePassesItemIncreasesQualityWhenSellByDayLessThanSixAndReachToFifty() {
		GildedRose app = this.createGildedRoseItem(BACKSTAGE_PASSES_ITEM, 5, 49);

		app.updateQuality();

		assertEquals(50, itemQualityValue(app));
	}

	@Test
	public void backstagePassesItemQualityDropsToZeroWhenSellByDayIsZeroOrLess() {
		GildedRose app = this.createGildedRoseItem(BACKSTAGE_PASSES_ITEM, 0, 50);

		app.updateQuality();

		assertEquals(0, itemQualityValue(app));
	}
	
	@Test
	public void backstagePassesItemQualityDropsToZeroWhenAfterConcert() {
		GildedRose app = this.createGildedRoseItem(BACKSTAGE_PASSES_ITEM, -1, 10);

		app.updateQuality();

		assertEquals(0, itemQualityValue(app));
	}

	@Test
	public void backstagePassesItemQualityMaxFifty() {
		GildedRose app = this.createGildedRoseItem(BACKSTAGE_PASSES_ITEM, 5, 50);

		app.updateQuality();

		assertEquals(50, itemQualityValue(app));
	}
	
	@Test
	public void conjuredItemDegradesSellByDay() {
		GildedRose app = this.createGildedRoseItem(CONJURED_ITEM, 0, 0);

		app.updateQuality();

		assertEquals(-1, itemSellByDayValue(app));
	}
	
	@Test
	public void conjuredItemmQualityDegradesOnceSellByDayLessThanZero() {
		GildedRose app = this.createGildedRoseItem(CONJURED_ITEM, 0, 20);

		app.updateQuality();

		assertEquals(18, itemQualityValue(app));
	}

	@Test
	public void conjuredItemDegradesQualityTwice() {
		GildedRose app = this.createGildedRoseItem(CONJURED_ITEM, 3, 6);

		app.updateQuality();

		assertEquals(4, itemQualityValue(app));
	}

	@Test
	public void conjuredItemQualityMinimumIsZero() {
		GildedRose app = this.createGildedRoseItem(CONJURED_ITEM, 0, 0);

		app.updateQuality();

		assertEquals(0, itemQualityValue(app));
	}

	private GildedRose createGildedRoseItem(String itemName, int itemSellIn, int itemQuality) {
		Item[] items = new Item[] { new Item(itemName, itemSellIn, itemQuality) };
		return new GildedRose(items);
	}
	
	private String itemNameValue(GildedRose app) {
		return app.items[0].name;
	}

	private int itemSellByDayValue(GildedRose app) {
		return app.items[0].sellIn;
	}

	private int itemQualityValue(GildedRose app) {
		return app.items[0].quality;
	}
}
