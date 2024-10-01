import styles from "./TodoInput.module.css";
const TodoInput = () => {
  return (
    <>
      <div className="container">
        <div className="row">
          <div className="col-md-5">
            <input
              className={styles.todo}
              type="text"
              placeholder="Enter here"
            />
          </div>
          <div className="col-md-5">
            <input className={styles.todo} type="date" />
          </div>
          <div className="col-md-2">
            <button className="btn1">Add</button>
          </div>
        </div>
      </div>
    </>
  );
};
export default TodoInput;
