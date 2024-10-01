function TodoItem() {
  return (
    <div className="container">
      <div className="row kg-row">
        <div className="col-6">Buy Milk</div>
        <div className="col-3">4/10/2024</div>
        <div className="col-3">
          <button className="btn kButton btn-danger">Delete</button>
        </div>
      </div>
    </div>
  );
}
export default TodoItem;
