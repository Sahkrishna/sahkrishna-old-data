function TodoInput({ addTodo }) {
  return (
    <div className="container">
      <div className="row kg-row todo-input">
        <div className="col-6">
          <input type="text" placeholder="Enter todo here" />
        </div>
        <div className="col-3">
          <input type="date" />
        </div>
        <div className="col-3">
          <button className="btn kButton btn-primary">{addTodo}</button>
        </div>
      </div>
    </div>
  );
}
export default TodoInput;
