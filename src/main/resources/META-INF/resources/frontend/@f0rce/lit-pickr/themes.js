import { css } from "lit";

export const themes = css`
.pickr {
  position: relative;
  overflow: visible;
  transform: translateY(0);
  height: 100%;
  width: 100%;
}
.pickr * {
  box-sizing: border-box;
  outline: none;
  border: none;
  -webkit-appearance: none;
}
.pickr .pcr-button {
  position: absolute;
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
  height: 100%;
  width: 100%;
  padding: 0.5em;
  cursor: pointer;
  border-radius: var(--lumo-border-radius-m);
  background: url('data:image/svg+xml;utf8, <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 50 50" stroke="%2342445A" stroke-width="5px" stroke-linecap="round"><path d="M45,45L5,5"></path><path d="M45,5L5,45"></path></svg>')
    no-repeat center;
  background-size: 0;
  transition: all 0.3s;
}
.pickr .pcr-button::before {
  position: absolute;
  content: "";
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
  width: 100%;
  height: 100%;
  background: url('data:image/svg+xml;utf8, <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 2 2"><path fill="white" d="M1,0H2V1H1V0ZM0,1H1V2H0V1Z"/><path fill="gray" d="M0,0H1V1H0V0ZM1,1H2V2H1V1Z"/></svg>');
  background-size: 0.5em;
  border-radius: var(--lumo-border-radius-m);
  z-index: -1;
}
.pickr .pcr-button::before {
  z-index: initial;
}
.pickr .pcr-button::after {
  position: absolute;
  content: "";
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
  height: 100%;
  width: 100%;
  transition: background 0.3s;
  background: var(--pcr-color);
  border-radius: var(--lumo-border-radius-m);
}
.pickr .pcr-button.clear {
  background-size: 70%;
}
.pickr .pcr-button.clear::before {
  opacity: 0;
}
.pickr .pcr-button.clear:focus {
  box-shadow: 0 0 0 1px rgba(255, 255, 255, 0.85), 0 0 0 3px var(--pcr-color);
}
.pickr .pcr-button.disabled {
  cursor: not-allowed;
}
.pickr *,
.pcr-app * {
  box-sizing: border-box;
  outline: none;
  border: none;
  -webkit-appearance: none;
}
.pickr input:focus,
.pickr input.pcr-active,
.pickr button:focus,
.pickr button.pcr-active,
.pcr-app input:focus,
.pcr-app input.pcr-active,
.pcr-app button:focus,
.pcr-app button.pcr-active {
  box-shadow: 0 0 0 1px var(--lumo-base-color), 0 0 0 3px var(--pcr-color);
}
.pickr .pcr-palette,
.pickr .pcr-slider,
.pcr-app .pcr-palette,
.pcr-app .pcr-slider {
  transition: box-shadow 0.3s;
}
.pickr .pcr-palette:focus,
.pickr .pcr-slider:focus,
.pcr-app .pcr-palette:focus,
.pcr-app .pcr-slider:focus {
  box-shadow: 0 0 0 1px rgba(255, 255, 255, 0.85), 0 0 0 3px rgba(0, 0, 0, 0.25);
}
.pcr-app {
  position: fixed;
  display: flex;
  flex-direction: column;
  z-index: 10000;
  background: var(--lumo-base-color);
  opacity: 0;
  visibility: hidden;
  transition: opacity 0.3s, visibility 0s 0.3s;
  font-family: var(--lumo-font-family);
  font-size: var(--lumo-font-size-m)
  font-weight: 400;
  line-height: var(--lumo-line-height-m);
  letter-spacing: 0;
  text-transform: none;
  -webkit-text-size-adjust: 100%;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  outline: none;
  box-shadow: 0 0 0 1px var(--lumo-shade-5pct), var(--lumo-box-shadow-xl);
  left: 0;
  top: 0;
  border-radius: var(--lumo-border-radius-m);
  -webkit-tap-highlight-color: transparent;
}
.pcr-app.visible {
  transition: opacity 0.3s;
  visibility: visible;
  opacity: 1;
}
.pcr-app .pcr-swatches {
  display: flex;
  flex-wrap: wrap;
  margin-top: 0.75em;
}
.pcr-app .pcr-swatches.pcr-last {
  margin: 0;
}
@supports (display: grid) {
  .pcr-app .pcr-swatches {
    display: grid;
    align-items: center;
    grid-template-columns: repeat(auto-fit, 1.75em);
  }
}
.pcr-app .pcr-swatches > button {
  font-size: var(--lumo-font-size-m);
  position: relative;
  width: calc(1.75em - 5px);
  height: calc(1.75em - 5px);
  border-radius: 0.15em;
  cursor: pointer;
  margin: 2.5px;
  flex-shrink: 0;
  justify-self: center;
  transition: all 0.15s;
  overflow: hidden;
  background: transparent;
  z-index: 1;
}
.pcr-app .pcr-swatches > button::before {
  position: absolute;
  content: "";
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background: url('data:image/svg+xml;utf8, <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 2 2"><path fill="white" d="M1,0H2V1H1V0ZM0,1H1V2H0V1Z"/><path fill="gray" d="M0,0H1V1H0V0ZM1,1H2V2H1V1Z"/></svg>');
  background-size: 6px;
  border-radius: 0.15em;
  z-index: -1;
}
.pcr-app .pcr-swatches > button::after {
  content: "";
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background: var(--pcr-color);
  border: 1px solid rgba(0, 0, 0, 0.05);
  border-radius: 0.15em;
  box-sizing: border-box;
}
.pcr-app .pcr-swatches > button:hover {
  filter: brightness(1.05);
}
.pcr-app .pcr-swatches > button:not(.pcr-active) {
  box-shadow: none;
}
.pcr-app .pcr-interaction {
  display: flex;
  flex-wrap: wrap;
  align-items: center;
  margin: 0 -0.2em 0 -0.2em;
}
.pcr-app .pcr-interaction > * {
  margin: 0 0.2em;
}
.pcr-app .pcr-interaction input {
  letter-spacing: 0.07em;
  font-size: var(--lumo-font-size-xxs);
  text-align: center;
  cursor: pointer;
  color: var(--lumo-body-text-color)
  background-color: var(--lumo-contrast-10pct);
  border-radius: 0.15em;
  transition: all 0.15s;
  padding: 0.45em 0.5em;
  margin-top: 0.75em;
}
.pcr-app .pcr-interaction input:hover {
  filter: brightness(0.975);
}
.pcr-app .pcr-interaction input:focus {
    box-shadow: var(--lumo-primary-contrast-color) 0px 0px 0px 1px, var(--lumo-primary-color) 0px 0px 0px 3px
}
.pcr-app .pcr-interaction .pcr-result {
  color: #75797e;
  text-align: left;
  flex: 1 1 8em;
  min-width: 8em;
  transition: all 0.2s;
  border-radius: 0.15em;
  background: #f1f3f4;
  cursor: text;
}
.pcr-app .pcr-interaction .pcr-result::-moz-selection {
  background: var(--lumo-primary-text-color);
  color: var(--lumo-primary-contrast-color);
}
.pcr-app .pcr-interaction .pcr-result::selection {
  background: var(--lumo-primary-text-color);
  color: var(--lumo-primary-contrast-color);
}
.pcr-app .pcr-interaction .pcr-type.active {
  color: var(--lumo-primary-contrast-color);
  background:  var(--lumo-primary-color);
}
.pcr-app .pcr-interaction .pcr-save,
.pcr-app .pcr-interaction .pcr-cancel,
.pcr-app .pcr-interaction .pcr-clear {
  color: var(--lumo-primary-text-color);
  width: auto;
}
.pcr-app .pcr-interaction .pcr-save,
.pcr-app .pcr-interaction .pcr-cancel,
.pcr-app .pcr-interaction .pcr-clear {
  color: var(--lumo-primary-text-color);
}
.pcr-app .pcr-interaction .pcr-save:hover,
.pcr-app .pcr-interaction .pcr-cancel:hover,
.pcr-app .pcr-interaction .pcr-clear:hover {
  filter: brightness(0.925);
}
.pcr-app .pcr-interaction .pcr-save {
  color: var(--lumo-primary-contrast-color);
  background: var(--lumo-primary-color);
}
.pcr-app .pcr-interaction .pcr-clear,
.pcr-app .pcr-interaction .pcr-cancel {
  background: var(--lumo-contrast-5pct)
;
}
.pcr-app .pcr-interaction .pcr-clear:focus,
.pcr-app .pcr-interaction .pcr-cancel:focus {
  box-shadow: 0 0 0 1px var(--lumo-contrast-10pct),
    0 0 0 3px var(--lumo-contrast-5pct);
}
.pcr-app .pcr-selection .pcr-picker {
  position: absolute;
  height: 18px;
  width: 18px;
  border: 2px solid #fff;
  border-radius: 100%;
  -webkit-user-select: none;
  -moz-user-select: none;
  -ms-user-select: none;
  user-select: none;
}
.pcr-app .pcr-selection .pcr-color-palette,
.pcr-app .pcr-selection .pcr-color-chooser,
.pcr-app .pcr-selection .pcr-color-opacity {
  position: relative;
  -webkit-user-select: none;
  -moz-user-select: none;
  -ms-user-select: none;
  user-select: none;
  display: flex;
  flex-direction: column;
  cursor: grab;
  cursor: -webkit-grab;
}
.pcr-app .pcr-selection .pcr-color-palette:active,
.pcr-app .pcr-selection .pcr-color-chooser:active,
.pcr-app .pcr-selection .pcr-color-opacity:active {
  cursor: grabbing;
  cursor: -webkit-grabbing;
}
.pcr-app[data-theme="classic"] {
  width: 28.5em;
  max-width: 95vw;
  padding: 0.8em;
}
.pcr-app[data-theme="classic"] .pcr-selection {
  display: flex;
  justify-content: space-between;
  flex-grow: 1;
}
.pcr-app[data-theme="classic"] .pcr-selection .pcr-color-preview {
  position: relative;
  z-index: 1;
  width: 2em;
  display: flex;
  flex-direction: column;
  justify-content: space-between;
  margin-right: 0.75em;
}
.pcr-app[data-theme="classic"] .pcr-selection .pcr-color-preview::before {
  position: absolute;
  content: "";
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background: url('data:image/svg+xml;utf8, <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 2 2"><path fill="white" d="M1,0H2V1H1V0ZM0,1H1V2H0V1Z"/><path fill="gray" d="M0,0H1V1H0V0ZM1,1H2V2H1V1Z"/></svg>');
  background-size: 0.5em;
  border-radius: 0.15em;
  z-index: -1;
}
.pcr-app[data-theme="classic"]
  .pcr-selection
  .pcr-color-preview
  .pcr-last-color {
  cursor: pointer;
  border-radius: 0.15em 0.15em 0 0;
  z-index: 2;
}
.pcr-app[data-theme="classic"]
  .pcr-selection
  .pcr-color-preview
  .pcr-current-color {
  border-radius: 0 0 0.15em 0.15em;
}
.pcr-app[data-theme="classic"]
  .pcr-selection
  .pcr-color-preview
  .pcr-last-color,
.pcr-app[data-theme="classic"]
  .pcr-selection
  .pcr-color-preview
  .pcr-current-color {
  background: var(--pcr-color);
  width: 100%;
  height: 50%;
}
.pcr-app[data-theme="classic"] .pcr-selection .pcr-color-palette {
  width: 100%;
  height: 8em;
  z-index: 1;
}
.pcr-app[data-theme="classic"] .pcr-selection .pcr-color-palette .pcr-palette {
  flex-grow: 1;
  border-radius: 0.15em;
}
.pcr-app[data-theme="classic"]
  .pcr-selection
  .pcr-color-palette
  .pcr-palette::before {
  position: absolute;
  content: "";
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background: url('data:image/svg+xml;utf8, <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 2 2"><path fill="white" d="M1,0H2V1H1V0ZM0,1H1V2H0V1Z"/><path fill="gray" d="M0,0H1V1H0V0ZM1,1H2V2H1V1Z"/></svg>');
  background-size: 0.5em;
  border-radius: 0.15em;
  z-index: -1;
}
.pcr-app[data-theme="classic"] .pcr-selection .pcr-color-chooser,
.pcr-app[data-theme="classic"] .pcr-selection .pcr-color-opacity {
  margin-left: 0.75em;
}
.pcr-app[data-theme="classic"] .pcr-selection .pcr-color-chooser .pcr-picker,
.pcr-app[data-theme="classic"] .pcr-selection .pcr-color-opacity .pcr-picker {
  left: 50%;
  transform: translateX(-50%);
}
.pcr-app[data-theme="classic"] .pcr-selection .pcr-color-chooser .pcr-slider,
.pcr-app[data-theme="classic"] .pcr-selection .pcr-color-opacity .pcr-slider {
  width: 8px;
  flex-grow: 1;
  border-radius: 50em;
}
.pcr-app[data-theme="classic"] .pcr-selection .pcr-color-chooser .pcr-slider {
  background: linear-gradient(
    to bottom,
    red,
    #ff0,
    lime,
    cyan,
    blue,
    #f0f,
    red
  );
}
.pcr-app[data-theme="classic"] .pcr-selection .pcr-color-opacity .pcr-slider {
  background: linear-gradient(to bottom, transparent, black),
    url('data:image/svg+xml;utf8, <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 2 2"><path fill="white" d="M1,0H2V1H1V0ZM0,1H1V2H0V1Z"/><path fill="gray" d="M0,0H1V1H0V0ZM1,1H2V2H1V1Z"/></svg>');
  background-size: 100%, 50%;
}
.pcr-app[data-theme="monolith"] {
  width: 14.25em;
  max-width: 95vw;
  padding: 0.8em;
}
.pcr-app[data-theme="monolith"] .pcr-selection {
  display: flex;
  flex-direction: column;
  justify-content: space-between;
  flex-grow: 1;
}
.pcr-app[data-theme="monolith"] .pcr-selection .pcr-color-preview {
  position: relative;
  z-index: 1;
  width: 100%;
  height: 1em;
  display: flex;
  flex-direction: row;
  justify-content: space-between;
  margin-bottom: 0.5em;
}
.pcr-app[data-theme="monolith"] .pcr-selection .pcr-color-preview::before {
  position: absolute;
  content: "";
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background: url('data:image/svg+xml;utf8, <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 2 2"><path fill="white" d="M1,0H2V1H1V0ZM0,1H1V2H0V1Z"/><path fill="gray" d="M0,0H1V1H0V0ZM1,1H2V2H1V1Z"/></svg>');
  background-size: 0.5em;
  border-radius: 0.15em;
  z-index: -1;
}
.pcr-app[data-theme="monolith"]
  .pcr-selection
  .pcr-color-preview
  .pcr-last-color {
  cursor: pointer;
  transition: background-color 0.3s, box-shadow 0.3s;
  border-radius: 0.15em 0 0 0.15em;
  z-index: 2;
}
.pcr-app[data-theme="monolith"]
  .pcr-selection
  .pcr-color-preview
  .pcr-current-color {
  border-radius: 0 0.15em 0.15em 0;
}
.pcr-app[data-theme="monolith"]
  .pcr-selection
  .pcr-color-preview
  .pcr-last-color,
.pcr-app[data-theme="monolith"]
  .pcr-selection
  .pcr-color-preview
  .pcr-current-color {
  background: var(--pcr-color);
  width: 50%;
  height: 100%;
}
.pcr-app[data-theme="monolith"] .pcr-selection .pcr-color-palette {
  width: 100%;
  height: 8em;
  z-index: 1;
}
.pcr-app[data-theme="monolith"] .pcr-selection .pcr-color-palette .pcr-palette {
  border-radius: 0.15em;
  width: 100%;
  height: 100%;
}
.pcr-app[data-theme="monolith"]
  .pcr-selection
  .pcr-color-palette
  .pcr-palette::before {
  position: absolute;
  content: "";
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background: url('data:image/svg+xml;utf8, <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 2 2"><path fill="white" d="M1,0H2V1H1V0ZM0,1H1V2H0V1Z"/><path fill="gray" d="M0,0H1V1H0V0ZM1,1H2V2H1V1Z"/></svg>');
  background-size: 0.5em;
  border-radius: 0.15em;
  z-index: -1;
}
.pcr-app[data-theme="monolith"] .pcr-selection .pcr-color-chooser,
.pcr-app[data-theme="monolith"] .pcr-selection .pcr-color-opacity {
  height: 0.5em;
  margin-top: 0.75em;
}
.pcr-app[data-theme="monolith"] .pcr-selection .pcr-color-chooser .pcr-picker,
.pcr-app[data-theme="monolith"] .pcr-selection .pcr-color-opacity .pcr-picker {
  top: 50%;
  transform: translateY(-50%);
}
.pcr-app[data-theme="monolith"] .pcr-selection .pcr-color-chooser .pcr-slider,
.pcr-app[data-theme="monolith"] .pcr-selection .pcr-color-opacity .pcr-slider {
  flex-grow: 1;
  border-radius: 50em;
}
.pcr-app[data-theme="monolith"] .pcr-selection .pcr-color-chooser .pcr-slider {
  background: linear-gradient(to right, red, #ff0, lime, cyan, blue, #f0f, red);
}
.pcr-app[data-theme="monolith"] .pcr-selection .pcr-color-opacity .pcr-slider {
  background: linear-gradient(to right, transparent, black),
    url('data:image/svg+xml;utf8, <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 2 2"><path fill="white" d="M1,0H2V1H1V0ZM0,1H1V2H0V1Z"/><path fill="gray" d="M0,0H1V1H0V0ZM1,1H2V2H1V1Z"/></svg>');
  background-size: 100%, 0.25em;
}
.pcr-app[data-theme="nano"] {
  width: 14.25em;
  max-width: 95vw;
}
.pcr-app[data-theme="nano"] .pcr-swatches {
  margin-top: 0.6em;
  padding: 0 0.6em;
}
.pcr-app[data-theme="nano"] .pcr-interaction {
  padding: 0 0.6em 0.6em 0.6em;
}
.pcr-app[data-theme="nano"] .pcr-selection {
  display: grid;
  grid-gap: 0.6em;
  grid-template-columns: 1fr 4fr;
  grid-template-rows: 5fr auto auto;
  align-items: center;
  height: 10.5em;
  width: 100%;
  align-self: flex-start;
}
.pcr-app[data-theme="nano"] .pcr-selection .pcr-color-preview {
  grid-area: 2 / 1 / 4 / 1;
  height: 100%;
  width: 100%;
  display: flex;
  flex-direction: row;
  justify-content: center;
  margin-left: 0.6em;
}
.pcr-app[data-theme="nano"] .pcr-selection .pcr-color-preview .pcr-last-color {
  display: none;
}
.pcr-app[data-theme="nano"]
  .pcr-selection
  .pcr-color-preview
  .pcr-current-color {
  position: relative;
  background: var(--pcr-color);
  width: 2em;
  height: 2em;
  border-radius: 50em;
  overflow: hidden;
}
.pcr-app[data-theme="nano"]
  .pcr-selection
  .pcr-color-preview
  .pcr-current-color::before {
  position: absolute;
  content: "";
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background: url('data:image/svg+xml;utf8, <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 2 2"><path fill="white" d="M1,0H2V1H1V0ZM0,1H1V2H0V1Z"/><path fill="gray" d="M0,0H1V1H0V0ZM1,1H2V2H1V1Z"/></svg>');
  background-size: 0.5em;
  border-radius: 0.15em;
  z-index: -1;
}
.pcr-app[data-theme="nano"] .pcr-selection .pcr-color-palette {
  grid-area: 1 / 1 / 2 / 3;
  width: 100%;
  height: 100%;
  z-index: 1;
}
.pcr-app[data-theme="nano"] .pcr-selection .pcr-color-palette .pcr-palette {
  border-radius: 0.15em;
  width: 100%;
  height: 100%;
}
.pcr-app[data-theme="nano"]
  .pcr-selection
  .pcr-color-palette
  .pcr-palette::before {
  position: absolute;
  content: "";
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background: url('data:image/svg+xml;utf8, <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 2 2"><path fill="white" d="M1,0H2V1H1V0ZM0,1H1V2H0V1Z"/><path fill="gray" d="M0,0H1V1H0V0ZM1,1H2V2H1V1Z"/></svg>');
  background-size: 0.5em;
  border-radius: 0.15em;
  z-index: -1;
}
.pcr-app[data-theme="nano"] .pcr-selection .pcr-color-chooser {
  grid-area: 2 / 2 / 2 / 2;
}
.pcr-app[data-theme="nano"] .pcr-selection .pcr-color-opacity {
  grid-area: 3 / 2 / 3 / 2;
}
.pcr-app[data-theme="nano"] .pcr-selection .pcr-color-chooser,
.pcr-app[data-theme="nano"] .pcr-selection .pcr-color-opacity {
  height: 0.5em;
  margin: 0 0.6em;
}
.pcr-app[data-theme="nano"] .pcr-selection .pcr-color-chooser .pcr-picker,
.pcr-app[data-theme="nano"] .pcr-selection .pcr-color-opacity .pcr-picker {
  top: 50%;
  transform: translateY(-50%);
}
.pcr-app[data-theme="nano"] .pcr-selection .pcr-color-chooser .pcr-slider,
.pcr-app[data-theme="nano"] .pcr-selection .pcr-color-opacity .pcr-slider {
  flex-grow: 1;
  border-radius: 50em;
}
.pcr-app[data-theme="nano"] .pcr-selection .pcr-color-chooser .pcr-slider {
  background: linear-gradient(to right, red, #ff0, lime, cyan, blue, #f0f, red);
}
.pcr-app[data-theme="nano"] .pcr-selection .pcr-color-opacity .pcr-slider {
  background: linear-gradient(to right, transparent, black),
    url('data:image/svg+xml;utf8, <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 2 2"><path fill="white" d="M1,0H2V1H1V0ZM0,1H1V2H0V1Z"/><path fill="gray" d="M0,0H1V1H0V0ZM1,1H2V2H1V1Z"/></svg>');
  background-size: 100%, 0.25em;
}`