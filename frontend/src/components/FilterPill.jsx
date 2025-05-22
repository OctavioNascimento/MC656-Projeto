function FilterPill(props) {
  return (
    <>
      <li className="flex items-center gap-1 border border-gray-300 p-1 rounded-md ">
        {props.icon} 
        {props.text}
      </li>
    </>
  );
}

export default FilterPill;
