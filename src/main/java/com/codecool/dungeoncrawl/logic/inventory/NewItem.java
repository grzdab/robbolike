package com.codecool.dungeoncrawl.logic.inventory;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class NewItem {
    private ObservableList<Inventory> itemList = FXCollections.observableArrayList();

    Inventory NewItem = new Inventory(1,1,
                            "b", "weapon", 1);
}
