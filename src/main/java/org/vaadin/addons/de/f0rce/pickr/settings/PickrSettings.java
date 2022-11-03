package org.vaadin.addons.de.f0rce.pickr.settings;

import java.util.ArrayList;
import java.util.Arrays;
import org.vaadin.addons.de.f0rce.pickr.Pickr;
import org.vaadin.addons.de.f0rce.pickr.enums.PickrColorRepresentation;
import org.vaadin.addons.de.f0rce.pickr.enums.PickrPosition;
import org.vaadin.addons.de.f0rce.pickr.enums.PickrTheme;
import org.vaadin.addons.de.f0rce.pickr.events.PickrSaveEvent;
import org.vaadin.addons.de.f0rce.pickr.util.PickrColor;
import com.google.gson.annotations.SerializedName;

/**
 * Change the settings of {@link Pickr}.
 *
 * @author David "F0rce" Dodlek
 */
public class PickrSettings {

  private String theme = PickrTheme.CLASSIC.getTheme();
  private boolean closeOnScroll = false;
  private int padding = 8;
  private boolean inline = false;
  private boolean autoReposition = true;
  private String sliders = null;
  private boolean disabled = false;
  private boolean lockOpacity = false;
  private int outputPrecision = 0;
  private boolean comparison = true;

  @SerializedName("default")
  private String defaultColor = "#42445a";

  private ArrayList<String> swatches = new ArrayList<>();
  private String defaultRepresentation = null;
  private boolean showAlways = false;
  private String closeWithKey = "Escape";
  private String position = PickrPosition.BOTTOM_MIDDLE.getPosition();
  private boolean adjustableNumbers = true;
  private PickrComponents components = new PickrComponents();
  private PickrI18N i18n;

  /**
   * Returns the current set {@link PickrTheme}.
   *
   * @return {@link PickrTheme}
   */
  public PickrTheme getTheme() {
    return PickrTheme.findByTheme(theme);
  }

  /**
   * Which theme you want to use.
   *
   * @param theme {@link PickrTheme}
   */
  public void setTheme(PickrTheme theme) {
    this.theme = theme.getTheme();
  }

  /**
   * Returns if closing on scrolling is enabled/disabled.
   *
   * @return boolean
   */
  public boolean isCloseOnScroll() {
    return closeOnScroll;
  }

  /**
   * Nested scrolling is currently not supported and as this would be really sophisticated to add
   * this. It's easier to set this to true which will hide pickr if the user scrolls the area
   * behind. it.
   *
   * @param closeOnScroll boolean
   */
  public void setCloseOnScroll(boolean closeOnScroll) {
    this.closeOnScroll = closeOnScroll;
  }

  /**
   * Returns the current set padding.
   *
   * @return int
   */
  public int getPadding() {
    return padding;
  }

  /**
   * Size of gap between {@link Pickr} (dialog) and the corresponding reference (toggle-button) in
   * px.
   *
   * @param padding int
   */
  public void setPadding(int padding) {
    this.padding = padding;
  }

  /**
   * Returns if inline is enabled/disabled.
   *
   * @return boolean
   */
  public boolean isInline() {
    return inline;
  }

  /**
   * If true pickr won't be floating, and instead will append after the in el resolved element.<br>
   * It's possible to hide it via {@link Pickr#hide()} anyway.
   *
   * @param inline boolean
   */
  public void setInline(boolean inline) {
    this.inline = inline;
  }

  /**
   * Returns if auto reposition is enabled/disabled.
   *
   * @return boolean
   */
  public boolean isAutoReposition() {
    return autoReposition;
  }

  /**
   * If true, pickr will be repositioned automatically on page scroll or window resize. Can be set
   * to false to make custom positioning easier.
   *
   * @param autoReposition boolean
   */
  public void setAutoReposition(boolean autoReposition) {
    this.autoReposition = autoReposition;
  }

  /**
   * Retruns the current set direction in which the knoby of hue and opacity can be moved.
   *
   * @return {@link String}
   */
  public String getSliders() {
    return sliders;
  }

  /**
   * Defines the direction in which the knobs of hue and opacity can be moved.<br>
   * 'v' => opacity- and hue-slider can both only moved vertically.<br>
   * 'hv' => opacity-slider can be moved horizontally and hue-slider vertically.<br>
   * Can be used to apply custom layouts.
   *
   * @param sliders {@link String}
   */
  public void setSliders(String sliders) {
    this.sliders = sliders;
  }

  /**
   * Returns if the buttons are currently enabled/disabled.
   *
   * @return boolean
   */
  public boolean isDisabled() {
    return disabled;
  }

  /**
   * Start state. If true 'disabled' will be added to the button's classlist.
   *
   * @param disabled boolean
   */
  public void setDisabled(boolean disabled) {
    this.disabled = disabled;
  }

  /**
   * Returns if lockOpacity is enabled/disabled.
   *
   * @return the lockOpacity
   */
  public boolean isLockOpacity() {
    return lockOpacity;
  }

  /**
   * If true, the user won't be able to adjust any opacity. Opacity will be locked at 1 and the
   * opacity slider will be removed.
   *
   * @param lockOpacity boolean
   */
  public void setLockOpacity(boolean lockOpacity) {
    this.lockOpacity = lockOpacity;
  }

  /**
   * Returns the current set output precision.
   *
   * @return int
   */
  public int getOutputPrecision() {
    return outputPrecision;
  }

