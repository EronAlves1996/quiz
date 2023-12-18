package com.eronalves;

public final class Alternative {
  final String description;
  final boolean isCorrect;

  public Alternative(String alternativeDescription, boolean isCorrect) {
    this.description = alternativeDescription;
    this.isCorrect = isCorrect;
  }

  public String getDescription() {
    return description;
  }

  public boolean isCorrect() {
    return isCorrect;
  }

}
