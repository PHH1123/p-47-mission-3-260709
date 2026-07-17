package com.ll.wiseSaying;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class WiseSayingControllerTest {

    // 테스트 전 data.json 지우기
    @BeforeEach
    public void beforeEach() {
        AppTest.clear();
    }

    @Test
    @DisplayName("등록")
    public void t3() {
        final String out = AppTest.run("""
                등록
                현재를 사랑하라.
                작자미상
                """);

        assertThat(out)
                .contains("명언 :")
                .contains("작가 :")
                .contains("1번 명언이 등록되었습니다.");
    }

    @Test
    @DisplayName("목록")
    public void t5() {
        final String out = AppTest.run("""
                등록
                현재를 사랑하라.
                작자미상
                등록
                과거에 집착하지 마라.
                작자미상
                목록
                """);

        assertThat(out)
                .contains("2 / 작자미상 / 과거에 집착하지 마라.")
                .contains("1 / 작자미상 / 현재를 사랑하라.");
    }

    @Test
    @DisplayName("삭제")
    public void t6() {
        final String out = AppTest.run("""
                등록
                현재를 사랑하라.
                작자미상
                등록
                과거에 집착하지 마라.
                작자미상
                목록
                삭제?id=1
                """);

        assertThat(out)
                .contains("1번 명언이 삭제되었습니다.");
    }

    @Test
    @DisplayName("수정")
    public void t8() {
        final String out = AppTest.run("""
                등록
                현재를 사랑하라.
                작자미상
                등록
                과거에 집착하지 마라.
                작자미상
                목록
                삭제?id=1
                삭제?id=1
                수정?id=3
                수정?id=2
                현재와 자신을 사랑하라.
                홍길동
                목록
                """);
        assertThat(out)
                .contains("명언은 존재하지 않습니다.")
                .contains("명언(기존) :")
                .contains("작가(기존) :");
    }

    @Test
    @DisplayName("빌드")
    public void t10() {
        final String out = AppTest.run("""
                등록
                현재를 사랑하라.
                작자미상
                등록
                과거에 집착하지 마라.
                작자미상
                목록
                삭제?id=1
                삭제?id=1
                수정?id=2
                현재와 자신을 사랑하라.
                홍길동
                목록
                빌드
                """);

        assertThat(out)
                .contains("data.json 파일의 내용이 갱신되었습니다.");
    }
}