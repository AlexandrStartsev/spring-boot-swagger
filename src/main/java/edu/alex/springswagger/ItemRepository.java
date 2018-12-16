package edu.alex.springswagger;

import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Repository
public class ItemRepository {

    private final static Map<Long, Item> items = Stream.of(
            new Item(1L, "Item1"),
            new Item(2L, "Item2")
    ).collect(Collectors.toMap(Item::getId, self -> self));

    public CompletableFuture<Item> getItem(final Long id) {
        return CompletableFuture.completedFuture(items.get(id));
    }
}
