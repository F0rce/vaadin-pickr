package org.vaadin.addons.de.f0rce.pickr;

import java.util.ArrayList;
import java.util.Arrays;
import org.vaadin.addons.de.f0rce.pickr.enums.PickrColorRepresentation;
import org.vaadin.addons.de.f0rce.pickr.enums.PickrTheme;
import org.vaadin.addons.de.f0rce.pickr.events.PickrCancelEvent;
import org.vaadin.addons.de.f0rce.pickr.events.PickrChangeEvent;
import org.vaadin.addons.de.f0rce.pickr.events.PickrClearEvent;
import org.vaadin.addons.de.f0rce.pickr.events.PickrHideEvent;
import org.vaadin.addons.de.f0rce.pickr.events.PickrInitEvent;
import org.vaadin.addons.de.f0rce.pickr.events.PickrSaveEvent;
import org.vaadin.addons.de.f0rce.pickr.events.PickrShowEvent;
import org.vaadin.addons.de.f0rce.pickr.events.PickrSwatchSelectEvent;
import org.vaadin.addons.de.f0rce.pickr.interfaces.IPickrColorChange;
import org.vaadin.addons.de.f0rce.pickr.interfaces.IPickrVisibilityChange;
import org.vaadin.addons.de.f0rce.pickr.settings.PickrSettings;
import org.vaadin.addons.de.f0rce.pickr.util.PickrColor;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.vaadin.flow.component.AttachEvent;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.DetachEvent;
import com.vaadin.flow.component.HasSize;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.NpmPackage;
import com.vaadin.flow.shared.Registration;

/** @author David "F0rce" Dodlek */
@SuppressWarnings("serial")
@Tag("lit-pickr")
@NpmPackage(value = "@simonwep/pickr", version = "1.8.2")
@NpmPackage(value = "lit", version = "2.2.8")
@JsModule("./@f0rce/lit-pickr/lit-pickr.js")
public class Pickr extends Component implements HasSize {

  private PickrSettings settings = new PickrSettings();
  private PickrColor color = new PickrColor();
  private boolean open = false;
  private boolean enabled = true;
  private PickrColorRepresentation colorRepresentation = null;
  private ArrayList<String> swatches = new ArrayList<>();
  private int outputPrecision = -1;

  // internal to avoid useless roundtrip
  private boolean hasBeenDetached = false;

  @Override
  protected void onAttach(AttachEvent attachEvent) {
    if (hasBeenDetached) {
      if (!this.color.isNull()) {
        this.setColor(color.getHEXA());
      }
      if (!this.swatches.isEmpty()) {
        this.setSwatches(this.swatches.toArray(String[]::new));
      }
      if (this.colorRepresentation != null) {
        this.setColorRepresentation(this.colorRepresentation);
      }
      hasBeenDetached = false;
    }
  }

  @Override
  protected void onDetach(DetachEvent detachEvent) {
    hasBeenDetached = true;
  }

  /** Initialize Pickr with default {@link PickrSettings}. */
  public Pickr() {
    initProcedure();
  }

  /**
   * Initialize Pickr with customized {@link PickrSettings}.
   *
   * @param settings {@link PickrSettings}
   */
  public Pickr(PickrSettings settings) {
    this.settings = settings;
    initProcedure();
  }

  // init procedure
  private void initProcedure() {
    this.setHeight("1.3em");
    this.setWidth("1.3em");

    this.enabled = !this.settings.isDisabled();
    this.colorRepresentation = this.settings.getDefaultRepresentation();
    this.swatches.addAll(this.settings.getSwatches());

    this.addListener(PickrInitEvent.class, this::updateColor);
    this.addListener(PickrSaveEvent.class, this::updateColor);
    this.addListener(PickrShowEvent.class, this::updateVisibility);
    this.addListener(PickrHideEvent.class, this::updateVisibility);

    Gson gson = new GsonBuilder().create();
    this.getElement().setProperty("settings", gson.toJson(this.settings));
  }

