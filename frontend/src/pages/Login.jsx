import { Link } from "react-router-dom";
import Button from "../components/Button";

function Login() {
  return (
    <div className="h-full flex flex-col relative items-center justify-center">
      <figure className="w-full flex justify-center">
        <img src="/logo-name.png" alt="logo" className="w-50" />
      </figure>
      <Link to="/home">
        <Button
          value="LOGIN"
          className="
        border p-2 w-70 rounded-md 
        bg-cyan-600 hover:bg-cyan-700 
        font-bold hover:cursor-pointer active:bg-cyan-700 "
        />
      </Link>

      <div className="text-[12px] absolute bottom-10">
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
