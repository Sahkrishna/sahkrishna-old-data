import styles from "./TodoContainer.module.css";
const TodoContainer = ({ children }) => {
  return <div className={styles.todoContainer}>{children}</div>;
};
export default TodoContainer;
