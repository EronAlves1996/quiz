package com.eronalves;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 * Game
 */
@SessionScoped
@Named
public class Game implements Serializable {

  private Stack<Question> questions;
  private int questionPosition;
  private String actualQuestion;
  private List<Alternative> alternatives;

  public String start() {
    questionPosition = 0;
    initializeQuestionStack();
    return nextQuestion();
  }

  private void incrementQuestion() {
    Question question = questions.pop();
    actualQuestion = question.description;
    alternatives = question.alternatives;
    questionPosition++;
  }

  private void initializeQuestionStack() {
    List<Question> questionList = Arrays.asList(
        new Question("Quem roeu a roupa do rei de roma?",
            Arrays.asList(
                new Alternative("Rato", true),
                new Alternative("Pato", false),
                new Alternative("Napoleão", false),
                new Alternative("João", false))),
        new Question("Quem deu o cu?",
            Arrays.asList(new Alternative("Mau Glove", true),
                new Alternative("Deyvid Bahia", false),
                new Alternative("José Doctor Cuck", false))),
        new Question("Quem foi o pior presidente do Brasil",
            Arrays.asList(new Alternative("Lula", false),
                new Alternative("Dilma", false),
                new Alternative("Bolsonaro", true),
                new Alternative("Fernando Henrique Cardoso", false))),
        new Question("Pior jogador de futebol, que mais decepcionou?",
            Arrays.asList(new Alternative("Vinicius Jr.", false),
                new Alternative("Neymar", true),
                new Alternative("Neymar pai", false),
                new Alternative("Ronaldo Fenomeno", false))),
        new Question("Prêmio maior nazista de 2023",
            Arrays.asList(new Alternative("Kanye West", false),
                new Alternative("Hitler", false),
                new Alternative("Farid Germano Filho", false),
                new Alternative("Monark", true))));
    Collections.shuffle(questionList);
    questions = new Stack<>();
    questions.addAll(questionList);
  }

  public String restart() {
    return "/index.xhtml";
  }

  public String nextQuestion() {
    incrementQuestion();
    return "/question.xhtml";
  }

  public String answerQuestion(Alternative alternative) {
    if (alternative.isCorrect()) {
      if (questions.isEmpty()) {
        return "/winner.xhtml";
      }
      return "/correct-answer.xhtml";
    }
    return "/wrong-answer.xhtml";
  }

  public String getRightAnswer() {
    return alternatives
        .stream()
        .filter(a -> a.isCorrect)
        .findFirst()
        .orElse(new Alternative("Sem alternativas corretas", true)).description;
  }

  public int getQuestionPosition() {
    return questionPosition;
  }

  public String getActualQuestion() {
    return actualQuestion;
  }

  public List<Alternative> getAlternatives() {
    return alternatives;
  }

}
