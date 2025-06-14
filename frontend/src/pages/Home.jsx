import * as React from 'react';
import { RiMenu2Line } from "react-icons/ri";
import { FaCheck, FaCog, FaExclamationCircle, FaIdCard, FaOrcid, FaQrcode, FaQuestion, FaSignOutAlt, FaUser, FaUserCircle } from "react-icons/fa";
import FilterPill from "../components/FilterPill";
import { Link } from "react-router-dom";
import { userInfo } from "../mocks/mocks";
import Header, { headerIconsSize } from "../components/Header";
import Drawer from '@mui/material/Drawer';
import Mapa from '../components/Map';
import ContainedButton from '../components/Button';

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

      <section className="my-2 text-black w-full">
        <div>
          <p className="text-l font-semibold mb-4 mt-10 text-left">Fazer Check-in:</p>
          <div className="flex items-center justify-around">
              <ContainedButton
                onClick={() => {}}
                width={'43vw'}
                height={'5rem'}
              >
                <FaIdCard size={24}/>
                Digitar ID da Bike
              </ContainedButton>
              <ContainedButton
                onClick={() => {}}
                width={'43vw'}
                height={'5rem'}
              >
                <FaQrcode size={24} />
                Scanear QR Code
              </ContainedButton>
            </div>
        </div>
        <div>
          <p className="text-l font-semibold mb-4 mt-10 text-left">Bikes perto de você:</p>
          <Mapa width={'100%'} height={'70vh'}/>
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
