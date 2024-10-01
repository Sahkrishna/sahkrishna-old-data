const TodoItem = () => {
  return (
    <>
      <div className="container">
        <div className="row">
          <div className="col-md-5">
            <p>C programming</p>
          </div>
          <div className="col-md-5">
            <p>1992/23/4</p>
          </div>
          <div className="col-md-2">
            <button>delete</button>
          </div>
        </div>
      </div>
    </>
  );
};
export default TodoItem;
