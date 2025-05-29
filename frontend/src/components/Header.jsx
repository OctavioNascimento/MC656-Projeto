import logo from "../assets/logo.png";

function Header({leftIcon, rightIcon}){
    return (
        <header className="w-full flex gap-2 items-center justify-around relative mt-3">
        {leftIcon? leftIcon : <div></div>}
        <img src={logo} alt="Logo"/>
        {rightIcon? rightIcon : <div></div>}
      </header>
    )
}

export default Header;