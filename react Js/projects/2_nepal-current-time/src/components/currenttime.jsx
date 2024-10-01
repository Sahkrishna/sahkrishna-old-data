let CurrentTime = () => {
  let time = new Date();

  let times = time.toLocaleTimeString();
  return (
    <p className="lead">
      This is the current Time:{times} - {time.toLocaleDateString()}
    </p>
  );
};
export default CurrentTime;
