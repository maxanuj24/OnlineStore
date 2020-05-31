package com.startup.OnlineStore.service;

import com.startup.OnlineStore.model.Item;

import java.util.List;

public interface ItemService {

    public void addItem(Item item);
    public Item getItem(int itemId);
    public List<Item> getAllItems();
}
