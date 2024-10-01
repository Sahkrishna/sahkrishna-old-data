import { useRef, useState } from "react";
import styles from "./TodoInput.module.css";
import { IoIosAddCircle } from "react-icons/io";
function TodoInput({ onNewItem }) {
  // const [todoName, setTodoName] = useState("");
  // const [todoDate, setTodoDate] = useState("");

  const todoNameElement = useRef();
  const todoDueDate = useRef();

  const handOnButtonClicked = (event) => {
    event.preventDefault();
    const todoName = todoNameElement.current.value;
    const todoDate = todoDueDate.current.value;

    todoNameElement.current.value = "";
    todoDueDate.current.value = "";
    onNewItem(todoName, todoDate);
  };
  return (
    <div className="container">
      <form onSubmit={handOnButtonClicked} className="row kg-row input ">
        <div className="col-6 ">
          <input
            ref={todoNameElement}
            type="text"
            placeholder="Enter todo here"
          />
        </div>
        <div className="col-3">
          <input ref={todoDueDate} type="date" />
        </div>
        <div className="col-3">
          <button className={"btn kButton btn-primary " + styles.addBtn}>
            <IoIosAddCircle />
          </button>
        </div>
      </form>
    </div>
  );
}
export default TodoInput;
