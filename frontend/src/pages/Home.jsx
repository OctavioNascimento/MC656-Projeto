import * as React from 'react';
import { RiMenu2Line } from "react-icons/ri";
import { FaCheck, FaCog, FaExclamationCircle, FaQuestion, FaSignOutAlt, FaUser, FaUserCircle } from "react-icons/fa";
import { CiClock2, CiHeart, CiSearch } from "react-icons/ci";
import FilterPill from "../components/FilterPill";
import { Link } from "react-router-dom";
import { userInfo } from "../mocks/mocks";
import Header, { headerIconsSize } from "../components/Header";
import Drawer from '@mui/material/Drawer';

function Home() {
  const [menuState, setMenuState] = React.useState({
    left: false,
    right: false,
  });

  const toggleDrawer = (anchor, open) => (event) => {
    if (event.type === 'keydown' && (event.key === 'Tab' || event.key === 'Shift')) {
      return;
    }

    setMenuState({ ...menuState, [anchor]: open });
  };

  function getLeftMenu(){
    return (
      <>
        <div className='h-full w-[calc(100vw*0.5)] max-w-[384px] p-4'>
          <div className="flex flex-col gap-3 text-gray-700 mt-2">
            <div className="flex items-center gap-3 text-left hover:text-blue-600">
              <FaQuestion />
              <span>FAQ</span>
            </div>
            <div className="flex items-center gap-3 text-left hover:text-blue-600">
              <FaExclamationCircle />
              <span>Sobre o App</span>
            </div>
          </div>

          <hr className="border-gray-200 my-4" />
        </div>
      </>
    )
  }

  function getRightMenu(){
    return (
      <>
        <div className='h-full w-[calc(100vw*0.5)] max-w-[384px] p-4'>
          <div className="flex items-center gap-4 mb-4">
            <FaUserCircle className="text-4xl text-gray-600" />
            <span className="text-lg font-medium text-gray-800">{userInfo.name.split(' ')[0]}</span>
          </div>

          <hr className="border-gray-200 my-2" />

          <div className="flex flex-col gap-3 text-gray-700 mt-2">
            <Link to={'/user/' + userInfo.id} className="flex items-center gap-3 text-left hover:text-blue-600">
              <FaUser />
              <span>Perfil</span>
            </Link>
            {/*   TODO: FAZER LINK PARA PÁGINA DE CONFIG   */}
            <div className="flex items-center gap-3 text-left hover:text-blue-600">
              <FaCog />
              <span>Configurações</span>
            </div>
          </div>

          <hr className="border-gray-200 my-4" />

          <Link to={'/'} className="flex items-center gap-3 text-red-500 hover:text-red-600 mt-auto">
            <FaSignOutAlt />
            <span>Sair</span>
          </Link>
        </div>
      </>
    )
  }

  return (
    <div className="h-full items-center relative flex flex-col">
      <Header
        leftIcon={<RiMenu2Line color="black" size={headerIconsSize} onClick={toggleDrawer('left', true)} />}
        rightIcon={<FaUserCircle color="black" size={headerIconsSize} onClick={toggleDrawer('right', true)} />}
      />

      <section className="overflow-hidden">
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


      <Drawer
        className='w-3/4'
        anchor='left'
        open={menuState['left']}
        onClose={toggleDrawer('left', false)}
      >
        {getLeftMenu()}
      </Drawer>

      <Drawer
        anchor='right'
        open={menuState['right']}
        onClose={toggleDrawer('right', false)}
      >
        {getRightMenu()}
      </Drawer>
    </div>
  );
}

export default Home;
