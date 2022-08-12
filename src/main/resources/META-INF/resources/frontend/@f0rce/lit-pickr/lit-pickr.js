import { LitElement, html, css } from "lit";

import Pickr from "@simonwep/pickr";

Pickr.prototype.setSwatches = function (swatches) {
  if (!swatches.length) return;
  for (let i = this._swatchColors.length - 1; i > -1; i--) {
    this.removeSwatch(i);
  }
  swatches.forEach(swatch => this.addSwatch(swatch));
}

import { themes } from "./themes";

class LitPickr extends LitElement {
  static get properties() {
    return {
      settings: { type: String },
      enabled: { type: Boolean },
      outputPrecision: { type: Number }
    };
  }

  constructor() {
    super();
    this.outputPrecision = -1;
    this.enabled = true;
  }

  static get styles() {
    return [
      themes,
      css`
        :host {
          display: block;
          width: 100%;
          height: 100%;
        }
      `,
    ];
  }

  render() {
    return html`
      <div
        id="pickr-container"
        style="height: 100%; width: 100%; position: relative;"
      >
        <div
          id="pickr"
        ></div>
      </div>
    `;
  }

  updated(changedProperties) {
    for (let i = 0; i < changedProperties.size; i++) {
      var toUpdate = Array.from(changedProperties.keys())[i];
      var funcToCall = toUpdate + "Changed";
      if (typeof this[funcToCall] == "function") {
        this[funcToCall](); // This line is freaking cool
      }
    }
  }

  async firstUpdated(changedProperties) {
    this.pickrContainerDiv = this.shadowRoot.getElementById("pickr-container");
    this.pickrDiv = this.shadowRoot.getElementById("pickr");
    let settings;

    try {
      settings = await this.parseSettings();
    } catch (e) {
      console.error("[lit-pickr] Failure parsing config", e);
      return;
    }

    this._settings = settings;

    this.initializePickr();
  }

  parseSettings() {
    return new Promise((resolve, reject) => {
      let parsed;
      try {
        const json = JSON.parse(this.settings);
        parsed = json;
      } catch (e) {
        reject(e);
      }

      parsed.el = this.pickrDiv;
      parsed.container = this.pickrContainerDiv;

      this.enabled = !parsed.disabled;

      resolve(parsed);
    })
  }

  initializePickr() {
    this.pickr = new Pickr(this._settings);

    this.pickr.on("init", instance => {
      this.dispatchEvent(new CustomEvent("pickr-init", {
        detail: {
          color: this._getColorsObject(instance.getColor()),
          colorRepresentation: instance.getColorRepresentation(),
        },
      }));
    });

    this.pickr.on("hide", () => {
      this.dispatchEvent(new CustomEvent("pickr-hide", {
        detail: {},
      }));
    });

    this.pickr.on("show", color => {
      this.dispatchEvent(new CustomEvent("pickr-show", {
        detail: {
          color: this._getColorsObject(color),
        },
      }));
    });

    this.pickr.on("save", (color, instance) => {
      this.dispatchEvent(new CustomEvent("pickr-save", {
        detail: {
          color: this._getColorsObject(color),
          colorRepresentation: instance.getColorRepresentation(),
        },
      }));
    });

    this.pickr.on("clear", () => {
      this.dispatchEvent(new CustomEvent("pickr-clear", {
        detail: {},
      }));
    });

    this.pickr.on("change", (color, source, instance) => {
      this.dispatchEvent(new CustomEvent("pickr-change", {
        detail: {
          color: this._getColorsObject(color),
          colorRepresentation: instance.getColorRepresentation(),
        },
      }));
    });

    this.pickr.on("cancel", () => {
      this.dispatchEvent(new CustomEvent("pickr-cancel", {
        detail: {},
      }));
    });

    this.pickr.on("swatchselect", color => {
      this.dispatchEvent(new CustomEvent("pickr-swatchselect", {
        detail: {
          color: this._getColorsObject(color),
        },
      }));
    });
  }

  async settingsChanged() {
    if (this.pickr == undefined) {
      return;
    }

    this.pickr.destroyAndRemove();
    this.pickr = undefined;

    const pickrDiv = document.createElement("div");
    pickrDiv.id = "pickr"
    this.pickrContainerDiv.appendChild(pickrDiv);
    this.pickrDiv = this.shadowRoot.getElementById("pickr");

    let settings;
    try {
      settings = await this.parseSettings();
    } catch (e) {
      console.error("[lit-pickr] Failure parsing config", e);
      return;
    }

    this._settings = settings;

    this.initializePickr();
  }

