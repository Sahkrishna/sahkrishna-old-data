import styles from "./ButtonContainer.module.css";
const ButtonContainer = ({ buttonClicked }) => {
  const buttons = [
    "C",
    "1",
    "2",
    "+",
    "3",
    "4",
    "-",
    "5",
    "6",
    "*",
    "7",
    "8",
    "/",
    "=",
    "9",
    "0",
    ".",
  ];
  return (
    <div className={styles.buttonsContainer}>
      {buttons.map((buttonValue) => (
        <button
          key={buttonValue}
          onClick={() => buttonClicked(buttonValue)}
          className={styles.button}
          aria-readonly
        >
          {buttonValue}
        </button>
      ))}
    </div>
  );
};
export default ButtonContainer;
