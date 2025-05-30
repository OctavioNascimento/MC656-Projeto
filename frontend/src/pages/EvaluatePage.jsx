import { RiArrowLeftLine } from "react-icons/ri";
import { useNavigate, Link, useLocation } from "react-router-dom";
import { getTravelById } from "../mocks/mocks";
import Header, { headerIconsSize } from "../components/Header";

function EvaluatePage() {
  const navigate = useNavigate()
  const travelId = useLocation().pathname.split('/')[2]
  const travel = getTravelById(travelId)

//   Remover log
  console.log({travel});
  
  return (
    <div className="h-full flex flex-col items-center relative">
      <Header 
        leftIcon={
            <Link to={'..'} onClick={(e) => {
                e.preventDefault();
                navigate(-1);
                }}>
            <RiArrowLeftLine color="black" size={headerIconsSize} />
            </Link>
        }
      />

    </div>
  );
}

export default EvaluatePage;
