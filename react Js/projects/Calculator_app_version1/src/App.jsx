import { useState } from "react";
import "./App.css";
import styles from "./App.module.css";
import ButtonContainer from "./components/ButtonContainer";
import Screen from "./components/Screen";

function App() {
  const [calValue, setCalValue] = useState([""]);

  const onButtonClickValue = (buttonValue) => {
    if (buttonValue === "C") {
      setCalValue("");
    } else if (buttonValue === "=") {
      let result = eval(calValue);
      setCalValue(result);
    } else {
      const newDisplayValue = calValue + buttonValue;
      setCalValue(newDisplayValue);
    }
  };

  return (
    <>
      <div className={styles.calculator}>
        <Screen calValue={calValue}></Screen>
        <ButtonContainer buttonClicked={onButtonClickValue}></ButtonContainer>
      </div>
    </>
  );
}

export default App;
