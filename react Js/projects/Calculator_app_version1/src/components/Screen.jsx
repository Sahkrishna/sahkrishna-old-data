import styles from "./Screen.module.css";
const Screen = ({ calValue }) => {
  return <input type="text" value={calValue} className={styles.screen} />;
};
export default Screen;
