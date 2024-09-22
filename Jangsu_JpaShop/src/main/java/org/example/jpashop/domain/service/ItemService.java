package org.example.jpashop.domain.service;

import lombok.RequiredArgsConstructor;
import org.example.jpashop.domain.item.Item;
import org.example.jpashop.domain.repository.ItemRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ItemService {
    private final ItemRepository itemRepository;

    @Transactional
    public void saveItem(Item item) {
        itemRepository.save(item);
    }

    // 아이템 전부 찾기
    public List<Item> findItems() {
        return itemRepository.findAll();
    }

    // 아이템 하나만 찾기
    public Item findOne(Long itemId) {
        return itemRepository.findOne(itemId);
    }
}
