import { RiMenu2Line } from "react-icons/ri";
import { FaCheck, FaUserCircle } from "react-icons/fa";
import { CiClock2, CiHeart, CiSearch } from "react-icons/ci";
import { MapContainer, TileLayer, Marker, Popup } from "react-leaflet";

import logo from "../assets/logo.png";

const position = [-23.55052, -46.633308]; // São Paulo

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
            <li className="flex items-center gap-1 border border-gray-300 p-1 rounded-md ">
              <CiHeart color="black" />
              Favoritos
            </li>
            <li className="flex items-center gap-1 border border-gray-300 p-1 rounded-md ">
              <CiClock2 color="black" />
              Histórico
            </li>
            <li className="flex items-center gap-1 border border-gray-300 p-1 rounded-md ">
              <FaCheck color="black" />
              Pendências
            </li>
            <li className="flex items-center gap-1 border border-gray-300 p-1 rounded-md ">
              <CiHeart color="black" />
              Favoritos
            </li>
          </ul>
        </div>
      </section>
    </div>
  );
}

export default Home;
