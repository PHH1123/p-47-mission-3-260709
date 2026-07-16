package com.ll.wiseSaying;

import java.util.List;

public class WiseSayingService {

    private final WiseSayingRepository wiseSayingRepository;

    public WiseSayingService(WiseSayingRepository wiseSayingRepository) {
        this.wiseSayingRepository = wiseSayingRepository;
    }

    public int saveWise(String author, String content) {
        WiseSaying savedWiseSaying = wiseSayingRepository.save(author, content);

        return savedWiseSaying.getNo();
    }

    public List<WiseSaying> findAll() {
        return wiseSayingRepository.findAll();
    }

    public void deleteById(int id) {
        wiseSayingRepository.deleteById(id);
    }

    public void updateWise(int id, String author, String content) {
        wiseSayingRepository.update(id, author, content);
    }

    public WiseSaying findWise(int id) {
        return wiseSayingRepository.findById(id);
    }

    public void build() {
        wiseSayingRepository.build();
    }
}
