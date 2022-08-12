package org.vaadin.addons.de.f0rce.pickr.enums;

public enum PickrColorRepresentation {
  HEX("hex"),
  RGBA("rgba"),
  HSVA("hsva"),
  HSLA("hsla"),
  CMYK("cmyk");

  private String defaultRepresentation;

  private PickrColorRepresentation(String defaultRepresentation) {
    this.defaultRepresentation = defaultRepresentation;
  }

  public String getColorRepresentation() {
    return this.defaultRepresentation;
  }

  public static PickrColorRepresentation findByColorRepresentation(
      String defaultRepresentation) {
    for (PickrColorRepresentation dr : values()) {
      if (dr.getColorRepresentation().equals(defaultRepresentation)) {
        return dr;
      }
    }
    return null;
  }
}