  enabledChanged() {
    if (this.pickr == undefined) {
      return;
    }

    if (this.enabled) {
      this.pickr.enable();
    } else if (!this.enabled) {
      this.pickr.disable();
    }
  }

  setColor(color, silent) {
    if (this.pickr == undefined) {
      this.addEventListener(
        "pickr-init",
        () => this._setColor(color, silent),
        { once: true }
      );
    } else {
      this._setColor(color, silent);
    }
  }

  /** @private */
  _setColor(color, silent) {
    this.pickr.setColor(color, silent);
  }

  show() {
    if (this.pickr == undefined) {
      this.addEventListener(
        "pickr-init",
        () => this._show(),
        { once: true }
      );
    } else {
      this._show();
    }
  }

  /** @private */
  _show() {
    this.pickr.show();
  }

  hide() {
    if (this.pickr == undefined) {
      this.addEventListener(
        "pickr-init",
        () => this._hide(),
        { once: true }
      );
    } else {
      this._hide();
    }
  }

  /** @private */
  _hide() {
    this.pickr.hide();
  }

  setColorRepresentation(color) {
    if (this.pickr == undefined) {
      this.addEventListener(
        "pickr-init",
        () => this._setColorRepresentation(color),
        { once: true }
      );
    } else {
      this._setColorRepresentation(color);
    }
  }

  /** @private */
  _setColorRepresentation(color) {
    this.pickr.setColorRepresentation(color);
  }

  applyColor(silent) {
    if (this.pickr == undefined) {
      this.addEventListener(
        "pickr-init",
        () => this._applyColor(silent),
        { once: true }
      );
    } else {
      this._applyColor(silent);
    }
  }

  /** @private */
  _applyColor(silent) {
    this.pickr.applyColor(silent);
  }

  addSwatch(color) {
    if (this.pickr == undefined) {
      this.addEventListener(
        "pickr-init",
        () => this._addSwatch(color),
        { once: true }
      );
    } else {
      this._addSwatch(color);
    }
  }

  /** @private */
  _addSwatch(color) {
    this.pickr.addSwatch(color);
  }

  removeSwatch(index) {
    if (this.pickr == undefined) {
      this.addEventListener(
        "pickr-init",
        () => this._removeSwatch(index),
        { once: true }
      );
    } else {
      this._removeSwatch(index);
    }
  }

  /** @private */
  _removeSwatch(index) {
    this.pickr.removeSwatch(index);
  }

  setSwatches(swatches) {
    const array = JSON.parse(swatches);
    if (this.pickr == undefined) {
      this.addEventListener(
        "pickr-init",
        () => this._setSwatches(array),
        { once: true }
      );
    } else {
      this._setSwatches(array);
    }
  }

  /** @private */
  _setSwatches(swatches) {
    this.pickr.setSwatches(swatches);
  }

  /** @private */
  _getColorsObject(color) {
    // remove alpha from returned colors
    if (this._settings.lockOpacity) {

      const _mapper = (original, next) => (precision = -1) => {
        return next(~precision ? original.map(v => Number(v.toFixed(precision))) : original);
      };

      const hsl = _mapper(color.toHSLA(), arr => `hsl(${arr[0]}, ${arr[1]}%, ${arr[2]}%)`);
      const hsv = _mapper(color.toHSVA(), arr => `hsv(${arr[0]}, ${arr[1]}%, ${arr[2]}%)`);
      const rgb = _mapper(color.toRGBA(), arr => `rgb(${arr[0]}, ${arr[1]}, ${arr[2]})`);

      return {
        cmyk: color == null ? null : color.toCMYK().toString(this.outputPrecision),
        hexa: color == null ? null : color.toHEXA().toString(),
        hsla: color == null ? null : hsl(this.outputPrecision),
        hsva: color == null ? null : hsv(this.outputPrecision),
        rgba: color == null ? null : rgb(this.outputPrecision),
      }
    }

    return {
      cmyk: color == null ? null : color.toCMYK().toString(this.outputPrecision),
      hexa: color == null ? null : color.toHEXA().toString(),
      hsla: color == null ? null : color.toHSLA().toString(this.outputPrecision),
      hsva: color == null ? null : color.toHSVA().toString(this.outputPrecision),
      rgba: color == null ? null : color.toRGBA().toString(this.outputPrecision)
    }
  }
}

customElements.define("lit-pickr", LitPickr);
