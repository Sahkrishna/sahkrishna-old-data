import "./App.css";
import TodoInput from "./components/TodoInput";
import TodoItem from "./components/TodoItem";
function App() {
  return (
    <>
      <h2 className="heading">Programming Language</h2>
      <TodoInput></TodoInput>
      <TodoItem></TodoItem>
    </>
  );
}

export default App;
