const ErrorMessage = ({ listOfItem }) => {
  return (
    <>
      <div className="text-center">
        {listOfItem.length === 0 ? (
          <h2>There is no any list of food or game</h2>
        ) : null}
      </div>
    </>
  );
};
export default ErrorMessage;
