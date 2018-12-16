package edu.alex.springswagger;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping(path = "/api")
public class ItemController {

    @Autowired
    private ItemRepository itemRepository;

    @ApiOperation(value = "", nickname = "getItem", notes = "Request an item with given Id", response = Item.class, tags={  })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = Item.class) })
    @GetMapping(path = "item/{id}")
    @Async
    CompletableFuture<Item> getItem(@ApiParam(value = "Id lookup") @PathVariable final Long id) {

        return  itemRepository.getItem(id);
    }
}
