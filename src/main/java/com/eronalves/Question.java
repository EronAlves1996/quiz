package com.eronalves;

import java.util.List;

public final class Question {
  final String description;
  final List<Alternative> alternatives;

  public Question(String description, List<Alternative> alternatives) {
    this.description = description;
    this.alternatives = alternatives;
  }

}
