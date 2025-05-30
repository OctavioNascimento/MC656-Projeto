import logo from "../assets/logo.png";

export const headerIconsSize = 30

function Header({leftIcon, rightIcon}){
    return (
      <header className="fixed top-0 w-full pl-5 pr-5">
        <div className="w-full flex gap-2 items-center justify-between relative h-[50px]">
          {leftIcon? leftIcon : <div className="w=[30px]"></div>}
          <img src={logo} alt="Logo" className="h-[30px]"/>
          {rightIcon? rightIcon : <div className="w-[30px]"></div>}
        </div>
      </header>
        
    )
}

export default Header;