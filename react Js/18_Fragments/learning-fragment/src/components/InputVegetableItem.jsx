import styles from "./InputVegetableItem.module.css";
const InputVegetableItem = ({ handOnKey }) => {
  return (
    <>
      <h3 className={styles.heading}>Vegetable</h3>
      <input
        type="text"
        placeholder="Enter  vegetable "
        className={styles.input}
        onKeyDown={handOnKey}
      />
    </>
  );
};
export default InputVegetableItem;