  private void updateVisibility(IPickrVisibilityChange event) {
    this.open = event.isVisible();
  }

  private void updateColor(IPickrColorChange event) {
    this.color = event.getColor();
    this.colorRepresentation = event.getColorRepresentation();
  }

  /**
   * Parses a string which represents a color (e.g. <code>#fff</code>, <code>rgb(10, 156, 23)</code>
   * ) or name e.g. 'magenta'. <code>null</code> will clear the color.
   *
   * @param color {@link String}
   */
  public void setColor(String color) {
    this.setColor(color, false);
  }

  /**
   * Parses a string which represents a color (e.g. <code>#fff</code>, <code>rgb(10, 156, 23)</code>
   * ) or name e.g. 'magenta'. <code>null</code> will clear the color.</br></br>If <code>silent
   * </code> is true (Default is false), the button won't change the color.
   *
   * @param color {@link String}
   * @param silent boolean
   */
  public void setColor(String color, boolean silent) {
    this.getElement().callJsFunction("setColor", color, silent);
  }

  /**
   * Initialization done - {@link Pickr} can be used.
   *
   * @param listener {@link ComponentEventListener}
   * @return {@link Registration}
   */
  public Registration addInitListener(ComponentEventListener<PickrInitEvent> listener) {
    return this.addListener(PickrInitEvent.class, listener);
  }

  /**
   * {@link Pickr} get closed.
   *
   * @param listener {@link ComponentEventListener}
   * @return {@link Registration}
   */
  public Registration addHideListener(ComponentEventListener<PickrHideEvent> listener) {
    return this.addListener(PickrHideEvent.class, listener);
  }

  /**
   * {@link Pickr} got opened.
   *
   * @param listener {@link ComponentEventListener}
   * @return {@link Registration}
   */
  public Registration addShowListener(ComponentEventListener<PickrShowEvent> listener) {
    return this.addListener(PickrShowEvent.class, listener);
  }

  /**
   * User clicked the save / clear button. Also fired on {@link PickrClearEvent} with true as {@link
   * PickrColor#isNull()}.
   *
   * @param listener {@link ComponentEventListener}
   * @return {@link Registration}
   */
  public Registration addSaveListener(ComponentEventListener<PickrSaveEvent> listener) {
    return this.addListener(PickrSaveEvent.class, listener);
  }

  /**
   * User cleared the color.
   *
   * @param listener {@link ComponentEventListener}
   * @return {@link Registration}
   */
  public Registration addClearListener(ComponentEventListener<PickrClearEvent> listener) {
    return this.addListener(PickrClearEvent.class, listener);
  }

  /**
   * Color has changed (but not saved). Also fired on {@link
   * PickrSwatchSelectEvent}.</br></br><b>The event is sent for every change, it could send a lot of
   * data!</b>
   *
   * @param listener {@link ComponentEventListener}
   * @return {@link Registration}
   */
  public Registration addChangeListener(ComponentEventListener<PickrChangeEvent> listener) {
    return this.addListener(PickrChangeEvent.class, listener);
  }

  /**
   * User clicked the cancel button (return to previous color).
   *
   * @param listener {@link ComponentEventListener}
   * @return {@link Registration}
   */
  public Registration addCancelListener(ComponentEventListener<PickrCancelEvent> listener) {
    return this.addListener(PickrCancelEvent.class, listener);
  }

  /**
   * User clicked one of the swatches.
   *
   * @param listener {@link ComponentEventListener}
   * @return {@link Registration}
   */
  public Registration addSwatchSelectListener(
      ComponentEventListener<PickrSwatchSelectEvent> listener) {
    return this.addListener(PickrSwatchSelectEvent.class, listener);
  }

  /** Shows the color-picker. */
  public void show() {
    this.getElement().callJsFunction("show");
  }

  /** Hides the color-picker. */
  public void hide() {
    this.getElement().callJsFunction("hide");
  }

