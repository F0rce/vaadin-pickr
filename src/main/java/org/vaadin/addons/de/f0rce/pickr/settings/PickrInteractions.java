package org.vaadin.addons.de.f0rce.pickr.settings;

import org.vaadin.addons.de.f0rce.pickr.Pickr;
import org.vaadin.addons.de.f0rce.pickr.enums.PickrColorRepresentation;

/**
 * Show or hide components on the bottom interaction bar.
 *
 * @author David "F0rce" Dodlek
 */
public class PickrInteractions {

  private boolean hex = false;
  private boolean rgba = false;
  private boolean hsla = false;
  private boolean hsva = false;
  private boolean cmyk = false;
  private boolean input = false;
  private boolean cancel = false;
  private boolean clear = false;
  private boolean save = true;

  /**
   * Returns if the 'input/output format as hex' button is visible.
   *
   * @return boolean
   */
  public boolean isHex() {
    return hex;
  }

  /**
   * Display 'input/output format as hex' button (hexadecimal representation of the rgba value).
   *
   * @param boolean
   */
  public void setHex(boolean hex) {
    this.hex = hex;
  }

  /**
   * Returns if the 'input/output format as rgba' button is visible.
   *
   * @return boolean
   */
  public boolean isRgba() {
    return rgba;
  }

  /**
   * Display 'input/output format as rgba' button (red green blue and alpha).
   *
   * @param rgba boolean
   */
  public void setRgba(boolean rgba) {
    this.rgba = rgba;
  }

  /**
   * Returns if the 'input/output format as hsla' button is visible.
   *
   * @return boolean
   */
  public boolean isHsla() {
    return hsla;
  }

  /**
   * Display 'input/output format as hsla' button (hue saturation lightness and alpha).
   *
   * @param hsla boolean
   */
  public void setHsla(boolean hsla) {
    this.hsla = hsla;
  }

  /**
   * Returns if the 'input/output format as hsva' button is visible.
   *
   * @return boolean
   */
  public boolean isHsva() {
    return hsva;
  }

  /**
   * Display 'input/output format as hsva' button (hue saturation value and alpha).
   *
   * @param hsva boolean
   */
  public void setHsva(boolean hsva) {
    this.hsva = hsva;
  }

  /**
   * Returns if the 'input/output format as cmyk' button is visible.
   *
   * @return boolean
   */
  public boolean isCmyk() {
    return cmyk;
  }

  /**
   * Display 'input/output format as cmyk' button (cyan mangenta yellow key )
   *
   * @param cmyk boolean
   */
  public void setCmyk(boolean cmyk) {
    this.cmyk = cmyk;
  }

  /**
   * Returns if the input/output textbox is visible.
   *
   * @return boolean
   */
  public boolean isInput() {
    return input;
  }

  /**
   * Display input/output textbox which shows the selected color value.<br>
   * The format of the input is determined by {@link PickrColorRepresentation} ({@link
   * Pickr#setColorRepresentation(PickrColorRepresentation)}), and can be changed by the user with
   * the buttons set by {@link #setHex(boolean)}, {@link #setRgba(boolean)}, {@link
   * #setHsla(boolean)}, etc.
   *
   * @param input boolean
   */
  public void setInput(boolean input) {
    this.input = input;
  }

  /**
   * Returns if the cancel button is visible.
   *
   * @return boolean
   */
  public boolean isCancel() {
    return cancel;
  }

  /**
   * Display cancel button, resets the color to the previous state.
   *
   * @param cancel boolean
   */
  public void setCancel(boolean cancel) {
    this.cancel = cancel;
  }

  /**
   * Returns if the clear button is visible.
   *
   * @return boolean
   */
  public boolean isClear() {
    return clear;
  }

  /**
   * Display clear button. Same as cancel, but keeps the dialog open.
   *
   * @param clear the clear to set
   */
  public void setClear(boolean clear) {
    this.clear = clear;
  }

  /**
   * Returns if the save button is visible.
   *
   * @return boolean
   */
  public boolean isSave() {
    return save;
  }

  /**
   * Display save button.
   *
   * @param save boolean
   */
  public void setSave(boolean save) {
    this.save = save;
  }
}
