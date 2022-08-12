package org.vaadin.addons.de.f0rce.pickr.enums;

public enum PickrPosition {
  TOP_START("top-start"),
  TOP_MIDDLE("top-middle"),
  TOP_END("top-end"),
  LEFT_START("left-start"),
  LEFT_MIDDLE("left-middle"),
  LEFT_END("left-end"),
  BOTTOM_START("bottom-start"),
  BOTTOM_MIDDLE("bottom-middle"),
  BOTTOM_END("bottom-end"),
  RIGHT_START("right-start"),
  RIGHT_MIDDLE("right-middle"),
  RIGHT_END("right-end");

  private String position;

  private PickrPosition(String position) {
    this.position = position;
  }

  public String getPosition() {
    return this.position;
  }

  public static PickrPosition findByPosition(String position) {
    for (PickrPosition p : values()) {
      if (p.getPosition().equals(position)) {
        return p;
      }
    }
    return null;
  }
}
