package com.ll.wiseSaying;

import java.util.Scanner;

public class App {

    public static void run(Scanner sc) {

        FileIO fileIO = new FileIO();
        WiseSayingRepository repository = new WiseSayingRepository(fileIO);
        WiseSayingService service = new WiseSayingService(repository);
        WiseSayingController wiseSayingController = new WiseSayingController(sc, service);

        System.out.println("== 명언 앱 ==");
        String input;

        while (true) {
            System.out.print("명령) ");
            input = sc.nextLine();
            String prefix = input.contains("?") ? input.split("\\?")[0] : input;

            switch (prefix) {
                case "종료":
                    return;
                case "등록":
                    wiseSayingController.save();
                    break;
                case "목록":
                    wiseSayingController.getList();
                    break;
                case "삭제":
                    wiseSayingController.delete(input);
                    break;
                case "수정":
                    wiseSayingController.update(input);
                    break;
                case "빌드":
                    wiseSayingController.build();
                    break;
            }
        }
    }
}
