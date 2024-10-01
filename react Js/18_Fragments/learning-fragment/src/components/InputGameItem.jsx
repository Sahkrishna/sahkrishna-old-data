import styles from "./InputGameItem.module.css";
const InputGameItem = ({ handOnKey }) => {
  return (
    <>
      <h3 className={styles.heading}>Game</h3>
      <input
        type="text"
        placeholder="Enter game"
        className={styles.input}
        onKeyDown={handOnKey}
      />
    </>
  );
};
export default InputGameItem;
