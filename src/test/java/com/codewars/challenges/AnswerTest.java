package com.codewars.challenges;

import static org.assertj.core.api.Assertions.assertThat;

public class AnswerTest {

    @org.junit.Test
    public void AnswerTest1(){
        int answer = Answer.answer("abccbaabccba");
        assertThat(answer).isEqualTo(2);
    }

    @org.junit.Test
    public void AnswerTest2(){
        int answer = Answer.answer("abcabcabcabc");
        assertThat(answer).isEqualTo(4);
    }

}
