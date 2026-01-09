/* Root background */
.root {
    -fx-background-color: linear-gradient(to bottom, #0f2027, #203a43, #2c5364);
    -fx-padding: 20;
}

/* Title text */
.title {
    -fx-font-size: 22px;
    -fx-font-weight: bold;
    -fx-text-fill: #ffffff;
}

/* Temperature text */
.temp {
    -fx-font-size: 40px;
    -fx-font-weight: bold;
    -fx-text-fill: #4fc3f7;
}

/* Normal labels */
.label {
    -fx-font-size: 14px;
    -fx-text-fill: #e0e0e0;
}

/* Weather plane shape */
.plane {
    -fx-fill: #ffffff;
}

/* TextField styling */
.text-field {
    -fx-background-radius: 8;
    -fx-border-radius: 8;
    -fx-background-color: #ffffff;
    -fx-pref-width: 200;
}

/* Button styling */
.button {
    -fx-background-color: #4fc3f7;
    -fx-text-fill: #000000;
    -fx-font-weight: bold;
    -fx-background-radius: 8;
    -fx-padding: 8 20 8 20;
}

.button:hover {
    -fx-background-color: #81d4fa;
}

/* Disabled button */
.button:disabled {
    -fx-opacity: 0.5;
}

/* Forecast labels */
.hbox .label {
    -fx-text-fill: #ffffff;
    -fx-font-size: 13px;
}