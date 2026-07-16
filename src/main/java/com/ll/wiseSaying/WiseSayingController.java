package com.ll.wiseSaying;

import java.util.List;
import java.util.Scanner;

public class WiseSayingController {

    private final Scanner sc;
    private final WiseSayingService wiseSayingService;

    public WiseSayingController(Scanner sc, WiseSayingService wiseSayingService) {
        this.sc = sc;
        this.wiseSayingService = wiseSayingService;
    }

    public void save() {
        System.out.print("명언 : ");
        String content = this.sc.nextLine();

        System.out.print("작가 : ");
        String author = this.sc.nextLine();

        int no = wiseSayingService.saveWise(author, content);

        System.out.println(no + "번 명언이 등록되었습니다.");
    }

    public void getList() {
        List<WiseSaying> wiseSayings = wiseSayingService.findAll();

        System.out.println("번호 / 작가 / 명언");
        System.out.println("---------------------------");

        if (wiseSayings == null || wiseSayings.isEmpty()) {
            return;
        }

        for (int i = wiseSayings.size() - 1; i >= 0; i--) {
            WiseSaying wiseSaying = wiseSayings.get(i);

            if (wiseSaying == null || wiseSaying.getNo() == 0) {
                continue;
            }

            System.out.println(wiseSaying.getNo() + " / " +
                    wiseSaying.getAuthor() + " / " +
                    wiseSaying.getContent()
            );
        }
    }

    public void delete(String input) {
        try {
            int id = getId(input);
            wiseSayingService.deleteById(id);

            System.out.println(id + "번 명언이 삭제되었습니다.");

        } catch (RuntimeException e) {
            System.out.println(getId(input) + "번 명언은 존재하지 않습니다.");
        }
    }

    public void update(String input) {
        try {
            int id = getId(input);
            WiseSaying wiseSaying = wiseSayingService.findWise(id);

            System.out.println("명언(기존) : " + wiseSaying.getContent());
            System.out.print("명언 : ");
            String content = sc.nextLine();

            System.out.println("작가(기존) : " + wiseSaying.getAuthor());
            System.out.print("작가 : ");
            String author = sc.nextLine();

            wiseSayingService.updateWise(id, author, content);

        } catch (RuntimeException e) {
            System.out.println(getId(input) + "번 명언은 존재하지 않습니다.");
        }
    }

    private static int getId(String input) {
        return Integer.parseInt(input.split("=")[1]);
    }

    public void build() {
        wiseSayingService.build();

        System.out.println("data.json 파일의 내용이 갱신되었습니다.");
    }
}
