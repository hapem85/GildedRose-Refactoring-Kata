package com.gildedrose;

import java.util.Objects;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }
    
    public void updateQuality() {
    	for (Item item: items) {
    		ItemStateBehavior itemBehavior = this.getItemBehaviorFactory(item);
    		if(Objects.isNull(itemBehavior)) {
    			continue;
    		}
    		itemBehavior.changeState();
    	}
    }
	
	private ItemStateBehavior getItemBehaviorFactory(Item item) {
		return new ItemBehaviorFactory(item).getItemBehavior(item);
	}
	
}