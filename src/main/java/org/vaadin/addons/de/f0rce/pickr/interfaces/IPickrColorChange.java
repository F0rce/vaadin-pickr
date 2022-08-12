package org.vaadin.addons.de.f0rce.pickr.interfaces;

import org.vaadin.addons.de.f0rce.pickr.enums.PickrColorRepresentation;
import org.vaadin.addons.de.f0rce.pickr.util.PickrColor;

/** @author David "F0rce" Dodlek */
public interface IPickrColorChange {
  public PickrColor getColor();

  public PickrColorRepresentation getColorRepresentation();
}
