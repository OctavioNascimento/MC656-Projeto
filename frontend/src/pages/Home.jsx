import { RiMenu2Line } from "react-icons/ri";
import { FaCheck, FaUserCircle } from "react-icons/fa";
import { CiClock2, CiHeart, CiSearch } from "react-icons/ci";
import FilterPill from "../components/FilterPill";
import logo from "../assets/logo.png";

function Home() {
  return (
    <div className="h-full items-center relative flex flex-col">
      <header className="w-full flex gap-2 items-center justify-around relative mt-3">
        <RiMenu2Line color="black" size="20" />
        <img src={logo} alt="Logo" />
        <FaUserCircle color="black" size="25" />
      </header>

      <section className="overflow-hidden w-3/4 ">
        <div className="search bg-blue-50 mt-7 rounded-md items-center flex p-2 gap-4">
          <CiSearch size="25" color="blue" className="hover:cursor-pointer" />
          <input
            type="text"
            placeholder="Procura"
            className="placeholder-blue-500 placeholder:font-medium outline-0 text-black"
          />
        </div>

        <div className="tags text-black overflow-hidden">
          <ul className="flex mt-2 gap-3 w-full overflow-x-scroll whitespace-nowrap text-[12px]">

            <FilterPill text="Favoritos" icon={<CiHeart color="black" />} />
            <FilterPill text="Histórico" icon={<CiClock2 color="black" />} />
            <FilterPill text="Pendências" icon={<FaCheck color="black" />} />
            <FilterPill text="Favoritos" icon={<CiHeart color="black" />} />
            
          </ul>
        </div>
      </section>
    </div>
  );
}

export default Home;
