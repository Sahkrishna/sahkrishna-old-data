import TodoItem from "./TodoItem";
const TodoItems = ({ todoItems, onClickDelete }) => {
  // console.log(todoItems);
  return (
    <>
      <div className="item-container">
        {todoItems.map((item) => (
          <TodoItem
            key={item.todoName}
            todoName={item.todoName}
            todoDate={item.todoDate}
            onClickDelete={onClickDelete}
          ></TodoItem>
        ))}
        {/* <TodoItem todoName={"Buy Milk"} todoDate="4/10/2024"></TodoItem>
        <TodoItem todoName={"Go to college"} todoDate="4/10/2024"></TodoItem> */}
      </div>
    </>
  );
};
export default TodoItems;
