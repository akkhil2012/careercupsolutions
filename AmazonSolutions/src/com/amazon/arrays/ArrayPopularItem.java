package com.amazon.arrays;

import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
/*
 * http://www.careercup.com/question?id=5737921569095680 : Alterbnative ----> To use Heap is left TO DO
 * 
 * Alternative: To use MinHeap
 */
class AmazonItems {
	public Item getIthItem(List<Item> lst, int k) {
		Item item = null;
		Map<Item, Integer> itemsMap = new TreeMap<Item, Integer>(
				new MyComparator());

		Iterator<Item> it = lst.iterator();
		while (it.hasNext()) {
			Item nextItem = it.next();
			itemsMap.put(nextItem, nextItem.getQuantitySold());
		}

		Item[] itemArray = new Item[lst.size() + 1];
		int i = 1;
		for (Map.Entry<Item, Integer> items : itemsMap.entrySet()) {
			itemArray[i++] = items.getKey();
		}

		return itemArray[k];
	}
}

class MyComparator implements Comparator<Item> {
	public int compare(Item o1, Item o2) {
		if (o1.getQuantitySold() > o2.getQuantitySold())
			return -1;
		else if (o1.getQuantitySold() < o2.getQuantitySold())
			return 1;
		return 0;
	}
}

class Item {
	private String itemId;
	private int quantitySold;

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public int getQuantitySold() {
		return quantitySold;
	}

	public void setQuantitySold(int quantitySold) {
		this.quantitySold = quantitySold;
	}

	public Item(String itemId, int quantitySold) {
		this.itemId = itemId;
		this.quantitySold = quantitySold;
	}

}

public class ArrayPopularItem {
	public static void main(String args[]) {

		List<Item> lst = new LinkedList<Item>();

		lst.add(new Item("first", 100));
		lst.add(new Item("sec", 1000));
		lst.add(new Item("third", 200));
		lst.add(new Item("fourth", 400));
		lst.add(new Item("fifth", 700));
		lst.add(new Item("six", 4700));
		lst.add(new Item("seven", 11700));
		/* new AmazonItems().getIthItem(lst,3); */
		System.out.println(" K th item is "
				+ new AmazonItems().getIthItem(lst, 5).getQuantitySold());
	}
}
