package com.ll.wiseSaying;

import java.io.*;
import java.util.Scanner;

public class TestUtil {

    /*
    사용자가 미리 입력한 String의 바이트 값을 이용해 ByteArrayInputStream 인스턴스 생성
    방금 생성한 인스턴스 InputStream을 가진 Scanner 인스턴스를 반환

    여기서 ByteArrayInputStream은 String을 담은 그릇이라고 볼 수 있다.
    사용자는 해당 그릇에서 scanner.nextLine()을 통해 한 줄씩 꺼내 쓸 수 있다.
     */
    public static Scanner getScanner(final String input) {
        final InputStream in = new ByteArrayInputStream(input.getBytes());
        return new Scanner(in);
    }

    /*
    ByteArrayOutputStream 인스턴스 생성 후 PrintStream으로 인스턴스를 감싼 뒤
    System의 out에다가 PrintStream 인스턴스를 설정
    기존의 방식인 콘솔에 출력을 하지 않고
    ByteArrayOutputStream이라는 인스턴스에 보관하게 바꿈
    ByteArrayOutputStream은 출력할 내용을 담은 그릇이라고 볼 수 있다.
     */
    public static ByteArrayOutputStream setOutToByteArray() {
        final ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        return out;
    }

    /*
    위에서 out에 설정한 ByteArrayOutputStream 인스턴스에서
    콘솔로 내보내도록 변경
     */
    public static void clearSetOutToByteArray(final ByteArrayOutputStream out) {
        System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
        try {
            out.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
