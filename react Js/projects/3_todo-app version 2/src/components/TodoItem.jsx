import styles from "./TodoItem.module.css";
import { AiFillDelete } from "react-icons/ai";
function TodoItem({ todoName, todoDate, onClickDelete }) {
  return (
    <div className="container">
      <div className="row kg-row">
        <div className="col-6">{todoName}</div>
        <div className="col-3">{todoDate}</div>
        <div className="col-3">
          <button
            onClick={() => onClickDelete(todoName)}
            className={"btn btn-danger " + styles.deleteButton}
          >
            <AiFillDelete />
          </button>
        </div>
      </div>
    </div>
  );
}
export default TodoItem;