  /**
   * Returns true if the color picker is currently open.
   *
   * @return boolean
   */
  public boolean isOpen() {
    return this.open;
  }

  /**
   * Enable/Disable pickr and remove/add the <code>disabled</code> class to the button.
   *
   * @param enabled boolean
   */
  public void setEnabled(boolean enabled) {
    this.enabled = enabled;
    this.getElement().setProperty("enabled", enabled);
  }

  /**
   * Returns true if the color picker is currently enabled.
   *
   * @return boolean
   */
  public boolean isEnabled() {
    return this.enabled;
  }

  /**
   * Returns the current {@link PickrColor} object.
   *
   * @return {@link PickrColor}
   */
  public PickrColor getColor() {
    return this.color;
  }

  /**
   * Change the current color-representation.
   *
   * @param colorRepresentation {@link PickrColorRepresentation}
   */
  public void setColorRepresentation(PickrColorRepresentation colorRepresentation) {
    this.getElement()
        .callJsFunction("setColorRepresentation", colorRepresentation.getColorRepresentation());
  }

  /**
   * Returns the currently used color-representation.
   *
   * @return {@link PickrColorRepresentation}
   */
  public PickrColorRepresentation getColorRepresentation() {
    return this.colorRepresentation;
  }

  /** Same as pressing the save button. */
  public void applyColor() {
    this.applyColor(false);
  }

  /**
   * Same as pressing the save button. If silent is true the {@link PickrSaveEvent} won't be called.
   *
   * @param silent boolean
   */
  public void applyColor(boolean silent) {
    this.getElement().callJsFunction("applyColor", silent);
  }

  /**
   * Adds a color to the swatch palette.
   *
   * @param swatch {@link String}
   */
  public void addSwatch(String swatch) {
    this.swatches.add(swatch);
    this.getElement().callJsFunction("addSwatch", swatch);
  }

  /**
   * Removes a color from the swatch palette by its index.
   *
   * @param index int
   */
  public void removeSwatch(int index) {
    this.swatches.remove(index);
  }

  /**
   * Overwrites the current swatch palette.
   *
   * @param swatches
   */
  public void setSwatches(String... swatches) {
    this.swatches = new ArrayList<String>(Arrays.asList(swatches));

    Gson gson = new GsonBuilder().create();
    this.getElement().callJsFunction("setSwatches", gson.toJson(swatches));
  }

  /**
   * Returns the current swatch palette.
   *
   * @return {@link ArrayList}
   */
  public ArrayList<String> getSwatches() {
    return this.swatches;
  }

  /**
   * Sets the precision (rounding) of the output string for all {@link PickrColor} values.
   *
   * @param outputPrecision int
   */
  public void setOutputPrecision(int outputPrecision) {
    this.outputPrecision = outputPrecision;
    this.getElement().setProperty("outputPrecision", outputPrecision);
  }

  /**
   * Returns the current set precision of the output string.
   *
   * @return int
   */
  public int getOutputPrecision() {
    return this.outputPrecision;
  }

  /**
   * Disables the precision (rounding) of the output string. Same as <code>.setOutputPrecision(-1)
   * </code>.
   */
  public void disableOutputPrecision() {
    this.setOutputPrecision(-1);
  }

  /**
   * Update the {@link PickrSettings} during runtime (to change the {@link PickrTheme} for example).
   *
   * @param settings {@link PickrSettings}
   */
  public void setSettings(PickrSettings settings) {
    this.settings = settings;

    this.enabled = !this.settings.isDisabled();
    this.colorRepresentation = this.settings.getDefaultRepresentation();
    this.swatches.addAll(this.settings.getSwatches());

    Gson gson = new GsonBuilder().create();
    this.getElement().setProperty("settings", gson.toJson(this.settings));
  }

  /**
   * Returns the current set {@link PickrSettings}.
   *
   * @return {@link PickrSettings}
   */
  public PickrSettings getSettings() {
    return this.settings;
  }
}
