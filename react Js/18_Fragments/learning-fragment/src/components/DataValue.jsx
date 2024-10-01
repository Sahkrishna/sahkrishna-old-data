const DataValue = ({ listOfData }) => {
  return (
    <>
      {listOfData.map((item) => (
        <p key={item}>{item}</p>
      ))}
    </>
  );
};
export default DataValue;
