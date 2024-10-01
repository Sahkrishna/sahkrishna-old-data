import styles from "./Input.module.css";
const Input = ({ handOnKeyValue }) => {
  // const inputClick = (event) => {
  //   console.log(event.target.value);
  // };
  return (
    <input
      className={styles.input}
      placeholder="Enter email Id:"
      type="email"
      onKeyDown={handOnKeyValue}
    />
  );
};
export default Input;
