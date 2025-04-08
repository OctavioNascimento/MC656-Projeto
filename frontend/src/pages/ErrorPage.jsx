import { Link } from "react-router-dom";
import Bike from "../assets/bike-cycle.gif";
import { FaLongArrowAltRight } from "react-icons/fa";

function ErrorPage() {
  return (
    <div className="h-full relative justify-center flex flex-col items-center">
      <img src={Bike} alt="Gif de bike" className="w-100 rounded-t-4xl" />
      <div className=" w-full bg-white text-gray-900 p-3">
        <h1 className="font-bold text-[25px] mb-5">Erro ao Carregar Página</h1>
        <Link to="/home">
          <small className="font-bold text-blue-500 flex items-center gap-2 relative justify-center border-1 rounded-sm hover:bg-blue-50">
            Início
            <FaLongArrowAltRight />
          </small>
        </Link>
      </div>
    </div>
  );
}

export default ErrorPage;
