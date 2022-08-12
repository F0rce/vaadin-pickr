package org.vaadin.addons.de.f0rce.pickr.events;

import org.vaadin.addons.de.f0rce.pickr.Pickr;
import com.vaadin.flow.component.ComponentEvent;
import com.vaadin.flow.component.DomEvent;

/** @author David "F0rce" Dodlek */
@SuppressWarnings("serial")
@DomEvent("pickr-cancel")
public class PickrCancelEvent extends ComponentEvent<Pickr> {

  public PickrCancelEvent(Pickr source, boolean fromClient) {
    super(source, fromClient);
  }
}
