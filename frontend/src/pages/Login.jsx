import { Link } from "react-router-dom";
import ContainedButton from "../components/Button";

function Login() {
  return (
    <div className="h-screen flex flex-col relative items-center justify-center">
      <figure className="w-full flex justify-center">
        <img src="/logo-name.png" alt="logo" className="w-50" />
      </figure>
      <Link to="/home">
        <ContainedButton>LOGIN</ContainedButton>
      </Link>

      <div className="text-[12px] text-black absolute bottom-3">
        <p className="">
          Gerencie seu usuário e senha única, acessar o Portal da Senha UNICAMP{" "}
          <br />
        </p>
        <a
          href="https://www.unicamp.br/senhaunicamp/"
          className="text-blue-500 font-bold"
        >
          Autenticação Unicamp
        </a>
      </div>
    </div>
  );
}

export default Login;
