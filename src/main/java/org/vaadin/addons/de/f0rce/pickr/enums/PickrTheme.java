package org.vaadin.addons.de.f0rce.pickr.enums;

public enum PickrTheme {
  CLASSIC("classic"),
  MONOLITH("monolith"),
  NANO("nano");

  private String theme;

  private PickrTheme(String theme) {
    this.theme = theme;
  }

  public String getTheme() {
    return this.theme;
  }

  public static PickrTheme findByTheme(String theme) {
    for (PickrTheme t : values()) {
      if (t.getTheme().equals(theme)) {
        return t;
      }
    }
    return null;
  }
}
