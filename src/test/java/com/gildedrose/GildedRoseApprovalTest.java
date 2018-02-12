package com.gildedrose;


import org.approvaltests.combinations.CombinationApprovals;
import org.junit.jupiter.api.Test;

import static com.gildedrose.ItemNames.*;


class GildedRoseApprovalTest {

    @Test
    void updateQuality_normal_shouldDecrease() throws Exception {
        String[] names = {SULFURAS, BRIE, PASS, CONJURED, "toto"};
        Integer[] prices = {0, 20};
        Integer[] qualities = {-1, 0, 1, 5, 6, 10, 50};
        CombinationApprovals.verifyAllCombinations(this::doTest, names, prices, qualities);
    }

    private Item doTest(String name, int sellIn, int quality) {
        //GIVEN
        Item[] items = new Item[]{new Item(name, sellIn, quality)};
        GildedRose app = new GildedRose(items);
        //WHEN
        app.updateQuality();
        return app.items[0];
    }

}
