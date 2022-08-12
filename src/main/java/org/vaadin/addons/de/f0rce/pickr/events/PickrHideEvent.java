package org.vaadin.addons.de.f0rce.pickr.events;

import org.vaadin.addons.de.f0rce.pickr.Pickr;
import org.vaadin.addons.de.f0rce.pickr.interfaces.IPickrVisibilityChange;
import com.vaadin.flow.component.ComponentEvent;
import com.vaadin.flow.component.DomEvent;

/** @author David "F0rce" Dodlek */
@SuppressWarnings("serial")
@DomEvent("pickr-hide")
public class PickrHideEvent extends ComponentEvent<Pickr> implements IPickrVisibilityChange {

  public PickrHideEvent(Pickr source, boolean fromClient) {
    super(source, fromClient);
  }

  @Override
  public boolean isVisible() {
    return false;
  }
}
