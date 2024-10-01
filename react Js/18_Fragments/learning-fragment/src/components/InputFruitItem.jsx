import styles from "./InputFruitItem.module.css";

const InputFruitItem = ({ handOnkey }) => {
  return (
    <>
      <h3 className={styles.heading}>Fruit</h3>
      <input
        type="text"
        placeholder="Enter fruit"
        className={styles.input}
        onKeyDown={handOnkey}
      />
    </>
  );
};
export default InputFruitItem;
