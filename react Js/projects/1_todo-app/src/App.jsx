import "./App.css";
import TodoHeader from "./components/TodoHeader";
import TodoInput from "./components/TodoInput";
import TodoItem from "./components/TodoItem";
import TodoItem2 from "./components/TodoItem2";

function App() {
  return (
    <center className="todo-container">
      <TodoHeader></TodoHeader>
      <TodoInput addTodo={"Add"}></TodoInput>

      <div className="item-container">
        <TodoItem></TodoItem>
        <TodoItem2></TodoItem2>
      </div>
    </center>
  );
}

export default App;