  /**
   * Precision of output string (only effective if {@link PickrInteractions#setInput(boolean)} is
   * true).<br>
   * If you want to change the precision of the values in {@link PickrColor} use {@link
   * Pickr#setOutputPrecision(int)}.
   *
   * @param outputPrecision int
   */
  public void setOutputPrecision(int outputPrecision) {
    this.outputPrecision = outputPrecision;
  }

  /**
   * Returns the current set change/save behaviour.<br>
   * See: {@link PickrSettings#setComparison(boolean)} for explanation.
   *
   * @return the comparision
   */
  public boolean isComparison() {
    return comparison;
  }

  /**
   * Defines change/save behavior:<br>
   * - to keep current color in place until save is pressed, set to `true`<br>
   * - to apply color to button and preview (save) in sync with each change (from picker or
   * palette), set to `false`
   *
   * @param comparison boolean
   */
  public void setComparison(boolean comparison) {
    this.comparison = comparison;
  }

  /**
   * Returns the current set default color.
   *
   * @return {@link String}
   */
  public String getDefaultColor() {
    return defaultColor;
  }

  /**
   * Default color. If you're using a named color such as red, white ... set a value for {@link
   * #setDefaultRepresentation(PickrColorRepresentation)} too as there is no button for
   * named-colors.
   *
   * @param defaultColor {@link String}
   */
  public void setDefaultColor(String defaultColor) {
    this.defaultColor = defaultColor;
  }

  /**
   * Returns the current set swatches.
   *
   * @return {@link ArrayList}
   */
  public ArrayList<String> getSwatches() {
    return swatches;
  }

  /**
   * Optional color swatches.<br>
   * Types are all those which can be produced by pickr e.g. hex(a), hsv(a), hsl(a), rgb(a), cmyk,
   * and also CSS color names like 'magenta'.<br>
   * Example: ['#F44336', '#E91E63', '#9C27B0', '#673AB7'],
   *
   * @param swatches String[]
   */
  public void setSwatches(String... swatches) {
    this.swatches.addAll(Arrays.asList(swatches));
  }

  /**
   * Returns the current set default {@link PickrColorRepresentation}.
   *
   * @return the defaultRepresentation
   */
  public PickrColorRepresentation getDefaultRepresentation() {
    return PickrColorRepresentation.findByColorRepresentation(defaultRepresentation);
  }

  /**
   * Default color representation of the input/output textbox.
   *
   * @param defaultRepresentation {@link PickrColorRepresentation}
   */
  public void setDefaultRepresentation(PickrColorRepresentation defaultRepresentation) {
    this.defaultRepresentation = defaultRepresentation.getColorRepresentation();
  }

  /**
   * Returns if showAlways is enabled/disabled.
   *
   * @return the showAlways
   */
  public boolean isShowAlways() {
    return showAlways;
  }

  /**
   * Option to keep the color picker always visible.<br>
   * You can still hide / show it via {@link Pickr#hide()} and {@link Pickr#show()}.<br>
   * The save button keeps its functionality, so still fires the {@link PickrSaveEvent} when
   * clicked.
   *
   * @param showAlways boolean
   */
  public void setShowAlways(boolean showAlways) {
    this.showAlways = showAlways;
  }

  /**
   * Return the key with which pickr can be closed.
   *
   * @return {@link String}
   */
  public String getCloseWithKey() {
    return closeWithKey;
  }

  /**
   * Close pickr with a keypress.<br>
   * Default is 'Escape'. Can be the event key or code.<br>
   * (see: https://developer.mozilla.org/en-US/docs/Web/API/KeyboardEvent/key)
   *
   * @param closeWithKey {@link String}
   */
  public void setCloseWithKey(String closeWithKey) {
    this.closeWithKey = closeWithKey;
  }

  /**
   * Returns the current defined {@link PickrPosition} of the color-pickr.
   *
   * @return {@link PickrPosition}
   */
  public PickrPosition getPosition() {
    return PickrPosition.findByPosition(position);
  }

  /**
   * Defines the position of the color-picker.<br>
   * If clipping occurs, the color picker will automatically choose its position.
   *
   * @param position {@link PickrPosition}
   */
  public void setPosition(PickrPosition position) {
    this.position = position.getPosition();
  }

  /**
   * Returns if adjustableNumbers is enabled/disabled.
   *
   * @return the adjustableNumbers
   */
  public boolean isAdjustableNumbers() {
    return adjustableNumbers;
  }

  /**
   * Enables the ability to change numbers in an input field with the scroll-wheel.<br>
   * To use it set the cursor on a position where a number is and scroll, use ctrl to make steps of
   * five
   *
   * @param adjustableNumbers the adjustableNumbers to set
   */
  public void setAdjustableNumbers(boolean adjustableNumbers) {
    this.adjustableNumbers = adjustableNumbers;
  }

  /**
   * Returns the current {@link PickrComponents}.
   *
   * @return {@link PickrComponents}
   */
  public PickrComponents getComponents() {
    return components;
  }

  /**
   * Show or hide specific components.<br>
   * By default only the palette, hue and the save button is visible.
   *
   * @param components {@link PickrComponents}
   */
  public void setComponents(PickrComponents components) {
    this.components = components;
  }

  /**
   * Returns the current set {@link PickrI18N}.
   *
   * @return {@link PickrI18N}
   */
  public PickrI18N getI18N() {
    return i18n;
  }

  /**
   * Set the translations.
   *
   * @param i18n {@link PickrI18N}
   */
  public void setI18N(PickrI18N i18n) {
    this.i18n = i18n;
  }
}
