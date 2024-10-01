import styles from "./PasswordInput.module.css";
const PasswordInput = ({ handOnKeyDown }) => {
  return (
    <>
      <h3 className={styles.heading}>Food</h3>
      <input
        type="text"
        placeholder="Enter food"
        className={styles.input}
        onKeyDown={handOnKeyDown}
      ></input>
    </>
  );
};
export default PasswordInput;
