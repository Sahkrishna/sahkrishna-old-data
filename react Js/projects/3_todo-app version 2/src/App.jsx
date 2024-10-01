import { useState } from "react";
import "./App.css";
import TodoContainer from "./components/TodoContainer";
import TodoHeader from "./components/TodoHeader";
import TodoInput from "./components/TodoInput";
import TodoItem from "./components/TodoItem";
import TodoItems from "./components/TodoItems";
import WelcomeMessage from "./components/WelcomeMessage";

function App() {
  let [todoItem, setTodoItem] = useState([]);

  const handOnTodo = (itemName, itemDate) => {
    const newTodoItem = [
      ...todoItem,
      { todoName: itemName, todoDate: itemDate },
    ];
    setTodoItem(newTodoItem);
  };

  const handOnDelete = (todoName) => {
    const newTodoItem = todoItem.filter((item) => item.todoName !== todoName);
    setTodoItem(newTodoItem);
    console.log(`${todoName} is deleted`);
  };
  return (
    <TodoContainer>
      <TodoHeader></TodoHeader>
      <TodoInput onNewItem={handOnTodo}></TodoInput>
      {todoItem.length === 0 && <WelcomeMessage></WelcomeMessage>}
      <TodoItems todoItems={todoItem} onClickDelete={handOnDelete}></TodoItems>
    </TodoContainer>
  );
}

export default App;
