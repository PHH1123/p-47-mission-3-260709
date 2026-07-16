package com.ll.wiseSaying;

import java.util.List;

public class WiseSayingRepository {

    private final FileIO fileIO;
    private List<WiseSaying> wiseSayings;

    public WiseSayingRepository(FileIO fileIO) {
        this.fileIO = fileIO;
        wiseSayings = fileIO.fileInput();
    }

    public WiseSaying save(String author, String content) {
        WiseSaying wiseSaying = new WiseSaying(wiseSayings.size() + 1, author, content);
        this.wiseSayings.add(wiseSaying);

        fileIO.jsonOutput(wiseSaying);
        fileIO.txtOutput(wiseSaying.getNo());

        return wiseSaying;
    }


    public List<WiseSaying> findAll() {
        return this.wiseSayings;
    }

    public void deleteById(int id) {
        validId(id);
        this.wiseSayings.set(id - 1, new WiseSaying(0, "", ""));
    }

    public WiseSaying update(int id, String author, String content) {
        validId(id);
        WiseSaying wiseSaying = this.wiseSayings.get(id - 1);

        wiseSaying.setAuthor(author);
        wiseSaying.setContent(content);

        fileIO.jsonOutput(wiseSaying);

        return wiseSaying;
    }

    public WiseSaying findById(int id) {
        validId(id);
        return wiseSayings.get(id - 1);
    }

    private void validId(int id) {
        if (this.wiseSayings.size() < id || this.wiseSayings.get(id - 1) == null) {
            throw new RuntimeException();
        }
    }

    public void build() {
        fileIO.saveAllJsonOutput(this.wiseSayings);
    }
}
